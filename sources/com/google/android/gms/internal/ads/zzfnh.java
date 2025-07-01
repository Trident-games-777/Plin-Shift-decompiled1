package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnh {
    private final zzfnj zza;
    private final WebView zzb;
    private final HashMap zzc = new HashMap();
    private final zzfnv zzd = new zzfnv();

    private zzfnh(zzfnj zzfnj, WebView webView, boolean z) {
        zzfor.zza();
        this.zza = zzfnj;
        this.zzb = webView;
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            zzg();
            WebViewCompat.addWebMessageListener(webView, "omidJsSessionService", new HashSet(Arrays.asList(new String[]{ProxyConfig.MATCH_ALL_SCHEMES})), new zzfng(this));
            return;
        }
        throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
    }

    public static zzfnh zza(zzfnj zzfnj, WebView webView, boolean z) {
        return new zzfnh(zzfnj, webView, true);
    }

    static /* bridge */ /* synthetic */ void zzb(zzfnh zzfnh, String str) {
        zzfmw zzfmw = (zzfmw) zzfnh.zzc.get(str);
        if (zzfmw != null) {
            zzfmw.zzc();
            zzfnh.zzc.remove(str);
        }
    }

    static /* bridge */ /* synthetic */ void zzd(zzfnh zzfnh, String str) {
        zzfna zzfna = new zzfna(zzfmx.zza(zzfnb.DEFINED_BY_JAVASCRIPT, zzfne.DEFINED_BY_JAVASCRIPT, zzfni.JAVASCRIPT, zzfni.JAVASCRIPT, false), zzfmy.zzb(zzfnh.zza, zzfnh.zzb, (String) null, (String) null), str);
        zzfnh.zzc.put(str, zzfna);
        zzfna.zzd(zzfnh.zzb);
        for (zzfnu zzfnu : zzfnh.zzd.zza()) {
            zzfna.zzb((View) zzfnu.zzb().get(), zzfnu.zza(), zzfnu.zzc());
        }
        zzfna.zze();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        WebViewCompat.removeWebMessageListener(this.zzb, "omidJsSessionService");
    }

    public final void zze(View view, zzfnd zzfnd, String str) {
        for (zzfmw zzb2 : this.zzc.values()) {
            zzb2.zzb(view, zzfnd, "Ad overlay");
        }
        this.zzd.zzb(view, zzfnd, "Ad overlay");
    }

    public final void zzf(zzcfz zzcfz) {
        for (zzfmw zzc2 : this.zzc.values()) {
            zzc2.zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzfnf(this, zzcfz, timer), 1000);
    }
}
