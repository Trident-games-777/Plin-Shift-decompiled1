package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzga extends zzfw {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzga(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfz {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzfz(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzen.zza;
        FileInputStream fileInputStream2 = fileInputStream;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f8, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fa, code lost:
        r3 = 2005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0100, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0101, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0100 A[ExcHandler: zzfz (r0v1 'e' com.google.android.gms.internal.ads.zzfz A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzgi r17) throws com.google.android.gms.internal.ads.zzfz {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = "Could not open file descriptor for: "
            r4 = 1
            android.net.Uri r5 = r0.zza     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            android.net.Uri r5 = r5.normalizeScheme()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r1.zzb = r5     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r16.zzi(r17)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r6 = "content"
            java.lang.String r7 = r5.getScheme()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            boolean r6 = r6.equals(r7)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            if (r6 == 0) goto L_0x0031
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r6.<init>()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r7 = "android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT"
            r6.putBoolean(r7, r4)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            android.content.ContentResolver r7 = r1.zza     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r8 = "*/*"
            android.content.res.AssetFileDescriptor r6 = r7.openTypedAssetFileDescriptor(r5, r8, r6)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            goto L_0x0039
        L_0x0031:
            android.content.ContentResolver r6 = r1.zza     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r7 = "r"
            android.content.res.AssetFileDescriptor r6 = r6.openAssetFileDescriptor(r5, r7)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
        L_0x0039:
            r1.zzc = r6     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            if (r6 == 0) goto L_0x00cf
            long r7 = r6.getLength()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.io.FileDescriptor r5 = r6.getFileDescriptor()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r2.<init>(r5)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r1.zzd = r2     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r9 = -1
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r11 = 2008(0x7d8, float:2.814E-42)
            r12 = 0
            if (r5 == 0) goto L_0x0062
            long r13 = r0.zze     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 > 0) goto L_0x005c
            goto L_0x0062
        L_0x005c:
            com.google.android.gms.internal.ads.zzfz r0 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            throw r0     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
        L_0x0062:
            long r13 = r6.getStartOffset()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            long r3 = r0.zze     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            long r3 = r3 + r13
            long r3 = r2.skip(r3)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            long r3 = r3 - r13
            long r13 = r0.zze     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x00c9
            r13 = 0
            if (r5 != 0) goto L_0x009a
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            long r3 = r2.size()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0088
            r1.zze = r9     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r3 = r9
            goto L_0x00a2
        L_0x0088:
            long r7 = r2.position()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            long r3 = r3 - r7
            r1.zze = r3     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0094
            goto L_0x00a2
        L_0x0094:
            com.google.android.gms.internal.ads.zzfz r0 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            throw r0     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
        L_0x009a:
            long r3 = r7 - r3
            r1.zze = r3     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00c3
        L_0x00a2:
            long r5 = r0.zzf
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x00b3
            int r2 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            long r5 = java.lang.Math.min(r3, r5)
        L_0x00b1:
            r1.zze = r5
        L_0x00b3:
            r15 = 1
            r1.zzf = r15
            r16.zzj(r17)
            long r2 = r0.zzf
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x00c0
            return r2
        L_0x00c0:
            long r2 = r1.zze
            return r2
        L_0x00c3:
            com.google.android.gms.internal.ads.zzfz r0 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            throw r0     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
        L_0x00c9:
            com.google.android.gms.internal.ads.zzfz r0 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            throw r0     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
        L_0x00cf:
            com.google.android.gms.internal.ads.zzfz r0 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r5.<init>(r2)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r5.append(r4)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            java.lang.String r2 = r5.toString()     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r3.<init>(r2)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ee }
            r6 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r3, r6)     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ec }
            throw r0     // Catch:{ zzfz -> 0x0100, IOException -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f1
        L_0x00ee:
            r0 = move-exception
            r6 = 2000(0x7d0, float:2.803E-42)
        L_0x00f1:
            com.google.android.gms.internal.ads.zzfz r2 = new com.google.android.gms.internal.ads.zzfz
            boolean r3 = r0 instanceof java.io.FileNotFoundException
            r15 = 1
            if (r15 == r3) goto L_0x00fa
            r3 = r6
            goto L_0x00fc
        L_0x00fa:
            r3 = 2005(0x7d5, float:2.81E-42)
        L_0x00fc:
            r2.<init>(r0, r3)
            throw r2
        L_0x0100:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzga.zzb(com.google.android.gms.internal.ads.zzgi):long");
    }

    public final Uri zzc() {
        return this.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        throw new com.google.android.gms.internal.ads.zzfz(r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004f, code lost:
        throw new com.google.android.gms.internal.ads.zzfz(r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r5.zzc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
        if (r5.zzf != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5.zzf = false;
        zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x000f, B:15:0x0025, B:24:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzfz {
        /*
            r5 = this;
            r0 = 0
            r5.zzb = r0
            r1 = 0
            r2 = 2000(0x7d0, float:2.803E-42)
            java.io.FileInputStream r3 = r5.zzd     // Catch:{ IOException -> 0x002d }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x002d }
        L_0x000d:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r3 = r5.zzc     // Catch:{ IOException -> 0x0024 }
            if (r3 == 0) goto L_0x0016
            r3.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0016:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0021
            r5.zzf = r1
            r5.zzh()
        L_0x0021:
            return
        L_0x0022:
            r2 = move-exception
            goto L_0x0050
        L_0x0024:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfz r4 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ all -> 0x0022 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x002b:
            r3 = move-exception
            goto L_0x0034
        L_0x002d:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfz r4 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ all -> 0x002b }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x002b }
            throw r4     // Catch:{ all -> 0x002b }
        L_0x0034:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r4 = r5.zzc     // Catch:{ IOException -> 0x0049 }
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ IOException -> 0x0049 }
        L_0x003d:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0048
            r5.zzf = r1
            r5.zzh()
        L_0x0048:
            throw r3
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfz r4 = new com.google.android.gms.internal.ads.zzfz     // Catch:{ all -> 0x0022 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0050:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x005b
            r5.zzf = r1
            r5.zzh()
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzga.zzd():void");
    }
}
