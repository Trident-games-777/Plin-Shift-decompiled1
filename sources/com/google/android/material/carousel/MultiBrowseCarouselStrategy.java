package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    /* access modifiers changed from: package-private */
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float containerHeight = (float) carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
        }
        float f = containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f2 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f3 = f2;
        float smallItemSizeMin = getSmallItemSizeMin() + f3;
        float max = Math.max(getSmallItemSizeMax() + f3, smallItemSizeMin);
        float min = Math.min(measuredHeight + f3, f);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f3, smallItemSizeMin + f3, max + f3);
        float f4 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        if (f < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        }
        int[] iArr2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArr = doubleCounts(iArr);
            iArr2 = doubleCounts(iArr2);
        }
        int[] iArr3 = iArr2;
        float f5 = f4;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr3;
        int ceil = (int) Math.ceil((double) (f / min));
        int max2 = (ceil - ((int) Math.max(1.0d, Math.floor((double) (((f - (((float) CarouselStrategyHelper.maxValue(iArr5)) * f5)) - (((float) CarouselStrategyHelper.maxValue(iArr4)) * max)) / min))))) + 1;
        int[] iArr6 = new int[max2];
        for (int i = 0; i < max2; i++) {
            iArr6[i] = ceil - i;
        }
        float f6 = clamp;
        float f7 = smallItemSizeMin;
        float f8 = f6;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f, f8, f7, max, iArr4, f5, iArr5, min, iArr6);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount())) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f, f8, f7, max, new int[]{findLowestCostArrangement.smallCount}, f5, new int[]{findLowestCostArrangement.mediumCount}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f3, f, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    /* access modifiers changed from: package-private */
    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i) {
        int itemCount = arrangement.getItemCount() - i;
        boolean z = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            if (arrangement.smallCount > 0) {
                arrangement.smallCount--;
            } else if (arrangement.mediumCount > 1) {
                arrangement.mediumCount--;
            }
            itemCount--;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if (i >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
            return i >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
        }
        return true;
    }
}
