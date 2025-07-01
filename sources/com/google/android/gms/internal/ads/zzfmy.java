package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmy {
    private final zzfnj zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfmz zzg;

    private zzfmy(zzfnj zzfnj, WebView webView, String str, List list, String str2, String str3, zzfmz zzfmz) {
        this.zza = zzfnj;
        this.zzb = webView;
        this.zzg = zzfmz;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfmy zzb(zzfnj zzfnj, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzfor.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfmy(zzfnj, webView, (String) null, (List) null, str, str2, zzfmz.HTML);
    }

    public static zzfmy zzc(zzfnj zzfnj, WebView webView, String str, String str2) {
        zzfor.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfmy(zzfnj, webView, (String) null, (List) null, str, "", zzfmz.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfmz zzd() {
        return this.zzg;
    }

    public final zzfnj zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
