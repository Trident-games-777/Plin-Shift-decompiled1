package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaem {
    protected final zzadx zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private long[] zzl;
    private int[] zzm;

    public zzaem(int i, int i2, long j, int i3, zzadx zzadx) {
        i2 = i2 != 1 ? 2 : i2;
        this.zzd = j;
        this.zze = i3;
        this.zza = zzadx;
        this.zzb = zzh(i, i2 == 2 ? 1667497984 : 1651965952);
        this.zzc = i2 == 2 ? zzh(i, 1650720768) : -1;
        this.zzk = -1;
        this.zzl = new long[512];
        this.zzm = new int[512];
    }

    private static int zzh(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzi(int i) {
        return (this.zzd * ((long) i)) / ((long) this.zze);
    }

    private final zzadr zzj(int i) {
        return new zzadr(((long) this.zzm[i]) * zzi(1), this.zzl[i]);
    }

    public final zzado zza(long j) {
        if (this.zzj != 0) {
            int zzi2 = (int) (j / zzi(1));
            int zzc2 = zzen.zzc(this.zzm, zzi2, true, true);
            if (this.zzm[zzc2] == zzi2) {
                zzadr zzj2 = zzj(zzc2);
                return new zzado(zzj2, zzj2);
            }
            zzadr zzj3 = zzj(zzc2);
            int i = zzc2 + 1;
            if (i < this.zzl.length) {
                return new zzado(zzj3, zzj(i));
            }
            return new zzado(zzj3, zzj3);
        }
        zzadr zzadr = new zzadr(0, this.zzk);
        return new zzado(zzadr, zzadr);
    }

    public final void zzb(long j, boolean z) {
        if (this.zzk == -1) {
            this.zzk = j;
        }
        if (z) {
            if (this.zzj == this.zzm.length) {
                long[] jArr = this.zzl;
                this.zzl = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzm;
                this.zzm = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzl;
            int i = this.zzj;
            jArr2[i] = j;
            this.zzm[i] = this.zzi;
            this.zzj = i + 1;
        }
        this.zzi++;
    }

    public final void zzc() {
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
        this.zzm = Arrays.copyOf(this.zzm, this.zzj);
    }

    public final void zzd(int i) {
        this.zzf = i;
        this.zzg = i;
    }

    public final void zze(long j) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzm[zzen.zzd(this.zzl, j, true, true)];
    }

    public final boolean zzf(int i) {
        return this.zzb == i || this.zzc == i;
    }

    public final boolean zzg(zzacs zzacs) throws IOException {
        int i = this.zzg;
        int zzf2 = i - this.zza.zzf(zzacs, i, false);
        this.zzg = zzf2;
        boolean z = zzf2 == 0;
        if (z) {
            if (this.zzf > 0) {
                this.zza.zzs(zzi(this.zzh), Arrays.binarySearch(this.zzm, this.zzh) >= 0 ? 1 : 0, this.zzf, 0, (zzadw) null);
            }
            this.zzh++;
        }
        return z;
    }
}
