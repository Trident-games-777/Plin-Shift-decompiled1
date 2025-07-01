package coil3.compose;

import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LocalAsyncImagePreviewHandler.kt */
final class AsyncImagePreviewHandler$Companion$Default$1 implements AsyncImagePreviewHandler {
    public static final AsyncImagePreviewHandler$Companion$Default$1 INSTANCE = new AsyncImagePreviewHandler$Companion$Default$1();

    AsyncImagePreviewHandler$Companion$Default$1() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: coil3.request.ImageRequest} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handle(coil3.ImageLoader r5, coil3.request.ImageRequest r6, kotlin.coroutines.Continuation<? super coil3.compose.AsyncImagePainter.State> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof coil3.compose.AsyncImagePreviewHandler$Companion$Default$1$handle$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            coil3.compose.AsyncImagePreviewHandler$Companion$Default$1$handle$1 r0 = (coil3.compose.AsyncImagePreviewHandler$Companion$Default$1$handle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            coil3.compose.AsyncImagePreviewHandler$Companion$Default$1$handle$1 r0 = new coil3.compose.AsyncImagePreviewHandler$Companion$Default$1$handle$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            coil3.request.ImageRequest r6 = (coil3.request.ImageRequest) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.execute(r6, r0)
            if (r7 != r1) goto L_0x0045
            return r1
        L_0x0045:
            coil3.request.ImageResult r7 = (coil3.request.ImageResult) r7
            boolean r5 = r7 instanceof coil3.request.SuccessResult
            r0 = 2
            r1 = 0
            r2 = 0
            if (r5 == 0) goto L_0x0064
            coil3.compose.AsyncImagePainter$State$Success r5 = new coil3.compose.AsyncImagePainter$State$Success
            coil3.request.SuccessResult r7 = (coil3.request.SuccessResult) r7
            coil3.Image r3 = r7.getImage()
            android.content.Context r6 = r6.getContext()
            androidx.compose.ui.graphics.painter.Painter r6 = coil3.compose.ImagePainter_androidKt.m7472asPainter55t9rM$default(r3, r6, r1, r0, r2)
            r5.<init>(r6, r7)
            coil3.compose.AsyncImagePainter$State r5 = (coil3.compose.AsyncImagePainter.State) r5
            return r5
        L_0x0064:
            boolean r5 = r7 instanceof coil3.request.ErrorResult
            if (r5 == 0) goto L_0x0080
            coil3.compose.AsyncImagePainter$State$Error r5 = new coil3.compose.AsyncImagePainter$State$Error
            coil3.request.ErrorResult r7 = (coil3.request.ErrorResult) r7
            coil3.Image r3 = r7.getImage()
            if (r3 == 0) goto L_0x007a
            android.content.Context r6 = r6.getContext()
            androidx.compose.ui.graphics.painter.Painter r2 = coil3.compose.ImagePainter_androidKt.m7472asPainter55t9rM$default(r3, r6, r1, r0, r2)
        L_0x007a:
            r5.<init>(r2, r7)
            coil3.compose.AsyncImagePainter$State r5 = (coil3.compose.AsyncImagePainter.State) r5
            return r5
        L_0x0080:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePreviewHandler$Companion$Default$1.handle(coil3.ImageLoader, coil3.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
