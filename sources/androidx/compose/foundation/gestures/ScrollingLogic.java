package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000f*\u0001\u0013\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0006\u0010\"\u001a\u00020\u000bJ\u001b\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0004\b&\u0010!J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b)\u0010*JA\u0010(\u001a\u00020$2\b\b\u0002\u0010+\u001a\u00020,2'\u0010-\u001a#\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020$00\u0012\u0006\u0012\u0004\u0018\u00010\u00010.¢\u0006\u0002\b1H@¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u000bJ8\u00104\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ&\u00105\u001a\u00020\u0019*\u00020\u00162\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0014\u0010:\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b;\u0010*J\n\u0010:\u001a\u00020<*\u00020<J\u0014\u0010=\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b>\u0010*J\u0016\u0010?\u001a\u00020\u001e*\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010*J\u0014\u0010A\u001a\u00020<*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u0016\u0010A\u001a\u00020<*\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010CJ\u0017\u0010E\u001a\u00020\u0019*\u00020<ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001e\u00104\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010H\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010JR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u0010X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "update", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollingLogic {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public FlingBehavior flingBehavior;
    /* access modifiers changed from: private */
    public int latestScrollSource = NestedScrollSource.Companion.m5481getUserInputWNlRxjI();
    /* access modifiers changed from: private */
    public NestedScrollDispatcher nestedScrollDispatcher;
    /* access modifiers changed from: private */
    public final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
    private Orientation orientation;
    /* access modifiers changed from: private */
    public ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    /* access modifiers changed from: private */
    public OverscrollEffect overscrollEffect;
    /* access modifiers changed from: private */
    public final Function1<Offset, Offset> performScrollForOverscroll = new ScrollingLogic$performScrollForOverscroll$1(this);
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    public ScrollingLogic(ScrollableState scrollableState2, OverscrollEffect overscrollEffect2, FlingBehavior flingBehavior2, Orientation orientation2, boolean z, NestedScrollDispatcher nestedScrollDispatcher2) {
        this.scrollableState = scrollableState2;
        this.overscrollEffect = overscrollEffect2;
        this.flingBehavior = flingBehavior2;
        this.orientation = orientation2;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m556toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m554singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3981copydBAh8RU$default(j, 0.0f, 0.0f, 1, (Object) null) : Offset.m3981copydBAh8RU$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m555toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3987getXimpl(j) : Offset.m3988getYimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m548toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7350getXimpl(j) : Velocity.m7351getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    private final long m547singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7346copyOhffZ5M$default(j, 0.0f, 0.0f, 1, (Object) null) : Velocity.m7346copyOhffZ5M$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m549updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7346copyOhffZ5M$default(j, f, 0.0f, 2, (Object) null) : Velocity.m7346copyOhffZ5M$default(j, 0.0f, f, 1, (Object) null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * ((float) -1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m553reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m3994timestuRUvjQ(j, -1.0f) : j;
    }

    /* access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA  reason: not valid java name */
    public final long m546performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long r0 = this.nestedScrollDispatcher.m5461dispatchPreScrollOzD1aCk(j, i);
        long r12 = Offset.m3991minusMKHz9U(j, r0);
        long r5 = m553reverseIfNeededMKHz9U(m556toOffsettuRUvjQ(scrollScope.scrollBy(m555toFloatk4lQ0M(m553reverseIfNeededMKHz9U(m554singleAxisOffsetMKHz9U(r12))))));
        return Offset.m3992plusMKHz9U(Offset.m3992plusMKHz9U(r0, r5), this.nestedScrollDispatcher.m5459dispatchPostScrollDzOQY0M(r5, Offset.m3991minusMKHz9U(r12, r5), i));
    }

    /* access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m552performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        return m556toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m555toFloatk4lQ0M(j)))));
    }

    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    public final Object m551onDragStoppedsFctU(long j, Continuation<? super Unit> continuation) {
        long r4 = m547singleAxisVelocityAH228Gc(j);
        Function2 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, (Continuation<? super ScrollingLogic$onDragStopped$performFling$1>) null);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 == null || !getShouldDispatchOverscroll()) {
            Object invoke = scrollingLogic$onDragStopped$performFling$1.invoke(Velocity.m7341boximpl(r4), continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        Object r42 = overscrollEffect2.m344applyToFlingBMRW4eQ(r4, scrollingLogic$onDragStopped$performFling$1, continuation);
        return r42 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r42 : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m550doFlingAnimationQWom1Mo(long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = r10
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            r6.element = r11
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r11 = r10.scroll(r13, r4, r0)
            if (r11 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r11 = r6
        L_0x0059:
            long r11 = r11.element
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m7341boximpl(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m550doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        return overscrollEffect2 != null ? overscrollEffect2.isInProgress() : false;
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic scrollingLogic, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic.scroll(mutatePriority, function2, continuation);
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, new ScrollingLogic$scroll$2(this, function2, (Continuation<? super ScrollingLogic$scroll$2>) null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState2, Orientation orientation2, OverscrollEffect overscrollEffect2, boolean z, FlingBehavior flingBehavior2, NestedScrollDispatcher nestedScrollDispatcher2) {
        boolean z2;
        boolean z3 = true;
        if (!Intrinsics.areEqual((Object) this.scrollableState, (Object) scrollableState2)) {
            this.scrollableState = scrollableState2;
            z2 = true;
        } else {
            z2 = false;
        }
        this.overscrollEffect = overscrollEffect2;
        if (this.orientation != orientation2) {
            this.orientation = orientation2;
            z2 = true;
        }
        if (this.reverseDirection != z) {
            this.reverseDirection = z;
        } else {
            z3 = z2;
        }
        this.flingBehavior = flingBehavior2;
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
        return z3;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }
}
