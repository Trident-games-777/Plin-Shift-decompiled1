package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
final class TransformedTextFieldState$outputTransformedText$1$1 extends Lambda implements Function0<TransformedTextFieldState.TransformedText> {
    final /* synthetic */ OutputTransformation $transformation;
    final /* synthetic */ TransformedTextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformedTextFieldState$outputTransformedText$1$1(TransformedTextFieldState transformedTextFieldState, OutputTransformation outputTransformation) {
        super(0);
        this.this$0 = transformedTextFieldState;
        this.$transformation = outputTransformation;
    }

    public final TransformedTextFieldState.TransformedText invoke() {
        return TransformedTextFieldState.Companion.calculateTransformedText(this.this$0.textFieldState.getValue$foundation_release(), this.$transformation, this.this$0.getSelectionWedgeAffinity());
    }
}
