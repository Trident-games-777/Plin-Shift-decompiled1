package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzanh implements zzacb {
    private final zzek zza;
    private final zzed zzb = new zzed();

    /* synthetic */ zzanh(zzek zzek, zzani zzani) {
        this.zza = zzek;
    }

    public final zzaca zza(zzacs zzacs, long j) throws IOException {
        int zzh;
        long zzf = zzacs.zzf();
        int min = (int) Math.min(20000, zzacs.zzd() - zzf);
        this.zzb.zzI(min);
        zzacs.zzh(this.zzb.zzN(), 0, min);
        int i = -1;
        long j2 = -9223372036854775807L;
        int i2 = -1;
        while (true) {
            zzed zzed = this.zzb;
            if (zzed.zzb() < 4) {
                return j2 != -9223372036854775807L ? zzaca.zzf(j2, zzf + ((long) i)) : zzaca.zza;
            }
            if (zzanj.zzh(zzed.zzN(), zzed.zzd()) != 442) {
                zzed.zzM(1);
            } else {
                zzed.zzM(4);
                long zzc = zzank.zzc(zzed);
                if (zzc != -9223372036854775807L) {
                    long zzb2 = this.zza.zzb(zzc);
                    if (zzb2 > j) {
                        return j2 == -9223372036854775807L ? zzaca.zzd(zzb2, zzf) : zzaca.zze(zzf + ((long) i2));
                    }
                    if (100000 + zzb2 > j) {
                        return zzaca.zze(zzf + ((long) zzed.zzd()));
                    }
                    i2 = zzed.zzd();
                    j2 = zzb2;
                }
                int zze = zzed.zze();
                if (zzed.zzb() >= 10) {
                    zzed.zzM(9);
                    int zzm = zzed.zzm() & 7;
                    if (zzed.zzb() >= zzm) {
                        zzed.zzM(zzm);
                        if (zzed.zzb() >= 4) {
                            if (zzanj.zzh(zzed.zzN(), zzed.zzd()) == 443) {
                                zzed.zzM(4);
                                int zzq = zzed.zzq();
                                if (zzed.zzb() < zzq) {
                                    zzed.zzL(zze);
                                } else {
                                    zzed.zzM(zzq);
                                }
                            }
                            while (true) {
                                if (zzed.zzb() < 4 || (zzh = zzanj.zzh(zzed.zzN(), zzed.zzd())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzed.zzM(4);
                                if (zzed.zzb() < 2) {
                                    zzed.zzL(zze);
                                    break;
                                }
                                zzed.zzL(Math.min(zzed.zze(), zzed.zzd() + zzed.zzq()));
                            }
                        } else {
                            zzed.zzL(zze);
                        }
                    } else {
                        zzed.zzL(zze);
                    }
                } else {
                    zzed.zzL(zze);
                }
                i = zzed.zzd();
            }
        }
    }

    public final void zzb() {
        byte[] bArr = zzen.zzf;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
