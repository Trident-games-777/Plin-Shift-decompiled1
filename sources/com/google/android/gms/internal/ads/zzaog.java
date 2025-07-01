package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaog implements zzaof {
    private final zzacu zza;
    private final zzadx zzb;
    private final zzaoi zzc;
    private final zzad zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaog(zzacu zzacu, zzadx zzadx, zzaoi zzaoi, String str, int i) throws zzbh {
        this.zza = zzacu;
        this.zzb = zzadx;
        this.zzc = zzaoi;
        int i2 = zzaoi.zzb * zzaoi.zze;
        int i3 = zzaoi.zzd;
        int i4 = i2 / 8;
        if (i3 == i4) {
            int i5 = zzaoi.zzc * i4;
            int i6 = i5 * 8;
            int max = Math.max(i4, i5 / 10);
            this.zze = max;
            zzab zzab = new zzab();
            zzab.zzZ(str);
            zzab.zzy(i6);
            zzab.zzU(i6);
            zzab.zzQ(max);
            zzab.zzz(zzaoi.zzb);
            zzab.zzaa(zzaoi.zzc);
            zzab.zzT(i);
            this.zzd = zzab.zzaf();
            return;
        }
        throw zzbh.zza("Expected block size: " + i4 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzO(new zzaol(this.zzc, 1, (long) i, j));
        this.zzb.zzl(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzacs zzacs, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                zzaoi zzaoi = this.zzc;
                int i4 = this.zzg;
                int i5 = zzaoi.zzd;
                int i6 = i4 / i5;
            } else {
                int zzf2 = this.zzb.zzf(zzacs, (int) Math.min((long) (i3 - i2), j2), true);
                if (zzf2 == -1) {
                    j2 = 0;
                } else {
                    this.zzg += zzf2;
                    j2 -= (long) zzf2;
                }
            }
        }
        zzaoi zzaoi2 = this.zzc;
        int i42 = this.zzg;
        int i52 = zzaoi2.zzd;
        int i62 = i42 / i52;
        if (i62 > 0) {
            int i7 = i62 * i52;
            int i8 = this.zzg - i7;
            this.zzb.zzs(this.zzf + zzen.zzu(this.zzh, AnimationKt.MillisToNanos, (long) zzaoi2.zzc, RoundingMode.FLOOR), 1, i7, i8, (zzadw) null);
            this.zzh += (long) i62;
            this.zzg = i8;
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }
}
