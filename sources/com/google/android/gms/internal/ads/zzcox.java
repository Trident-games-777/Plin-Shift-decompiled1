package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcox extends zzcrq {
    private final zzcfk zzc;
    private final int zzd;
    private final Context zze;
    private final zzcol zzf;
    private final zzdgv zzg;
    private final zzddp zzh;
    private final zzcwz zzi;
    private final boolean zzj;
    private final zzcad zzk;
    private boolean zzl = false;

    zzcox(zzcrp zzcrp, Context context, zzcfk zzcfk, int i, zzcol zzcol, zzdgv zzdgv, zzddp zzddp, zzcwz zzcwz, zzcad zzcad) {
        super(zzcrp);
        this.zzc = zzcfk;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcol;
        this.zzg = zzdgv;
        this.zzh = zzddp;
        this.zzi = zzcwz;
        this.zzj = ((Boolean) zzbe.zzc().zza(zzbcn.zzfp)).booleanValue();
        this.zzk = zzcad;
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzb() {
        super.zzb();
        zzcfk zzcfk = this.zzc;
        if (zzcfk != null) {
            zzcfk.destroy();
        }
    }

    public final void zzc(zzazz zzazz) {
        zzcfk zzcfk = this.zzc;
        if (zzcfk != null) {
            zzcfk.zzak(zzazz);
        }
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r3, com.google.android.gms.internal.ads.zzbam r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            boolean r4 = r2.zzj
            if (r4 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzddp r4 = r2.zzh
            r4.zzb()
        L_0x000d:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzaJ
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.zzv.zzq()
            boolean r4 = com.google.android.gms.ads.internal.util.zzs.zzG(r3)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzcwz r4 = r2.zzi
            r4.zzb()
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzaK
            com.google.android.gms.internal.ads.zzbcl r5 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzfqa r4 = new com.google.android.gms.internal.ads.zzfqa
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbs r5 = com.google.android.gms.ads.internal.zzv.zzu()
            android.os.Looper r5 = r5.zzb()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzfff r3 = r2.zza
            com.google.android.gms.internal.ads.zzffe r3 = r3.zzb
            com.google.android.gms.internal.ads.zzfew r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x0061:
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzlC
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzcfk r4 = r2.zzc
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzfet r4 = r4.zzD()
            if (r4 == 0) goto L_0x00a0
            boolean r1 = r4.zzar
            if (r1 == 0) goto L_0x00a0
            int r4 = r4.zzas
            com.google.android.gms.internal.ads.zzcad r1 = r2.zzk
            int r1 = r1.zzb()
            if (r4 != r1) goto L_0x008d
            goto L_0x00a0
        L_0x008d:
            java.lang.String r3 = "The app open consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)
            com.google.android.gms.internal.ads.zzcwz r3 = r2.zzi
            r4 = 12
            java.lang.String r5 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r4 = com.google.android.gms.internal.ads.zzfgq.zzd(r4, r5, r0)
            r3.zza(r4)
            return
        L_0x00a0:
            boolean r4 = r2.zzl
            if (r4 == 0) goto L_0x00b4
            java.lang.String r4 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzcwz r4 = r2.zzi
            r1 = 10
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgq.zzd(r1, r0, r0)
            r4.zza(r0)
        L_0x00b4:
            boolean r4 = r2.zzl
            if (r4 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzdgv r4 = r2.zzg     // Catch:{ zzdgu -> 0x00cc }
            com.google.android.gms.internal.ads.zzcwz r0 = r2.zzi     // Catch:{ zzdgu -> 0x00cc }
            r4.zza(r5, r3, r0)     // Catch:{ zzdgu -> 0x00cc }
            boolean r3 = r2.zzj     // Catch:{ zzdgu -> 0x00cc }
            if (r3 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzddp r3 = r2.zzh     // Catch:{ zzdgu -> 0x00cc }
            r3.zza()     // Catch:{ zzdgu -> 0x00cc }
        L_0x00c8:
            r3 = 1
            r2.zzl = r3
            return
        L_0x00cc:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzcwz r4 = r2.zzi
            r4.zzc(r3)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcox.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzbam, boolean):void");
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
