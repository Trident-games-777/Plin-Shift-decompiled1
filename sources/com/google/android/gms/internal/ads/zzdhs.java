package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdhs implements zzbjr {
    private final WeakReference zza;

    /* synthetic */ zzdhs(zzdhu zzdhu, zzdht zzdht) {
        this.zza = new WeakReference(zzdhu);
    }

    public final void zza(Object obj, Map map) {
        zzdhu zzdhu = (zzdhu) this.zza.get();
        if (zzdhu != null) {
            zzdhu.zzg.zza();
        }
    }
}
