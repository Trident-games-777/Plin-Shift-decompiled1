package coil3.disk;

import coil3.util.Coroutines_nonJsCommonKt;
import coil3.util.FileSystems_androidKt;
import coil3.util.FileSystems_nonJsCommonKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache;", "", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "directory", "Lokio/Path;", "getDirectory", "()Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "openSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lcoil3/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "Snapshot", "Editor", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DiskCache.kt */
public interface DiskCache {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache$Editor;", "", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "commit", "", "commitAndOpenSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "abort", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskCache.kt */
    public interface Editor {
        void abort();

        void commit();

        Snapshot commitAndOpenSnapshot();

        Path getData();

        Path getMetadata();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "close", "", "closeAndOpenEditor", "Lcoil3/disk/DiskCache$Editor;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskCache.kt */
    public interface Snapshot extends AutoCloseable {
        void close();

        Editor closeAndOpenEditor();

        Path getData();

        Path getMetadata();
    }

    void clear();

    Path getDirectory();

    FileSystem getFileSystem();

    long getMaxSize();

    long getSize();

    Editor openEditor(String str);

    Snapshot openSnapshot(String str);

    boolean remove(String str);

    void shutdown();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/disk/DiskCache$Builder;", "", "<init>", "()V", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "maxSizePercent", "", "minimumMaxSizeBytes", "", "maximumMaxSizeBytes", "maxSizeBytes", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "percent", "size", "dispatcher", "build", "Lcoil3/disk/DiskCache;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskCache.kt */
    public static final class Builder {
        private CoroutineDispatcher cleanupDispatcher = Coroutines_nonJsCommonKt.ioCoroutineDispatcher();
        private Path directory;
        private FileSystem fileSystem = FileSystems_nonJsCommonKt.defaultFileSystem();
        private long maxSizeBytes;
        private double maxSizePercent = 0.02d;
        private long maximumMaxSizeBytes = 262144000;
        private long minimumMaxSizeBytes = 10485760;

        public final Builder directory(Path path) {
            Builder builder = this;
            this.directory = path;
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem2) {
            Builder builder = this;
            this.fileSystem = fileSystem2;
            return this;
        }

        public final Builder maxSizePercent(double d) {
            Builder builder = this;
            if (0.0d > d || d > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].".toString());
            }
            this.maxSizeBytes = 0;
            this.maxSizePercent = d;
            return this;
        }

        public final Builder minimumMaxSizeBytes(long j) {
            Builder builder = this;
            if (j > 0) {
                this.minimumMaxSizeBytes = j;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder maximumMaxSizeBytes(long j) {
            Builder builder = this;
            if (j > 0) {
                this.maximumMaxSizeBytes = j;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder maxSizeBytes(long j) {
            Builder builder = this;
            if (j > 0) {
                this.maxSizePercent = 0.0d;
                this.maxSizeBytes = j;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder cleanupDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.cleanupDispatcher = coroutineDispatcher;
            return this;
        }

        public final DiskCache build() {
            long j;
            Path path = this.directory;
            if (path != null) {
                double d = this.maxSizePercent;
                if (d > 0.0d) {
                    try {
                        j = RangesKt.coerceIn((long) (d * ((double) FileSystems_androidKt.remainingFreeSpaceBytes(this.fileSystem, path))), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                    } catch (Exception unused) {
                        j = this.minimumMaxSizeBytes;
                    }
                } else {
                    j = this.maxSizeBytes;
                }
                return new RealDiskCache(j, path, this.fileSystem, this.cleanupDispatcher);
            }
            throw new IllegalStateException("directory == null".toString());
        }
    }
}
