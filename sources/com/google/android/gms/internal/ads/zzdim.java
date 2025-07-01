package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdim implements Runnable {
    public final /* synthetic */ zzcfk zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdim(zzcfk zzcfk, JSONObject jSONObject) {
        this.zza = zzcfk;
        this.zzb = jSONObject;
    }

    public final void run() {
        int i = zzdit.zzc;
        this.zza.zze("onVideoEvent", this.zzb);
    }
}
