package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzget implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgcy zzb;

    zzget(Executor executor, zzgcy zzgcy) {
        this.zza = executor;
        this.zzb = zzgcy;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }
}
