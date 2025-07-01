package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfuy implements Runnable {
    public final /* synthetic */ zzfvd zza;
    public final /* synthetic */ zzfvf zzb;
    public final /* synthetic */ zzfvi zzc;

    public /* synthetic */ zzfuy(zzfvd zzfvd, zzfvf zzfvf, zzfvi zzfvi) {
        this.zza = zzfvd;
        this.zzb = zzfvf;
        this.zzc = zzfvi;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
