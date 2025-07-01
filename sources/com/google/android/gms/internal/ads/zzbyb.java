package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbyb implements zzgee {
    final /* synthetic */ ListenableFuture zza;

    zzbyb(zzbyc zzbyc, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final void zza(Throwable th) {
        zzbyc.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzbyc.zzc.remove(this.zza);
    }
}
