package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
public final class TextFieldSelectionState$menuItem$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextToolbarState $desiredState;
    final /* synthetic */ Function0<Unit> $operation;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$menuItem$1(Function0<Unit> function0, TextFieldSelectionState textFieldSelectionState, TextToolbarState textToolbarState) {
        super(0);
        this.$operation = function0;
        this.this$0 = textFieldSelectionState;
        this.$desiredState = textToolbarState;
    }

    public final void invoke() {
        this.$operation.invoke();
        this.this$0.updateTextToolbarState(this.$desiredState);
    }
}
