package com.google.android.gms.ads.nonagon.signalgeneration;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzg implements Runnable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzg(zzj zzj, boolean z, boolean z2) {
        this.zza = zzj;
        this.zzb = z;
        this.zzc = z2;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
