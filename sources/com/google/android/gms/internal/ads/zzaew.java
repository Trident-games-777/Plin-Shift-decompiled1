package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaew implements zzacr {
    private final byte[] zza;
    private final zzed zzb;
    private final zzacx zzc;
    private zzacu zzd;
    private zzadx zze;
    private int zzf;
    private zzbd zzg;
    private zzadc zzh;
    private int zzi;
    private int zzj;
    private zzaev zzk;
    private int zzl;
    private long zzm;

    public zzaew() {
        throw null;
    }

    public zzaew(int i) {
        this.zza = new byte[42];
        this.zzb = new zzed(new byte[32768], 0);
        this.zzc = new zzacx();
        this.zzf = 0;
    }

    private final long zza(zzed zzed, boolean z) {
        boolean z2;
        this.zzh.getClass();
        int zzd2 = zzed.zzd();
        while (zzd2 <= zzed.zze() - 16) {
            zzed.zzL(zzd2);
            if (zzacy.zzc(zzed, this.zzh, this.zzj, this.zzc)) {
                zzed.zzL(zzd2);
                return this.zzc.zza;
            }
            zzd2++;
        }
        if (z) {
            while (zzd2 <= zzed.zze() - this.zzi) {
                zzed.zzL(zzd2);
                try {
                    z2 = zzacy.zzc(zzed, this.zzh, this.zzj, this.zzc);
                } catch (IndexOutOfBoundsException unused) {
                    z2 = false;
                }
                if (zzed.zzd() <= zzed.zze() && z2) {
                    zzed.zzL(zzd2);
                    return this.zzc.zza;
                }
                zzd2++;
            }
            zzed.zzL(zzed.zze());
            return -1;
        }
        zzed.zzL(zzd2);
        return -1;
    }

    private final void zzg() {
        long j = this.zzm * AnimationKt.MillisToNanos;
        zzadc zzadc = this.zzh;
        int i = zzen.zza;
        zzadc zzadc2 = zzadc;
        long j2 = j / ((long) zzadc.zze);
        zzadx zzadx = this.zze;
        zzadx zzadx2 = zzadx;
        zzadx.zzs(j2, 1, this.zzl, 0, (zzadw) null);
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzd = zzacu;
        this.zze = zzacu.zzw(0, 1);
        zzacu.zzD();
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzacz.zza(zzacs, false);
        zzed zzed = new zzed(4);
        ((zzacg) zzacs).zzm(zzed.zzN(), 0, 4, false);
        if (zzed.zzu() == 1716281667) {
            return true;
        }
        return false;
    }

    public final void zzf(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzaev zzaev = this.zzk;
            if (zzaev != null) {
                zzaev.zzd(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.zzm = j3;
        this.zzl = 0;
        this.zzb.zzI(0);
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        boolean zzp;
        zzadq zzadq;
        zzacs zzacs2 = zzacs;
        int i = this.zzf;
        boolean z = true;
        if (i == 0) {
            zzacs2.zzj();
            long zze2 = zzacs2.zze();
            zzbd zza2 = zzacz.zza(zzacs2, true);
            zzacs2.zzk((int) (zzacs2.zze() - zze2));
            this.zzg = zza2;
            this.zzf = 1;
            return 0;
        } else if (i == 1) {
            zzacs2.zzh(this.zza, 0, 42);
            zzacs2.zzj();
            this.zzf = 2;
            return 0;
        } else if (i == 2) {
            zzed zzed = new zzed(4);
            zzacs2.zzi(zzed.zzN(), 0, 4);
            if (zzed.zzu() == 1716281667) {
                this.zzf = 3;
                return 0;
            }
            throw zzbh.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i == 3) {
            zzadc zzadc = this.zzh;
            do {
                zzacs2.zzj();
                zzec zzec = new zzec(new byte[4], 4);
                zzacs2.zzh(zzec.zza, 0, 4);
                zzp = zzec.zzp();
                int zzd2 = zzec.zzd(7);
                int zzd3 = zzec.zzd(24) + 4;
                if (zzd2 == 0) {
                    byte[] bArr = new byte[38];
                    zzacs2.zzi(bArr, 0, 38);
                    zzadc = new zzadc(bArr, 4);
                } else if (zzadc == null) {
                    throw new IllegalArgumentException();
                } else if (zzd2 == 3) {
                    zzed zzed2 = new zzed(zzd3);
                    zzacs2.zzi(zzed2.zzN(), 0, zzd3);
                    zzadc = zzadc.zzf(zzacz.zzb(zzed2));
                } else if (zzd2 == 4) {
                    zzed zzed3 = new zzed(zzd3);
                    zzacs2.zzi(zzed3.zzN(), 0, zzd3);
                    zzed3.zzM(4);
                    zzadc = zzadc.zzg(Arrays.asList(zzaed.zzc(zzed3, false, false).zza));
                } else if (zzd2 == 6) {
                    zzed zzed4 = new zzed(zzd3);
                    zzacs2.zzi(zzed4.zzN(), 0, zzd3);
                    zzed4.zzM(4);
                    zzadc = zzadc.zze(zzfzo.zzo(zzafr.zzb(zzed4)));
                } else {
                    zzacs2.zzk(zzd3);
                }
                int i2 = zzen.zza;
                zzadc zzadc2 = zzadc;
                this.zzh = zzadc;
            } while (!zzp);
            zzadc.getClass();
            this.zzi = Math.max(zzadc.zzc, 6);
            zzadx zzadx = this.zze;
            zzadx zzadx2 = zzadx;
            zzadx.zzl(this.zzh.zzc(this.zza, this.zzg));
            this.zzf = 4;
            return 0;
        } else if (i != 4) {
            this.zze.getClass();
            zzadc zzadc3 = this.zzh;
            zzadc3.getClass();
            zzaev zzaev = this.zzk;
            if (zzaev != null && zzaev.zze()) {
                return zzaev.zza(zzacs2, zzadn);
            }
            if (this.zzm == -1) {
                this.zzm = zzacy.zzb(zzacs2, zzadc3);
                return 0;
            }
            zzed zzed5 = this.zzb;
            int zze3 = zzed5.zze();
            if (zze3 < 32768) {
                int zza3 = zzacs2.zza(zzed5.zzN(), zze3, 32768 - zze3);
                if (zza3 != -1) {
                    z = false;
                }
                if (!z) {
                    this.zzb.zzK(zze3 + zza3);
                } else if (this.zzb.zzb() == 0) {
                    zzg();
                    return -1;
                }
            } else {
                z = false;
            }
            zzed zzed6 = this.zzb;
            int zzd4 = zzed6.zzd();
            int i3 = this.zzl;
            int i4 = this.zzi;
            if (i3 < i4) {
                zzed6.zzM(Math.min(i4 - i3, zzed6.zzb()));
            }
            long zza4 = zza(this.zzb, z);
            zzed zzed7 = this.zzb;
            int zzd5 = zzed7.zzd() - zzd4;
            zzed7.zzL(zzd4);
            this.zze.zzq(this.zzb, zzd5);
            this.zzl += zzd5;
            if (zza4 != -1) {
                zzg();
                this.zzl = 0;
                this.zzm = zza4;
            }
            zzed zzed8 = this.zzb;
            if (zzed8.zzb() >= 16) {
                return 0;
            }
            int zzb2 = zzed8.zzb();
            System.arraycopy(zzed8.zzN(), zzed8.zzd(), zzed8.zzN(), 0, zzb2);
            this.zzb.zzL(0);
            this.zzb.zzK(zzb2);
            return 0;
        } else {
            zzacs2.zzj();
            zzed zzed9 = new zzed(2);
            zzacs2.zzh(zzed9.zzN(), 0, 2);
            int zzq = zzed9.zzq();
            if ((zzq >> 2) == 16382) {
                zzacs2.zzj();
                this.zzj = zzq;
                zzacu zzacu = this.zzd;
                int i5 = zzen.zza;
                zzacu zzacu2 = zzacu;
                long zzf2 = zzacs2.zzf();
                long zzd6 = zzacs2.zzd();
                zzadc zzadc4 = this.zzh;
                zzadc4.getClass();
                if (zzadc4.zzk != null) {
                    zzadq = new zzada(zzadc4, zzf2);
                } else if (zzd6 == -1 || zzadc4.zzj <= 0) {
                    zzadq = new zzadp(zzadc4.zza(), 0);
                } else {
                    zzaev zzaev2 = new zzaev(zzadc4, this.zzj, zzf2, zzd6);
                    this.zzk = zzaev2;
                    zzadq = zzaev2.zzb();
                }
                zzacu.zzO(zzadq);
                this.zzf = 5;
                return 0;
            }
            zzacs2.zzj();
            throw zzbh.zza("First frame does not start with sync code.", (Throwable) null);
        }
    }
}
