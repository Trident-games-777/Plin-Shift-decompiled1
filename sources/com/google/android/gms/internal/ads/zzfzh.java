package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfzh extends zzfzi {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    zzfzh(int i) {
        zzfyl.zza(i, "initialCapacity");
        this.zza = new Object[i];
    }

    private final void zzf(int i) {
        int length = this.zza.length;
        int zze = zze(length, this.zzb + i);
        if (zze > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, zze);
            this.zzc = false;
        }
    }

    public /* bridge */ /* synthetic */ zzfzi zzb(Object obj) {
        throw null;
    }

    public final zzfzi zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(collection.size());
            if (collection instanceof zzfzj) {
                this.zzb = ((zzfzj) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        for (Object zzb2 : iterable) {
            zzb(zzb2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object[] objArr, int i) {
        zzgay.zzb(objArr, 2);
        zzf(2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }

    public final zzfzh zza(Object obj) {
        obj.getClass();
        zzf(1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
