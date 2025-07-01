package coil3.compose;

import androidx.compose.ui.graphics.painter.Painter;
import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* compiled from: LocalAsyncImagePreviewHandler.kt */
public final class LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1 implements AsyncImagePreviewHandler {
    final /* synthetic */ Function2<ImageRequest, Continuation<? super Image>, Object> $image;

    public LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        this.$image = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: coil3.request.ImageRequest} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handle(coil3.ImageLoader r4, coil3.request.ImageRequest r5, kotlin.coroutines.Continuation<? super coil3.compose.AsyncImagePainter.State> r6) {
        /*
            r3 = this;
            boolean r4 = r6 instanceof coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1
            if (r4 == 0) goto L_0x0014
            r4 = r6
            coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 r4 = (coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1) r4
            int r0 = r4.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r6 = r4.label
            int r6 = r6 - r1
            r4.label = r6
            goto L_0x0019
        L_0x0014:
            coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 r4 = new coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1
            r4.<init>(r3, r6)
        L_0x0019:
            java.lang.Object r6 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r4 = r4.L$0
            r5 = r4
            coil3.request.ImageRequest r5 = (coil3.request.ImageRequest) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function2<coil3.request.ImageRequest, kotlin.coroutines.Continuation<? super coil3.Image>, java.lang.Object> r6 = r3.$image
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r6 = r6.invoke(r5, r4)
            if (r6 != r0) goto L_0x0047
            return r0
        L_0x0047:
            coil3.Image r6 = (coil3.Image) r6
            r4 = 0
            if (r6 == 0) goto L_0x0056
            android.content.Context r5 = r5.getContext()
            r0 = 0
            r1 = 2
            androidx.compose.ui.graphics.painter.Painter r4 = coil3.compose.ImagePainter_androidKt.m7472asPainter55t9rM$default(r6, r5, r0, r1, r4)
        L_0x0056:
            coil3.compose.AsyncImagePainter$State$Loading r5 = new coil3.compose.AsyncImagePainter$State$Loading
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1.handle(coil3.ImageLoader, coil3.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object handle$$forInline(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
        new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
        Image image = (Image) this.$image.invoke(imageRequest, continuation);
        Painter painter = null;
        if (image != null) {
            painter = ImagePainter_androidKt.m7472asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, (Object) null);
        }
        return new AsyncImagePainter.State.Loading(painter);
    }
}
