package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$2", f = "NetworkFetcher.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* compiled from: NetworkFetcher.kt */
final class NetworkFetcher$fetch$2 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkFetcher$fetch$2(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$fetch$2> continuation) {
        super(2, continuation);
        this.this$0 = networkFetcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkFetcher$fetch$2 networkFetcher$fetch$2 = new NetworkFetcher$fetch$2(this.this$0, continuation);
        networkFetcher$fetch$2.L$0 = obj;
        return networkFetcher$fetch$2;
    }

    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return ((NetworkFetcher$fetch$2) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NetworkResponse networkResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse2 = (NetworkResponse) this.L$0;
            this.L$0 = networkResponse2;
            this.label = 1;
            Object access$toImageSource = this.this$0.toImageSource(UtilsKt.requireBody(networkResponse2), this);
            if (access$toImageSource == coroutine_suspended) {
                return coroutine_suspended;
            }
            networkResponse = networkResponse2;
            obj = access$toImageSource;
        } else if (i == 1) {
            networkResponse = (NetworkResponse) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkFetcher networkFetcher = this.this$0;
        return new SourceFetchResult((ImageSource) obj, networkFetcher.getMimeType(networkFetcher.url, networkResponse.getHeaders().get("Content-Type")), DataSource.NETWORK);
    }
}
