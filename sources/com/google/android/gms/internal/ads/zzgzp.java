package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgzp implements Map.Entry {
    private final Map.Entry zza;

    /* synthetic */ zzgzp(Map.Entry entry, zzgzr zzgzr) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzgzs) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhai) {
            return ((zzgzs) this.zza.getValue()).zzc((zzhai) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzgzs zza() {
        return (zzgzs) this.zza.getValue();
    }
}
