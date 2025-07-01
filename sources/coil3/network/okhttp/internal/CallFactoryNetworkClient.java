package coil3.network.okhttp.internal;

import coil3.network.NetworkClient;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JQ\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t21\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000bH@¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u001b"}, d2 = {"Lcoil3/network/okhttp/internal/CallFactoryNetworkClient;", "Lcoil3/network/NetworkClient;", "callFactory", "Lokhttp3/Call$Factory;", "constructor-impl", "(Lokhttp3/Call$Factory;)Lokhttp3/Call$Factory;", "executeRequest", "T", "request", "Lcoil3/network/NetworkRequest;", "block", "Lkotlin/Function2;", "Lcoil3/network/NetworkResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "executeRequest-impl", "(Lokhttp3/Call$Factory;Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "coil-network-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* compiled from: utils.kt */
public final class CallFactoryNetworkClient implements NetworkClient {
    private final Call.Factory callFactory;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CallFactoryNetworkClient m7524boximpl(Call.Factory factory) {
        return new CallFactoryNetworkClient(factory);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Call.Factory m7525constructorimpl(Call.Factory factory) {
        return factory;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7526equalsimpl(Call.Factory factory, Object obj) {
        return (obj instanceof CallFactoryNetworkClient) && Intrinsics.areEqual((Object) factory, (Object) ((CallFactoryNetworkClient) obj).m7531unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7527equalsimpl0(Call.Factory factory, Call.Factory factory2) {
        return Intrinsics.areEqual((Object) factory, (Object) factory2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7529hashCodeimpl(Call.Factory factory) {
        return factory.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7530toStringimpl(Call.Factory factory) {
        return "CallFactoryNetworkClient(callFactory=" + factory + ')';
    }

    public boolean equals(Object obj) {
        return m7526equalsimpl(this.callFactory, obj);
    }

    public int hashCode() {
        return m7529hashCodeimpl(this.callFactory);
    }

    public String toString() {
        return m7530toStringimpl(this.callFactory);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Call.Factory m7531unboximpl() {
        return this.callFactory;
    }

    private /* synthetic */ CallFactoryNetworkClient(Call.Factory factory) {
        this.callFactory = factory;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: kotlin.jvm.functions.Function2<? super coil3.network.NetworkResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object>} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r11 == r1) goto L_0x008c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: executeRequest-impl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.lang.Object m7528executeRequestimpl(okhttp3.Call.Factory r8, coil3.network.NetworkRequest r9, kotlin.jvm.functions.Function2<? super coil3.network.NetworkResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            boolean r0 = r11 instanceof coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = (coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = new coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r8 = r0.L$0
            java.io.Closeable r8 = (java.io.Closeable) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0035 }
            goto L_0x008e
        L_0x0035:
            r9 = move-exception
            goto L_0x0096
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0078
        L_0x0047:
            java.lang.Object r8 = r0.L$1
            okhttp3.Call$Factory r8 = (okhttp3.Call.Factory) r8
            java.lang.Object r9 = r0.L$0
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0064
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r10
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r11 = coil3.network.okhttp.internal.UtilsKt.toRequest(r9, r0)
            if (r11 != r1) goto L_0x0064
            goto L_0x008c
        L_0x0064:
            okhttp3.Request r11 = (okhttp3.Request) r11
            okhttp3.Call r8 = r8.newCall(r11)
            r0.L$0 = r10
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r11 = coil3.network.okhttp.internal.CallsKt.await(r8, r0)
            if (r11 != r1) goto L_0x0077
            goto L_0x008c
        L_0x0077:
            r8 = r10
        L_0x0078:
            r9 = r11
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = r9
            okhttp3.Response r10 = (okhttp3.Response) r10     // Catch:{ all -> 0x0092 }
            coil3.network.NetworkResponse r10 = coil3.network.okhttp.internal.UtilsKt.toNetworkResponse(r10)     // Catch:{ all -> 0x0092 }
            r0.L$0 = r9     // Catch:{ all -> 0x0092 }
            r0.label = r3     // Catch:{ all -> 0x0092 }
            java.lang.Object r11 = r8.invoke(r10, r0)     // Catch:{ all -> 0x0092 }
            if (r11 != r1) goto L_0x008d
        L_0x008c:
            return r1
        L_0x008d:
            r8 = r9
        L_0x008e:
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            return r11
        L_0x0092:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0096:
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.CallFactoryNetworkClient.m7528executeRequestimpl(okhttp3.Call$Factory, coil3.network.NetworkRequest, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public <T> Object executeRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return m7528executeRequestimpl(this.callFactory, networkRequest, function2, continuation);
    }
}
