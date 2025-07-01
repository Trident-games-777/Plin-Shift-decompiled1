package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcvp implements Callable {
    public final /* synthetic */ zzcvq zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzcvp(zzcvq zzcvq, ListenableFuture listenableFuture, Bundle bundle) {
        this.zza = zzcvq;
        this.zzb = listenableFuture;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
