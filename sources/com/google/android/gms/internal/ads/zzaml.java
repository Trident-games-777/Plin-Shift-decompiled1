package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaml implements zzamm {
    private final List zza;
    private final zzadx[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzaml(List list) {
        this.zza = list;
        this.zzb = new zzadx[list.size()];
    }

    private final boolean zzf(zzed zzed, int i) {
        if (zzed.zzb() == 0) {
            return false;
        }
        if (zzed.zzm() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzed zzed) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzed, 32)) {
            if (this.zzd != 1 || zzf(zzed, 0)) {
                int zzd2 = zzed.zzd();
                int zzb2 = zzed.zzb();
                zzadx[] zzadxArr = this.zzb;
                for (zzadx zzq : zzadxArr) {
                    zzed.zzL(zzd2);
                    zzq.zzq(zzed, zzb2);
                }
                this.zze += zzb2;
            }
        }
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzanx zzanx = (zzanx) this.zza.get(i);
            zzaoa.zzc();
            zzadx zzw = zzacu.zzw(zzaoa.zza(), 3);
            zzab zzab = new zzab();
            zzab.zzL(zzaoa.zzb());
            zzab.zzZ("application/dvbsubs");
            zzab.zzM(Collections.singletonList(zzanx.zzb));
            zzab.zzP(zzanx.zza);
            zzw.zzl(zzab.zzaf());
            this.zzb[i] = zzw;
        }
    }

    public final void zzc(boolean z) {
        if (this.zzc) {
            zzdb.zzf(this.zzf != -9223372036854775807L);
            zzadx[] zzadxArr = this.zzb;
            for (zzadx zzs : zzadxArr) {
                zzs.zzs(this.zzf, 1, this.zze, 0, (zzadw) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzf = j;
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
