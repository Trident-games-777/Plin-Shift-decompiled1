package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Indication.kt */
final class IndicationKt$indication$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Indication $indication;
    final /* synthetic */ InteractionSource $interactionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndicationKt$indication$2(Indication indication, InteractionSource interactionSource) {
        super(3);
        this.$indication = indication;
        this.$interactionSource = interactionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-353972293);
        ComposerKt.sourceInformation(composer, "C183@8965L42,184@9020L79:Indication.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-353972293, i, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:182)");
        }
        IndicationInstance rememberUpdatedInstance = this.$indication.rememberUpdatedInstance(this.$interactionSource, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1774073380, "CC(remember):Indication.kt#9igjgp");
        boolean changed = composer.changed((Object) rememberUpdatedInstance);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new IndicationModifier(rememberUpdatedInstance);
            composer.updateRememberedValue(rememberedValue);
        }
        IndicationModifier indicationModifier = (IndicationModifier) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return indicationModifier;
    }
}
