package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzclp {
    private final Map zza;
    private final Map zzb;

    zzclp(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfff zzfff) throws Exception {
        for (zzffd zzffd : zzfff.zzb.zzc) {
            if (this.zza.containsKey(zzffd.zza)) {
                ((zzcls) this.zza.get(zzffd.zza)).zza(zzffd.zzb);
            } else if (this.zzb.containsKey(zzffd.zza)) {
                zzclr zzclr = (zzclr) this.zzb.get(zzffd.zza);
                JSONObject jSONObject = zzffd.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzclr.zza(hashMap);
            }
        }
    }
}
