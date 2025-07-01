package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfzu {
    public static Object zza(Iterable iterable, Object obj) {
        zzgbj zzgbj = new zzgbj((zzgbk) iterable);
        return zzgbj.hasNext() ? zzgbj.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfwr zzfwr) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            zzfwr.getClass();
            boolean z = false;
            while (it.hasNext()) {
                if (zzfwr.zza(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        zzfwr.getClass();
        zzfwr zzfwr2 = zzfwr;
        return zzd((List) iterable, zzfwr);
    }

    private static void zzc(List list, zzfwr zzfwr, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfwr.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 >= i) {
                list.remove(i2);
            } else {
                return;
            }
        }
    }

    private static boolean zzd(List list, zzfwr zzfwr) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfwr.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (UnsupportedOperationException unused) {
                        zzc(list, zzfwr, i2, i);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        zzc(list, zzfwr, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}
