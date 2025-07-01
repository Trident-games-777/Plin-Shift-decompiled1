package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlm implements Callable {
    public final /* synthetic */ zzfff zza;
    public final /* synthetic */ zzfet zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzdlm(zzdlr zzdlr, zzfff zzfff, zzfet zzfet, JSONObject jSONObject) {
        this.zza = zzfff;
        this.zzb = zzfet;
        this.zzc = jSONObject;
    }

    public final Object call() {
        zzdiy zzdiy = new zzdiy();
        JSONObject jSONObject = this.zzc;
        zzdiy.zzaa(jSONObject.optInt("template_id", -1));
        zzdiy.zzK(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        String optString = optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null;
        zzfff zzfff = this.zza;
        zzdiy.zzV(optString);
        zzffo zzffo = zzfff.zza.zza;
        if (zzffo.zzg.contains(Integer.toString(zzdiy.zzc()))) {
            if (zzdiy.zzc() == 3) {
                if (zzdiy.zzA() == null) {
                    throw new zzeiz(1, "No custom template id for custom template ad response.");
                } else if (!zzffo.zzh.contains(zzdiy.zzA())) {
                    throw new zzeiz(1, "Unexpected custom template id in the response.");
                }
            }
            zzfet zzfet = this.zzb;
            zzdiy.zzY(jSONObject.optDouble("rating", -1.0d));
            String optString2 = jSONObject.optString("headline", (String) null);
            if (zzfet.zzM) {
                zzv.zzq();
                optString2 = zzs.zzy() + " : " + optString2;
            }
            zzdiy.zzZ("headline", optString2);
            zzdiy.zzZ("body", jSONObject.optString("body", (String) null));
            zzdiy.zzZ("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdiy.zzZ("store", jSONObject.optString("store", (String) null));
            zzdiy.zzZ(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, (String) null));
            zzdiy.zzZ("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdiy;
        }
        throw new zzeiz(1, "Invalid template ID: " + zzdiy.zzc());
    }
}
