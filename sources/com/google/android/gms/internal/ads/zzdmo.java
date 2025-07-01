package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdmo implements zzgdp {
    public final /* synthetic */ zzdmy zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdmo(zzdmy zzdmy, JSONObject jSONObject) {
        this.zza = zzdmy;
        this.zzb = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (zzcfk) obj);
    }
}
