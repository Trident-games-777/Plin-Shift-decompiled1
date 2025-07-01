package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$2$1", f = "BasicTextField.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$TextFieldCursorHandle$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$TextFieldCursorHandle$2$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super BasicTextFieldKt$TextFieldCursorHandle$2$1> continuation) {
        super(2, continuation);
        this.$selectionState = textFieldSelectionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BasicTextFieldKt$TextFieldCursorHandle$2$1 basicTextFieldKt$TextFieldCursorHandle$2$1 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(this.$selectionState, continuation);
        basicTextFieldKt$TextFieldCursorHandle$2$1.L$0 = obj;
        return basicTextFieldKt$TextFieldCursorHandle$2$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((BasicTextFieldKt$TextFieldCursorHandle$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextFieldSelectionState textFieldSelectionState = this.$selectionState;
            this.label = 1;
            if (textFieldSelectionState.cursorHandleGestures((PointerInputScope) this.L$0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
