package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgo extends zzfze {
    private final Map zza;

    public zzgo(Map map) {
        this.zza = map;
    }

    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return super.zzd(obj);
    }

    public final Set entrySet() {
        return zzgbq.zzc(this.zza.entrySet(), new zzgm());
    }

    public final boolean equals(Object obj) {
        return obj != null && super.zze(obj);
    }

    public final /* synthetic */ Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.zza.get(obj);
    }

    public final int hashCode() {
        return super.zzc();
    }

    public final boolean isEmpty() {
        if (this.zza.isEmpty()) {
            return true;
        }
        if (super.size() != 1 || !super.containsKey((Object) null)) {
            return false;
        }
        return true;
    }

    public final Set keySet() {
        return zzgbq.zzc(this.zza.keySet(), new zzgn());
    }

    public final int size() {
        return super.size() - (super.containsKey((Object) null) ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final Map zzb() {
        return this.zza;
    }
}
