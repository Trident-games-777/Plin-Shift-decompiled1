package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzcgs extends zzcfs {
    public zzcgs(zzcfk zzcfk, zzbbl zzbbl, boolean z, zzeea zzeea) {
        super(zzcfk, zzbbl, z, new zzbsj(zzcfk, zzcfk.zzE(), new zzbbv(zzcfk.getContext())), (zzbse) null, zzeea);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzV(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcfk)) {
            zzm.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcfk zzcfk = (zzcfk) webView;
        zzbyh zzbyh = this.zza;
        if (zzbyh != null) {
            zzbyh.zzd(str, map, 1);
        }
        zzfsb.zza();
        zzfsh zzfsh = zzfsh.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcfk.zzN() != null) {
            zzcfk.zzN().zzG();
        }
        if (zzcfk.zzO().zzi()) {
            str2 = (String) zzbe.zzc().zza(zzbcn.zzX);
        } else if (zzcfk.zzaF()) {
            str2 = (String) zzbe.zzc().zza(zzbcn.zzW);
        } else {
            str2 = (String) zzbe.zzc().zza(zzbcn.zzV);
        }
        zzv.zzq();
        return zzs.zzx(zzcfk.getContext(), zzcfk.zzn().afmaVersion, str2);
    }
}
