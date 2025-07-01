package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbab;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzban;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbpc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
    public static abstract class AppOpenAdLoadCallback extends AdLoadCallback<AppOpenAd> {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
    public @interface AppOpenAdOrientation {
    }

    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzbc.zza().zzg(context.getApplicationContext(), new zzbpc()).zzj(str);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    @Deprecated
    public static void load(Context context, String str, AdRequest adRequest, int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzd.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzb.zzb.execute(new zzb(context, str, adRequest, i, appOpenAdLoadCallback));
                return;
            }
        }
        int i2 = i;
        new zzban(context, str, adRequest.zza(), i2, appOpenAdLoadCallback).zza();
    }

    public static AppOpenAd pollAd(Context context, String str) {
        try {
            zzbaf zze = zzbc.zza().zzg(context.getApplicationContext(), new zzbpc()).zze(str);
            if (zze != null) {
                return new zzbab(zze, str);
            }
            zzm.zzl("Failed to obtain an App Open ad from the preloader.", (Throwable) null);
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

    public static void load(Context context, String str, AdRequest adRequest, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzd.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzb.zzb.execute(new zza(context, str, adRequest, appOpenAdLoadCallback));
                return;
            }
        }
        new zzban(context, str, adRequest.zza(), 3, appOpenAdLoadCallback).zza();
    }

    @Deprecated
    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbcn.zza(context);
        if (((Boolean) zzbel.zzd.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                zzb.zzb.execute(new zzc(context, str, adManagerAdRequest, i, appOpenAdLoadCallback));
                return;
            }
        }
        int i2 = i;
        new zzban(context, str, adManagerAdRequest.zza(), i2, appOpenAdLoadCallback).zza();
    }
}
