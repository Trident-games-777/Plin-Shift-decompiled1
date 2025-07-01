package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
final class TransformedTextFieldState$codepointTransformedText$1$1 extends Lambda implements Function0<TransformedTextFieldState.TransformedText> {
    final /* synthetic */ CodepointTransformation $transformation;
    final /* synthetic */ TransformedTextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformedTextFieldState$codepointTransformedText$1$1(TransformedTextFieldState transformedTextFieldState, CodepointTransformation codepointTransformation) {
        super(0);
        this.this$0 = transformedTextFieldState;
        this.$transformation = codepointTransformation;
    }

    public final TransformedTextFieldState.TransformedText invoke() {
        TextFieldCharSequence textFieldCharSequence;
        TransformedTextFieldState.TransformedText transformedText;
        TransformedTextFieldState.Companion access$getCompanion$p = TransformedTextFieldState.Companion;
        State access$getOutputTransformedText$p = this.this$0.outputTransformedText;
        if (access$getOutputTransformedText$p == null || (transformedText = (TransformedTextFieldState.TransformedText) access$getOutputTransformedText$p.getValue()) == null || (textFieldCharSequence = transformedText.getText()) == null) {
            textFieldCharSequence = this.this$0.textFieldState.getValue$foundation_release();
        }
        return access$getCompanion$p.calculateTransformedText(textFieldCharSequence, this.$transformation, this.this$0.getSelectionWedgeAffinity());
    }
}
