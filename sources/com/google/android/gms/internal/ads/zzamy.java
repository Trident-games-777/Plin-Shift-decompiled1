package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamy implements zzamm {
    private final zzed zza;
    private final zzadj zzb;
    private final String zzc;
    private final int zzd;
    private zzadx zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;

    public zzamy() {
        throw null;
    }

    public zzamy(String str, int i) {
        this.zzg = 0;
        zzed zzed = new zzed(4);
        this.zza = zzed;
        zzed.zzN()[0] = -1;
        this.zzb = new zzadj();
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zza(zzed zzed) {
        zzdb.zzb(this.zze);
        while (zzed.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                byte[] zzN = zzed.zzN();
                int zzd2 = zzed.zzd();
                int zze2 = zzed.zze();
                while (true) {
                    if (zzd2 >= zze2) {
                        zzed.zzL(zze2);
                        break;
                    }
                    int i2 = zzd2 + 1;
                    byte b = zzN[zzd2];
                    boolean z2 = (b & 255) == 255;
                    boolean z3 = this.zzj && (b & 224) == 224;
                    this.zzj = z2;
                    if (z3) {
                        zzed.zzL(i2);
                        this.zzj = false;
                        this.zza.zzN()[1] = zzN[zzd2];
                        this.zzh = 2;
                        this.zzg = 1;
                        break;
                    }
                    zzd2 = i2;
                }
            } else if (i != 1) {
                int min = Math.min(zzed.zzb(), this.zzl - this.zzh);
                this.zze.zzq(zzed, min);
                int i3 = this.zzh + min;
                this.zzh = i3;
                if (i3 >= this.zzl) {
                    if (this.zzm == -9223372036854775807L) {
                        z = false;
                    }
                    zzdb.zzf(z);
                    this.zze.zzs(this.zzm, 1, this.zzl, 0, (zzadw) null);
                    this.zzm += this.zzk;
                    this.zzh = 0;
                    this.zzg = 0;
                }
            } else {
                int min2 = Math.min(zzed.zzb(), 4 - this.zzh);
                zzed.zzH(this.zza.zzN(), this.zzh, min2);
                int i4 = this.zzh + min2;
                this.zzh = i4;
                if (i4 >= 4) {
                    this.zza.zzL(0);
                    if (!this.zzb.zza(this.zza.zzg())) {
                        this.zzh = 0;
                        this.zzg = 1;
                    } else {
                        zzadj zzadj = this.zzb;
                        this.zzl = zzadj.zzc;
                        if (!this.zzi) {
                            this.zzk = (((long) zzadj.zzg) * AnimationKt.MillisToNanos) / ((long) zzadj.zzd);
                            zzab zzab = new zzab();
                            zzab.zzL(this.zzf);
                            zzab.zzZ(this.zzb.zzb);
                            zzab.zzQ(4096);
                            zzab.zzz(this.zzb.zze);
                            zzab.zzaa(this.zzb.zzd);
                            zzab.zzP(this.zzc);
                            zzab.zzX(this.zzd);
                            this.zze.zzl(zzab.zzaf());
                            this.zzi = true;
                        }
                        this.zza.zzL(0);
                        this.zze.zzq(this.zza, 4);
                        this.zzg = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zzf = zzaoa.zzb();
        this.zze = zzacu.zzw(zzaoa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
    }
}
