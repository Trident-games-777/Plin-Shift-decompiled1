package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcmc implements zzcls {
    private final zzdvk zza;

    zzcmc(zzdvk zzdvk) {
        this.zza = zzdvk;
    }

    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziP)).booleanValue()) {
                this.zza.zzn(jSONObject);
            }
        }
    }
}
