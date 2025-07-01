package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdu extends zzcdr {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcdu(zzccf zzccf) {
        super(zzccf);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzm.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfsc.zza(zzfsb.zza(), cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            zzm.zzj("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        } else if (!this.zzg.setReadable(true, false) || !this.zzg.setExecutable(true, false)) {
            zzm.zzj("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        }
    }

    private final File zza(File file) {
        return new File(zzfsc.zza(zzfsb.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f2, code lost:
        r22 = r3;
        r13 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r8 = "File too big for full file cache. Size: " + java.lang.Integer.toString(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0313, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0314, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0317, code lost:
        r4 = r8;
        r8 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x031b, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r22.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0325, code lost:
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0327, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zze("Preloaded " + zzf.format((long) r11) + " bytes from " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x034a, code lost:
        r9.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0353, code lost:
        if (r10.isFile() == false) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0355, code lost:
        r10.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r10.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        zzh(r2, r9.getAbsolutePath(), r11);
        zze.remove(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x036c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x036f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0371, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0373, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0376, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0378, code lost:
        r8 = r22;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x037c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x037f, code lost:
        r4 = null;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0383, code lost:
        if ((r0 instanceof java.lang.RuntimeException) != false) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0385, code lost:
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0393, code lost:
        if (r1.zzh != false) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0395, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Preload aborted for URL \"" + r2 + "\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03ac, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzk("Preload failed for URL \"" + r2 + "\"", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03ce, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not delete partial cache file at ".concat(java.lang.String.valueOf(r9.getAbsolutePath())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03df, code lost:
        zzg(r2, r9.getAbsolutePath(), r13, r4);
        zze.remove(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        r13 = com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0 = com.google.android.gms.internal.ads.zzfsy.zza().zzn(new com.google.android.gms.internal.ads.zzcdt(r2), 265, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0121, code lost:
        if ((r0 instanceof java.net.HttpURLConnection) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0123, code lost:
        r3 = r0;
        r3 = r0.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012c, code lost:
        if (r3 >= 400) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012f, code lost:
        r13 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r4 = "HTTP request failed. Code: " + java.lang.Integer.toString(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0164, code lost:
        throw new java.io.IOException("HTTP status code " + r3 + " at " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0165, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016e, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r5 = r0.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0175, code lost:
        if (r5 >= 0) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0177, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Stream cache aborted, missing content-length header at " + r2);
        zzg(r2, r9.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        r4.remove(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0197, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0198, code lost:
        r3 = zzf.format((long) r5);
        r14 = ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzq)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01af, code lost:
        if (r5 <= r14) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b1, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Content length " + r3 + " exceeds limit at " + r2);
        r0 = new java.lang.StringBuilder();
        r0.append("File too big for full file cache. Size: ");
        r0.append(r3);
        zzg(r2, r9.getAbsolutePath(), "sizeExceeded", r0.toString());
        r4.remove(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ea, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01eb, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zze("Caching " + r3 + " bytes from " + r2);
        r15 = java.nio.channels.Channels.newChannel(r0.getInputStream());
        r3 = new java.io.FileOutputStream(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r0 = r3.getChannel();
        r4 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzv.zzC();
        r17 = r16.currentTimeMillis();
        r6 = new com.google.android.gms.ads.internal.util.zzbw(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzI)).longValue());
        r7 = ((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzH)).longValue();
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x024c, code lost:
        r21 = r15.read(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0250, code lost:
        if (r21 < 0) goto L_0x031b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0252, code lost:
        r11 = r11 + r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0254, code lost:
        if (r11 > r14) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0256, code lost:
        r4.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x025d, code lost:
        if (r0.write(r4) > 0) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x025f, code lost:
        r4.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x026e, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r7)) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0270, code lost:
        r21 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0274, code lost:
        if (r1.zzh != false) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x027a, code lost:
        if (r6.zzb() == false) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x027c, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r24 = r6;
        r25 = r11;
        r11 = r4;
        r4 = r25;
        r25 = r7;
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new com.google.android.gms.internal.ads.zzcdl(r1, r2, r9.getAbsolutePath(), r4, r5, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x029b, code lost:
        r22 = r11;
        r11 = r4;
        r4 = r22;
        r22 = r3;
        r24 = r6;
        r25 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02a6, code lost:
        r0 = r11;
        r11 = r4;
        r4 = r0;
        r0 = r21;
        r3 = r22;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b2, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02bd, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02be, code lost:
        r22 = r3;
        r13 = "downloadTimeout";
        r8 = "Timeout exceeded. Limit: " + java.lang.Long.toString(r7) + " sec";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e5, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02e6, code lost:
        r27 = r11;
        r11 = r4;
        r4 = r27;
        r27 = r11;
        r11 = r4;
        r4 = r27;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x0360 */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x036f A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r13 r22 
      PHI: (r13v4 java.lang.String) = (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v0 java.lang.String), (r13v5 java.lang.String), (r13v0 java.lang.String) binds: [B:109:0x031d, B:118:0x0360, B:119:?, B:116:0x035d, B:117:?, B:101:0x02f7, B:89:0x027e] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r22v4 java.io.FileOutputStream) = (r22v2 java.io.FileOutputStream), (r22v2 java.io.FileOutputStream), (r22v2 java.io.FileOutputStream), (r22v2 java.io.FileOutputStream), (r22v2 java.io.FileOutputStream), (r22v5 java.io.FileOutputStream), (r22v12 java.io.FileOutputStream) binds: [B:109:0x031d, B:118:0x0360, B:119:?, B:116:0x035d, B:117:?, B:101:0x02f7, B:89:0x027e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:89:0x027e] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.io.File r0 = r1.zzg
            r7 = 0
            r8 = 0
            if (r0 == 0) goto L_0x03f1
        L_0x000a:
            java.io.File r0 = r1.zzg
            if (r0 != 0) goto L_0x0010
            r5 = r7
            goto L_0x002c
        L_0x0010:
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = r7
            r5 = r4
        L_0x0017:
            if (r4 >= r3) goto L_0x002c
            r6 = r0[r4]
            java.lang.String r6 = r6.getName()
            java.lang.String r9 = ".done"
            boolean r6 = r6.endsWith(r9)
            if (r6 != 0) goto L_0x0029
            int r5 = r5 + 1
        L_0x0029:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x002c:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzp
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r5 <= r0) goto L_0x0090
            java.io.File r0 = r1.zzg
            if (r0 != 0) goto L_0x0043
            goto L_0x0085
        L_0x0043:
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r7
            r9 = r8
        L_0x004f:
            if (r6 >= r3) goto L_0x006c
            r10 = r0[r6]
            java.lang.String r11 = r10.getName()
            java.lang.String r12 = ".done"
            boolean r11 = r11.endsWith(r12)
            if (r11 != 0) goto L_0x0069
            long r11 = r10.lastModified()
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 >= 0) goto L_0x0069
            r9 = r10
            r4 = r11
        L_0x0069:
            int r6 = r6 + 1
            goto L_0x004f
        L_0x006c:
            if (r9 == 0) goto L_0x0082
            boolean r0 = r9.delete()
            java.io.File r3 = r1.zza(r9)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x0083
            boolean r3 = r3.delete()
            r0 = r0 & r3
            goto L_0x0083
        L_0x0082:
            r0 = r7
        L_0x0083:
            if (r0 != 0) goto L_0x000a
        L_0x0085:
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            java.lang.String r0 = "expireFailed"
            r1.zzg(r2, r8, r0, r8)
            return r7
        L_0x0090:
            java.lang.String r0 = com.google.android.gms.ads.internal.util.client.zzf.zzf(r2)
            java.io.File r9 = new java.io.File
            com.google.android.gms.internal.ads.zzfsd r3 = com.google.android.gms.internal.ads.zzfsb.zza()
            java.io.File r4 = r1.zzg
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfsc.zza(r3, r4, r0)
            r9.<init>(r0)
            java.io.File r10 = r1.zza(r9)
            boolean r0 = r9.isFile()
            r11 = 1
            if (r0 == 0) goto L_0x00cf
            boolean r0 = r10.isFile()
            if (r0 != 0) goto L_0x00b5
            goto L_0x00cf
        L_0x00b5:
            long r3 = r9.length()
            int r0 = (int) r3
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "Stream cache hit at "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.ads.internal.util.client.zzm.zze(r3)
            java.lang.String r3 = r9.getAbsolutePath()
            r1.zzh(r2, r3, r0)
            return r11
        L_0x00cf:
            java.io.File r0 = r1.zzg
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.util.Set r4 = zze
            java.lang.String r12 = r0.concat(r3)
            monitor-enter(r4)
            boolean r0 = r4.contains(r12)     // Catch:{ all -> 0x03ee }
            if (r0 == 0) goto L_0x0109
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ee }
            r0.<init>()     // Catch:{ all -> 0x03ee }
            java.lang.String r3 = "Stream cache already in progress at "
            r0.append(r3)     // Catch:{ all -> 0x03ee }
            r0.append(r2)     // Catch:{ all -> 0x03ee }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03ee }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x03ee }
            java.lang.String r0 = r9.getAbsolutePath()     // Catch:{ all -> 0x03ee }
            java.lang.String r3 = "inProgress"
            r1.zzg(r2, r0, r3, r8)     // Catch:{ all -> 0x03ee }
            monitor-exit(r4)     // Catch:{ all -> 0x03ee }
            return r7
        L_0x0109:
            r4.add(r12)     // Catch:{ all -> 0x03ee }
            monitor-exit(r4)     // Catch:{ all -> 0x03ee }
            java.lang.String r13 = "error"
            com.google.android.gms.internal.ads.zzfsy r0 = com.google.android.gms.internal.ads.zzfsy.zza()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.internal.ads.zzcdt r3 = new com.google.android.gms.internal.ads.zzcdt     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r3.<init>(r2)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r5 = 265(0x109, float:3.71E-43)
            r6 = -1
            java.net.HttpURLConnection r0 = r0.zzn(r3, r5, r6)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            boolean r3 = r0 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            if (r3 == 0) goto L_0x0171
            r3 = r0
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r5 = 400(0x190, float:5.6E-43)
            if (r3 >= r5) goto L_0x012f
            goto L_0x0171
        L_0x012f:
            java.lang.String r13 = "badUrl"
            java.lang.String r0 = java.lang.Integer.toString(r3)     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            r4.<init>()     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            java.lang.String r5 = "HTTP request failed. Code: "
            r4.append(r5)     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            r4.append(r0)     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x016d, RuntimeException -> 0x016b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            r5.<init>()     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            java.lang.String r6 = "HTTP status code "
            r5.append(r6)     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            r5.append(r3)     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            java.lang.String r3 = " at "
            r5.append(r3)     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            r5.append(r2)     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            java.lang.String r3 = r5.toString()     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
            throw r0     // Catch:{ IOException -> 0x0168, RuntimeException -> 0x0165 }
        L_0x0165:
            r0 = move-exception
            goto L_0x0381
        L_0x0168:
            r0 = move-exception
            goto L_0x0381
        L_0x016b:
            r0 = move-exception
            goto L_0x016e
        L_0x016d:
            r0 = move-exception
        L_0x016e:
            r4 = r8
            goto L_0x0381
        L_0x0171:
            int r5 = r0.getContentLength()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            if (r5 >= 0) goto L_0x0198
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.<init>()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = "Stream cache aborted, missing content-length header at "
            r0.append(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.append(r2)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r0 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = "contentLengthMissing"
            r1.zzg(r2, r0, r3, r8)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r4.remove(r12)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            return r7
        L_0x0198:
            java.text.DecimalFormat r3 = zzf     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            long r14 = (long) r5     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = r3.format(r14)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzq     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.internal.ads.zzbcl r14 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.Object r6 = r14.zza(r6)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            int r14 = r6.intValue()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            if (r5 <= r14) goto L_0x01eb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.<init>()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r5 = "Content length "
            r0.append(r5)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.append(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r5 = " exceeds limit at "
            r0.append(r5)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.append(r2)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.<init>()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r5 = "File too big for full file cache. Size: "
            r0.append(r5)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r0.append(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r5 = "sizeExceeded"
            r1.zzg(r2, r3, r5, r0)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r4.remove(r12)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            return r7
        L_0x01eb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r4.<init>()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r6 = "Caching "
            r4.append(r6)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r4.append(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = " bytes from "
            r4.append(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r4.append(r2)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r3)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.nio.channels.ReadableByteChannel r15 = java.nio.channels.Channels.newChannel(r0)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r3.<init>(r9)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.nio.channels.FileChannel r0 = r3.getChannel()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            r4 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzI     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            java.lang.Object r6 = r8.zza(r6)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            long r7 = r6.longValue()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.ads.internal.util.zzbw r6 = new com.google.android.gms.ads.internal.util.zzbw     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.internal.ads.zzbce r7 = com.google.android.gms.internal.ads.zzbcn.zzH     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            java.lang.Object r7 = r8.zza(r7)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            long r7 = r7.longValue()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            r11 = 0
        L_0x024c:
            int r21 = r15.read(r4)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            if (r21 < 0) goto L_0x031b
            int r11 = r11 + r21
            if (r11 > r14) goto L_0x02f2
            r4.flip()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
        L_0x0259:
            int r21 = r0.write(r4)     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            if (r21 > 0) goto L_0x02e6
            r4.clear()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            long r21 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            long r21 = r21 - r17
            r23 = 1000(0x3e8, double:4.94E-321)
            long r23 = r23 * r7
            int r21 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r21 > 0) goto L_0x02be
            r21 = r0
            boolean r0 = r1.zzh     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            if (r0 != 0) goto L_0x02b2
            boolean r0 = r6.zzb()     // Catch:{ IOException -> 0x0375, RuntimeException -> 0x0373 }
            if (r0 == 0) goto L_0x029b
            r22 = r3
            java.lang.String r3 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            android.os.Handler r0 = com.google.android.gms.ads.internal.util.client.zzf.zza     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r23 = r0
            com.google.android.gms.internal.ads.zzcdl r0 = new com.google.android.gms.internal.ads.zzcdl     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r24 = r6
            r6 = 0
            r25 = r11
            r11 = r4
            r4 = r25
            r25 = r7
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r7.post(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            goto L_0x02a6
        L_0x029b:
            r22 = r11
            r11 = r4
            r4 = r22
            r22 = r3
            r24 = r6
            r25 = r7
        L_0x02a6:
            r0 = r11
            r11 = r4
            r4 = r0
            r0 = r21
            r3 = r22
            r6 = r24
            r7 = r25
            goto L_0x024c
        L_0x02b2:
            r22 = r3
            java.lang.String r13 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r3 = "abort requested"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            throw r0     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
        L_0x02be:
            r22 = r3
            r25 = r7
            java.lang.String r13 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r25)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.<init>()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r4 = "Timeout exceeded. Limit: "
            r3.append(r4)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.append(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r0 = " sec"
            r3.append(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r8 = r3.toString()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
            java.lang.String r3 = "stream cache time limit exceeded"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
            throw r0     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
        L_0x02e6:
            r27 = r11
            r11 = r4
            r4 = r27
            r27 = r11
            r11 = r4
            r4 = r27
            goto L_0x0259
        L_0x02f2:
            r22 = r3
            r4 = r11
            java.lang.String r13 = "sizeExceeded"
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.<init>()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r4 = "File too big for full file cache. Size: "
            r3.append(r4)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.append(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r8 = r3.toString()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
            java.lang.String r3 = "stream cache file size limit exceeded"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
            throw r0     // Catch:{ IOException -> 0x0316, RuntimeException -> 0x0314 }
        L_0x0314:
            r0 = move-exception
            goto L_0x0317
        L_0x0316:
            r0 = move-exception
        L_0x0317:
            r4 = r8
            r8 = r22
            goto L_0x0381
        L_0x031b:
            r22 = r3
            r22.close()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r0 = 3
            boolean r0 = com.google.android.gms.ads.internal.util.zze.zzm(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            if (r0 == 0) goto L_0x034a
            java.text.DecimalFormat r0 = zzf     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            long r3 = (long) r11     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r0 = r0.format(r3)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.<init>()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r4 = "Preloaded "
            r3.append(r4)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.append(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r0 = " bytes from "
            r3.append(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r3.append(r2)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
        L_0x034a:
            r0 = 1
            r3 = 0
            r9.setReadable(r0, r3)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            boolean r0 = r10.isFile()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            if (r0 == 0) goto L_0x035d
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r10.setLastModified(r3)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            goto L_0x0360
        L_0x035d:
            r10.createNewFile()     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x036f }
        L_0x0360:
            java.lang.String r0 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r1.zzh(r2, r0, r11)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r0.remove(r12)     // Catch:{ IOException -> 0x0371, RuntimeException -> 0x036f }
            r20 = 1
            return r20
        L_0x036f:
            r0 = move-exception
            goto L_0x0378
        L_0x0371:
            r0 = move-exception
            goto L_0x0378
        L_0x0373:
            r0 = move-exception
            goto L_0x0376
        L_0x0375:
            r0 = move-exception
        L_0x0376:
            r22 = r3
        L_0x0378:
            r8 = r22
            r4 = 0
            goto L_0x0381
        L_0x037c:
            r0 = move-exception
            goto L_0x037f
        L_0x037e:
            r0 = move-exception
        L_0x037f:
            r4 = 0
            r8 = 0
        L_0x0381:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x038e
            java.lang.String r3 = "VideoStreamFullFileCache.preload"
            com.google.android.gms.internal.ads.zzbzz r5 = com.google.android.gms.ads.internal.zzv.zzp()
            r5.zzw(r0, r3)
        L_0x038e:
            r8.close()     // Catch:{ IOException | NullPointerException -> 0x0391 }
        L_0x0391:
            boolean r3 = r1.zzh
            if (r3 == 0) goto L_0x03ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Preload aborted for URL \""
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r3 = "\""
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r0)
            goto L_0x03c2
        L_0x03ac:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Preload failed for URL \""
            r3.<init>(r5)
            r3.append(r2)
            java.lang.String r5 = "\""
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r3, r0)
        L_0x03c2:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x03df
            boolean r0 = r9.delete()
            if (r0 != 0) goto L_0x03df
            java.lang.String r0 = r9.getAbsolutePath()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Could not delete partial cache file at "
            java.lang.String r0 = r3.concat(r0)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
        L_0x03df:
            java.lang.String r0 = r9.getAbsolutePath()
            r1.zzg(r2, r0, r13, r4)
            java.util.Set r0 = zze
            r0.remove(r12)
        L_0x03eb:
            r19 = 0
            return r19
        L_0x03ee:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x03ee }
            throw r0
        L_0x03f1:
            java.lang.String r0 = "noCacheDir"
            r3 = 0
            r1.zzg(r2, r3, r0, r3)
            goto L_0x03eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdu.zzt(java.lang.String):boolean");
    }
}
