package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeuu implements zzevz {
    private final Context zza;
    private final zzges zzb;
    private final zzffo zzc;
    private final VersionInfoParcel zzd;

    zzeuu(Context context, zzges zzges, zzffo zzffo, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzges;
        this.zzc = zzffo;
        this.zzd = versionInfoParcel;
    }

    public final int zza() {
        return 53;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeut(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdf)).booleanValue() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        r1 = com.google.android.gms.internal.ads.zzftl.zzj(r0).zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdo)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ba, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzde)).booleanValue() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ce, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdg)).booleanValue() != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d0, code lost:
        r4 = com.google.android.gms.internal.ads.zzftm.zzi(r0);
        r0 = com.google.android.gms.internal.ads.zzfti.zza(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ec, code lost:
        if (r9.zzd.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdk)).intValue()) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ee, code lost:
        r2 = r4.zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdp)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
        r3 = r0.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        r6 = r0.zze();
        r4 = r2;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzdd)).booleanValue() == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeuv zzc() throws java.lang.Exception {
        /*
            r9 = this;
            android.content.Context r0 = r9.zza     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzffo r1 = r9.zzc     // Catch:{ IOException -> 0x0124 }
            boolean r7 = r1.zzb()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfth r1 = new com.google.android.gms.internal.ads.zzfth     // Catch:{ IOException -> 0x0124 }
            r1.<init>()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfth r2 = new com.google.android.gms.internal.ads.zzfth     // Catch:{ IOException -> 0x0124 }
            r2.<init>()     // Catch:{ IOException -> 0x0124 }
            r3 = 1
            if (r7 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdh     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzeuv r0 = new com.google.android.gms.internal.ads.zzeuv     // Catch:{ IOException -> 0x0124 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0124 }
            return r0
        L_0x002d:
            if (r7 != 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdd     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x0055
        L_0x0041:
            if (r7 == 0) goto L_0x0079
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdf     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x0079
        L_0x0055:
            com.google.android.gms.internal.ads.zzftl r1 = com.google.android.gms.internal.ads.zzftl.zzj(r0)     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdo     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IOException -> 0x0124 }
            long r4 = r4.longValue()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbzz r6 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.zzg r6 = r6.zzi()     // Catch:{ IOException -> 0x0124 }
            boolean r6 = r6.zzN()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfth r1 = r1.zzh(r4, r6)     // Catch:{ IOException -> 0x0124 }
        L_0x0079:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdl     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x00a8
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r9.zzd     // Catch:{ IOException -> 0x0124 }
            int r4 = r4.clientJarVersion     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbce r5 = com.google.android.gms.internal.ads.zzbcn.zzdk     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r6 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ IOException -> 0x0124 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0124 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 >= r5) goto L_0x00a8
            com.google.android.gms.internal.ads.zzftm r4 = com.google.android.gms.internal.ads.zzftm.zzi(r0)     // Catch:{ IOException -> 0x0124 }
            r4.zzj()     // Catch:{ IOException -> 0x0124 }
        L_0x00a8:
            if (r7 != 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzde     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x00d0
        L_0x00bc:
            if (r7 == 0) goto L_0x011a
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzdg     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x011a
        L_0x00d0:
            com.google.android.gms.internal.ads.zzftm r4 = com.google.android.gms.internal.ads.zzftm.zzi(r0)     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfti r0 = com.google.android.gms.internal.ads.zzfti.zza(r0)     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r9.zzd     // Catch:{ IOException -> 0x0124 }
            int r5 = r5.clientJarVersion     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzdk     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r6 = r8.zza(r6)     // Catch:{ IOException -> 0x0124 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ IOException -> 0x0124 }
            int r6 = r6.intValue()     // Catch:{ IOException -> 0x0124 }
            if (r5 < r6) goto L_0x0112
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzdp     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ IOException -> 0x0124 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0124 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbzz r5 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.zzg r5 = r5.zzi()     // Catch:{ IOException -> 0x0124 }
            boolean r5 = r5.zzN()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfth r2 = r4.zzh(r2, r5)     // Catch:{ IOException -> 0x0124 }
            boolean r3 = r0.zzd()     // Catch:{ IOException -> 0x0124 }
        L_0x0112:
            boolean r0 = r0.zze()     // Catch:{ IOException -> 0x0124 }
            r6 = r0
            r4 = r2
            r5 = r3
            goto L_0x011d
        L_0x011a:
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x011d:
            com.google.android.gms.internal.ads.zzeuv r2 = new com.google.android.gms.internal.ads.zzeuv     // Catch:{ IOException -> 0x0124 }
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0124 }
            return r2
        L_0x0124:
            r0 = move-exception
            java.lang.String r1 = "PerAppIdSignal"
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()
            r2.zzw(r0, r1)
            com.google.android.gms.internal.ads.zzffo r0 = r9.zzc
            com.google.android.gms.internal.ads.zzeuv r1 = new com.google.android.gms.internal.ads.zzeuv
            boolean r0 = r0.zzb()
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuu.zzc():com.google.android.gms.internal.ads.zzeuv");
    }
}
