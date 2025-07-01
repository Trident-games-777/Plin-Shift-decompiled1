package androidx.compose.ui.graphics.layer;

import android.media.Image;
import android.media.ImageReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayerSnapshot.android.kt */
final class LayerSnapshotV22$toBitmap$2$image$1$1 implements ImageReader.OnImageAvailableListener {
    final /* synthetic */ CancellableContinuation<Image> $continuation;

    LayerSnapshotV22$toBitmap$2$image$1$1(CancellableContinuation<? super Image> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m7823constructorimpl(imageReader.acquireLatestImage()));
    }
}
