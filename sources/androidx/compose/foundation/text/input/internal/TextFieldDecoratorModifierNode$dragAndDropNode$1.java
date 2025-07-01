package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.MediaType;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/content/MediaType;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$dragAndDropNode$1 extends Lambda implements Function0<Set<? extends MediaType>> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$dragAndDropNode$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(0);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public final Set<MediaType> invoke() {
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0) != null) {
            return TextFieldDecoratorModifierKt.MediaTypesAll;
        }
        return TextFieldDecoratorModifierKt.MediaTypesText;
    }
}
