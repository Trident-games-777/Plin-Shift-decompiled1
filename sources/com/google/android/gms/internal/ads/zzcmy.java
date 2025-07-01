package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcmy implements Runnable {
    public final /* synthetic */ zzcna zza;
    public final /* synthetic */ Throwable zzb;

    public /* synthetic */ zzcmy(zzcna zzcna, Throwable th) {
        this.zza = zzcna;
        this.zzb = th;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzjW)).booleanValue();
        zzcna zzcna = this.zza;
        Throwable th = this.zzb;
        if (booleanValue) {
            zzcnb zzcnb = zzcna.zzc;
            zzcnb.zzb = zzbuj.zzc(zzcnb.zzc);
            zzcna.zzc.zzb.zzh(th, "AttributionReporting.registerSourceAndPingClickUrl");
        } else {
            zzcnb zzcnb2 = zzcna.zzc;
            zzcnb2.zza = zzbuj.zza(zzcnb2.zzc);
            zzcna.zzc.zza.zzh(th, "AttributionReportingSampled.registerSourceAndPingClickUrl");
        }
        zzcna.zza.zzc(zzcna.zzb, (zzfkl) null);
    }
}
