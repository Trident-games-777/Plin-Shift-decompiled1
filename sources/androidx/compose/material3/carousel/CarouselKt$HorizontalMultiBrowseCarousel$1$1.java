package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/material3/carousel/KeylineList;", "availableSpace", "", "itemSpacingPx", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
final class CarouselKt$HorizontalMultiBrowseCarousel$1$1 extends Lambda implements Function2<Float, Float, KeylineList> {
    final /* synthetic */ Density $density;
    final /* synthetic */ float $maxSmallItemWidth;
    final /* synthetic */ float $minSmallItemWidth;
    final /* synthetic */ float $preferredItemWidth;
    final /* synthetic */ CarouselState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$HorizontalMultiBrowseCarousel$1$1(Density density, float f, CarouselState carouselState, float f2, float f3) {
        super(2);
        this.$density = density;
        this.$preferredItemWidth = f;
        this.$state = carouselState;
        this.$minSmallItemWidth = f2;
        this.$maxSmallItemWidth = f3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
    }

    public final KeylineList invoke(float f, float f2) {
        Density density = this.$density;
        float f3 = this.$preferredItemWidth;
        CarouselState carouselState = this.$state;
        float f4 = this.$minSmallItemWidth;
        float f5 = this.$maxSmallItemWidth;
        float r1 = density.m7091toPx0680j_4(f3);
        int intValue = ((Number) carouselState.getItemCountState().getValue().invoke()).intValue();
        float r5 = density.m7091toPx0680j_4(f4);
        float r6 = density.m7091toPx0680j_4(f5);
        int i = intValue;
        float f6 = r1;
        return KeylinesKt.multiBrowseKeylineList(density, f, f6, f2, i, r5, r6);
    }
}
