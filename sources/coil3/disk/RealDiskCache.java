package coil3.disk;

import coil3.disk.DiskCache;
import coil3.disk.DiskLruCache;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0003\"#$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\f\u0010!\u001a\u00020\u0019*\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006%"}, d2 = {"Lcoil3/disk/RealDiskCache;", "Lcoil3/disk/DiskCache;", "maxSize", "", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(JLokio/Path;Lokio/FileSystem;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getMaxSize", "()J", "getDirectory", "()Lokio/Path;", "getFileSystem", "()Lokio/FileSystem;", "cache", "Lcoil3/disk/DiskLruCache;", "size", "getSize", "openSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lcoil3/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "hash", "RealSnapshot", "RealEditor", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RealDiskCache.kt */
public final class RealDiskCache implements DiskCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ENTRY_DATA = 1;
    private static final int ENTRY_METADATA = 0;
    private final DiskLruCache cache;
    private final Path directory;
    private final FileSystem fileSystem;
    private final long maxSize;

    public RealDiskCache(long j, Path path, FileSystem fileSystem2, CoroutineDispatcher coroutineDispatcher) {
        this.maxSize = j;
        this.directory = path;
        this.fileSystem = fileSystem2;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), coroutineDispatcher, getMaxSize(), 3, 2);
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public Path getDirectory() {
        return this.directory;
    }

    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public long getSize() {
        return this.cache.size();
    }

    public DiskCache.Snapshot openSnapshot(String str) {
        DiskLruCache.Snapshot snapshot = this.cache.get(hash(str));
        return snapshot != null ? new RealSnapshot(snapshot) : null;
    }

    public DiskCache.Editor openEditor(String str) {
        DiskLruCache.Editor edit = this.cache.edit(hash(str));
        return edit != null ? new RealEditor(edit) : null;
    }

    public boolean remove(String str) {
        return this.cache.remove(hash(str));
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void shutdown() {
        UtilsKt.closeQuietly((AutoCloseable) this.cache);
    }

    private final String hash(String str) {
        return ByteString.Companion.encodeUtf8(str).sha256().hex();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0011"}, d2 = {"Lcoil3/disk/RealDiskCache$RealSnapshot;", "Lcoil3/disk/DiskCache$Snapshot;", "snapshot", "Lcoil3/disk/DiskLruCache$Snapshot;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache$Snapshot;)V", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "close", "", "closeAndOpenEditor", "Lcoil3/disk/RealDiskCache$RealEditor;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: RealDiskCache.kt */
    private static final class RealSnapshot implements DiskCache.Snapshot {
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot2) {
            this.snapshot = snapshot2;
        }

        public Path getMetadata() {
            return this.snapshot.file(0);
        }

        public Path getData() {
            return this.snapshot.file(1);
        }

        public void close() {
            this.snapshot.close();
        }

        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor closeAndEdit = this.snapshot.closeAndEdit();
            if (closeAndEdit != null) {
                return new RealEditor(closeAndEdit);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcoil3/disk/RealDiskCache$RealEditor;", "Lcoil3/disk/DiskCache$Editor;", "editor", "Lcoil3/disk/DiskLruCache$Editor;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache$Editor;)V", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "commit", "", "commitAndOpenSnapshot", "Lcoil3/disk/RealDiskCache$RealSnapshot;", "abort", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: RealDiskCache.kt */
    private static final class RealEditor implements DiskCache.Editor {
        private final DiskLruCache.Editor editor;

        public RealEditor(DiskLruCache.Editor editor2) {
            this.editor = editor2;
        }

        public Path getMetadata() {
            return this.editor.file(0);
        }

        public Path getData() {
            return this.editor.file(1);
        }

        public void commit() {
            this.editor.commit();
        }

        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot commitAndGet = this.editor.commitAndGet();
            if (commitAndGet != null) {
                return new RealSnapshot(commitAndGet);
            }
            return null;
        }

        public void abort() {
            this.editor.abort();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcoil3/disk/RealDiskCache$Companion;", "", "<init>", "()V", "ENTRY_METADATA", "", "ENTRY_DATA", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: RealDiskCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
