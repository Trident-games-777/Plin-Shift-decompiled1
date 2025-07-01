package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgaz implements Comparator {
    protected zzgaz() {
    }

    public static zzgaz zzb(Comparator comparator) {
        return new zzfyz(comparator);
    }

    public static zzgaz zzc() {
        return zzgax.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzgaz zza() {
        return new zzgbi(this);
    }
}
