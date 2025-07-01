package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzbv {
    public static final zzbv zza = new zzbs();

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    protected zzbv() {
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbv)) {
            return false;
        }
        zzbv zzbv = (zzbv) obj;
        if (zzbv.zzc() == zzc() && zzbv.zzb() == zzb()) {
            zzbu zzbu = new zzbu();
            zzbt zzbt = new zzbt();
            zzbu zzbu2 = new zzbu();
            zzbt zzbt2 = new zzbt();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzbu, 0).equals(zzbv.zze(i, zzbu2, 0))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzbt, true).equals(zzbv.zzd(i2, zzbt2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzbv.zzg(true) && (zzh = zzh(true)) == zzbv.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzbv.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzbu zzbu = new zzbu();
        zzbt zzbt = new zzbt();
        int zzc = zzc() + 217;
        int i2 = 0;
        while (true) {
            i = zzc * 31;
            if (i2 >= zzc()) {
                break;
            }
            zzc = i + zze(i2, zzbu, 0).hashCode();
            i2++;
        }
        int zzb = i + zzb();
        for (int i3 = 0; i3 < zzb(); i3++) {
            zzb = (zzb * 31) + zzd(i3, zzbt, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb = (zzb * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzbt zzd(int i, zzbt zzbt, boolean z);

    public abstract zzbu zze(int i, zzbu zzbu, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzbt zzbt, zzbu zzbu, int i2, boolean z) {
        int i3 = zzd(i, zzbt, false).zzc;
        if (zze(i3, zzbu, 0).zzo != i) {
            return i + 1;
        }
        int zzj = zzj(i3, i2, z);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzbu, 0).zzn;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == zzh(z) ? zzg(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == zzh(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzbu zzbu, zzbt zzbt, int i, long j) {
        Pair zzm = zzm(zzbu, zzbt, i, j, 0);
        zzm.getClass();
        Pair pair = zzm;
        return zzm;
    }

    public final Pair zzm(zzbu zzbu, zzbt zzbt, int i, long j, long j2) {
        zzdb.zza(i, 0, zzc());
        zze(i, zzbu, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzbu.zzl;
            j = 0;
        }
        int i2 = zzbu.zzn;
        zzd(i2, zzbt, false);
        while (i2 < zzbu.zzo) {
            long j4 = zzbt.zze;
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 == 0) {
                break;
            }
            int i4 = i2 + 1;
            long j5 = zzd(i4, zzbt, false).zze;
            if (i3 < 0) {
                break;
            }
            i2 = i4;
        }
        zzd(i2, zzbt, true);
        long j6 = zzbt.zze;
        long j7 = zzbt.zzd;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long max = Math.max(0, j);
        Object obj = zzbt.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzbt zzn(Object obj, zzbt zzbt) {
        return zzd(zza(obj), zzbt, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
