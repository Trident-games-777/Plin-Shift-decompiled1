package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
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
final class CarouselKt$Carousel$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function4<CarouselItemScope, Integer, Composer, Integer, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ TargetedFlingBehavior $flingBehavior;
    final /* synthetic */ float $itemSpacing;
    final /* synthetic */ Function2<Float, Float, KeylineList> $keylineList;
    final /* synthetic */ int $maxNonFocalVisibleItemCount;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ CarouselState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarouselKt$Carousel$3(CarouselState carouselState, Orientation orientation, Function2<? super Float, ? super Float, KeylineList> function2, PaddingValues paddingValues, int i, Modifier modifier, float f, TargetedFlingBehavior targetedFlingBehavior, Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, int i2, int i3) {
        super(2);
        this.$state = carouselState;
        this.$orientation = orientation;
        this.$keylineList = function2;
        this.$contentPadding = paddingValues;
        this.$maxNonFocalVisibleItemCount = i;
        this.$modifier = modifier;
        this.$itemSpacing = f;
        this.$flingBehavior = targetedFlingBehavior;
        this.$content = function4;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CarouselKt.m2894CarouselV95POc(this.$state, this.$orientation, this.$keylineList, this.$contentPadding, this.$maxNonFocalVisibleItemCount, this.$modifier, this.$itemSpacing, this.$flingBehavior, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
