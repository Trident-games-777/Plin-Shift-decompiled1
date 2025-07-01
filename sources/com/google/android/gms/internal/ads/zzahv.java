package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzahv implements zzahy {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzahv(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzen.zzs(jArr2[jArr2.length - 1]) : j;
    }

    public static zzahv zzb(long j, zzagq zzagq, long j2) {
        int length = zzagq.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzagq.zzb + zzagq.zzd[i3]);
            j3 += (long) (zzagq.zzc + zzagq.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzahv(jArr, jArr2, j2);
    }

    private static Pair zzf(long j, long[] jArr, long[] jArr2) {
        int zzd = zzen.zzd(jArr, j, true, true);
        long j2 = jArr[zzd];
        long j3 = jArr2[zzd];
        int i = zzd + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (((double) j) - ((double) j2)) / ((double) (j4 - j2))) * ((double) (jArr2[i] - j3)))) + j3));
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return -2147483647;
    }

    public final long zzd() {
        return -1;
    }

    public final long zze(long j) {
        return zzen.zzs(((Long) zzf(j, this.zza, this.zzb).second).longValue());
    }

    public final zzado zzg(long j) {
        Pair zzf = zzf(zzen.zzv(Math.max(0, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzadr zzadr = new zzadr(zzen.zzs(((Long) zzf.first).longValue()), ((Long) zzf.second).longValue());
        return new zzado(zzadr, zzadr);
    }

    public final boolean zzh() {
        return true;
    }
}
