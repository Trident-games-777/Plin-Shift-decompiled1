package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzejq implements zzefd {
    private final Map zza = new HashMap();
    private final zzdqd zzb;

    public zzejq(zzdqd zzdqd) {
        this.zzb = zzdqd;
    }

    public final zzefe zza(String str, JSONObject jSONObject) throws zzffv {
        zzefe zzefe;
        synchronized (this) {
            zzefe = (zzefe) this.zza.get(str);
            if (zzefe == null) {
                zzefe = new zzefe(this.zzb.zzc(str, jSONObject), new zzegy(), str);
                this.zza.put(str, zzefe);
            }
        }
        return zzefe;
    }
}
