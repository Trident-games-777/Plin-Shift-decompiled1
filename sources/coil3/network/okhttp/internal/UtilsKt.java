package coil3.network.okhttp.internal;

import coil3.network.NetworkHeaders;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.Headers;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H@¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"toRequest", "Lokhttp3/Request;", "Lcoil3/network/NetworkRequest;", "(Lcoil3/network/NetworkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readByteString", "Lokio/ByteString;", "Lcoil3/network/NetworkRequestBody;", "(Lcoil3/network/NetworkRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toNetworkResponse", "Lcoil3/network/NetworkResponse;", "Lokhttp3/Response;", "toHeaders", "Lokhttp3/Headers;", "Lcoil3/network/NetworkHeaders;", "toNetworkHeaders", "coil-network-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toRequest(coil3.network.NetworkRequest r6, kotlin.coroutines.Continuation<? super okhttp3.Request> r7) {
        /*
            boolean r0 = r7 instanceof coil3.network.okhttp.internal.UtilsKt$toRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = (coil3.network.okhttp.internal.UtilsKt$toRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = new coil3.network.okhttp.internal.UtilsKt$toRequest$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r6 = r0.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r0.L$2
            okhttp3.Request$Builder r1 = (okhttp3.Request.Builder) r1
            java.lang.Object r2 = r0.L$1
            okhttp3.Request$Builder r2 = (okhttp3.Request.Builder) r2
            java.lang.Object r0 = r0.L$0
            coil3.network.NetworkRequest r0 = (coil3.network.NetworkRequest) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0072
        L_0x003b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            okhttp3.Request$Builder r7 = new okhttp3.Request$Builder
            r7.<init>()
            java.lang.String r2 = r6.getUrl()
            r7.url((java.lang.String) r2)
            java.lang.String r2 = r6.getMethod()
            coil3.network.NetworkRequestBody r5 = r6.getBody()
            if (r5 == 0) goto L_0x0082
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r0 = readByteString(r5, r0)
            if (r0 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r1 = r7
            r7 = r0
            r0 = r6
            r6 = r2
            r2 = r1
        L_0x0072:
            okio.ByteString r7 = (okio.ByteString) r7
            if (r7 == 0) goto L_0x007d
            okhttp3.RequestBody$Companion r5 = okhttp3.RequestBody.Companion
            okhttp3.RequestBody r3 = okhttp3.RequestBody.Companion.create$default((okhttp3.RequestBody.Companion) r5, (okio.ByteString) r7, (okhttp3.MediaType) r3, (int) r4, (java.lang.Object) r3)
            goto L_0x0088
        L_0x007d:
            r7 = r0
            r0 = r6
            r6 = r7
            r7 = r1
            goto L_0x0084
        L_0x0082:
            r0 = r2
            r2 = r7
        L_0x0084:
            r1 = r0
            r0 = r6
            r6 = r1
            r1 = r7
        L_0x0088:
            r1.method(r6, r3)
            coil3.network.NetworkHeaders r6 = r0.getHeaders()
            okhttp3.Headers r6 = toHeaders(r6)
            r2.headers(r6)
            okhttp3.Request r6 = r2.build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.toRequest(coil3.network.NetworkRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readByteString(coil3.network.NetworkRequestBody r4, kotlin.coroutines.Continuation<? super okio.ByteString> r5) {
        /*
            boolean r0 = r5 instanceof coil3.network.okhttp.internal.UtilsKt$readByteString$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = (coil3.network.okhttp.internal.UtilsKt$readByteString$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = new coil3.network.okhttp.internal.UtilsKt$readByteString$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            okio.Buffer r4 = (okio.Buffer) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004d
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            okio.Buffer r5 = new okio.Buffer
            r5.<init>()
            r2 = r5
            okio.BufferedSink r2 = (okio.BufferedSink) r2
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.writeTo(r2, r0)
            if (r4 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r4 = r5
        L_0x004d:
            okio.ByteString r4 = r4.readByteString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.readByteString(coil3.network.NetworkRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001a, code lost:
        r0 = r0.source();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final coil3.network.NetworkResponse toNetworkResponse(okhttp3.Response r9) {
        /*
            int r1 = r9.code()
            long r2 = r9.sentRequestAtMillis()
            long r4 = r9.receivedResponseAtMillis()
            okhttp3.Headers r0 = r9.headers()
            coil3.network.NetworkHeaders r6 = toNetworkHeaders(r0)
            okhttp3.ResponseBody r0 = r9.body()
            if (r0 == 0) goto L_0x0025
            okio.BufferedSource r0 = r0.source()
            if (r0 == 0) goto L_0x0025
            coil3.network.NetworkResponseBody r0 = coil3.network.NetworkClientKt.NetworkResponseBody(r0)
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            r7 = r0
            coil3.network.NetworkResponse r0 = new coil3.network.NetworkResponse
            r8 = r9
            r0.<init>(r1, r2, r4, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.toNetworkResponse(okhttp3.Response):coil3.network.NetworkResponse");
    }

    private static final Headers toHeaders(NetworkHeaders networkHeaders) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry next : networkHeaders.asMap().entrySet()) {
            String str = (String) next.getKey();
            for (String addUnsafeNonAscii : (List) next.getValue()) {
                builder.addUnsafeNonAscii(str, addUnsafeNonAscii);
            }
        }
        return builder.build();
    }

    private static final NetworkHeaders toNetworkHeaders(Headers headers) {
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        Iterator<Pair<String, String>> it = headers.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            builder.add((String) next.component1(), (String) next.component2());
        }
        return builder.build();
    }
}
