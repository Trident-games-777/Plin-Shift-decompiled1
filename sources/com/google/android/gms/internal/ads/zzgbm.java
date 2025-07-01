package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbm extends zzgbl implements SortedSet {
    zzgbm(SortedSet sortedSet, zzfwr zzfwr) {
        super(sortedSet, zzfwr);
    }

    @CheckForNull
    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    public final Object first() {
        Iterator it = this.zza.iterator();
        it.getClass();
        zzfwr zzfwr = this.zzb;
        zzfwr.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzfwr.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new zzgbm(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            zzfwr zzfwr = this.zzb;
            Object last = sortedSet.last();
            if (zzfwr.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzgbm(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    public final SortedSet tailSet(Object obj) {
        return new zzgbm(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
