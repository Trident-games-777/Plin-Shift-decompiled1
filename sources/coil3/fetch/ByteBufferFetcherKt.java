package coil3.fetch;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import okio.Source;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"asSource", "Lokio/Source;", "Ljava/nio/ByteBuffer;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: ByteBufferFetcher.kt */
public final class ByteBufferFetcherKt {
    public static final Source asSource(ByteBuffer byteBuffer) {
        return new ByteBufferFetcherKt$asSource$1(byteBuffer);
    }
}
