package coil3.compose;

import coil3.compose.AsyncImagePainter;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$1$2", f = "AsyncImagePainter.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncImagePainter.kt */
final class AsyncImagePainter$onRemembered$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncImagePainter$onRemembered$1$2(AsyncImagePainter asyncImagePainter, Continuation<? super AsyncImagePainter$onRemembered$1$2> continuation) {
        super(2, continuation);
        this.this$0 = asyncImagePainter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$onRemembered$1$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncImagePainter$onRemembered$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/compose/AsyncImagePainter$State;", "it", "Lcoil3/compose/AsyncImagePainter$Input;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.compose.AsyncImagePainter$onRemembered$1$2$2", f = "AsyncImagePainter.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: coil3.compose.AsyncImagePainter$onRemembered$1$2$2  reason: invalid class name */
    /* compiled from: AsyncImagePainter.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<AsyncImagePainter.Input, Continuation<? super AsyncImagePainter.State>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(asyncImagePainter, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AsyncImagePainter.Input input, Continuation<? super AsyncImagePainter.State> continuation) {
            return ((AnonymousClass2) create(input, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            AsyncImagePainter asyncImagePainter;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AsyncImagePainter.Input input = (AsyncImagePainter.Input) this.L$0;
                ImageRequest access$updateRequest = asyncImagePainter.updateRequest(input.getRequest(), false);
                AsyncImagePainter asyncImagePainter2 = asyncImagePainter;
                this.L$0 = asyncImagePainter2;
                this.label = 1;
                obj = input.getImageLoader().execute(access$updateRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                asyncImagePainter = asyncImagePainter2;
            } else if (i == 1) {
                asyncImagePainter = (AsyncImagePainter) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return asyncImagePainter.toState((ImageResult) obj);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow transformLatest = FlowKt.transformLatest(this.this$0.restartSignal, new AsyncImagePainter$onRemembered$1$2$invokeSuspend$$inlined$flatMapLatest$1((Continuation) null, this.this$0));
            final AsyncImagePainter asyncImagePainter = this.this$0;
            Flow mapLatest = FlowKt.mapLatest(transformLatest, new AnonymousClass2((Continuation<? super AnonymousClass2>) null));
            final AsyncImagePainter asyncImagePainter2 = this.this$0;
            this.label = 1;
            if (mapLatest.collect(new Object() {
                public final boolean equals(Object obj) {
                    if (!(obj instanceof FlowCollector) || !(obj instanceof FunctionAdapter)) {
                        return false;
                    }
                    return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
                }

                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, AsyncImagePainter.this, AsyncImagePainter.class, "updateState", "updateState(Lcoil3/compose/AsyncImagePainter$State;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                public final Object emit(AsyncImagePainter.State state, Continuation<? super Unit> continuation) {
                    Object access$invokeSuspend$updateState = AsyncImagePainter.this.updateState(state);
                    return access$invokeSuspend$updateState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$invokeSuspend$updateState : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
