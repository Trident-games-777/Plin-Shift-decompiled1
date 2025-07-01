package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzy implements zzfwh {
    public final /* synthetic */ zzbvx zza;

    public /* synthetic */ zzdzy(zzdzz zzdzz, zzbvx zzbvx) {
        this.zza = zzbvx;
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zza.zza;
        if (bundle == null) {
            return jSONObject;
        }
        try {
            JSONObject zzi = zzbc.zzb().zzi(bundle);
            try {
                zzbc.zzb().zzl(jSONObject, zzi);
                return jSONObject;
            } catch (JSONException unused) {
                return zzi;
            }
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}
