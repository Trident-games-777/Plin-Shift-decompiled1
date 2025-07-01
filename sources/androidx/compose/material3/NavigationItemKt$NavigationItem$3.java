package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationItem.kt */
final class NavigationItemKt$NavigationItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $badge;
    final /* synthetic */ NavigationItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ int $iconPosition;
    final /* synthetic */ float $indicatorHorizontalPadding;
    final /* synthetic */ Shape $indicatorShape;
    final /* synthetic */ float $indicatorToLabelVerticalPadding;
    final /* synthetic */ float $indicatorVerticalPadding;
    final /* synthetic */ float $indicatorWidth;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ float $startIconToLabelHorizontalPadding;
    final /* synthetic */ float $topIconItemVerticalPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationItemKt$NavigationItem$3(boolean z, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Shape shape, float f, float f2, float f3, float f4, float f5, float f6, NavigationItemColors navigationItemColors, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, MutableInteractionSource mutableInteractionSource, int i2, int i3) {
        super(2);
        this.$selected = z;
        this.$onClick = function0;
        this.$icon = function2;
        this.$labelTextStyle = textStyle;
        this.$indicatorShape = shape;
        this.$indicatorWidth = f;
        this.$indicatorHorizontalPadding = f2;
        this.$indicatorVerticalPadding = f3;
        this.$indicatorToLabelVerticalPadding = f4;
        this.$startIconToLabelHorizontalPadding = f5;
        this.$topIconItemVerticalPadding = f6;
        this.$colors = navigationItemColors;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$label = function22;
        this.$badge = function23;
        this.$iconPosition = i;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i2;
        this.$$changed1 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        boolean z = this.$selected;
        boolean z2 = z;
        NavigationItemKt.m2290NavigationItemSHbi2eg(z2, this.$onClick, this.$icon, this.$labelTextStyle, this.$indicatorShape, this.$indicatorWidth, this.$indicatorHorizontalPadding, this.$indicatorVerticalPadding, this.$indicatorToLabelVerticalPadding, this.$startIconToLabelHorizontalPadding, this.$topIconItemVerticalPadding, this.$colors, this.$modifier, this.$enabled, this.$label, this.$badge, this.$iconPosition, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
