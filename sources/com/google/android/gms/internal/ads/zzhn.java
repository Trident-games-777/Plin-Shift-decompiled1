package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzhn extends zzbv {
    private final int zzb;
    private final zzwj zzc;

    public zzhn(boolean z, zzwj zzwj) {
        this.zzc = zzwj;
        this.zzb = zzwj.zzc();
    }

    private final int zzw(int i, boolean z) {
        if (z) {
            return this.zzc.zzd(i);
        }
        if (i >= this.zzb - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzc.zze(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    public final int zza(Object obj) {
        int zza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int zzp = zzp(obj2);
            if (!(zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1)) {
                return zzs(zzp) + zza;
            }
        }
        return -1;
    }

    public final zzbt zzd(int i, zzbt zzbt, boolean z) {
        int zzq = zzq(i);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i - zzs(zzq), zzbt, z);
        zzbt.zzc += zzt;
        if (z) {
            Object zzv = zzv(zzq);
            Object obj = zzbt.zzb;
            obj.getClass();
            zzbt.zzb = Pair.create(zzv, obj);
        }
        return zzbt;
    }

    public final zzbu zze(int i, zzbu zzbu, long j) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i - zzt, zzbu, j);
        Object zzv = zzv(zzr);
        if (!zzbu.zza.equals(zzbu.zzb)) {
            zzv = Pair.create(zzv, zzbu.zzb);
        }
        zzbu.zzb = zzv;
        zzbu.zzn += zzs;
        zzbu.zzo += zzs;
        return zzbu;
    }

    public final Object zzf(int i) {
        int zzq = zzq(i);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i - zzs(zzq)));
    }

    public final int zzg(boolean z) {
        if (this.zzb != 0) {
            int zza = z ? this.zzc.zza() : 0;
            while (zzu(zza).zzo()) {
                zza = zzw(zza, z);
                if (zza == -1) {
                }
            }
            return zzt(zza) + zzu(zza).zzg(z);
        }
        return -1;
    }

    public final int zzh(boolean z) {
        int i = this.zzb;
        if (i != 0) {
            int zzb2 = z ? this.zzc.zzb() : i - 1;
            while (zzu(zzb2).zzo()) {
                zzb2 = zzx(zzb2, z);
                if (zzb2 == -1) {
                }
            }
            return zzt(zzb2) + zzu(zzb2).zzh(z);
        }
        return -1;
    }

    public final int zzj(int i, int i2, boolean z) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzj = zzu(zzr).zzj(i - zzt, i2 == 2 ? 0 : i2, z);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z);
        }
        if (zzw != -1) {
            return zzt(zzw) + zzu(zzw).zzg(z);
        }
        if (i2 == 2) {
            return zzg(z);
        }
        return -1;
    }

    public final int zzk(int i, int i2, boolean z) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx != -1) {
            return zzt(zzx) + zzu(zzx).zzh(false);
        }
        return -1;
    }

    public final zzbt zzn(Object obj, zzbt zzbt) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzbt);
        zzbt.zzc += zzt;
        zzbt.zzb = obj;
        return zzbt;
    }

    /* access modifiers changed from: protected */
    public abstract int zzp(Object obj);

    /* access modifiers changed from: protected */
    public abstract int zzq(int i);

    /* access modifiers changed from: protected */
    public abstract int zzr(int i);

    /* access modifiers changed from: protected */
    public abstract int zzs(int i);

    /* access modifiers changed from: protected */
    public abstract int zzt(int i);

    /* access modifiers changed from: protected */
    public abstract zzbv zzu(int i);

    /* access modifiers changed from: protected */
    public abstract Object zzv(int i);
}
