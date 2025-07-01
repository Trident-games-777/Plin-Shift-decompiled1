package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzgdg implements Runnable {
    public final /* synthetic */ zzgdi zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzgdg(zzgdi zzgdi, int i, ListenableFuture listenableFuture) {
        this.zza = zzgdi;
        this.zzb = i;
        this.zzc = listenableFuture;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
