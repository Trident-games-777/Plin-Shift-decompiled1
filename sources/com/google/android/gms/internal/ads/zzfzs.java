package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfzs extends zzfzh {
    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzfzs() {
        super(4);
    }

    public final /* bridge */ /* synthetic */ zzfzi zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfzs zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i = 0; i < 2; i++) {
                zzf(objArr[i]);
            }
            return this;
        }
        zzd(objArr, 2);
        return this;
    }

    zzfzs(int i, boolean z) {
        super(i);
        this.zzd = new Object[zzfzt.zzh(i)];
    }

    public final zzfzs zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            for (Object zzf : iterable) {
                zzf(zzf);
            }
            return this;
        }
        super.zzc(iterable);
        return this;
    }

    public final zzfzt zzi() {
        zzfzt zzfzt;
        int i = this.zzb;
        if (i == 0) {
            return zzgbg.zza;
        }
        if (i == 1) {
            return new zzgbr(Objects.requireNonNull(this.zza[0]));
        }
        if (this.zzd == null || zzfzt.zzh(i) != this.zzd.length) {
            zzfzt = zzfzt.zzv(this.zzb, this.zza);
            this.zzb = zzfzt.size();
        } else {
            int i2 = this.zzb;
            Object[] objArr = this.zza;
            if (zzfzt.zzw(i2, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i2);
            }
            int i3 = this.zze;
            Object[] objArr2 = this.zzd;
            zzfzt = new zzgbg(objArr, i3, objArr2, objArr2.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfzt;
    }

    public final zzfzs zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int zzh = zzfzt.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (zzh <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.zzd.length - 1;
                int hashCode = obj.hashCode();
                int zza = zzfzg.zza(hashCode);
                while (true) {
                    int i = zza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 == null) {
                        objArr2[i] = obj;
                        this.zze += hashCode;
                        super.zza(obj);
                        return this;
                    } else if (obj2.equals(obj)) {
                        return this;
                    } else {
                        zza = i + 1;
                    }
                }
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
