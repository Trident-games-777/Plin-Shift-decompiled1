package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\t\b\u0000\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J4\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "maxSize", "", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(JLcoil3/memory/WeakMemoryCache;)V", "cache", "coil3/memory/RealStrongMemoryCache$cache$1", "Lcoil3/memory/RealStrongMemoryCache$cache$1;", "size", "getSize", "()J", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "image", "Lcoil3/Image;", "extras", "", "", "", "remove", "", "clear", "trimToSize", "InternalValue", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: StrongMemoryCache.kt */
public final class RealStrongMemoryCache implements StrongMemoryCache {
    private final RealStrongMemoryCache$cache$1 cache;
    /* access modifiers changed from: private */
    public final WeakMemoryCache weakMemoryCache;

    public RealStrongMemoryCache(long j, WeakMemoryCache weakMemoryCache2) {
        this.weakMemoryCache = weakMemoryCache2;
        this.cache = new RealStrongMemoryCache$cache$1(j, this);
    }

    public long getSize() {
        return this.cache.getSize();
    }

    public long getMaxSize() {
        return this.cache.getMaxSize();
    }

    public Set<MemoryCache.Key> getKeys() {
        return this.cache.getKeys();
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        InternalValue internalValue = (InternalValue) this.cache.get(key);
        if (internalValue != null) {
            return new MemoryCache.Value(internalValue.getImage(), internalValue.getExtras());
        }
        return null;
    }

    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long j) {
        if (j <= getMaxSize()) {
            this.cache.put(key, new InternalValue(image, map, j));
            return;
        }
        this.cache.remove(key);
        this.weakMemoryCache.set(key, image, map, j);
    }

    public boolean remove(MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    public void clear() {
        this.cache.clear();
    }

    public void trimToSize(long j) {
        this.cache.trimToSize(j);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache$InternalValue;", "", "image", "Lcoil3/Image;", "extras", "", "", "size", "", "<init>", "(Lcoil3/Image;Ljava/util/Map;J)V", "getImage", "()Lcoil3/Image;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: StrongMemoryCache.kt */
    private static final class InternalValue {
        private final Map<String, Object> extras;
        private final Image image;
        private final long size;

        public InternalValue(Image image2, Map<String, ? extends Object> map, long j) {
            this.image = image2;
            this.extras = map;
            this.size = j;
        }

        public final Image getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }
}
