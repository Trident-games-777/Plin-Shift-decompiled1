package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/gestures/snapping/PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateApproachOffset", "", "velocity", "decayOffset", "calculateSnapOffset", "searchForSnappingBounds", "Lkotlin/Pair;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "isValidDistance", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerSnapLayoutInfoProvider.kt */
public final class PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ Function3<Float, Float, Float, Float> $calculateFinalSnappingBound;
    final /* synthetic */ PagerSnapDistance $pagerSnapDistance;
    final /* synthetic */ PagerState $pagerState;

    public final boolean isValidDistance(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(PagerState pagerState, Function3<? super Float, ? super Float, ? super Float, Float> function3, PagerSnapDistance pagerSnapDistance) {
        this.$pagerState = pagerState;
        this.$calculateFinalSnappingBound = function3;
        this.$pagerSnapDistance = pagerSnapDistance;
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.$pagerState.getLayoutInfo();
    }

    public float calculateSnapOffset(float f) {
        Pair<Float, Float> searchForSnappingBounds = searchForSnappingBounds(this.$pagerState.getLayoutInfo().getSnapPosition());
        float floatValue = searchForSnappingBounds.component1().floatValue();
        float floatValue2 = searchForSnappingBounds.component2().floatValue();
        float floatValue3 = this.$calculateFinalSnappingBound.invoke(Float.valueOf(f), Float.valueOf(floatValue), Float.valueOf(floatValue2)).floatValue();
        if (floatValue3 != floatValue && floatValue3 != floatValue2 && floatValue3 != 0.0f) {
            throw new IllegalStateException(("Final Snapping Offset Should Be one of " + floatValue + ", " + floatValue2 + " or 0.0").toString());
        } else if (isValidDistance(floatValue3)) {
            return floatValue3;
        } else {
            return 0.0f;
        }
    }

    public float calculateApproachOffset(float f, float f2) {
        int i;
        int pageSize$foundation_release = this.$pagerState.getPageSize$foundation_release() + this.$pagerState.getPageSpacing$foundation_release();
        if (pageSize$foundation_release == 0) {
            return 0.0f;
        }
        if (f < 0.0f) {
            i = this.$pagerState.getFirstVisiblePage$foundation_release() + 1;
        } else {
            i = this.$pagerState.getFirstVisiblePage$foundation_release();
        }
        int i2 = i;
        float f3 = f;
        int coerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(this.$pagerSnapDistance.calculateTargetPage(i2, RangesKt.coerceIn(((int) (f2 / ((float) pageSize$foundation_release))) + i2, 0, this.$pagerState.getPageCount()), f3, this.$pagerState.getPageSize$foundation_release(), this.$pagerState.getPageSpacing$foundation_release()), 0, this.$pagerState.getPageCount()) - i2) * pageSize$foundation_release) - pageSize$foundation_release, 0);
        if (coerceAtLeast == 0) {
            return (float) coerceAtLeast;
        }
        return ((float) coerceAtLeast) * Math.signum(f3);
    }

    private final Pair<Float, Float> searchForSnappingBounds(SnapPosition snapPosition) {
        float f;
        List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
        PagerState pagerState = this.$pagerState;
        int size = visiblePagesInfo.size();
        boolean z = false;
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= size) {
                break;
            }
            PageInfo pageInfo = visiblePagesInfo.get(i);
            float calculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState.getPageCount());
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f3) {
                f3 = calculateDistanceToDesiredSnapPosition;
            }
            i++;
        }
        if (f2 == Float.NEGATIVE_INFINITY) {
            f2 = f3;
        }
        if (f3 == Float.POSITIVE_INFINITY) {
            f3 = f2;
        }
        if (PagerSnapLayoutInfoProviderKt.dragGestureDelta(this.$pagerState) == 0.0f) {
            z = true;
        }
        if (!this.$pagerState.getCanScrollForward()) {
            if (z || !PagerSnapLayoutInfoProviderKt.isScrollingForward(this.$pagerState)) {
                f3 = 0.0f;
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
        }
        if (this.$pagerState.getCanScrollBackward()) {
            f = f2;
        } else if (!z && !PagerSnapLayoutInfoProviderKt.isScrollingForward(this.$pagerState)) {
            f3 = 0.0f;
        }
        return TuplesKt.to(Float.valueOf(f), Float.valueOf(f3));
    }
}
