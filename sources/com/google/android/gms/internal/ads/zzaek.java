package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaek implements zzaef {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaek(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaek zzb(zzed zzed) {
        int zzi = zzed.zzi();
        zzed.zzM(8);
        int zzi2 = zzed.zzi();
        int zzi3 = zzed.zzi();
        zzed.zzM(4);
        int zzi4 = zzed.zzi();
        zzed.zzM(12);
        return new zzaek(zzi, zzi2, zzi3, zzi4);
    }

    public final int zza() {
        return 1751742049;
    }
}
