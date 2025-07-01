package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeyj implements zzevy {
    private final String zza;
    private final String zzb;

    public zzeyj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject zzg = zzbr.zzg((JSONObject) obj, "pii");
            zzg.put("doritos", this.zza);
            zzg.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            zze.zza("Failed putting doritos string.");
        }
    }
}
