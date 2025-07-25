package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final Queue<?> DISCARDING_QUEUE = new AbstractQueue<Object>() {
        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }

        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }
    };
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>() {
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @CheckForNull Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public int getWeight() {
            return 0;
        }

        public boolean isActive() {
            return false;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(Object obj) {
        }

        public Object waitForValue() {
            return null;
        }
    };
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    final int concurrencyLevel;
    @CheckForNull
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;
    @CheckForNull
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;
    @CheckForNull
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    @CheckForNull
    Collection<V> values;
    final Weigher<K, V> weigher;

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public long getAccessTime() {
            return 0;
        }

        public int getHash() {
            return 0;
        }

        public Object getKey() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        public long getWriteTime() {
            return 0;
        }

        public void setAccessTime(long j) {
        }

        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        public void setWriteTime(long j) {
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                if (i == 1) {
                    return new StrongValueReference(v);
                }
                return new WeightedStrongValueReference(v, i);
            }

            /* access modifiers changed from: package-private */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT {
            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                if (i == 1) {
                    return new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry);
                }
                return new WeightedSoftValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            /* access modifiers changed from: package-private */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                if (i == 1) {
                    return new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry);
                }
                return new WeightedWeakValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            /* access modifiers changed from: package-private */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* access modifiers changed from: package-private */
        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @CheckForNull V v, ReferenceEntry<K, V> referenceEntry);

        @CheckForNull
        V get();

        @CheckForNull
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@CheckForNull V v);

        V waitForValue() throws ExecutionException;
    }

    static int rehash(int i) {
        int i2 = i + ((i << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @CheckForNull CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> queue;
        this.concurrencyLevel = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        Strength keyStrength2 = cacheBuilder.getKeyStrength();
        this.keyStrength = keyStrength2;
        this.valueStrength = cacheBuilder.getValueStrength();
        this.keyEquivalence = cacheBuilder.getKeyEquivalence();
        this.valueEquivalence = cacheBuilder.getValueEquivalence();
        long maximumWeight = cacheBuilder.getMaximumWeight();
        this.maxWeight = maximumWeight;
        this.weigher = cacheBuilder.getWeigher();
        this.expireAfterAccessNanos = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = cacheBuilder.getRefreshNanos();
        RemovalListener<K1, V1> removalListener2 = cacheBuilder.getRemovalListener();
        this.removalListener = removalListener2;
        if (removalListener2 == CacheBuilder.NullListener.INSTANCE) {
            queue = discardingQueue();
        } else {
            queue = new ConcurrentLinkedQueue<>();
        }
        this.removalNotificationQueue = queue;
        this.ticker = cacheBuilder.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(keyStrength2, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int min = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (evictsBySize() && !customWeigher()) {
            min = (int) Math.min((long) min, maximumWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        while (i4 < this.concurrencyLevel && (!evictsBySize() || ((long) (i4 * 20)) <= this.maxWeight)) {
            i3++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i3;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i5 = min / i4;
        while (i2 < (i5 * i4 < min ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        if (evictsBySize()) {
            long j = this.maxWeight;
            long j2 = (long) i4;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (true) {
                Segment<K, V>[] segmentArr = this.segments;
                if (i < segmentArr.length) {
                    if (((long) i) == j4) {
                        j3--;
                    }
                    segmentArr[i] = createSegment(i2, j3, (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                    i++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.segments;
                if (i < segmentArr2.length) {
                    segmentArr2[i] = createSegment(i2, -1, (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    /* access modifiers changed from: package-private */
    public boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public boolean expires() {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean refreshes() {
        return this.refreshNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean usesAccessQueue() {
        return expiresAfterAccess() || evictsBySize();
    }

    /* access modifiers changed from: package-private */
    public boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsWrite() {
        return expiresAfterWrite() || refreshes();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsAccess() {
        return expiresAfterAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsTime() {
        return recordsWrite() || recordsAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean usesWriteEntries() {
        return usesWriteQueue() || recordsWrite();
    }

    /* access modifiers changed from: package-private */
    public boolean usesAccessEntries() {
        return usesAccessQueue() || recordsAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    enum EntryFactory {
        STRONG {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        
        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = null;

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry);

        static {
            AnonymousClass1 r0;
            AnonymousClass2 r1;
            AnonymousClass3 r3;
            AnonymousClass4 r5;
            AnonymousClass5 r7;
            AnonymousClass6 r9;
            AnonymousClass7 r11;
            AnonymousClass8 r13;
            factories = new EntryFactory[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            char c = 0;
            boolean z3 = (strength == Strength.WEAK ? (char) 4 : 0) | z;
            if (z2) {
                c = 2;
            }
            return factories[z3 | c];
        }

        /* access modifiers changed from: package-private */
        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.connectAccessOrder(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.connectWriteOrder(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(referenceEntry);
        }
    }

    static <K, V> ValueReference<K, V> unset() {
        return UNSET;
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;
        @CheckForNull
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        StrongEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            this.key = k;
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return this.key;
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();

        StrongAccessEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.accessTime;
        }

        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        StrongWriteEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getWriteTime() {
            return this.writeTime;
        }

        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        StrongAccessWriteEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.accessTime;
        }

        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        public long getWriteTime() {
            return this.writeTime;
        }

        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        @CheckForNull
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.accessTime;
        }

        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getWriteTime() {
            return this.writeTime;
        }

        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getAccessTime() {
            return this.accessTime;
        }

        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        public long getWriteTime() {
            return this.writeTime;
        }

        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        StrongValueReference(V v) {
            this.referent = v;
        }

        public V get() {
            return this.referent;
        }

        public V waitForValue() {
            return get();
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        WeightedStrongValueReference(V v, int i) {
            super(v);
            this.weight = i;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    /* access modifiers changed from: package-private */
    public ReferenceEntry<K, V> newEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
        Segment segmentFor = segmentFor(i);
        segmentFor.lock();
        try {
            return segmentFor.newEntry(k, i, referenceEntry);
        } finally {
            segmentFor.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return segmentFor(referenceEntry.getHash()).copyEntry(referenceEntry, referenceEntry2);
    }

    /* access modifiers changed from: package-private */
    public ValueReference<K, V> newValueReference(ReferenceEntry<K, V> referenceEntry, V v, int i) {
        return this.valueStrength.referenceValue(segmentFor(referenceEntry.getHash()), referenceEntry, Preconditions.checkNotNull(v), i);
    }

    /* access modifiers changed from: package-private */
    public int hash(@CheckForNull Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    /* access modifiers changed from: package-private */
    public void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    /* access modifiers changed from: package-private */
    public void reclaimKey(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    /* access modifiers changed from: package-private */
    public boolean isLive(ReferenceEntry<K, V> referenceEntry, long j) {
        return segmentFor(referenceEntry.getHash()).getLiveValue(referenceEntry, j) != null;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> createSegment(int i, long j, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i, j, statsCounter);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
        V v;
        if (referenceEntry.getKey() == null || (v = referenceEntry.getValueReference().get()) == null || isExpired(referenceEntry, j)) {
            return null;
        }
        return v;
    }

    /* access modifiers changed from: package-private */
    public boolean isExpired(ReferenceEntry<K, V> referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (expiresAfterAccess() && j - referenceEntry.getAccessTime() >= this.expireAfterAccessNanos) {
            return true;
        }
        if (!expiresAfterWrite() || j - referenceEntry.getWriteTime() < this.expireAfterWriteNanos) {
            return false;
        }
        return true;
    }

    static <K, V> void connectAccessOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextInAccessQueue(nullEntry);
        referenceEntry.setPreviousInAccessQueue(nullEntry);
    }

    static <K, V> void connectWriteOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextInWriteQueue(nullEntry);
        referenceEntry.setPreviousInWriteQueue(nullEntry);
    }

    /* access modifiers changed from: package-private */
    public void processPendingNotifications() {
        while (true) {
            RemovalNotification poll = this.removalNotificationQueue.poll();
            if (poll != null) {
                try {
                    this.removalListener.onRemoval(poll);
                } catch (Throwable th) {
                    logger.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V>[] newSegmentArray(int i) {
        return new Segment[i];
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        @CheckForNull
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        @CheckForNull
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        long totalWeight;
        @CheckForNull
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter2) {
            Queue<ReferenceEntry<K, V>> queue;
            Queue<ReferenceEntry<K, V>> queue2;
            Queue<ReferenceEntry<K, V>> queue3;
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter2);
            initTable(newEntryArray(i));
            ReferenceQueue<V> referenceQueue = null;
            this.keyReferenceQueue = localCache.usesKeyReferences() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue<>() : referenceQueue;
            if (localCache.usesAccessQueue()) {
                queue = new ConcurrentLinkedQueue<>();
            } else {
                queue = LocalCache.discardingQueue();
            }
            this.recencyQueue = queue;
            if (localCache.usesWriteQueue()) {
                queue2 = new WriteQueue<>();
            } else {
                queue2 = LocalCache.discardingQueue();
            }
            this.writeQueue = queue2;
            if (localCache.usesAccessQueue()) {
                queue3 = new AccessQueue<>();
            } else {
                queue3 = LocalCache.discardingQueue();
            }
            this.accessQueue = queue3;
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* access modifiers changed from: package-private */
        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.customWeigher()) {
                int i = this.threshold;
                if (((long) i) == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> newEntry(K k, int i, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(k), i, referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        /* access modifiers changed from: package-private */
        public void setValue(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.weigher.weigh(k, v);
            Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v, weigh));
            recordWrite(referenceEntry, weigh, j);
            valueReference.notifyNewValue(v);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0066 A[Catch:{ all -> 0x0079 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0071 A[Catch:{ all -> 0x0079 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V get(K r10, int r11, com.google.common.cache.CacheLoader<? super K, V> r12) throws java.util.concurrent.ExecutionException {
            /*
                r9 = this;
                com.google.common.base.Preconditions.checkNotNull(r10)
                com.google.common.base.Preconditions.checkNotNull(r12)
                int r0 = r9.count     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                if (r0 == 0) goto L_0x0049
                com.google.common.cache.ReferenceEntry r2 = r9.getEntry(r10, r11)     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                if (r2 == 0) goto L_0x0049
                com.google.common.cache.LocalCache<K, V> r0 = r9.map     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                long r6 = r0.read()     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                java.lang.Object r5 = r9.getLiveValue(r2, r6)     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                if (r5 == 0) goto L_0x0033
                r9.recordRead(r2, r6)     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                com.google.common.cache.AbstractCache$StatsCounter r0 = r9.statsCounter     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                r1 = 1
                r0.recordHits(r1)     // Catch:{ ExecutionException -> 0x005b, all -> 0x0057 }
                r1 = r9
                r3 = r10
                r4 = r11
                r8 = r12
                java.lang.Object r10 = r1.scheduleRefresh(r2, r3, r4, r5, r6, r8)     // Catch:{ ExecutionException -> 0x0055 }
                r9.postReadCleanup()
                return r10
            L_0x0033:
                r1 = r9
                r3 = r10
                r4 = r11
                r8 = r12
                com.google.common.cache.LocalCache$ValueReference r10 = r2.getValueReference()     // Catch:{ ExecutionException -> 0x0055 }
                boolean r11 = r10.isLoading()     // Catch:{ ExecutionException -> 0x0055 }
                if (r11 == 0) goto L_0x004d
                java.lang.Object r10 = r9.waitForLoadingValue(r2, r3, r10)     // Catch:{ ExecutionException -> 0x0055 }
                r9.postReadCleanup()
                return r10
            L_0x0049:
                r1 = r9
                r3 = r10
                r4 = r11
                r8 = r12
            L_0x004d:
                java.lang.Object r10 = r9.lockedGetOrLoad(r3, r4, r8)     // Catch:{ ExecutionException -> 0x0055 }
                r9.postReadCleanup()
                return r10
            L_0x0055:
                r0 = move-exception
                goto L_0x005d
            L_0x0057:
                r0 = move-exception
                r1 = r9
            L_0x0059:
                r10 = r0
                goto L_0x007b
            L_0x005b:
                r0 = move-exception
                r1 = r9
            L_0x005d:
                r10 = r0
                java.lang.Throwable r11 = r10.getCause()     // Catch:{ all -> 0x0079 }
                boolean r12 = r11 instanceof java.lang.Error     // Catch:{ all -> 0x0079 }
                if (r12 != 0) goto L_0x0071
                boolean r12 = r11 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0079 }
                if (r12 == 0) goto L_0x0070
                com.google.common.util.concurrent.UncheckedExecutionException r10 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch:{ all -> 0x0079 }
                r10.<init>((java.lang.Throwable) r11)     // Catch:{ all -> 0x0079 }
                throw r10     // Catch:{ all -> 0x0079 }
            L_0x0070:
                throw r10     // Catch:{ all -> 0x0079 }
            L_0x0071:
                com.google.common.util.concurrent.ExecutionError r10 = new com.google.common.util.concurrent.ExecutionError     // Catch:{ all -> 0x0079 }
                java.lang.Error r11 = (java.lang.Error) r11     // Catch:{ all -> 0x0079 }
                r10.<init>((java.lang.Error) r11)     // Catch:{ all -> 0x0079 }
                throw r10     // Catch:{ all -> 0x0079 }
            L_0x0079:
                r0 = move-exception
                goto L_0x0059
            L_0x007b:
                r9.postReadCleanup()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.get(java.lang.Object, int, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    ReferenceEntry liveEntry = getLiveEntry(obj, i, read);
                    if (liveEntry == null) {
                        postReadCleanup();
                        return null;
                    }
                    Object obj2 = liveEntry.getValueReference().get();
                    if (obj2 != null) {
                        recordRead(liveEntry, read);
                        V scheduleRefresh = scheduleRefresh(liveEntry, liveEntry.getKey(), i, obj2, read, this.map.defaultLoader);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                postReadCleanup();
                throw th2;
            }
        }

        /* access modifiers changed from: package-private */
        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            LoadingValueReference loadingValueReference;
            boolean z;
            ValueReference valueReference;
            V loadSync;
            K k2 = k;
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                int i3 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        z = true;
                        valueReference = null;
                        break;
                    }
                    long j = read;
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i2 || key == null || !this.map.keyEquivalence.equivalent(k2, key)) {
                        long j2 = j;
                        referenceEntry2 = referenceEntry2.getNext();
                        read = j2;
                    } else {
                        valueReference = referenceEntry2.getValueReference();
                        if (valueReference.isLoading()) {
                            z = false;
                        } else {
                            long j3 = j;
                            V v = valueReference.get();
                            if (v == null) {
                                enqueueNotification(key, i2, v, valueReference.getWeight(), RemovalCause.COLLECTED);
                                i2 = i;
                            } else if (this.map.isExpired(referenceEntry2, j3)) {
                                i2 = i;
                                enqueueNotification(key, i2, v, valueReference.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(referenceEntry2, j3);
                                this.statsCounter.recordHits(1);
                                unlock();
                                postWriteCleanup();
                                return v;
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i3;
                            z = true;
                        }
                    }
                }
                if (z) {
                    loadingValueReference = new LoadingValueReference();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k2, i2, referenceEntry);
                        referenceEntry2.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(loadingValueReference);
                    }
                }
                if (!z) {
                    return waitForLoadingValue(referenceEntry2, k2, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        loadSync = loadSync(k2, i2, loadingValueReference, cacheLoader);
                    }
                    this.statsCounter.recordMisses(1);
                    return loadSync;
                } catch (Throwable th) {
                    this.statsCounter.recordMisses(1);
                    throw th;
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.isLoading()) {
                Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", (Object) k);
                try {
                    V waitForValue = valueReference.waitForValue();
                    if (waitForValue != null) {
                        recordRead(referenceEntry, this.map.ticker.read());
                        return waitForValue;
                    }
                    String valueOf = String.valueOf(k);
                    throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(valueOf).length() + 35).append("CacheLoader returned null for key ").append(valueOf).append(".").toString());
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public V loadSync(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, loadingValueReference, loadingValueReference.loadFuture(k, cacheLoader));
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> loadAsync(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> loadFuture = loadingValueReference.loadFuture(k, cacheLoader);
            final K k2 = k;
            final int i2 = i;
            final LoadingValueReference<K, V> loadingValueReference2 = loadingValueReference;
            loadFuture.addListener(new Runnable() {
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k2, i2, loadingValueReference2, loadFuture);
                    } catch (Throwable th) {
                        LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", th);
                        loadingValueReference2.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return loadFuture;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V getAndRecordStats(K r5, int r6, com.google.common.cache.LocalCache.LoadingValueReference<K, V> r7, com.google.common.util.concurrent.ListenableFuture<V> r8) throws java.util.concurrent.ExecutionException {
            /*
                r4 = this;
                java.lang.Object r8 = com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(r8)     // Catch:{ all -> 0x0050 }
                if (r8 == 0) goto L_0x0023
                com.google.common.cache.AbstractCache$StatsCounter r0 = r4.statsCounter     // Catch:{ all -> 0x0021 }
                long r1 = r7.elapsedNanos()     // Catch:{ all -> 0x0021 }
                r0.recordLoadSuccess(r1)     // Catch:{ all -> 0x0021 }
                r4.storeLoadedValue(r5, r6, r7, r8)     // Catch:{ all -> 0x0021 }
                if (r8 != 0) goto L_0x0020
                com.google.common.cache.AbstractCache$StatsCounter r0 = r4.statsCounter
                long r1 = r7.elapsedNanos()
                r0.recordLoadException(r1)
                r4.removeLoadingValue(r5, r6, r7)
            L_0x0020:
                return r8
            L_0x0021:
                r0 = move-exception
                goto L_0x0052
            L_0x0023:
                com.google.common.cache.CacheLoader$InvalidCacheLoadException r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ all -> 0x0021 }
                java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0021 }
                java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0021 }
                int r2 = r2.length()     // Catch:{ all -> 0x0021 }
                int r2 = r2 + 35
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
                r3.<init>(r2)     // Catch:{ all -> 0x0021 }
                java.lang.String r2 = "CacheLoader returned null for key "
                java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x0021 }
                java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0021 }
                java.lang.String r2 = "."
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0021 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0021 }
                r0.<init>(r1)     // Catch:{ all -> 0x0021 }
                throw r0     // Catch:{ all -> 0x0021 }
            L_0x0050:
                r0 = move-exception
                r8 = 0
            L_0x0052:
                if (r8 != 0) goto L_0x0060
                com.google.common.cache.AbstractCache$StatsCounter r8 = r4.statsCounter
                long r1 = r7.elapsedNanos()
                r8.recordLoadException(r1)
                r4.removeLoadingValue(r5, r6, r7)
            L_0x0060:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.getAndRecordStats(java.lang.Object, int, com.google.common.cache.LocalCache$LoadingValueReference, com.google.common.util.concurrent.ListenableFuture):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            r3 = refresh(r4, r5, r9, true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V scheduleRefresh(com.google.common.cache.ReferenceEntry<K, V> r3, K r4, int r5, V r6, long r7, com.google.common.cache.CacheLoader<? super K, V> r9) {
            /*
                r2 = this;
                com.google.common.cache.LocalCache<K, V> r0 = r2.map
                boolean r0 = r0.refreshes()
                if (r0 == 0) goto L_0x0027
                long r0 = r3.getWriteTime()
                long r7 = r7 - r0
                com.google.common.cache.LocalCache<K, V> r0 = r2.map
                long r0 = r0.refreshNanos
                int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r7 <= 0) goto L_0x0027
                com.google.common.cache.LocalCache$ValueReference r3 = r3.getValueReference()
                boolean r3 = r3.isLoading()
                if (r3 != 0) goto L_0x0027
                r3 = 1
                java.lang.Object r3 = r2.refresh(r4, r5, r9, r3)
                if (r3 == 0) goto L_0x0027
                return r3
            L_0x0027:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.scheduleRefresh(com.google.common.cache.ReferenceEntry, java.lang.Object, int, java.lang.Object, long, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            LoadingValueReference insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return Uninterruptibles.getUninterruptibly(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @CheckForNull
        public LoadingValueReference<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading()) {
                            if (!z || read - referenceEntry2.getWriteTime() >= this.map.refreshNanos) {
                                this.modCount++;
                                LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                                referenceEntry2.setValueReference(loadingValueReference);
                                unlock();
                                postWriteCleanup();
                                return loadingValueReference;
                            }
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry newEntry = newEntry(k, i, referenceEntry);
                newEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((ReferenceEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((ValueReference) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        public void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public void recordRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public void recordWrite(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += (long) i;
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.recordsWrite()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void expireEntries(long j) {
            ReferenceEntry peek;
            ReferenceEntry peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.isExpired(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.isExpired(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void enqueueNotification(@CheckForNull K k, int i, @CheckForNull V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        /* access modifiers changed from: package-private */
        public void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.evictsBySize()) {
                drainRecencyQueue();
                if (((long) referenceEntry.getValueReference().getWeight()) <= this.maxSegmentWeight || removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry nextEvictable = getNextEvictable();
                        if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> getEntry(Object obj, int i) {
            for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.isExpired(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        /* access modifiers changed from: package-private */
        public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.isExpired(referenceEntry, j)) {
                return v;
            } else {
                tryExpireEntries(j);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    ReferenceEntry liveEntry = getLiveEntry(obj, i, this.map.ticker.read());
                    if (liveEntry == null) {
                        return false;
                    }
                    if (liveEntry.getValueReference().get() != null) {
                        z = true;
                    }
                    postReadCleanup();
                    return z;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            Object liveValue = getLiveValue(referenceEntry, read);
                            if (liveValue != null) {
                                if (this.map.valueEquivalence.equivalent(obj, liveValue)) {
                                    postReadCleanup();
                                    return true;
                                }
                            }
                        }
                    }
                }
                postReadCleanup();
                return false;
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
            r0 = r10.getValueReference();
            r4 = r0.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            if (r4 != null) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            r12.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
            if (r0.isActive() == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
            enqueueNotification(r13, r14, r4, r0.getWeight(), com.google.common.cache.RemovalCause.COLLECTED);
            r2 = r10;
            setValue(r2, r13, r15, r7);
            r13 = r12.count;
            r7 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
            r2 = r10;
            setValue(r2, r13, r15, r7);
            r7 = r2;
            r13 = r12.count + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
            r12.count = r13;
            evictEntries(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
            r8 = r7;
            r7 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
            if (r16 == false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            recordLockedRead(r7, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r12.modCount++;
            enqueueNotification(r13, r14, r4, r0.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            r0 = r4;
            r2 = r7;
            setValue(r2, r13, r15, r8);
            evictEntries(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
            return r0;
         */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V put(K r13, int r14, V r15, boolean r16) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch:{ all -> 0x00e6 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x00e6 }
                long r7 = r0.read()     // Catch:{ all -> 0x00e6 }
                r12.preWriteCleanup(r7)     // Catch:{ all -> 0x00e6 }
                int r0 = r12.count     // Catch:{ all -> 0x00e6 }
                int r0 = r0 + 1
                int r1 = r12.threshold     // Catch:{ all -> 0x00e6 }
                if (r0 <= r1) goto L_0x0019
                r12.expand()     // Catch:{ all -> 0x00e6 }
            L_0x0019:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch:{ all -> 0x00e6 }
                int r1 = r0.length()     // Catch:{ all -> 0x00e6 }
                int r1 = r1 + -1
                r9 = r14 & r1
                java.lang.Object r1 = r0.get(r9)     // Catch:{ all -> 0x00e6 }
                com.google.common.cache.ReferenceEntry r1 = (com.google.common.cache.ReferenceEntry) r1     // Catch:{ all -> 0x00e6 }
                r10 = r1
            L_0x002a:
                r11 = 0
                if (r10 == 0) goto L_0x00c7
                java.lang.Object r2 = r10.getKey()     // Catch:{ all -> 0x00e6 }
                int r4 = r10.getHash()     // Catch:{ all -> 0x00e6 }
                if (r4 != r14) goto L_0x00be
                if (r2 == 0) goto L_0x00be
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch:{ all -> 0x00e6 }
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.keyEquivalence     // Catch:{ all -> 0x00e6 }
                boolean r2 = r4.equivalent(r13, r2)     // Catch:{ all -> 0x00e6 }
                if (r2 == 0) goto L_0x00be
                com.google.common.cache.LocalCache$ValueReference r0 = r10.getValueReference()     // Catch:{ all -> 0x00e6 }
                java.lang.Object r4 = r0.get()     // Catch:{ all -> 0x00e6 }
                if (r4 != 0) goto L_0x008a
                int r1 = r12.modCount     // Catch:{ all -> 0x00e6 }
                int r1 = r1 + 1
                r12.modCount = r1     // Catch:{ all -> 0x00e6 }
                boolean r1 = r0.isActive()     // Catch:{ all -> 0x00e6 }
                if (r1 == 0) goto L_0x0071
                int r5 = r0.getWeight()     // Catch:{ all -> 0x00e6 }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00e6 }
                r1 = r12
                r2 = r13
                r3 = r14
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e6 }
                r1 = r12
                r3 = r13
                r4 = r15
                r5 = r7
                r2 = r10
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e6 }
                int r13 = r12.count     // Catch:{ all -> 0x00e6 }
                r7 = r2
                goto L_0x007e
            L_0x0071:
                r1 = r12
                r3 = r13
                r4 = r15
                r5 = r7
                r2 = r10
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e6 }
                r7 = r2
                int r13 = r12.count     // Catch:{ all -> 0x00e6 }
                int r13 = r13 + 1
            L_0x007e:
                r12.count = r13     // Catch:{ all -> 0x00e6 }
                r12.evictEntries(r7)     // Catch:{ all -> 0x00e6 }
            L_0x0083:
                r12.unlock()
                r12.postWriteCleanup()
                return r11
            L_0x008a:
                r8 = r7
                r7 = r10
                if (r16 == 0) goto L_0x0098
                r12.recordLockedRead(r7, r8)     // Catch:{ all -> 0x00e6 }
                r12.unlock()
                r12.postWriteCleanup()
                return r4
            L_0x0098:
                int r2 = r12.modCount     // Catch:{ all -> 0x00e6 }
                int r2 = r2 + 1
                r12.modCount = r2     // Catch:{ all -> 0x00e6 }
                int r5 = r0.getWeight()     // Catch:{ all -> 0x00e6 }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00e6 }
                r1 = r12
                r2 = r13
                r3 = r14
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e6 }
                r0 = r4
                r1 = r12
                r3 = r13
                r4 = r15
                r2 = r7
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e6 }
                r7 = r2
                r12.evictEntries(r7)     // Catch:{ all -> 0x00e6 }
                r12.unlock()
                r12.postWriteCleanup()
                return r0
            L_0x00be:
                r5 = r7
                r7 = r10
                com.google.common.cache.ReferenceEntry r10 = r7.getNext()     // Catch:{ all -> 0x00e6 }
                r7 = r5
                goto L_0x002a
            L_0x00c7:
                r5 = r7
                int r7 = r12.modCount     // Catch:{ all -> 0x00e6 }
                int r7 = r7 + 1
                r12.modCount = r7     // Catch:{ all -> 0x00e6 }
                com.google.common.cache.ReferenceEntry r1 = r12.newEntry(r13, r14, r1)     // Catch:{ all -> 0x00e6 }
                r3 = r13
                r4 = r15
                r2 = r1
                r1 = r12
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e6 }
                r0.set(r9, r2)     // Catch:{ all -> 0x00e6 }
                int r13 = r12.count     // Catch:{ all -> 0x00e6 }
                int r13 = r13 + 1
                r12.count = r13     // Catch:{ all -> 0x00e6 }
                r12.evictEntries(r2)     // Catch:{ all -> 0x00e6 }
                goto L_0x0083
            L_0x00e6:
                r0 = move-exception
                r13 = r0
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            newEntryArray.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                } else {
                                    removeCollectedEntry(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = newEntryArray;
                this.count = i;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r13 = r7;
            r7 = r5.getValueReference();
            r6 = r7.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (r6 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r7.isActive() == false) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
            r1.modCount++;
            r0.set(r10, removeValueFromChain(r2, r5, r4, r3, r6, r7, com.google.common.cache.RemovalCause.COLLECTED));
            r1.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
            r0 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            if (r1.map.valueEquivalence.equivalent(r19, r4) == false) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
            r1.modCount++;
            enqueueNotification(r12, r18, r4, r7.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            r1 = r16;
            r2 = r0;
            setValue(r2, r17, r20, r13);
            evictEntries(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x009a, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            recordLockedRead(r0, r13);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean replace(K r17, int r18, V r19, V r20) {
            /*
                r16 = this;
                r1 = r16
                r3 = r18
                r1.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r1.map     // Catch:{ all -> 0x00b7 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x00b7 }
                long r7 = r0.read()     // Catch:{ all -> 0x00b7 }
                r1.preWriteCleanup(r7)     // Catch:{ all -> 0x00b7 }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r1.table     // Catch:{ all -> 0x00b7 }
                int r2 = r0.length()     // Catch:{ all -> 0x00b7 }
                r9 = 1
                int r2 = r2 - r9
                r10 = r3 & r2
                java.lang.Object r2 = r0.get(r10)     // Catch:{ all -> 0x00b7 }
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch:{ all -> 0x00b7 }
                r4 = r2
            L_0x0023:
                r11 = 0
                if (r4 == 0) goto L_0x0066
                r5 = r4
                java.lang.Object r4 = r5.getKey()     // Catch:{ all -> 0x00b7 }
                int r6 = r5.getHash()     // Catch:{ all -> 0x00b7 }
                if (r6 != r3) goto L_0x00a6
                if (r4 == 0) goto L_0x00a6
                com.google.common.cache.LocalCache<K, V> r6 = r1.map     // Catch:{ all -> 0x00b7 }
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch:{ all -> 0x00b7 }
                r12 = r17
                boolean r6 = r6.equivalent(r12, r4)     // Catch:{ all -> 0x00b7 }
                if (r6 == 0) goto L_0x00a6
                r13 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r5.getValueReference()     // Catch:{ all -> 0x00b7 }
                java.lang.Object r6 = r7.get()     // Catch:{ all -> 0x00b7 }
                if (r6 != 0) goto L_0x006d
                boolean r8 = r7.isActive()     // Catch:{ all -> 0x00b7 }
                if (r8 == 0) goto L_0x0066
                int r8 = r1.modCount     // Catch:{ all -> 0x00b7 }
                int r8 = r8 + r9
                r1.modCount = r8     // Catch:{ all -> 0x00b7 }
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00b7 }
                r15 = r5
                r5 = r3
                r3 = r15
                com.google.common.cache.ReferenceEntry r2 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00b7 }
                int r3 = r1.count     // Catch:{ all -> 0x00b7 }
                int r3 = r3 - r9
                r0.set(r10, r2)     // Catch:{ all -> 0x00b7 }
                r1.count = r3     // Catch:{ all -> 0x00b7 }
            L_0x0066:
                r1.unlock()
                r1.postWriteCleanup()
                return r11
            L_0x006d:
                r0 = r5
                r4 = r6
                com.google.common.cache.LocalCache<K, V> r2 = r1.map     // Catch:{ all -> 0x00b7 }
                com.google.common.base.Equivalence<java.lang.Object> r2 = r2.valueEquivalence     // Catch:{ all -> 0x00b7 }
                r3 = r19
                boolean r2 = r2.equivalent(r3, r4)     // Catch:{ all -> 0x00b7 }
                if (r2 == 0) goto L_0x00a1
                int r2 = r1.modCount     // Catch:{ all -> 0x00b7 }
                int r2 = r2 + r9
                r1.modCount = r2     // Catch:{ all -> 0x00b7 }
                int r5 = r7.getWeight()     // Catch:{ all -> 0x00b7 }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00b7 }
                r3 = r18
                r2 = r12
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b7 }
                r1 = r16
                r3 = r17
                r4 = r20
                r2 = r0
                r5 = r13
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00b7 }
                r1.evictEntries(r2)     // Catch:{ all -> 0x00b7 }
                r1.unlock()
                r1.postWriteCleanup()
                return r9
            L_0x00a1:
                r2 = r0
                r1.recordLockedRead(r2, r13)     // Catch:{ all -> 0x00b7 }
                goto L_0x0066
            L_0x00a6:
                r3 = r19
                r4 = r2
                r2 = r5
                r13 = r7
                com.google.common.cache.ReferenceEntry r2 = r2.getNext()     // Catch:{ all -> 0x00b7 }
                r3 = r4
                r4 = r2
                r2 = r3
                r3 = r18
                r7 = r13
                goto L_0x0023
            L_0x00b7:
                r0 = move-exception
                r1.unlock()
                r1.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
            r11 = r7;
            r7 = r1.getValueReference();
            r6 = r7.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
            if (r6 != null) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
            if (r7.isActive() == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            r13.modCount++;
            r3 = r1;
            r0.set(r9, removeValueFromChain(r2, r3, r4, r15, r6, r7, com.google.common.cache.RemovalCause.COLLECTED));
            r13.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
            r0 = r1;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r13.modCount++;
            enqueueNotification(r14, r15, r4, r7.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            r7 = r4;
            r2 = r0;
            setValue(r2, r14, r16, r11);
            evictEntries(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
            return r7;
         */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V replace(K r14, int r15, V r16) {
            /*
                r13 = this;
                r13.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r13.map     // Catch:{ all -> 0x009c }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x009c }
                long r7 = r0.read()     // Catch:{ all -> 0x009c }
                r13.preWriteCleanup(r7)     // Catch:{ all -> 0x009c }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r13.table     // Catch:{ all -> 0x009c }
                int r1 = r0.length()     // Catch:{ all -> 0x009c }
                int r1 = r1 + -1
                r9 = r15 & r1
                java.lang.Object r1 = r0.get(r9)     // Catch:{ all -> 0x009c }
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch:{ all -> 0x009c }
                r1 = r2
            L_0x0020:
                r10 = 0
                if (r1 == 0) goto L_0x0062
                java.lang.Object r4 = r1.getKey()     // Catch:{ all -> 0x009c }
                int r5 = r1.getHash()     // Catch:{ all -> 0x009c }
                if (r5 != r15) goto L_0x0091
                if (r4 == 0) goto L_0x0091
                com.google.common.cache.LocalCache<K, V> r5 = r13.map     // Catch:{ all -> 0x009c }
                com.google.common.base.Equivalence<java.lang.Object> r5 = r5.keyEquivalence     // Catch:{ all -> 0x009c }
                boolean r5 = r5.equivalent(r14, r4)     // Catch:{ all -> 0x009c }
                if (r5 == 0) goto L_0x0091
                r11 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r1.getValueReference()     // Catch:{ all -> 0x009c }
                java.lang.Object r6 = r7.get()     // Catch:{ all -> 0x009c }
                if (r6 != 0) goto L_0x0069
                boolean r14 = r7.isActive()     // Catch:{ all -> 0x009c }
                if (r14 == 0) goto L_0x0062
                int r14 = r13.modCount     // Catch:{ all -> 0x009c }
                int r14 = r14 + 1
                r13.modCount = r14     // Catch:{ all -> 0x009c }
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x009c }
                r5 = r15
                r3 = r1
                r1 = r13
                com.google.common.cache.ReferenceEntry r14 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x009c }
                int r2 = r13.count     // Catch:{ all -> 0x009c }
                int r2 = r2 + -1
                r0.set(r9, r14)     // Catch:{ all -> 0x009c }
                r13.count = r2     // Catch:{ all -> 0x009c }
            L_0x0062:
                r13.unlock()
                r13.postWriteCleanup()
                return r10
            L_0x0069:
                r0 = r1
                r4 = r6
                int r2 = r13.modCount     // Catch:{ all -> 0x009c }
                int r2 = r2 + 1
                r13.modCount = r2     // Catch:{ all -> 0x009c }
                int r5 = r7.getWeight()     // Catch:{ all -> 0x009c }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x009c }
                r1 = r13
                r2 = r14
                r3 = r15
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x009c }
                r7 = r4
                r1 = r13
                r3 = r14
                r4 = r16
                r2 = r0
                r5 = r11
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x009c }
                r13.evictEntries(r2)     // Catch:{ all -> 0x009c }
                r13.unlock()
                r13.postWriteCleanup()
                return r7
            L_0x0091:
                r3 = r2
                r5 = r7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = r2.getNext()     // Catch:{ all -> 0x009c }
                r1 = r2
                r2 = r3
                r7 = r5
                goto L_0x0020
            L_0x009c:
                r0 = move-exception
                r14 = r0
                r13.unlock()
                r13.postWriteCleanup()
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            r9 = r5.getValueReference();
            r8 = r9.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
            if (r8 == null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r12 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
            r10 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
            r12 = r0;
            r3 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            if (r9.isActive() == false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
            r12 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
            r11.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
            r3 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r0.set(r1, removeValueFromChain(r4, r5, r6, r13, r8, r9, r10));
            r3.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
            r0 = th;
         */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch:{ all -> 0x0081 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x0081 }
                long r0 = r0.read()     // Catch:{ all -> 0x0081 }
                r11.preWriteCleanup(r0)     // Catch:{ all -> 0x0081 }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r11.table     // Catch:{ all -> 0x0081 }
                int r1 = r0.length()     // Catch:{ all -> 0x0081 }
                int r1 = r1 + -1
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0081 }
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch:{ all -> 0x0081 }
                r5 = r4
            L_0x001f:
                r2 = 0
                if (r5 == 0) goto L_0x006f
                java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x0081 }
                int r3 = r5.getHash()     // Catch:{ all -> 0x0081 }
                if (r3 != r13) goto L_0x0077
                if (r6 == 0) goto L_0x0077
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch:{ all -> 0x0081 }
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.keyEquivalence     // Catch:{ all -> 0x0081 }
                boolean r3 = r3.equivalent(r12, r6)     // Catch:{ all -> 0x0081 }
                if (r3 == 0) goto L_0x0077
                com.google.common.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch:{ all -> 0x0081 }
                java.lang.Object r8 = r9.get()     // Catch:{ all -> 0x0081 }
                if (r8 == 0) goto L_0x004a
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch:{ all -> 0x0046 }
            L_0x0044:
                r10 = r12
                goto L_0x0053
            L_0x0046:
                r0 = move-exception
                r12 = r0
                r3 = r11
                goto L_0x0084
            L_0x004a:
                boolean r12 = r9.isActive()     // Catch:{ all -> 0x0081 }
                if (r12 == 0) goto L_0x006f
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x0081 }
                goto L_0x0044
            L_0x0053:
                int r12 = r11.modCount     // Catch:{ all -> 0x0081 }
                int r12 = r12 + 1
                r11.modCount = r12     // Catch:{ all -> 0x0081 }
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r12 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x007f }
                int r13 = r3.count     // Catch:{ all -> 0x007f }
                int r13 = r13 + -1
                r0.set(r1, r12)     // Catch:{ all -> 0x007f }
                r3.count = r13     // Catch:{ all -> 0x007f }
                r11.unlock()
                r11.postWriteCleanup()
                return r8
            L_0x006f:
                r3 = r11
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L_0x0077:
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r5 = r5.getNext()     // Catch:{ all -> 0x007f }
                r13 = r7
                goto L_0x001f
            L_0x007f:
                r0 = move-exception
                goto L_0x0083
            L_0x0081:
                r0 = move-exception
                r3 = r11
            L_0x0083:
                r12 = r0
            L_0x0084:
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (r12.map.valueEquivalence.equivalent(r15, r9) == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
            r11 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
            r13 = r0;
            r4 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
            if (r9 != null) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
            if (r10.isActive() == false) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
            r12.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
            r4 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r0.set(r1, removeValueFromChain(r5, r6, r7, r14, r9, r10, r11));
            r4.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r11 != com.google.common.cache.RemovalCause.EXPLICIT) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
            r0 = th;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch:{ all -> 0x0090 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x0090 }
                long r0 = r0.read()     // Catch:{ all -> 0x0090 }
                r12.preWriteCleanup(r0)     // Catch:{ all -> 0x0090 }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch:{ all -> 0x0090 }
                int r1 = r0.length()     // Catch:{ all -> 0x0090 }
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch:{ all -> 0x0090 }
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch:{ all -> 0x0090 }
                r6 = r5
            L_0x001f:
                r3 = 0
                if (r6 == 0) goto L_0x008e
                java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x0090 }
                int r4 = r6.getHash()     // Catch:{ all -> 0x0090 }
                if (r4 != r14) goto L_0x0084
                if (r7 == 0) goto L_0x0084
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch:{ all -> 0x0090 }
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.keyEquivalence     // Catch:{ all -> 0x0090 }
                boolean r4 = r4.equivalent(r13, r7)     // Catch:{ all -> 0x0090 }
                if (r4 == 0) goto L_0x0084
                com.google.common.cache.LocalCache$ValueReference r10 = r6.getValueReference()     // Catch:{ all -> 0x0090 }
                java.lang.Object r9 = r10.get()     // Catch:{ all -> 0x0090 }
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch:{ all -> 0x0090 }
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.valueEquivalence     // Catch:{ all -> 0x0090 }
                boolean r13 = r13.equivalent(r15, r9)     // Catch:{ all -> 0x0090 }
                if (r13 == 0) goto L_0x0052
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch:{ all -> 0x004e }
            L_0x004c:
                r11 = r13
                goto L_0x005d
            L_0x004e:
                r0 = move-exception
                r13 = r0
                r4 = r12
                goto L_0x0093
            L_0x0052:
                if (r9 != 0) goto L_0x008e
                boolean r13 = r10.isActive()     // Catch:{ all -> 0x0090 }
                if (r13 == 0) goto L_0x008e
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x0090 }
                goto L_0x004c
            L_0x005d:
                int r13 = r12.modCount     // Catch:{ all -> 0x0090 }
                int r13 = r13 + r2
                r12.modCount = r13     // Catch:{ all -> 0x0090 }
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r13 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x008c }
                int r14 = r4.count     // Catch:{ all -> 0x008c }
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch:{ all -> 0x008c }
                r4.count = r14     // Catch:{ all -> 0x008c }
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch:{ all -> 0x008c }
                if (r11 != r13) goto L_0x0075
                goto L_0x0076
            L_0x0075:
                r2 = r3
            L_0x0076:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L_0x007d:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L_0x0084:
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch:{ all -> 0x008c }
                r14 = r8
                goto L_0x001f
            L_0x008c:
                r0 = move-exception
                goto L_0x0092
            L_0x008e:
                r4 = r12
                goto L_0x007d
            L_0x0090:
                r0 = move-exception
                r4 = r12
            L_0x0092:
                r13 = r0
            L_0x0093:
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
            r4 = r12.getValueReference();
            r5 = r4.get();
            r6 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r6 == r4) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
            if (r5 != null) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
            if (r4 == com.google.common.cache.LocalCache.UNSET) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
            enqueueNotification(r14, r15, r17, 0, com.google.common.cache.RemovalCause.REPLACED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r13.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
            if (r6.isActive() == false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
            if (r5 != null) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
            r2 = com.google.common.cache.RemovalCause.REPLACED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
            enqueueNotification(r14, r15, r5, r6.getWeight(), r2);
            r0 = r0 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
            r2 = r12;
            setValue(r2, r14, r17, r7);
            r13.count = r0;
            evictEntries(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean storeLoadedValue(K r14, int r15, com.google.common.cache.LocalCache.LoadingValueReference<K, V> r16, V r17) {
            /*
                r13 = this;
                r13.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r13.map     // Catch:{ all -> 0x00c1 }
                com.google.common.base.Ticker r0 = r0.ticker     // Catch:{ all -> 0x00c1 }
                long r7 = r0.read()     // Catch:{ all -> 0x00c1 }
                r13.preWriteCleanup(r7)     // Catch:{ all -> 0x00c1 }
                int r0 = r13.count     // Catch:{ all -> 0x00c1 }
                r9 = 1
                int r0 = r0 + r9
                int r4 = r13.threshold     // Catch:{ all -> 0x00c1 }
                if (r0 <= r4) goto L_0x001c
                r13.expand()     // Catch:{ all -> 0x00c1 }
                int r0 = r13.count     // Catch:{ all -> 0x00c1 }
                int r0 = r0 + r9
            L_0x001c:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r13.table     // Catch:{ all -> 0x00c1 }
                int r4 = r10.length()     // Catch:{ all -> 0x00c1 }
                int r4 = r4 - r9
                r11 = r15 & r4
                java.lang.Object r4 = r10.get(r11)     // Catch:{ all -> 0x00c1 }
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch:{ all -> 0x00c1 }
                r12 = r4
            L_0x002c:
                if (r12 == 0) goto L_0x00a7
                java.lang.Object r5 = r12.getKey()     // Catch:{ all -> 0x00c1 }
                int r6 = r12.getHash()     // Catch:{ all -> 0x00c1 }
                if (r6 != r15) goto L_0x009f
                if (r5 == 0) goto L_0x009f
                com.google.common.cache.LocalCache<K, V> r6 = r13.map     // Catch:{ all -> 0x00c1 }
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch:{ all -> 0x00c1 }
                boolean r5 = r6.equivalent(r14, r5)     // Catch:{ all -> 0x00c1 }
                if (r5 == 0) goto L_0x009f
                com.google.common.cache.LocalCache$ValueReference r4 = r12.getValueReference()     // Catch:{ all -> 0x00c1 }
                java.lang.Object r5 = r4.get()     // Catch:{ all -> 0x00c1 }
                r6 = r16
                if (r6 == r4) goto L_0x006a
                if (r5 != 0) goto L_0x0057
                com.google.common.cache.LocalCache$ValueReference<java.lang.Object, java.lang.Object> r10 = com.google.common.cache.LocalCache.UNSET     // Catch:{ all -> 0x00c1 }
                if (r4 == r10) goto L_0x0057
                goto L_0x006a
            L_0x0057:
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00c1 }
                r5 = 0
                r1 = r13
                r2 = r14
                r3 = r15
                r4 = r17
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00c1 }
                r13.unlock()
                r13.postWriteCleanup()
                r0 = 0
                return r0
            L_0x006a:
                int r2 = r13.modCount     // Catch:{ all -> 0x00c1 }
                int r2 = r2 + r9
                r13.modCount = r2     // Catch:{ all -> 0x00c1 }
                boolean r2 = r6.isActive()     // Catch:{ all -> 0x00c1 }
                if (r2 == 0) goto L_0x008a
                if (r5 != 0) goto L_0x007a
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00c1 }
                goto L_0x007c
            L_0x007a:
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00c1 }
            L_0x007c:
                r4 = r5
                int r5 = r6.getWeight()     // Catch:{ all -> 0x00c1 }
                r1 = r13
                r3 = r15
                r6 = r2
                r2 = r14
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00c1 }
                int r0 = r0 + -1
            L_0x008a:
                r1 = r13
                r3 = r14
                r4 = r17
                r5 = r7
                r2 = r12
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00c1 }
                r13.count = r0     // Catch:{ all -> 0x00c1 }
                r13.evictEntries(r2)     // Catch:{ all -> 0x00c1 }
            L_0x0098:
                r13.unlock()
                r13.postWriteCleanup()
                return r9
            L_0x009f:
                r6 = r16
                r2 = r12
                com.google.common.cache.ReferenceEntry r12 = r2.getNext()     // Catch:{ all -> 0x00c1 }
                goto L_0x002c
            L_0x00a7:
                int r2 = r13.modCount     // Catch:{ all -> 0x00c1 }
                int r2 = r2 + r9
                r13.modCount = r2     // Catch:{ all -> 0x00c1 }
                com.google.common.cache.ReferenceEntry r2 = r13.newEntry(r14, r15, r4)     // Catch:{ all -> 0x00c1 }
                r1 = r13
                r3 = r14
                r4 = r17
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00c1 }
                r10.set(r11, r2)     // Catch:{ all -> 0x00c1 }
                r13.count = r0     // Catch:{ all -> 0x00c1 }
                r13.evictEntries(r2)     // Catch:{ all -> 0x00c1 }
                goto L_0x0098
            L_0x00c1:
                r0 = move-exception
                r13.unlock()
                r13.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.storeLoadedValue(java.lang.Object, int, com.google.common.cache.LocalCache$LoadingValueReference, java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.ticker.read());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                Object key = referenceEntry.getKey();
                                Object obj = referenceEntry.getValueReference().get();
                                if (key != null) {
                                    if (obj != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                try {
                                    enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                                } catch (Throwable th) {
                                    th = th;
                                    unlock();
                                    postWriteCleanup();
                                    throw th;
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, (Object) null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                    postWriteCleanup();
                } catch (Throwable th2) {
                    th = th2;
                    unlock();
                    postWriteCleanup();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @CheckForNull K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        /* access modifiers changed from: package-private */
        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry3 = referenceEntry2;
                while (referenceEntry3 != null) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        try {
                            atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                            this.count--;
                            unlock();
                            postWriteCleanup();
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            unlock();
                            postWriteCleanup();
                            throw th2;
                        }
                    } else {
                        int i2 = i;
                        referenceEntry3 = referenceEntry3.getNext();
                        i = i2;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                unlock();
                postWriteCleanup();
                throw th22;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean reclaimValue(K r13, int r14, com.google.common.cache.LocalCache.ValueReference<K, V> r15) {
            /*
                r12 = this;
                r12.lock()
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch:{ all -> 0x0082 }
                int r1 = r0.length()     // Catch:{ all -> 0x0082 }
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch:{ all -> 0x0082 }
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch:{ all -> 0x0082 }
                r6 = r5
            L_0x0014:
                r3 = 0
                if (r6 == 0) goto L_0x0074
                java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x0082 }
                int r4 = r6.getHash()     // Catch:{ all -> 0x0082 }
                if (r4 != r14) goto L_0x0068
                if (r7 == 0) goto L_0x0068
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch:{ all -> 0x0082 }
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.keyEquivalence     // Catch:{ all -> 0x0082 }
                boolean r4 = r4.equivalent(r13, r7)     // Catch:{ all -> 0x0082 }
                if (r4 == 0) goto L_0x0068
                com.google.common.cache.LocalCache$ValueReference r13 = r6.getValueReference()     // Catch:{ all -> 0x0082 }
                if (r13 != r15) goto L_0x005a
                int r13 = r12.modCount     // Catch:{ all -> 0x0082 }
                int r13 = r13 + r2
                r12.modCount = r13     // Catch:{ all -> 0x0082 }
                java.lang.Object r9 = r15.get()     // Catch:{ all -> 0x0082 }
                com.google.common.cache.RemovalCause r11 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x0082 }
                r4 = r12
                r8 = r14
                r10 = r15
                com.google.common.cache.ReferenceEntry r13 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0072 }
                int r14 = r4.count     // Catch:{ all -> 0x0072 }
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch:{ all -> 0x0072 }
                r4.count = r14     // Catch:{ all -> 0x0072 }
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L_0x0059
                r12.postWriteCleanup()
            L_0x0059:
                return r2
            L_0x005a:
                r4 = r12
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L_0x0067
                r12.postWriteCleanup()
            L_0x0067:
                return r3
            L_0x0068:
                r4 = r12
                r8 = r14
                r10 = r15
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch:{ all -> 0x0072 }
                r14 = r8
                r15 = r10
                goto L_0x0014
            L_0x0072:
                r0 = move-exception
                goto L_0x0084
            L_0x0074:
                r4 = r12
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L_0x0081
                r12.postWriteCleanup()
            L_0x0081:
                return r3
            L_0x0082:
                r0 = move-exception
                r4 = r12
            L_0x0084:
                r13 = r0
                r12.unlock()
                boolean r14 = r12.isHeldByCurrentThread()
                if (r14 != 0) goto L_0x0091
                r12.postWriteCleanup()
            L_0x0091:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.reclaimValue(java.lang.Object, int, com.google.common.cache.LocalCache$ValueReference):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean removeLoadingValue(K k, int i, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntry2.setValueReference(loadingValueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
                int i2 = i;
                RemovalCause removalCause2 = removalCause;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        /* access modifiers changed from: package-private */
        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        /* access modifiers changed from: package-private */
        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @CheckForNull V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = valueReference;
        }

        public boolean isActive() {
            return this.oldValue.isActive();
        }

        public int getWeight() {
            return this.oldValue.getWeight();
        }

        public boolean set(@CheckForNull V v) {
            return this.futureValue.set(v);
        }

        public boolean setException(Throwable th) {
            return this.futureValue.setException(th);
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        public void notifyNewValue(@CheckForNull V v) {
            if (v != null) {
                set(v);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        public ListenableFuture<V> loadFuture(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.stopwatch.start();
                V v = this.oldValue.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return set(load) ? this.futureValue : Futures.immediateFuture(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return Futures.immediateFuture(null);
                }
                return Futures.transform(reload, new Function<V, V>() {
                    public V apply(V v) {
                        LoadingValueReference.this.set(v);
                        return v;
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture<V> fullyFailedFuture = setException(th) ? this.futureValue : fullyFailedFuture(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return fullyFailedFuture;
            }
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        public V waitForValue() throws ExecutionException {
            return Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        public V get() {
            return this.oldValue.get();
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(this) {
            ReferenceEntry<K, V> nextWrite = this;
            ReferenceEntry<K, V> previousWrite = this;

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setWriteTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.nextWrite;
            }

            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextWrite = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousWrite = referenceEntry;
            }
        };

        WriteQueue() {
        }

        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.connectWriteOrder(referenceEntry, this.head);
            return true;
        }

        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            return nextInWriteQueue;
        }

        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
            LocalCache.nullifyWriteOrder(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(this) {
            ReferenceEntry<K, V> nextAccess = this;
            ReferenceEntry<K, V> previousAccess = this;

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public void setAccessTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.nextAccess;
            }

            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextAccess = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousAccess = referenceEntry;
            }
        };

        AccessQueue() {
        }

        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.connectAccessOrder(referenceEntry, this.head);
            return true;
        }

        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            return nextInAccessQueue;
        }

        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
            LocalCache.nullifyAccessOrder(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }
    }

    public void cleanUp() {
        for (Segment<K, V> cleanUp : this.segments) {
            cleanUp.cleanUp();
        }
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j -= (long) segmentArr[i2].modCount;
        }
        if (j == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long longSize() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (Segment<K, V> segment : segmentArr) {
            j += (long) Math.max(0, segment.count);
        }
        return j;
    }

    public int size() {
        return Ints.saturatedCast(longSize());
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public V get(K k, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int hash = hash(Preconditions.checkNotNull(k));
        return segmentFor(hash).get(k, hash, cacheLoader);
    }

    @CheckForNull
    public V getIfPresent(Object obj) {
        int hash = hash(Preconditions.checkNotNull(obj));
        V v = segmentFor(hash).get(obj, hash);
        if (v == null) {
            this.globalStatsCounter.recordMisses(1);
            return v;
        }
        this.globalStatsCounter.recordHits(1);
        return v;
    }

    @CheckForNull
    public V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    /* access modifiers changed from: package-private */
    public V getOrLoad(K k) throws ExecutionException {
        return get(k, this.defaultLoader);
    }

    /* access modifiers changed from: package-private */
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        int i2 = 0;
        for (Object next : iterable) {
            Object obj = get(next);
            if (obj == null) {
                i2++;
            } else {
                builder.put(next, obj);
                i++;
            }
        }
        this.globalStatsCounter.recordHits(i);
        this.globalStatsCounter.recordMisses(i2);
        return builder.buildKeepingLast();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|(2:25|23)|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r8 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (r8.hasNext() != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r1 = r8.next();
        r3 = r3 - 1;
        r0.put(r1, get(r1, r7.defaultLoader));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> r8) throws java.util.concurrent.ExecutionException {
        /*
            r7 = this;
            java.util.LinkedHashMap r0 = com.google.common.collect.Maps.newLinkedHashMap()
            java.util.LinkedHashSet r1 = com.google.common.collect.Sets.newLinkedHashSet()
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = r2
        L_0x000e:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0030
            java.lang.Object r4 = r8.next()
            java.lang.Object r5 = r7.get(r4)
            boolean r6 = r0.containsKey(r4)
            if (r6 != 0) goto L_0x000e
            r0.put(r4, r5)
            if (r5 != 0) goto L_0x002d
            int r3 = r3 + 1
            r1.add(r4)
            goto L_0x000e
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0030:
            boolean r8 = r1.isEmpty()     // Catch:{ all -> 0x00a8 }
            if (r8 != 0) goto L_0x0099
            java.util.Set r8 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            com.google.common.cache.CacheLoader<? super K, V> r4 = r7.defaultLoader     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.util.Map r8 = r7.loadAll(r8, r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.util.Iterator r4 = r1.iterator()     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
        L_0x0044:
            boolean r5 = r4.hasNext()     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            if (r5 == 0) goto L_0x0099
            java.lang.Object r5 = r4.next()     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.Object r6 = r8.get(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            if (r6 == 0) goto L_0x0058
            r0.put(r5, r6)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            goto L_0x0044
        L_0x0058:
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r8 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            int r5 = r5.length()     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            int r5 = r5 + 37
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            r6.<init>(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.String r5 = "loadAll failed to return a value for "
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            r8.<init>(r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
            throw r8     // Catch:{ UnsupportedLoadingOperationException -> 0x007f }
        L_0x007f:
            java.util.Iterator r8 = r1.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x0083:
            boolean r1 = r8.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0099
            java.lang.Object r1 = r8.next()     // Catch:{ all -> 0x00a8 }
            int r3 = r3 + -1
            com.google.common.cache.CacheLoader<? super K, V> r4 = r7.defaultLoader     // Catch:{ all -> 0x00a8 }
            java.lang.Object r4 = r7.get(r1, r4)     // Catch:{ all -> 0x00a8 }
            r0.put(r1, r4)     // Catch:{ all -> 0x00a8 }
            goto L_0x0083
        L_0x0099:
            com.google.common.collect.ImmutableMap r8 = com.google.common.collect.ImmutableMap.copyOf(r0)     // Catch:{ all -> 0x00a8 }
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.globalStatsCounter
            r0.recordHits(r2)
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.globalStatsCounter
            r0.recordMisses(r3)
            return r8
        L_0x00a8:
            r8 = move-exception
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.globalStatsCounter
            r0.recordHits(r2)
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.globalStatsCounter
            r0.recordMisses(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.getAll(java.lang.Iterable):com.google.common.collect.ImmutableMap");
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Map<K, V> loadAll(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        Stopwatch createStarted = Stopwatch.createStarted();
        boolean z = true;
        boolean z2 = false;
        try {
            Map<? super K, V> loadAll = cacheLoader.loadAll(set);
            if (loadAll != null) {
                createStarted.stop();
                for (Map.Entry next : loadAll.entrySet()) {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    if (key == null || value == null) {
                        z2 = true;
                    } else {
                        put(key, value);
                    }
                }
                if (!z2) {
                    this.globalStatsCounter.recordLoadSuccess(createStarted.elapsed(TimeUnit.NANOSECONDS));
                    return loadAll;
                }
                this.globalStatsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
                String valueOf = String.valueOf(cacheLoader);
                throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(valueOf).length() + 42).append(valueOf).append(" returned null keys or values from loadAll").toString());
            }
            this.globalStatsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
            String valueOf2 = String.valueOf(cacheLoader);
            throw new CacheLoader.InvalidCacheLoadException(new StringBuilder(String.valueOf(valueOf2).length() + 31).append(valueOf2).append(" returned null map from loadAll").toString());
        } catch (CacheLoader.UnsupportedLoadingOperationException e) {
            throw e;
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(e2);
        } catch (RuntimeException e3) {
            throw new UncheckedExecutionException((Throwable) e3);
        } catch (Exception e4) {
            throw new ExecutionException(e4);
        } catch (Error e5) {
            throw new ExecutionError(e5);
        } catch (Throwable th) {
            th = th;
        }
        if (!z) {
            this.globalStatsCounter.recordLoadException(createStarted.elapsed(TimeUnit.NANOSECONDS));
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public ReferenceEntry<K, V> getEntry(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public void refresh(K k) {
        int hash = hash(Preconditions.checkNotNull(k));
        segmentFor(hash).refresh(k, hash, this.defaultLoader, false);
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        Object obj2 = obj;
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        long read = this.ticker.read();
        Segment<K, V>[] segmentArr = this.segments;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            int i2 = z;
            while (i2 < length) {
                Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                int i4 = z;
                boolean z2 = i4;
                while (i4 < atomicReferenceArray.length()) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i4);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, read);
                        ReferenceEntry referenceEntry2 = referenceEntry;
                        if (liveValue != null && this.valueEquivalence.equivalent(obj2, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry2.getNext();
                        segmentArr = segmentArr2;
                    }
                    Segment<K, V>[] segmentArr3 = segmentArr;
                    i4++;
                }
                Segment<K, V>[] segmentArr4 = segmentArr;
                j2 += (long) segment.modCount;
                i2++;
                z = z2;
            }
            boolean z3 = z;
            Segment<K, V>[] segmentArr5 = segmentArr;
            if (j2 == j) {
                return z3;
            }
            i++;
            j = j2;
            z = z3;
            segmentArr = segmentArr5;
        }
        return z;
    }

    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    public boolean replace(K k, @CheckForNull V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v, v2);
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v);
    }

    public void clear() {
        for (Segment<K, V> clear : this.segments) {
            clear.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateAll(Iterable<?> iterable) {
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values2 = new Values();
        this.values = values2;
        return values2;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    abstract class HashIterator<T> implements Iterator<T> {
        @CheckForNull
        Segment<K, V> currentSegment;
        @CheckForNull
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        @CheckForNull
        LocalCache<K, V>.WriteThroughEntry lastReturned;
        @CheckForNull
        ReferenceEntry<K, V> nextEntry;
        @CheckForNull
        LocalCache<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        public abstract T next();

        HashIterator() {
            this.nextSegmentIndex = LocalCache.this.segments.length - 1;
            advance();
        }

        /* access modifiers changed from: package-private */
        public final void advance() {
            this.nextExternal = null;
            if (!nextInChain() && !nextInTable()) {
                while (this.nextSegmentIndex >= 0) {
                    Segment<K, V>[] segmentArr = LocalCache.this.segments;
                    int i = this.nextSegmentIndex;
                    this.nextSegmentIndex = i - 1;
                    Segment<K, V> segment = segmentArr[i];
                    this.currentSegment = segment;
                    if (segment.count != 0) {
                        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentSegment.table;
                        this.currentTable = atomicReferenceArray;
                        this.nextTableIndex = atomicReferenceArray.length() - 1;
                        if (nextInTable()) {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean nextInChain() {
            ReferenceEntry<K, V> referenceEntry = this.nextEntry;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.nextEntry = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.nextEntry;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (advanceTo(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean nextInTable() {
            while (true) {
                int i = this.nextTableIndex;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(referenceEntry) || nextInChain())) {
                    return true;
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public boolean advanceTo(ReferenceEntry<K, V> referenceEntry) {
            try {
                long read = LocalCache.this.ticker.read();
                K key = referenceEntry.getKey();
                V liveValue = LocalCache.this.getLiveValue(referenceEntry, read);
                if (liveValue != null) {
                    this.nextExternal = new WriteThroughEntry(key, liveValue);
                    this.currentSegment.postReadCleanup();
                    return true;
                }
                this.currentSegment.postReadCleanup();
                return false;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
            }
        }

        public boolean hasNext() {
            return this.nextExternal != null;
        }

        /* access modifiers changed from: package-private */
        public LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry != null) {
                this.lastReturned = writeThroughEntry;
                advance();
                return this.lastReturned;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache localCache) {
            super();
        }

        public K next() {
            return nextEntry().getKey();
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache localCache) {
            super();
        }

        public V next() {
            return nextEntry().getValue();
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!this.key.equals(entry.getKey()) || !this.value.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public V setValue(V v) {
            V put = LocalCache.this.put(this.key, v);
            this.value = v;
            return put;
        }

        public String toString() {
            String valueOf = String.valueOf(getKey());
            String valueOf2 = String.valueOf(getValue());
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        }
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache localCache) {
            super();
        }

        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        AbstractCacheSet() {
        }

        public int size() {
            return LocalCache.this.size();
        }

        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        public void clear() {
            LocalCache.this.clear();
        }

        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet() {
            super();
        }

        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public int size() {
            return LocalCache.this.size();
        }

        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        public void clear() {
            LocalCache.this.clear();
        }

        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean contains(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x000f
                return r1
            L_0x000f:
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                java.lang.Object r0 = r2.get(r0)
                if (r0 == 0) goto L_0x0027
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                com.google.common.base.Equivalence<java.lang.Object> r2 = r2.valueEquivalence
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.equivalent(r4, r0)
                if (r4 == 0) goto L_0x0027
                r4 = 1
                return r4
            L_0x0027:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.EntrySet.contains(java.lang.Object):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 == 0) goto L_0x001c
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.remove(r0, r4)
                if (r4 == 0) goto L_0x001c
                r4 = 1
                return r4
            L_0x001c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.EntrySet.remove(java.lang.Object):boolean");
        }
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        @CheckForNull
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        @CheckForNull
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ManualSerializationProxy(com.google.common.cache.LocalCache<K, V> r17) {
            /*
                r16 = this;
                r0 = r17
                com.google.common.cache.LocalCache$Strength r1 = r0.keyStrength
                com.google.common.cache.LocalCache$Strength r2 = r0.valueStrength
                com.google.common.base.Equivalence<java.lang.Object> r3 = r0.keyEquivalence
                com.google.common.base.Equivalence<java.lang.Object> r4 = r0.valueEquivalence
                long r5 = r0.expireAfterWriteNanos
                long r7 = r0.expireAfterAccessNanos
                long r9 = r0.maxWeight
                com.google.common.cache.Weigher<K, V> r11 = r0.weigher
                int r12 = r0.concurrencyLevel
                com.google.common.cache.RemovalListener<K, V> r13 = r0.removalListener
                com.google.common.base.Ticker r14 = r0.ticker
                com.google.common.cache.CacheLoader<? super K, V> r15 = r0.defaultLoader
                r0 = r16
                r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.ManualSerializationProxy.<init>(com.google.common.cache.LocalCache):void");
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher2, int i, RemovalListener<? super K, ? super V> removalListener2, Ticker ticker2, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher2;
            this.concurrencyLevel = i;
            this.removalListener = removalListener2;
            this.ticker = (ticker2 == Ticker.systemTicker() || ticker2 == CacheBuilder.NULL_TICKER) ? null : ticker2;
            this.loader = cacheLoader;
        }

        /* access modifiers changed from: package-private */
        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K1, V1> removalListener2 = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            removalListener2.strictParsing = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                removalListener2.expireAfterWrite(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                removalListener2.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
            }
            if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
                removalListener2.weigher(this.weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    removalListener2.maximumWeight(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    removalListener2.maximumSize(j4);
                }
            }
            Ticker ticker2 = this.ticker;
            if (ticker2 != null) {
                removalListener2.ticker(ticker2);
            }
            return removalListener2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* access modifiers changed from: protected */
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        @CheckForNull
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = recreateCacheBuilder().build(this.loader);
        }

        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, (CacheLoader) null));
        }

        private LocalManualCache(LocalCache<K, V> localCache2) {
            this.localCache = localCache2;
        }

        @CheckForNull
        public V getIfPresent(Object obj) {
            return this.localCache.getIfPresent(obj);
        }

        public V get(K k, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.checkNotNull(callable);
            return this.localCache.get(k, new CacheLoader<Object, V>(this) {
                public V load(Object obj) throws Exception {
                    return callable.call();
                }
            });
        }

        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.getAllPresent(iterable);
        }

        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.invalidateAll(iterable);
        }

        public void invalidateAll() {
            this.localCache.clear();
        }

        public long size() {
            return this.localCache.longSize();
        }

        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
            for (Segment<K, V> segment : this.localCache.segments) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        public void cleanUp() {
            this.localCache.cleanUp();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        public V get(K k) throws ExecutionException {
            return this.localCache.getOrLoad(k);
        }

        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.getAll(iterable);
        }

        public void refresh(K k) {
            this.localCache.refresh(k);
        }

        public final V apply(K k) {
            return getUnchecked(k);
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }
}
