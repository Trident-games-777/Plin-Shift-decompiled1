package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgeg {
    private final boolean zza;
    private final zzfzo zzb;

    /* synthetic */ zzgeg(boolean z, zzfzo zzfzo, zzgeh zzgeh) {
        this.zza = z;
        this.zzb = zzfzo;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzgdv(this.zzb, this.zza, executor, callable);
    }
}
