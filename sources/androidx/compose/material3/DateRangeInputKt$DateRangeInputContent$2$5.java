package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
final class DateRangeInputKt$DateRangeInputContent$2$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $endRangeText;
    final /* synthetic */ String $pattern;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangeInputKt$DateRangeInputContent$2$5(String str, String str2) {
        super(2);
        this.$endRangeText = str;
        this.$pattern = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C105@4617L50,103@4527L158:DateRangeInput.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(911487285, i2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:103)");
            }
            String str = this.$endRangeText;
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer2, -1505852885, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed = composer2.changed((Object) this.$endRangeText) | composer2.changed((Object) this.$pattern);
            String str2 = this.$endRangeText;
            String str3 = this.$pattern;
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangeInputKt$DateRangeInputContent$2$5$1$1(str2, str3);
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextKt.m2692Text4IGK_g(str, SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer2.skipToGroupEnd();
    }
}
