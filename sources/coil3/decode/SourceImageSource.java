package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.UtilsKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil3/decode/SourceImageSource;", "Lcoil3/decode/ImageSource;", "source", "Lokio/BufferedSource;", "fileSystem", "Lokio/FileSystem;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "<init>", "(Lokio/BufferedSource;Lokio/FileSystem;Lcoil3/decode/ImageSource$Metadata;)V", "getFileSystem", "()Lokio/FileSystem;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "isClosed", "", "file", "Lokio/Path;", "sourceOrNull", "fileOrNull", "close", "", "assertNotClosed", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageSource.kt */
public final class SourceImageSource implements ImageSource {
    private Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final Object lock = new Object();
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public SourceImageSource(BufferedSource bufferedSource, FileSystem fileSystem2, ImageSource.Metadata metadata2) {
        this.fileSystem = fileSystem2;
        this.metadata = metadata2;
        this.source = bufferedSource;
    }

    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    public BufferedSource source() {
        synchronized (this.lock) {
            assertNotClosed();
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            FileSystem fileSystem2 = getFileSystem();
            Path path = this.file;
            Intrinsics.checkNotNull(path);
            BufferedSource buffer = Okio.buffer(fileSystem2.source(path));
            this.source = buffer;
            return buffer;
        }
    }

    public BufferedSource sourceOrNull() {
        return source();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[Catch:{ all -> 0x003f, all -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053 A[SYNTHETIC, Splitter:B:29:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.Path file() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r6.assertNotClosed()     // Catch:{ all -> 0x0054 }
            okio.Path r1 = r6.file     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r1
        L_0x000c:
            okio.FileSystem r1 = r6.getFileSystem()     // Catch:{ all -> 0x0054 }
            okio.Path r1 = coil3.util.FileSystemsKt.createTempFile(r1)     // Catch:{ all -> 0x0054 }
            okio.FileSystem r2 = r6.getFileSystem()     // Catch:{ all -> 0x0054 }
            r3 = 0
            okio.Sink r2 = r2.sink(r1, r3)     // Catch:{ all -> 0x0054 }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x0054 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0054 }
            r3 = 0
            r4 = r2
            okio.BufferedSink r4 = (okio.BufferedSink) r4     // Catch:{ all -> 0x003f }
            okio.BufferedSource r5 = r6.source     // Catch:{ all -> 0x003f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x003f }
            okio.Source r5 = (okio.Source) r5     // Catch:{ all -> 0x003f }
            long r4 = r4.writeAll(r5)     // Catch:{ all -> 0x003f }
            java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r2 = move-exception
            goto L_0x004b
        L_0x003d:
            r2 = r3
            goto L_0x004b
        L_0x003f:
            r4 = move-exception
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r2 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r2)     // Catch:{ all -> 0x0054 }
        L_0x004a:
            r2 = r4
        L_0x004b:
            if (r2 != 0) goto L_0x0053
            r6.source = r3     // Catch:{ all -> 0x0054 }
            r6.file = r1     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)
            return r1
        L_0x0053:
            throw r2     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.SourceImageSource.file():okio.Path");
    }

    public Path fileOrNull() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
    }

    public void close() {
        synchronized (this.lock) {
            this.isClosed = true;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                UtilsKt.closeQuietly((Closeable) bufferedSource);
            }
            Path path = this.file;
            if (path != null) {
                getFileSystem().delete(path);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void assertNotClosed() {
        if (this.isClosed) {
            throw new IllegalStateException("closed".toString());
        }
    }
}
