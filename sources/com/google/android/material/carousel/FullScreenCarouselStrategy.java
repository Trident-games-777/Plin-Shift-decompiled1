package com.google.android.material.carousel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class FullScreenCarouselStrategy extends CarouselStrategy {
    /* access modifiers changed from: package-private */
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float f;
        int i;
        int i2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (carousel.isHorizontal()) {
            f = (float) carousel.getContainerWidth();
            i = layoutParams.leftMargin;
            i2 = layoutParams.rightMargin;
        } else {
            f = (float) carousel.getContainerHeight();
            i = layoutParams.topMargin;
            i2 = layoutParams.bottomMargin;
        }
        float f2 = (float) (i + i2);
        float f3 = f;
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f2, f3, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(f3 + f2, f3), 1, f3));
    }
}
