package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2", f = "TextFieldSelectionState.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldTapGestures$2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldTapGestures$2(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2> continuation) {
        super(3, continuation);
        this.$interactionSource = mutableInteractionSource;
        this.this$0 = textFieldSelectionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1500invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3997unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final Object m1500invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectTextFieldTapGestures$2 textFieldSelectionState$detectTextFieldTapGestures$2 = new TextFieldSelectionState$detectTextFieldTapGestures$2(this.$interactionSource, this.this$0, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$2.L$0 = pressGestureScope;
        textFieldSelectionState$detectTextFieldTapGestures$2.J$0 = j;
        return textFieldSelectionState$detectTextFieldTapGestures$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
            long j = this.J$0;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            if (mutableInteractionSource != null) {
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(pressGestureScope, this.this$0, j, mutableInteractionSource, (Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2$1$1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
