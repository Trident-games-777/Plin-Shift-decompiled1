package coil3.network;

import coil3.disk.DiskCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {141, 156}, m = "writeToDiskCache", n = {"this", "snapshot", "networkResponse", "networkResponse", "modifiedNetworkResponse", "editor"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: NetworkFetcher.kt */
final class NetworkFetcher$writeToDiskCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkFetcher$writeToDiskCache$1(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$writeToDiskCache$1> continuation) {
        super(continuation);
        this.this$0 = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeToDiskCache((DiskCache.Snapshot) null, (NetworkResponse) null, (NetworkRequest) null, (NetworkResponse) null, this);
    }
}
