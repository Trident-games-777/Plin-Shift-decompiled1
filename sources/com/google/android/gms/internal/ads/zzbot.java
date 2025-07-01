package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbot implements zzbkg {
    private final zzcao zza;

    public zzbot(zzbou zzbou, zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zza.zzd(new zzbnx());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zza.zzd(new zzbnx(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }
}
