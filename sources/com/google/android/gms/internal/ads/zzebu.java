package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzebu implements zzfiv {
    protected final Context zza;
    protected final String zzb;

    public zzebu(Context context, String str, zzbwf zzbwf, int i) {
        this.zza = context;
        this.zzb = str;
    }

    /* renamed from: zzb */
    public final zzebt zza(zzebs zzebs) throws zzdwn {
        return zzc(zzebs.zza, zzebs.zzb, zzebs.zzc, zzebs.zzd, zzebs.zze, zzv.zzC().elapsedRealtime());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.io.InputStreamReader} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2 = new java.io.InputStreamReader(r12.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        com.google.android.gms.ads.internal.zzv.zzq();
        r0 = com.google.android.gms.ads.internal.util.zzs.zzN(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r9.zzg(r0);
        r7.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0136, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzfu)).booleanValue() == false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0151, code lost:
        throw new com.google.android.gms.internal.ads.zzdwn(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0152, code lost:
        r7.zzd = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r12.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0163, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0164, code lost:
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0226, code lost:
        return r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzebt zzc(java.lang.String r18, int r19, java.util.Map r20, byte[] r21, java.lang.String r22, long r23) throws com.google.android.gms.internal.ads.zzdwn {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r21
            java.lang.String r3 = "Received error HTTP response code: "
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r5 = "SDK version: "
            r6 = 1
            com.google.android.gms.internal.ads.zzebt r7 = new com.google.android.gms.internal.ads.zzebt     // Catch:{ IOException -> 0x022c }
            r7.<init>()     // Catch:{ IOException -> 0x022c }
            java.lang.String r8 = r1.zzb     // Catch:{ IOException -> 0x022c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
            r9.<init>(r5)     // Catch:{ IOException -> 0x022c }
            r9.append(r8)     // Catch:{ IOException -> 0x022c }
            java.lang.String r5 = r9.toString()     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r5)     // Catch:{ IOException -> 0x022c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x022c }
            r5.append(r0)     // Catch:{ IOException -> 0x022c }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r4)     // Catch:{ IOException -> 0x022c }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x022c }
            r4.<init>(r0)     // Catch:{ IOException -> 0x022c }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ IOException -> 0x022c }
            r5.<init>()     // Catch:{ IOException -> 0x022c }
            r0 = 0
            r16 = r4
            r4 = r0
            r0 = r16
        L_0x0042:
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x022c }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.zzs r8 = com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ zzdwn -> 0x0205 }
            android.content.Context r9 = r1.zza     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r10 = r1.zzb     // Catch:{ zzdwn -> 0x0205 }
            r11 = 0
            r13 = 0
            r14 = r19
            r8.zzf(r9, r10, r11, r12, r13, r14)     // Catch:{ zzdwn -> 0x0205 }
            java.util.Set r0 = r20.entrySet()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ zzdwn -> 0x0205 }
        L_0x0060:
            boolean r8 = r0.hasNext()     // Catch:{ zzdwn -> 0x0205 }
            if (r8 == 0) goto L_0x007c
            java.lang.Object r8 = r0.next()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r9 = r8.getKey()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ zzdwn -> 0x0205 }
            r12.addRequestProperty(r9, r8)     // Catch:{ zzdwn -> 0x0205 }
            goto L_0x0060
        L_0x007c:
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ zzdwn -> 0x0205 }
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = "Content-Type"
            r8 = r22
            r12.setRequestProperty(r0, r8)     // Catch:{ zzdwn -> 0x0205 }
            goto L_0x008c
        L_0x008a:
            r8 = r22
        L_0x008c:
            com.google.android.gms.ads.internal.util.client.zzl r9 = new com.google.android.gms.ads.internal.util.client.zzl     // Catch:{ zzdwn -> 0x0205 }
            r10 = 0
            r9.<init>(r10)     // Catch:{ zzdwn -> 0x0205 }
            r9.zzc(r12, r2)     // Catch:{ all -> 0x0096 }
            goto L_0x00a5
        L_0x0096:
            r0 = move-exception
            java.lang.String r11 = "Network request logging failed."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r11, r0)     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzbzz r11 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r13 = "HttpRequestFunction.logAdRequest"
            r11.zzv(r0, r13)     // Catch:{ zzdwn -> 0x0205 }
        L_0x00a5:
            int r0 = r2.length     // Catch:{ zzdwn -> 0x0205 }
            if (r0 <= 0) goto L_0x00c6
            r12.setDoOutput(r6)     // Catch:{ zzdwn -> 0x0205 }
            r12.setFixedLengthStreamingMode(r0)     // Catch:{ zzdwn -> 0x0205 }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00c1 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x00c1 }
            r11.<init>(r0)     // Catch:{ all -> 0x00c1 }
            r11.write(r2)     // Catch:{ all -> 0x00be }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11)     // Catch:{ zzdwn -> 0x0205 }
            goto L_0x00c6
        L_0x00be:
            r0 = move-exception
            r10 = r11
            goto L_0x00c2
        L_0x00c1:
            r0 = move-exception
        L_0x00c2:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r10)     // Catch:{ zzdwn -> 0x0205 }
            throw r0     // Catch:{ zzdwn -> 0x0205 }
        L_0x00c6:
            int r0 = r12.getResponseCode()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Map r11 = r12.getHeaderFields()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ zzdwn -> 0x0205 }
        L_0x00d6:
            boolean r13 = r11.hasNext()     // Catch:{ zzdwn -> 0x0205 }
            if (r13 == 0) goto L_0x0107
            java.lang.Object r13 = r11.next()     // Catch:{ zzdwn -> 0x0205 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ zzdwn -> 0x0205 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ zzdwn -> 0x0205 }
            boolean r15 = r5.containsKey(r14)     // Catch:{ zzdwn -> 0x0205 }
            if (r15 == 0) goto L_0x00fe
            java.lang.Object r14 = r5.get(r14)     // Catch:{ zzdwn -> 0x0205 }
            java.util.List r14 = (java.util.List) r14     // Catch:{ zzdwn -> 0x0205 }
            r14.addAll(r13)     // Catch:{ zzdwn -> 0x0205 }
            goto L_0x00d6
        L_0x00fe:
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ zzdwn -> 0x0205 }
            r15.<init>(r13)     // Catch:{ zzdwn -> 0x0205 }
            r5.put(r14, r15)     // Catch:{ zzdwn -> 0x0205 }
            goto L_0x00d6
        L_0x0107:
            r9.zze(r12, r0)     // Catch:{ zzdwn -> 0x0205 }
            r7.zza = r0     // Catch:{ zzdwn -> 0x0205 }
            r7.zzb = r5     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r11 = ""
            r7.zzc = r11     // Catch:{ zzdwn -> 0x0205 }
            r11 = 200(0xc8, float:2.8E-43)
            r13 = 300(0x12c, float:4.2E-43)
            if (r0 < r11) goto L_0x016b
            if (r0 >= r13) goto L_0x016b
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0166 }
            java.io.InputStream r0 = r12.getInputStream()     // Catch:{ all -> 0x0166 }
            r2.<init>(r0)     // Catch:{ all -> 0x0166 }
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0163 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzs.zzN(r2)     // Catch:{ all -> 0x0163 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzdwn -> 0x0205 }
            r9.zzg(r0)     // Catch:{ zzdwn -> 0x0205 }
            r7.zzc = r0     // Catch:{ zzdwn -> 0x0205 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzdwn -> 0x0205 }
            if (r0 == 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzfu     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzdwn -> 0x0205 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzdwn -> 0x0205 }
            if (r0 == 0) goto L_0x014b
            goto L_0x0152
        L_0x014b:
            com.google.android.gms.internal.ads.zzdwn r0 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzdwn -> 0x0205 }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzdwn -> 0x0205 }
            throw r0     // Catch:{ zzdwn -> 0x0205 }
        L_0x0152:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ zzdwn -> 0x0205 }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzdwn -> 0x0205 }
            long r2 = r2 - r23
            r7.zzd = r2     // Catch:{ zzdwn -> 0x0205 }
        L_0x015e:
            r12.disconnect()     // Catch:{ IOException -> 0x022c }
            goto L_0x0226
        L_0x0163:
            r0 = move-exception
            r10 = r2
            goto L_0x0167
        L_0x0166:
            r0 = move-exception
        L_0x0167:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r10)     // Catch:{ zzdwn -> 0x0205 }
            throw r0     // Catch:{ zzdwn -> 0x0205 }
        L_0x016b:
            if (r0 < r13) goto L_0x01dc
            r9 = 400(0x190, float:5.6E-43)
            if (r0 >= r9) goto L_0x01dc
            java.lang.String r0 = "Location"
            java.lang.String r0 = r12.getHeaderField(r0)     // Catch:{ zzdwn -> 0x0205 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzdwn -> 0x0205 }
            if (r9 != 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzhw     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzbcl r10 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r9 = r10.zza(r9)     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ zzdwn -> 0x0205 }
            boolean r9 = r9.booleanValue()     // Catch:{ zzdwn -> 0x0205 }
            if (r9 == 0) goto L_0x01a4
            java.net.URI r9 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0199 }
            r9.<init>(r0)     // Catch:{ URISyntaxException -> 0x0199 }
            java.net.URL r0 = r9.toURL()     // Catch:{ URISyntaxException -> 0x0199 }
            goto L_0x01aa
        L_0x0199:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzdwn r2 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ zzdwn -> 0x0205 }
            r2.<init>(r6, r3, r0)     // Catch:{ zzdwn -> 0x0205 }
            throw r2     // Catch:{ zzdwn -> 0x0205 }
        L_0x01a4:
            java.net.URL r9 = new java.net.URL     // Catch:{ zzdwn -> 0x0205 }
            r9.<init>(r0)     // Catch:{ zzdwn -> 0x0205 }
            r0 = r9
        L_0x01aa:
            int r4 = r4 + r6
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzfa     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzbcl r10 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Object r9 = r10.zza(r9)     // Catch:{ zzdwn -> 0x0205 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ zzdwn -> 0x0205 }
            int r9 = r9.intValue()     // Catch:{ zzdwn -> 0x0205 }
            if (r4 > r9) goto L_0x01c2
            r12.disconnect()     // Catch:{ IOException -> 0x022c }
            goto L_0x0042
        L_0x01c2:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzdwn r0 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r6, r2)     // Catch:{ zzdwn -> 0x0205 }
            throw r0     // Catch:{ zzdwn -> 0x0205 }
        L_0x01cf:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzdwn r0 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r6, r2)     // Catch:{ zzdwn -> 0x0205 }
            throw r0     // Catch:{ zzdwn -> 0x0205 }
        L_0x01dc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ zzdwn -> 0x0205 }
            r2.<init>()     // Catch:{ zzdwn -> 0x0205 }
            r2.append(r3)     // Catch:{ zzdwn -> 0x0205 }
            r2.append(r0)     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r2 = r2.toString()     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)     // Catch:{ zzdwn -> 0x0205 }
            com.google.android.gms.internal.ads.zzdwn r2 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzdwn -> 0x0205 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzdwn -> 0x0205 }
            r4.<init>()     // Catch:{ zzdwn -> 0x0205 }
            r4.append(r3)     // Catch:{ zzdwn -> 0x0205 }
            r4.append(r0)     // Catch:{ zzdwn -> 0x0205 }
            java.lang.String r0 = r4.toString()     // Catch:{ zzdwn -> 0x0205 }
            r2.<init>(r6, r0)     // Catch:{ zzdwn -> 0x0205 }
            throw r2     // Catch:{ zzdwn -> 0x0205 }
        L_0x0203:
            r0 = move-exception
            goto L_0x0228
        L_0x0205:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzhW     // Catch:{ all -> 0x0203 }
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0203 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ all -> 0x0203 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0203 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0203 }
            if (r2 == 0) goto L_0x0227
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x0203 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0203 }
            long r2 = r2 - r23
            r7.zzd = r2     // Catch:{ all -> 0x0203 }
            goto L_0x015e
        L_0x0226:
            return r7
        L_0x0227:
            throw r0     // Catch:{ all -> 0x0203 }
        L_0x0228:
            r12.disconnect()     // Catch:{ IOException -> 0x022c }
            throw r0     // Catch:{ IOException -> 0x022c }
        L_0x022c:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)
            com.google.android.gms.internal.ads.zzdwn r3 = new com.google.android.gms.internal.ads.zzdwn
            r3.<init>(r6, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebu.zzc(java.lang.String, int, java.util.Map, byte[], java.lang.String, long):com.google.android.gms.internal.ads.zzebt");
    }
}
