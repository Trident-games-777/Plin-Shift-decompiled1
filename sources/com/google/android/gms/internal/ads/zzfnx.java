package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfnx implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    zzfnx(zzfny zzfny, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        zzfny.zzk(this.zza, this.zzb);
    }
}
