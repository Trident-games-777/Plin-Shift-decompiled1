package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Draggable2DNode$onDragStopped$1", f = "Draggable2D.kt", i = {}, l = {436}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable2D.kt */
final class Draggable2DNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Draggable2DNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Draggable2DNode$onDragStopped$1(Draggable2DNode draggable2DNode, long j, Continuation<? super Draggable2DNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = draggable2DNode;
        this.$velocity = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Draggable2DNode$onDragStopped$1 draggable2DNode$onDragStopped$1 = new Draggable2DNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
        draggable2DNode$onDragStopped$1.L$0 = obj;
        return draggable2DNode$onDragStopped$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Draggable2DNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3 access$getOnDragStopped$p = this.this$0.onDragStopped;
            Velocity r3 = Velocity.m7341boximpl(this.this$0.m475reverseIfNeededAH228Gc(this.$velocity));
            this.label = 1;
            if (access$getOnDragStopped$p.invoke((CoroutineScope) this.L$0, r3, this) == coroutine_suspended) {
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
