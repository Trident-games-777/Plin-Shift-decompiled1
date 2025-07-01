package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzaqe implements zzapi {
    protected final zzaqg zza;
    private final zzaqd zzb;

    public zzaqe(zzaqd zzaqd) {
        zzaqg zzaqg = new zzaqg(4096);
        this.zzb = zzaqd;
        this.zza = zzaqg;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:49|50|(3:51|52|(1:54)(1:144))|57|58|59|60|61|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01aa, code lost:
        r10 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0135 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0147 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzapl zza(com.google.android.gms.internal.ads.zzapp r23) throws com.google.android.gms.internal.ads.zzapy {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            java.lang.String r3 = "Error occurred when closing InputStream"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r6 = 0
            com.google.android.gms.internal.ads.zzaoy r0 = r2.zzd()     // Catch:{ IOException -> 0x01ac }
            if (r0 != 0) goto L_0x0019
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x01ac }
            goto L_0x0039
        L_0x0019:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ IOException -> 0x01ac }
            r7.<init>()     // Catch:{ IOException -> 0x01ac }
            java.lang.String r8 = r0.zzb     // Catch:{ IOException -> 0x01ac }
            if (r8 == 0) goto L_0x0027
            java.lang.String r9 = "If-None-Match"
            r7.put(r9, r8)     // Catch:{ IOException -> 0x01ac }
        L_0x0027:
            long r8 = r0.zzd     // Catch:{ IOException -> 0x01ac }
            r10 = 0
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r8 = com.google.android.gms.internal.ads.zzaqm.zzc(r8)     // Catch:{ IOException -> 0x01ac }
            r7.put(r0, r8)     // Catch:{ IOException -> 0x01ac }
        L_0x0038:
            r0 = r7
        L_0x0039:
            com.google.android.gms.internal.ads.zzaqd r7 = r1.zzb     // Catch:{ IOException -> 0x01ac }
            com.google.android.gms.internal.ads.zzaqn r7 = r7.zza(r2, r0)     // Catch:{ IOException -> 0x01ac }
            int r9 = r7.zzb()     // Catch:{ IOException -> 0x01a9 }
            java.util.List r14 = r7.zzd()     // Catch:{ IOException -> 0x01a9 }
            r0 = 304(0x130, float:4.26E-43)
            if (r9 != r0) goto L_0x0108
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x01a9 }
            long r19 = r8 - r4
            com.google.android.gms.internal.ads.zzaoy r0 = r2.zzd()     // Catch:{ IOException -> 0x01a9 }
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzapl r10 = new com.google.android.gms.internal.ads.zzapl     // Catch:{ IOException -> 0x01a9 }
            r12 = 0
            r13 = 1
            r11 = 304(0x130, float:4.26E-43)
            r16 = r14
            r14 = r19
            r10.<init>((int) r11, (byte[]) r12, (boolean) r13, (long) r14, (java.util.List) r16)     // Catch:{ IOException -> 0x01a9 }
            goto L_0x0107
        L_0x0066:
            java.util.TreeSet r8 = new java.util.TreeSet     // Catch:{ IOException -> 0x01a9 }
            java.util.Comparator r9 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x01a9 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x01a9 }
            boolean r9 = r14.isEmpty()     // Catch:{ IOException -> 0x01a9 }
            if (r9 != 0) goto L_0x008b
            java.util.Iterator r9 = r14.iterator()     // Catch:{ IOException -> 0x01a9 }
        L_0x0077:
            boolean r10 = r9.hasNext()     // Catch:{ IOException -> 0x01a9 }
            if (r10 == 0) goto L_0x008b
            java.lang.Object r10 = r9.next()     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaph r10 = (com.google.android.gms.internal.ads.zzaph) r10     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r10 = r10.zza()     // Catch:{ IOException -> 0x01a9 }
            r8.add(r10)     // Catch:{ IOException -> 0x01a9 }
            goto L_0x0077
        L_0x008b:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ IOException -> 0x01a9 }
            r9.<init>(r14)     // Catch:{ IOException -> 0x01a9 }
            java.util.List r10 = r0.zzh     // Catch:{ IOException -> 0x01a9 }
            if (r10 == 0) goto L_0x00ba
            boolean r10 = r10.isEmpty()     // Catch:{ IOException -> 0x01a9 }
            if (r10 != 0) goto L_0x00f7
            java.util.List r10 = r0.zzh     // Catch:{ IOException -> 0x01a9 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x01a9 }
        L_0x00a0:
            boolean r11 = r10.hasNext()     // Catch:{ IOException -> 0x01a9 }
            if (r11 == 0) goto L_0x00f7
            java.lang.Object r11 = r10.next()     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaph r11 = (com.google.android.gms.internal.ads.zzaph) r11     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r12 = r11.zza()     // Catch:{ IOException -> 0x01a9 }
            boolean r12 = r8.contains(r12)     // Catch:{ IOException -> 0x01a9 }
            if (r12 != 0) goto L_0x00a0
            r9.add(r11)     // Catch:{ IOException -> 0x01a9 }
            goto L_0x00a0
        L_0x00ba:
            java.util.Map r10 = r0.zzg     // Catch:{ IOException -> 0x01a9 }
            boolean r10 = r10.isEmpty()     // Catch:{ IOException -> 0x01a9 }
            if (r10 != 0) goto L_0x00f7
            java.util.Map r10 = r0.zzg     // Catch:{ IOException -> 0x01a9 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x01a9 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x01a9 }
        L_0x00cc:
            boolean r11 = r10.hasNext()     // Catch:{ IOException -> 0x01a9 }
            if (r11 == 0) goto L_0x00f7
            java.lang.Object r11 = r10.next()     // Catch:{ IOException -> 0x01a9 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ IOException -> 0x01a9 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ IOException -> 0x01a9 }
            boolean r12 = r8.contains(r12)     // Catch:{ IOException -> 0x01a9 }
            if (r12 != 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzaph r12 = new com.google.android.gms.internal.ads.zzaph     // Catch:{ IOException -> 0x01a9 }
            java.lang.Object r13 = r11.getKey()     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x01a9 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x01a9 }
            r12.<init>(r13, r11)     // Catch:{ IOException -> 0x01a9 }
            r9.add(r12)     // Catch:{ IOException -> 0x01a9 }
            goto L_0x00cc
        L_0x00f7:
            com.google.android.gms.internal.ads.zzapl r15 = new com.google.android.gms.internal.ads.zzapl     // Catch:{ IOException -> 0x01a9 }
            byte[] r0 = r0.zza     // Catch:{ IOException -> 0x01a9 }
            r18 = 1
            r16 = 304(0x130, float:4.26E-43)
            r17 = r0
            r21 = r9
            r15.<init>((int) r16, (byte[]) r17, (boolean) r18, (long) r19, (java.util.List) r21)     // Catch:{ IOException -> 0x01a9 }
            r10 = r15
        L_0x0107:
            return r10
        L_0x0108:
            java.io.InputStream r8 = r7.zzc()     // Catch:{ IOException -> 0x01a9 }
            r10 = 0
            if (r8 == 0) goto L_0x0153
            int r0 = r7.zza()     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaqg r11 = r1.zza     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaqt r12 = new com.google.android.gms.internal.ads.zzaqt     // Catch:{ IOException -> 0x01a9 }
            r12.<init>(r11, r0)     // Catch:{ IOException -> 0x01a9 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r11.zzb(r0)     // Catch:{ all -> 0x0141 }
        L_0x0120:
            int r0 = r8.read(r13)     // Catch:{ all -> 0x012b }
            r15 = -1
            if (r0 == r15) goto L_0x012d
            r12.write(r13, r10, r0)     // Catch:{ all -> 0x012b }
            goto L_0x0120
        L_0x012b:
            r0 = move-exception
            goto L_0x0143
        L_0x012d:
            byte[] r0 = r12.toByteArray()     // Catch:{ all -> 0x012b }
            r8.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x013a
        L_0x0135:
            java.lang.Object[] r8 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaqb.zzd(r3, r8)     // Catch:{ IOException -> 0x01a9 }
        L_0x013a:
            r11.zza(r13)     // Catch:{ IOException -> 0x01a9 }
            r12.close()     // Catch:{ IOException -> 0x01a9 }
            goto L_0x0155
        L_0x0141:
            r0 = move-exception
            r13 = r6
        L_0x0143:
            r8.close()     // Catch:{ IOException -> 0x0147 }
            goto L_0x014c
        L_0x0147:
            java.lang.Object[] r8 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x01a9 }
            com.google.android.gms.internal.ads.zzaqb.zzd(r3, r8)     // Catch:{ IOException -> 0x01a9 }
        L_0x014c:
            r11.zza(r13)     // Catch:{ IOException -> 0x01a9 }
            r12.close()     // Catch:{ IOException -> 0x01a9 }
            throw r0     // Catch:{ IOException -> 0x01a9 }
        L_0x0153:
            byte[] r0 = new byte[r10]     // Catch:{ IOException -> 0x01a9 }
        L_0x0155:
            r10 = r0
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x01a7 }
            long r11 = r11 - r4
            boolean r0 = com.google.android.gms.internal.ads.zzaqb.zzb     // Catch:{ IOException -> 0x01a7 }
            if (r0 != 0) goto L_0x0165
            r15 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x018c
        L_0x0165:
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ IOException -> 0x01a7 }
            if (r10 == 0) goto L_0x0173
            int r11 = r10.length     // Catch:{ IOException -> 0x01a7 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException -> 0x01a7 }
            goto L_0x0175
        L_0x0173:
            java.lang.String r11 = "null"
        L_0x0175:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x01a7 }
            com.google.android.gms.internal.ads.zzapd r13 = r2.zzy()     // Catch:{ IOException -> 0x01a7 }
            int r13 = r13.zza()     // Catch:{ IOException -> 0x01a7 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x01a7 }
            java.lang.Object[] r8 = new java.lang.Object[]{r2, r8, r11, r12, r13}     // Catch:{ IOException -> 0x01a7 }
            com.google.android.gms.internal.ads.zzaqb.zza(r0, r8)     // Catch:{ IOException -> 0x01a7 }
        L_0x018c:
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 < r0) goto L_0x01a1
            r0 = 299(0x12b, float:4.19E-43)
            if (r9 > r0) goto L_0x01a1
            com.google.android.gms.internal.ads.zzapl r8 = new com.google.android.gms.internal.ads.zzapl     // Catch:{ IOException -> 0x01a7 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x01a7 }
            long r12 = r11 - r4
            r11 = 0
            r8.<init>((int) r9, (byte[]) r10, (boolean) r11, (long) r12, (java.util.List) r14)     // Catch:{ IOException -> 0x01a7 }
            return r8
        L_0x01a1:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01a7 }
            r0.<init>()     // Catch:{ IOException -> 0x01a7 }
            throw r0     // Catch:{ IOException -> 0x01a7 }
        L_0x01a7:
            r0 = move-exception
            goto L_0x01af
        L_0x01a9:
            r0 = move-exception
            r10 = r6
            goto L_0x01af
        L_0x01ac:
            r0 = move-exception
            r7 = r6
            r10 = r7
        L_0x01af:
            boolean r8 = r0 instanceof java.net.SocketTimeoutException
            if (r8 == 0) goto L_0x01c1
            com.google.android.gms.internal.ads.zzaqr r0 = new com.google.android.gms.internal.ads.zzaqr
            com.google.android.gms.internal.ads.zzapx r7 = new com.google.android.gms.internal.ads.zzapx
            r7.<init>()
            java.lang.String r8 = "socket"
            r0.<init>(r8, r7, r6)
        L_0x01bf:
            r6 = r0
            goto L_0x0225
        L_0x01c1:
            boolean r8 = r0 instanceof java.net.MalformedURLException
            if (r8 != 0) goto L_0x0268
            if (r7 == 0) goto L_0x0262
            int r9 = r7.zzb()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            java.lang.String r8 = r2.zzk()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r8}
            java.lang.String r8 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzaqb.zzb(r8, r0)
            if (r10 == 0) goto L_0x0218
            java.util.List r14 = r7.zzd()
            com.google.android.gms.internal.ads.zzapl r8 = new com.google.android.gms.internal.ads.zzapl
            long r11 = android.os.SystemClock.elapsedRealtime()
            long r12 = r11 - r4
            r11 = 0
            r8.<init>((int) r9, (byte[]) r10, (boolean) r11, (long) r12, (java.util.List) r14)
            r0 = 401(0x191, float:5.62E-43)
            if (r9 == r0) goto L_0x020b
            r0 = 403(0x193, float:5.65E-43)
            if (r9 != r0) goto L_0x01f7
            goto L_0x020b
        L_0x01f7:
            r0 = 400(0x190, float:5.6E-43)
            if (r9 < r0) goto L_0x0205
            r0 = 499(0x1f3, float:6.99E-43)
            if (r9 > r0) goto L_0x0205
            com.google.android.gms.internal.ads.zzapc r0 = new com.google.android.gms.internal.ads.zzapc
            r0.<init>(r8)
            throw r0
        L_0x0205:
            com.google.android.gms.internal.ads.zzapw r0 = new com.google.android.gms.internal.ads.zzapw
            r0.<init>(r8)
            throw r0
        L_0x020b:
            com.google.android.gms.internal.ads.zzaqr r0 = new com.google.android.gms.internal.ads.zzaqr
            com.google.android.gms.internal.ads.zzaox r7 = new com.google.android.gms.internal.ads.zzaox
            r7.<init>(r8)
            java.lang.String r8 = "auth"
            r0.<init>(r8, r7, r6)
            goto L_0x01bf
        L_0x0218:
            com.google.android.gms.internal.ads.zzaqr r0 = new com.google.android.gms.internal.ads.zzaqr
            com.google.android.gms.internal.ads.zzapk r7 = new com.google.android.gms.internal.ads.zzapk
            r7.<init>()
            java.lang.String r8 = "network"
            r0.<init>(r8, r7, r6)
            goto L_0x01bf
        L_0x0225:
            com.google.android.gms.internal.ads.zzapd r0 = r2.zzy()
            int r7 = r2.zzb()
            com.google.android.gms.internal.ads.zzapy r8 = r6.zzb     // Catch:{ zzapy -> 0x024b }
            r0.zzc(r8)     // Catch:{ zzapy -> 0x024b }
            java.lang.String r0 = r6.zza
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r6}
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r2.zzm(r0)
            goto L_0x000a
        L_0x024b:
            r0 = move-exception
            java.lang.String r3 = r6.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r4}
            java.lang.String r4 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r2.zzm(r3)
            throw r0
        L_0x0262:
            com.google.android.gms.internal.ads.zzapm r2 = new com.google.android.gms.internal.ads.zzapm
            r2.<init>(r0)
            throw r2
        L_0x0268:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r2 = r2.zzk()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "Bad URL "
            java.lang.String r2 = r4.concat(r2)
            r3.<init>(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqe.zza(com.google.android.gms.internal.ads.zzapp):com.google.android.gms.internal.ads.zzapl");
    }
}
