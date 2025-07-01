package coil3.network.internal;

import coil3.disk.DiskCache;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\tH@¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u001a\f\u0010\u0015\u001a\u00020\t*\u00020\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u0005*\u00060\u0018j\u0002`\u0019H\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"append", "Lcoil3/network/NetworkHeaders$Builder;", "line", "", "abortQuietly", "", "Lcoil3/disk/DiskCache$Editor;", "readBuffer", "Lokio/Buffer;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CACHE_CONTROL", "CONTENT_TYPE", "HTTP_METHOD_GET", "MIME_TYPE_TEXT_PLAIN", "HTTP_RESPONSE_OK", "", "HTTP_RESPONSE_NOT_MODIFIED", "plus", "Lcoil3/network/NetworkHeaders;", "other", "requireBody", "Lcoil3/network/NetworkResponse;", "closeQuietly", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String HTTP_METHOD_GET = "GET";
    public static final int HTTP_RESPONSE_NOT_MODIFIED = 304;
    public static final int HTTP_RESPONSE_OK = 200;
    public static final String MIME_TYPE_TEXT_PLAIN = "text/plain";

    public static final NetworkHeaders.Builder append(NetworkHeaders.Builder builder, String str) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String obj = StringsKt.trim((CharSequence) substring).toString();
            String substring2 = str.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            builder.add(obj, substring2);
            return builder;
        }
        throw new IllegalArgumentException(("Unexpected header: " + str).toString());
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readBuffer(coil3.network.NetworkResponseBody r5, kotlin.coroutines.Continuation<? super okio.Buffer> r6) {
        /*
            boolean r0 = r6 instanceof coil3.network.internal.UtilsKt$readBuffer$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = (coil3.network.internal.UtilsKt$readBuffer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = new coil3.network.internal.UtilsKt$readBuffer$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r5 = r0.L$1
            okio.Buffer r5 = (okio.Buffer) r5
            java.lang.Object r0 = r0.L$0
            java.lang.AutoCloseable r0 = (java.lang.AutoCloseable) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x005b
        L_0x0032:
            r5 = move-exception
            goto L_0x0063
        L_0x0034:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.AutoCloseable r5 = (java.lang.AutoCloseable) r5
            r6 = r5
            coil3.network.NetworkResponseBody r6 = (coil3.network.NetworkResponseBody) r6     // Catch:{ all -> 0x0060 }
            okio.Buffer r2 = new okio.Buffer     // Catch:{ all -> 0x0060 }
            r2.<init>()     // Catch:{ all -> 0x0060 }
            r4 = r2
            okio.BufferedSink r4 = (okio.BufferedSink) r4     // Catch:{ all -> 0x0060 }
            r0.L$0 = r5     // Catch:{ all -> 0x0060 }
            r0.L$1 = r2     // Catch:{ all -> 0x0060 }
            r0.label = r3     // Catch:{ all -> 0x0060 }
            java.lang.Object r6 = r6.writeTo(r4, r0)     // Catch:{ all -> 0x0060 }
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r5
            r5 = r2
        L_0x005b:
            r6 = 0
            kotlin.jdk7.AutoCloseableKt.closeFinally(r0, r6)
            return r5
        L_0x0060:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L_0x0063:
            throw r5     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r6 = move-exception
            kotlin.jdk7.AutoCloseableKt.closeFinally(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.internal.UtilsKt.readBuffer(coil3.network.NetworkResponseBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final NetworkHeaders plus(NetworkHeaders networkHeaders, NetworkHeaders networkHeaders2) {
        NetworkHeaders.Builder newBuilder = networkHeaders.newBuilder();
        for (Map.Entry next : networkHeaders2.asMap().entrySet()) {
            newBuilder.set((String) next.getKey(), (List<String>) (List) next.getValue());
        }
        return newBuilder.build();
    }

    public static final NetworkResponseBody requireBody(NetworkResponse networkResponse) {
        NetworkResponseBody body = networkResponse.getBody();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("body == null".toString());
    }

    public static final void closeQuietly(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }
}
