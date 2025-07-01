package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4", f = "Clickable.kt", i = {}, l = {787}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Clickable.kt */
final class CombinedClickableNodeImpl$clickPointerInput$4 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CombinedClickableNodeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombinedClickableNodeImpl$clickPointerInput$4(CombinedClickableNodeImpl combinedClickableNodeImpl, Continuation<? super CombinedClickableNodeImpl$clickPointerInput$4> continuation) {
        super(3, continuation);
        this.this$0 = combinedClickableNodeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m302invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3997unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final Object m302invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        CombinedClickableNodeImpl$clickPointerInput$4 combinedClickableNodeImpl$clickPointerInput$4 = new CombinedClickableNodeImpl$clickPointerInput$4(this.this$0, continuation);
        combinedClickableNodeImpl$clickPointerInput$4.L$0 = pressGestureScope;
        combinedClickableNodeImpl$clickPointerInput$4.J$0 = j;
        return combinedClickableNodeImpl$clickPointerInput$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
            long j = this.J$0;
            if (this.this$0.getEnabled()) {
                this.label = 1;
                if (this.this$0.m219handlePressInteractiond4ec7I(pressGestureScope, j, this) == coroutine_suspended) {
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
