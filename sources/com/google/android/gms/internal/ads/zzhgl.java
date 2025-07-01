package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhgl implements zzhfx {
    private final List zza;
    private final List zzb;

    static {
        zzhfy.zza(Collections.emptySet());
    }

    /* synthetic */ zzhgl(List list, List list2, zzhgj zzhgj) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzhgk zza(int i, int i2) {
        return new zzhgk(i, i2, (zzhgj) null);
    }

    /* renamed from: zzc */
    public final Set zzb() {
        int size = this.zza.size();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        int size2 = this.zzb.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) ((zzhgg) this.zzb.get(i)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zza2 = zzhfu.zza(size);
        int size3 = this.zza.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object zzb2 = ((zzhgg) this.zza.get(i2)).zzb();
            zzb2.getClass();
            zza2.add(zzb2);
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object next : (Collection) arrayList.get(i3)) {
                next.getClass();
                zza2.add(next);
            }
        }
        return Collections.unmodifiableSet(zza2);
    }
}
