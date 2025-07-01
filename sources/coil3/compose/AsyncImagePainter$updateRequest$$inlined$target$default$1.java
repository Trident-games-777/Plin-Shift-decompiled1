package coil3.compose;

import coil3.Image;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.target.Target;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"coil3/request/ImageRequest$Builder$target$4", "Lcoil3/target/Target;", "onStart", "", "placeholder", "Lcoil3/Image;", "onError", "error", "onSuccess", "result", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageRequest.kt */
public final class AsyncImagePainter$updateRequest$$inlined$target$default$1 implements Target {
    final /* synthetic */ ImageRequest $request$inlined;
    final /* synthetic */ AsyncImagePainter this$0;

    public void onError(Image image) {
    }

    public void onSuccess(Image image) {
    }

    public AsyncImagePainter$updateRequest$$inlined$target$default$1(ImageRequest imageRequest, AsyncImagePainter asyncImagePainter) {
        this.$request$inlined = imageRequest;
        this.this$0 = asyncImagePainter;
    }

    public void onStart(Image image) {
        this.this$0.updateState(new AsyncImagePainter.State.Loading(image != null ? ImagePainter_androidKt.m7471asPainter55t9rM(image, this.$request$inlined.getContext(), this.this$0.m7460getFilterQualityfv9h1I$coil_compose_core_release()) : null));
    }
}
