package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzceo implements Runnable {
    public final /* synthetic */ zzccf zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzceo(zzccf zzccf, Map map) {
        this.zza = zzccf;
        this.zzb = map;
    }

    public final void run() {
        int i = zzces.zza;
        this.zza.zzd("onGcacheInfoEvent", this.zzb);
    }
}
