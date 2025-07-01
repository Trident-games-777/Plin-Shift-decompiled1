package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/carousel/Strategy;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
final class CarouselKt$Carousel$1$1$1 extends Lambda implements Function0<Strategy> {
    final /* synthetic */ CarouselPageSize $pageSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$Carousel$1$1$1(CarouselPageSize carouselPageSize) {
        super(0);
        this.$pageSize = carouselPageSize;
    }

    public final Strategy invoke() {
        return this.$pageSize.getStrategy();
    }
}
