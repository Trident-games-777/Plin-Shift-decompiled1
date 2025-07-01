package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$drawModifier$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$drawModifier$1$1(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(1);
        this.$state = legacyTextFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult != null) {
            TextFieldValue textFieldValue = this.$value;
            LegacyTextFieldState legacyTextFieldState = this.$state;
            OffsetMapping offsetMapping = this.$offsetMapping;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
            TextFieldDelegate.Companion.m1265drawQ1vqE60$foundation_release(canvas, textFieldValue, legacyTextFieldState2.m1214getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m1211getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.m1213getSelectionBackgroundColor0d7_KjU());
        }
    }
}
