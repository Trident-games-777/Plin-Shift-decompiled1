package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcoil3/memory/EmptyStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil3/memory/WeakMemoryCache;", "<init>", "(Lcoil3/memory/WeakMemoryCache;)V", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "keys", "", "Lcoil3/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil3/memory/MemoryCache$Value;", "key", "set", "", "image", "Lcoil3/Image;", "extras", "", "", "", "remove", "", "trimToSize", "clear", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: StrongMemoryCache.kt */
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    private final WeakMemoryCache weakMemoryCache;

    public void clear() {
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    public long getMaxSize() {
        return 0;
    }

    public long getSize() {
        return 0;
    }

    public boolean remove(MemoryCache.Key key) {
        return false;
    }

    public void trimToSize(long j) {
    }

    public EmptyStrongMemoryCache(WeakMemoryCache weakMemoryCache2) {
        this.weakMemoryCache = weakMemoryCache2;
    }

    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.emptySet();
    }

    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long j) {
        this.weakMemoryCache.set(key, image, map, j);
    }
}
