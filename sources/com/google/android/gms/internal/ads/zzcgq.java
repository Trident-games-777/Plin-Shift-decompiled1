package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcgq {
    private final zzcgr zza;
    private final zzcgp zzb;

    public zzcgq(zzcgr zzcgr, zzcgp zzcgp) {
        this.zzb = zzcgp;
        this.zza = zzcgr;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzavc zzI = ((zzcgx) this.zza).zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaux zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (this.zza.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcgr zzcgr = this.zza;
            return zzc.zze(zzcgr.getContext(), str, ((zzcgz) zzcgr).zzF(), this.zza.zzi());
        }
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzavc zzI = ((zzcgx) this.zza).zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaux zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (this.zza.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcgr zzcgr = this.zza;
            return zzc.zzh(zzcgr.getContext(), ((zzcgz) zzcgr).zzF(), this.zza.zzi());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("URL is empty, ignoring message");
        } else {
            zzs.zza.post(new zzcgo(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        Uri parse = Uri.parse(str);
        zzcfs zzaO = ((zzcgj) this.zzb.zza).zzaO();
        if (zzaO == null) {
            zzm.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaO.zzj(parse);
        }
    }
}
