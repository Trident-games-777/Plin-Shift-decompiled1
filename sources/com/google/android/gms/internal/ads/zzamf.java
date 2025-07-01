package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamf implements zzacr {
    private final zzamg zza = new zzamg((String) null, 0);
    private final zzed zzb = new zzed(16384);
    private boolean zzc;

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        int zza2 = zzacs.zza(this.zzb.zzN(), 0, 16384);
        if (zza2 == -1) {
            return -1;
        }
        this.zzb.zzL(0);
        this.zzb.zzK(zza2);
        if (!this.zzc) {
            this.zza.zzd(0, 4);
            this.zzc = true;
        }
        this.zza.zza(this.zzb);
        return 0;
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zza.zzb(zzacu, new zzaoa(Integer.MIN_VALUE, 0, 1));
        zzacu.zzD();
        zzacu.zzO(new zzadp(-9223372036854775807L, 0));
    }

    public final void zzf(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzacg zzacg;
        int i;
        zzed zzed = new zzed(10);
        int i2 = 0;
        while (true) {
            zzacg = (zzacg) zzacs;
            zzacg.zzm(zzed.zzN(), 0, 10, false);
            zzed.zzL(0);
            if (zzed.zzo() != 4801587) {
                break;
            }
            zzed.zzM(3);
            int zzl = zzed.zzl();
            i2 += zzl + 10;
            zzacg.zzl(zzl, false);
        }
        zzacs.zzj();
        zzacg.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzacg.zzm(zzed.zzN(), 0, 7, false);
            zzed.zzL(0);
            int zzq = zzed.zzq();
            if (zzq == 44096 || zzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzN = zzed.zzN();
                int i6 = zzabu.zza;
                if (zzN.length < 7) {
                    i = -1;
                } else {
                    byte b = ((zzN[2] & 255) << 8) | (zzN[3] & 255);
                    if (b == 65535) {
                        b = ((zzN[4] & 255) << Ascii.DLE) | ((zzN[5] & 255) << 8) | (zzN[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (zzq == 44097) {
                        i5 += 2;
                    }
                    i = b + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzacg.zzl(i - 7, false);
            } else {
                zzacs.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzacg.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
