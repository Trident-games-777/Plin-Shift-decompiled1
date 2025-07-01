package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbkn extends zzbkp {
    private final OnH5AdsEventListener zza;

    public zzbkn(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
