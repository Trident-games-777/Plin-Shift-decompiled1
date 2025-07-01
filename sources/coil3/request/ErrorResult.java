package coil3.request;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcoil3/request/ErrorResult;", "Lcoil3/request/ImageResult;", "image", "Lcoil3/Image;", "request", "Lcoil3/request/ImageRequest;", "throwable", "", "<init>", "(Lcoil3/Image;Lcoil3/request/ImageRequest;Ljava/lang/Throwable;)V", "getImage", "()Lcoil3/Image;", "getRequest", "()Lcoil3/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "copy", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageResult.kt */
public final class ErrorResult implements ImageResult {
    private final Image image;
    private final ImageRequest request;
    private final Throwable throwable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual((Object) this.image, (Object) errorResult.image) && Intrinsics.areEqual((Object) this.request, (Object) errorResult.request) && Intrinsics.areEqual((Object) this.throwable, (Object) errorResult.throwable);
    }

    public int hashCode() {
        Image image2 = this.image;
        return ((((image2 == null ? 0 : image2.hashCode()) * 31) + this.request.hashCode()) * 31) + this.throwable.hashCode();
    }

    public String toString() {
        return "ErrorResult(image=" + this.image + ", request=" + this.request + ", throwable=" + this.throwable + ')';
    }

    public ErrorResult(Image image2, ImageRequest imageRequest, Throwable th) {
        this.image = image2;
        this.request = imageRequest;
        this.throwable = th;
    }

    public Image getImage() {
        return this.image;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Image image2, ImageRequest imageRequest, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = errorResult.getImage();
        }
        if ((i & 2) != 0) {
            imageRequest = errorResult.getRequest();
        }
        if ((i & 4) != 0) {
            th = errorResult.throwable;
        }
        return errorResult.copy(image2, imageRequest, th);
    }

    public final ErrorResult copy(Image image2, ImageRequest imageRequest, Throwable th) {
        return new ErrorResult(image2, imageRequest, th);
    }
}
