package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextStringSimpleNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Z)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStringSimpleNode.kt */
final class TextStringSimpleNode$applySemantics$3 extends Lambda implements Function1<Boolean, Boolean> {
    final /* synthetic */ TextStringSimpleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStringSimpleNode$applySemantics$3(TextStringSimpleNode textStringSimpleNode) {
        super(1);
        this.this$0 = textStringSimpleNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    public final Boolean invoke(boolean z) {
        if (this.this$0.textSubstitution == null) {
            return false;
        }
        TextStringSimpleNode.TextSubstitutionValue access$getTextSubstitution$p = this.this$0.textSubstitution;
        if (access$getTextSubstitution$p != null) {
            access$getTextSubstitution$p.setShowingSubstitution(z);
        }
        this.this$0.invalidateForTranslate();
        return true;
    }
}
