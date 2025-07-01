package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnd {
    public static final zzgnd zza = new zzgnb().zza();
    private final Map zzb;

    /* synthetic */ zzgnd(Map map, zzgnc zzgnc) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnd)) {
            return false;
        }
        return this.zzb.equals(((zzgnd) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
