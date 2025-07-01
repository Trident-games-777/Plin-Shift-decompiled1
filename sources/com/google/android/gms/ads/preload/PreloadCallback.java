package com.google.android.gms.ads.preload;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public interface PreloadCallback {
    void onAdsAvailable(PreloadConfiguration preloadConfiguration);

    void onAdsExhausted(PreloadConfiguration preloadConfiguration);
}
