package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamd implements zzacr {
    private final zzame zza = new zzame((String) null, 0);
    private final zzed zzb = new zzed(2786);
    private boolean zzc;

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        int zza2 = zzacs.zza(this.zzb.zzN(), 0, 2786);
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
        zzed zzed = new zzed(10);
        int i = 0;
        while (true) {
            zzacg = (zzacg) zzacs;
            zzacg.zzm(zzed.zzN(), 0, 10, false);
            zzed.zzL(0);
            if (zzed.zzo() != 4801587) {
                break;
            }
            zzed.zzM(3);
            int zzl = zzed.zzl();
            i += zzl + 10;
            zzacg.zzl(zzl, false);
        }
        zzacs.zzj();
        zzacg.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzacg.zzm(zzed.zzN(), 0, 6, false);
            zzed.zzL(0);
            if (zzed.zzq() != 2935) {
                zzacs.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzacg.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int zzb2 = zzabr.zzb(zzed.zzN());
                if (zzb2 == -1) {
                    return false;
                }
                zzacg.zzl(zzb2 - 6, false);
            }
        }
    }
}
