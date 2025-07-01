package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajm implements zzajr {
    private final zzadc zza;
    private final zzadb zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzajm(zzadc zzadc, zzadb zzadb) {
        this.zza = zzadc;
        this.zzb = zzadb;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final long zzd(zzacs zzacs) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final zzadq zze() {
        zzdb.zzf(this.zzc != -1);
        return new zzada(this.zza, this.zzc);
    }

    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzen.zzd(jArr, j, true, true)];
    }
}
