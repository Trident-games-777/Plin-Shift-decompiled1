package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaia {
    public final zzadj zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaia(zzadj zzadj, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzadj(zzadj);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaia zzb(zzadj zzadj, zzed zzed) {
        long[] jArr;
        int i;
        int i2;
        int zzg = zzed.zzg();
        int zzp = (zzg & 1) != 0 ? zzed.zzp() : -1;
        long zzu = (zzg & 2) != 0 ? zzed.zzu() : -1;
        if ((zzg & 4) == 4) {
            jArr = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr[i3] = (long) zzed.zzm();
            }
        } else {
            jArr = null;
        }
        long[] jArr2 = jArr;
        if ((zzg & 8) != 0) {
            zzed.zzM(4);
        }
        if (zzed.zzb() >= 24) {
            zzed.zzM(21);
            int zzo = zzed.zzo();
            i = zzo & 4095;
            i2 = zzo >> 12;
        } else {
            i2 = -1;
            i = -1;
        }
        return new zzaia(zzadj, (long) zzp, zzu, jArr2, i2, i);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        zzadj zzadj = this.zza;
        return zzen.zzt((j * ((long) zzadj.zzg)) - 1, zzadj.zzd);
    }
}
