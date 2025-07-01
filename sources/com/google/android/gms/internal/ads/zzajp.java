package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajp {
    private final zzajq zza = new zzajq();
    private final zzed zzb = new zzed(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzajp() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzajq zzajq = this.zza;
            if (i5 >= zzajq.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzajq.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzed zza() {
        return this.zzb;
    }

    public final zzajq zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzI(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzed zzed = this.zzb;
        if (zzed.zzN().length != 65025) {
            zzed.zzJ(Arrays.copyOf(zzed.zzN(), Math.max(65025, zzed.zze())), this.zzb.zze());
        }
    }

    public final boolean zze(zzacs zzacs) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzI(0);
        }
        while (true) {
            boolean z = true;
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzacs, -1) || !this.zza.zzb(zzacs, true)) {
                    return false;
                }
                zzajq zzajq = this.zza;
                int i2 = zzajq.zzd;
                if ((zzajq.zza & 1) == 1 && this.zzb.zze() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzacv.zze(zzacs, i2)) {
                    return false;
                }
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzed zzed = this.zzb;
                zzed.zzF(zzed.zze() + zzf);
                zzed zzed2 = this.zzb;
                if (!zzacv.zzd(zzacs, zzed2.zzN(), zzed2.zze(), zzf)) {
                    return false;
                }
                zzed zzed3 = this.zzb;
                zzed3.zzK(zzed3.zze() + zzf);
                if (this.zza.zzf[i3 - 1] == 255) {
                    z = false;
                }
                this.zze = z;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
        return false;
    }
}
