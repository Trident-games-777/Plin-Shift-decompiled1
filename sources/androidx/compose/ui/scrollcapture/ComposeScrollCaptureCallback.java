package androidx.compose.ui.scrollcapture;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import androidx.core.internal.view.SupportMenu;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u001f\u001a\u00020\u0010*\u00020 H\u0002J\f\u0010!\u001a\u00020\u0010*\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listener", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;)V", "requestCount", "", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "onScrollCaptureEnd", "", "onReady", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", "session", "Landroid/view/ScrollCaptureSession;", "signal", "Landroid/os/CancellationSignal;", "captureArea", "Landroid/graphics/Rect;", "onComplete", "Ljava/util/function/Consumer;", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureSearch", "onScrollCaptureStart", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ScrollCaptureSessionListener", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeScrollCaptureCallback.android.kt */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final ScrollCaptureSessionListener listener;
    /* access modifiers changed from: private */
    public final SemanticsNode node;
    private int requestCount;
    /* access modifiers changed from: private */
    public final RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "", "onSessionEnded", "", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ComposeScrollCaptureCallback.android.kt */
    public interface ScrollCaptureSessionListener {
        void onSessionEnded();

        void onSessionStarted();
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, CoroutineScope coroutineScope2, ScrollCaptureSessionListener scrollCaptureSessionListener) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = scrollCaptureSessionListener;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope2, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, (Continuation<? super ComposeScrollCaptureCallback$scrollTracker$1>) null));
    }

    public void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer<Rect> consumer) {
        consumer.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        runnable.run();
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer<Rect> consumer) {
        Job unused = ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(this.coroutineScope, cancellationSignal, new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1(this, scrollCaptureSession, rect, consumer, (Continuation<? super ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onScrollCaptureImageRequest(android.view.ScrollCaptureSession r9, androidx.compose.ui.unit.IntRect r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.IntRect> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 r0 = (androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 r0 = new androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2
            r0.<init>(r8, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005e
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r1 = r0.L$2
            androidx.compose.ui.unit.IntRect r1 = (androidx.compose.ui.unit.IntRect) r1
            java.lang.Object r2 = r0.L$1
            android.view.ScrollCaptureSession r2 = (android.view.ScrollCaptureSession) r2
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback r0 = (androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r2
            goto L_0x009b
        L_0x003e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0046:
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$2
            androidx.compose.ui.unit.IntRect r2 = (androidx.compose.ui.unit.IntRect) r2
            java.lang.Object r4 = r0.L$1
            android.view.ScrollCaptureSession r4 = (android.view.ScrollCaptureSession) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback r5 = (androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r2
            r2 = r9
            r9 = r4
            goto L_0x007f
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r11)
            int r11 = r10.getTop()
            int r2 = r10.getBottom()
            androidx.compose.ui.scrollcapture.RelativeScroller r5 = r8.scrollTracker
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.I$0 = r11
            r0.I$1 = r2
            r0.label = r4
            java.lang.Object r4 = r5.scrollRangeIntoView(r11, r2, r0)
            if (r4 != r1) goto L_0x007e
            goto L_0x0095
        L_0x007e:
            r5 = r8
        L_0x007f:
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3 r4 = androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r10
            r0.I$0 = r11
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r0 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r4, r0)
            if (r0 != r1) goto L_0x0096
        L_0x0095:
            return r1
        L_0x0096:
            r1 = r10
            r10 = r11
            r0 = r5
            r11 = r9
            r9 = r2
        L_0x009b:
            androidx.compose.ui.scrollcapture.RelativeScroller r2 = r0.scrollTracker
            int r3 = r2.mapOffsetToViewport(r10)
            androidx.compose.ui.scrollcapture.RelativeScroller r10 = r0.scrollTracker
            int r5 = r10.mapOffsetToViewport(r9)
            r6 = 5
            r7 = 0
            r2 = 0
            r4 = 0
            androidx.compose.ui.unit.IntRect r9 = androidx.compose.ui.unit.IntRect.copy$default(r1, r2, r3, r4, r5, r6, r7)
            if (r3 != r5) goto L_0x00b8
            androidx.compose.ui.unit.IntRect$Companion r9 = androidx.compose.ui.unit.IntRect.Companion
            androidx.compose.ui.unit.IntRect r9 = r9.getZero()
            return r9
        L_0x00b8:
            androidx.compose.ui.semantics.SemanticsNode r10 = r0.node
            androidx.compose.ui.node.NodeCoordinator r10 = r10.findCoordinatorToGetBounds$ui_release()
            if (r10 == 0) goto L_0x0105
            android.view.Surface r1 = r11.getSurface()
            android.graphics.Canvas r1 = r1.lockHardwareCanvas()
            android.graphics.BlendMode r2 = android.graphics.BlendMode.CLEAR     // Catch:{ all -> 0x00fb }
            r3 = 0
            r1.drawColor(r3, r2)     // Catch:{ all -> 0x00fb }
            androidx.compose.ui.graphics.Canvas r2 = androidx.compose.ui.graphics.AndroidCanvas_androidKt.Canvas(r1)     // Catch:{ all -> 0x00fb }
            int r4 = r9.getLeft()     // Catch:{ all -> 0x00fb }
            float r4 = (float) r4     // Catch:{ all -> 0x00fb }
            float r4 = -r4
            int r5 = r9.getTop()     // Catch:{ all -> 0x00fb }
            float r5 = (float) r5     // Catch:{ all -> 0x00fb }
            float r5 = -r5
            r2.translate(r4, r5)     // Catch:{ all -> 0x00fb }
            r4 = 0
            r10.draw(r2, r4)     // Catch:{ all -> 0x00fb }
            android.view.Surface r10 = r11.getSurface()
            r10.unlockCanvasAndPost(r1)
            androidx.compose.ui.scrollcapture.RelativeScroller r10 = r0.scrollTracker
            float r10 = r10.getScrollAmount()
            int r10 = kotlin.math.MathKt.roundToInt((float) r10)
            androidx.compose.ui.unit.IntRect r9 = r9.translate(r3, r10)
            return r9
        L_0x00fb:
            r0 = move-exception
            r9 = r0
            android.view.Surface r10 = r11.getSurface()
            r10.unlockCanvasAndPost(r1)
            throw r9
        L_0x0105:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Could not find coordinator for semantics node."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.onScrollCaptureImageRequest(android.view.ScrollCaptureSession, androidx.compose.ui.unit.IntRect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void onScrollCaptureEnd(Runnable runnable) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, (CoroutineStart) null, new ComposeScrollCaptureCallback$onScrollCaptureEnd$1(this, runnable, (Continuation<? super ComposeScrollCaptureCallback$onScrollCaptureEnd$1>) null), 2, (Object) null);
    }

    private final void drawDebugBackground(Canvas canvas) {
        canvas.drawColor(ColorKt.m4293toArgb8_81llA(Color.Companion.m4263hslJlNiLsg$default(Color.Companion, Random.Default.nextFloat() * 360.0f, 0.75f, 0.5f, 1.0f, (Rgb) null, 16, (Object) null)));
    }

    private final void drawDebugOverlay(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTextSize(48.0f);
        canvas.drawCircle(0.0f, 0.0f, 20.0f, paint);
        canvas.drawCircle((float) canvas.getWidth(), 0.0f, 20.0f, paint);
        canvas.drawCircle((float) canvas.getWidth(), (float) canvas.getHeight(), 20.0f, paint);
        canvas.drawCircle(0.0f, (float) canvas.getHeight(), 20.0f, paint);
        canvas.drawText(String.valueOf(this.requestCount), ((float) canvas.getWidth()) / 2.0f, ((float) canvas.getHeight()) / 2.0f, paint);
        this.requestCount++;
    }
}
