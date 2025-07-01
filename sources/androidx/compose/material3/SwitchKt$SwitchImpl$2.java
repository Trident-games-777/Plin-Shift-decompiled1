package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$SwitchImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ SwitchColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $thumbContent;
    final /* synthetic */ Shape $thumbShape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$SwitchImpl$2(Modifier modifier, boolean z, boolean z2, SwitchColors switchColors, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, int i) {
        super(2);
        this.$modifier = modifier;
        this.$checked = z;
        this.$enabled = z2;
        this.$colors = switchColors;
        this.$thumbContent = function2;
        this.$interactionSource = interactionSource;
        this.$thumbShape = shape;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SwitchKt.SwitchImpl(this.$modifier, this.$checked, this.$enabled, this.$colors, this.$thumbContent, this.$interactionSource, this.$thumbShape, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
