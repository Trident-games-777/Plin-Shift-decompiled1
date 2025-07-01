package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzehr implements zzgdp {
    public final /* synthetic */ zzehv zza;
    public final /* synthetic */ zzdoc zzb;

    public /* synthetic */ zzehr(zzehv zzehv, zzdoc zzdoc) {
        this.zza = zzehv;
        this.zzb = zzdoc;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (JSONObject) obj);
    }
}
