package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzano implements zzaob {
    private final zzann zza;
    private final zzed zzb = new zzed(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzano(zzann zzann) {
        this.zza = zzann;
    }

    public final void zza(zzed zzed, int i) {
        int i2 = i & 1;
        int zzd2 = i2 != 0 ? zzed.zzd() + zzed.zzm() : -1;
        if (this.zzf) {
            if (i2 != 0) {
                this.zzf = false;
                zzed.zzL(zzd2);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzed.zzb() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int zzm = zzed.zzm();
                    zzed.zzL(zzed.zzd() - 1);
                    if (zzm == 255) {
                    }
                }
                int min = Math.min(zzed.zzb(), 3 - this.zzd);
                zzed.zzH(this.zzb.zzN(), this.zzd, min);
                int i4 = this.zzd + min;
                this.zzd = i4;
                if (i4 == 3) {
                    this.zzb.zzL(0);
                    this.zzb.zzK(3);
                    this.zzb.zzM(1);
                    zzed zzed2 = this.zzb;
                    int zzm2 = zzed2.zzm();
                    boolean z = (zzm2 & 128) != 0;
                    int zzm3 = zzed2.zzm();
                    this.zze = z;
                    this.zzc = (zzm3 | ((zzm2 & 15) << 8)) + 3;
                    int zzc2 = this.zzb.zzc();
                    int i5 = this.zzc;
                    if (zzc2 < i5) {
                        int zzc3 = this.zzb.zzc();
                        this.zzb.zzF(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, zzc3 + zzc3)));
                    }
                }
            } else {
                int min2 = Math.min(zzed.zzb(), this.zzc - i3);
                zzed.zzH(this.zzb.zzN(), this.zzd, min2);
                int i6 = this.zzd + min2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzK(i7);
                    } else if (zzen.zzf(this.zzb.zzN(), 0, i7, -1) == 0) {
                        this.zzb.zzK(this.zzc - 4);
                    }
                    this.zzb.zzL(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
            this.zzf = true;
            return;
        }
    }

    public final void zzb(zzek zzek, zzacu zzacu, zzaoa zzaoa) {
        this.zza.zzb(zzek, zzacu, zzaoa);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
