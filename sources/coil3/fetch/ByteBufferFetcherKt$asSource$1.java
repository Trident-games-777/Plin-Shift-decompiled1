package coil3.fetch;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0018\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"coil3/fetch/ByteBufferFetcherKt$asSource$1", "Lokio/Source;", "buffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "Ljava/nio/ByteBuffer;", "len", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ByteBufferFetcher.kt */
public final class ByteBufferFetcherKt$asSource$1 implements Source {
    private final ByteBuffer buffer;
    private final int len;

    public void close() {
    }

    ByteBufferFetcherKt$asSource$1(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        this.buffer = slice;
        this.len = slice.capacity();
    }

    public long read(Buffer buffer2, long j) {
        if (this.buffer.position() == this.len) {
            return -1;
        }
        this.buffer.limit(RangesKt.coerceAtMost((int) (((long) this.buffer.position()) + j), this.len));
        return (long) buffer2.write(this.buffer);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }
}
