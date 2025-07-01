package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a8\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0017\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\b\u001a\f\u0010\u0014\u001a\u00020\b*\u00020\u0003H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0003H\u0002¨\u0006\u0018"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isLtrDragging", "", "isScrollingForward", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerSnapLayoutInfoProvider.kt */
public final class PagerSnapLayoutInfoProviderKt {
    private static final void debugLog(Function0<String> function0) {
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState pagerState, PagerSnapDistance pagerSnapDistance, Function3<? super Float, ? super Float, ? super Float, Float> function3) {
        return new PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(pagerState, function3, pagerSnapDistance);
    }

    private static final boolean isLtrDragging(PagerState pagerState) {
        return dragGestureDelta(pagerState) > 0.0f;
    }

    /* access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        boolean reverseLayout = pagerState.getLayoutInfo().getReverseLayout();
        if (!isLtrDragging(pagerState) || !reverseLayout) {
            return !isLtrDragging(pagerState) && !reverseLayout;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Offset.m3987getXimpl(pagerState.m1105getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m3988getYimpl(pagerState.m1105getUpDownDifferenceF1C5BW0$foundation_release());
    }

    public static final float calculateFinalSnappingBound(PagerState pagerState, LayoutDirection layoutDirection, float f, float f2, float f3, float f4) {
        boolean z;
        float f5;
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            z = isScrollingForward(pagerState);
        } else if (layoutDirection == LayoutDirection.Ltr) {
            z = isScrollingForward(pagerState);
        } else {
            z = !isScrollingForward(pagerState);
        }
        int pageSize = pagerState.getLayoutInfo().getPageSize();
        if (pageSize == 0) {
            f5 = 0.0f;
        } else {
            f5 = dragGestureDelta(pagerState) / ((float) pageSize);
        }
        float f6 = f5 - ((float) ((int) f5));
        int calculateFinalSnappingItem = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(pagerState.getDensity$foundation_release(), f2);
        if (FinalSnappingItem.m580equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.Companion.m584getClosestItembbeMdSM())) {
            if (Math.abs(f6) > f) {
            }
        } else if (!FinalSnappingItem.m580equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.Companion.m585getNextItembbeMdSM())) {
            if (FinalSnappingItem.m580equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.Companion.m586getPreviousItembbeMdSM())) {
                return f3;
            }
            return 0.0f;
        }
        return f4;
    }
}
