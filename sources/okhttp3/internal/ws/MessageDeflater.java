package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "deflater", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "close", "", "deflate", "buffer", "endsWith", "suffix", "Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MessageDeflater.kt */
public final class MessageDeflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Deflater deflater2 = new Deflater(-1, true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((Sink) buffer, deflater2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void deflate(okio.Buffer r6) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "buffer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            okio.Buffer r0 = r5.deflatedBytes
            long r0 = r0.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0068
            boolean r0 = r5.noContextTakeover
            if (r0 == 0) goto L_0x001a
            java.util.zip.Deflater r0 = r5.deflater
            r0.reset()
        L_0x001a:
            okio.DeflaterSink r0 = r5.deflaterSink
            long r1 = r6.size()
            r0.write(r6, r1)
            okio.DeflaterSink r0 = r5.deflaterSink
            r0.flush()
            okio.Buffer r0 = r5.deflatedBytes
            okio.ByteString r1 = okhttp3.internal.ws.MessageDeflaterKt.EMPTY_DEFLATE_BLOCK
            boolean r0 = r5.endsWith(r0, r1)
            if (r0 == 0) goto L_0x0058
            okio.Buffer r0 = r5.deflatedBytes
            long r0 = r0.size()
            r2 = 4
            long r2 = (long) r2
            long r0 = r0 - r2
            okio.Buffer r2 = r5.deflatedBytes
            r3 = 1
            r4 = 0
            okio.Buffer$UnsafeCursor r2 = okio.Buffer.readAndWriteUnsafe$default(r2, r4, r3, r4)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            okio.Buffer$UnsafeCursor r3 = (okio.Buffer.UnsafeCursor) r3     // Catch:{ all -> 0x0051 }
            r3.resizeBuffer(r0)     // Catch:{ all -> 0x0051 }
            kotlin.io.CloseableKt.closeFinally(r2, r4)
            goto L_0x005e
        L_0x0051:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)
            throw r0
        L_0x0058:
            okio.Buffer r0 = r5.deflatedBytes
            r1 = 0
            r0.writeByte((int) r1)
        L_0x005e:
            okio.Buffer r0 = r5.deflatedBytes
            long r1 = r0.size()
            r6.write((okio.Buffer) r0, (long) r1)
            return
        L_0x0068:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.MessageDeflater.deflate(okio.Buffer):void");
    }

    public void close() throws IOException {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer buffer, ByteString byteString) {
        return buffer.rangeEquals(buffer.size() - ((long) byteString.size()), byteString);
    }
}
