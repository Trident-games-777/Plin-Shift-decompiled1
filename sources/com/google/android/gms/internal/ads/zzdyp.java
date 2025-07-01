package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdyp implements zzczj {
    private final Context zza;
    private final zzbyv zzb;

    zzdyp(Context context, zzbyv zzbyv) {
        this.zza = context;
        this.zzb = zzbyv;
    }

    public final void zzdn(zzbvx zzbvx) {
    }

    public final void zzdo(zzfff zzfff) {
        if (!TextUtils.isEmpty(zzfff.zzb.zzb.zze)) {
            this.zzb.zzm(this.zza, zzfff.zza.zza.zzd);
            this.zzb.zzi(this.zza, zzfff.zzb.zzb.zze);
        }
    }
}
