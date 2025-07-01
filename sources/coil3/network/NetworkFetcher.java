package coil3.network;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.network.NetworkHeaders;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.Utils_androidKt;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J4\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J@\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\u001b2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010)\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002J\f\u0010*\u001a\u00020+*\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020+*\u00020,H@¢\u0006\u0002\u0010-J\f\u0010*\u001a\u00020+*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", "url", "", "options", "Lcoil3/request/Options;", "networkClient", "Lkotlin/Lazy;", "Lcoil3/network/NetworkClient;", "diskCache", "Lcoil3/disk/DiskCache;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Ljava/lang/String;Lcoil3/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/network/ConnectivityChecker;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil3/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "networkResponse", "(Lcoil3/disk/DiskCache$Snapshot;Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRequest", "executeNetworkRequest", "T", "request", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "toNetworkResponseOrNull", "toImageSource", "Lcoil3/decode/ImageSource;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokio/Buffer;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: NetworkFetcher.kt */
public final class NetworkFetcher implements Fetcher {
    private final Lazy<CacheStrategy> cacheStrategy;
    private final ConnectivityChecker connectivityChecker;
    private final Lazy<DiskCache> diskCache;
    private final Lazy<NetworkClient> networkClient;
    private final Options options;
    /* access modifiers changed from: private */
    public final String url;

