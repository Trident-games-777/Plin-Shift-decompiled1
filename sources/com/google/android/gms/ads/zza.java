package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzei;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ AdLoader zza;
    public final /* synthetic */ zzei zzb;

    public /* synthetic */ zza(AdLoader adLoader, zzei zzei) {
        this.zza = adLoader;
        this.zzb = zzei;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
