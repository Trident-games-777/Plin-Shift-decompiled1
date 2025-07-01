package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
final class WindowInsetsPaddingKt$consumeWindowInsets$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ WindowInsets $insets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInsetsPaddingKt$consumeWindowInsets$2(WindowInsets windowInsets) {
        super(3);
        this.$insets = windowInsets;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(788931215);
        ComposerKt.sourceInformation(composer, "C81@3188L57:WindowInsetsPadding.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(788931215, i, -1, "androidx.compose.foundation.layout.consumeWindowInsets.<anonymous> (WindowInsetsPadding.kt:81)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -261086064, "CC(remember):WindowInsetsPadding.kt#9igjgp");
        boolean changed = composer.changed((Object) this.$insets);
        WindowInsets windowInsets = this.$insets;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new UnionInsetsConsumingModifier(windowInsets);
            composer.updateRememberedValue(rememberedValue);
        }
        UnionInsetsConsumingModifier unionInsetsConsumingModifier = (UnionInsetsConsumingModifier) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return unionInsetsConsumingModifier;
    }
}
