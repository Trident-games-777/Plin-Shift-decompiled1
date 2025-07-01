package coil3.size;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcoil3/size/RealSizeResolver;", "Lcoil3/size/SizeResolver;", "size", "Lcoil3/size/Size;", "<init>", "(Lcoil3/size/Size;)V", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealSizeResolver.kt */
public final class RealSizeResolver implements SizeResolver {
    private final Size size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RealSizeResolver) && Intrinsics.areEqual((Object) this.size, (Object) ((RealSizeResolver) obj).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }

    public String toString() {
        return "RealSizeResolver(size=" + this.size + ')';
    }

    public RealSizeResolver(Size size2) {
        this.size = size2;
    }

    public Object size(Continuation<? super Size> continuation) {
        return this.size;
    }
}
