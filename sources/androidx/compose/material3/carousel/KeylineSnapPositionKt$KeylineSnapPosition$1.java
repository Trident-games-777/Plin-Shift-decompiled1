package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"androidx/compose/material3/carousel/KeylineSnapPositionKt$KeylineSnapPosition$1", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeylineSnapPosition.kt */
public final class KeylineSnapPositionKt$KeylineSnapPosition$1 implements SnapPosition {
    final /* synthetic */ CarouselPageSize $pageSize;

    KeylineSnapPositionKt$KeylineSnapPosition$1(CarouselPageSize carouselPageSize) {
        this.$pageSize = carouselPageSize;
    }

    public int position(int i, int i2, int i3, int i4, int i5, int i6) {
        return KeylineSnapPositionKt.getSnapPositionOffset(this.$pageSize.getStrategy(), i5, i6);
    }
}
