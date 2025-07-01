package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbsv extends zzbhl {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbsv(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbhv zzbhv) {
        this.zza.onNativeAdLoaded(new zzbsp(zzbhv));
    }
}
