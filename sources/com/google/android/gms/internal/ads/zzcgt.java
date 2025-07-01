package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcgt extends zzcgs {
    public zzcgt(zzcfk zzcfk, zzbbl zzbbl, boolean z, zzeea zzeea) {
        super(zzcfk, zzbbl, z, zzeea);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzV(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
