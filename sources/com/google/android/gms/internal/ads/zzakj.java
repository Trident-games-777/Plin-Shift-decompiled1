package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzakj implements zzacu {
    private final zzacu zzb;
    private final zzakg zzc;
    private final SparseArray zzd = new SparseArray();

    public zzakj(zzacu zzacu, zzakg zzakg) {
        this.zzb = zzacu;
        this.zzc = zzakg;
    }

    public final void zzD() {
        this.zzb.zzD();
    }

    public final void zzO(zzadq zzadq) {
        this.zzb.zzO(zzadq);
    }

    public final zzadx zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzakl zzakl = (zzakl) this.zzd.get(i);
        if (zzakl != null) {
            return zzakl;
        }
        zzakl zzakl2 = new zzakl(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzakl2);
        return zzakl2;
    }
}
