package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2$1 extends Lambda implements Function0<TextFieldHandleState> {
    final /* synthetic */ TextFieldSelectionState $selectionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$TextFieldCursorHandle$cursorHandleState$2$1(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.$selectionState = textFieldSelectionState;
    }

    public final TextFieldHandleState invoke() {
        return this.$selectionState.getCursorHandleState$foundation_release(false);
    }
}
