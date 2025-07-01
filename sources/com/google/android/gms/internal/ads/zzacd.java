package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacd {
    public static void zza(long j, zzed zzed, zzadx[] zzadxArr) {
        int i;
        while (true) {
            boolean z = true;
            if (zzed.zzb() > 1) {
                int zzc = zzc(zzed);
                int zzc2 = zzc(zzed);
                int zzd = zzed.zzd() + zzc2;
                if (zzc2 == -1 || zzc2 > zzed.zzb()) {
                    zzdt.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzd = zzed.zze();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzm = zzed.zzm();
                    int zzq = zzed.zzq();
                    if (zzq == 49) {
                        i = zzed.zzg();
                        zzq = 49;
                    } else {
                        i = 0;
                    }
                    int zzm2 = zzed.zzm();
                    if (zzq == 47) {
                        zzed.zzM(1);
                        zzq = 47;
                    }
                    boolean z2 = zzm == 181 && (zzq == 49 || zzq == 47) && zzm2 == 3;
                    if (zzq == 49) {
                        if (i != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        zzb(j, zzed, zzadxArr);
                    }
                }
                zzed.zzL(zzd);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j, zzed zzed, zzadx[] zzadxArr) {
        zzed zzed2 = zzed;
        zzadx[] zzadxArr2 = zzadxArr;
        int zzm = zzed2.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzed2.zzM(1);
            int zzd = zzed2.zzd();
            for (zzadx zzadx : zzadxArr2) {
                int i2 = i * 3;
                zzed2.zzL(zzd);
                zzadx.zzq(zzed2, i2);
                zzdb.zzf(j != -9223372036854775807L);
                zzadx.zzs(j, 1, i2, 0, (zzadw) null);
            }
        }
    }

    private static int zzc(zzed zzed) {
        int i = 0;
        while (zzed.zzb() != 0) {
            int zzm = zzed.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
