package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzhfn implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhfo zzb;

    zzhfn(zzhfo zzhfo) {
        this.zzb = zzhfo;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            zzhfo zzhfo = this.zzb;
            int i = this.zza;
            this.zza = i + 1;
            return zzhfo.zza.get(i);
        }
        zzhfo zzhfo2 = this.zzb;
        zzhfo2.zza.add(zzhfo2.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
