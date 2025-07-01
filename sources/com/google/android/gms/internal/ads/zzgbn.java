package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzgbn extends AbstractSet {
    zzgbn() {
    }

    public boolean removeAll(Collection collection) {
        return zzgbq.zze(this, collection);
    }

    public boolean retainAll(Collection collection) {
        collection.getClass();
        Collection collection2 = collection;
        return super.retainAll(collection);
    }
}
