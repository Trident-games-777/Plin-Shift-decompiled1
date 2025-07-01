package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "position", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$dragAndDropNode$5 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$dragAndDropNode$5(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(1);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1413invokek4lQ0M(((Offset) obj).m3997unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1413invokek4lQ0M(long j) {
        long r2 = TextLayoutStateKt.m1439fromWindowToDecorationUv8p0NA(this.this$0.getTextLayoutState(), j);
        this.this$0.getTextFieldState().m1449selectCharsIn5zctL8(TextRangeKt.TextRange(TextLayoutState.m1429getOffsetForPosition3MmeM6k$default(this.this$0.getTextLayoutState(), r2, false, 2, (Object) null)));
        this.this$0.getTextFieldSelectionState().m1486updateHandleDraggingUv8p0NA(Handle.Cursor, r2);
    }
}
