package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdmd implements zzgdp {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdmd(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return obj != null ? this.zza : zzgei.zzg(new zzeiz(1, "Retrieve required value in native ad response failed."));
    }
}
