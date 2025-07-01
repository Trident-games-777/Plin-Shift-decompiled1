package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgbq {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    public static zzgbo zzb(Set set, Set set2) {
        zzfwq.zzc(set, "set1");
        zzfwq.zzc(set2, "set2");
        return new zzgbk(set, set2);
    }

    public static Set zzc(Set set, zzfwr zzfwr) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzgbl) {
                zzgbl zzgbl = (zzgbl) sortedSet;
                return new zzgbm((SortedSet) zzgbl.zza, zzfwu.zza(zzgbl.zzb, zzfwr));
            }
            sortedSet.getClass();
            SortedSet sortedSet2 = sortedSet;
            zzfwr zzfwr2 = zzfwr;
            return new zzgbm(sortedSet, zzfwr);
        } else if (set instanceof zzgbl) {
            zzgbl zzgbl2 = (zzgbl) set;
            return new zzgbl((Set) zzgbl2.zza, zzfwu.zza(zzgbl2.zzb, zzfwr));
        } else {
            set.getClass();
            Set set2 = set;
            zzfwr zzfwr3 = zzfwr;
            return new zzgbl(set, zzfwr);
        }
    }

    static boolean zzd(Set set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    static boolean zzf(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgaw) {
            collection = ((zzgaw) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
