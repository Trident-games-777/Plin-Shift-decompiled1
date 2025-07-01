package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaik implements zzaig {
    private final zzed zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaik(zzet zzet) {
        zzed zzed = zzet.zza;
        this.zza = zzed;
        zzed.zzL(12);
        this.zzc = zzed.zzp() & 255;
        this.zzb = zzed.zzp();
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzm();
        }
        if (i == 16) {
            return this.zza.zzq();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzm = this.zza.zzm();
        this.zze = zzm;
        return (zzm & 240) >> 4;
    }
}
