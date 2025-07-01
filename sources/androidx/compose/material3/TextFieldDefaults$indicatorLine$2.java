package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
final class TextFieldDefaults$indicatorLine$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ float $focusedIndicatorLineThickness;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ float $unfocusedIndicatorLineThickness;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDefaults$indicatorLine$2(InteractionSource interactionSource, boolean z, boolean z2, TextFieldColors textFieldColors, float f, float f2) {
        super(3);
        this.$interactionSource = interactionSource;
        this.$enabled = z;
        this.$isError = z2;
        this.$colors = textFieldColors;
        this.$focusedIndicatorLineThickness = f;
        this.$unfocusedIndicatorLineThickness = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-891038934);
        ComposerKt.sourceInformation(composer, "C169@7666L25,171@7739L263:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-891038934, i, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:169)");
        }
        Composer composer2 = composer;
        Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.Companion, TextFieldImplKt.m2999animateBorderStrokeAsStateNuRrP5Q(this.$enabled, this.$isError, FocusInteractionKt.collectIsFocusedAsState(this.$interactionSource, composer, 0).getValue().booleanValue(), this.$colors, this.$focusedIndicatorLineThickness, this.$unfocusedIndicatorLineThickness, composer2, 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return drawIndicatorLine;
    }
}
