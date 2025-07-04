package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdoa implements zzbjr {
    final /* synthetic */ zzdoc zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbjr zzd;

    /* synthetic */ zzdoa(zzdoc zzdoc, WeakReference weakReference, String str, zzbjr zzbjr, zzdob zzdob) {
        this.zza = zzdoc;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbjr;
    }

    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzn(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
