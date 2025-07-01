package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
final class zzgw implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzgu zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzgr zzf;

    public zzgw(zzgr zzgr, String str, URL url, byte[] bArr, Map<String, String> map, zzgu zzgu) {
        this.zzf = zzgr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgu);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzgu;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.util.Map} */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f7 A[SYNTHETIC, Splitter:B:53:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0131 A[SYNTHETIC, Splitter:B:65:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            java.lang.String r1 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzgr r0 = r15.zzf
            r0.zzr()
            r2 = 0
            r3 = 0
            java.net.URL r0 = r15.zza     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            com.google.android.gms.internal.measurement.zzcy r4 = com.google.android.gms.internal.measurement.zzcy.zza()     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.lang.String r5 = "client-measurement"
            java.net.URLConnection r0 = r4.zza(r0, r5)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            boolean r4 = r0 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            if (r4 == 0) goto L_0x00e7
            r4 = r0
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r4.setDefaultUseCaches(r3)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r0 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r0)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r0 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r0)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r4.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r0 = 1
            r4.setDoInput(r0)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.util.Map<java.lang.String, java.lang.String> r5 = r15.zze     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            if (r5 == 0) goto L_0x005a
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
        L_0x003e:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            if (r6 == 0) goto L_0x005a
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r4.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            goto L_0x003e
        L_0x005a:
            byte[] r5 = r15.zzb     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            if (r5 == 0) goto L_0x00a5
            com.google.android.gms.measurement.internal.zzgr r5 = r15.zzf     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzoo r5 = r5.g_()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            byte[] r6 = r15.zzb     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            byte[] r5 = r5.zzb((byte[]) r6)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzgr r6 = r15.zzf     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzgo r6 = r6.zzj()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzp()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r5.length     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r6.zza(r7, r8)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r4.setDoOutput(r0)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r0, r6)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            int r0 = r5.length     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r4.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r4.connect()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            r6.write(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009a }
            r6.close()     // Catch:{ IOException -> 0x009e, all -> 0x009a }
            goto L_0x00a5
        L_0x009a:
            r0 = move-exception
            r13 = r2
            goto L_0x00f3
        L_0x009e:
            r0 = move-exception
            r8 = r0
            r10 = r2
            r7 = r3
            r2 = r6
            goto L_0x012f
        L_0x00a5:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x00e3, all -> 0x00e0 }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x00db, all -> 0x00d6 }
            com.google.android.gms.measurement.internal.zzgr r0 = r15.zzf     // Catch:{ IOException -> 0x00d2, all -> 0x00cd }
            byte[] r10 = com.google.android.gms.measurement.internal.zzgr.zza(r4)     // Catch:{ IOException -> 0x00d2, all -> 0x00cd }
            if (r4 == 0) goto L_0x00b8
            r4.disconnect()
        L_0x00b8:
            com.google.android.gms.measurement.internal.zzgr r0 = r15.zzf
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgt r5 = new com.google.android.gms.measurement.internal.zzgt
            java.lang.String r6 = r15.zzd
            com.google.android.gms.measurement.internal.zzgu r7 = r15.zzc
            r9 = 0
            r12 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzb((java.lang.Runnable) r5)
            return
        L_0x00cd:
            r0 = move-exception
            r6 = r2
            r10 = r8
            r13 = r11
            goto L_0x00f4
        L_0x00d2:
            r0 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x00de
        L_0x00d6:
            r0 = move-exception
            r6 = r2
            r13 = r6
            r10 = r8
            goto L_0x00f4
        L_0x00db:
            r0 = move-exception
            r10 = r2
            r7 = r8
        L_0x00de:
            r8 = r0
            goto L_0x012f
        L_0x00e0:
            r0 = move-exception
            r6 = r2
            goto L_0x00f2
        L_0x00e3:
            r0 = move-exception
            r8 = r0
            r10 = r2
            goto L_0x012e
        L_0x00e7:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r0.<init>(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            throw r0     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
        L_0x00ef:
            r0 = move-exception
            r4 = r2
            r6 = r4
        L_0x00f2:
            r13 = r6
        L_0x00f3:
            r10 = r3
        L_0x00f4:
            r2 = r0
            if (r6 == 0) goto L_0x010f
            r6.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x010f
        L_0x00fb:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgr r3 = r15.zzf
            com.google.android.gms.measurement.internal.zzgo r3 = r3.zzj()
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()
            java.lang.String r5 = r15.zzd
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r5)
            r3.zza(r1, r5, r0)
        L_0x010f:
            if (r4 == 0) goto L_0x0114
            r4.disconnect()
        L_0x0114:
            com.google.android.gms.measurement.internal.zzgr r0 = r15.zzf
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgt r7 = new com.google.android.gms.measurement.internal.zzgt
            java.lang.String r8 = r15.zzd
            com.google.android.gms.measurement.internal.zzgu r9 = r15.zzc
            r12 = 0
            r14 = 0
            r11 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r0.zzb((java.lang.Runnable) r7)
            throw r2
        L_0x012a:
            r0 = move-exception
            r8 = r0
            r4 = r2
            r10 = r4
        L_0x012e:
            r7 = r3
        L_0x012f:
            if (r2 == 0) goto L_0x0149
            r2.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x0149
        L_0x0135:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgr r2 = r15.zzf
            com.google.android.gms.measurement.internal.zzgo r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()
            java.lang.String r3 = r15.zzd
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r3)
            r2.zza(r1, r3, r0)
        L_0x0149:
            if (r4 == 0) goto L_0x014e
            r4.disconnect()
        L_0x014e:
            com.google.android.gms.measurement.internal.zzgr r0 = r15.zzf
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgt r4 = new com.google.android.gms.measurement.internal.zzgt
            java.lang.String r5 = r15.zzd
            com.google.android.gms.measurement.internal.zzgu r6 = r15.zzc
            r9 = 0
            r11 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zzb((java.lang.Runnable) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgw.run():void");
    }
}
