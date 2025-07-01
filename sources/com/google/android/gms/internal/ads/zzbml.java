package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzei;
import com.google.android.gms.ads.internal.client.zzfs;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbml extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzr zzb;
    private final zzby zzc;
    private final String zzd;
    private final zzbpc zze;
    private final long zzf;
    private AppEventListener zzg;
    private FullScreenContentCallback zzh;
    private OnPaidEventListener zzi;

    public zzbml(Context context, String str) {
        zzbpc zzbpc = new zzbpc();
        this.zze = zzbpc;
        this.zzf = System.currentTimeMillis();
        this.zza = context;
        this.zzd = str;
        this.zzb = zzr.zza;
        this.zzc = zzbc.zza().zzf(context, new zzs(), str, zzbpc);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzg;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzh;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzi;
    }

    public final ResponseInfo getResponseInfo() {
        zzdy zzdy = null;
        try {
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzdy = zzby.zzk();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzdy);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzg = appEventListener;
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzby.zzG(appEventListener != null ? new zzaza(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzh = fullScreenContentCallback;
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzby.zzJ(new zzbf(fullScreenContentCallback));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzby.zzL(z);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzi = onPaidEventListener;
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzby.zzP(new zzfs(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzm.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzby zzby = this.zzc;
            if (zzby != null) {
                zzby.zzW(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzei zzei, AdLoadCallback adLoadCallback) {
        try {
            if (this.zzc != null) {
                zzei.zzq(this.zzf);
                this.zzc.zzy(this.zzb.zza(this.zza, zzei), new zzh(adLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }

    public zzbml(Context context, String str, zzby zzby) {
        this.zze = new zzbpc();
        this.zzf = System.currentTimeMillis();
        this.zza = context;
        this.zzd = str;
        this.zzb = zzr.zza;
        this.zzc = zzby;
    }
}
