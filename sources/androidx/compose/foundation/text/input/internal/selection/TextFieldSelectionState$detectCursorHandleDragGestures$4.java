package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectCursorHandleDragGestures$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $cursorDragDelta;
    final /* synthetic */ Ref.LongRef $cursorDragStart;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectCursorHandleDragGestures$4(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.$cursorDragStart = longRef;
        this.$cursorDragDelta = longRef2;
        this.this$0 = textFieldSelectionState;
    }

    public final void invoke() {
        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(this.$cursorDragStart, this.$cursorDragDelta, this.this$0);
    }
}
