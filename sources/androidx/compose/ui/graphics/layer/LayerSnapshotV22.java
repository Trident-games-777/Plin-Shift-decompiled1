package androidx.compose.ui.graphics.layer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayerSnapshot.android.kt */
public final class LayerSnapshotV22 implements LayerSnapshotImpl {
    public static final LayerSnapshotV22 INSTANCE = new LayerSnapshotV22();

    private LayerSnapshotV22() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer r9, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r0 = (androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r0 = new androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 != r4) goto L_0x0043
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r9 = (androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1) r9
            java.lang.Object r9 = r0.L$3
            android.media.ImageReader r9 = (android.media.ImageReader) r9
            java.lang.Object r9 = r0.L$2
            java.lang.AutoCloseable r9 = (java.lang.AutoCloseable) r9
            java.lang.Object r1 = r0.L$1
            android.os.Looper r1 = (android.os.Looper) r1
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.graphics.layer.GraphicsLayer r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0040 }
            goto L_0x00cf
        L_0x0040:
            r10 = move-exception
            goto L_0x00e0
        L_0x0043:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r10)
            long r5 = r9.m4973getSizeYbymL2g()
            android.os.Looper r10 = android.os.Looper.myLooper()
            if (r10 != 0) goto L_0x005c
            android.os.Looper r10 = android.os.Looper.getMainLooper()
        L_0x005c:
            int r2 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r5)
            int r5 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r5)
            android.media.ImageReader r2 = android.media.ImageReader.newInstance(r2, r5, r4, r4)
            java.lang.AutoCloseable r2 = (java.lang.AutoCloseable) r2
            r5 = r2
            android.media.ImageReader r5 = (android.media.ImageReader) r5     // Catch:{ all -> 0x00de }
            r0.L$0 = r9     // Catch:{ all -> 0x00de }
            r0.L$1 = r10     // Catch:{ all -> 0x00de }
            r0.L$2 = r2     // Catch:{ all -> 0x00de }
            r0.L$3 = r5     // Catch:{ all -> 0x00de }
            r0.L$4 = r0     // Catch:{ all -> 0x00de }
            r0.label = r4     // Catch:{ all -> 0x00de }
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00de }
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00de }
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)     // Catch:{ all -> 0x00de }
            r7.<init>(r6, r4)     // Catch:{ all -> 0x00de }
            r7.initCancellability()     // Catch:{ all -> 0x00de }
            r4 = r7
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4     // Catch:{ all -> 0x00de }
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1 r6 = new androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1     // Catch:{ all -> 0x00de }
            r6.<init>(r4)     // Catch:{ all -> 0x00de }
            android.media.ImageReader$OnImageAvailableListener r6 = (android.media.ImageReader.OnImageAvailableListener) r6     // Catch:{ all -> 0x00de }
            android.os.Handler r10 = androidx.core.os.HandlerCompat.createAsync(r10)     // Catch:{ all -> 0x00de }
            r5.setOnImageAvailableListener(r6, r10)     // Catch:{ all -> 0x00de }
            android.view.Surface r10 = r5.getSurface()     // Catch:{ all -> 0x00de }
            androidx.compose.ui.graphics.layer.SurfaceUtils r4 = androidx.compose.ui.graphics.layer.SurfaceUtils.INSTANCE     // Catch:{ all -> 0x00de }
            android.graphics.Canvas r4 = r4.lockCanvas(r10)     // Catch:{ all -> 0x00de }
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion     // Catch:{ all -> 0x00d9 }
            long r5 = r5.m4265getBlack0d7_KjU()     // Catch:{ all -> 0x00d9 }
            int r5 = androidx.compose.ui.graphics.ColorKt.m4293toArgb8_81llA(r5)     // Catch:{ all -> 0x00d9 }
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.CLEAR     // Catch:{ all -> 0x00d9 }
            r4.drawColor(r5, r6)     // Catch:{ all -> 0x00d9 }
            androidx.compose.ui.graphics.Canvas r5 = androidx.compose.ui.graphics.AndroidCanvas_androidKt.Canvas(r4)     // Catch:{ all -> 0x00d9 }
            r9.draw$ui_graphics_release(r5, r3)     // Catch:{ all -> 0x00d9 }
            r10.unlockCanvasAndPost(r4)     // Catch:{ all -> 0x00de }
            java.lang.Object r10 = r7.getResult()     // Catch:{ all -> 0x00de }
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00de }
            if (r10 != r9) goto L_0x00cb
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00de }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00de }
        L_0x00cb:
            if (r10 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r9 = r2
        L_0x00cf:
            android.media.Image r10 = (android.media.Image) r10     // Catch:{ all -> 0x0040 }
            android.graphics.Bitmap r10 = androidx.compose.ui.graphics.layer.LayerSnapshot_androidKt.toBitmap(r10)     // Catch:{ all -> 0x0040 }
            kotlin.jdk7.AutoCloseableKt.closeFinally(r9, r3)
            return r10
        L_0x00d9:
            r9 = move-exception
            r10.unlockCanvasAndPost(r4)     // Catch:{ all -> 0x00de }
            throw r9     // Catch:{ all -> 0x00de }
        L_0x00de:
            r10 = move-exception
            r9 = r2
        L_0x00e0:
            throw r10     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r0 = move-exception
            kotlin.jdk7.AutoCloseableKt.closeFinally(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.LayerSnapshotV22.toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
