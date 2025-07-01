package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbmq implements Predicate {
    public final /* synthetic */ zzbjr zza;

    public /* synthetic */ zzbmq(zzbjr zzbjr) {
        this.zza = zzbjr;
    }

    public final boolean apply(Object obj) {
        zzbjr zzbjr = (zzbjr) obj;
        if (!(zzbjr instanceof zzbmw)) {
            return false;
        }
        return ((zzbmw) zzbjr).zzb.equals(this.zza);
    }
}
