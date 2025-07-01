package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzank {
    private final zzek zza = new zzek(0);
    private final zzed zzb = new zzed();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzank() {
    }

    public static long zzc(zzed zzed) {
        zzed zzed2 = zzed;
        int zzd2 = zzed2.zzd();
        if (zzed2.zzb() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzed2.zzH(bArr, 0, 9);
        zzed2.zzL(zzd2);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = (long) b;
        long j2 = (long) bArr[1];
        long j3 = (long) b2;
        long j4 = (j2 & 255) << 20;
        long j5 = (j3 & 3) << 13;
        long j6 = j5 | j4 | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (((248 & j3) >> 3) << 15);
        return j6 | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzacs zzacs) {
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzacs.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << Ascii.DLE) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzacs zzacs, zzadn zzadn) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzacs.zzd();
            int min = (int) Math.min(20000, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzacs.zzf() != j2) {
                zzadn.zza = j2;
                return 1;
            }
            this.zzb.zzI(min);
            zzacs.zzj();
            zzacs.zzh(this.zzb.zzN(), 0, min);
            zzed zzed = this.zzb;
            int zzd3 = zzed.zzd();
            int zze2 = zzed.zze() - 4;
            while (true) {
                if (zze2 < zzd3) {
                    break;
                }
                if (zzg(zzed.zzN(), zze2) == 442) {
                    zzed.zzL(zze2 + 4);
                    long zzc2 = zzc(zzed);
                    if (zzc2 != -9223372036854775807L) {
                        j = zzc2;
                        break;
                    }
                }
                zze2--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zzf(zzacs);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zzacs.zzd());
            if (zzacs.zzf() != 0) {
                zzadn.zza = 0;
                return 1;
            }
            this.zzb.zzI(min2);
            zzacs.zzj();
            zzacs.zzh(this.zzb.zzN(), 0, min2);
            zzed zzed2 = this.zzb;
            int zzd4 = zzed2.zzd();
            int zze3 = zzed2.zze();
            while (true) {
                if (zzd4 >= zze3 - 3) {
                    break;
                }
                if (zzg(zzed2.zzN(), zzd4) == 442) {
                    zzed2.zzL(zzd4 + 4);
                    long zzc3 = zzc(zzed2);
                    if (zzc3 != -9223372036854775807L) {
                        j = zzc3;
                        break;
                    }
                }
                zzd4++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zzf(zzacs);
                return 0;
            }
            zzek zzek = this.zza;
            this.zzh = zzek.zzc(this.zzg) - zzek.zzb(j3);
            zzf(zzacs);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzek zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
