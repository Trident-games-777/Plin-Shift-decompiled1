package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationItem.kt */
final class NavigationItemKt$NavigationItemLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ Function0<Float> $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ int $iconPosition;
    final /* synthetic */ long $indicatorColor;
    final /* synthetic */ float $indicatorHorizontalPadding;
    final /* synthetic */ Shape $indicatorShape;
    final /* synthetic */ float $indicatorToLabelVerticalPadding;
    final /* synthetic */ float $indicatorVerticalPadding;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ float $startIconToLabelHorizontalPadding;
    final /* synthetic */ float $topIconItemVerticalPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationItemKt$NavigationItemLayout$2(InteractionSource interactionSource, long j, Shape shape, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function0<Float> function0, float f, float f2, float f3, float f4, float f5, int i2, int i3) {
        super(2);
        this.$interactionSource = interactionSource;
        this.$indicatorColor = j;
        this.$indicatorShape = shape;
        this.$icon = function2;
        this.$iconPosition = i;
        this.$label = function22;
        this.$animationProgress = function0;
        this.$indicatorHorizontalPadding = f;
        this.$indicatorVerticalPadding = f2;
        this.$indicatorToLabelVerticalPadding = f3;
        this.$startIconToLabelHorizontalPadding = f4;
        this.$topIconItemVerticalPadding = f5;
        this.$$changed = i2;
        this.$$changed1 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationItemKt.m2291NavigationItemLayoutKmRXDg(this.$interactionSource, this.$indicatorColor, this.$indicatorShape, this.$icon, this.$iconPosition, this.$label, this.$animationProgress, this.$indicatorHorizontalPadding, this.$indicatorVerticalPadding, this.$indicatorToLabelVerticalPadding, this.$startIconToLabelHorizontalPadding, this.$topIconItemVerticalPadding, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
