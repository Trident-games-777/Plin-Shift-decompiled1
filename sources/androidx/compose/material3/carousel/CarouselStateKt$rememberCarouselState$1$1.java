package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/carousel/CarouselState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CarouselState.kt */
final class CarouselStateKt$rememberCarouselState$1$1 extends Lambda implements Function0<CarouselState> {
    final /* synthetic */ int $initialItem;
    final /* synthetic */ Function0<Integer> $itemCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselStateKt$rememberCarouselState$1$1(int i, Function0<Integer> function0) {
        super(0);
        this.$initialItem = i;
        this.$itemCount = function0;
    }

    public final CarouselState invoke() {
        return new CarouselState(this.$initialItem, 0.0f, this.$itemCount);
    }
}
