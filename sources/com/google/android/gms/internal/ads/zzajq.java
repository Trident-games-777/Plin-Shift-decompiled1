package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajq {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzed zzg = new zzed(255);

    zzajq() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzacs zzacs, boolean z) throws IOException {
        zza();
        this.zzg.zzI(27);
        if (zzacv.zzc(zzacs, this.zzg.zzN(), 0, 27, z) && this.zzg.zzu() == 1332176723) {
            if (this.zzg.zzm() == 0) {
                this.zza = this.zzg.zzm();
                this.zzb = this.zzg.zzr();
                this.zzg.zzs();
                this.zzg.zzs();
                this.zzg.zzs();
                int zzm = this.zzg.zzm();
                this.zzc = zzm;
                this.zzd = zzm + 27;
                this.zzg.zzI(zzm);
                if (zzacv.zzc(zzacs, this.zzg.zzN(), 0, this.zzc, z)) {
                    for (int i = 0; i < this.zzc; i++) {
                        this.zzf[i] = this.zzg.zzm();
                        this.zze += this.zzf[i];
                    }
                    return true;
                }
            } else if (z) {
                return false;
            } else {
                throw zzbh.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzacs zzacs, long j) throws IOException {
        int i;
        zzdb.zzd(zzacs.zzf() == zzacs.zze());
        this.zzg.zzI(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || zzacs.zzf() + 4 < j) && zzacv.zzc(zzacs, this.zzg.zzN(), 0, 4, true)) {
                this.zzg.zzL(0);
                if (this.zzg.zzu() == 1332176723) {
                    zzacs.zzj();
                    return true;
                }
                zzacs.zzk(1);
            }
        }
        do {
            if ((i != 0 && zzacs.zzf() >= j) || zzacs.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzacs.zzc(1) == -1);
        return false;
    }
}
