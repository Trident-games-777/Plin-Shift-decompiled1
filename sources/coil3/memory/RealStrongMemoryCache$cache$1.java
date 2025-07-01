package coil3.memory;

import coil3.memory.MemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.util.LruCache;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"coil3/memory/RealStrongMemoryCache$cache$1", "Lcoil3/util/LruCache;", "Lcoil3/memory/MemoryCache$Key;", "Lcoil3/memory/RealStrongMemoryCache$InternalValue;", "sizeOf", "", "key", "value", "entryRemoved", "", "oldValue", "newValue", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: StrongMemoryCache.kt */
public final class RealStrongMemoryCache$cache$1 extends LruCache<MemoryCache.Key, RealStrongMemoryCache.InternalValue> {
    final /* synthetic */ RealStrongMemoryCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealStrongMemoryCache$cache$1(long j, RealStrongMemoryCache realStrongMemoryCache) {
        super(j);
        this.this$0 = realStrongMemoryCache;
    }

    public long sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue) {
        return internalValue.getSize();
    }

    public void entryRemoved(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue, RealStrongMemoryCache.InternalValue internalValue2) {
        this.this$0.weakMemoryCache.set(key, internalValue.getImage(), internalValue.getExtras(), internalValue.getSize());
    }
}
