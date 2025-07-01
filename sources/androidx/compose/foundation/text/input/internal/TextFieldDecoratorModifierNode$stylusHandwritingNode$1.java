package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$stylusHandwritingNode$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$stylusHandwritingNode$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, KeyboardOptions keyboardOptions) {
        super(0);
        this.this$0 = textFieldDecoratorModifierNode;
        this.$keyboardOptions = keyboardOptions;
    }

    public final Boolean invoke() {
        MutableSharedFlow access$getStylusHandwritingTrigger;
        if (!this.this$0.isFocused()) {
            FocusRequesterModifierNodeKt.requestFocus(this.this$0);
        }
        if (!KeyboardType.m6794equalsimpl0(this.$keyboardOptions.m1210getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6813getPasswordPjHm6EE()) && !KeyboardType.m6794equalsimpl0(this.$keyboardOptions.m1210getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6812getNumberPasswordPjHm6EE()) && (access$getStylusHandwritingTrigger = this.this$0.getStylusHandwritingTrigger()) != null) {
            access$getStylusHandwritingTrigger.tryEmit(Unit.INSTANCE);
        }
        return true;
    }
}
