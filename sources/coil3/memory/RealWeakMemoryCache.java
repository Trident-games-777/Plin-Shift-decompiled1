package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\r\u0010$\u001a\u00020\u0017H\u0000¢\u0006\u0002\b%RP\u0010\u0004\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lcoil3/memory/RealWeakMemoryCache;", "Lcoil3/memory/WeakMemoryCache;", "<init>", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lcoil3/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil3/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "getCache$coil_core_release", "()Ljava/util/LinkedHashMap;", "operationsSinceCleanUp", "", "keys", "", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "image", "Lcoil3/Image;", "extras", "", "", "", "size", "", "remove", "", "clear", "cleanUpIfNecessary", "cleanUp", "cleanUp$coil_core_release", "InternalValue", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WeakMemoryCache.kt */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;

    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_core_release() {
        return this.cache;
    }

    public Set<MemoryCache.Key> getKeys() {
        return CollectionsKt.toSet(this.cache.keySet());
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        ArrayList arrayList = this.cache.get(key);
        MemoryCache.Value value = null;
        if (arrayList == null) {
            return null;
        }
        List list = arrayList;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            InternalValue internalValue = (InternalValue) list.get(i);
            Image image = (Image) internalValue.getImage().get();
            MemoryCache.Value value2 = image != null ? new MemoryCache.Value(image, internalValue.getExtras()) : null;
            if (value2 != null) {
                value = value2;
                break;
            }
            i++;
        }
        cleanUpIfNecessary();
        return value;
    }

    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long j) {
        Map map2 = this.cache;
        Object obj = map2.get(key);
        if (obj == null) {
            obj = new ArrayList();
            map2.put(key, obj);
        }
        ArrayList arrayList = (ArrayList) obj;
        InternalValue internalValue = new InternalValue(new WeakReference(image), map, j);
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                InternalValue internalValue2 = (InternalValue) arrayList.get(i);
                if (j < internalValue2.getSize()) {
                    i++;
                } else if (internalValue2.getImage().get() == image) {
                    arrayList.set(i, internalValue);
                } else {
                    arrayList.add(i, internalValue);
                }
            }
        } else {
            arrayList.add(internalValue);
        }
        cleanUpIfNecessary();
    }

    public boolean remove(MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    public void clear() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_core_release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r2 = r2.getImage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cleanUp$coil_core_release() {
        /*
            r9 = this;
            r0 = 0
            r9.operationsSinceCleanUp = r0
            java.util.LinkedHashMap<coil3.memory.MemoryCache$Key, java.util.ArrayList<coil3.memory.RealWeakMemoryCache$InternalValue>> r1 = r9.cache
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0070
            java.lang.Object r2 = r1.next()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r3 = r2.size()
            r4 = 1
            if (r3 > r4) goto L_0x003e
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            coil3.memory.RealWeakMemoryCache$InternalValue r2 = (coil3.memory.RealWeakMemoryCache.InternalValue) r2
            if (r2 == 0) goto L_0x0037
            java.lang.ref.WeakReference r2 = r2.getImage()
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r2.get()
            coil3.Image r2 = (coil3.Image) r2
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            if (r2 != 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x003e:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = r0
            r6 = r5
        L_0x004a:
            if (r5 >= r4) goto L_0x0066
            int r7 = r5 - r6
            java.lang.Object r8 = r3.get(r7)
            coil3.memory.RealWeakMemoryCache$InternalValue r8 = (coil3.memory.RealWeakMemoryCache.InternalValue) r8
            java.lang.ref.WeakReference r8 = r8.getImage()
            java.lang.Object r8 = r8.get()
            if (r8 != 0) goto L_0x0063
            r3.remove(r7)
            int r6 = r6 + 1
        L_0x0063:
            int r5 = r5 + 1
            goto L_0x004a
        L_0x0066:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.memory.RealWeakMemoryCache.cleanUp$coil_core_release():void");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcoil3/memory/RealWeakMemoryCache$InternalValue;", "", "image", "Ljava/lang/ref/WeakReference;", "Lcoil3/Image;", "Lcoil3/util/WeakReference;", "extras", "", "", "size", "", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/Map;J)V", "getImage", "()Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: WeakMemoryCache.kt */
    public static final class InternalValue {
        private final Map<String, Object> extras;
        private final WeakReference<Image> image;
        private final long size;

        public InternalValue(WeakReference<Image> weakReference, Map<String, ? extends Object> map, long j) {
            this.image = weakReference;
            this.extras = map;
            this.size = j;
        }

        public final WeakReference<Image> getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/memory/RealWeakMemoryCache$Companion;", "", "<init>", "()V", "CLEAN_UP_INTERVAL", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: WeakMemoryCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
