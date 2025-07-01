package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HeightInLinesModifier.kt */
final class HeightInLinesModifierKt$heightInLines$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightInLinesModifierKt$heightInLines$2(int i, int i2, TextStyle textStyle) {
        super(3);
        this.$minLines = i;
        this.$maxLines = i2;
        this.$textStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(408240218);
        ComposerKt.sourceInformation(composer, "C62@2391L7,63@2452L7,64@2507L7,68@2678L96,71@2795L312,80@3135L366,96@3533L428:HeightInLinesModifier.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(408240218, i, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:59)");
        }
        HeightInLinesModifierKt.validateMinMaxLines(this.$minLines, this.$maxLines);
        if (this.$minLines == 1 && this.$maxLines == Integer.MAX_VALUE) {
            Modifier.Companion companion = Modifier.Companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd(composer);
        FontFamily.Resolver resolver = (FontFamily.Resolver) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(composer, -1954450869, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean changed = composer.changed((Object) this.$textStyle) | composer.changed((Object) layoutDirection);
        TextStyle textStyle = this.$textStyle;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer.updateRememberedValue(rememberedValue);
        }
        TextStyle textStyle2 = (TextStyle) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1954446909, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean changed2 = composer.changed((Object) resolver) | composer.changed((Object) textStyle2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = textStyle2.getFontFamily();
            FontWeight fontWeight = textStyle2.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r7 = textStyle2.m6596getFontStyle4Lr2A7w();
            int r72 = r7 != null ? r7.m6681unboximpl() : FontStyle.Companion.m6685getNormal_LCdwA();
            FontSynthesis r8 = textStyle2.m6597getFontSynthesisZQGJjVo();
            rememberedValue2 = resolver.m6652resolveDPcqOEQ(fontFamily, fontWeight, r72, r8 != null ? r8.m6694unboximpl() : FontSynthesis.Companion.m6695getAllGVVA2EU());
            composer.updateRememberedValue(rememberedValue2);
        }
        State state = (State) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object invoke$lambda$2 = invoke$lambda$2(state);
        ComposerKt.sourceInformationMarkerStart(composer, -1954435975, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean changed3 = composer.changed(invoke$lambda$2) | composer.changed((Object) density) | composer.changed((Object) resolver) | composer.changed((Object) this.$textStyle) | composer.changed((Object) layoutDirection);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = Integer.valueOf(IntSize.m7282getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
            composer.updateRememberedValue(rememberedValue3);
        }
        int intValue = ((Number) rememberedValue3).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object invoke$lambda$22 = invoke$lambda$2(state);
        ComposerKt.sourceInformationMarkerStart(composer, -1954423177, "CC(remember):HeightInLinesModifier.kt#9igjgp");
        boolean changed4 = composer.changed((Object) layoutDirection) | composer.changed((Object) density) | composer.changed((Object) resolver) | composer.changed((Object) this.$textStyle) | composer.changed(invoke$lambda$22);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = Integer.valueOf(IntSize.m7282getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + 10 + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
            composer.updateRememberedValue(rememberedValue4);
        }
        int intValue2 = ((Number) rememberedValue4).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = intValue2 - intValue;
        int i3 = this.$minLines;
        Integer num = null;
        Integer valueOf = i3 == 1 ? null : Integer.valueOf(((i3 - 1) * i2) + intValue);
        int i4 = this.$maxLines;
        if (i4 != Integer.MAX_VALUE) {
            num = Integer.valueOf(intValue + (i2 * (i4 - 1)));
        }
        Modifier r10 = SizeKt.m832heightInVpY3zN4(Modifier.Companion, valueOf != null ? density.m7088toDpu2uoSUM(valueOf.intValue()) : Dp.Companion.m7131getUnspecifiedD9Ej5fM(), num != null ? density.m7088toDpu2uoSUM(num.intValue()) : Dp.Companion.m7131getUnspecifiedD9Ej5fM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return r10;
    }

    private static final Object invoke$lambda$2(State<? extends Object> state) {
        return state.getValue();
    }
}
