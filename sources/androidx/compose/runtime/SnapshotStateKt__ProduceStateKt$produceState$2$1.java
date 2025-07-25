package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2$1", f = "ProduceState.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProduceState.kt */
final class SnapshotStateKt__ProduceStateKt$produceState$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
    final /* synthetic */ MutableState<T> $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__ProduceStateKt$produceState$2$1(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, MutableState<T> mutableState, Continuation<? super SnapshotStateKt__ProduceStateKt$produceState$2$1> continuation) {
        super(2, continuation);
        this.$producer = function2;
        this.$result = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__ProduceStateKt$produceState$2$1 snapshotStateKt__ProduceStateKt$produceState$2$1 = new SnapshotStateKt__ProduceStateKt$produceState$2$1(this.$producer, this.$result, continuation);
        snapshotStateKt__ProduceStateKt$produceState$2$1.L$0 = obj;
        return snapshotStateKt__ProduceStateKt$produceState$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__ProduceStateKt$produceState$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> function2 = this.$producer;
            ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, ((CoroutineScope) this.L$0).getCoroutineContext());
            this.label = 1;
            if (function2.invoke(produceStateScopeImpl, this) == coroutine_suspended) {
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
