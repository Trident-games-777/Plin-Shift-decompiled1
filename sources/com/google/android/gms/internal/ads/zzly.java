package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzly {
    private final zzz zza;
    private final SparseArray zzb;

    public zzly(zzz zzz, SparseArray sparseArray) {
        this.zza = zzz;
        SparseArray sparseArray2 = new SparseArray(zzz.zzb());
        for (int i = 0; i < zzz.zzb(); i++) {
            int zza2 = zzz.zza(i);
            zzlx zzlx = (zzlx) sparseArray.get(zza2);
            zzlx.getClass();
            zzlx zzlx2 = zzlx;
            sparseArray2.append(zza2, zzlx);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzlx zzc(int i) {
        zzlx zzlx = (zzlx) this.zzb.get(i);
        zzlx.getClass();
        zzlx zzlx2 = zzlx;
        return zzlx;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
