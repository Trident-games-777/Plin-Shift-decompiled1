package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
final class StatelessInputConnection$deleteSurroundingText$1 extends Lambda implements Function1<EditingBuffer, Unit> {
    final /* synthetic */ int $afterLength;
    final /* synthetic */ int $beforeLength;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StatelessInputConnection$deleteSurroundingText$1(int i, int i2) {
        super(1);
        this.$beforeLength = i;
        this.$afterLength = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EditingBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EditingBuffer editingBuffer) {
        EditCommandKt.deleteSurroundingText(editingBuffer, this.$beforeLength, this.$afterLength);
    }
}
