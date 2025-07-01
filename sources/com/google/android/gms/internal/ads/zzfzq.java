package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfzq {
    Object[] zza;
    int zzb;
    zzfzp zzc;

    public zzfzq() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfzi.zze(length, i2));
        }
    }

    public final zzfzq zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfyl.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzfzq zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfzr zzc() {
        zzfzp zzfzp = this.zzc;
        if (zzfzp == null) {
            zzgbf zzj = zzgbf.zzj(this.zzb, this.zza, this);
            zzfzp zzfzp2 = this.zzc;
            if (zzfzp2 == null) {
                return zzj;
            }
            throw zzfzp2.zza();
        }
        throw zzfzp.zza();
    }

    zzfzq(int i) {
        this.zza = new Object[(i + i)];
        this.zzb = 0;
    }
}
