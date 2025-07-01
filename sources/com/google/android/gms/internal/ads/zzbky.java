package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzbky implements OnH5AdsEventListener {
    public final /* synthetic */ WebView zza;

    public /* synthetic */ zzbky(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        int i = zzbkz.zza;
        this.zza.evaluateJavascript(str, (ValueCallback) null);
    }
}
