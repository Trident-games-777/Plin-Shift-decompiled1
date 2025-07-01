package com.google.android.gms.ads.nonagon.signalgeneration;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzges;
import java.util.Locale;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zze extends zzbkm {
    private final WebView zza;
    private final zza zzb;
    private final Executor zzc;
    private WebViewClient zzd;

    public zze(WebView webView, zza zza2, zzges zzges) {
        this.zza = webView;
        this.zzb = zza2;
        this.zzc = zzges;
    }

    private final void zzc() {
        this.zza.evaluateJavascript(String.format(Locale.getDefault(), (String) zzbe.zzc().zza(zzbcn.zzjr), new Object[]{this.zzb.zza()}), (ValueCallback) null);
    }

    /* access modifiers changed from: protected */
    public final WebViewClient getDelegate() {
        return this.zzd;
    }

    public final void onPageFinished(WebView webView, String str) {
        zzc();
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzc();
        super.onPageStarted(webView, str, bitmap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        try {
            zzv.zzq();
            WebViewClient webViewClient = this.zza.getWebViewClient();
            if (webViewClient != this) {
                if (webViewClient != null) {
                    this.zzd = webViewClient;
                }
                this.zza.setWebViewClient(this);
                zzc();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public final void zzb() {
        this.zzc.execute(new zzc(this));
    }
}
