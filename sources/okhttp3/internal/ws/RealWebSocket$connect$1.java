package okhttp3.internal.ws;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.RealWebSocket;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"okhttp3/internal/ws/RealWebSocket$connect$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RealWebSocket.kt */
public final class RealWebSocket$connect$1 implements Callback {
    final /* synthetic */ Request $request;
    final /* synthetic */ RealWebSocket this$0;

    RealWebSocket$connect$1(RealWebSocket realWebSocket, Request request) {
        this.this$0 = realWebSocket;
        this.$request = request;
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        Exchange exchange = response.exchange();
        try {
            this.this$0.checkUpgradeSuccess$okhttp(response, exchange);
            Intrinsics.checkNotNull(exchange);
            RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
            WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
            this.this$0.extensions = parse;
            if (!this.this$0.isValid(parse)) {
                RealWebSocket realWebSocket = this.this$0;
                synchronized (realWebSocket) {
                    realWebSocket.messageAndCloseQueue.clear();
                    realWebSocket.close(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.this$0.initReaderAndWriter(Util.okHttpName + " WebSocket " + this.$request.url().redact(), newWebSocketStreams);
                this.this$0.getListener$okhttp().onOpen(this.this$0, response);
                this.this$0.loopReader();
            } catch (Exception e) {
                this.this$0.failWebSocket(e, (Response) null);
            }
        } catch (IOException e2) {
            this.this$0.failWebSocket(e2, response);
            Util.closeQuietly((Closeable) response);
            if (exchange != null) {
                exchange.webSocketUpgradeFailed();
            }
        }
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.this$0.failWebSocket(iOException, (Response) null);
    }
}
