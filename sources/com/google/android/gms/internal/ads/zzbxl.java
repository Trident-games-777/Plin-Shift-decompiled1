package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzei;
import com.google.android.gms.ads.internal.client.zzfr;
import com.google.android.gms.ads.internal.client.zzfs;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbxl extends RewardedAd {
    private final String zza;
    private final zzbxc zzb;
    private final Context zzc;
    private final zzbxu zzd;
    private zzci zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;
    private FullScreenContentCallback zzh;
    private final long zzi;
    private final Object zzj;

    public zzbxl(Context context, String str) {
        this(context.getApplicationContext(), str, zzbc.zza().zzs(context, str, new zzbpc()), new zzbxu());
    }

    private final void zzd(Context context, zzbpg zzbpg) {
        synchronized (this.zzj) {
            if (this.zze == null) {
                this.zze = zzbc.zza().zzg(context, zzbpg);
            }
        }
    }

    public final Bundle getAdMetadata() {
        try {
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                return zzbxc.zzb();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzh;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final ResponseInfo getResponseInfo() {
        zzdy zzdy = null;
        try {
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                zzdy = zzbxc.zzc();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzdy);
    }

    public final RewardItem getRewardItem() {
        try {
            zzbxc zzbxc = this.zzb;
            zzbwz zzd2 = zzbxc != null ? zzbxc.zzd() : null;
            if (zzd2 == null) {
                return RewardItem.DEFAULT_REWARD;
            }
            return new zzbxm(zzd2);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzh = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                zzbxc.zzh(z);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzf = onAdMetadataChangedListener;
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                zzbxc.zzi(new zzfr(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzg = onPaidEventListener;
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                zzbxc.zzj(new zzfs(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzbxc zzbxc = this.zzb;
                if (zzbxc != null) {
                    zzbxc.zzl(new zzbxq(serverSideVerificationOptions));
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzm.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbxc zzbxc = this.zzb;
            if (zzbxc != null) {
                zzbxc.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final RewardedAd zza() {
        try {
            zzd(this.zzc, new zzbpc());
            zzbxc zzg2 = this.zze.zzg(this.zza);
            if (zzg2 != null) {
                return new zzbxl(this.zzc, this.zza, zzg2, this.zzd);
            }
            zzm.zzl("Failed to obtain a Rewarded Ad from the preloader.", (Throwable) null);
            return null;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void zzb(zzei zzei, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            if (this.zzb != null) {
                zzei.zzq(this.zzi);
                this.zzb.zzf(zzr.zza.zza(this.zzc, zzei), new zzbxp(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzc() {
        try {
            zzd(this.zzc, new zzbpc());
            return this.zze.zzl(this.zza);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    protected zzbxl(Context context, String str, zzbxc zzbxc, zzbxu zzbxu) {
        this.zzi = System.currentTimeMillis();
        this.zzj = new Object();
        this.zzc = context.getApplicationContext();
        this.zza = str;
        this.zzb = zzbxc;
        this.zzd = zzbxu;
    }
}
