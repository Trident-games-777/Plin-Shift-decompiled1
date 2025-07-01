package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzads implements zzacr {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzacu zzf;
    private zzadx zzg;

    public zzads(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        int i = this.zze;
        if (i == 1) {
            zzadx zzadx = this.zzg;
            zzadx.getClass();
            zzadx zzadx2 = zzadx;
            int zzf2 = zzadx.zzf(zzacs, 1024, true);
            if (zzf2 == -1) {
                this.zze = 2;
                this.zzg.zzs(0, 1, this.zzd, 0, (zzadw) null);
                this.zzd = 0;
            } else {
                this.zzd += zzf2;
            }
            return 0;
        } else if (i == 2) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzf = zzacu;
        zzadx zzw = zzacu.zzw(1024, 4);
        this.zzg = zzw;
        zzab zzab = new zzab();
        zzab.zzZ(this.zzc);
        zzw.zzl(zzab.zzaf());
        this.zzf.zzD();
        this.zzf.zzO(new zzadt(-9223372036854775807L));
        this.zze = 1;
    }

    public final void zzf(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzdb.zzf((this.zza == -1 || this.zzb == -1) ? false : true);
        zzed zzed = new zzed(this.zzb);
        ((zzacg) zzacs).zzm(zzed.zzN(), 0, this.zzb, false);
        return zzed.zzq() == this.zza;
    }
}
