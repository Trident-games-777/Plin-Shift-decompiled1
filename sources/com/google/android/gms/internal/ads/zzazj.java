package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzazj implements Runnable {
    final ValueCallback zza = new zzazi(this);
    final /* synthetic */ zzazb zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzazl zze;

    zzazj(zzazl zzazl, zzazb zzazb, WebView webView, boolean z) {
        this.zzb = zzazb;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzazl;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
