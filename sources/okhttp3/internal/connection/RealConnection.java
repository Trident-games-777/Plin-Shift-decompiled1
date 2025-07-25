package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ%\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ(\u0010K\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020NH\u0002J0\u0010O\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J*\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002J\b\u0010S\u001a\u00020QH\u0002J(\u0010T\u001a\u0002062\u0006\u0010M\u001a\u00020N2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010U\u001a\u000206H\u0000¢\u0006\u0002\bVJ%\u0010W\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010[H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u001d\u0010_\u001a\u00020`2\u0006\u0010E\u001a\u00020F2\u0006\u0010a\u001a\u00020bH\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\r\u0010 \u001a\u000206H\u0000¢\u0006\u0002\biJ\r\u0010!\u001a\u000206H\u0000¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010r\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060[H\u0002J\b\u00101\u001a\u00020(H\u0016J\u0010\u0010t\u001a\u0002062\u0006\u0010>\u001a\u00020\tH\u0002J\u0010\u0010u\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010v\u001a\u00020wH\u0016J\u001f\u0010x\u001a\u0002062\u0006\u0010@\u001a\u00020\r2\b\u0010y\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bzR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNs", "", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed", "", "isMultiplexed$okhttp", "()Z", "noCoalescedConnections", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", "source", "Lokio/BufferedSource;", "successCount", "cancel", "", "certificateSupportHost", "url", "Lokhttp3/HttpUrl;", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectFailed", "client", "Lokhttp3/OkHttpClient;", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "createTunnelRequest", "establishProtocol", "incrementSuccessCount", "incrementSuccessCount$okhttp", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "noCoalescedConnections$okhttp", "noNewExchanges$okhttp", "onSettings", "connection", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", "e", "trackFailure$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RealConnection.kt */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit = 1;
    private final List<Reference<RealCall>> calls = new ArrayList();
    private final RealConnectionPool connectionPool;
    /* access modifiers changed from: private */
    public Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs = Long.MAX_VALUE;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    /* access modifiers changed from: private */
    public Socket socket;
    private BufferedSource source;
    private int successCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RealConnection.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                java.net.Proxy$Type[] r0 = java.net.Proxy.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                java.net.Proxy$Type r1 = java.net.Proxy.Type.DIRECT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.WhenMappings.<clinit>():void");
        }
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public RealConnection(RealConnectionPool realConnectionPool, Route route2) {
        Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route2, "route");
        this.connectionPool = realConnectionPool;
        this.route = route2;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs$okhttp(long j) {
        this.idleAtNs = j;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: okhttp3.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: okhttp3.internal.connection.RealConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: okhttp3.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: okhttp3.internal.connection.RealConnection} */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        if (r12.route.requiresTunnel() == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d7, code lost:
        if (r12.rawSocket == null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
        throw new okhttp3.internal.connection.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e9, code lost:
        r12.idleAtNs = java.lang.System.nanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ef, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013b A[LOOP:0: B:15:0x0095->B:58:0x013b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141 A[EDGE_INSN: B:66:0x0141->B:59:0x0141 ?: BREAK  
    EDGE_INSN: B:67:0x0141->B:59:0x0141 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect(int r13, int r14, int r15, int r16, boolean r17, okhttp3.Call r18, okhttp3.EventListener r19) {
        /*
            r12 = this;
            r2 = r18
            r1 = r19
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "eventListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            okhttp3.Protocol r0 = r12.protocol
            if (r0 != 0) goto L_0x0151
            okhttp3.Route r0 = r12.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r7 = new okhttp3.internal.connection.ConnectionSpecSelector
            r7.<init>(r0)
            okhttp3.Route r3 = r12.route
            okhttp3.Address r3 = r3.address()
            javax.net.ssl.SSLSocketFactory r3 = r3.sslSocketFactory()
            if (r3 != 0) goto L_0x0081
            okhttp3.ConnectionSpec r3 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0072
            okhttp3.Route r0 = r12.route
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform$Companion r3 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r3 = r3.get()
            boolean r3 = r3.isCleartextTrafficPermitted(r0)
            if (r3 == 0) goto L_0x0050
            goto L_0x0093
        L_0x0050:
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "CLEARTEXT communication to "
            r15.<init>(r1)
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            java.io.IOException r14 = (java.io.IOException) r14
            r13.<init>(r14)
            throw r13
        L_0x0072:
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "CLEARTEXT communication not enabled for client"
            r14.<init>(r15)
            java.io.IOException r14 = (java.io.IOException) r14
            r13.<init>(r14)
            throw r13
        L_0x0081:
            okhttp3.Route r0 = r12.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            okhttp3.Protocol r3 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0142
        L_0x0093:
            r8 = 0
            r9 = r8
        L_0x0095:
            okhttp3.Route r0 = r12.route     // Catch:{ IOException -> 0x00f4 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00f4 }
            if (r0 == 0) goto L_0x00b3
            r3 = r14
            r4 = r15
            r6 = r1
            r5 = r2
            r1 = r12
            r2 = r13
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00ae }
            r10 = r3
            r2 = r5
            r1 = r6
            java.net.Socket r0 = r12.rawSocket     // Catch:{ IOException -> 0x00f2 }
            if (r0 != 0) goto L_0x00b7
            goto L_0x00cd
        L_0x00ae:
            r0 = move-exception
            r10 = r3
            r2 = r5
            r1 = r6
            goto L_0x00f6
        L_0x00b3:
            r10 = r14
            r12.connectSocket(r13, r14, r2, r1)     // Catch:{ IOException -> 0x00f2 }
        L_0x00b7:
            r11 = r16
            r12.establishProtocol(r7, r11, r2, r1)     // Catch:{ IOException -> 0x00f0 }
            okhttp3.Route r0 = r12.route     // Catch:{ IOException -> 0x00f0 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00f0 }
            okhttp3.Route r3 = r12.route     // Catch:{ IOException -> 0x00f0 }
            java.net.Proxy r3 = r3.proxy()     // Catch:{ IOException -> 0x00f0 }
            okhttp3.Protocol r4 = r12.protocol     // Catch:{ IOException -> 0x00f0 }
            r1.connectEnd(r2, r0, r3, r4)     // Catch:{ IOException -> 0x00f0 }
        L_0x00cd:
            okhttp3.Route r13 = r12.route
            boolean r13 = r13.requiresTunnel()
            if (r13 == 0) goto L_0x00e9
            java.net.Socket r13 = r12.rawSocket
            if (r13 == 0) goto L_0x00da
            goto L_0x00e9
        L_0x00da:
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            java.net.ProtocolException r14 = new java.net.ProtocolException
            java.lang.String r15 = "Too many tunnel connections attempted: 21"
            r14.<init>(r15)
            java.io.IOException r14 = (java.io.IOException) r14
            r13.<init>(r14)
            throw r13
        L_0x00e9:
            long r13 = java.lang.System.nanoTime()
            r12.idleAtNs = r13
            return
        L_0x00f0:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f2:
            r0 = move-exception
            goto L_0x00f6
        L_0x00f4:
            r0 = move-exception
            r10 = r14
        L_0x00f6:
            r11 = r16
        L_0x00f8:
            r6 = r0
            java.net.Socket r0 = r12.socket
            if (r0 == 0) goto L_0x0100
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r0)
        L_0x0100:
            java.net.Socket r0 = r12.rawSocket
            if (r0 == 0) goto L_0x0107
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r0)
        L_0x0107:
            r12.socket = r8
            r12.rawSocket = r8
            r12.source = r8
            r12.sink = r8
            r12.handshake = r8
            r12.protocol = r8
            r12.http2Connection = r8
            r0 = 1
            r12.allocationLimit = r0
            okhttp3.Route r0 = r12.route
            java.net.InetSocketAddress r3 = r0.socketAddress()
            okhttp3.Route r0 = r12.route
            java.net.Proxy r4 = r0.proxy()
            r5 = 0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r9 != 0) goto L_0x0130
            okhttp3.internal.connection.RouteException r9 = new okhttp3.internal.connection.RouteException
            r9.<init>(r6)
            goto L_0x0133
        L_0x0130:
            r9.addConnectException(r6)
        L_0x0133:
            if (r17 == 0) goto L_0x0141
            boolean r0 = r7.connectionFailed(r6)
            if (r0 == 0) goto L_0x0141
            r2 = r18
            r1 = r19
            goto L_0x0095
        L_0x0141:
            throw r9
        L_0x0142:
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r14.<init>(r15)
            java.io.IOException r14 = (java.io.IOException) r14
            r13.<init>(r14)
            throw r13
        L_0x0151:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "already connected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    private final void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (i4 < 21) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
                i4++;
            } else {
                return;
            }
        }
    }

    private final void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            socket2 = address.socketFactory().createSocket();
            Intrinsics.checkNotNull(socket2);
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        socket2.setSoTimeout(i2);
        try {
            Platform.Companion.get().connectSocket(socket2, this.route.socketAddress(), i);
            try {
                this.source = Okio.buffer(Okio.source(socket2));
                this.sink = Okio.buffer(Okio.sink(socket2));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual((Object) e.getMessage(), (Object) NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private final void startHttp2(int i) throws IOException {
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket2.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket2, this.route.address().url().host(), bufferedSource, bufferedSink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, (TaskRunner) null, 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void connectTls(okhttp3.internal.connection.ConnectionSpecSelector r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "\n              |Hostname "
            java.lang.String r1 = "Hostname "
            okhttp3.Route r2 = r10.route
            okhttp3.Address r2 = r2.address()
            javax.net.ssl.SSLSocketFactory r3 = r2.sslSocketFactory()
            r4 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0186 }
            java.net.Socket r5 = r10.rawSocket     // Catch:{ all -> 0x0186 }
            okhttp3.HttpUrl r6 = r2.url()     // Catch:{ all -> 0x0186 }
            java.lang.String r6 = r6.host()     // Catch:{ all -> 0x0186 }
            okhttp3.HttpUrl r7 = r2.url()     // Catch:{ all -> 0x0186 }
            int r7 = r7.port()     // Catch:{ all -> 0x0186 }
            r8 = 1
            java.net.Socket r3 = r3.createSocket(r5, r6, r7, r8)     // Catch:{ all -> 0x0186 }
            java.lang.String r5 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)     // Catch:{ all -> 0x0186 }
            javax.net.ssl.SSLSocket r3 = (javax.net.ssl.SSLSocket) r3     // Catch:{ all -> 0x0186 }
            okhttp3.ConnectionSpec r11 = r11.configureSecureSocket(r3)     // Catch:{ all -> 0x0183 }
            boolean r5 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0183 }
            if (r5 == 0) goto L_0x004f
            okhttp3.internal.platform.Platform$Companion r5 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0183 }
            okhttp3.internal.platform.Platform r5 = r5.get()     // Catch:{ all -> 0x0183 }
            okhttp3.HttpUrl r6 = r2.url()     // Catch:{ all -> 0x0183 }
            java.lang.String r6 = r6.host()     // Catch:{ all -> 0x0183 }
            java.util.List r7 = r2.protocols()     // Catch:{ all -> 0x0183 }
            r5.configureTlsExtensions(r3, r6, r7)     // Catch:{ all -> 0x0183 }
        L_0x004f:
            r3.startHandshake()     // Catch:{ all -> 0x0183 }
            javax.net.ssl.SSLSession r5 = r3.getSession()     // Catch:{ all -> 0x0183 }
            okhttp3.Handshake$Companion r6 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x0183 }
            java.lang.String r7 = "sslSocketSession"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ all -> 0x0183 }
            okhttp3.Handshake r6 = r6.get(r5)     // Catch:{ all -> 0x0183 }
            javax.net.ssl.HostnameVerifier r7 = r2.hostnameVerifier()     // Catch:{ all -> 0x0183 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0183 }
            okhttp3.HttpUrl r9 = r2.url()     // Catch:{ all -> 0x0183 }
            java.lang.String r9 = r9.host()     // Catch:{ all -> 0x0183 }
            boolean r5 = r7.verify(r9, r5)     // Catch:{ all -> 0x0183 }
            if (r5 != 0) goto L_0x010a
            java.util.List r11 = r6.peerCertificates()     // Catch:{ all -> 0x0183 }
            r5 = r11
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0183 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0183 }
            if (r5 != 0) goto L_0x00e9
            r1 = 0
            java.lang.Object r11 = r11.get(r1)     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r1)     // Catch:{ all -> 0x0183 }
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ all -> 0x0183 }
            javax.net.ssl.SSLPeerUnverifiedException r1 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0183 }
            r5.<init>(r0)     // Catch:{ all -> 0x0183 }
            okhttp3.HttpUrl r0 = r2.url()     // Catch:{ all -> 0x0183 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = " not verified:\n              |    certificate: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0183 }
            okhttp3.CertificatePinner$Companion r2 = okhttp3.CertificatePinner.Companion     // Catch:{ all -> 0x0183 }
            r5 = r11
            java.security.cert.Certificate r5 = (java.security.cert.Certificate) r5     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = r2.pin(r5)     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = "\n              |    DN: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0183 }
            java.security.Principal r2 = r11.getSubjectDN()     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = "\n              |    subjectAltNames: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0183 }
            okhttp3.internal.tls.OkHostnameVerifier r2 = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE     // Catch:{ all -> 0x0183 }
            java.util.List r11 = r2.allSubjectAltNames(r11)     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r11 = r0.append(r11)     // Catch:{ all -> 0x0183 }
            java.lang.String r0 = "\n              "
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ all -> 0x0183 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0183 }
            java.lang.String r11 = kotlin.text.StringsKt.trimMargin$default(r11, r4, r8, r4)     // Catch:{ all -> 0x0183 }
            r1.<init>(r11)     // Catch:{ all -> 0x0183 }
            throw r1     // Catch:{ all -> 0x0183 }
        L_0x00e9:
            javax.net.ssl.SSLPeerUnverifiedException r11 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0183 }
            r0.<init>(r1)     // Catch:{ all -> 0x0183 }
            okhttp3.HttpUrl r1 = r2.url()     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = r1.host()     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = " not verified (no certificates)"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0183 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0183 }
            r11.<init>(r0)     // Catch:{ all -> 0x0183 }
            throw r11     // Catch:{ all -> 0x0183 }
        L_0x010a:
            okhttp3.CertificatePinner r0 = r2.certificatePinner()     // Catch:{ all -> 0x0183 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0183 }
            okhttp3.Handshake r1 = new okhttp3.Handshake     // Catch:{ all -> 0x0183 }
            okhttp3.TlsVersion r5 = r6.tlsVersion()     // Catch:{ all -> 0x0183 }
            okhttp3.CipherSuite r7 = r6.cipherSuite()     // Catch:{ all -> 0x0183 }
            java.util.List r8 = r6.localCertificates()     // Catch:{ all -> 0x0183 }
            okhttp3.internal.connection.RealConnection$connectTls$1 r9 = new okhttp3.internal.connection.RealConnection$connectTls$1     // Catch:{ all -> 0x0183 }
            r9.<init>(r0, r6, r2)     // Catch:{ all -> 0x0183 }
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9     // Catch:{ all -> 0x0183 }
            r1.<init>(r5, r7, r8, r9)     // Catch:{ all -> 0x0183 }
            r10.handshake = r1     // Catch:{ all -> 0x0183 }
            okhttp3.HttpUrl r1 = r2.url()     // Catch:{ all -> 0x0183 }
            java.lang.String r1 = r1.host()     // Catch:{ all -> 0x0183 }
            okhttp3.internal.connection.RealConnection$connectTls$2 r2 = new okhttp3.internal.connection.RealConnection$connectTls$2     // Catch:{ all -> 0x0183 }
            r2.<init>(r10)     // Catch:{ all -> 0x0183 }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch:{ all -> 0x0183 }
            r0.check$okhttp(r1, r2)     // Catch:{ all -> 0x0183 }
            boolean r11 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0183 }
            if (r11 == 0) goto L_0x014d
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0183 }
            okhttp3.internal.platform.Platform r11 = r11.get()     // Catch:{ all -> 0x0183 }
            java.lang.String r4 = r11.getSelectedProtocol(r3)     // Catch:{ all -> 0x0183 }
        L_0x014d:
            r11 = r3
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0183 }
            r10.socket = r11     // Catch:{ all -> 0x0183 }
            r11 = r3
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0183 }
            okio.Source r11 = okio.Okio.source((java.net.Socket) r11)     // Catch:{ all -> 0x0183 }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r11)     // Catch:{ all -> 0x0183 }
            r10.source = r11     // Catch:{ all -> 0x0183 }
            r11 = r3
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0183 }
            okio.Sink r11 = okio.Okio.sink((java.net.Socket) r11)     // Catch:{ all -> 0x0183 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ all -> 0x0183 }
            r10.sink = r11     // Catch:{ all -> 0x0183 }
            if (r4 == 0) goto L_0x0175
            okhttp3.Protocol$Companion r11 = okhttp3.Protocol.Companion     // Catch:{ all -> 0x0183 }
            okhttp3.Protocol r11 = r11.get(r4)     // Catch:{ all -> 0x0183 }
            goto L_0x0177
        L_0x0175:
            okhttp3.Protocol r11 = okhttp3.Protocol.HTTP_1_1     // Catch:{ all -> 0x0183 }
        L_0x0177:
            r10.protocol = r11     // Catch:{ all -> 0x0183 }
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r11 = r11.get()
            r11.afterHandshake(r3)
            return
        L_0x0183:
            r11 = move-exception
            r4 = r3
            goto L_0x0187
        L_0x0186:
            r11 = move-exception
        L_0x0187:
            if (r4 == 0) goto L_0x0192
            okhttp3.internal.platform.Platform$Companion r0 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r0 = r0.get()
            r0.afterHandshake(r4)
        L_0x0192:
            if (r4 == 0) goto L_0x0199
            java.net.Socket r4 = (java.net.Socket) r4
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r4)
        L_0x0199:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private final Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec((OkHttpClient) null, this, bufferedSource, bufferedSink);
            bufferedSource.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            bufferedSink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (StringsKt.equals("close", Response.header$default(build, HttpHeaders.CONNECTION, (String) null, 2, (Object) null), true)) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", (RequestBody) null).header(HttpHeaders.HOST, Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", HttpHeaders.KEEP_ALIVE).header(HttpHeaders.USER_AGENT, Util.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    private final boolean routeMatchesAny(List<Route> list) {
        Iterable<Route> iterable = list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Route route2 : iterable) {
            if (route2.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual((Object) this.route.socketAddress(), (Object) route2.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake2) {
        List<Certificate> peerCertificates = handshake2.peerCertificates();
        if (!peerCertificates.isEmpty()) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
            String host = httpUrl.host();
            Certificate certificate = peerCertificates.get(0);
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (okHostnameVerifier.verify(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection2);
        }
        socket2.setSoTimeout(realInterceptorChain.readTimeoutMillis());
        bufferedSource.timeout().timeout((long) realInterceptorChain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        bufferedSink.timeout().timeout((long) realInterceptorChain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket2.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealConnection$newWebSocketStreams$1(bufferedSource, bufferedSink, exchange);
    }

    public Route route() {
        return this.route;
    }

    public final void cancel() {
        Socket socket2 = this.rawSocket;
        if (socket2 != null) {
            Util.closeQuietly(socket2);
        }
    }

    public Socket socket() {
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        return socket2;
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        Intrinsics.checkNotNullParameter(http2Stream, "stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public synchronized void onSettings(Http2Connection http2Connection2, Settings settings) {
        Intrinsics.checkNotNullParameter(http2Connection2, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(OkHttpClient okHttpClient, Route route2, IOException iOException) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(route2, "failedRoute");
        Intrinsics.checkNotNullParameter(iOException, "failure");
        if (route2.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route2.address();
            address.proxySelector().connectFailed(address.url().uri(), route2.proxy().address(), iOException);
        }
        okHttpClient.getRouteDatabase().failed(route2);
    }

    public final synchronized void trackFailure$okhttp(RealCall realCall, IOException iOException) {
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i = this.refusedStreamCount + 1;
                this.refusedStreamCount = i;
                if (i > 1) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !realCall.isCanceled()) {
                this.noNewExchanges = true;
                this.routeFailureCount++;
            }
        } else if (!isMultiplexed$okhttp() || (iOException instanceof ConnectionShutdownException)) {
            this.noNewExchanges = true;
            if (this.successCount == 0) {
                if (iOException != null) {
                    connectFailed$okhttp(realCall.getClient(), this.route, iOException);
                }
                this.routeFailureCount++;
            }
        }
    }

    public Protocol protocol() {
        Protocol protocol2 = this.protocol;
        Intrinsics.checkNotNull(protocol2);
        return protocol2;
    }

    public String toString() {
        Object obj;
        StringBuilder append = new StringBuilder("Connection{").append(this.route.address().url().host()).append(':').append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        if (handshake2 == null || (obj = handshake2.cipherSuite()) == null) {
            obj = "none";
        }
        return append.append(obj).append(" protocol=").append(this.protocol).append('}').toString();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RealConnection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RealConnection newTestConnection(RealConnectionPool realConnectionPool, Route route, Socket socket, long j) {
            Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(realConnectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(j);
            return realConnection;
        }
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        } else if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        } else {
            if (Intrinsics.areEqual((Object) address.url().host(), (Object) route().address().url().host())) {
                return true;
            }
            if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
                return false;
            }
            try {
                CertificatePinner certificatePinner = address.certificatePinner();
                Intrinsics.checkNotNull(certificatePinner);
                String host = address.url().host();
                Handshake handshake2 = handshake();
                Intrinsics.checkNotNull(handshake2);
                certificatePinner.check(host, (List<? extends Certificate>) handshake2.peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake2;
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            HttpUrl url = this.route.address().url();
            if (httpUrl.port() != url.port()) {
                return false;
            }
            if (Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host())) {
                return true;
            }
            if (!this.noCoalescedConnections && (handshake2 = this.handshake) != null) {
                Intrinsics.checkNotNull(handshake2);
                if (certificateSupportHost(httpUrl, handshake2)) {
                    return true;
                }
            }
            return false;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final boolean isHealthy(boolean z) {
        long j;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket2 = this.rawSocket;
            Intrinsics.checkNotNull(socket2);
            Socket socket3 = this.socket;
            Intrinsics.checkNotNull(socket3);
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            if (socket2.isClosed() || socket3.isClosed() || socket3.isInputShutdown() || socket3.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection2 = this.http2Connection;
            if (http2Connection2 != null) {
                return http2Connection2.isHealthy(nanoTime);
            }
            synchronized (this) {
                j = nanoTime - this.idleAtNs;
            }
            if (j < IDLE_CONNECTION_HEALTHY_NS || !z) {
                return true;
            }
            return Util.isHealthy(socket3, bufferedSource);
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
