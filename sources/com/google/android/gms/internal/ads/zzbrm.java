package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbrm implements MediationAdLoadCallback {
    final /* synthetic */ zzbqw zza;
    final /* synthetic */ zzbpm zzb;
    final /* synthetic */ zzbrs zzc;

    zzbrm(zzbrs zzbrs, zzbqw zzbqw, zzbpm zzbpm) {
        this.zza = zzbqw;
        this.zzb = zzbpm;
        this.zzc = zzbrs;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterstitialAd mediationInterstitialAd = (MediationInterstitialAd) obj;
        if (mediationInterstitialAd == null) {
            zzm.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zze("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzm.zzh("", e);
                return null;
            }
        } else {
            try {
                this.zzc.zzb = mediationInterstitialAd;
                this.zza.zzg();
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
            return new zzbrt(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
