package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzant {
    private final zzek zza = new zzek(0);
    private final zzed zzb = new zzed();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzant(int i) {
    }

    private final int zze(zzacs zzacs) {
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzacs.zzj();
        return 0;
    }

    public final int zza(zzacs zzacs, zzadn zzadn, int i) throws IOException {
        if (i <= 0) {
            zze(zzacs);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzacs.zzd();
            int min = (int) Math.min(112800, zzd2);
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
            int zze2 = zzed.zze();
            int i2 = zze2 - 188;
            while (true) {
                if (i2 < zzd3) {
                    break;
                }
                byte[] zzN = zzed.zzN();
                int i3 = -4;
                int i4 = 0;
                while (true) {
                    if (i3 > 4) {
                        break;
                    }
                    int i5 = (i3 * 188) + i2;
                    if (i5 < zzd3 || i5 >= zze2 || zzN[i5] != 71) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == 5) {
                            long zzb2 = zzaoc.zzb(zzed, i2, i);
                            if (zzb2 != -9223372036854775807L) {
                                j = zzb2;
                                break;
                            }
                        }
                    }
                    i3++;
                }
                i2--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zze(zzacs);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzacs.zzd());
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
                if (zzd4 >= zze3) {
                    break;
                }
                if (zzed2.zzN()[zzd4] == 71) {
                    long zzb3 = zzaoc.zzb(zzed2, zzd4, i);
                    if (zzb3 != -9223372036854775807L) {
                        j = zzb3;
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
                zze(zzacs);
                return 0;
            }
            zzek zzek = this.zza;
            this.zzh = zzek.zzc(this.zzg) - zzek.zzb(j3);
            zze(zzacs);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzek zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
