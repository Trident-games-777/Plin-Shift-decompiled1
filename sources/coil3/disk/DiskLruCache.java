package coil3.disk;

import coil3.util.Collections_jvmCommonKt;
import coil3.util.FileSystemsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001&\b\u0000\u0018\u0000 H2\u00060\u0001j\u0002`\u0002:\u0004EFGHB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0017\u00100\u001a\b\u0018\u000101R\u00020\u00002\u0006\u00102\u001a\u00020\u0015H\u0002J\u0014\u00103\u001a\b\u0018\u000104R\u00020\u00002\u0006\u00102\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\nJ\u001c\u00105\u001a\u00020)2\n\u00106\u001a\u000604R\u00020\u00002\u0006\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\u000e\u00109\u001a\u00020!2\u0006\u00102\u001a\u00020\u0015J\u0014\u0010:\u001a\u00020!2\n\u0010;\u001a\u00060\u0016R\u00020\u0000H\u0002J\b\u0010<\u001a\u00020)H\u0002J\b\u0010=\u001a\u00020)H\u0016J\u0006\u0010>\u001a\u00020)J\b\u0010?\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020!H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u0006\u0010B\u001a\u00020)J\b\u0010C\u001a\u00020)H\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u00102\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060\u0016R\u00020\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006I"}, d2 = {"Lcoil3/disk/DiskLruCache;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "fileSystem", "Lokio/FileSystem;", "directory", "Lokio/Path;", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "maxSize", "", "appVersion", "", "valueCount", "<init>", "(Lokio/FileSystem;Lokio/Path;Lkotlinx/coroutines/CoroutineDispatcher;JII)V", "journalFile", "journalFileTmp", "journalFileBackup", "lruEntries", "", "", "Lcoil3/disk/DiskLruCache$Entry;", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "size", "operationsSinceRewrite", "journalWriter", "Lokio/BufferedSink;", "hasJournalErrors", "", "initialized", "closed", "mostRecentTrimFailed", "mostRecentRebuildFailed", "coil3/disk/DiskLruCache$fileSystem$1", "Lcoil3/disk/DiskLruCache$fileSystem$1;", "initialize", "", "readJournal", "newJournalWriter", "readJournalLine", "line", "processJournal", "writeJournal", "get", "Lcoil3/disk/DiskLruCache$Snapshot;", "key", "edit", "Lcoil3/disk/DiskLruCache$Editor;", "completeEdit", "editor", "success", "journalRewriteRequired", "remove", "removeEntry", "entry", "checkNotClosed", "close", "flush", "trimToSize", "removeOldestEntry", "delete", "evictAll", "launchCleanup", "validateKey", "Snapshot", "Editor", "Entry", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache implements AutoCloseable {
    private static final String CLEAN = "CLEAN";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TMP = "journal.tmp";
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    public static final String VERSION = "1";
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    /* access modifiers changed from: private */
    public boolean closed;
    /* access modifiers changed from: private */
    public final Path directory;
    /* access modifiers changed from: private */
    public final DiskLruCache$fileSystem$1 fileSystem;
    private boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    /* access modifiers changed from: private */
    public BufferedSink journalWriter;
    /* access modifiers changed from: private */
    public final Object lock;
    private final Map<String, Entry> lruEntries;
    private final long maxSize;
    /* access modifiers changed from: private */
    public boolean mostRecentRebuildFailed;
    /* access modifiers changed from: private */
    public boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    /* access modifiers changed from: private */
    public final int valueCount;

    public DiskLruCache(FileSystem fileSystem2, Path path, CoroutineDispatcher coroutineDispatcher, long j, int i, int i2) {
        this.directory = path;
        this.maxSize = j;
        this.appVersion = i;
        this.valueCount = i2;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        } else if (i2 > 0) {
            this.journalFile = path.resolve(JOURNAL_FILE);
            this.journalFileTmp = path.resolve(JOURNAL_FILE_TMP);
            this.journalFileBackup = path.resolve(JOURNAL_FILE_BACKUP);
            this.lruEntries = Collections_jvmCommonKt.LruMutableMap$default(0, 0.0f, 3, (Object) null);
            this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(CoroutineDispatcher.limitedParallelism$default(coroutineDispatcher, 1, (String) null, 2, (Object) null)));
            this.lock = new Object();
            this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem2);
        } else {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
    }

    public final void initialize() {
        synchronized (this.lock) {
            if (!this.initialized) {
                this.fileSystem.delete(this.journalFileTmp);
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.delete(this.journalFileBackup);
                    } else {
                        this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    try {
                        readJournal();
                        processJournal();
                        this.initialized = true;
                        return;
                    } catch (IOException unused) {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
                writeJournal();
                this.initialized = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|(1:19)(1:20)|21|(2:23|24)|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r10.operationsSinceRewrite = r0 - r10.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        if (r3.exhausted() == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        writeJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        r10.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        if (r2 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0067 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0067=Splitter:B:16:0x0067, B:27:0x008c=Splitter:B:27:0x008c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() {
        /*
            r10 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r10.fileSystem
            okio.FileSystem r2 = (okio.FileSystem) r2
            okio.Path r3 = r10.journalFile
            okio.Source r2 = r2.source(r3)
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r2)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c5 }
            java.lang.String r7 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c5 }
            java.lang.String r8 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c5 }
            java.lang.String r9 = "libcore.io.DiskLruCache"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x008c
            java.lang.String r9 = "1"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x008c
            int r9 = r10.appVersion     // Catch:{ all -> 0x00c5 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00c5 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x008c
            int r9 = r10.valueCount     // Catch:{ all -> 0x00c5 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00c5 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x008c
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x00c5 }
            int r9 = r9.length()     // Catch:{ all -> 0x00c5 }
            if (r9 > 0) goto L_0x008c
            r0 = 0
        L_0x005d:
            java.lang.String r1 = r3.readUtf8LineStrict()     // Catch:{ EOFException -> 0x0067 }
            r10.readJournalLine(r1)     // Catch:{ EOFException -> 0x0067 }
            int r0 = r0 + 1
            goto L_0x005d
        L_0x0067:
            java.util.Map<java.lang.String, coil3.disk.DiskLruCache$Entry> r1 = r10.lruEntries     // Catch:{ all -> 0x00c5 }
            int r1 = r1.size()     // Catch:{ all -> 0x00c5 }
            int r0 = r0 - r1
            r10.operationsSinceRewrite = r0     // Catch:{ all -> 0x00c5 }
            boolean r0 = r3.exhausted()     // Catch:{ all -> 0x00c5 }
            if (r0 != 0) goto L_0x007a
            r10.writeJournal()     // Catch:{ all -> 0x00c5 }
            goto L_0x0080
        L_0x007a:
            okio.BufferedSink r0 = r10.newJournalWriter()     // Catch:{ all -> 0x00c5 }
            r10.journalWriter = r0     // Catch:{ all -> 0x00c5 }
        L_0x0080:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ all -> 0x0088 }
            goto L_0x008a
        L_0x0088:
            r0 = move-exception
            goto L_0x00d0
        L_0x008a:
            r0 = 0
            goto L_0x00d0
        L_0x008c:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
            r9.<init>(r1)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r9.append(r4)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch:{ all -> 0x00c5 }
            r1 = 93
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c5 }
            r3.<init>(r0)     // Catch:{ all -> 0x00c5 }
            throw r3     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            if (r2 == 0) goto L_0x00d0
            r2.close()     // Catch:{ all -> 0x00cc }
            goto L_0x00d0
        L_0x00cc:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r0, r1)
        L_0x00d0:
            if (r0 != 0) goto L_0x00d3
            return
        L_0x00d3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.readJournal():void");
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$$ExternalSyntheticLambda0(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit newJournalWriter$lambda$4(DiskLruCache diskLruCache, IOException iOException) {
        diskLruCache.hasJournalErrors = true;
        return Unit.INSTANCE;
    }

    private final void readJournalLine(String str) {
        String str2;
        String str3 = str;
        CharSequence charSequence = str3;
        int indexOf$default = StringsKt.indexOf$default(charSequence, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                str2 = str3.substring(i);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                if (indexOf$default == 6 && StringsKt.startsWith$default(str3, REMOVE, false, 2, (Object) null)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str3.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
            }
            Map<String, Entry> map = this.lruEntries;
            Entry entry = map.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                map.put(str2, entry);
            }
            Entry entry2 = entry;
            if (indexOf$default2 != -1 && indexOf$default == 5 && StringsKt.startsWith$default(str3, CLEAN, false, 2, (Object) null)) {
                String substring = str3.substring(indexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                List split$default = StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                entry2.setReadable(true);
                entry2.setCurrentEditor((Editor) null);
                entry2.setLengths(split$default);
            } else if (indexOf$default2 == -1 && indexOf$default == 5 && StringsKt.startsWith$default(str3, DIRTY, false, 2, (Object) null)) {
                entry2.setCurrentEditor(new Editor(entry2));
            } else if (indexOf$default2 != -1 || indexOf$default != 4 || !StringsKt.startsWith$default(str3, READ, false, 2, (Object) null)) {
                throw new IOException("unexpected journal line: " + str3);
            }
        } else {
            throw new IOException("unexpected journal line: " + str3);
        }
    }

    private final void processJournal() {
        Iterator<Entry> it = this.lruEntries.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.getCurrentEditor() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    j += next.getLengths()[i];
                    i++;
                }
            } else {
                next.setCurrentEditor((Editor) null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(next.getCleanFiles().get(i));
                    this.fileSystem.delete(next.getDirtyFiles().get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.size = j;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa A[Catch:{ all -> 0x009c, all -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7 A[SYNTHETIC, Splitter:B:38:0x00e7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeJournal() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.lock
            monitor-enter(r0)
            okio.BufferedSink r1 = r9.journalWriter     // Catch:{ all -> 0x00e8 }
            if (r1 == 0) goto L_0x000a
            r1.close()     // Catch:{ all -> 0x00e8 }
        L_0x000a:
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.FileSystem r1 = (okio.FileSystem) r1     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFileTmp     // Catch:{ all -> 0x00e8 }
            r3 = 0
            okio.Sink r1 = r1.sink(r2, r3)     // Catch:{ all -> 0x00e8 }
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)     // Catch:{ all -> 0x00e8 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x00e8 }
            r2 = r1
            okio.BufferedSink r2 = (okio.BufferedSink) r2     // Catch:{ all -> 0x009c }
            java.lang.String r4 = "libcore.io.DiskLruCache"
            okio.BufferedSink r4 = r2.writeUtf8(r4)     // Catch:{ all -> 0x009c }
            r5 = 10
            r4.writeByte(r5)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = "1"
            okio.BufferedSink r4 = r2.writeUtf8(r4)     // Catch:{ all -> 0x009c }
            r4.writeByte(r5)     // Catch:{ all -> 0x009c }
            int r4 = r9.appVersion     // Catch:{ all -> 0x009c }
            long r6 = (long) r4     // Catch:{ all -> 0x009c }
            okio.BufferedSink r4 = r2.writeDecimalLong(r6)     // Catch:{ all -> 0x009c }
            r4.writeByte(r5)     // Catch:{ all -> 0x009c }
            int r4 = r9.valueCount     // Catch:{ all -> 0x009c }
            long r6 = (long) r4     // Catch:{ all -> 0x009c }
            okio.BufferedSink r4 = r2.writeDecimalLong(r6)     // Catch:{ all -> 0x009c }
            r4.writeByte(r5)     // Catch:{ all -> 0x009c }
            r2.writeByte(r5)     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, coil3.disk.DiskLruCache$Entry> r4 = r9.lruEntries     // Catch:{ all -> 0x009c }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x009c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x009c }
        L_0x0053:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x009c }
            if (r6 == 0) goto L_0x0090
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x009c }
            coil3.disk.DiskLruCache$Entry r6 = (coil3.disk.DiskLruCache.Entry) r6     // Catch:{ all -> 0x009c }
            coil3.disk.DiskLruCache$Editor r7 = r6.getCurrentEditor()     // Catch:{ all -> 0x009c }
            r8 = 32
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "DIRTY"
            r2.writeUtf8(r7)     // Catch:{ all -> 0x009c }
            r2.writeByte(r8)     // Catch:{ all -> 0x009c }
            java.lang.String r6 = r6.getKey()     // Catch:{ all -> 0x009c }
            r2.writeUtf8(r6)     // Catch:{ all -> 0x009c }
            r2.writeByte(r5)     // Catch:{ all -> 0x009c }
            goto L_0x0053
        L_0x007a:
            java.lang.String r7 = "CLEAN"
            r2.writeUtf8(r7)     // Catch:{ all -> 0x009c }
            r2.writeByte(r8)     // Catch:{ all -> 0x009c }
            java.lang.String r7 = r6.getKey()     // Catch:{ all -> 0x009c }
            r2.writeUtf8(r7)     // Catch:{ all -> 0x009c }
            r6.writeLengths(r2)     // Catch:{ all -> 0x009c }
            r2.writeByte(r5)     // Catch:{ all -> 0x009c }
            goto L_0x0053
        L_0x0090:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x009a
            r1.close()     // Catch:{ all -> 0x0098 }
            goto L_0x009a
        L_0x0098:
            r1 = move-exception
            goto L_0x00a8
        L_0x009a:
            r1 = 0
            goto L_0x00a8
        L_0x009c:
            r2 = move-exception
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ all -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r2, r1)     // Catch:{ all -> 0x00e8 }
        L_0x00a7:
            r1 = r2
        L_0x00a8:
            if (r1 != 0) goto L_0x00e7
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFile     // Catch:{ all -> 0x00e8 }
            boolean r1 = r1.exists(r2)     // Catch:{ all -> 0x00e8 }
            if (r1 == 0) goto L_0x00ce
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFile     // Catch:{ all -> 0x00e8 }
            okio.Path r4 = r9.journalFileBackup     // Catch:{ all -> 0x00e8 }
            r1.atomicMove(r2, r4)     // Catch:{ all -> 0x00e8 }
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFileTmp     // Catch:{ all -> 0x00e8 }
            okio.Path r4 = r9.journalFile     // Catch:{ all -> 0x00e8 }
            r1.atomicMove(r2, r4)     // Catch:{ all -> 0x00e8 }
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFileBackup     // Catch:{ all -> 0x00e8 }
            r1.delete(r2)     // Catch:{ all -> 0x00e8 }
            goto L_0x00d7
        L_0x00ce:
            coil3.disk.DiskLruCache$fileSystem$1 r1 = r9.fileSystem     // Catch:{ all -> 0x00e8 }
            okio.Path r2 = r9.journalFileTmp     // Catch:{ all -> 0x00e8 }
            okio.Path r4 = r9.journalFile     // Catch:{ all -> 0x00e8 }
            r1.atomicMove(r2, r4)     // Catch:{ all -> 0x00e8 }
        L_0x00d7:
            okio.BufferedSink r1 = r9.newJournalWriter()     // Catch:{ all -> 0x00e8 }
            r9.journalWriter = r1     // Catch:{ all -> 0x00e8 }
            r9.operationsSinceRewrite = r3     // Catch:{ all -> 0x00e8 }
            r9.hasJournalErrors = r3     // Catch:{ all -> 0x00e8 }
            r9.mostRecentRebuildFailed = r3     // Catch:{ all -> 0x00e8 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e8 }
            monitor-exit(r0)
            return
        L_0x00e7:
            throw r1     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.writeJournal():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil3.disk.DiskLruCache.Snapshot get(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            r4.checkNotClosed()     // Catch:{ all -> 0x0048 }
            r4.validateKey(r5)     // Catch:{ all -> 0x0048 }
            r4.initialize()     // Catch:{ all -> 0x0048 }
            java.util.Map<java.lang.String, coil3.disk.DiskLruCache$Entry> r1 = r4.lruEntries     // Catch:{ all -> 0x0048 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0048 }
            coil3.disk.DiskLruCache$Entry r1 = (coil3.disk.DiskLruCache.Entry) r1     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0045
            coil3.disk.DiskLruCache$Snapshot r1 = r1.snapshot()     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x001d
            goto L_0x0045
        L_0x001d:
            int r2 = r4.operationsSinceRewrite     // Catch:{ all -> 0x0048 }
            int r2 = r2 + 1
            r4.operationsSinceRewrite = r2     // Catch:{ all -> 0x0048 }
            okio.BufferedSink r2 = r4.journalWriter     // Catch:{ all -> 0x0048 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "READ"
            r2.writeUtf8(r3)     // Catch:{ all -> 0x0048 }
            r3 = 32
            r2.writeByte(r3)     // Catch:{ all -> 0x0048 }
            r2.writeUtf8(r5)     // Catch:{ all -> 0x0048 }
            r5 = 10
            r2.writeByte(r5)     // Catch:{ all -> 0x0048 }
            boolean r5 = r4.journalRewriteRequired()     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x0043
            r4.launchCleanup()     // Catch:{ all -> 0x0048 }
        L_0x0043:
            monitor-exit(r0)
            return r1
        L_0x0045:
            monitor-exit(r0)
            r5 = 0
            return r5
        L_0x0048:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.get(java.lang.String):coil3.disk.DiskLruCache$Snapshot");
    }

    public final Editor edit(String str) {
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(str);
            initialize();
            Entry entry = this.lruEntries.get(str);
            if ((entry != null ? entry.getCurrentEditor() : null) != null) {
                return null;
            }
            if (entry != null) {
                if (entry.getLockingSnapshotCount() != 0) {
                    return null;
                }
            }
            if (!this.mostRecentTrimFailed) {
                if (!this.mostRecentRebuildFailed) {
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.writeUtf8(DIRTY);
                    bufferedSink.writeByte(32);
                    bufferedSink.writeUtf8(str);
                    bufferedSink.writeByte(10);
                    bufferedSink.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(entry);
                    entry.setCurrentEditor(editor);
                    return editor;
                }
            }
            launchCleanup();
            return null;
        }
    }

    public final long size() {
        long j;
        synchronized (this.lock) {
            initialize();
            j = this.size;
        }
        return j;
    }

    /* access modifiers changed from: private */
    public final void completeEdit(Editor editor, boolean z) {
        synchronized (this.lock) {
            Entry entry = editor.getEntry();
            if (Intrinsics.areEqual((Object) entry.getCurrentEditor(), (Object) editor)) {
                if (!z || entry.getZombie()) {
                    int i = this.valueCount;
                    for (int i2 = 0; i2 < i; i2++) {
                        this.fileSystem.delete(entry.getDirtyFiles().get(i2));
                    }
                } else {
                    int i3 = this.valueCount;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (!editor.getWritten()[i4] || this.fileSystem.exists(entry.getDirtyFiles().get(i4))) {
                            i4++;
                        } else {
                            editor.abort();
                            return;
                        }
                    }
                    int i5 = this.valueCount;
                    for (int i6 = 0; i6 < i5; i6++) {
                        Path path = entry.getDirtyFiles().get(i6);
                        Path path2 = entry.getCleanFiles().get(i6);
                        if (this.fileSystem.exists(path)) {
                            this.fileSystem.atomicMove(path, path2);
                        } else {
                            FileSystemsKt.createFile$default(this.fileSystem, entry.getCleanFiles().get(i6), false, 2, (Object) null);
                        }
                        long j = entry.getLengths()[i6];
                        Long size2 = this.fileSystem.metadata(path2).getSize();
                        long longValue = size2 != null ? size2.longValue() : 0;
                        entry.getLengths()[i6] = longValue;
                        this.size = (this.size - j) + longValue;
                    }
                }
                entry.setCurrentEditor((Editor) null);
                if (entry.getZombie()) {
                    removeEntry(entry);
                    return;
                }
                this.operationsSinceRewrite++;
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                if (!z) {
                    if (!entry.getReadable()) {
                        this.lruEntries.remove(entry.getKey());
                        bufferedSink.writeUtf8(REMOVE);
                        bufferedSink.writeByte(32);
                        bufferedSink.writeUtf8(entry.getKey());
                        bufferedSink.writeByte(10);
                        bufferedSink.flush();
                        if (this.size > this.maxSize || journalRewriteRequired()) {
                            launchCleanup();
                        }
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                }
                entry.setReadable(true);
                bufferedSink.writeUtf8(CLEAN);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey());
                entry.writeLengths(bufferedSink);
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                launchCleanup();
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r6.checkNotClosed()     // Catch:{ all -> 0x002b }
            r6.validateKey(r7)     // Catch:{ all -> 0x002b }
            r6.initialize()     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, coil3.disk.DiskLruCache$Entry> r1 = r6.lruEntries     // Catch:{ all -> 0x002b }
            java.lang.Object r7 = r1.get(r7)     // Catch:{ all -> 0x002b }
            coil3.disk.DiskLruCache$Entry r7 = (coil3.disk.DiskLruCache.Entry) r7     // Catch:{ all -> 0x002b }
            r1 = 0
            if (r7 != 0) goto L_0x0019
            monitor-exit(r0)
            return r1
        L_0x0019:
            boolean r7 = r6.removeEntry(r7)     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x0029
            long r2 = r6.size     // Catch:{ all -> 0x002b }
            long r4 = r6.maxSize     // Catch:{ all -> 0x002b }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0029
            r6.mostRecentTrimFailed = r1     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)
            return r7
        L_0x002b:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) {
        BufferedSink bufferedSink;
        if (entry.getLockingSnapshotCount() > 0 && (bufferedSink = this.journalWriter) != null) {
            bufferedSink.writeUtf8(DIRTY);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles().get(i2));
            this.size -= entry.getLengths()[i2];
            entry.getLengths()[i2] = 0;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public void close() {
        synchronized (this.lock) {
            if (this.initialized) {
                if (!this.closed) {
                    for (Entry currentEditor : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                        Editor currentEditor2 = currentEditor.getCurrentEditor();
                        if (currentEditor2 != null) {
                            currentEditor2.detach();
                        }
                    }
                    trimToSize();
                    CoroutineScopeKt.cancel$default(this.cleanupScope, (CancellationException) null, 1, (Object) null);
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
            this.closed = true;
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            if (this.initialized) {
                checkNotClosed();
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.flush();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry next : this.lruEntries.values()) {
            if (!next.getZombie()) {
                removeEntry(next);
                return true;
            }
        }
        return false;
    }

    private final void delete() {
        close();
        FileSystemsKt.deleteContents(this.fileSystem, this.directory);
    }

    public final void evictAll() {
        synchronized (this.lock) {
            initialize();
            for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                removeEntry(removeEntry);
            }
            this.mostRecentTrimFailed = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void launchCleanup() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.cleanupScope, (CoroutineContext) null, (CoroutineStart) null, new DiskLruCache$launchCleanup$1(this, (Continuation<? super DiskLruCache$launchCleanup$1>) null), 3, (Object) null);
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Typography.quote).toString());
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0005R\u0015\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil3/disk/DiskLruCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "entry", "Lcoil3/disk/DiskLruCache$Entry;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache;Lcoil3/disk/DiskLruCache$Entry;)V", "getEntry", "()Lcoil3/disk/DiskLruCache$Entry;", "closed", "", "file", "Lokio/Path;", "index", "", "close", "", "closeAndEdit", "Lcoil3/disk/DiskLruCache$Editor;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Snapshot implements AutoCloseable {
        private boolean closed;
        private final Entry entry;

        public Snapshot(Entry entry2) {
            this.entry = entry2;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Path file(int i) {
            if (!this.closed) {
                return this.entry.getCleanFiles().get(i);
            }
            throw new IllegalStateException("snapshot is closed".toString());
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                Object access$getLock$p = DiskLruCache.this.lock;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (access$getLock$p) {
                    Entry entry2 = this.entry;
                    entry2.setLockingSnapshotCount(entry2.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        boolean unused = diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final Editor closeAndEdit() {
            Editor edit;
            Object access$getLock$p = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (access$getLock$p) {
                close();
                edit = diskLruCache.edit(this.entry.getKey());
            }
            return edit;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\f\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\nH\u0002R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcoil3/disk/DiskLruCache$Editor;", "", "entry", "Lcoil3/disk/DiskLruCache$Entry;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache;Lcoil3/disk/DiskLruCache$Entry;)V", "getEntry", "()Lcoil3/disk/DiskLruCache$Entry;", "closed", "", "written", "", "getWritten", "()[Z", "file", "Lokio/Path;", "index", "", "detach", "", "commit", "commitAndGet", "Lcoil3/disk/DiskLruCache$Snapshot;", "abort", "complete", "success", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Editor {
        private boolean closed;
        private final Entry entry;
        private final boolean[] written;

        public Editor(Entry entry2) {
            this.entry = entry2;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }

        public final Path file(int i) {
            Path path;
            Object access$getLock$p = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (access$getLock$p) {
                if (!this.closed) {
                    this.written[i] = true;
                    Path path2 = this.entry.getDirtyFiles().get(i);
                    FileSystemsKt.createFile$default(diskLruCache.fileSystem, path2, false, 2, (Object) null);
                    path = path2;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
            return path;
        }

        public final void detach() {
            if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor(), (Object) this)) {
                this.entry.setZombie(true);
            }
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            Object access$getLock$p = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (access$getLock$p) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void abort() {
            complete(false);
        }

        private final void complete(boolean z) {
            Object access$getLock$p = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (access$getLock$p) {
                if (!this.closed) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor(), (Object) this)) {
                        diskLruCache.completeEdit(this, z);
                    }
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200J\f\u00101\u001a\b\u0018\u000102R\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R \u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcoil3/disk/DiskLruCache$Entry;", "", "key", "", "<init>", "(Lcoil3/disk/DiskLruCache;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "lengths", "", "getLengths", "()[J", "cleanFiles", "Ljava/util/ArrayList;", "Lokio/Path;", "Lkotlin/collections/ArrayList;", "getCleanFiles", "()Ljava/util/ArrayList;", "dirtyFiles", "getDirtyFiles", "readable", "", "getReadable", "()Z", "setReadable", "(Z)V", "zombie", "getZombie", "setZombie", "currentEditor", "Lcoil3/disk/DiskLruCache$Editor;", "Lcoil3/disk/DiskLruCache;", "getCurrentEditor", "()Lcoil3/disk/DiskLruCache$Editor;", "setCurrentEditor", "(Lcoil3/disk/DiskLruCache$Editor;)V", "lockingSnapshotCount", "", "getLockingSnapshotCount", "()I", "setLockingSnapshotCount", "(I)V", "setLengths", "", "strings", "", "writeLengths", "writer", "Lokio/BufferedSink;", "snapshot", "Lcoil3/disk/DiskLruCache$Snapshot;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Entry {
        private final ArrayList<Path> cleanFiles;
        private Editor currentEditor;
        private final ArrayList<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        private boolean zombie;

        public Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            int access$getValueCount$p = DiskLruCache.this.valueCount;
            for (int i = 0; i < access$getValueCount$p; i++) {
                append.append(i);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(append.toString()));
                append.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(append.toString()));
                append.setLength(length);
            }
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final void setReadable(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setZombie(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final void setCurrentEditor(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final void setLockingSnapshotCount(int i) {
            this.lockingSnapshotCount = i;
        }

        public final void setLengths(List<String> list) {
            if (list.size() == DiskLruCache.this.valueCount) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + list);
                }
            } else {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void writeLengths(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            List list = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!diskLruCache.fileSystem.exists((Path) list.get(i))) {
                    try {
                        boolean unused = diskLruCache.removeEntry(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return new Snapshot(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u0005XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0014\u0010\t\u001a\u00020\u0005XT¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\u0005XT¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\u0005XT¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/disk/DiskLruCache$Companion;", "", "<init>", "()V", "JOURNAL_FILE", "", "getJOURNAL_FILE$coil_core_release$annotations", "JOURNAL_FILE_TMP", "getJOURNAL_FILE_TMP$coil_core_release$annotations", "JOURNAL_FILE_BACKUP", "getJOURNAL_FILE_BACKUP$coil_core_release$annotations", "MAGIC", "getMAGIC$coil_core_release$annotations", "VERSION", "getVERSION$coil_core_release$annotations", "CLEAN", "DIRTY", "REMOVE", "READ", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJOURNAL_FILE$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_BACKUP$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_TMP$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getMAGIC$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getVERSION$coil_core_release$annotations() {
        }

        private Companion() {
        }
    }
}
