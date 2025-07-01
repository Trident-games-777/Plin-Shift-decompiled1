package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfza extends zzfzd {
    zzfza() {
        super((zzfzc) null);
    }

    static final zzfzd zzf(int i) {
        return i < 0 ? zzfzd.zzb : i > 0 ? zzfzd.zzc : zzfzd.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfzd zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    public final zzfzd zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    public final zzfzd zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    public final zzfzd zze(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }
}
