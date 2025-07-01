package coil3.compose;

import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"coil3/compose/AsyncImageModelEqualityDelegate$Companion$Default$1", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "equals", "", "self", "", "other", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LocalAsyncImageModelEqualityDelegate.kt */
public final class AsyncImageModelEqualityDelegate$Companion$Default$1 implements AsyncImageModelEqualityDelegate {
    AsyncImageModelEqualityDelegate$Companion$Default$1() {
    }

    public boolean equals(Object obj, Object obj2) {
        if (this == obj2) {
            return true;
        }
        if (!(obj instanceof ImageRequest) || !(obj2 instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        ImageRequest imageRequest2 = (ImageRequest) obj2;
        if (!Intrinsics.areEqual((Object) imageRequest.getContext(), (Object) imageRequest2.getContext()) || !Intrinsics.areEqual(imageRequest.getData(), imageRequest2.getData()) || !Intrinsics.areEqual((Object) imageRequest.getMemoryCacheKey(), (Object) imageRequest2.getMemoryCacheKey()) || !Intrinsics.areEqual((Object) imageRequest.getMemoryCacheKeyExtras(), (Object) imageRequest2.getMemoryCacheKeyExtras()) || !Intrinsics.areEqual((Object) imageRequest.getDiskCacheKey(), (Object) imageRequest2.getDiskCacheKey()) || !Intrinsics.areEqual((Object) imageRequest.getSizeResolver(), (Object) imageRequest2.getSizeResolver()) || imageRequest.getScale() != imageRequest2.getScale() || imageRequest.getPrecision() != imageRequest2.getPrecision()) {
            return false;
        }
        return true;
    }

    public int hashCode(Object obj) {
        int i = 0;
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            int hashCode = ((imageRequest.getContext().hashCode() * 31) + imageRequest.getData().hashCode()) * 31;
            String memoryCacheKey = imageRequest.getMemoryCacheKey();
            int hashCode2 = (((hashCode + (memoryCacheKey != null ? memoryCacheKey.hashCode() : 0)) * 31) + imageRequest.getMemoryCacheKeyExtras().hashCode()) * 31;
            String diskCacheKey = imageRequest.getDiskCacheKey();
            if (diskCacheKey != null) {
                i = diskCacheKey.hashCode();
            }
            return ((((((hashCode2 + i) * 31) + imageRequest.getSizeResolver().hashCode()) * 31) + imageRequest.getScale().hashCode()) * 31) + imageRequest.getPrecision().hashCode();
        } else if (obj != null) {
            return obj.hashCode();
        } else {
            return 0;
        }
    }

    public String toString() {
        return "AsyncImageModelEqualityDelegate.Default";
    }
}
