package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaql implements zzaoz {
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzaqk zzc;
    private final int zzd;

    public zzaql(zzaqk zzaqk, int i) {
        this.zzc = zzaqk;
        this.zzd = 5242880;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    static String zzh(zzaqj zzaqj) throws IOException {
        return new String(zzm(zzaqj, zzf(zzaqj)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzaqj zzaqj, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        long zza2 = zzaqj.zza();
        if (i >= 0 && j <= zza2) {
            int i2 = (int) j;
            if (((long) i2) == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(zzaqj).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + zza2);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqi zzaqi) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzaqi.zza;
        } else {
            this.zzb += zzaqi.zza - ((zzaqi) this.zza.get(str)).zza;
        }
        this.zza.put(str, zzaqi);
    }

    private final void zzp(String str) {
        zzaqi zzaqi = (zzaqi) this.zza.remove(str);
        if (zzaqi != null) {
            this.zzb -= zzaqi.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    public final synchronized zzaoy zza(String str) {
        zzaqj zzaqj;
        zzaqi zzaqi = (zzaqi) this.zza.get(str);
        if (zzaqi == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzaqj = new zzaqj(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            zzaqi zza2 = zzaqi.zza(zzaqj);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzaqb.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza2.zzb);
                zzp(str);
                zzaqj.close();
                return null;
            }
            byte[] zzm = zzm(zzaqj, zzaqj.zza());
            zzaoy zzaoy = new zzaoy();
            zzaoy.zza = zzm;
            zzaoy.zzb = zzaqi.zzc;
            zzaoy.zzc = zzaqi.zzd;
            zzaoy.zzd = zzaqi.zze;
            zzaoy.zze = zzaqi.zzf;
            zzaoy.zzf = zzaqi.zzg;
            List<zzaph> list = zzaqi.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzaph zzaph : list) {
                treeMap.put(zzaph.zza(), zzaph.zzb());
            }
            zzaoy.zzg = treeMap;
            zzaoy.zzh = Collections.unmodifiableList(zzaqi.zzh);
            zzaqj.close();
            return zzaoy;
        } catch (IOException e) {
            zzaqb.zza("%s: %s", zzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        } catch (Throwable th) {
            zzaqj.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzaqk r0 = r8.zzc     // Catch:{ all -> 0x005d }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x005d }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x005b
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x005d }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "Unable to create cache dir %s"
            com.google.android.gms.internal.ads.zzaqb.zzb(r1, r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r8)
            return
        L_0x0022:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            r1 = 0
        L_0x0029:
            int r2 = r0.length     // Catch:{ all -> 0x005d }
            if (r1 >= r2) goto L_0x005b
            r2 = r0[r1]     // Catch:{ all -> 0x005d }
            long r3 = r2.length()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.ads.zzaqj r5 = new com.google.android.gms.internal.ads.zzaqj     // Catch:{ IOException -> 0x0055 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0055 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0055 }
            r7.<init>(r2)     // Catch:{ IOException -> 0x0055 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0055 }
            r5.<init>(r6, r3)     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.ads.zzaqi r6 = com.google.android.gms.internal.ads.zzaqi.zza(r5)     // Catch:{ all -> 0x0050 }
            r6.zza = r3     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r6.zzb     // Catch:{ all -> 0x0050 }
            r8.zzo(r3, r6)     // Catch:{ all -> 0x0050 }
            r5.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0058
        L_0x0050:
            r3 = move-exception
            r5.close()     // Catch:{ IOException -> 0x0055 }
            throw r3     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            r2.delete()     // Catch:{ all -> 0x005d }
        L_0x0058:
            int r1 = r1 + 1
            goto L_0x0029
        L_0x005b:
            monitor-exit(r8)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x005d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaql.zzb():void");
    }

    public final synchronized void zzc(String str, boolean z) {
        zzaoy zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzd(str, zza2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0149 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r13, com.google.android.gms.internal.ads.zzaoy r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.zzb     // Catch:{ all -> 0x017f }
            byte[] r2 = r14.zza     // Catch:{ all -> 0x017f }
            int r2 = r2.length     // Catch:{ all -> 0x017f }
            long r3 = (long) r2     // Catch:{ all -> 0x017f }
            long r0 = r0 + r3
            int r3 = r12.zzd     // Catch:{ all -> 0x017f }
            long r4 = (long) r3     // Catch:{ all -> 0x017f }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r1 = 1063675494(0x3f666666, float:0.9)
            if (r0 <= 0) goto L_0x0019
            float r0 = (float) r2     // Catch:{ all -> 0x017f }
            float r2 = (float) r3     // Catch:{ all -> 0x017f }
            float r2 = r2 * r1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x017d
        L_0x0019:
            java.io.File r0 = r12.zzg(r13)     // Catch:{ all -> 0x017f }
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0149 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0149 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0149 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqi r4 = new com.google.android.gms.internal.ads.zzaqi     // Catch:{ IOException -> 0x0149 }
            r4.<init>(r13, r14)     // Catch:{ IOException -> 0x0149 }
            r5 = 538247942(0x20150306, float:1.2621791E-19)
            zzj(r3, r5)     // Catch:{ IOException -> 0x0125 }
            java.lang.String r5 = r4.zzb     // Catch:{ IOException -> 0x0125 }
            zzl(r3, r5)     // Catch:{ IOException -> 0x0125 }
            java.lang.String r5 = r4.zzc     // Catch:{ IOException -> 0x0125 }
            if (r5 != 0) goto L_0x003e
            java.lang.String r5 = ""
        L_0x003e:
            zzl(r3, r5)     // Catch:{ IOException -> 0x0125 }
            long r5 = r4.zzd     // Catch:{ IOException -> 0x0125 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0125 }
            long r5 = r4.zze     // Catch:{ IOException -> 0x0125 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0125 }
            long r5 = r4.zzf     // Catch:{ IOException -> 0x0125 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0125 }
            long r5 = r4.zzg     // Catch:{ IOException -> 0x0125 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0125 }
            java.util.List r5 = r4.zzh     // Catch:{ IOException -> 0x0125 }
            if (r5 == 0) goto L_0x007f
            int r6 = r5.size()     // Catch:{ IOException -> 0x0125 }
            zzj(r3, r6)     // Catch:{ IOException -> 0x0125 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0125 }
        L_0x0064:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0125 }
            if (r6 == 0) goto L_0x0082
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0125 }
            com.google.android.gms.internal.ads.zzaph r6 = (com.google.android.gms.internal.ads.zzaph) r6     // Catch:{ IOException -> 0x0125 }
            java.lang.String r7 = r6.zza()     // Catch:{ IOException -> 0x0125 }
            zzl(r3, r7)     // Catch:{ IOException -> 0x0125 }
            java.lang.String r6 = r6.zzb()     // Catch:{ IOException -> 0x0125 }
            zzl(r3, r6)     // Catch:{ IOException -> 0x0125 }
            goto L_0x0064
        L_0x007f:
            zzj(r3, r2)     // Catch:{ IOException -> 0x0125 }
        L_0x0082:
            r3.flush()     // Catch:{ IOException -> 0x0125 }
            byte[] r14 = r14.zza     // Catch:{ IOException -> 0x0149 }
            r3.write(r14)     // Catch:{ IOException -> 0x0149 }
            r3.close()     // Catch:{ IOException -> 0x0149 }
            long r5 = r0.length()     // Catch:{ IOException -> 0x0149 }
            r4.zza = r5     // Catch:{ IOException -> 0x0149 }
            r12.zzo(r13, r4)     // Catch:{ IOException -> 0x0149 }
            long r13 = r12.zzb     // Catch:{ IOException -> 0x0149 }
            int r3 = r12.zzd     // Catch:{ IOException -> 0x0149 }
            long r3 = (long) r3     // Catch:{ IOException -> 0x0149 }
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            goto L_0x017d
        L_0x00a1:
            boolean r13 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ IOException -> 0x0149 }
            if (r13 == 0) goto L_0x00ac
            java.lang.String r13 = "Pruning old cache entries."
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqb.zzd(r13, r14)     // Catch:{ IOException -> 0x0149 }
        L_0x00ac:
            long r13 = r12.zzb     // Catch:{ IOException -> 0x0149 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0149 }
            java.util.Map r5 = r12.zza     // Catch:{ IOException -> 0x0149 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0149 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0149 }
            r6 = r2
        L_0x00bd:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0149 }
            if (r7 == 0) goto L_0x0102
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0149 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0149 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqi r7 = (com.google.android.gms.internal.ads.zzaqi) r7     // Catch:{ IOException -> 0x0149 }
            java.lang.String r8 = r7.zzb     // Catch:{ IOException -> 0x0149 }
            java.io.File r8 = r12.zzg(r8)     // Catch:{ IOException -> 0x0149 }
            boolean r8 = r8.delete()     // Catch:{ IOException -> 0x0149 }
            if (r8 == 0) goto L_0x00e3
            long r8 = r12.zzb     // Catch:{ IOException -> 0x0149 }
            long r10 = r7.zza     // Catch:{ IOException -> 0x0149 }
            long r8 = r8 - r10
            r12.zzb = r8     // Catch:{ IOException -> 0x0149 }
            goto L_0x00f2
        L_0x00e3:
            java.lang.String r8 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.String r7 = r7.zzb     // Catch:{ IOException -> 0x0149 }
            java.lang.String r9 = zzq(r7)     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r9}     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqb.zza(r8, r7)     // Catch:{ IOException -> 0x0149 }
        L_0x00f2:
            r5.remove()     // Catch:{ IOException -> 0x0149 }
            int r6 = r6 + 1
            long r7 = r12.zzb     // Catch:{ IOException -> 0x0149 }
            float r7 = (float) r7     // Catch:{ IOException -> 0x0149 }
            int r8 = r12.zzd     // Catch:{ IOException -> 0x0149 }
            float r8 = (float) r8     // Catch:{ IOException -> 0x0149 }
            float r8 = r8 * r1
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00bd
        L_0x0102:
            boolean r1 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ IOException -> 0x0149 }
            if (r1 == 0) goto L_0x017d
            java.lang.String r1 = "pruned %d files, %d bytes, %d ms"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0149 }
            long r6 = r12.zzb     // Catch:{ IOException -> 0x0149 }
            long r6 = r6 - r13
            java.lang.Long r13 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x0149 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0149 }
            long r6 = r6 - r3
            java.lang.Long r14 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r13 = new java.lang.Object[]{r5, r13, r14}     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqb.zzd(r1, r13)     // Catch:{ IOException -> 0x0149 }
            monitor-exit(r12)
            return
        L_0x0125:
            r13 = move-exception
            java.lang.String r14 = "%s"
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r13 = new java.lang.Object[]{r13}     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqb.zza(r14, r13)     // Catch:{ IOException -> 0x0149 }
            r3.close()     // Catch:{ IOException -> 0x0149 }
            java.lang.String r13 = "Failed to write header for %s"
            java.lang.String r14 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r14 = new java.lang.Object[]{r14}     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzaqb.zza(r13, r14)     // Catch:{ IOException -> 0x0149 }
            java.io.IOException r13 = new java.io.IOException     // Catch:{ IOException -> 0x0149 }
            r13.<init>()     // Catch:{ IOException -> 0x0149 }
            throw r13     // Catch:{ IOException -> 0x0149 }
        L_0x0149:
            boolean r13 = r0.delete()     // Catch:{ all -> 0x017f }
            if (r13 != 0) goto L_0x015c
            java.lang.String r13 = r0.getAbsolutePath()     // Catch:{ all -> 0x017f }
            java.lang.Object[] r13 = new java.lang.Object[]{r13}     // Catch:{ all -> 0x017f }
            java.lang.String r14 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzaqb.zza(r14, r13)     // Catch:{ all -> 0x017f }
        L_0x015c:
            com.google.android.gms.internal.ads.zzaqk r13 = r12.zzc     // Catch:{ all -> 0x017f }
            java.io.File r13 = r13.zza()     // Catch:{ all -> 0x017f }
            boolean r13 = r13.exists()     // Catch:{ all -> 0x017f }
            if (r13 != 0) goto L_0x017d
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ all -> 0x017f }
            java.lang.String r14 = "Re-initializing cache after external clearing."
            com.google.android.gms.internal.ads.zzaqb.zza(r14, r13)     // Catch:{ all -> 0x017f }
            java.util.Map r13 = r12.zza     // Catch:{ all -> 0x017f }
            r13.clear()     // Catch:{ all -> 0x017f }
            r13 = 0
            r12.zzb = r13     // Catch:{ all -> 0x017f }
            r12.zzb()     // Catch:{ all -> 0x017f }
            monitor-exit(r12)
            return
        L_0x017d:
            monitor-exit(r12)
            return
        L_0x017f:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x017f }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaql.zzd(java.lang.String, com.google.android.gms.internal.ads.zzaoy):void");
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzaqb.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzaql(File file, int i) {
        this.zzc = new zzaqh(this, file);
        this.zzd = 20971520;
    }
}
