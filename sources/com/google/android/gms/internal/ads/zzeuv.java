package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuv implements zzevy {
    private zzfth zza;
    private zzfth zzb;
    private boolean zzc;
    private boolean zzd;
    private final boolean zze = false;
    private final boolean zzf;

    public zzeuv(zzfth zzfth, zzfth zzfth2, boolean z, boolean z2, boolean z3) {
        this.zza = zzfth;
        this.zzb = zzfth2;
        this.zzc = z;
        this.zzd = z2;
        this.zzf = z3;
    }

    public zzeuv(boolean z) {
        this.zzf = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r5.zza.zzc() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r1.putString("paidv1_id_android", r5.zza.zza());
        r1.putLong("paidv1_creation_time_android", r5.zza.zzb().toEpochMilli());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzde)).booleanValue() == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdg)).booleanValue() != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
        if (r5.zzb.zzc() == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        r1.putString("paidv2_id_android", r5.zzb.zza());
        r1.putLong("paidv2_creation_time_android", r5.zzb.zzb().toEpochMilli());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00aa, code lost:
        r1.putBoolean("paidv2_pub_option_android", r5.zzc);
        r1.putBoolean("paidv2_user_option_android", r5.zzd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdd)).booleanValue() == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdf)).booleanValue() != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzj(java.lang.Object r6) {
        /*
            r5 = this;
            android.os.Bundle r6 = (android.os.Bundle) r6
            boolean r0 = r5.zze
            if (r0 == 0) goto L_0x0008
            goto L_0x00c1
        L_0x0008:
            java.lang.String r0 = "pii"
            android.os.Bundle r1 = com.google.android.gms.internal.ads.zzfgc.zza(r6, r0)
            boolean r2 = r5.zzf
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzdd
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x003a
        L_0x0024:
            boolean r2 = r5.zzf
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzdf
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x005c
        L_0x003a:
            com.google.android.gms.internal.ads.zzfth r2 = r5.zza
            boolean r2 = r2.zzc()
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzfth r2 = r5.zza
            java.lang.String r2 = r2.zza()
            java.lang.String r3 = "paidv1_id_android"
            r1.putString(r3, r2)
            com.google.android.gms.internal.ads.zzfth r2 = r5.zza
            java.time.Instant r2 = r2.zzb()
            long r2 = r2.toEpochMilli()
            java.lang.String r4 = "paidv1_creation_time_android"
            r1.putLong(r4, r2)
        L_0x005c:
            boolean r2 = r5.zzf
            if (r2 != 0) goto L_0x0072
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzde
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0088
        L_0x0072:
            boolean r2 = r5.zzf
            if (r2 == 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzdg
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b8
        L_0x0088:
            com.google.android.gms.internal.ads.zzfth r2 = r5.zzb
            boolean r2 = r2.zzc()
            if (r2 == 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzfth r2 = r5.zzb
            java.lang.String r2 = r2.zza()
            java.lang.String r3 = "paidv2_id_android"
            r1.putString(r3, r2)
            com.google.android.gms.internal.ads.zzfth r2 = r5.zzb
            java.time.Instant r2 = r2.zzb()
            long r2 = r2.toEpochMilli()
            java.lang.String r4 = "paidv2_creation_time_android"
            r1.putLong(r4, r2)
        L_0x00aa:
            boolean r2 = r5.zzc
            java.lang.String r3 = "paidv2_pub_option_android"
            r1.putBoolean(r3, r2)
            boolean r2 = r5.zzd
            java.lang.String r3 = "paidv2_user_option_android"
            r1.putBoolean(r3, r2)
        L_0x00b8:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x00c1
            r6.putBundle(r0, r1)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuv.zzj(java.lang.Object):void");
    }
}
