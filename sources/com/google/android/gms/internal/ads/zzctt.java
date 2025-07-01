package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzctt implements zza {
    private final zzctx zza;
    private final zzffo zzb;

    zzctt(zzctx zzctx, zzffo zzffo) {
        this.zza = zzctx;
        this.zzb = zzffo;
    }

    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
