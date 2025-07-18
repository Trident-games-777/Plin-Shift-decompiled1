package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmk {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgmk() {
    }

    public final zzgmk zza(Enum enumR, Object obj) {
        this.zza.put(enumR, obj);
        this.zzb.put(obj, enumR);
        return this;
    }

    public final zzgmm zzb() {
        return new zzgmm(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), (zzgml) null);
    }

    /* synthetic */ zzgmk(zzgml zzgml) {
    }
}
