package coil3.network.okhttp.internal;

import coil3.network.NetworkRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import okhttp3.Call;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.CallFactoryNetworkClient", f = "utils.kt", i = {0, 1}, l = {24, 24, 25}, m = "executeRequest-impl", n = {"block", "block"}, s = {"L$0", "L$0"})
/* compiled from: utils.kt */
final class CallFactoryNetworkClient$executeRequest$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    CallFactoryNetworkClient$executeRequest$1(Continuation<? super CallFactoryNetworkClient$executeRequest$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CallFactoryNetworkClient.m7528executeRequestimpl((Call.Factory) null, (NetworkRequest) null, (Function2) null, this);
    }
}
