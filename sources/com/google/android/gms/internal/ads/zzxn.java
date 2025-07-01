package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzxn implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxn(zzad zzad, int i) {
        this.zza = 1 != (zzad.zze & 1) ? false : true;
        this.zzb = zzlo.zza(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzxn zzxn) {
        return zzfzd.zzj().zzd(this.zzb, zzxn.zzb).zzd(this.zza, zzxn.zza).zza();
    }
}
