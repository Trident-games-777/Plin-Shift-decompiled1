package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamg implements zzamm {
    private final zzec zza;
    private final zzed zzb;
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadx zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private zzad zzk;
    private int zzl;
    private long zzm;

    public zzamg() {
        throw null;
    }

    public zzamg(String str, int i) {
        zzec zzec = new zzec(new byte[16], 16);
        this.zza = zzec;
        this.zzb = new zzed(zzec.zza);
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zza(zzed zzed) {
        int zzm2;
        byte b;
        zzdb.zzb(this.zzf);
        while (zzed.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                while (true) {
                    if (zzed.zzb() <= 0) {
                        break;
                    } else if (!this.zzi) {
                        this.zzi = zzed.zzm() == 172;
                    } else {
                        zzm2 = zzed.zzm();
                        this.zzi = zzm2 == 172;
                        b = SignedBytes.MAX_POWER_OF_TWO;
                        if (zzm2 == 64) {
                            break;
                        } else if (zzm2 == 65) {
                            zzm2 = 65;
                            break;
                        }
                    }
                }
                this.zzg = 1;
                zzed zzed2 = this.zzb;
                zzed2.zzN()[0] = -84;
                if (zzm2 == 65) {
                    b = 65;
                }
                zzed2.zzN()[1] = b;
                this.zzh = 2;
            } else if (i != 1) {
                int min = Math.min(zzed.zzb(), this.zzl - this.zzh);
                this.zzf.zzq(zzed, min);
                int i2 = this.zzh + min;
                this.zzh = i2;
                if (i2 == this.zzl) {
                    if (this.zzm == -9223372036854775807L) {
                        z = false;
                    }
                    zzdb.zzf(z);
                    this.zzf.zzs(this.zzm, 1, this.zzl, 0, (zzadw) null);
                    this.zzm += this.zzj;
                    this.zzg = 0;
                }
            } else {
                byte[] zzN = this.zzb.zzN();
                int min2 = Math.min(zzed.zzb(), 16 - this.zzh);
                zzed.zzH(zzN, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 16) {
                    this.zza.zzl(0);
                    zzabs zza2 = zzabu.zza(this.zza);
                    zzad zzad = this.zzk;
                    if (zzad == null || zzad.zzC != 2 || zza2.zza != zzad.zzD || !"audio/ac4".equals(zzad.zzo)) {
                        zzab zzab = new zzab();
                        zzab.zzL(this.zze);
                        zzab.zzZ("audio/ac4");
                        zzab.zzz(2);
                        zzab.zzaa(zza2.zza);
                        zzab.zzP(this.zzc);
                        zzab.zzX(this.zzd);
                        zzad zzaf = zzab.zzaf();
                        this.zzk = zzaf;
                        this.zzf.zzl(zzaf);
                    }
                    this.zzl = zza2.zzb;
                    this.zzj = (((long) zza2.zzc) * AnimationKt.MillisToNanos) / ((long) this.zzk.zzD);
                    this.zzb.zzL(0);
                    this.zzf.zzq(this.zzb, 16);
                    this.zzg = 2;
                }
            }
        }
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zze = zzaoa.zzb();
        this.zzf = zzacu.zzw(zzaoa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
    }
}
