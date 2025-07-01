package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzges;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzak implements Runnable {
    public final /* synthetic */ zzat zza;
    public final /* synthetic */ zzges zzb;

    public /* synthetic */ zzak(zzat zzat, zzges zzges) {
        this.zza = zzat;
        this.zzb = zzges;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
