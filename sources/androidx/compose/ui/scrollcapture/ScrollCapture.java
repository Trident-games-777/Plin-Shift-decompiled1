package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "()V", "<set-?>", "", "scrollCaptureInProgress", "getScrollCaptureInProgress", "()Z", "setScrollCaptureInProgress", "(Z)V", "scrollCaptureInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "onScrollCaptureSearch", "", "view", "Landroid/view/View;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onSessionEnded", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScrollCapture.android.kt */
public final class ScrollCapture implements ComposeScrollCaptureCallback.ScrollCaptureSessionListener {
    public static final int $stable = 0;
    private final MutableState scrollCaptureInProgress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);

    private final void setScrollCaptureInProgress(boolean z) {
        this.scrollCaptureInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getScrollCaptureInProgress() {
        return ((Boolean) this.scrollCaptureInProgress$delegate.getValue()).booleanValue();
    }

    public void onSessionStarted() {
        setScrollCaptureInProgress(true);
    }

    public void onSessionEnded() {
        setScrollCaptureInProgress(false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.compose.ui.scrollcapture.ScrollCaptureCandidate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrollCaptureSearch(android.view.View r6, androidx.compose.ui.semantics.SemanticsOwner r7, kotlin.coroutines.CoroutineContext r8, java.util.function.Consumer<android.view.ScrollCaptureTarget> r9) {
        /*
            r5 = this;
            androidx.compose.runtime.collection.MutableVector r0 = new androidx.compose.runtime.collection.MutableVector
            r1 = 16
            androidx.compose.ui.scrollcapture.ScrollCaptureCandidate[] r1 = new androidx.compose.ui.scrollcapture.ScrollCaptureCandidate[r1]
            r2 = 0
            r0.<init>(r1, r2)
            androidx.compose.ui.semantics.SemanticsNode r7 = r7.getUnmergedRootSemanticsNode()
            androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1 r1 = new androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = 2
            r4 = 0
            androidx.compose.ui.scrollcapture.ScrollCapture_androidKt.visitScrollCaptureCandidates$default(r7, r2, r1, r3, r4)
            kotlin.jvm.functions.Function1[] r7 = new kotlin.jvm.functions.Function1[r3]
            androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2 r1 = androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2.INSTANCE
            r7[r2] = r1
            androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$3 r1 = androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$3.INSTANCE
            r2 = 1
            r7[r2] = r1
            java.util.Comparator r7 = kotlin.comparisons.ComparisonsKt.compareBy((kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>[]) r7)
            r0.sortWith(r7)
            boolean r7 = r0.isEmpty()
            if (r7 == 0) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            int r7 = r0.getSize()
            int r7 = r7 - r2
            java.lang.Object[] r0 = r0.getContent()
            r4 = r0[r7]
        L_0x003e:
            androidx.compose.ui.scrollcapture.ScrollCaptureCandidate r4 = (androidx.compose.ui.scrollcapture.ScrollCaptureCandidate) r4
            if (r4 != 0) goto L_0x0043
            return
        L_0x0043:
            kotlinx.coroutines.CoroutineScope r7 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r8)
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback r8 = new androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback
            androidx.compose.ui.semantics.SemanticsNode r0 = r4.getNode()
            androidx.compose.ui.unit.IntRect r1 = r4.getViewportBoundsInWindow()
            r2 = r5
            androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$ScrollCaptureSessionListener r2 = (androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener) r2
            r8.<init>(r0, r1, r7, r2)
            androidx.compose.ui.layout.LayoutCoordinates r7 = r4.getCoordinates()
            androidx.compose.ui.geometry.Rect r7 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInRoot(r7)
            androidx.compose.ui.unit.IntRect r0 = r4.getViewportBoundsInWindow()
            long r0 = r0.m7269getTopLeftnOccac()
            androidx.compose.ui.unit.IntRect r7 = androidx.compose.ui.unit.IntRectKt.roundToIntRect(r7)
            android.graphics.Rect r7 = androidx.compose.ui.graphics.RectHelper_androidKt.toAndroidRect((androidx.compose.ui.unit.IntRect) r7)
            android.graphics.Point r2 = new android.graphics.Point
            int r3 = androidx.compose.ui.unit.IntOffset.m7241getXimpl(r0)
            int r0 = androidx.compose.ui.unit.IntOffset.m7242getYimpl(r0)
            r2.<init>(r3, r0)
            android.view.ScrollCaptureCallback r8 = (android.view.ScrollCaptureCallback) r8
            android.view.ScrollCaptureTarget r0 = new android.view.ScrollCaptureTarget
            r0.<init>(r6, r7, r2, r8)
            androidx.compose.ui.unit.IntRect r6 = r4.getViewportBoundsInWindow()
            android.graphics.Rect r6 = androidx.compose.ui.graphics.RectHelper_androidKt.toAndroidRect((androidx.compose.ui.unit.IntRect) r6)
            r0.setScrollBounds(r6)
            r9.accept(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.ScrollCapture.onScrollCaptureSearch(android.view.View, androidx.compose.ui.semantics.SemanticsOwner, kotlin.coroutines.CoroutineContext, java.util.function.Consumer):void");
    }
}
