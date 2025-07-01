package coil3.network;

import coil3.network.NetworkHeaders;
import coil3.network.internal.UtilsKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcoil3/network/CacheNetworkResponse;", "", "<init>", "()V", "readFrom", "Lcoil3/network/NetworkResponse;", "source", "Lokio/BufferedSource;", "writeTo", "", "response", "sink", "Lokio/BufferedSink;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CacheNetworkResponse.kt */
public final class CacheNetworkResponse {
    public static final CacheNetworkResponse INSTANCE = new CacheNetworkResponse();

    private CacheNetworkResponse() {
    }

    public final NetworkResponse readFrom(BufferedSource bufferedSource) {
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        long parseLong = Long.parseLong(bufferedSource.readUtf8LineStrict());
        long parseLong2 = Long.parseLong(bufferedSource.readUtf8LineStrict());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int parseInt2 = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        for (int i = 0; i < parseInt2; i++) {
            UtilsKt.append(builder, bufferedSource.readUtf8LineStrict());
        }
        return new NetworkResponse(parseInt, parseLong, parseLong2, builder.build(), (NetworkResponseBody) null, (Object) null, 48, (DefaultConstructorMarker) null);
    }

    public final void writeTo(NetworkResponse networkResponse, BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong((long) networkResponse.getCode()).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.getRequestMillis()).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.getResponseMillis()).writeByte(10);
        Set<Map.Entry<String, List<String>>> entrySet = networkResponse.getHeaders().asMap().entrySet();
        int i = 0;
        for (Map.Entry value : entrySet) {
            i += ((List) value.getValue()).size();
        }
        bufferedSink.writeDecimalLong((long) i).writeByte(10);
        for (Map.Entry next : entrySet) {
            for (String writeUtf8 : (List) next.getValue()) {
                bufferedSink.writeUtf8((String) next.getKey()).writeUtf8(":").writeUtf8(writeUtf8).writeByte(10);
            }
        }
    }
}
