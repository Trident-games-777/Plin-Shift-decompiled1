package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbxv extends zzbxi {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbxw zzb;

    public zzbxv(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbxw zzbxw) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbxw;
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzbxw zzbxw;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzbxw = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzbxw);
        }
    }
}
