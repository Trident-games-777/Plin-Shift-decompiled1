package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcgk implements Runnable {
    public final /* synthetic */ zzcgm zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcgk(zzcgm zzcgm, Map map) {
        this.zza = zzcgm;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
