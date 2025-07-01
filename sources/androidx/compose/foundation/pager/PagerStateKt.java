package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000m\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u001a(\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015H\b\u001a/\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0003\u0010\u001c\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010\u001d\u001aO\u0010\u001e\u001a\u00020\u0017*\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u001d\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\b'H@¢\u0006\u0002\u0010(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020\u0010H@¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020\u0017*\u00020\u0010H@¢\u0006\u0002\u0010*\u001a\u0014\u0010,\u001a\u00020-*\u00020.2\u0006\u0010\u0014\u001a\u00020\nH\u0000\u001a\u0014\u0010/\u001a\u00020-*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00060"}, d2 = {"DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "MaxPagesForAnimateScroll", "", "PagesToPrefetch", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "PagerState", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "currentPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "debugLog", "", "generateMsg", "", "rememberPagerState", "initialPage", "initialPageOffsetFraction", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt {
    private static final float DefaultPositionThreshold = Dp.m7111constructorimpl((float) 56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, (MeasuredPage) null, (MeasuredPage) null, 0.0f, 0, false, SnapPosition.Start.INSTANCE, new PagerStateKt$EmptyLayoutInfo$1(), false, (List) null, (List) null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), 393216, (DefaultConstructorMarker) null);
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    /* access modifiers changed from: private */
    public static final PagerStateKt$UnitDensity$1 UnitDensity = new PagerStateKt$UnitDensity$1();

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerState rememberPagerState(int r10, float r11, kotlin.jvm.functions.Function0<java.lang.Integer> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "C(rememberPagerState)*87@3977L130,87@3927L180:PagerState.kt#g6yjnt"
            r1 = -1210768637(0xffffffffb7d52303, float:-2.5407882E-5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            r0 = r15 & 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            r10 = r2
        L_0x000e:
            r15 = r15 & 2
            if (r15 == 0) goto L_0x0013
            r11 = 0
        L_0x0013:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x001f
            r15 = -1
            java.lang.String r0 = "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r15, r0)
        L_0x001f:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.pager.DefaultPagerState$Companion r15 = androidx.compose.foundation.pager.DefaultPagerState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r15.getSaver()
            r15 = 17132194(0x1056aa2, float:2.4504747E-38)
            java.lang.String r0 = "CC(remember):PagerState.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r0)
            r15 = r14 & 14
            r15 = r15 ^ 6
            r0 = 4
            r1 = 1
            if (r15 <= r0) goto L_0x003d
            boolean r15 = r13.changed((int) r10)
            if (r15 != 0) goto L_0x0041
        L_0x003d:
            r15 = r14 & 6
            if (r15 != r0) goto L_0x0043
        L_0x0041:
            r15 = r1
            goto L_0x0044
        L_0x0043:
            r15 = r2
        L_0x0044:
            r0 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 ^ 48
            r5 = 32
            if (r0 <= r5) goto L_0x0052
            boolean r0 = r13.changed((float) r11)
            if (r0 != 0) goto L_0x0056
        L_0x0052:
            r0 = r14 & 48
            if (r0 != r5) goto L_0x0058
        L_0x0056:
            r0 = r1
            goto L_0x0059
        L_0x0058:
            r0 = r2
        L_0x0059:
            r15 = r15 | r0
            r0 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 ^ 384(0x180, float:5.38E-43)
            r5 = 256(0x100, float:3.59E-43)
            if (r0 <= r5) goto L_0x0068
            boolean r0 = r13.changed((java.lang.Object) r12)
            if (r0 != 0) goto L_0x006c
        L_0x0068:
            r14 = r14 & 384(0x180, float:5.38E-43)
            if (r14 != r5) goto L_0x006d
        L_0x006c:
            r2 = r1
        L_0x006d:
            r14 = r15 | r2
            java.lang.Object r15 = r13.rememberedValue()
            if (r14 != 0) goto L_0x007d
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x0088
        L_0x007d:
            androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1 r14 = new androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
            r14.<init>(r10, r11, r12)
            r15 = r14
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r13.updateRememberedValue(r15)
        L_0x0088:
            r6 = r15
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r8 = 0
            r9 = 4
            r5 = 0
            r7 = r13
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.foundation.pager.DefaultPagerState r10 = (androidx.compose.foundation.pager.DefaultPagerState) r10
            androidx.compose.runtime.MutableState r11 = r10.getPageCountState()
            r11.setValue(r12)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00a8:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.foundation.pager.PagerState r10 = (androidx.compose.foundation.pager.PagerState) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerStateKt.rememberPagerState(int, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.pager.PagerState");
    }

    public static /* synthetic */ PagerState PagerState$default(int i, float f, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return PagerState(i, f, function0);
    }

    public static final PagerState PagerState(int i, float f, Function0<Integer> function0) {
        return new DefaultPagerState(i, f, function0);
    }

    public static final Object animateToNextPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount()) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo pagerLayoutInfo, int i) {
        long pageSpacing = (((long) i) * ((long) (pagerLayoutInfo.getPageSpacing() + pagerLayoutInfo.getPageSize()))) + ((long) pagerLayoutInfo.getBeforeContentPadding()) + ((long) pagerLayoutInfo.getAfterContentPadding());
        int r4 = pagerLayoutInfo.getOrientation() == Orientation.Horizontal ? IntSize.m7283getWidthimpl(pagerLayoutInfo.m1095getViewportSizeYbymL2g()) : IntSize.m7282getHeightimpl(pagerLayoutInfo.m1095getViewportSizeYbymL2g());
        return RangesKt.coerceAtLeast(pageSpacing - ((long) (r4 - RangesKt.coerceIn(pagerLayoutInfo.getSnapPosition().position(r4, pagerLayoutInfo.getPageSize(), pagerLayoutInfo.getBeforeContentPadding(), pagerLayoutInfo.getAfterContentPadding(), i - 1, i), 0, r4))), 0);
    }

    /* access modifiers changed from: private */
    public static final long calculateNewMinScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        int r2 = pagerMeasureResult.getOrientation() == Orientation.Horizontal ? IntSize.m7283getWidthimpl(pagerMeasureResult.m1101getViewportSizeYbymL2g()) : IntSize.m7282getHeightimpl(pagerMeasureResult.m1101getViewportSizeYbymL2g());
        return (long) RangesKt.coerceIn(pagerMeasureResult.getSnapPosition().position(r2, pagerMeasureResult.getPageSize(), pagerMeasureResult.getBeforeContentPadding(), pagerMeasureResult.getAfterContentPadding(), 0, i), 0, r2);
    }

    /* access modifiers changed from: private */
    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, float f, AnimationSpec<Float> animationSpec, Function2<? super ScrollScope, ? super Integer, Unit> function2, Continuation<? super Unit> continuation) {
        LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope2 = lazyLayoutAnimateScrollScope;
        Object scroll = lazyLayoutAnimateScrollScope2.scroll(new PagerStateKt$animateScrollToPage$2(function2, i, lazyLayoutAnimateScrollScope2, f, animationSpec, (Continuation<? super PagerStateKt$animateScrollToPage$2>) null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }
}
