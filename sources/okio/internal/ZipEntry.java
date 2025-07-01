package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\"\b\u0000\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0017J-\u0010:\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b;\u0010<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010%\u001a\u0004\u0018\u00010\t8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010/R\u0016\u00100\u001a\u0004\u0018\u00010\t8@X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010'R\u0016\u00102\u001a\u0004\u0018\u00010\t8@X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010'R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00105\u001a\u0004\b4\u0010'R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00105\u001a\u0004\b6\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00105\u001a\u0004\b7\u0010'R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!¨\u0006="}, d2 = {"Lokio/internal/ZipEntry;", "", "canonicalPath", "Lokio/Path;", "isDirectory", "", "comment", "", "crc", "", "compressedSize", "size", "compressionMethod", "", "offset", "dosLastModifiedAtDate", "dosLastModifiedAtTime", "ntfsLastModifiedAtFiletime", "ntfsLastAccessedAtFiletime", "ntfsCreatedAtFiletime", "extendedLastModifiedAtSeconds", "extendedLastAccessedAtSeconds", "extendedCreatedAtSeconds", "(Lokio/Path;ZLjava/lang/String;JJJIJIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCanonicalPath", "()Lokio/Path;", "children", "", "getChildren", "()Ljava/util/List;", "getComment", "()Ljava/lang/String;", "getCompressedSize", "()J", "getCompressionMethod", "()I", "getCrc", "createdAtMillis", "getCreatedAtMillis$okio", "()Ljava/lang/Long;", "getDosLastModifiedAtDate", "getDosLastModifiedAtTime", "getExtendedCreatedAtSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtendedLastAccessedAtSeconds", "getExtendedLastModifiedAtSeconds", "()Z", "lastAccessedAtMillis", "getLastAccessedAtMillis$okio", "lastModifiedAtMillis", "getLastModifiedAtMillis$okio", "getNtfsCreatedAtFiletime", "Ljava/lang/Long;", "getNtfsLastAccessedAtFiletime", "getNtfsLastModifiedAtFiletime", "getOffset", "getSize", "copy", "copy$okio", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lokio/internal/ZipEntry;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ZipEntry.kt */
public final class ZipEntry {
    private final Path canonicalPath;
    private final List<Path> children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final int dosLastModifiedAtDate;
    private final int dosLastModifiedAtTime;
    private final Integer extendedCreatedAtSeconds;
    private final Integer extendedLastAccessedAtSeconds;
    private final Integer extendedLastModifiedAtSeconds;
    private final boolean isDirectory;
    private final Long ntfsCreatedAtFiletime;
    private final Long ntfsLastAccessedAtFiletime;
    private final Long ntfsLastModifiedAtFiletime;
    private final long offset;
    private final long size;

    public ZipEntry(Path path, boolean z, String str, long j, long j2, long j3, int i, long j4, int i2, int i3, Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(path, "canonicalPath");
        Intrinsics.checkNotNullParameter(str, "comment");
        this.canonicalPath = path;
        this.isDirectory = z;
        this.comment = str;
        this.crc = j;
        this.compressedSize = j2;
        this.size = j3;
        this.compressionMethod = i;
        this.offset = j4;
        this.dosLastModifiedAtDate = i2;
        this.dosLastModifiedAtTime = i3;
        this.ntfsLastModifiedAtFiletime = l;
        this.ntfsLastAccessedAtFiletime = l2;
        this.ntfsCreatedAtFiletime = l3;
        this.extendedLastModifiedAtSeconds = num;
        this.extendedLastAccessedAtSeconds = num2;
        this.extendedCreatedAtSeconds = num3;
        this.children = new ArrayList();
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ZipEntry(okio.Path r18, boolean r19, java.lang.String r20, long r21, long r23, long r25, int r27, long r28, int r30, int r31, java.lang.Long r32, java.lang.Long r33, java.lang.Long r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.Integer r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r17 = this;
            r0 = r38
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            java.lang.String r2 = ""
            goto L_0x0013
        L_0x0011:
            r2 = r20
        L_0x0013:
            r3 = r0 & 8
            r4 = -1
            if (r3 == 0) goto L_0x001b
            r6 = r4
            goto L_0x001d
        L_0x001b:
            r6 = r21
        L_0x001d:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0023
            r8 = r4
            goto L_0x0025
        L_0x0023:
            r8 = r23
        L_0x0025:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x002b
            r10 = r4
            goto L_0x002d
        L_0x002b:
            r10 = r25
        L_0x002d:
            r3 = r0 & 64
            r12 = -1
            if (r3 == 0) goto L_0x0034
            r3 = r12
            goto L_0x0036
        L_0x0034:
            r3 = r27
        L_0x0036:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r4 = r28
        L_0x003d:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0043
            r13 = r12
            goto L_0x0045
        L_0x0043:
            r13 = r30
        L_0x0045:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r12 = r31
        L_0x004c:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0052
            r14 = 0
            goto L_0x0054
        L_0x0052:
            r14 = r32
        L_0x0054:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005a
            r15 = 0
            goto L_0x005c
        L_0x005a:
            r15 = r33
        L_0x005c:
            r39 = r1
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0064
            r1 = 0
            goto L_0x0066
        L_0x0064:
            r1 = r34
        L_0x0066:
            r20 = r1
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x006e
            r1 = 0
            goto L_0x0070
        L_0x006e:
            r1 = r35
        L_0x0070:
            r21 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0078
            r1 = 0
            goto L_0x007a
        L_0x0078:
            r1 = r36
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0088
            r37 = r21
            r21 = r39
            r39 = 0
            goto L_0x0090
        L_0x0088:
            r19 = r37
            r37 = r21
            r21 = r39
            r39 = r19
        L_0x0090:
            r19 = r17
            r36 = r20
            r38 = r1
            r22 = r2
            r29 = r3
            r30 = r4
            r23 = r6
            r25 = r8
            r27 = r10
            r33 = r12
            r32 = r13
            r34 = r14
            r35 = r15
            r20 = r18
            r19.<init>(r20, r21, r22, r23, r25, r27, r29, r30, r32, r33, r34, r35, r36, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipEntry.<init>(okio.Path, boolean, java.lang.String, long, long, long, int, long, int, int, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final int getDosLastModifiedAtDate() {
        return this.dosLastModifiedAtDate;
    }

    public final int getDosLastModifiedAtTime() {
        return this.dosLastModifiedAtTime;
    }

    public final Long getNtfsLastModifiedAtFiletime() {
        return this.ntfsLastModifiedAtFiletime;
    }

    public final Long getNtfsLastAccessedAtFiletime() {
        return this.ntfsLastAccessedAtFiletime;
    }

    public final Long getNtfsCreatedAtFiletime() {
        return this.ntfsCreatedAtFiletime;
    }

    public final Integer getExtendedLastModifiedAtSeconds() {
        return this.extendedLastModifiedAtSeconds;
    }

    public final Integer getExtendedLastAccessedAtSeconds() {
        return this.extendedLastAccessedAtSeconds;
    }

    public final Integer getExtendedCreatedAtSeconds() {
        return this.extendedCreatedAtSeconds;
    }

    public final List<Path> getChildren() {
        return this.children;
    }

    public final ZipEntry copy$okio(Integer num, Integer num2, Integer num3) {
        Path path = this.canonicalPath;
        boolean z = this.isDirectory;
        String str = this.comment;
        long j = this.crc;
        long j2 = this.compressedSize;
        long j3 = this.size;
        int i = this.compressionMethod;
        long j4 = this.offset;
        int i2 = this.dosLastModifiedAtDate;
        int i3 = this.dosLastModifiedAtTime;
        Long l = this.ntfsLastModifiedAtFiletime;
        return new ZipEntry(path, z, str, j, j2, j3, i, j4, i2, i3, l, this.ntfsLastAccessedAtFiletime, this.ntfsCreatedAtFiletime, num, num2, num3);
    }

    public final Long getLastAccessedAtMillis$okio() {
        Long l = this.ntfsLastAccessedAtFiletime;
        if (l != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l.longValue()));
        }
        Integer num = this.extendedLastAccessedAtSeconds;
        if (num != null) {
            return Long.valueOf(((long) num.intValue()) * 1000);
        }
        return null;
    }

    public final Long getLastModifiedAtMillis$okio() {
        Long l = this.ntfsLastModifiedAtFiletime;
        if (l != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l.longValue()));
        }
        Integer num = this.extendedLastModifiedAtSeconds;
        if (num != null) {
            return Long.valueOf(((long) num.intValue()) * 1000);
        }
        int i = this.dosLastModifiedAtTime;
        if (i != -1) {
            return ZipFilesKt.dosDateTimeToEpochMillis(this.dosLastModifiedAtDate, i);
        }
        return null;
    }

    public final Long getCreatedAtMillis$okio() {
        Long l = this.ntfsCreatedAtFiletime;
        if (l != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l.longValue()));
        }
        Integer num = this.extendedCreatedAtSeconds;
        if (num != null) {
            return Long.valueOf(((long) num.intValue()) * 1000);
        }
        return null;
    }
}
