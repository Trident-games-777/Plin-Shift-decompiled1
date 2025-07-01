package coil3.network;

import coil3.disk.DiskCache;
import coil3.fetch.SourceFetchResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$fetchResult$1", f = "NetworkFetcher.kt", i = {0, 1}, l = {79, 90}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
/* compiled from: NetworkFetcher.kt */
final class NetworkFetcher$fetch$fetchResult$1 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<NetworkResponse> $cacheResponse;
    final /* synthetic */ NetworkRequest $networkRequest;
    final /* synthetic */ Ref.ObjectRef<DiskCache.Snapshot> $snapshot;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkFetcher$fetch$fetchResult$1(Ref.ObjectRef<DiskCache.Snapshot> objectRef, NetworkFetcher networkFetcher, Ref.ObjectRef<NetworkResponse> objectRef2, NetworkRequest networkRequest, Continuation<? super NetworkFetcher$fetch$fetchResult$1> continuation) {
        super(2, continuation);
        this.$snapshot = objectRef;
        this.this$0 = networkFetcher;
        this.$cacheResponse = objectRef2;
        this.$networkRequest = networkRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(this.$snapshot, this.this$0, this.$cacheResponse, this.$networkRequest, continuation);
        networkFetcher$fetch$fetchResult$1.L$0 = obj;
        return networkFetcher$fetch$fetchResult$1;
    }

    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return ((NetworkFetcher$fetch$fetchResult$1) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: coil3.network.NetworkResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "Content-Type"
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x002e
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            java.lang.Object r0 = r12.L$0
            coil3.network.NetworkResponse r0 = (coil3.network.NetworkResponse) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00bc
        L_0x001a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0022:
            java.lang.Object r1 = r12.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r4 = r12.L$0
            coil3.network.NetworkResponse r4 = (coil3.network.NetworkResponse) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0059
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r10 = r13
            coil3.network.NetworkResponse r10 = (coil3.network.NetworkResponse) r10
            kotlin.jvm.internal.Ref$ObjectRef<coil3.disk.DiskCache$Snapshot> r1 = r12.$snapshot
            coil3.network.NetworkFetcher r6 = r12.this$0
            T r13 = r1.element
            r7 = r13
            coil3.disk.DiskCache$Snapshot r7 = (coil3.disk.DiskCache.Snapshot) r7
            kotlin.jvm.internal.Ref$ObjectRef<coil3.network.NetworkResponse> r13 = r12.$cacheResponse
            T r13 = r13.element
            r8 = r13
            coil3.network.NetworkResponse r8 = (coil3.network.NetworkResponse) r8
            coil3.network.NetworkRequest r9 = r12.$networkRequest
            r11 = r12
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r12.L$0 = r10
            r12.L$1 = r1
            r12.label = r4
            java.lang.Object r13 = r6.writeToDiskCache(r7, r8, r9, r10, r11)
            if (r13 != r0) goto L_0x0058
            goto L_0x00ba
        L_0x0058:
            r4 = r10
        L_0x0059:
            r1.element = r13
            kotlin.jvm.internal.Ref$ObjectRef<coil3.disk.DiskCache$Snapshot> r13 = r12.$snapshot
            T r13 = r13.element
            if (r13 == 0) goto L_0x00a7
            kotlin.jvm.internal.Ref$ObjectRef<coil3.network.NetworkResponse> r13 = r12.$cacheResponse
            coil3.network.NetworkFetcher r0 = r12.this$0
            kotlin.jvm.internal.Ref$ObjectRef<coil3.disk.DiskCache$Snapshot> r1 = r12.$snapshot
            T r1 = r1.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            coil3.disk.DiskCache$Snapshot r1 = (coil3.disk.DiskCache.Snapshot) r1
            coil3.network.NetworkResponse r0 = r0.toNetworkResponseOrNull(r1)
            r13.element = r0
            coil3.fetch.SourceFetchResult r13 = new coil3.fetch.SourceFetchResult
            coil3.network.NetworkFetcher r0 = r12.this$0
            kotlin.jvm.internal.Ref$ObjectRef<coil3.disk.DiskCache$Snapshot> r1 = r12.$snapshot
            T r1 = r1.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            coil3.disk.DiskCache$Snapshot r1 = (coil3.disk.DiskCache.Snapshot) r1
            coil3.decode.ImageSource r0 = r0.toImageSource((coil3.disk.DiskCache.Snapshot) r1)
            coil3.network.NetworkFetcher r1 = r12.this$0
            java.lang.String r3 = r1.url
            kotlin.jvm.internal.Ref$ObjectRef<coil3.network.NetworkResponse> r4 = r12.$cacheResponse
            T r4 = r4.element
            coil3.network.NetworkResponse r4 = (coil3.network.NetworkResponse) r4
            if (r4 == 0) goto L_0x009d
            coil3.network.NetworkHeaders r4 = r4.getHeaders()
            if (r4 == 0) goto L_0x009d
            java.lang.String r5 = r4.get(r2)
        L_0x009d:
            java.lang.String r1 = r1.getMimeType(r3, r5)
            coil3.decode.DataSource r2 = coil3.decode.DataSource.NETWORK
            r13.<init>(r0, r1, r2)
            return r13
        L_0x00a7:
            coil3.network.NetworkResponseBody r13 = coil3.network.internal.UtilsKt.requireBody(r4)
            r1 = r12
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r12.L$0 = r4
            r12.L$1 = r5
            r12.label = r3
            java.lang.Object r13 = coil3.network.internal.UtilsKt.readBuffer(r13, r1)
            if (r13 != r0) goto L_0x00bb
        L_0x00ba:
            return r0
        L_0x00bb:
            r0 = r4
        L_0x00bc:
            okio.Buffer r13 = (okio.Buffer) r13
            long r3 = r13.size()
            r6 = 0
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e8
            coil3.fetch.SourceFetchResult r1 = new coil3.fetch.SourceFetchResult
            coil3.network.NetworkFetcher r3 = r12.this$0
            coil3.decode.ImageSource r13 = r3.toImageSource((okio.Buffer) r13)
            coil3.network.NetworkFetcher r3 = r12.this$0
            java.lang.String r4 = r3.url
            coil3.network.NetworkHeaders r0 = r0.getHeaders()
            java.lang.String r0 = r0.get(r2)
            java.lang.String r0 = r3.getMimeType(r4, r0)
            coil3.decode.DataSource r2 = coil3.decode.DataSource.NETWORK
            r1.<init>(r13, r0, r2)
            return r1
        L_0x00e8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher$fetch$fetchResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
