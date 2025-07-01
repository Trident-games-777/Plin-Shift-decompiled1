package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjn implements zzdto {
    private final Long zza;
    private final String zzb;
    private final zzciy zzc;
    private final zzcjp zzd;

    /* synthetic */ zzcjn(zzciy zzciy, zzcjp zzcjp, Long l, String str, zzckd zzckd) {
        this.zzc = zzciy;
        this.zzd = zzcjp;
        this.zza = l;
        this.zzb = str;
    }

    public final zzdty zza() {
        zzcjp zzcjp = this.zzd;
        return zzdtz.zza(this.zza.longValue(), zzcjp.zza, zzdts.zzc(zzcjp.zzb), this.zzc, this.zzb);
    }

    public final zzduc zzb() {
        zzcjp zzcjp = this.zzd;
        return zzdud.zza(this.zza.longValue(), zzcjp.zza, zzdts.zzc(zzcjp.zzb), this.zzc, this.zzb);
    }
}
