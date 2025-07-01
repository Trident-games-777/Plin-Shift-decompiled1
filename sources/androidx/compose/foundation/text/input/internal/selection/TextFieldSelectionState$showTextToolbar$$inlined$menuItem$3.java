package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "androidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$menuItem$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
public final class TextFieldSelectionState$showTextToolbar$$inlined$menuItem$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextToolbarState $desiredState;
    final /* synthetic */ TextFieldSelectionState this$0;
    final /* synthetic */ TextFieldSelectionState this$0$inline_fun;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$showTextToolbar$$inlined$menuItem$3(TextFieldSelectionState textFieldSelectionState, TextToolbarState textToolbarState, TextFieldSelectionState textFieldSelectionState2) {
        super(0);
        this.this$0$inline_fun = textFieldSelectionState;
        this.$desiredState = textToolbarState;
        this.this$0 = textFieldSelectionState2;
    }

    public final void invoke() {
        this.this$0.cut();
        this.this$0$inline_fun.updateTextToolbarState(this.$desiredState);
    }
}
