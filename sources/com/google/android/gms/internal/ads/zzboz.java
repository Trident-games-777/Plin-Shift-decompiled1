package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzboz {
    public final List zza;
    public final String zzb;
    public final String zzc;

    public zzboz(JSONObject jSONObject) throws JSONException {
        jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("allocation_id", (String) null);
        zzv.zzh();
        zzbpb.zza(jSONObject, "clickurl");
        zzv.zzh();
        zzbpb.zza(jSONObject, "imp_urls");
        zzv.zzh();
        zzbpb.zza(jSONObject, "downloaded_imp_urls");
        zzv.zzh();
        zzbpb.zza(jSONObject, "fill_urls");
        zzv.zzh();
        zzbpb.zza(jSONObject, "video_start_urls");
        zzv.zzh();
        zzbpb.zza(jSONObject, "video_complete_urls");
        zzv.zzh();
        zzbpb.zza(jSONObject, "video_reward_urls");
        jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzv.zzh();
            zzbpb.zza(optJSONObject, "manual_impression_urls");
        }
        if (optJSONObject != null) {
            optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.zzb = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            optJSONObject2.optString("class_name");
        }
        jSONObject.optString("html_template", (String) null);
        jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        if (optJSONObject3 != null) {
            optJSONObject3.toString();
        }
        zzv.zzh();
        zzbpb.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject4 != null) {
            optJSONObject4.toString();
        }
        this.zzc = jSONObject.optString("response_type", (String) null);
        jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
