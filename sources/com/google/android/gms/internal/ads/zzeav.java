package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeav implements Callable {
    public final /* synthetic */ zzebg zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzbvx zzd;
    public final /* synthetic */ zzfka zze;

    public /* synthetic */ zzeav(zzebg zzebg, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvx zzbvx, zzfka zzfka) {
        this.zza = zzebg;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzbvx;
        this.zze = zzfka;
    }

    public final Object call() {
        return this.zza.zzk(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
