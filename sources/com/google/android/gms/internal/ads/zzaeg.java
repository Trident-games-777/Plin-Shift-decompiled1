package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaeg implements zzadq {
    final /* synthetic */ zzaej zza;
    private final long zzb;

    public zzaeg(zzaej zzaej, long j) {
        this.zza = zzaej;
        this.zzb = j;
    }

    public final long zza() {
        return this.zzb;
    }

    public final zzado zzg(long j) {
        zzado zza2 = this.zza.zzi[0].zza(j);
        int i = 1;
        while (true) {
            zzaej zzaej = this.zza;
            if (i >= zzaej.zzi.length) {
                return zza2;
            }
            zzado zza3 = zzaej.zzi[i].zza(j);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
