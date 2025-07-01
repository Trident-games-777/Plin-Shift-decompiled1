package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxh implements zzhfx {
    private final zzhgp zza;

    public zzdxh(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zzb() {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzhgp r0 = r4.zza
            com.google.android.gms.internal.ads.zzcwd r0 = (com.google.android.gms.internal.ads.zzcwd) r0
            com.google.android.gms.internal.ads.zzffo r0 = r0.zza()
            r1 = r0
            com.google.android.gms.internal.ads.zzffo r1 = (com.google.android.gms.internal.ads.zzffo) r1
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzgW
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0054
            com.google.android.gms.ads.internal.client.zzm r1 = r0.zzd
            java.lang.String r1 = r1.zzx
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "request_id"
            if (r2 != 0) goto L_0x0039
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0039 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0039 }
            java.lang.String r1 = r2.getString(r3)     // Catch:{ JSONException -> 0x0039 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0039 }
            if (r2 != 0) goto L_0x0039
            goto L_0x0064
        L_0x0039:
            com.google.android.gms.ads.internal.client.zzm r1 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r1 = r1.zzs
            if (r1 == 0) goto L_0x0054
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0054 }
            com.google.android.gms.ads.internal.client.zzm r0 = r0.zzd     // Catch:{ JSONException -> 0x0054 }
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs     // Catch:{ JSONException -> 0x0054 }
            java.lang.String r0 = r0.zza     // Catch:{ JSONException -> 0x0054 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0054 }
            java.lang.String r1 = r1.getString(r3)     // Catch:{ JSONException -> 0x0054 }
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0054 }
            if (r0 == 0) goto L_0x0064
        L_0x0054:
            java.util.Random r0 = com.google.android.gms.ads.internal.client.zzbc.zze()
            int r0 = r0.nextInt()
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0 = r0 & r1
            java.lang.String r1 = java.lang.String.valueOf(r0)
        L_0x0064:
            com.google.android.gms.internal.ads.zzhgf.zzb(r1)
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxh.zzb():java.lang.Object");
    }
}
