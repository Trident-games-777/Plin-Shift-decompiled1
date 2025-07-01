package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.formats.zzi;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.internal.ads.zzbgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zze extends AdListener implements zzi, zzg, zzf {
    final AbstractAdViewAdapter zza;
    final MediationNativeListener zzb;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, (AdError) loadAdError);
    }

    public final void onAdImpression() {
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void zza(UnifiedNativeAd unifiedNativeAd) {
        this.zzb.onAdLoaded(this.zza, new zza(unifiedNativeAd));
    }

    public final void zzb(zzbgt zzbgt, String str) {
        this.zzb.zze(this.zza, zzbgt, str);
    }

    public final void zzc(zzbgt zzbgt) {
        this.zzb.zzd(this.zza, zzbgt);
    }
}
