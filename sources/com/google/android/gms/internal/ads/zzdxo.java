package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdxo implements Callable {
    public final /* synthetic */ zzdxq zza;
    public final /* synthetic */ zzbvx zzb;

    public /* synthetic */ zzdxo(zzdxq zzdxq, zzbvx zzbvx) {
        this.zza = zzdxq;
        this.zzb = zzbvx;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
