package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzebe implements zzbob {
    zzebe() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzebf zzebf = (zzebf) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziS)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzebf.zzd.zzg());
            jSONObject2.put("ad_request_post_body", zzebf.zzd.zzf());
        }
        jSONObject2.put("base_url", zzebf.zzd.zzd());
        jSONObject2.put("signals", zzebf.zzc);
        jSONObject3.put("body", zzebf.zzb.zzc);
        jSONObject3.put("headers", zzbc.zzb().zzj(zzebf.zzb.zzb));
        jSONObject3.put("response_code", zzebf.zzb.zza);
        jSONObject3.put("latency", zzebf.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzebf.zzd.zzi());
        return jSONObject;
    }
}
