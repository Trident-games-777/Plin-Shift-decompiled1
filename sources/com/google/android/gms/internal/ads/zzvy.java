package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvy implements zzym {
    public long zza;
    public long zzb;
    public zzyl zzc;
    public zzvy zzd;

    public zzvy(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzvy zzb() {
        this.zzc = null;
        zzvy zzvy = this.zzd;
        this.zzd = null;
        return zzvy;
    }

    public final zzym zzd() {
        zzvy zzvy = this.zzd;
        if (zzvy == null || zzvy.zzc == null) {
            return null;
        }
        return zzvy;
    }

    public final void zze(long j, int i) {
        zzdb.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }

    public final zzyl zzc() {
        zzyl zzyl = this.zzc;
        zzyl.getClass();
        zzyl zzyl2 = zzyl;
        return zzyl;
    }
}
