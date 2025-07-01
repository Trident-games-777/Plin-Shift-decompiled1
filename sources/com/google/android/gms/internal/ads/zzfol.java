package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfol extends zzfoh {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfol(String str, Map map, String str2) {
        super(str);
        this.zzc = map;
    }

    public final void zzc() {
        long j;
        super.zzc();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzfok(this), Math.max(4000 - j, 2000));
        this.zza = null;
    }

    public final void zzi(zzfna zzfna, zzfmy zzfmy) {
        JSONObject jSONObject = new JSONObject();
        Map zzi = zzfmy.zzi();
        Iterator it = zzi.keySet().iterator();
        if (!it.hasNext()) {
            zzj(zzfna, zzfmy, jSONObject);
        } else {
            zzfnk zzfnk = (zzfnk) zzi.get((String) it.next());
            throw null;
        }
    }

    public final void zzo() {
        WebView webView = new WebView(zzfnw.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfoj(this));
        zzn(this.zza);
        zzfny.zzk(this.zza, (String) null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfnk zzfnk = (zzfnk) this.zzc.get((String) it.next());
        throw null;
    }
}
