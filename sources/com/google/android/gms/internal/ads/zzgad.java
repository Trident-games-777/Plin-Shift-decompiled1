package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgad extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzfwh zzb;

    zzgad(List list, zzfwh zzfwh) {
        list.getClass();
        List list2 = list;
        this.zza = list;
        zzfwh zzfwh2 = zzfwh;
        this.zzb = zzfwh;
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final ListIterator listIterator(int i) {
        return new zzgac(this, this.zza.listIterator(i));
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        this.zza.subList(i, i2).clear();
    }

    public final int size() {
        return this.zza.size();
    }
}
