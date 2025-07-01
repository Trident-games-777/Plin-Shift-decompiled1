package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzazi implements ValueCallback {
    public final /* synthetic */ zzazj zza;

    public /* synthetic */ zzazi(zzazj zzazj) {
        this.zza = zzazj;
    }

    public final void onReceiveValue(Object obj) {
        zzazj zzazj = this.zza;
        zzazj.zze.zzc(zzazj.zzb, zzazj.zzc, (String) obj, zzazj.zzd);
    }
}
