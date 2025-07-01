package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcsc implements zzgdp {
    public final /* synthetic */ zzcsf zza;
    public final /* synthetic */ zzgee zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzcsc(zzcsf zzcsf, zzgee zzgee, ListenableFuture listenableFuture) {
        this.zza = zzcsf;
        this.zzb = zzgee;
        this.zzc = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, (zzcrq) obj);
    }
}
