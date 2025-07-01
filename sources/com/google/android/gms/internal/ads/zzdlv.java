package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlv implements zzgdp {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdlv(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        zzcfk zzcfk = (zzcfk) obj;
        if (zzcfk != null && zzcfk.zzq() != null) {
            return this.zza;
        }
        throw new zzeiz(1, "Retrieve video view in html5 ad response failed.");
    }
}
