package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdmb implements zzfwh {
    public final /* synthetic */ zzdmg zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdmb(zzdmg zzdmg, JSONObject jSONObject) {
        this.zza = zzdmg;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
