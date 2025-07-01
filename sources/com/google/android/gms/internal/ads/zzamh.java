package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamh implements zzacr {
    private final zzami zza;
    private final zzed zzb;
    private final zzed zzc;
    private final zzec zzd;
    private zzacu zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzamh() {
        throw null;
    }

    public zzamh(int i) {
        this.zza = new zzami(true, (String) null, 0);
        this.zzb = new zzed(2048);
        this.zzg = -1;
        zzed zzed = new zzed(10);
        this.zzc = zzed;
        byte[] zzN = zzed.zzN();
        this.zzd = new zzec(zzN, zzN.length);
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        zzdb.zzb(this.zze);
        int zza2 = zzacs.zza(this.zzb.zzN(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzO(new zzadp(-9223372036854775807L, 0));
            this.zzi = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzb.zzL(0);
        this.zzb.zzK(zza2);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
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
        this.zze = zzacu;
        this.zza.zzb(zzacu, new zzaoa(Integer.MIN_VALUE, 0, 1));
        zzacu.zzD();
    }

    public final void zzf(long j, long j2) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j2;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzacg zzacg;
        int i = 0;
        while (true) {
            zzacg = (zzacg) zzacs;
            zzacg.zzm(this.zzc.zzN(), 0, 10, false);
            this.zzc.zzL(0);
            if (this.zzc.zzo() != 4801587) {
                break;
            }
            this.zzc.zzM(3);
            int zzl = this.zzc.zzl();
            i += zzl + 10;
            zzacg.zzl(zzl, false);
        }
        zzacs.zzj();
        zzacg.zzl(i, false);
        if (this.zzg == -1) {
            this.zzg = (long) i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzacg.zzm(this.zzc.zzN(), 0, 2, false);
            this.zzc.zzL(0);
            if (!zzami.zzf(this.zzc.zzq())) {
                i4++;
                zzacs.zzj();
                zzacg.zzl(i4, false);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzacg.zzm(this.zzc.zzN(), 0, 4, false);
                this.zzd.zzl(14);
                int zzd2 = this.zzd.zzd(13);
                if (zzd2 <= 6) {
                    i4++;
                    zzacs.zzj();
                    zzacg.zzl(i4, false);
                } else {
                    zzacg.zzl(zzd2 - 6, false);
                    i3 += zzd2;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }
}
