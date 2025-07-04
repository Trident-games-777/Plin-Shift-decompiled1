package okhttp3.internal.cache2;

import coil3.util.UtilsKt;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Relay.kt */
public final class Relay {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
    public static final ByteString PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j, byteString, j2);
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    /* access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j);
        buffer2.writeLong(j2);
        if (buffer2.size() == FILE_HEADER_SIZE) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.checkNotNull(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            new FileOperator(channel).write(0, buffer2, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j, buffer2, (long) this.metadata.size());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            try {
                this.complete = true;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly((Closeable) source);
        }
        this.upstream = null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Relay.kt */
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.checkNotNull(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
            r9 = r8.getUpstreamPos() - r8.getBuffer().size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
            if (r1.sourcePos >= r9) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
            if (r0 != true) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
            r6 = java.lang.Math.min(r2, r1.this$0.getUpstreamPos() - r1.sourcePos);
            r2 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2.read(r1.sourcePos + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r5, r6);
            r1.sourcePos += r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
            return r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r0 = r1.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
            r11 = r0.read(r1.this$0.getUpstreamBuffer(), r1.this$0.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
            if (r11 != -1) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
            r0 = r1.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r6 = java.lang.Math.min(r11, r2);
            r1.this$0.getUpstreamBuffer().copyTo(r20, 0, r6);
            r1.sourcePos += r6;
            r13 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            r17 = r11;
            r13.write(r1.this$0.getUpstreamPos() + okhttp3.internal.cache2.Relay.FILE_HEADER_SIZE, r1.this$0.getUpstreamBuffer().clone(), r17);
            r2 = r17;
            r4 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e8, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r4.getBuffer().write(r4.getUpstreamBuffer(), r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0102, code lost:
            if (r4.getBuffer().size() <= r4.getBufferMaxSize()) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
            r4.getBuffer().skip(r4.getBuffer().size() - r4.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0118, code lost:
            r4.setUpstreamPos(r4.getUpstreamPos() + r2);
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0123, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0136, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0137, code lost:
            return r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x013e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x013f, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0141, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r3 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0150, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            r6 = java.lang.Math.min(r2, r8.getUpstreamPos() - r1.sourcePos);
            r8.getBuffer().copyTo(r20, r1.sourcePos - r9, r6);
            r1.sourcePos += r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0172, code lost:
            return r6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                r19 = this;
                r1 = r19
                r2 = r21
                java.lang.String r0 = "sink"
                r5 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0176
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r8)
            L_0x0012:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0173 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0173 }
                int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                r4 = 2
                r6 = -1
                if (r0 != 0) goto L_0x003c
                boolean r0 = r8.getComplete()     // Catch:{ all -> 0x0173 }
                if (r0 == 0) goto L_0x0027
                monitor-exit(r8)
                return r6
            L_0x0027:
                java.lang.Thread r0 = r8.getUpstreamReader()     // Catch:{ all -> 0x0173 }
                if (r0 == 0) goto L_0x0033
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0173 }
                r0.waitUntilNotified(r8)     // Catch:{ all -> 0x0173 }
                goto L_0x0012
            L_0x0033:
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0173 }
                r8.setUpstreamReader(r0)     // Catch:{ all -> 0x0173 }
                r0 = 1
                goto L_0x0050
            L_0x003c:
                long r9 = r8.getUpstreamPos()     // Catch:{ all -> 0x0173 }
                okio.Buffer r0 = r8.getBuffer()     // Catch:{ all -> 0x0173 }
                long r11 = r0.size()     // Catch:{ all -> 0x0173 }
                long r9 = r9 - r11
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0173 }
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 >= 0) goto L_0x0154
                r0 = r4
            L_0x0050:
                monitor-exit(r8)
                r8 = 32
                if (r0 != r4) goto L_0x0073
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this
                long r6 = r0.getUpstreamPos()
                long r10 = r1.sourcePos
                long r6 = r6 - r10
                long r6 = java.lang.Math.min(r2, r6)
                okhttp3.internal.cache2.FileOperator r2 = r1.fileOperator
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                long r3 = r1.sourcePos
                long r3 = r3 + r8
                r2.read(r3, r5, r6)
                long r2 = r1.sourcePos
                long r2 = r2 + r6
                r1.sourcePos = r2
                return r6
            L_0x0073:
                r10 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                okio.Source r0 = r0.getUpstream()     // Catch:{ all -> 0x013e }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                okio.Buffer r4 = r4.getUpstreamBuffer()     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                long r11 = r5.getBufferMaxSize()     // Catch:{ all -> 0x013e }
                long r11 = r0.read(r4, r11)     // Catch:{ all -> 0x013e }
                int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r0 != 0) goto L_0x00b2
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x013e }
                r0.commit(r2)     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x00af }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r0)     // Catch:{ all -> 0x00af }
                r0 = r2
                java.lang.Object r0 = (java.lang.Object) r0     // Catch:{ all -> 0x00af }
                r0.notifyAll()     // Catch:{ all -> 0x00af }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00af }
                monitor-exit(r2)
                return r6
            L_0x00af:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x00b2:
                long r6 = java.lang.Math.min(r11, r2)     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                okio.Buffer r2 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x013e }
                r4 = 0
                r3 = r20
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x013e }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x013e }
                long r2 = r2 + r6
                r1.sourcePos = r2     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator     // Catch:{ all -> 0x013e }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x013e }
                long r14 = r2 + r8
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                okio.Buffer r0 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x013e }
                okio.Buffer r16 = r0.clone()     // Catch:{ all -> 0x013e }
                r17 = r11
                r13.write(r14, r16, r17)     // Catch:{ all -> 0x013e }
                r2 = r17
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013e }
                monitor-enter(r4)     // Catch:{ all -> 0x013e }
                okio.Buffer r0 = r4.getBuffer()     // Catch:{ all -> 0x013b }
                okio.Buffer r5 = r4.getUpstreamBuffer()     // Catch:{ all -> 0x013b }
                r0.write((okio.Buffer) r5, (long) r2)     // Catch:{ all -> 0x013b }
                okio.Buffer r0 = r4.getBuffer()     // Catch:{ all -> 0x013b }
                long r8 = r0.size()     // Catch:{ all -> 0x013b }
                long r11 = r4.getBufferMaxSize()     // Catch:{ all -> 0x013b }
                int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x0118
                okio.Buffer r0 = r4.getBuffer()     // Catch:{ all -> 0x013b }
                okio.Buffer r5 = r4.getBuffer()     // Catch:{ all -> 0x013b }
                long r8 = r5.size()     // Catch:{ all -> 0x013b }
                long r11 = r4.getBufferMaxSize()     // Catch:{ all -> 0x013b }
                long r8 = r8 - r11
                r0.skip(r8)     // Catch:{ all -> 0x013b }
            L_0x0118:
                long r8 = r4.getUpstreamPos()     // Catch:{ all -> 0x013b }
                long r8 = r8 + r2
                r4.setUpstreamPos(r8)     // Catch:{ all -> 0x013b }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x013b }
                monitor-exit(r4)     // Catch:{ all -> 0x013e }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0138 }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r0)     // Catch:{ all -> 0x0138 }
                r0 = r2
                java.lang.Object r0 = (java.lang.Object) r0     // Catch:{ all -> 0x0138 }
                r0.notifyAll()     // Catch:{ all -> 0x0138 }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0138 }
                monitor-exit(r2)
                return r6
            L_0x0138:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x013b:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x013e }
                throw r0     // Catch:{ all -> 0x013e }
            L_0x013e:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0151 }
                java.lang.String r3 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)     // Catch:{ all -> 0x0151 }
                r2.notifyAll()     // Catch:{ all -> 0x0151 }
                kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0151 }
                monitor-exit(r2)
                throw r0
            L_0x0151:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0154:
                long r4 = r8.getUpstreamPos()     // Catch:{ all -> 0x0173 }
                long r6 = r1.sourcePos     // Catch:{ all -> 0x0173 }
                long r4 = r4 - r6
                long r6 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0173 }
                okio.Buffer r2 = r8.getBuffer()     // Catch:{ all -> 0x0173 }
                long r3 = r1.sourcePos     // Catch:{ all -> 0x0173 }
                long r4 = r3 - r9
                r3 = r20
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x0173 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x0173 }
                long r2 = r2 + r6
                r1.sourcePos = r2     // Catch:{ all -> 0x0173 }
                monitor-exit(r8)
                return r6
            L_0x0173:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            L_0x0176:
                java.lang.String r0 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = Relay.this;
                synchronized (relay) {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        RandomAccessFile file = relay.getFile();
                        relay.setFile((RandomAccessFile) null);
                        randomAccessFile = file;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Relay.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
            Intrinsics.checkNotNullParameter(file, UtilsKt.SCHEME_FILE);
            Intrinsics.checkNotNullParameter(source, "upstream");
            Intrinsics.checkNotNullParameter(byteString, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0, byteString, j, (DefaultConstructorMarker) null);
            randomAccessFile.setLength(0);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1, -1);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, UtilsKt.SCHEME_FILE);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0, buffer, Relay.FILE_HEADER_SIZE);
            if (Intrinsics.areEqual((Object) buffer.readByteString((long) Relay.PREFIX_CLEAN.size()), (Object) Relay.PREFIX_CLEAN)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(Relay.FILE_HEADER_SIZE + readLong, buffer2, readLong2);
                return new Relay(randomAccessFile, (Source) null, readLong, buffer2.readByteString(), 0, (DefaultConstructorMarker) null);
            }
            throw new IOException("unreadable cache file");
        }
    }
}
