package okio.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002\u001a\u001f\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0000\u001a.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0%H\u0000\u001a\f\u0010'\u001a\u00020\u0016*\u00020(H\u0000\u001a\f\u0010)\u001a\u00020**\u00020(H\u0002\u001a.\u0010+\u001a\u00020,*\u00020(2\u0006\u0010-\u001a\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020,0/H\u0002\u001a\u0014\u00100\u001a\u00020\u0016*\u00020(2\u0006\u00101\u001a\u00020\u0016H\u0000\u001a\u0018\u00102\u001a\u0004\u0018\u00010\u0016*\u00020(2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\u0014\u00103\u001a\u00020**\u00020(2\u0006\u00104\u001a\u00020*H\u0002\u001a\f\u00105\u001a\u00020,*\u00020(H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "filetimeToEpochMillis", "filetime", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ZipFiles.kt */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipFilesKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [kotlin.Unit] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r12.close();
        r6 = r6 - ((long) 20);
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        if (r6 <= r8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        r6 = okio.Okio.buffer(r5.source(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = (okio.BufferedSource) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        if (r0.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        r7 = r0.readIntLe();
        r13 = r0.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0085, code lost:
        if (r0.readIntLe() != 1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        if (r7 != 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        r7 = okio.Okio.buffer(r5.source(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = (okio.BufferedSource) r7;
        r13 = r0.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        if (r13 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        r10 = readZip64EocdRecord(r0, r10);
        r13 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        if (r7 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00da, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00dc, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00dd, code lost:
        if (r7 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        kotlin.ExceptionsKt.addSuppressed(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f6, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0104, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r6 != null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010f, code lost:
        r0 = r7;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        r10 = readEocdRecord(r12);
        r11 = r12.readUtf8((long) r10.getCommentByteCount());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0199 A[SYNTHETIC, Splitter:B:103:0x0199] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb A[Catch:{ all -> 0x00db, all -> 0x00e3, all -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee A[Catch:{ all -> 0x00db, all -> 0x00e3, all -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0113 A[Catch:{ all -> 0x01b0, all -> 0x010b, all -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0116 A[Catch:{ all -> 0x01b0, all -> 0x010b, all -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0188 A[Catch:{ all -> 0x01b0, all -> 0x010b, all -> 0x01cc }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(okio.Path r21, okio.FileSystem r22, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r23) throws java.io.IOException {
        /*
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r0 = "not a zip: size="
            java.lang.String r4 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            okio.FileHandle r4 = r2.openReadOnly(r1)
            java.io.Closeable r4 = (java.io.Closeable) r4
            r5 = r4
            okio.FileHandle r5 = (okio.FileHandle) r5     // Catch:{ all -> 0x01cc }
            long r6 = r5.size()     // Catch:{ all -> 0x01cc }
            r8 = 22
            long r8 = (long) r8     // Catch:{ all -> 0x01cc }
            long r6 = r6 - r8
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x01b5
            r10 = 65536(0x10000, double:3.2379E-319)
            long r10 = r6 - r10
            long r10 = java.lang.Math.max(r10, r8)     // Catch:{ all -> 0x01cc }
        L_0x0037:
            okio.Source r0 = r5.source(r6)     // Catch:{ all -> 0x01cc }
            okio.BufferedSource r12 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x01cc }
            int r0 = r12.readIntLe()     // Catch:{ all -> 0x01b0 }
            r13 = 101010256(0x6054b50, float:2.506985E-35)
            if (r0 != r13) goto L_0x019a
            okio.internal.EocdRecord r10 = readEocdRecord(r12)     // Catch:{ all -> 0x01b0 }
            int r0 = r10.getCommentByteCount()     // Catch:{ all -> 0x01b0 }
            long r13 = (long) r0     // Catch:{ all -> 0x01b0 }
            java.lang.String r11 = r12.readUtf8(r13)     // Catch:{ all -> 0x01b0 }
            r12.close()     // Catch:{ all -> 0x01cc }
            r0 = 20
            long r12 = (long) r0     // Catch:{ all -> 0x01cc }
            long r6 = r6 - r12
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r12 = 0
            if (r0 <= 0) goto L_0x0117
            okio.Source r0 = r5.source(r6)     // Catch:{ all -> 0x01cc }
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x01cc }
            r6 = r0
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x01cc }
            r0 = r6
            okio.BufferedSource r0 = (okio.BufferedSource) r0     // Catch:{ all -> 0x0103 }
            int r7 = r0.readIntLe()     // Catch:{ all -> 0x0103 }
            r13 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r7 != r13) goto L_0x00f7
            int r7 = r0.readIntLe()     // Catch:{ all -> 0x0103 }
            long r13 = r0.readLongLe()     // Catch:{ all -> 0x0103 }
            int r0 = r0.readIntLe()     // Catch:{ all -> 0x0103 }
            r15 = 1
            if (r0 != r15) goto L_0x00ef
            if (r7 != 0) goto L_0x00ef
            okio.Source r0 = r5.source(r13)     // Catch:{ all -> 0x0103 }
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x0103 }
            r7 = r0
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x0103 }
            r0 = r7
            okio.BufferedSource r0 = (okio.BufferedSource) r0     // Catch:{ all -> 0x00db }
            int r13 = r0.readIntLe()     // Catch:{ all -> 0x00db }
            r14 = 101075792(0x6064b50, float:2.525793E-35)
            if (r13 != r14) goto L_0x00b0
            okio.internal.EocdRecord r10 = readZip64EocdRecord(r0, r10)     // Catch:{ all -> 0x00db }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00db }
            if (r7 == 0) goto L_0x00ae
            r7.close()     // Catch:{ all -> 0x00ac }
            goto L_0x00ae
        L_0x00ac:
            r0 = move-exception
            goto L_0x00e9
        L_0x00ae:
            r0 = r12
            goto L_0x00e9
        L_0x00b0:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r15.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r8 = "bad zip: expected "
            java.lang.StringBuilder r8 = r15.append(r8)     // Catch:{ all -> 0x00db }
            java.lang.String r9 = getHex(r14)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00db }
            java.lang.String r9 = " but was "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00db }
            java.lang.String r9 = getHex(r13)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00db }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00db }
            r0.<init>(r8)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x00db:
            r0 = move-exception
            r8 = r0
            if (r7 == 0) goto L_0x00e7
            r7.close()     // Catch:{ all -> 0x00e3 }
            goto L_0x00e7
        L_0x00e3:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r8, r0)     // Catch:{ all -> 0x0103 }
        L_0x00e7:
            r0 = r8
            r13 = r12
        L_0x00e9:
            if (r0 != 0) goto L_0x00ee
            java.lang.Object r13 = (java.lang.Object) r13     // Catch:{ all -> 0x0103 }
            goto L_0x00f7
        L_0x00ee:
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x00ef:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = "unsupported zip: spanned"
            r0.<init>(r7)     // Catch:{ all -> 0x0103 }
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x00f7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0103 }
            if (r6 == 0) goto L_0x0101
            r6.close()     // Catch:{ all -> 0x00ff }
            goto L_0x0101
        L_0x00ff:
            r0 = move-exception
            goto L_0x0111
        L_0x0101:
            r0 = r12
            goto L_0x0111
        L_0x0103:
            r0 = move-exception
            r7 = r0
            if (r6 == 0) goto L_0x010f
            r6.close()     // Catch:{ all -> 0x010b }
            goto L_0x010f
        L_0x010b:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r7, r0)     // Catch:{ all -> 0x01cc }
        L_0x010f:
            r0 = r7
            r7 = r12
        L_0x0111:
            if (r0 != 0) goto L_0x0116
            java.lang.Object r7 = (java.lang.Object) r7     // Catch:{ all -> 0x01cc }
            goto L_0x0117
        L_0x0116:
            throw r0     // Catch:{ all -> 0x01cc }
        L_0x0117:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x01cc }
            r0.<init>()     // Catch:{ all -> 0x01cc }
            r6 = r0
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x01cc }
            long r7 = r10.getCentralDirectoryOffset()     // Catch:{ all -> 0x01cc }
            okio.Source r0 = r5.source(r7)     // Catch:{ all -> 0x01cc }
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x01cc }
            r5 = r0
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x01cc }
            r0 = r5
            okio.BufferedSource r0 = (okio.BufferedSource) r0     // Catch:{ all -> 0x017a }
            long r7 = r10.getEntryCount()     // Catch:{ all -> 0x017a }
            r16 = 0
        L_0x0137:
            int r9 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x016a
            okio.internal.ZipEntry r9 = readCentralDirectoryZipEntry(r0)     // Catch:{ all -> 0x017a }
            long r13 = r9.getOffset()     // Catch:{ all -> 0x017a }
            long r18 = r10.getCentralDirectoryOffset()     // Catch:{ all -> 0x017a }
            int r13 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r13 >= 0) goto L_0x0162
            java.lang.Object r13 = r3.invoke(r9)     // Catch:{ all -> 0x017a }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x017a }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x017a }
            if (r13 == 0) goto L_0x015d
            r13 = r6
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ all -> 0x017a }
            r13.add(r9)     // Catch:{ all -> 0x017a }
        L_0x015d:
            r13 = 1
            long r16 = r16 + r13
            goto L_0x0137
        L_0x0162:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x017a }
            java.lang.String r3 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r3)     // Catch:{ all -> 0x017a }
            throw r0     // Catch:{ all -> 0x017a }
        L_0x016a:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x017a }
            if (r5 == 0) goto L_0x0174
            r5.close()     // Catch:{ all -> 0x0172 }
            goto L_0x0174
        L_0x0172:
            r0 = move-exception
            r12 = r0
        L_0x0174:
            r20 = r12
            r12 = r3
            r3 = r20
            goto L_0x0186
        L_0x017a:
            r0 = move-exception
            r3 = r0
            if (r5 == 0) goto L_0x0186
            r5.close()     // Catch:{ all -> 0x0182 }
            goto L_0x0186
        L_0x0182:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r3, r0)     // Catch:{ all -> 0x01cc }
        L_0x0186:
            if (r3 != 0) goto L_0x0199
            java.lang.Object r12 = (java.lang.Object) r12     // Catch:{ all -> 0x01cc }
            java.util.Map r0 = buildIndex(r6)     // Catch:{ all -> 0x01cc }
            okio.ZipFileSystem r3 = new okio.ZipFileSystem     // Catch:{ all -> 0x01cc }
            r3.<init>(r1, r2, r0, r11)     // Catch:{ all -> 0x01cc }
            if (r4 == 0) goto L_0x0198
            r4.close()     // Catch:{ all -> 0x0198 }
        L_0x0198:
            return r3
        L_0x0199:
            throw r3     // Catch:{ all -> 0x01cc }
        L_0x019a:
            r12.close()     // Catch:{ all -> 0x01cc }
            r8 = -1
            long r6 = r6 + r8
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x01a8
            r8 = 0
            goto L_0x0037
        L_0x01a8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01cc }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x01cc }
            throw r0     // Catch:{ all -> 0x01cc }
        L_0x01b0:
            r0 = move-exception
            r12.close()     // Catch:{ all -> 0x01cc }
            throw r0     // Catch:{ all -> 0x01cc }
        L_0x01b5:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x01cc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cc }
            r2.<init>(r0)     // Catch:{ all -> 0x01cc }
            long r5 = r5.size()     // Catch:{ all -> 0x01cc }
            java.lang.StringBuilder r0 = r2.append(r5)     // Catch:{ all -> 0x01cc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01cc }
            r1.<init>(r0)     // Catch:{ all -> 0x01cc }
            throw r1     // Catch:{ all -> 0x01cc }
        L_0x01cc:
            r0 = move-exception
            r1 = r0
            if (r4 == 0) goto L_0x01d8
            r4.close()     // Catch:{ all -> 0x01d4 }
            goto L_0x01d8
        L_0x01d4:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r1, r0)
        L_0x01d8:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, 0, 0, 0, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, 65532, (DefaultConstructorMarker) null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new ZipFilesKt$buildIndex$$inlined$sortedBy$1())) {
            if (mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = mutableMapOf.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, 0, 0, 0, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, 65532, (DefaultConstructorMarker) null);
                    mutableMapOf.put(parent, zipEntry3);
                    zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry3;
                }
            }
        }
        return mutableMapOf;
    }

    public static final ZipEntry readCentralDirectoryZipEntry(BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource2.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource2.readShortLe();
            short s = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                short readShortLe3 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                long readIntLe2 = ((long) bufferedSource2.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource2.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource2.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                short readShortLe5 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                short readShortLe6 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                short readShortLe7 = bufferedSource2.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource2.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe5);
                if (!StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? (long) 8 : 0;
                    long j2 = longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j + ((long) 8) : j;
                    Ref.LongRef longRef4 = longRef2;
                    if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j2 += (long) 8;
                    }
                    long j3 = j2;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Ref.LongRef longRef5 = longRef4;
                    String str = readUtf8;
                    readExtra(bufferedSource2, readShortLe6, new ZipFilesKt$readCentralDirectoryZipEntry$1(booleanRef, j3, longRef5, bufferedSource2, longRef, longRef3, objectRef, objectRef2, objectRef3));
                    if (j3 <= 0 || booleanRef.element) {
                        String str2 = str;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null).resolve(str2), StringsKt.endsWith$default(str2, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null), bufferedSource2.readUtf8((long) readShortLe7), readIntLe2, longRef.element, longRef5.element, readShortLe2, longRef3.element, readShortLe4, readShortLe3, (Long) objectRef.element, (Long) objectRef2.element, (Long) objectRef3.element, (Integer) null, (Integer) null, (Integer) null, 57344, (DefaultConstructorMarker) null);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    /* access modifiers changed from: private */
    public static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (ZipEntry) null);
    }

    public static final ZipEntry readLocalHeader(BufferedSource bufferedSource, ZipEntry zipEntry) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(zipEntry, "centralDirectoryZipEntry");
        ZipEntry readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, zipEntry);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final ZipEntry readOrSkipLocalHeader(BufferedSource bufferedSource, ZipEntry zipEntry) {
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(2);
            short readShortLe = bufferedSource.readShortLe();
            short s = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource.skip(readShortLe2);
                if (zipEntry == null) {
                    bufferedSource.skip((long) readShortLe3);
                    return null;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                readExtra(bufferedSource, readShortLe3, new ZipFilesKt$readOrSkipLocalHeader$1(bufferedSource, objectRef, objectRef2, objectRef3));
                return zipEntry.copy$okio((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / ((long) 10000)) - 11644473600000L;
    }

    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return sb.append(num).toString();
    }
}
