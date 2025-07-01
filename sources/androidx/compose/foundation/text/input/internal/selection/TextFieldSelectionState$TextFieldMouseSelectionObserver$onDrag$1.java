package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1 extends Lambda implements Function0<String> {
    final /* synthetic */ long $dragPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1(long j) {
        super(0);
        this.$dragPosition = j;
    }

    public final String invoke() {
        return "Mouse.onDrag " + Offset.m3995toStringimpl(this.$dragPosition);
    }
}
