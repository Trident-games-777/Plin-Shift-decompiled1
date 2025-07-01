package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadj {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzadj() {
    }

    public zzadj(zzadj zzadj) {
        this.zza = zzadj.zza;
        this.zzb = zzadj.zzb;
        this.zzc = zzadj.zzc;
        this.zzd = zzadj.zzd;
        this.zze = zzadj.zze;
        this.zzf = zzadj.zzf;
        this.zzg = zzadj.zzg;
    }

    public final boolean zza(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!zzadk.zzm(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        int i8 = i4 - 1;
        this.zza = i2;
        this.zzb = zzadk.zza[3 - i3];
        int i9 = zzadk.zzb[i5];
        this.zzd = i9;
        int i10 = 2;
        if (i2 == 2) {
            i9 /= 2;
            this.zzd = i9;
        } else if (i2 == 0) {
            i9 /= 4;
            this.zzd = i9;
        }
        int i11 = (i >>> 9) & 1;
        this.zzg = zzadk.zzl(i2, i3);
        if (i3 == 3) {
            if (i2 == 3) {
                i7 = zzadk.zzc[i8];
            } else {
                i7 = zzadk.zzd[i8];
            }
            this.zzf = i7;
            this.zzc = (((i7 * 12) / i9) + i11) * 4;
        } else {
            int i12 = 144;
            if (i2 == 3) {
                if (i3 == 2) {
                    i6 = zzadk.zze[i8];
                } else {
                    i6 = zzadk.zzf[i8];
                }
                this.zzf = i6;
                this.zzc = ((i6 * 144) / i9) + i11;
            } else {
                int i13 = zzadk.zzg[i8];
                this.zzf = i13;
                if (i3 == 1) {
                    i12 = 72;
                }
                this.zzc = ((i12 * i13) / i9) + i11;
            }
        }
        if (((i >> 6) & 3) == 3) {
            i10 = 1;
        }
        this.zze = i10;
        return true;
    }
}
