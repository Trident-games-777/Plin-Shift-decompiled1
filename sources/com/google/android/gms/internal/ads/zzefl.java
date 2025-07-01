package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzefl implements zzfwh {
    public final /* synthetic */ zzcfk zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ zzcoo zzc;

    public /* synthetic */ zzefl(zzefm zzefm, zzcfk zzcfk, zzfet zzfet, zzcoo zzcoo) {
        this.zza = zzcfk;
        this.zzb = zzfet;
        this.zzc = zzcoo;
    }

    public final Object apply(Object obj) {
        zzcfk zzcfk = this.zza;
        if (this.zzb.zzM) {
            zzcfk.zzah();
        }
        zzcoo zzcoo = this.zzc;
        zzcfk.zzab();
        zzcfk.onPause();
        return zzcoo.zza();
    }
}