    public NetworkFetcher(String str, Options options2, Lazy<? extends NetworkClient> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends CacheStrategy> lazy3, ConnectivityChecker connectivityChecker2) {
        this.url = str;
        this.options = options2;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0125, code lost:
        if (r14 == null) goto L_0x0127;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4 A[Catch:{ Exception -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121 A[SYNTHETIC, Splitter:B:52:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0149 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetch(kotlin.coroutines.Continuation<? super coil3.fetch.FetchResult> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof coil3.network.NetworkFetcher$fetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            coil3.network.NetworkFetcher$fetch$1 r0 = (coil3.network.NetworkFetcher$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            coil3.network.NetworkFetcher$fetch$1 r0 = new coil3.network.NetworkFetcher$fetch$1
            r0.<init>(r13, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x006a
            if (r2 == r5) goto L_0x0054
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r0 = r0.L$0
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0162
        L_0x0037:
            r0 = move-exception
            goto L_0x016b
        L_0x003a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0042:
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.L$0
            coil3.network.NetworkFetcher r4 = (coil3.network.NetworkFetcher) r4
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x004f }
            goto L_0x0145
        L_0x004f:
            r0 = move-exception
            r14 = r0
            r1 = r2
            goto L_0x016c
        L_0x0054:
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r7 = r0.L$0
            coil3.network.NetworkFetcher r7 = (coil3.network.NetworkFetcher) r7
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x0065 }
            goto L_0x00ec
        L_0x0065:
            r0 = move-exception
            r14 = r0
            r1 = r5
            goto L_0x016c
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            coil3.disk.DiskCache$Snapshot r2 = r13.readFromDiskCache()
            r14.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x0169 }
            r2.<init>()     // Catch:{ Exception -> 0x0169 }
            T r7 = r14.element     // Catch:{ Exception -> 0x0169 }
            if (r7 == 0) goto L_0x011b
            okio.FileSystem r7 = r13.getFileSystem()     // Catch:{ Exception -> 0x0169 }
            T r8 = r14.element     // Catch:{ Exception -> 0x0169 }
            coil3.disk.DiskCache$Snapshot r8 = (coil3.disk.DiskCache.Snapshot) r8     // Catch:{ Exception -> 0x0169 }
            okio.Path r8 = r8.getMetadata()     // Catch:{ Exception -> 0x0169 }
            okio.FileMetadata r7 = r7.metadata(r8)     // Catch:{ Exception -> 0x0169 }
            java.lang.Long r7 = r7.getSize()     // Catch:{ Exception -> 0x0169 }
            if (r7 != 0) goto L_0x0098
            goto L_0x00b8
        L_0x0098:
            long r7 = r7.longValue()     // Catch:{ Exception -> 0x0169 }
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x00b8
            coil3.fetch.SourceFetchResult r0 = new coil3.fetch.SourceFetchResult     // Catch:{ Exception -> 0x0169 }
            T r1 = r14.element     // Catch:{ Exception -> 0x0169 }
            coil3.disk.DiskCache$Snapshot r1 = (coil3.disk.DiskCache.Snapshot) r1     // Catch:{ Exception -> 0x0169 }
            coil3.decode.ImageSource r1 = r13.toImageSource((coil3.disk.DiskCache.Snapshot) r1)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = r13.url     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = r13.getMimeType(r2, r6)     // Catch:{ Exception -> 0x0169 }
            coil3.decode.DataSource r3 = coil3.decode.DataSource.DISK     // Catch:{ Exception -> 0x0169 }
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x0169 }
            return r0
        L_0x00b8:
            T r7 = r14.element     // Catch:{ Exception -> 0x0169 }
            coil3.disk.DiskCache$Snapshot r7 = (coil3.disk.DiskCache.Snapshot) r7     // Catch:{ Exception -> 0x0169 }
            coil3.network.NetworkResponse r7 = r13.toNetworkResponseOrNull(r7)     // Catch:{ Exception -> 0x0169 }
            r2.element = r7     // Catch:{ Exception -> 0x0169 }
            T r7 = r2.element     // Catch:{ Exception -> 0x0169 }
            if (r7 == 0) goto L_0x011b
            kotlin.Lazy<coil3.network.CacheStrategy> r7 = r13.cacheStrategy     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x0169 }
            coil3.network.CacheStrategy r7 = (coil3.network.CacheStrategy) r7     // Catch:{ Exception -> 0x0169 }
            T r8 = r2.element     // Catch:{ Exception -> 0x0169 }
            coil3.network.NetworkResponse r8 = (coil3.network.NetworkResponse) r8     // Catch:{ Exception -> 0x0169 }
            coil3.network.NetworkRequest r9 = r13.newRequest()     // Catch:{ Exception -> 0x0169 }
            coil3.request.Options r10 = r13.options     // Catch:{ Exception -> 0x0169 }
            r0.L$0 = r13     // Catch:{ Exception -> 0x0169 }
            r0.L$1 = r14     // Catch:{ Exception -> 0x0169 }
            r0.L$2 = r2     // Catch:{ Exception -> 0x0169 }
            r0.label = r5     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r5 = r7.read(r8, r9, r10, r0)     // Catch:{ Exception -> 0x0169 }
            if (r5 != r1) goto L_0x00e8
            goto L_0x0160
        L_0x00e8:
            r7 = r5
            r5 = r14
            r14 = r7
            r7 = r13
        L_0x00ec:
            coil3.network.CacheStrategy$ReadResult r14 = (coil3.network.CacheStrategy.ReadResult) r14     // Catch:{ Exception -> 0x0065 }
            coil3.network.NetworkResponse r8 = r14.getResponse()     // Catch:{ Exception -> 0x0065 }
            if (r8 == 0) goto L_0x0118
            coil3.fetch.SourceFetchResult r0 = new coil3.fetch.SourceFetchResult     // Catch:{ Exception -> 0x0065 }
            T r1 = r5.element     // Catch:{ Exception -> 0x0065 }
            coil3.disk.DiskCache$Snapshot r1 = (coil3.disk.DiskCache.Snapshot) r1     // Catch:{ Exception -> 0x0065 }
            coil3.decode.ImageSource r1 = r7.toImageSource((coil3.disk.DiskCache.Snapshot) r1)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r2 = r7.url     // Catch:{ Exception -> 0x0065 }
            coil3.network.NetworkResponse r14 = r14.getResponse()     // Catch:{ Exception -> 0x0065 }
            coil3.network.NetworkHeaders r14 = r14.getHeaders()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r14 = r14.get(r3)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r14 = r7.getMimeType(r2, r14)     // Catch:{ Exception -> 0x0065 }
            coil3.decode.DataSource r2 = coil3.decode.DataSource.DISK     // Catch:{ Exception -> 0x0065 }
            r0.<init>(r1, r14, r2)     // Catch:{ Exception -> 0x0065 }
            return r0
        L_0x0118:
            r8 = r5
            r9 = r7
            goto L_0x011e
        L_0x011b:
            r9 = r13
            r8 = r14
            r14 = r6
        L_0x011e:
            r10 = r2
            if (r14 == 0) goto L_0x0127
            coil3.network.NetworkRequest r14 = r14.getRequest()     // Catch:{ Exception -> 0x0165 }
            if (r14 != 0) goto L_0x012b
        L_0x0127:
            coil3.network.NetworkRequest r14 = r9.newRequest()     // Catch:{ Exception -> 0x0165 }
        L_0x012b:
            r11 = r14
            coil3.network.NetworkFetcher$fetch$fetchResult$1 r7 = new coil3.network.NetworkFetcher$fetch$fetchResult$1     // Catch:{ Exception -> 0x0165 }
            r12 = 0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0165 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ Exception -> 0x0165 }
            r0.L$0 = r9     // Catch:{ Exception -> 0x0165 }
            r0.L$1 = r8     // Catch:{ Exception -> 0x0165 }
            r0.L$2 = r6     // Catch:{ Exception -> 0x0165 }
            r0.label = r4     // Catch:{ Exception -> 0x0165 }
            java.lang.Object r14 = r9.executeNetworkRequest(r11, r7, r0)     // Catch:{ Exception -> 0x0165 }
            if (r14 != r1) goto L_0x0143
            goto L_0x0160
        L_0x0143:
            r2 = r8
            r4 = r9
        L_0x0145:
            coil3.fetch.SourceFetchResult r14 = (coil3.fetch.SourceFetchResult) r14     // Catch:{ Exception -> 0x004f }
            if (r14 != 0) goto L_0x0164
            coil3.network.NetworkRequest r14 = r4.newRequest()     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkFetcher$fetch$2 r5 = new coil3.network.NetworkFetcher$fetch$2     // Catch:{ Exception -> 0x004f }
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x004f }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ Exception -> 0x004f }
            r0.L$0 = r2     // Catch:{ Exception -> 0x004f }
            r0.L$1 = r6     // Catch:{ Exception -> 0x004f }
            r0.label = r3     // Catch:{ Exception -> 0x004f }
            java.lang.Object r14 = r4.executeNetworkRequest(r14, r5, r0)     // Catch:{ Exception -> 0x004f }
            if (r14 != r1) goto L_0x0161
        L_0x0160:
            return r1
        L_0x0161:
            r1 = r2
        L_0x0162:
            coil3.fetch.SourceFetchResult r14 = (coil3.fetch.SourceFetchResult) r14     // Catch:{ Exception -> 0x0037 }
        L_0x0164:
            return r14
        L_0x0165:
            r0 = move-exception
            r14 = r0
            r1 = r8
            goto L_0x016c
        L_0x0169:
            r0 = move-exception
            r1 = r14
        L_0x016b:
            r14 = r0
        L_0x016c:
            T r0 = r1.element
            coil3.disk.DiskCache$Snapshot r0 = (coil3.disk.DiskCache.Snapshot) r0
            if (r0 == 0) goto L_0x0177
            java.lang.AutoCloseable r0 = (java.lang.AutoCloseable) r0
            coil3.network.internal.UtilsKt.closeQuietly(r0)
        L_0x0177:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.fetch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        if (r0.writeTo(r14, r3, r7) == r1) goto L_0x010b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeToDiskCache(coil3.disk.DiskCache.Snapshot r12, coil3.network.NetworkResponse r13, coil3.network.NetworkRequest r14, coil3.network.NetworkResponse r15, kotlin.coroutines.Continuation<? super coil3.disk.DiskCache.Snapshot> r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof coil3.network.NetworkFetcher$writeToDiskCache$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            coil3.network.NetworkFetcher$writeToDiskCache$1 r1 = (coil3.network.NetworkFetcher$writeToDiskCache$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            coil3.network.NetworkFetcher$writeToDiskCache$1 r1 = new coil3.network.NetworkFetcher$writeToDiskCache$1
            r1.<init>(r11, r0)
        L_0x001b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r8 = 2
            r3 = 1
            r9 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r3) goto L_0x0049
            if (r2 != r8) goto L_0x0041
            java.lang.Object r12 = r7.L$2
            coil3.disk.DiskCache$Editor r12 = (coil3.disk.DiskCache.Editor) r12
            java.lang.Object r13 = r7.L$1
            coil3.network.NetworkResponse r13 = (coil3.network.NetworkResponse) r13
            java.lang.Object r14 = r7.L$0
            coil3.network.NetworkResponse r14 = (coil3.network.NetworkResponse) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x010e
        L_0x003e:
            r0 = move-exception
            goto L_0x0117
        L_0x0041:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0049:
            java.lang.Object r12 = r7.L$2
            coil3.network.NetworkResponse r12 = (coil3.network.NetworkResponse) r12
            java.lang.Object r13 = r7.L$1
            coil3.disk.DiskCache$Snapshot r13 = (coil3.disk.DiskCache.Snapshot) r13
            java.lang.Object r14 = r7.L$0
            coil3.network.NetworkFetcher r14 = (coil3.network.NetworkFetcher) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r10 = r13
            r13 = r12
            r12 = r10
            goto L_0x0093
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r0)
            coil3.request.Options r0 = r11.options
            coil3.request.CachePolicy r0 = r0.getDiskCachePolicy()
            boolean r0 = r0.getWriteEnabled()
            if (r0 != 0) goto L_0x0073
            if (r12 == 0) goto L_0x0072
            java.lang.AutoCloseable r12 = (java.lang.AutoCloseable) r12
            coil3.network.internal.UtilsKt.closeQuietly(r12)
        L_0x0072:
            return r9
        L_0x0073:
            kotlin.Lazy<coil3.network.CacheStrategy> r0 = r11.cacheStrategy
            java.lang.Object r0 = r0.getValue()
            r2 = r0
            coil3.network.CacheStrategy r2 = (coil3.network.CacheStrategy) r2
            coil3.request.Options r6 = r11.options
            r7.L$0 = r11
            r7.L$1 = r12
            r7.L$2 = r15
            r7.label = r3
            r3 = r13
            r4 = r14
            r5 = r15
            java.lang.Object r0 = r2.write(r3, r4, r5, r6, r7)
            if (r0 != r1) goto L_0x0091
            goto L_0x010b
        L_0x0091:
            r14 = r11
            r13 = r15
        L_0x0093:
            coil3.network.CacheStrategy$WriteResult r0 = (coil3.network.CacheStrategy.WriteResult) r0
            coil3.network.NetworkResponse r2 = r0.getResponse()
            if (r2 != 0) goto L_0x009c
            return r9
        L_0x009c:
            if (r12 == 0) goto L_0x00a3
            coil3.disk.DiskCache$Editor r12 = r12.closeAndOpenEditor()
            goto L_0x00b7
        L_0x00a3:
            kotlin.Lazy<coil3.disk.DiskCache> r12 = r14.diskCache
            java.lang.Object r12 = r12.getValue()
            coil3.disk.DiskCache r12 = (coil3.disk.DiskCache) r12
            if (r12 == 0) goto L_0x00b6
            java.lang.String r0 = r14.getDiskCacheKey()
            coil3.disk.DiskCache$Editor r12 = r12.openEditor(r0)
            goto L_0x00b7
        L_0x00b6:
            r12 = r9
        L_0x00b7:
            if (r12 != 0) goto L_0x00ba
            return r9
        L_0x00ba:
            okio.FileSystem r0 = r14.getFileSystem()     // Catch:{ Exception -> 0x0114 }
            okio.Path r3 = r12.getMetadata()     // Catch:{ Exception -> 0x0114 }
            r4 = 0
            okio.Sink r0 = r0.sink(r3, r4)     // Catch:{ Exception -> 0x0114 }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ Exception -> 0x0114 }
            r3 = r0
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ Exception -> 0x0114 }
            r0 = r3
            okio.BufferedSink r0 = (okio.BufferedSink) r0     // Catch:{ all -> 0x00e1 }
            coil3.network.CacheNetworkResponse r4 = coil3.network.CacheNetworkResponse.INSTANCE     // Catch:{ all -> 0x00e1 }
            r4.writeTo(r2, r0)     // Catch:{ all -> 0x00e1 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e1 }
            if (r3 == 0) goto L_0x00ed
            r3.close()     // Catch:{ all -> 0x00de }
            goto L_0x00ed
        L_0x00de:
            r0 = move-exception
            r9 = r0
            goto L_0x00ed
        L_0x00e1:
            r0 = move-exception
            r9 = r0
            if (r3 == 0) goto L_0x00ed
            r3.close()     // Catch:{ all -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r9, r0)     // Catch:{ Exception -> 0x0114 }
        L_0x00ed:
            if (r9 != 0) goto L_0x0113
            coil3.network.NetworkResponseBody r0 = r2.getBody()     // Catch:{ Exception -> 0x0114 }
            if (r0 == 0) goto L_0x010c
            okio.FileSystem r14 = r14.getFileSystem()     // Catch:{ Exception -> 0x0114 }
            okio.Path r3 = r12.getData()     // Catch:{ Exception -> 0x0114 }
            r7.L$0 = r13     // Catch:{ Exception -> 0x0114 }
            r7.L$1 = r2     // Catch:{ Exception -> 0x0114 }
            r7.L$2 = r12     // Catch:{ Exception -> 0x0114 }
            r7.label = r8     // Catch:{ Exception -> 0x0114 }
            java.lang.Object r14 = r0.writeTo(r14, r3, r7)     // Catch:{ Exception -> 0x0114 }
            if (r14 != r1) goto L_0x010c
        L_0x010b:
            return r1
        L_0x010c:
            r14 = r13
            r13 = r2
        L_0x010e:
            coil3.disk.DiskCache$Snapshot r12 = r12.commitAndOpenSnapshot()     // Catch:{ Exception -> 0x003e }
            return r12
        L_0x0113:
            throw r9     // Catch:{ Exception -> 0x0114 }
        L_0x0114:
            r0 = move-exception
            r14 = r13
            r13 = r2
        L_0x0117:
            coil3.network.internal.UtilsKt.abortQuietly(r12)
            coil3.network.NetworkResponseBody r12 = r14.getBody()
            if (r12 == 0) goto L_0x0125
            java.lang.AutoCloseable r12 = (java.lang.AutoCloseable) r12
            coil3.network.internal.UtilsKt.closeQuietly(r12)
        L_0x0125:
            coil3.network.NetworkResponseBody r12 = r13.getBody()
            if (r12 == 0) goto L_0x0130
            java.lang.AutoCloseable r12 = (java.lang.AutoCloseable) r12
            coil3.network.internal.UtilsKt.closeQuietly(r12)
        L_0x0130:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.writeToDiskCache(coil3.disk.DiskCache$Snapshot, coil3.network.NetworkResponse, coil3.network.NetworkRequest, coil3.network.NetworkResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder newBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            newBuilder.set("Cache-Control", "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                newBuilder.set("Cache-Control", "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            newBuilder.set("Cache-Control", "no-cache");
        } else {
            newBuilder.set("Cache-Control", "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), newBuilder.build(), ImageRequestsKt.getHttpBody(this.options));
    }

    /* access modifiers changed from: private */
    public final <T> Object executeNetworkRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            Utils_androidKt.assertNotOnMainThread();
        }
        return this.networkClient.getValue().executeRequest(networkRequest, new NetworkFetcher$executeNetworkRequest$2(function2, (Continuation<? super NetworkFetcher$executeNetworkRequest$2>) null), continuation);
    }

    public final String getMimeType(String str, String str2) {
        String mimeTypeFromUrl;
        if ((str2 == null || StringsKt.startsWith$default(str2, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(str)) != null) {
            return mimeTypeFromUrl;
        }
        if (str2 != null) {
            return StringsKt.substringBefore$default(str2, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[Catch:{ IOException -> 0x0037 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[Catch:{ IOException -> 0x0037 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil3.network.NetworkResponse toNetworkResponseOrNull(coil3.disk.DiskCache.Snapshot r4) {
        /*
            r3 = this;
            r0 = 0
            okio.FileSystem r1 = r3.getFileSystem()     // Catch:{ IOException -> 0x0037 }
            okio.Path r4 = r4.getMetadata()     // Catch:{ IOException -> 0x0037 }
            okio.Source r4 = r1.source(r4)     // Catch:{ IOException -> 0x0037 }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ IOException -> 0x0037 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ IOException -> 0x0037 }
            r1 = r4
            okio.BufferedSource r1 = (okio.BufferedSource) r1     // Catch:{ all -> 0x0026 }
            coil3.network.CacheNetworkResponse r2 = coil3.network.CacheNetworkResponse.INSTANCE     // Catch:{ all -> 0x0026 }
            coil3.network.NetworkResponse r1 = r2.readFrom(r1)     // Catch:{ all -> 0x0026 }
            if (r4 == 0) goto L_0x0024
            r4.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r4 = move-exception
            goto L_0x0033
        L_0x0024:
            r4 = r0
            goto L_0x0033
        L_0x0026:
            r1 = move-exception
            if (r4 == 0) goto L_0x0031
            r4.close()     // Catch:{ all -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r4 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r1, r4)     // Catch:{ IOException -> 0x0037 }
        L_0x0031:
            r4 = r1
            r1 = r0
        L_0x0033:
            if (r4 != 0) goto L_0x0036
            return r1
        L_0x0036:
            throw r4     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.toNetworkResponseOrNull(coil3.disk.DiskCache$Snapshot):coil3.network.NetworkResponse");
    }

    /* access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, (ImageSource.Metadata) null, 16, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object toImageSource(coil3.network.NetworkResponseBody r5, kotlin.coroutines.Continuation<? super coil3.decode.ImageSource> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil3.network.NetworkFetcher$toImageSource$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            coil3.network.NetworkFetcher$toImageSource$1 r0 = (coil3.network.NetworkFetcher$toImageSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            coil3.network.NetworkFetcher$toImageSource$1 r0 = new coil3.network.NetworkFetcher$toImageSource$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            okio.Buffer r5 = (okio.Buffer) r5
            java.lang.Object r0 = r0.L$0
            coil3.network.NetworkFetcher r0 = (coil3.network.NetworkFetcher) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r2 = r6
            okio.BufferedSink r2 = (okio.BufferedSink) r2
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r5.writeTo(r2, r0)
            if (r5 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r0 = r4
            r5 = r6
        L_0x0054:
            okio.BufferedSource r5 = (okio.BufferedSource) r5
            okio.FileSystem r6 = r0.getFileSystem()
            r0 = 4
            r1 = 0
            coil3.decode.ImageSource r5 = coil3.decode.ImageSourceKt.ImageSource$default(r5, r6, r1, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.toImageSource(coil3.network.NetworkResponseBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default(buffer, getFileSystem(), (ImageSource.Metadata) null, 4, (Object) null);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.getFileSystem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okio.FileSystem getFileSystem() {
        /*
            r1 = this;
            kotlin.Lazy<coil3.disk.DiskCache> r0 = r1.diskCache
            java.lang.Object r0 = r0.getValue()
            coil3.disk.DiskCache r0 = (coil3.disk.DiskCache) r0
            if (r0 == 0) goto L_0x0012
            okio.FileSystem r0 = r0.getFileSystem()
            if (r0 != 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            return r0
        L_0x0012:
            coil3.request.Options r0 = r1.options
            okio.FileSystem r0 = r0.getFileSystem()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.getFileSystem():okio.FileSystem");
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "networkClient", "Lkotlin/Function0;", "Lcoil3/network/NetworkClient;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "networkClientLazy", "Lkotlin/Lazy;", "cacheStrategyLazy", "connectivityCheckerLazy", "Lcoil3/network/internal/SingleParameterLazy;", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: NetworkFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<CacheStrategy> cacheStrategyLazy;
        private final SingleParameterLazy<Context, ConnectivityChecker> connectivityCheckerLazy;
        private final Lazy<NetworkClient> networkClientLazy;

        public Factory(Function0<? extends NetworkClient> function0, Function0<? extends CacheStrategy> function02, Function1<? super Context, ? extends ConnectivityChecker> function1) {
            this.networkClientLazy = LazyKt.lazy(function0);
            this.cacheStrategyLazy = LazyKt.lazy(function02);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function1);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Factory(kotlin.jvm.functions.Function0 r1, kotlin.jvm.functions.Function0 r2, kotlin.jvm.functions.Function1 r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
            /*
                r0 = this;
                r5 = r4 & 2
                if (r5 == 0) goto L_0x0009
                coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda1 r2 = new coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda1
                r2.<init>()
            L_0x0009:
                r4 = r4 & 4
                if (r4 == 0) goto L_0x0011
                coil3.network.NetworkFetcher$Factory$2 r3 = coil3.network.NetworkFetcher.Factory.AnonymousClass2.INSTANCE
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            L_0x0011:
                r0.<init>(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.Factory.<init>(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* access modifiers changed from: private */
        public static final CacheStrategy _init_$lambda$0() {
            return CacheStrategy.DEFAULT;
        }

        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!isApplicable(uri)) {
                return null;
            }
            return new NetworkFetcher(uri.toString(), options, this.networkClientLazy, LazyKt.lazy(new NetworkFetcher$Factory$$ExternalSyntheticLambda0(imageLoader)), this.cacheStrategyLazy, this.connectivityCheckerLazy.get(options.getContext()));
        }

        /* access modifiers changed from: private */
        public static final DiskCache create$lambda$1(ImageLoader imageLoader) {
            return imageLoader.getDiskCache();
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.areEqual((Object) uri.getScheme(), (Object) ProxyConfig.MATCH_HTTP) || Intrinsics.areEqual((Object) uri.getScheme(), (Object) ProxyConfig.MATCH_HTTPS);
        }
    }
}
