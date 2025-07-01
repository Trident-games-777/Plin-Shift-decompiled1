package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcnw implements Runnable {
    public final /* synthetic */ zzcfk zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcnw(zzcfk zzcfk, JSONObject jSONObject) {
        this.zza = zzcfk;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
