package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.Draggable2DNode$onDragStarted$1", f = "Draggable2D.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable2D.kt */
final class Draggable2DNode$onDragStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $startedPosition;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Draggable2DNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Draggable2DNode$onDragStarted$1(Draggable2DNode draggable2DNode, long j, Continuation<? super Draggable2DNode$onDragStarted$1> continuation) {
        super(2, continuation);
        this.this$0 = draggable2DNode;
        this.$startedPosition = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Draggable2DNode$onDragStarted$1 draggable2DNode$onDragStarted$1 = new Draggable2DNode$onDragStarted$1(this.this$0, this.$startedPosition, continuation);
        draggable2DNode$onDragStarted$1.L$0 = obj;
        return draggable2DNode$onDragStarted$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Draggable2DNode$onDragStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3 access$getOnDragStarted$p = this.this$0.onDragStarted;
            Offset r3 = Offset.m3976boximpl(this.$startedPosition);
            this.label = 1;
            if (access$getOnDragStarted$p.invoke((CoroutineScope) this.L$0, r3, this) == coroutine_suspended) {
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
