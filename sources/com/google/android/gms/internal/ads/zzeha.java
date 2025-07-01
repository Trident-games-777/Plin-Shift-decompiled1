package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeha implements zzfwh {
    public final /* synthetic */ zzcfk zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ zzdfk zzc;

    public /* synthetic */ zzeha(zzehe zzehe, zzcfk zzcfk, zzfet zzfet, zzdfk zzdfk) {
        this.zza = zzcfk;
        this.zzb = zzfet;
        this.zzc = zzdfk;
    }

    public final Object apply(Object obj) {
        zzcfk zzcfk = this.zza;
        if (this.zzb.zzM) {
            zzcfk.zzah();
        }
        zzdfk zzdfk = this.zzc;
        zzcfk.zzab();
        zzcfk.onPause();
        return zzdfk.zzg();
    }
}
