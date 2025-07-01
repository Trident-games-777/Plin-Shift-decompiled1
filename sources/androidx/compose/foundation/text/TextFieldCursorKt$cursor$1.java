package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1(Brush brush, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.$cursorBrush = brush;
        this.$state = legacyTextFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        composer.startReplaceGroup(-84507373);
        ComposerKt.sourceInformation(composer, "C45@1789L35,51@2211L7:TextFieldCursor.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:45)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1411529727, "CC(remember):TextFieldCursor.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CursorAnimationState();
            composer.updateRememberedValue(rememberedValue);
        }
        CursorAnimationState cursorAnimationState = (CursorAnimationState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Brush brush = this.$cursorBrush;
        boolean z = !(brush instanceof SolidColor) || ((SolidColor) brush).m4616getValue0d7_KjU() != 16;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalWindowInfo());
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (!((WindowInfo) consume).isWindowFocused() || !this.$state.getHasFocus() || !TextRange.m6558getCollapsedimpl(this.$value.m6823getSelectiond9O1mEE()) || !z) {
            composer.startReplaceGroup(809534830);
            composer.endReplaceGroup();
            modifier2 = Modifier.Companion;
        } else {
            composer.startReplaceGroup(808320157);
            ComposerKt.sourceInformation(composer, "53@2392L65,53@2337L120,56@2482L1096");
            AnnotatedString annotatedString = this.$value.getAnnotatedString();
            TextRange r1 = TextRange.m6552boximpl(this.$value.m6823getSelectiond9O1mEE());
            ComposerKt.sourceInformationMarkerStart(composer, 1411549053, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(cursorAnimationState);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, (Continuation<? super TextFieldCursorKt$cursor$1$1$1>) null);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(annotatedString, r1, (Function2) rememberedValue2, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1411552964, "CC(remember):TextFieldCursor.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(this.$offsetMapping) | composer.changed((Object) this.$value) | composer.changedInstance(this.$state) | composer.changed((Object) this.$cursorBrush);
            OffsetMapping offsetMapping = this.$offsetMapping;
            TextFieldValue textFieldValue = this.$value;
            LegacyTextFieldState legacyTextFieldState = this.$state;
            Brush brush2 = this.$cursorBrush;
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new TextFieldCursorKt$cursor$1$2$1(cursorAnimationState, offsetMapping, textFieldValue, legacyTextFieldState, brush2);
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            modifier2 = DrawModifierKt.drawWithContent(modifier, (Function1) rememberedValue3);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifier2;
    }
}
