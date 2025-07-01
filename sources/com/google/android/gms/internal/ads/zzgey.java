package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgey {
    public static zzges zza(ExecutorService executorService) {
        if (executorService instanceof zzges) {
            return (zzges) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzgex((ScheduledExecutorService) executorService);
        }
        return new zzgeu(executorService);
    }

    public static Executor zzb() {
        return zzgdw.INSTANCE;
    }

    static Executor zzc(Executor executor, zzgcy zzgcy) {
        executor.getClass();
        return executor == zzgdw.INSTANCE ? executor : new zzget(executor, zzgcy);
    }
}
