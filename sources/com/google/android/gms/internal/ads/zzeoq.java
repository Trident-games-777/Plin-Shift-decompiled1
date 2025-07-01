package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeoq implements zzevz {
    private final Set zza;

    zzeoq(Set set) {
        this.zza = set;
    }

    public final int zza() {
        return 8;
    }

    public final ListenableFuture zzb() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzgei.zzh(new zzeop(arrayList));
    }
}
