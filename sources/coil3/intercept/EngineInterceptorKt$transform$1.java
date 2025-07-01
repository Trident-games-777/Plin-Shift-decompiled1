package coil3.intercept;

import coil3.EventListener;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.util.Logger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptorKt", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0}, l = {54}, m = "transform", n = {"result", "request", "options", "eventListener", "$this$foldIndices$iv", "i$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptorKt$transform$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    EngineInterceptorKt$transform$1(Continuation<? super EngineInterceptorKt$transform$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EngineInterceptorKt.transform((EngineInterceptor.ExecuteResult) null, (ImageRequest) null, (Options) null, (EventListener) null, (Logger) null, this);
    }
}
