package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzh extends zzbn {
    private final AdLoadCallback zza;
    private final Object zzb;

    public zzh(AdLoadCallback adLoadCallback, Object obj) {
        this.zza = adLoadCallback;
        this.zzb = obj;
    }

    public final void zzb(zze zze) {
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzc() {
        Object obj;
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback != null && (obj = this.zzb) != null) {
            adLoadCallback.onAdLoaded(obj);
        }
    }
}
