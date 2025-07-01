package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdwe extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwh zzb;

    zzdwe(zzdwh zzdwh, String str) {
        this.zza = str;
        this.zzb = zzdwh;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdwh.zzl(loadAdError), this.zza);
    }
}
