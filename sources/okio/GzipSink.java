package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._ZlibJvmKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0011\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0007¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u00060\nj\u0002`\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GzipSink.kt */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink2);
        this.sink = realBufferedSink;
        Deflater deflater2 = new Deflater(_ZlibJvmKt.getDEFAULT_COMPRESSION(), true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((BufferedSink) realBufferedSink, deflater2);
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    public void write(Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (i != 0) {
            updateCrc(buffer, j);
            this.deflaterSink.write(buffer, j);
        }
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                this.deflaterSink.finishDeflate$okio();
                writeFooter();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private final void updateCrc(Buffer buffer, long j) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        while (j > 0) {
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.crc.update(segment.data, segment.pos, min);
            j -= (long) min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m9617deprecated_deflater() {
        return this.deflater;
    }
}
