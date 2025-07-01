package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfuv implements Runnable {
    public final /* synthetic */ zzfvd zza;
    public final /* synthetic */ zzfvk zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ zzfvi zzd;

    public /* synthetic */ zzfuv(zzfvd zzfvd, zzfvk zzfvk, int i, zzfvi zzfvi) {
        this.zza = zzfvd;
        this.zzb = zzfvk;
        this.zzc = i;
        this.zzd = zzfvi;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd);
    }
}
