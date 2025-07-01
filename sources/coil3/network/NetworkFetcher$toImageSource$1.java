package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0}, l = {247}, m = "toImageSource", n = {"this"}, s = {"L$0"})
/* compiled from: NetworkFetcher.kt */
final class NetworkFetcher$toImageSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkFetcher$toImageSource$1(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$toImageSource$1> continuation) {
        super(continuation);
        this.this$0 = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.toImageSource((NetworkResponseBody) null, this);
    }
}
