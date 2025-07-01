package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgcv extends zzgcx {
    zzgcv(ListenableFuture listenableFuture, Class cls, zzgdp zzgdp) {
        super(listenableFuture, cls, zzgdp);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgdp zzgdp = (zzgdp) obj;
        ListenableFuture zza = zzgdp.zza(th);
        zzfwq.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdp);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
