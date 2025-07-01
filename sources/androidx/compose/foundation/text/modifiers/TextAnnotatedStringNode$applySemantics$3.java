package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Z)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextAnnotatedStringNode.kt */
final class TextAnnotatedStringNode$applySemantics$3 extends Lambda implements Function1<Boolean, Boolean> {
    final /* synthetic */ TextAnnotatedStringNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextAnnotatedStringNode$applySemantics$3(TextAnnotatedStringNode textAnnotatedStringNode) {
        super(1);
        this.this$0 = textAnnotatedStringNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    public final Boolean invoke(boolean z) {
        if (this.this$0.getTextSubstitution$foundation_release() == null) {
            return false;
        }
        Function1 access$getOnShowTranslation$p = this.this$0.onShowTranslation;
        if (access$getOnShowTranslation$p != null) {
            TextAnnotatedStringNode.TextSubstitutionValue textSubstitution$foundation_release = this.this$0.getTextSubstitution$foundation_release();
            Intrinsics.checkNotNull(textSubstitution$foundation_release);
            access$getOnShowTranslation$p.invoke(textSubstitution$foundation_release);
        }
        TextAnnotatedStringNode.TextSubstitutionValue textSubstitution$foundation_release2 = this.this$0.getTextSubstitution$foundation_release();
        if (textSubstitution$foundation_release2 != null) {
            textSubstitution$foundation_release2.setShowingSubstitution(z);
        }
        this.this$0.invalidateForTranslate();
        return true;
    }
}
