package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdny {
    private final zzcwk zza;
    private final zzcxt zzb;
    private final zzcyg zzc;
    private final zzcys zzd;
    private final zzdbi zze;
    private final zzfet zzf;
    private final zzfew zzg;
    private final zzcnb zzh;

    public zzdny(zzcwk zzcwk, zzcxt zzcxt, zzcyg zzcyg, zzcys zzcys, zzdbi zzdbi, zzfet zzfet, zzfew zzfew, zzcnb zzcnb) {
        this.zza = zzcwk;
        this.zzb = zzcxt;
        this.zzc = zzcyg;
        this.zzd = zzcys;
        this.zze = zzdbi;
        this.zzf = zzfet;
        this.zzg = zzfew;
        this.zzh = zzcnb;
    }

    public final void zza(zzdoc zzdoc) {
        zzcxt zzcxt = this.zzb;
        zzdnp zzb2 = zzdoc.zza;
        Objects.requireNonNull(zzcxt);
        zzb2.zzh(this.zza, this.zzc, this.zzd, this.zze, new zzdnx(zzcxt));
        zzdoc.zzh(this.zzf, this.zzg, this.zzh);
    }
}
