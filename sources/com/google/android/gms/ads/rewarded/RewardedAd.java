package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbxl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class RewardedAd {
    public static boolean isAdAvailable(Context context, String str) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        return new zzbxl(context, str).zzc();
    }

    public static void load(Context context, String str, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzb.zzb.execute(new zzc(context, str, adRequest, rewardedAdLoadCallback));
                return;
            }
        }
        zzm.zze("Loading on UI thread");
        new zzbxl(context, str).zzb(adRequest.zza(), rewardedAdLoadCallback);
    }

    public static RewardedAd pollAd(Context context, String str) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        return new zzbxl(context, str).zza();
    }

    public abstract Bundle getAdMetadata();

    public abstract String getAdUnitId();

    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();

    public abstract OnPaidEventListener getOnPaidEventListener();

    public abstract ResponseInfo getResponseInfo();

    public abstract RewardItem getRewardItem();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzm.zze("Loading on background thread");
                zzb.zzb.execute(new zzb(context, str, adManagerAdRequest, rewardedAdLoadCallback));
                return;
            }
        }
        zzm.zze("Loading on UI thread");
        new zzbxl(context, str).zzb(adManagerAdRequest.zza(), rewardedAdLoadCallback);
    }
}
