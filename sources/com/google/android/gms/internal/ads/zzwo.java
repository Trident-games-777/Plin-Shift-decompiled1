package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzwo implements zzup, zzuo {
    private final zzup zza;
    private final long zzb;
    private zzuo zzc;

    public zzwo(zzup zzup, long j) {
        this.zza = zzup;
        this.zzb = j;
    }

    public final long zza(long j, zzls zzls) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzls) + j2;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    public final long zzf(zzyd[] zzydArr, boolean[] zArr, zzwg[] zzwgArr, boolean[] zArr2, long j) {
        zzwg[] zzwgArr2 = new zzwg[zzwgArr.length];
        int i = 0;
        while (true) {
            zzwg zzwg = null;
            if (i >= zzwgArr.length) {
                break;
            }
            zzwn zzwn = zzwgArr[i];
            if (zzwn != null) {
                zzwg = zzwn.zzc();
            }
            zzwgArr2[i] = zzwg;
            i++;
        }
        long zzf = this.zza.zzf(zzydArr, zArr, zzwgArr2, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzwgArr.length; i2++) {
            zzwg zzwg2 = zzwgArr2[i2];
            if (zzwg2 == null) {
                zzwgArr[i2] = null;
            } else {
                zzwn zzwn2 = zzwgArr[i2];
                if (zzwn2 == null || zzwn2.zzc() != zzwg2) {
                    zzwgArr[i2] = new zzwn(zzwg2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzwi zzwi) {
        zzup zzup = (zzup) zzwi;
        zzuo zzuo = this.zzc;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzg(this);
    }

    public final zzwr zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzuo zzuo, long j) {
        this.zzc = zzuo;
        this.zza.zzl(this, j - this.zzb);
    }

    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzup zzn() {
        return this.zza;
    }

    public final boolean zzo(zzko zzko) {
        long j = zzko.zza;
        long j2 = this.zzb;
        zzkm zza2 = zzko.zza();
        zza2.zze(j - j2);
        return this.zza.zzo(zza2.zzg());
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final void zzi(zzup zzup) {
        zzuo zzuo = this.zzc;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzi(this);
    }
}
