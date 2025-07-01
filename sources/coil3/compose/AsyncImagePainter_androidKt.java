package coil3.compose;

import androidx.compose.ui.layout.ContentScale;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.CrossfadePainter;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\f\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\"\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u000e"}, d2 = {"validateRequestProperties", "", "request", "Lcoil3/request/ImageRequest;", "maybeNewCrossfadePainter", "Lcoil3/compose/internal/CrossfadePainter;", "previous", "Lcoil3/compose/AsyncImagePainter$State;", "current", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "fakeTransitionTarget", "coil3/compose/AsyncImagePainter_androidKt$fakeTransitionTarget$1", "Lcoil3/compose/AsyncImagePainter_androidKt$fakeTransitionTarget$1;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: AsyncImagePainter.android.kt */
public final class AsyncImagePainter_androidKt {
    private static final AsyncImagePainter_androidKt$fakeTransitionTarget$1 fakeTransitionTarget = new AsyncImagePainter_androidKt$fakeTransitionTarget$1();

    public static final void validateRequestProperties(ImageRequest imageRequest) {
        if (imageRequest.getTarget() != null) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        } else if (ImageRequests_androidKt.getLifecycle(imageRequest) != null) {
            throw new IllegalArgumentException("request.lifecycle must be null.".toString());
        }
    }

    public static final CrossfadePainter maybeNewCrossfadePainter(AsyncImagePainter.State state, AsyncImagePainter.State state2, ContentScale contentScale) {
        ImageResult imageResult;
        if (state2 instanceof AsyncImagePainter.State.Success) {
            imageResult = ((AsyncImagePainter.State.Success) state2).getResult();
        } else {
            if (state2 instanceof AsyncImagePainter.State.Error) {
                imageResult = ((AsyncImagePainter.State.Error) state2).getResult();
            }
            return null;
        }
        Transition create = ImageRequests_androidKt.getTransitionFactory(imageResult.getRequest()).create(fakeTransitionTarget, imageResult);
        if (create instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) create;
            return new CrossfadePainter(state instanceof AsyncImagePainter.State.Loading ? state.getPainter() : null, state2.getPainter(), contentScale, crossfadeTransition.getDurationMillis(), !(imageResult instanceof SuccessResult) || !((SuccessResult) imageResult).isPlaceholderCached(), crossfadeTransition.getPreferExactIntrinsicSize());
        }
        return null;
    }
}
