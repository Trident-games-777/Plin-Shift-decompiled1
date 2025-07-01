package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020\u001fH\u0002J?\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\"\u0010'\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0)\u0012\u0006\u0012\u0004\u0018\u00010*0(H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J6\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c02H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u001cH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\b9J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>J\u001a\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bB\u0010>J\u001a\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010>J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020\u0011H\u0002J\u001a\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010LR\u0016\u0010\u0007\u001a\u00020\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollCycleInProgress", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "pullBottom", "", "scroll", "pullBottom-k-4lQ0M", "(J)F", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "pullTop", "pullTop-k-4lQ0M", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize = Size.Companion.m4065getZeroNHjbRc();
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled = true;
    /* access modifiers changed from: private */
    public PointerId pointerId;
    /* access modifiers changed from: private */
    public Offset pointerPosition;
    private final MutableState<Unit> redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    private boolean scrollCycleInProgress;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Modifier modifier;
        EdgeEffectWrapper edgeEffectWrapper2 = new EdgeEffectWrapper(context, ColorKt.m4293toArgb8_81llA(overscrollConfiguration.m343getGlowColor0d7_KjU()));
        this.edgeEffectWrapper = edgeEffectWrapper2;
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, (Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1>) null));
        if (Build.VERSION.SDK_INT >= 31) {
            modifier = new DrawStretchOverscrollModifier(this, edgeEffectWrapper2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo());
        } else {
            modifier = new DrawGlowOverscrollModifier(this, edgeEffectWrapper2, overscrollConfiguration, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2(this) : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = pointerInput.then(modifier);
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* renamed from: applyToScroll-Rhakbz0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m230applyToScrollRhakbz0(long r11, int r13, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset> r14) {
        /*
            r10 = this;
            long r0 = r10.containerSize
            boolean r0 = androidx.compose.ui.geometry.Size.m4058isEmptyimpl(r0)
            if (r0 == 0) goto L_0x0017
            androidx.compose.ui.geometry.Offset r11 = androidx.compose.ui.geometry.Offset.m3976boximpl(r11)
            java.lang.Object r11 = r14.invoke(r11)
            androidx.compose.ui.geometry.Offset r11 = (androidx.compose.ui.geometry.Offset) r11
            long r11 = r11.m3997unboximpl()
            return r11
        L_0x0017:
            boolean r0 = r10.scrollCycleInProgress
            r1 = 1
            if (r0 != 0) goto L_0x0021
            r10.stopOverscrollAnimation()
            r10.scrollCycleInProgress = r1
        L_0x0021:
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r11)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002c
        L_0x002a:
            r0 = r2
            goto L_0x0067
        L_0x002c:
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isTopStretched()
            if (r0 == 0) goto L_0x004a
            float r0 = r10.m227pullTopk4lQ0M(r11)
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isTopStretched()
            if (r3 != 0) goto L_0x0067
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r3 = r3.getOrCreateTopEffect()
            r3.onRelease()
            goto L_0x0067
        L_0x004a:
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.edgeEffectWrapper
            boolean r0 = r0.isBottomStretched()
            if (r0 == 0) goto L_0x002a
            float r0 = r10.m224pullBottomk4lQ0M(r11)
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isBottomStretched()
            if (r3 != 0) goto L_0x0067
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r3 = r3.getOrCreateBottomEffect()
            r3.onRelease()
        L_0x0067:
            float r3 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r11)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0070
            goto L_0x00ab
        L_0x0070:
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isLeftStretched()
            if (r3 == 0) goto L_0x008e
            float r2 = r10.m225pullLeftk4lQ0M(r11)
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isLeftStretched()
            if (r3 != 0) goto L_0x00ab
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r3 = r3.getOrCreateLeftEffect()
            r3.onRelease()
            goto L_0x00ab
        L_0x008e:
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isRightStretched()
            if (r3 == 0) goto L_0x00ab
            float r2 = r10.m226pullRightk4lQ0M(r11)
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            boolean r3 = r3.isRightStretched()
            if (r3 != 0) goto L_0x00ab
            androidx.compose.foundation.EdgeEffectWrapper r3 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r3 = r3.getOrCreateRightEffect()
            r3.onRelease()
        L_0x00ab:
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r2, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r0.m4003getZeroF1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m3984equalsimpl0(r2, r4)
            if (r0 != 0) goto L_0x00be
            r10.invalidateOverscroll$foundation_release()
        L_0x00be:
            long r4 = androidx.compose.ui.geometry.Offset.m3991minusMKHz9U(r11, r2)
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3976boximpl(r4)
            java.lang.Object r14 = r14.invoke(r0)
            androidx.compose.ui.geometry.Offset r14 = (androidx.compose.ui.geometry.Offset) r14
            long r6 = r14.m3997unboximpl()
            long r4 = androidx.compose.ui.geometry.Offset.m3991minusMKHz9U(r4, r6)
            androidx.compose.ui.input.nestedscroll.NestedScrollSource$Companion r14 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion
            int r14 = r14.m5481getUserInputWNlRxjI()
            boolean r13 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.m5469equalsimpl0(r13, r14)
            r14 = 0
            if (r13 == 0) goto L_0x0120
            float r13 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r4)
            r0 = 1056964608(0x3f000000, float:0.5)
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            r8 = -1090519040(0xffffffffbf000000, float:-0.5)
            if (r13 <= 0) goto L_0x00f2
            r10.m225pullLeftk4lQ0M(r4)
        L_0x00f0:
            r13 = r1
            goto L_0x00ff
        L_0x00f2:
            float r13 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r4)
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x00fe
            r10.m226pullRightk4lQ0M(r4)
            goto L_0x00f0
        L_0x00fe:
            r13 = r14
        L_0x00ff:
            float r9 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x010c
            r10.m227pullTopk4lQ0M(r4)
        L_0x010a:
            r0 = r1
            goto L_0x0119
        L_0x010c:
            float r0 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r4)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0118
            r10.m224pullBottomk4lQ0M(r4)
            goto L_0x010a
        L_0x0118:
            r0 = r14
        L_0x0119:
            if (r13 != 0) goto L_0x011f
            if (r0 == 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r1 = r14
        L_0x011f:
            r14 = r1
        L_0x0120:
            boolean r11 = r10.m228releaseOppositeOverscrollk4lQ0M(r11)
            if (r11 != 0) goto L_0x0128
            if (r14 == 0) goto L_0x012b
        L_0x0128:
            r10.invalidateOverscroll$foundation_release()
        L_0x012b:
            long r11 = androidx.compose.ui.geometry.Offset.m3992plusMKHz9U(r2, r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m230applyToScrollRhakbz0(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        if (r13.invoke(r11, r0) == r1) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: applyToFling-BMRW4eQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m229applyToFlingBMRW4eQ(long r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = new androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$0
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x012a
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x005a
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            long r6 = r10.containerSize
            boolean r14 = androidx.compose.ui.geometry.Size.m4058isEmptyimpl(r6)
            if (r14 == 0) goto L_0x005d
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m7341boximpl(r11)
            r0.label = r4
            java.lang.Object r11 = r13.invoke(r11, r0)
            if (r11 != r1) goto L_0x005a
            goto L_0x0128
        L_0x005a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x005d:
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0085
            androidx.compose.foundation.EdgeEffectWrapper r14 = r10.edgeEffectWrapper
            boolean r14 = r14.isLeftStretched()
            if (r14 == 0) goto L_0x0085
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r2 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r2 = r2.getOrCreateLeftEffect()
            float r4 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            r14.onAbsorbCompat(r2, r4)
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            goto L_0x00af
        L_0x0085:
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x00ae
            androidx.compose.foundation.EdgeEffectWrapper r14 = r10.edgeEffectWrapper
            boolean r14 = r14.isRightStretched()
            if (r14 == 0) goto L_0x00ae
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r2 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r2 = r2.getOrCreateRightEffect()
            float r4 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            int r4 = -r4
            r14.onAbsorbCompat(r2, r4)
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            goto L_0x00af
        L_0x00ae:
            r14 = r5
        L_0x00af:
            float r2 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d7
            androidx.compose.foundation.EdgeEffectWrapper r2 = r10.edgeEffectWrapper
            boolean r2 = r2.isTopStretched()
            if (r2 == 0) goto L_0x00d7
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r4 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r4 = r4.getOrCreateTopEffect()
            float r6 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            r2.onAbsorbCompat(r4, r6)
            float r2 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            goto L_0x0101
        L_0x00d7:
            float r2 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0100
            androidx.compose.foundation.EdgeEffectWrapper r2 = r10.edgeEffectWrapper
            boolean r2 = r2.isBottomStretched()
            if (r2 == 0) goto L_0x0100
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r4 = r10.edgeEffectWrapper
            android.widget.EdgeEffect r4 = r4.getOrCreateBottomEffect()
            float r6 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            int r6 = -r6
            r2.onAbsorbCompat(r4, r6)
            float r2 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            goto L_0x0101
        L_0x0100:
            r2 = r5
        L_0x0101:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r14, r2)
            androidx.compose.ui.unit.Velocity$Companion r14 = androidx.compose.ui.unit.Velocity.Companion
            long r8 = r14.m7361getZero9UxMQ8M()
            boolean r14 = androidx.compose.ui.unit.Velocity.m7349equalsimpl0(r6, r8)
            if (r14 != 0) goto L_0x0114
            r10.invalidateOverscroll$foundation_release()
        L_0x0114:
            long r11 = androidx.compose.ui.unit.Velocity.m7353minusAH228Gc(r11, r6)
            androidx.compose.ui.unit.Velocity r14 = androidx.compose.ui.unit.Velocity.m7341boximpl(r11)
            r0.L$0 = r10
            r0.J$0 = r11
            r0.label = r3
            java.lang.Object r14 = r13.invoke(r14, r0)
            if (r14 != r1) goto L_0x0129
        L_0x0128:
            return r1
        L_0x0129:
            r13 = r10
        L_0x012a:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.ui.unit.Velocity) r14
            long r0 = r14.m7359unboximpl()
            long r11 = androidx.compose.ui.unit.Velocity.m7353minusAH228Gc(r11, r0)
            r14 = 0
            r13.scrollCycleInProgress = r14
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0153
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r0 = r13.edgeEffectWrapper
            android.widget.EdgeEffect r0 = r0.getOrCreateLeftEffect()
            float r1 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            r14.onAbsorbCompat(r0, r1)
            goto L_0x016f
        L_0x0153:
            float r14 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x016f
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r0 = r13.edgeEffectWrapper
            android.widget.EdgeEffect r0 = r0.getOrCreateRightEffect()
            float r1 = androidx.compose.ui.unit.Velocity.m7350getXimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            int r1 = -r1
            r14.onAbsorbCompat(r0, r1)
        L_0x016f:
            float r14 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x018b
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r0 = r13.edgeEffectWrapper
            android.widget.EdgeEffect r0 = r0.getOrCreateTopEffect()
            float r1 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            r14.onAbsorbCompat(r0, r1)
            goto L_0x01a7
        L_0x018b:
            float r14 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x01a7
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            androidx.compose.foundation.EdgeEffectWrapper r0 = r13.edgeEffectWrapper
            android.widget.EdgeEffect r0 = r0.getOrCreateBottomEffect()
            float r1 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            int r1 = -r1
            r14.onAbsorbCompat(r0, r1)
        L_0x01a7:
            androidx.compose.ui.unit.Velocity$Companion r14 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r14.m7361getZero9UxMQ8M()
            boolean r11 = androidx.compose.ui.unit.Velocity.m7349equalsimpl0(r11, r0)
            if (r11 != 0) goto L_0x01b6
            r13.invalidateOverscroll$foundation_release()
        L_0x01b6:
            r13.animateToRelease()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m229applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper2 = this.edgeEffectWrapper;
        EdgeEffect access$getTopEffect$p = edgeEffectWrapper2.topEffect;
        if (access$getTopEffect$p != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(access$getTopEffect$p) != 0.0f) {
            return true;
        }
        EdgeEffect access$getBottomEffect$p = edgeEffectWrapper2.bottomEffect;
        if (access$getBottomEffect$p != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(access$getBottomEffect$p) != 0.0f) {
            return true;
        }
        EdgeEffect access$getLeftEffect$p = edgeEffectWrapper2.leftEffect;
        if (access$getLeftEffect$p != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(access$getLeftEffect$p) != 0.0f) {
            return true;
        }
        EdgeEffect access$getRightEffect$p = edgeEffectWrapper2.rightEffect;
        return (access$getRightEffect$p == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(access$getRightEffect$p) == 0.0f) ? false : true;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m225pullLeftk4lQ0M(Offset.Companion.m4003getZeroF1C5BW0());
            z = true;
        } else {
            z = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m226pullRightk4lQ0M(Offset.Companion.m4003getZeroF1C5BW0());
            z = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m227pullTopk4lQ0M(Offset.Companion.m4003getZeroF1C5BW0());
            z = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z;
        }
        m224pullBottomk4lQ0M(Offset.Companion.m4003getZeroF1C5BW0());
        return true;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release  reason: not valid java name */
    public final void m232updateSizeuvyYCjk$foundation_release(long j) {
        boolean r0 = Size.m4052equalsimpl0(this.containerSize, Size.Companion.m4065getZeroNHjbRc());
        boolean r1 = Size.m4052equalsimpl0(j, this.containerSize);
        this.containerSize = j;
        if (!r1) {
            this.edgeEffectWrapper.m305setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m4056getWidthimpl(j)), MathKt.roundToInt(Size.m4053getHeightimpl(j))));
        }
        if (!r0 && !r1) {
            invalidateOverscroll$foundation_release();
            animateToRelease();
        }
    }

    /* renamed from: displacement-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m231displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long r0 = offset != null ? offset.m3997unboximpl() : SizeKt.m4066getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m3987getXimpl(r0) / Size.m4056getWidthimpl(this.containerSize), Offset.m3988getYimpl(r0) / Size.m4053getHeightimpl(this.containerSize));
    }

    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToRelease() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper2 = this.edgeEffectWrapper;
        EdgeEffect access$getTopEffect$p = edgeEffectWrapper2.topEffect;
        boolean z2 = false;
        if (access$getTopEffect$p != null) {
            access$getTopEffect$p.onRelease();
            z = access$getTopEffect$p.isFinished();
        } else {
            z = false;
        }
        EdgeEffect access$getBottomEffect$p = edgeEffectWrapper2.bottomEffect;
        if (access$getBottomEffect$p != null) {
            access$getBottomEffect$p.onRelease();
            z = access$getBottomEffect$p.isFinished() || z;
        }
        EdgeEffect access$getLeftEffect$p = edgeEffectWrapper2.leftEffect;
        if (access$getLeftEffect$p != null) {
            access$getLeftEffect$p.onRelease();
            z = access$getLeftEffect$p.isFinished() || z;
        }
        EdgeEffect access$getRightEffect$p = edgeEffectWrapper2.rightEffect;
        if (access$getRightEffect$p != null) {
            access$getRightEffect$p.onRelease();
            if (access$getRightEffect$p.isFinished() || z) {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m228releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m3987getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m3987getXimpl(j));
            z = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m3987getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m3987getXimpl(j));
            z = z || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m3988getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m3988getYimpl(j));
            z = z || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m3988getYimpl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m3988getYimpl(j));
        return z || !this.edgeEffectWrapper.isBottomAnimating();
    }

    /* renamed from: pullTop-k-4lQ0M  reason: not valid java name */
    private final float m227pullTopk4lQ0M(long j) {
        float r0 = Offset.m3987getXimpl(m231displacementF1C5BW0$foundation_release());
        float r1 = Offset.m3988getYimpl(j) / Size.m4053getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        float onPullDistanceCompat = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateTopEffect, r1, r0) * Size.m4053getHeightimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) == 0.0f) {
            return onPullDistanceCompat;
        }
        return Offset.m3988getYimpl(j);
    }

    /* renamed from: pullBottom-k-4lQ0M  reason: not valid java name */
    private final float m224pullBottomk4lQ0M(long j) {
        float r0 = Offset.m3987getXimpl(m231displacementF1C5BW0$foundation_release());
        float r1 = Offset.m3988getYimpl(j) / Size.m4053getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        float r02 = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateBottomEffect, -r1, ((float) 1) - r0)) * Size.m4053getHeightimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect) == 0.0f) {
            return r02;
        }
        return Offset.m3988getYimpl(j);
    }

    /* renamed from: pullLeft-k-4lQ0M  reason: not valid java name */
    private final float m225pullLeftk4lQ0M(long j) {
        float r0 = Offset.m3988getYimpl(m231displacementF1C5BW0$foundation_release());
        float r1 = Offset.m3987getXimpl(j) / Size.m4056getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        float onPullDistanceCompat = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateLeftEffect, r1, ((float) 1) - r0) * Size.m4056getWidthimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect) == 0.0f) {
            return onPullDistanceCompat;
        }
        return Offset.m3987getXimpl(j);
    }

    /* renamed from: pullRight-k-4lQ0M  reason: not valid java name */
    private final float m226pullRightk4lQ0M(long j) {
        float r0 = Offset.m3988getYimpl(m231displacementF1C5BW0$foundation_release());
        float r1 = Offset.m3987getXimpl(j) / Size.m4056getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        float r02 = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateRightEffect, -r1, r0)) * Size.m4056getWidthimpl(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) == 0.0f) {
            return r02;
        }
        return Offset.m3987getXimpl(j);
    }
}
