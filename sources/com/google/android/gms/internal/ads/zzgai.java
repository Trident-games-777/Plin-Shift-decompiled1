package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
class zzgai extends zzgbn {
    final Map zzd;

    zzgai(Map map) {
        map.getClass();
        Map map2 = map;
        this.zzd = map;
    }

    public void clear() {
        this.zzd.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zzd.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.zzd.isEmpty();
    }

    public Iterator iterator() {
        return new zzgaf(this.zzd.entrySet().iterator());
    }

    public boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.zzd.remove(obj);
        return true;
    }

    public final int size() {
        return this.zzd.size();
    }
}
