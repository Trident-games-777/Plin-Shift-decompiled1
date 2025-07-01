package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzaz;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdye implements zzgee {
    final /* synthetic */ Context zza;

    zzdye(Context context) {
        this.zza = context;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbef.zzh.zze()).booleanValue() && (th instanceof zzaz)) {
            zzbbx.zze(this.zza);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdyx zzdyx = (zzdyx) obj;
        if (((Boolean) zzbef.zzj.zze()).booleanValue()) {
            zzbbx.zze(this.zza);
        }
    }
}
