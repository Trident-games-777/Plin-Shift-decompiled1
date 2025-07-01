package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "averageItemSize", "", "getAverageItemSize", "()I", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "calculateApproachOffset", "", "velocity", "decayOffset", "calculateSnapOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSnapLayoutInfoProvider.kt */
public final class LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ SnapPosition $snapPosition;

    LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(LazyGridState lazyGridState, SnapPosition snapPosition) {
        this.$lazyGridState = lazyGridState;
        this.$snapPosition = snapPosition;
    }

    private final LazyGridLayoutInfo getLayoutInfo() {
        return this.$lazyGridState.getLayoutInfo();
    }

    private final int getAverageItemSize() {
        LazyGridLayoutInfo layoutInfo = getLayoutInfo();
        int i = 0;
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        int size = layoutInfo.getVisibleItemsInfo().size();
        for (LazyGridItemInfo sizeOnMainAxis : layoutInfo.getVisibleItemsInfo()) {
            i += LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(sizeOnMainAxis, layoutInfo.getOrientation());
        }
        return i / size;
    }

    public float calculateApproachOffset(float f, float f2) {
        return RangesKt.coerceAtLeast(Math.abs(f2) - ((float) getAverageItemSize()), 0.0f) * Math.signum(f2);
    }

    public float calculateSnapOffset(float f) {
        List<LazyGridItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
        SnapPosition snapPosition = this.$snapPosition;
        int size = visibleItemsInfo.size();
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
            float calculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), lazyGridItemInfo.getIndex(), snapPosition, getLayoutInfo().getTotalItemsCount());
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f3) {
                f3 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return SnapFlingBehaviorKt.m587calculateFinalOffsetFhqu1e0(LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(this.$lazyGridState.getDensity$foundation_release(), f), f2, f3);
    }
}
