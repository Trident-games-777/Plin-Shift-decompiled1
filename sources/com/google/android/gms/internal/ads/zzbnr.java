package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbnr implements Runnable {
    public final /* synthetic */ zzbns zza;
    public final /* synthetic */ zzbmp zzb;

    public /* synthetic */ zzbnr(zzbns zzbns, zzbmp zzbmp) {
        this.zza = zzbns;
        this.zzb = zzbmp;
    }

    public final void run() {
        zzbmp zzbmp = this.zzb;
        zzbmp zzbmp2 = zzbmp;
        zzbmp.zzr("/result", zzbjq.zzo);
        zzbmp.zzc();
    }
}
