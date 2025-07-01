package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlx implements zzgdp {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdlx(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        if (((zzcfk) obj) != null) {
            return this.zza;
        }
        throw new zzeiz(1, "Retrieve Web View from image ad response failed.");
    }
}
