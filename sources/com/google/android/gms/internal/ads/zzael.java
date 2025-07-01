package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzael implements zzaef {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzael(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
    }

    public static zzael zzb(zzed zzed) {
        int zzi = zzed.zzi();
        zzed.zzM(12);
        int zzi2 = zzed.zzi();
        int zzi3 = zzed.zzi();
        int zzi4 = zzed.zzi();
        zzed.zzM(4);
        int zzi5 = zzed.zzi();
        int zzi6 = zzed.zzi();
        zzed.zzM(8);
        return new zzael(zzi, zzi2, zzi3, zzi4, zzi5, zzi6);
    }

    public final int zza() {
        return 1752331379;
    }
}
