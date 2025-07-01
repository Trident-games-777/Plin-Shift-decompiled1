package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzxi implements Comparator {
    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        return zzfzd.zzj().zzc((zzxz) Collections.max(list, new zzxx()), (zzxz) Collections.max(list2, new zzxx()), new zzxx()).zzb(list.size(), list2.size()).zzc((zzxz) Collections.max(list, new zzxy()), (zzxz) Collections.max(list2, new zzxy()), new zzxy()).zza();
    }
}
