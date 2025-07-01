package coil3.compose;

import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0015\u0010\u0005\u001a\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bH\n¨\u0006\t"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "Lkotlin/ParameterName;", "name", "value", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1", f = "AsyncImagePainter.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Merge.kt */
public final class AsyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super AsyncImagePainter.Input>, Unit, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, AsyncImagePainter asyncImagePainter) {
        super(3, continuation);
        this.this$0 = asyncImagePainter;
    }

    public final Object invoke(FlowCollector<? super AsyncImagePainter.Input> flowCollector, Unit unit, Continuation<? super Unit> continuation) {
        AsyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1 asyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1 = new AsyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.this$0);
        asyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = flowCollector;
        asyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = unit;
        return asyncImagePainter$onRemembered$1$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Unit unit = (Unit) this.L$1;
            Flow flow = this.this$0.get_input$coil_compose_core_release();
            this.label = 1;
            if (FlowKt.emitAll((FlowCollector) this.L$0, flow, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
