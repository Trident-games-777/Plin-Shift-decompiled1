package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzfyd implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfye zzc;

    zzfyd(zzfye zzfye) {
        Iterator it;
        this.zzc = zzfye;
        this.zzb = zzfye.zzb;
        Collection collection = zzfye.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    zzfyd(zzfye zzfye, Iterator it) {
        this.zzc = zzfye;
        this.zzb = zzfye.zzb;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfyh zzfyh = this.zzc.zze;
        zzfyh.zzb = zzfyh.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
