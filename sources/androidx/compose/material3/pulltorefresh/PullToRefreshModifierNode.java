package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u00106\u001a\u00020\bH@¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\bH@¢\u0006\u0002\u00107J\b\u00109\u001a\u00020\u0010H\u0002J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\bH\u0016J*\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020G2\u0006\u0010<\u001a\u00020GH@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\"\u0010J\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0016\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0010H@¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u001b\"\u0004\b\u001e\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\f\u001a\u00020\rX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0017R\u0014\u0010.\u001a\u00020/8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R+\u00102\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108B@BX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0019\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "adjustedDistancePulled", "", "getAdjustedDistancePulled", "()F", "<set-?>", "distancePulled", "getDistancePulled", "setDistancePulled", "(F)V", "distancePulled$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getEnabled", "()Z", "setEnabled", "(Z)V", "setRefreshing", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "progress", "getProgress", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "setThreshold-0680j_4", "F", "thresholdPx", "", "getThresholdPx", "()I", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "animateToHidden", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToThreshold", "calculateVerticalOffset", "consumeAvailableOffset", "Landroidx/compose/ui/geometry/Offset;", "available", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onAttach", "onPostScroll", "consumed", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, NestedScrollConnection {
    public static final int $stable = 8;
    private final MutableFloatState distancePulled$delegate;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0<Unit> onRefresh;
    private PullToRefreshState state;
    private float threshold;
    private final MutableFloatState verticalOffset$delegate;

    public /* synthetic */ PullToRefreshModifierNode(boolean z, Function0 function0, boolean z2, PullToRefreshState pullToRefreshState, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, z2, pullToRefreshState, f);
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    public final void setOnRefresh(Function0<Unit> function0) {
        this.onRefresh = function0;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    public final void setState(PullToRefreshState pullToRefreshState) {
        this.state = pullToRefreshState;
    }

    /* renamed from: getThreshold-D9Ej5fM  reason: not valid java name */
    public final float m3021getThresholdD9Ej5fM() {
        return this.threshold;
    }

    /* renamed from: setThreshold-0680j_4  reason: not valid java name */
    public final void m3025setThreshold0680j_4(float f) {
        this.threshold = f;
    }

    private PullToRefreshModifierNode(boolean z, Function0<Unit> function0, boolean z2, PullToRefreshState pullToRefreshState, float f) {
        this.isRefreshing = z;
        this.onRefresh = function0;
        this.enabled = z2;
        this.state = pullToRefreshState;
        this.threshold = f;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, (NestedScrollDispatcher) null);
        this.verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    /* access modifiers changed from: private */
    public final float getVerticalOffset() {
        return this.verticalOffset$delegate.getFloatValue();
    }

    private final void setVerticalOffset(float f) {
        this.verticalOffset$delegate.setFloatValue(f);
    }

    private final float getDistancePulled() {
        return this.distancePulled$delegate.getFloatValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled$delegate.setFloatValue(f);
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled() * 0.5f;
    }

    /* access modifiers changed from: private */
    public final int getThresholdPx() {
        return ((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalDensity())).m7086roundToPx0680j_4(this.threshold);
    }

    private final float getProgress() {
        return getAdjustedDistancePulled() / ((float) getThresholdPx());
    }

    public void onAttach() {
        delegate(this.nestedScrollNode);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshModifierNode$onAttach$1(this, (Continuation<? super PullToRefreshModifierNode$onAttach$1>) null), 3, (Object) null);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m3024onPreScrollOzD1aCk(long j, int i) {
        if (this.state.isAnimating()) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        if (!this.enabled) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        if (!NestedScrollSource.m5469equalsimpl0(i, NestedScrollSource.Companion.m5481getUserInputWNlRxjI()) || Offset.m3988getYimpl(j) >= 0.0f) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        return m3020consumeAvailableOffsetMKHz9U(j);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m3022onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.state.isAnimating()) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        if (!this.enabled) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        if (!NestedScrollSource.m5469equalsimpl0(i, NestedScrollSource.Companion.m5481getUserInputWNlRxjI())) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        long r7 = m3020consumeAvailableOffsetMKHz9U(j2);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshModifierNode$onPostScroll$1(this, (Continuation<? super PullToRefreshModifierNode$onPostScroll$1>) null), 3, (Object) null);
        return r7;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m3023onPreFlingQWom1Mo(long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            float r5 = r0.F$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            float r5 = androidx.compose.ui.unit.Velocity.m7351getYimpl(r5)
            r6 = 0
            r0.F$0 = r6
            r0.label = r3
            java.lang.Object r7 = r4.onRelease(r5, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r6
        L_0x0048:
            java.lang.Number r7 = (java.lang.Number) r7
            float r6 = r7.floatValue()
            long r5 = androidx.compose.ui.unit.VelocityKt.Velocity(r5, r6)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7341boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.m3023onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void update() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new PullToRefreshModifierNode$update$1(this, (Continuation<? super PullToRefreshModifierNode$update$1>) null), 3, (Object) null);
    }

    /* renamed from: consumeAvailableOffset-MK-Hz9U  reason: not valid java name */
    private final long m3020consumeAvailableOffsetMKHz9U(long j) {
        float f;
        if (this.isRefreshing) {
            f = 0.0f;
        } else {
            float coerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + Offset.m3988getYimpl(j), 0.0f);
            f = coerceAtLeast - getDistancePulled();
            setDistancePulled(coerceAtLeast);
            setVerticalOffset(calculateVerticalOffset());
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onRelease(float r7, kotlin.coroutines.Continuation<? super java.lang.Float> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            float r7 = r0.F$0
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0081
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            float r7 = r0.F$0
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006d
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6.isRefreshing
            if (r8 == 0) goto L_0x0052
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            return r7
        L_0x0052:
            float r8 = r6.getAdjustedDistancePulled()
            int r2 = r6.getThresholdPx()
            float r2 = (float) r2
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0073
            r0.L$0 = r6
            r0.F$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.animateToThreshold(r0)
            if (r8 != r1) goto L_0x006c
            goto L_0x007f
        L_0x006c:
            r0 = r6
        L_0x006d:
            kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r0.onRefresh
            r8.invoke()
            goto L_0x0081
        L_0x0073:
            r0.L$0 = r6
            r0.F$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.animateToHidden(r0)
            if (r8 != r1) goto L_0x0080
        L_0x007f:
            return r1
        L_0x0080:
            r0 = r6
        L_0x0081:
            float r8 = r0.getDistancePulled()
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x008b
        L_0x0089:
            r7 = r5
            goto L_0x0090
        L_0x008b:
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0090
            goto L_0x0089
        L_0x0090:
            r0.setDistancePulled(r5)
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.onRelease(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= ((float) getThresholdPx())) {
            return getAdjustedDistancePulled();
        }
        float coerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return ((float) getThresholdPx()) + (((float) getThresholdPx()) * (coerceIn - (((float) Math.pow((double) coerceIn, (double) 2)) / ((float) 4))));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToThreshold(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.state
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.animateToThreshold(r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r4
        L_0x0047:
            int r5 = r0.getThresholdPx()
            float r5 = (float) r5
            r0.setDistancePulled(r5)
            int r5 = r0.getThresholdPx()
            float r5 = (float) r5
            r0.setVerticalOffset(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.animateToThreshold(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToHidden(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.state
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.animateToHidden(r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r4
        L_0x0047:
            r5 = 0
            r0.setDistancePulled(r5)
            r0.setVerticalOffset(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.animateToHidden(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
