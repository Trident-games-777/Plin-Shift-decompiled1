package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzxw {
    public final int zza;
    public final zzbw zzb;
    public final int zzc;
    public final zzad zzd;

    public zzxw(int i, zzbw zzbw, int i2) {
        this.zza = i;
        this.zzb = zzbw;
        this.zzc = i2;
        this.zzd = zzbw.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzxw zzxw);
}
