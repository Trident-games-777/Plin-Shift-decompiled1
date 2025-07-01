package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzahz implements zzahy {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahz(long[] jArr, long[] jArr2, long j, long j2, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
    }

    public static zzahz zzb(long j, long j2, zzadj zzadj, zzed zzed) {
        int i;
        long j3 = j;
        zzadj zzadj2 = zzadj;
        zzed zzed2 = zzed;
        zzed2.zzM(10);
        int zzg = zzed2.zzg();
        if (zzg <= 0) {
            return null;
        }
        int i2 = zzadj2.zzd;
        long zzu = zzen.zzu((long) zzg, ((long) (i2 >= 32000 ? 1152 : 576)) * AnimationKt.MillisToNanos, (long) i2, RoundingMode.FLOOR);
        int zzq = zzed2.zzq();
        int zzq2 = zzed2.zzq();
        int zzq3 = zzed2.zzq();
        zzed2.zzM(2);
        long j4 = j2 + ((long) zzadj2.zzc);
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i3 = 0;
        long j5 = j2;
        while (i3 < zzq) {
            long j6 = zzu;
            jArr[i3] = (((long) i3) * j6) / ((long) zzq);
            jArr2[i3] = Math.max(j5, j4);
            if (zzq3 == 1) {
                i = zzed.zzm();
            } else if (zzq3 == 2) {
                i = zzed.zzq();
            } else if (zzq3 == 3) {
                i = zzed.zzo();
            } else if (zzq3 != 4) {
                return null;
            } else {
                i = zzed.zzp();
            }
            j5 += ((long) i) * ((long) zzq2);
            i3++;
            zzed zzed3 = zzed;
            zzq = zzq;
            zzu = j6;
        }
        long j7 = zzu;
        if (!(j3 == -1 || j3 == j5)) {
            zzdt.zzf("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new zzahz(jArr, jArr2, j7, j5, zzadj2.zzf);
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final long zze(long j) {
        return this.zza[zzen.zzd(this.zzb, j, true, true)];
    }

    public final zzado zzg(long j) {
        long[] jArr = this.zza;
        int zzd2 = zzen.zzd(jArr, j, true, true);
        zzadr zzadr = new zzadr(jArr[zzd2], this.zzb[zzd2]);
        if (zzadr.zzb < j) {
            long[] jArr2 = this.zza;
            if (zzd2 != jArr2.length - 1) {
                int i = zzd2 + 1;
                return new zzado(zzadr, new zzadr(jArr2[i], this.zzb[i]));
            }
        }
        return new zzado(zzadr, zzadr);
    }

    public final boolean zzh() {
        return true;
    }
}
