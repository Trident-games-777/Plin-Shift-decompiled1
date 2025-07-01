package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.google.common.base.Ascii;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzame implements zzamm {
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

    public zzame() {
        throw null;
    }

    public zzame(String str, int i) {
        zzec zzec = new zzec(new byte[128], 128);
        this.zza = zzec;
        this.zzb = new zzed(zzec.zza);
        this.zzg = 0;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zza(zzed zzed) {
        zzdb.zzb(this.zzf);
        while (zzed.zzb() > 0) {
            int i = this.zzg;
            boolean z = true;
            if (i == 0) {
                while (true) {
                    if (zzed.zzb() <= 0) {
                        break;
                    } else if (!this.zzi) {
                        this.zzi = zzed.zzm() == 11;
                    } else {
                        int zzm2 = zzed.zzm();
                        if (zzm2 == 119) {
                            this.zzi = false;
                            this.zzg = 1;
                            zzed zzed2 = this.zzb;
                            zzed2.zzN()[0] = Ascii.VT;
                            zzed2.zzN()[1] = 119;
                            this.zzh = 2;
                            break;
                        }
                        this.zzi = zzm2 == 11;
                    }
                }
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
                int min2 = Math.min(zzed.zzb(), 128 - this.zzh);
                zzed.zzH(zzN, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 128) {
                    this.zza.zzl(0);
                    zzabp zze2 = zzabr.zze(this.zza);
                    zzad zzad = this.zzk;
                    if (zzad == null || zze2.zzc != zzad.zzC || zze2.zzb != zzad.zzD || !Objects.equals(zze2.zza, zzad.zzo)) {
                        zzab zzab = new zzab();
                        zzab.zzL(this.zze);
                        zzab.zzZ(zze2.zza);
                        zzab.zzz(zze2.zzc);
                        zzab.zzaa(zze2.zzb);
                        zzab.zzP(this.zzc);
                        zzab.zzX(this.zzd);
                        zzab.zzU(zze2.zzf);
                        if ("audio/ac3".equals(zze2.zza)) {
                            zzab.zzy(zze2.zzf);
                        }
                        zzad zzaf = zzab.zzaf();
                        this.zzk = zzaf;
                        this.zzf.zzl(zzaf);
                    }
                    this.zzl = zze2.zzd;
                    this.zzj = (((long) zze2.zze) * AnimationKt.MillisToNanos) / ((long) this.zzk.zzD);
                    this.zzb.zzL(0);
                    this.zzf.zzq(this.zzb, 128);
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
