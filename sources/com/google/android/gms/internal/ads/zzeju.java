package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeju implements zzfwh {
    public final /* synthetic */ zzcfk zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ zzdos zzc;

    public /* synthetic */ zzeju(zzejy zzejy, zzcfk zzcfk, zzfet zzfet, zzdos zzdos) {
        this.zza = zzcfk;
        this.zzb = zzfet;
        this.zzc = zzdos;
    }

    public final Object apply(Object obj) {
        zzcfk zzcfk = this.zza;
        if (this.zzb.zzM) {
            zzcfk.zzah();
        }
        zzdos zzdos = this.zzc;
        zzcfk.zzab();
        zzcfk.onPause();
        return zzdos.zzi();
    }
}
