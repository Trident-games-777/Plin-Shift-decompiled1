package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvd implements zzyd {
    private final zzyd zza;
    private final zzbw zzb;

    public zzvd(zzyd zzyd, zzbw zzbw) {
        this.zza = zzyd;
        this.zzb = zzbw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvd)) {
            return false;
        }
        zzvd zzvd = (zzvd) obj;
        return this.zza.equals(zzvd.zza) && this.zzb.equals(zzvd.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzad zzd(int i) {
        return this.zzb.zzb(this.zza.zza(i));
    }

    public final zzbw zze() {
        return this.zzb;
    }
}
