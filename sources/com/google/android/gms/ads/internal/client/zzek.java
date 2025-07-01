package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzek extends zzbd {
    final /* synthetic */ zzel zza;

    zzek(zzel zzel) {
        this.zza = zzel;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzel zzel = this.zza;
        zzel.zze.zzb(zzel.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        zzel zzel = this.zza;
        zzel.zze.zzb(zzel.zzi());
        super.onAdLoaded();
    }
}
