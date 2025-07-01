package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfok implements Runnable {
    final /* synthetic */ zzfol zza;
    private final WebView zzb;

    zzfok(zzfol zzfol) {
        this.zza = zzfol;
        this.zzb = zzfol.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
