package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzfoh {
    private final String zza;
    private zzfpj zzb = new zzfpj((WebView) null);
    private long zzc;
    private int zzd;

    public zzfoh(String str) {
        zzb();
        this.zza = str;
    }

    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j) {
        if (j >= this.zzc && this.zzd != 3) {
            this.zzd = 3;
            zzfny.zza().zzh(zza(), this.zza, str);
        }
    }

    public final void zze() {
        zzfny.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzfmx zzfmx) {
        zzfny.zza().zzd(zza(), this.zza, zzfmx.zzb());
    }

    public final void zzg(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            zzfon.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
            zzfny.zza().zzf(zza(), jSONObject);
        }
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfny.zza().zzh(zza(), this.zza, str);
        }
    }

    public void zzi(zzfna zzfna, zzfmy zzfmy) {
        zzj(zzfna, zzfmy, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzfna zzfna, zzfmy zzfmy, JSONObject jSONObject) {
        String zzh = zzfna.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfon.zze(jSONObject2, "environment", "app");
        zzfon.zze(jSONObject2, "adSessionType", zzfmy.zzd());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzfon.zze(jSONObject3, "deviceType", str + "; " + str2);
        zzfon.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfon.zze(jSONObject3, "os", "Android");
        zzfon.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfon.zze(jSONObject2, "deviceCategory", zzfom.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfon.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfon.zze(jSONObject4, "partnerName", zzfmy.zze().zzb());
        zzfon.zze(jSONObject4, "partnerVersion", zzfmy.zze().zzc());
        zzfon.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfon.zze(jSONObject5, "libraryVersion", "1.4.14-google_20240908");
        zzfon.zze(jSONObject5, "appId", zzfnw.zzb().zza().getApplicationContext().getPackageName());
        zzfon.zze(jSONObject2, "app", jSONObject5);
        if (zzfmy.zzf() != null) {
            zzfon.zze(jSONObject2, "contentUrl", zzfmy.zzf());
        }
        if (zzfmy.zzg() != null) {
            zzfon.zze(jSONObject2, "customReferenceData", zzfmy.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfmy.zzh().iterator();
        if (!it.hasNext()) {
            zzfny.zza().zzj(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzfnk zzfnk = (zzfnk) it.next();
            throw null;
        }
    }

    public final void zzk(boolean z) {
        String str;
        if (zzp()) {
            if (true != z) {
                str = "backgrounded";
            } else {
                str = "foregrounded";
            }
            zzfny.zza().zzi(zza(), this.zza, str);
        }
    }

    public final void zzl(float f) {
        zzfny.zza().zze(zza(), this.zza, f);
    }

    public final void zzm(boolean z) {
        String str;
        if (zzp()) {
            if (true != z) {
                str = "unlocked";
            } else {
                str = "locked";
            }
            zzfny.zza().zzg(zza(), this.zza, str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(WebView webView) {
        this.zzb = new zzfpj(webView);
    }

    public void zzo() {
    }

    public final boolean zzp() {
        return this.zzb.get() != null;
    }
}
