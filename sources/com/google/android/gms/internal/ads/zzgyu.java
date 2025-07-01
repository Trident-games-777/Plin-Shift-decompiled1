package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgyu implements zzgyl {
    final int zza;
    final zzhca zzb;
    final boolean zzc;
    final boolean zzd;

    zzgyu(zzgzc zzgzc, int i, zzhca zzhca, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzhca;
        this.zzc = z;
        this.zzd = z2;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzgyu) obj).zza;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzhca zzb() {
        return this.zzb;
    }

    public final zzhcb zzc() {
        return this.zzb.zza();
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
