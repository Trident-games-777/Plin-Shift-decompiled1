package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdwc extends RewardedAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzdwh zzc;

    zzdwc(zzdwh zzdwh, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzdwh;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzc.zzm(zzdwh.zzl(loadAdError), this.zzb);
    }

    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        String str = this.zzb;
        this.zzc.zzg(this.zza, (RewardedAd) obj, str);
    }
}
