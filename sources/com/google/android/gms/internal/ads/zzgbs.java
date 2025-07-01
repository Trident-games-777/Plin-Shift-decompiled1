package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzgbs implements Iterator {
    final Iterator zzb;

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);

    zzgbs(Iterator it) {
        it.getClass();
        Iterator it2 = it;
        this.zzb = it;
    }
}
