package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnb {
    private HashMap zza = new HashMap();

    public final zzgnd zza() {
        if (this.zza != null) {
            zzgnd zzgnd = new zzgnd(Collections.unmodifiableMap(this.zza), (zzgnc) null);
            this.zza = null;
            return zzgnd;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
