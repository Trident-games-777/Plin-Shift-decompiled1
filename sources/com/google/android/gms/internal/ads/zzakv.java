package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzakv {
    private final zzed zza = new zzed();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzakv zzakv, zzed zzed, int i) {
        int zzo;
        if (i >= 4) {
            zzed.zzM(3);
            int i2 = i - 4;
            if ((zzed.zzm() & 128) != 0) {
                if (i2 >= 7 && (zzo = zzed.zzo()) >= 4) {
                    zzakv.zzh = zzed.zzq();
                    zzakv.zzi = zzed.zzq();
                    zzakv.zza.zzI(zzo - 4);
                    i2 = i - 11;
                } else {
                    return;
                }
            }
            zzed zzed2 = zzakv.zza;
            int zzd2 = zzed2.zzd();
            int zze2 = zzed2.zze();
            if (zzd2 < zze2 && i2 > 0) {
                int min = Math.min(i2, zze2 - zzd2);
                zzed.zzH(zzed2.zzN(), zzd2, min);
                zzakv.zza.zzL(zzd2 + min);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzc(zzakv zzakv, zzed zzed, int i) {
        if (i >= 19) {
            zzakv.zzd = zzed.zzq();
            zzakv.zze = zzed.zzq();
            zzed.zzM(11);
            zzakv.zzf = zzed.zzq();
            zzakv.zzg = zzed.zzq();
        }
    }

    static /* bridge */ /* synthetic */ void zzd(zzakv zzakv, zzed zzed, int i) {
        zzakv zzakv2 = zzakv;
        if (i % 5 == 2) {
            zzed zzed2 = zzed;
            zzed2.zzM(2);
            int i2 = 0;
            Arrays.fill(zzakv2.zzb, 0);
            int i3 = i / 5;
            int i4 = 0;
            while (i4 < i3) {
                int zzm = zzed2.zzm();
                int zzm2 = zzed2.zzm();
                int zzm3 = zzed2.zzm();
                int zzm4 = zzed2.zzm();
                double d = (double) zzm2;
                double d2 = (double) (zzm3 - 128);
                double d3 = (double) (zzm4 - 128);
                zzakv2.zzb[zzm] = Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)) | (zzed2.zzm() << 24) | (Math.max(i2, Math.min((int) ((1.402d * d2) + d), 255)) << 16) | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8);
                i4++;
                i2 = 0;
            }
            zzakv2.zzc = true;
        }
    }

    public final zzct zza() {
        int i;
        int i2;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzed zzed = this.zza;
        if (zzed.zze() == 0 || zzed.zzd() != zzed.zze() || !this.zzc) {
            return null;
        }
        zzed.zzL(0);
        int i3 = this.zzh * this.zzi;
        int[] iArr = new int[i3];
        int i4 = 0;
        while (i4 < i3) {
            int zzm = this.zza.zzm();
            if (zzm != 0) {
                i2 = i4 + 1;
                iArr[i4] = this.zzb[zzm];
            } else {
                int zzm2 = this.zza.zzm();
                if (zzm2 != 0) {
                    int i5 = zzm2 & 63;
                    if ((zzm2 & 64) != 0) {
                        i5 = (i5 << 8) | this.zza.zzm();
                    }
                    if ((zzm2 & 128) == 0) {
                        i = this.zzb[0];
                    } else {
                        i = this.zzb[this.zza.zzm()];
                    }
                    i2 = i5 + i4;
                    Arrays.fill(iArr, i4, i2, i);
                }
            }
            i4 = i2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcr zzcr = new zzcr();
        zzcr.zzc(createBitmap);
        zzcr.zzh(((float) this.zzf) / ((float) this.zzd));
        zzcr.zzi(0);
        zzcr.zze(((float) this.zzg) / ((float) this.zze), 0);
        zzcr.zzf(0);
        zzcr.zzk(((float) this.zzh) / ((float) this.zzd));
        zzcr.zzd(((float) this.zzi) / ((float) this.zze));
        return zzcr.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzI(0);
        this.zzc = false;
    }
}
