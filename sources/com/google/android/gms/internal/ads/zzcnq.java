package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcnq implements zzbjr {
    final /* synthetic */ zzcnt zza;

    zzcnq(zzcnt zzcnt) {
        this.zza = zzcnt;
    }

    public final void zza(Object obj, Map map) {
        if (zzcnt.zzg(this.zza, map)) {
            this.zza.zzc.execute(new zzcnp(this));
        }
    }
}
