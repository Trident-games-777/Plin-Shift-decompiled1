package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbt {
    public Object zza;
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    public zzb zzg = zzb.zza;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            zzbt zzbt = (zzbt) obj;
            return Objects.equals(this.zza, zzbt.zza) && Objects.equals(this.zzb, zzbt.zzb) && this.zzc == zzbt.zzc && this.zzd == zzbt.zzd && this.zzf == zzbt.zzf && Objects.equals(this.zzg, zzbt.zzg);
        }
    }

    public final int zza(int i) {
        return this.zzg.zza(i).zzb;
    }

    public final int zzb() {
        int i = this.zzg.zzb;
        return 0;
    }

    public final int zzc(long j) {
        return -1;
    }

    public final int zzd(long j) {
        this.zzg.zzb(-1);
        return -1;
    }

    public final int zze(int i) {
        return this.zzg.zza(i).zza(-1);
    }

    public final long zzf(int i, int i2) {
        zza zza2 = this.zzg.zza(i);
        if (zza2.zzb != -1) {
            return zza2.zzf[i2];
        }
        return -9223372036854775807L;
    }

    public final long zzg(int i) {
        long j = this.zzg.zza(i).zza;
        return 0;
    }

    public final long zzh() {
        long j = this.zzg.zzc;
        return 0;
    }

    public final zzbt zzi(Object obj, Object obj2, int i, long j, long j2, zzb zzb2, boolean z) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = i;
        this.zzd = j;
        this.zze = 0;
        this.zzg = zzb2;
        this.zzf = z;
        return this;
    }

    public final boolean zzj(int i) {
        zzb();
        if (i != -1) {
            return false;
        }
        this.zzg.zzb(-1);
        return false;
    }

    public final boolean zzk(int i) {
        boolean z = this.zzg.zza(i).zzh;
        return false;
    }

    public final int hashCode() {
        int i;
        Object obj = this.zza;
        int i2 = 0;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        Object obj2 = this.zzb;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        int i3 = ((((i + 217) * 31) + i2) * 31) + this.zzc;
        long j = this.zzd;
        return (((((i3 * 31) + ((int) (j ^ (j >>> 32)))) * 961) + (this.zzf ? 1 : 0)) * 31) + this.zzg.hashCode();
    }
}
