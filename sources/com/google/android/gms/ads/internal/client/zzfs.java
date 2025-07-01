package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfs extends zzdq {
    private final OnPaidEventListener zza;

    public zzfs(OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzu zzu) {
        OnPaidEventListener onPaidEventListener = this.zza;
        if (onPaidEventListener != null) {
            onPaidEventListener.onPaidEvent(AdValue.zza(zzu.zzb, zzu.zzc, zzu.zzd));
        }
    }

    public final boolean zzf() {
        return this.zza == null;
    }
}
