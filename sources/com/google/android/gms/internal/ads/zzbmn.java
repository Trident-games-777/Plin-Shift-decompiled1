package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbmn {
    public static void zza(zzbmo zzbmo, String str, Map map) {
        try {
            zzbmo.zze(str, zzbc.zzb().zzj(map));
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbmo zzbmo, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbmo.zza(sb.toString());
    }

    public static void zzc(zzbmo zzbmo, String str, String str2) {
        zzbmo.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbmo zzbmo, String str, JSONObject jSONObject) {
        zzbmo.zzb(str, jSONObject.toString());
    }
}
