package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdws implements Callable {
    public final /* synthetic */ zzdwv zza;
    public final /* synthetic */ zzbvx zzb;

    public /* synthetic */ zzdws(zzdwv zzdwv, zzbvx zzbvx) {
        this.zza = zzdwv;
        this.zzb = zzbvx;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
