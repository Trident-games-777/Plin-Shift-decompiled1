package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbpc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class InterstitialAd {
    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzbc.zza().zzg(context.getApplicationContext(), new zzbpc()).zzk(str);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public static void load(Context context, String str, AdRequest adRequest, InterstitialAdLoadCallback interstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzi.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzb.zzb.execute(new zza(context, str, adRequest, interstitialAdLoadCallback));
                return;
            }
        }
        new zzbml(context, str).zza(adRequest.zza(), interstitialAdLoadCallback);
    }

    public static InterstitialAd pollAd(Context context, String str) {
        try {
            zzby zzf = zzbc.zza().zzg(context.getApplicationContext(), new zzbpc()).zzf(str);
            if (zzf != null) {
                return new zzbml(context, str, zzf);
            }
            zzm.zzl("Failed to obtain an Interstitial Ad from the preloader.", (Throwable) null);
            return null;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    public abstract String getAdUnitId();

    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract OnPaidEventListener getOnPaidEventListener();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void show(Activity activity);
}
