package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgdq extends zzgds {
    zzgdq(zzfzj zzfzj, boolean z) {
        super(zzfzj, z);
        zzv();
    }

    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList zza = zzgae.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgdr zzgdr = (zzgdr) it.next();
            zza.add(zzgdr != null ? zzgdr.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}
