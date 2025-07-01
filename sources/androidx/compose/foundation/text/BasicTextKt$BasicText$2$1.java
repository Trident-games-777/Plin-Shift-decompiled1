package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "substitutionValue", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$2$1 extends Lambda implements Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit> {
    final /* synthetic */ MutableState<AnnotatedString> $displayedText$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$2$1(MutableState<AnnotatedString> mutableState) {
        super(1);
        this.$displayedText$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextAnnotatedStringNode.TextSubstitutionValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
        AnnotatedString annotatedString;
        MutableState<AnnotatedString> mutableState = this.$displayedText$delegate;
        if (textSubstitutionValue.isShowingSubstitution()) {
            annotatedString = textSubstitutionValue.getSubstitution();
        } else {
            annotatedString = textSubstitutionValue.getOriginal();
        }
        BasicTextKt.BasicText_RWo7tUw$lambda$6(mutableState, annotatedString);
    }
}
