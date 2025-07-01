package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Carousel.kt */
final class CarouselKt$HorizontalUncontainedCarousel$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function4<CarouselItemScope, Integer, Composer, Integer, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ TargetedFlingBehavior $flingBehavior;
    final /* synthetic */ float $itemSpacing;
    final /* synthetic */ float $itemWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ CarouselState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$HorizontalUncontainedCarousel$2(CarouselState carouselState, float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, PaddingValues paddingValues, Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, int i, int i2) {
        super(2);
        this.$state = carouselState;
        this.$itemWidth = f;
        this.$modifier = modifier;
        this.$itemSpacing = f2;
        this.$flingBehavior = targetedFlingBehavior;
        this.$contentPadding = paddingValues;
        this.$content = function4;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CarouselKt.m2896HorizontalUncontainedCarousel9QcgTRs(this.$state, this.$itemWidth, this.$modifier, this.$itemSpacing, this.$flingBehavior, this.$contentPadding, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
