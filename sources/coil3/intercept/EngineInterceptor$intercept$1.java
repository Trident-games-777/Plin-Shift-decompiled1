package coil3.intercept;

import coil3.intercept.Interceptor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0}, l = {65}, m = "intercept", n = {"chain"}, s = {"L$0"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$intercept$1(EngineInterceptor engineInterceptor, Continuation<? super EngineInterceptor$intercept$1> continuation) {
        super(continuation);
        this.this$0 = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.intercept((Interceptor.Chain) null, this);
    }
}
