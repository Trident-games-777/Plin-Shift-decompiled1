package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadc {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzadb zzk;
    private final zzbd zzl;

    private zzadc(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzadb zzadb, zzbd zzbd) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzi(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzh(i7);
        this.zzj = j;
        this.zzk = zzadb;
        this.zzl = zzbd;
    }

    public zzadc(byte[] bArr, int i) {
        zzec zzec = new zzec(bArr, bArr.length);
        zzec.zzl(i * 8);
        this.zza = zzec.zzd(16);
        this.zzb = zzec.zzd(16);
        this.zzc = zzec.zzd(24);
        this.zzd = zzec.zzd(24);
        int zzd2 = zzec.zzd(20);
        this.zze = zzd2;
        this.zzf = zzi(zzd2);
        this.zzg = zzec.zzd(3) + 1;
        int zzd3 = zzec.zzd(5) + 1;
        this.zzh = zzd3;
        this.zzi = zzh(zzd3);
        this.zzj = zzec.zze(36);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * AnimationKt.MillisToNanos) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return Math.max(0, Math.min((j * ((long) this.zze)) / AnimationKt.MillisToNanos, this.zzj - 1));
    }

    public final zzad zzc(byte[] bArr, zzbd zzbd) {
        bArr[4] = Byte.MIN_VALUE;
        zzbd zzd2 = zzd(zzbd);
        zzab zzab = new zzab();
        zzab.zzZ("audio/flac");
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzab.zzQ(i);
        zzab.zzz(this.zzg);
        zzab.zzaa(this.zze);
        zzab.zzT(zzen.zzn(this.zzh));
        zzab.zzM(Collections.singletonList(bArr));
        zzab.zzS(zzd2);
        return zzab.zzaf();
    }

    public final zzbd zzd(zzbd zzbd) {
        zzbd zzbd2 = this.zzl;
        return zzbd2 == null ? zzbd : zzbd2.zzd(zzbd);
    }

    public final zzadc zze(List list) {
        return new zzadc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbd(list)));
    }

    public final zzadc zzf(zzadb zzadb) {
        return new zzadc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzadb, this.zzl);
    }

    public final zzadc zzg(List list) {
        return new zzadc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzaed.zzb(list)));
    }
}
