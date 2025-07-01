package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzuy implements Runnable {
    public final /* synthetic */ zzva zza;
    public final /* synthetic */ zzvb zzb;
    public final /* synthetic */ zzui zzc;
    public final /* synthetic */ zzun zzd;

    public /* synthetic */ zzuy(zzva zzva, zzvb zzvb, zzui zzui, zzun zzun) {
        this.zza = zzva;
        this.zzb = zzvb;
        this.zzc = zzui;
        this.zzd = zzun;
    }

    public final void run() {
        this.zzb.zzag(0, this.zza.zzb, this.zzc, this.zzd);
    }
}
