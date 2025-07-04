package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FileOperator.kt */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel2) {
        Intrinsics.checkNotNullParameter(fileChannel2, "fileChannel");
        this.fileChannel = fileChannel2;
    }

    public final void write(long j, Buffer buffer, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }

    public final void read(long j, Buffer buffer, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (j2 >= 0) {
            long j3 = j;
            long j4 = j2;
            while (j4 > 0) {
                long transferTo = this.fileChannel.transferTo(j3, j4, buffer);
                j3 += transferTo;
                j4 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
