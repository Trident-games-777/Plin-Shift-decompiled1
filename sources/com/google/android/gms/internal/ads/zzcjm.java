package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjm implements zzdtn {
    private final zzciy zza;
    private final zzcjp zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcjm(zzciy zzciy, zzcjp zzcjp, zzckd zzckd) {
        this.zza = zzciy;
        this.zzb = zzcjp;
    }

    public final /* bridge */ /* synthetic */ zzdtn zzb(long j) {
        Long valueOf = Long.valueOf(j);
        Long l = valueOf;
        this.zzc = valueOf;
        return this;
    }

    public final zzdto zzc() {
        zzhgf.zzc(this.zzc, Long.class);
        zzhgf.zzc(this.zzd, String.class);
        return new zzcjn(this.zza, this.zzb, this.zzc, this.zzd, (zzckd) null);
    }

    public final /* bridge */ /* synthetic */ zzdtn zza(String str) {
        str.getClass();
        String str2 = str;
        this.zzd = str;
        return this;
    }
}
