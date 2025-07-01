package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdnq implements zzgdp {
    public final /* synthetic */ zzdoc zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzdnq(zzdoc zzdoc, String str, JSONObject jSONObject) {
        this.zza = zzdoc;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (zzcfk) obj);
    }
}
