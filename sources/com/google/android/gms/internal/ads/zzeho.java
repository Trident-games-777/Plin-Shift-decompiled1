package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeho implements zzefd {
    private final zzdqd zza;

    public zzeho(zzdqd zzdqd) {
        this.zza = zzdqd;
    }

    public final zzefe zza(String str, JSONObject jSONObject) throws zzffv {
        return new zzefe(this.zza.zzc(str, jSONObject), new zzegx(), str);
    }
}
