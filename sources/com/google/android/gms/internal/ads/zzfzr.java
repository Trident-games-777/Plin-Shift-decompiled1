package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfzr implements Map, Serializable {
    @CheckForNull
    private transient zzfzt zza;
    @CheckForNull
    private transient zzfzt zzb;
    @CheckForNull
    private transient zzfzj zzc;

    zzfzr() {
    }

    public static zzfzr zzc(Map map) {
        Set entrySet = map.entrySet();
        zzfzq zzfzq = new zzfzq(entrySet instanceof Collection ? entrySet.size() : 4);
        zzfzq.zzb(entrySet);
        return zzfzq.zzc();
    }

    public static zzfzr zzd() {
        return zzgbf.zza;
    }

    public static zzfzr zze(Object obj, Object obj2) {
        zzfyl.zzb("dialog_not_shown_reason", obj2);
        return zzgbf.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, (zzfzq) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return zzgal.zzb(this, obj);
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzgbq.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfyl.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzfzj zza();

    /* renamed from: zzb */
    public final zzfzj values() {
        zzfzj zzfzj = this.zzc;
        if (zzfzj != null) {
            return zzfzj;
        }
        zzfzj zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzfzt zzf();

    /* access modifiers changed from: package-private */
    public abstract zzfzt zzg();

    /* renamed from: zzh */
    public final zzfzt entrySet() {
        zzfzt zzfzt = this.zza;
        if (zzfzt != null) {
            return zzfzt;
        }
        zzfzt zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    /* renamed from: zzi */
    public final zzfzt keySet() {
        zzfzt zzfzt = this.zzb;
        if (zzfzt != null) {
            return zzfzt;
        }
        zzfzt zzg = zzg();
        this.zzb = zzg;
        return zzg;
    }
}
