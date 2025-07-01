package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExchangeFinder.kt */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address2, RealCall realCall, EventListener eventListener2) {
        Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address2, "address");
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        try {
            try {
                return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual((Object) realInterceptorChain.getRequest$okhttp().method(), (Object) "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
            } catch (RouteException e) {
                e = e;
                RouteException routeException = e;
                trackFailure(routeException.getLastConnectException());
                throw routeException;
            } catch (IOException e2) {
                e = e2;
                IOException iOException = e;
                trackFailure(iOException);
                throw new RouteException(iOException);
            }
        } catch (RouteException e3) {
            e = e3;
            RouteException routeException2 = e;
            trackFailure(routeException2.getLastConnectException());
            throw routeException2;
        } catch (IOException e4) {
            e = e4;
            IOException iOException2 = e;
            trackFailure(iOException2);
            throw new RouteException(iOException2);
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            boolean z3 = z;
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            int i8 = i;
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z4 = true;
                if (selection != null ? selection.hasNext() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.routeSelector;
                    if (routeSelector2 != null) {
                        z4 = routeSelector2.hasNext();
                    }
                    if (!z4) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
            i = i8;
            i2 = i7;
            i3 = i6;
            i4 = i5;
            z = z3;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection findConnection(int r13, int r14, int r15, int r16, boolean r17) throws java.io.IOException {
        /*
            r12 = this;
            okhttp3.internal.connection.RealCall r0 = r12.call
            boolean r0 = r0.isCanceled()
            if (r0 != 0) goto L_0x0190
            okhttp3.internal.connection.RealCall r0 = r12.call
            okhttp3.internal.connection.RealConnection r1 = r0.getConnection()
            r2 = 0
            if (r1 == 0) goto L_0x0062
            monitor-enter(r1)
            boolean r0 = r1.getNoNewExchanges()     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x002d
            okhttp3.Route r0 = r1.route()     // Catch:{ all -> 0x005e }
            okhttp3.Address r0 = r0.address()     // Catch:{ all -> 0x005e }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x005e }
            boolean r0 = r12.sameHostAndPort(r0)     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r0 = r2
            goto L_0x0033
        L_0x002d:
            okhttp3.internal.connection.RealCall r0 = r12.call     // Catch:{ all -> 0x005e }
            java.net.Socket r0 = r0.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x005e }
        L_0x0033:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005e }
            monitor-exit(r1)
            okhttp3.internal.connection.RealCall r3 = r12.call
            okhttp3.internal.connection.RealConnection r3 = r3.getConnection()
            if (r3 == 0) goto L_0x004d
            if (r0 != 0) goto L_0x0041
            return r1
        L_0x0041:
            java.lang.String r13 = "Check failed."
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r0)
        L_0x0052:
            okhttp3.EventListener r0 = r12.eventListener
            okhttp3.internal.connection.RealCall r3 = r12.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            okhttp3.Connection r1 = (okhttp3.Connection) r1
            r0.connectionReleased(r3, r1)
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r13 = r0
            monitor-exit(r1)
            throw r13
        L_0x0062:
            r0 = 0
            r12.refusedStreamCount = r0
            r12.connectionShutdownCount = r0
            r12.otherFailureCount = r0
            okhttp3.internal.connection.RealConnectionPool r1 = r12.connectionPool
            okhttp3.Address r3 = r12.address
            okhttp3.internal.connection.RealCall r4 = r12.call
            boolean r1 = r1.callAcquirePooledConnection(r3, r4, r2, r0)
            if (r1 == 0) goto L_0x008b
            okhttp3.internal.connection.RealCall r13 = r12.call
            okhttp3.internal.connection.RealConnection r13 = r13.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            okhttp3.EventListener r14 = r12.eventListener
            okhttp3.internal.connection.RealCall r15 = r12.call
            okhttp3.Call r15 = (okhttp3.Call) r15
            r0 = r13
            okhttp3.Connection r0 = (okhttp3.Connection) r0
            r14.connectionAcquired(r15, r0)
            return r13
        L_0x008b:
            okhttp3.Route r1 = r12.nextRouteToTry
            if (r1 == 0) goto L_0x0096
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r12.nextRouteToTry = r2
        L_0x0094:
            r3 = r2
            goto L_0x0102
        L_0x0096:
            okhttp3.internal.connection.RouteSelector$Selection r1 = r12.routeSelection
            if (r1 == 0) goto L_0x00ad
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r1.hasNext()
            if (r1 == 0) goto L_0x00ad
            okhttp3.internal.connection.RouteSelector$Selection r0 = r12.routeSelection
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.Route r1 = r0.next()
            goto L_0x0094
        L_0x00ad:
            okhttp3.internal.connection.RouteSelector r1 = r12.routeSelector
            if (r1 != 0) goto L_0x00ca
            okhttp3.internal.connection.RouteSelector r1 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r3 = r12.address
            okhttp3.internal.connection.RealCall r4 = r12.call
            okhttp3.OkHttpClient r4 = r4.getClient()
            okhttp3.internal.connection.RouteDatabase r4 = r4.getRouteDatabase()
            okhttp3.internal.connection.RealCall r5 = r12.call
            okhttp3.Call r5 = (okhttp3.Call) r5
            okhttp3.EventListener r6 = r12.eventListener
            r1.<init>(r3, r4, r5, r6)
            r12.routeSelector = r1
        L_0x00ca:
            okhttp3.internal.connection.RouteSelector$Selection r1 = r1.next()
            r12.routeSelection = r1
            java.util.List r3 = r1.getRoutes()
            okhttp3.internal.connection.RealCall r4 = r12.call
            boolean r4 = r4.isCanceled()
            if (r4 != 0) goto L_0x0188
            okhttp3.internal.connection.RealConnectionPool r4 = r12.connectionPool
            okhttp3.Address r5 = r12.address
            okhttp3.internal.connection.RealCall r6 = r12.call
            boolean r0 = r4.callAcquirePooledConnection(r5, r6, r3, r0)
            if (r0 == 0) goto L_0x00fe
            okhttp3.internal.connection.RealCall r13 = r12.call
            okhttp3.internal.connection.RealConnection r13 = r13.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            okhttp3.EventListener r14 = r12.eventListener
            okhttp3.internal.connection.RealCall r15 = r12.call
            okhttp3.Call r15 = (okhttp3.Call) r15
            r0 = r13
            okhttp3.Connection r0 = (okhttp3.Connection) r0
            r14.connectionAcquired(r15, r0)
            return r13
        L_0x00fe:
            okhttp3.Route r1 = r1.next()
        L_0x0102:
            okhttp3.internal.connection.RealConnection r4 = new okhttp3.internal.connection.RealConnection
            okhttp3.internal.connection.RealConnectionPool r0 = r12.connectionPool
            r4.<init>(r0, r1)
            okhttp3.internal.connection.RealCall r0 = r12.call
            r0.setConnectionToCancel(r4)
            okhttp3.internal.connection.RealCall r0 = r12.call     // Catch:{ all -> 0x0180 }
            r10 = r0
            okhttp3.Call r10 = (okhttp3.Call) r10     // Catch:{ all -> 0x0180 }
            okhttp3.EventListener r11 = r12.eventListener     // Catch:{ all -> 0x0180 }
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r4.connect(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0180 }
            okhttp3.internal.connection.RealCall r13 = r12.call
            r13.setConnectionToCancel(r2)
            okhttp3.internal.connection.RealCall r13 = r12.call
            okhttp3.OkHttpClient r13 = r13.getClient()
            okhttp3.internal.connection.RouteDatabase r13 = r13.getRouteDatabase()
            okhttp3.Route r14 = r4.route()
            r13.connected(r14)
            okhttp3.internal.connection.RealConnectionPool r13 = r12.connectionPool
            okhttp3.Address r14 = r12.address
            okhttp3.internal.connection.RealCall r15 = r12.call
            r0 = 1
            boolean r13 = r13.callAcquirePooledConnection(r14, r15, r3, r0)
            if (r13 == 0) goto L_0x0161
            okhttp3.internal.connection.RealCall r13 = r12.call
            okhttp3.internal.connection.RealConnection r13 = r13.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r12.nextRouteToTry = r1
            java.net.Socket r14 = r4.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r14)
            okhttp3.EventListener r14 = r12.eventListener
            okhttp3.internal.connection.RealCall r15 = r12.call
            okhttp3.Call r15 = (okhttp3.Call) r15
            r0 = r13
            okhttp3.Connection r0 = (okhttp3.Connection) r0
            r14.connectionAcquired(r15, r0)
            return r13
        L_0x0161:
            monitor-enter(r4)
            okhttp3.internal.connection.RealConnectionPool r13 = r12.connectionPool     // Catch:{ all -> 0x017c }
            r13.put(r4)     // Catch:{ all -> 0x017c }
            okhttp3.internal.connection.RealCall r13 = r12.call     // Catch:{ all -> 0x017c }
            r13.acquireConnectionNoEvents(r4)     // Catch:{ all -> 0x017c }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x017c }
            monitor-exit(r4)
            okhttp3.EventListener r13 = r12.eventListener
            okhttp3.internal.connection.RealCall r14 = r12.call
            okhttp3.Call r14 = (okhttp3.Call) r14
            r15 = r4
            okhttp3.Connection r15 = (okhttp3.Connection) r15
            r13.connectionAcquired(r14, r15)
            return r4
        L_0x017c:
            r0 = move-exception
            r13 = r0
            monitor-exit(r4)
            throw r13
        L_0x0180:
            r0 = move-exception
            r13 = r0
            okhttp3.internal.connection.RealCall r14 = r12.call
            r14.setConnectionToCancel(r2)
            throw r13
        L_0x0188:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "Canceled"
            r13.<init>(r14)
            throw r13
        L_0x0190:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r14 = "Canceled"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector2;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && (routeSelector2 = this.routeSelector) != null) {
            return routeSelector2.hasNext();
        }
        return true;
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
                return null;
            }
            Route route = connection.route();
            return route;
        }
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, ImagesContract.URL);
        HttpUrl url = this.address.url();
        return httpUrl.port() == url.port() && Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host());
    }
}
