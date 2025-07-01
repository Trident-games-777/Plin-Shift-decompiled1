package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.OffsetProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "provide-F1C5BW0", "()J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$TextFieldCursorHandle$1$1 implements OffsetProvider {
    final /* synthetic */ TextFieldSelectionState $selectionState;

    BasicTextFieldKt$TextFieldCursorHandle$1$1(TextFieldSelectionState textFieldSelectionState) {
        this.$selectionState = textFieldSelectionState;
    }

    /* renamed from: provide-F1C5BW0  reason: not valid java name */
    public final long m1158provideF1C5BW0() {
        return this.$selectionState.getCursorHandleState$foundation_release(true).m1460getPositionF1C5BW0();
    }
}
