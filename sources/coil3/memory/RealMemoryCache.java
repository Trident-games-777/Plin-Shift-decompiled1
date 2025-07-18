package coil3.memory;

import coil3.memory.MemoryCache;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcoil3/memory/RealMemoryCache;", "Lcoil3/memory/MemoryCache;", "strongMemoryCache", "Lcoil3/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(Lcoil3/memory/StrongMemoryCache;Lcoil3/memory/WeakMemoryCache;)V", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "value", "remove", "", "trimToSize", "clear", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealMemoryCache.kt */
public final class RealMemoryCache implements MemoryCache {
    private final Object lock = new Object();
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache2, WeakMemoryCache weakMemoryCache2) {
        this.strongMemoryCache = strongMemoryCache2;
        this.weakMemoryCache = weakMemoryCache2;
    }

    public long getSize() {
        long size;
        synchronized (this.lock) {
            size = this.strongMemoryCache.getSize();
        }
        return size;
    }

    public long getMaxSize() {
        long maxSize;
        synchronized (this.lock) {
            maxSize = this.strongMemoryCache.getMaxSize();
        }
        return maxSize;
    }

    public Set<MemoryCache.Key> getKeys() {
        Set<MemoryCache.Key> plus;
        synchronized (this.lock) {
            plus = SetsKt.plus(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
        }
        return plus;
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value;
        synchronized (this.lock) {
            value = this.strongMemoryCache.get(key);
            if (value == null) {
                value = this.weakMemoryCache.get(key);
            }
            if (value != null && !value.getImage().getShareable()) {
                remove(key);
            }
        }
        return value;
    }

    /* JADX INFO: finally extract failed */
    public void set(MemoryCache.Key key, MemoryCache.Value value) {
        synchronized (this.lock) {
            try {
                long size = value.getImage().getSize();
                if (size >= 0) {
                    this.strongMemoryCache.set(key, value.getImage(), value.getExtras(), size);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException(("Image size must be non-negative: " + size).toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean remove(MemoryCache.Key key) {
        boolean z;
        synchronized (this.lock) {
            z = this.strongMemoryCache.remove(key) || this.weakMemoryCache.remove(key);
        }
        return z;
    }

    public void trimToSize(long j) {
        synchronized (this.lock) {
            this.strongMemoryCache.trimToSize(j);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void clear() {
        synchronized (this.lock) {
            this.strongMemoryCache.clear();
            this.weakMemoryCache.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
