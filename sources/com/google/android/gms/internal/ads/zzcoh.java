package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcoh implements Runnable {
    public final /* synthetic */ zzcoi zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcoh(zzcoi zzcoi, JSONObject jSONObject) {
        this.zza = zzcoi;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
