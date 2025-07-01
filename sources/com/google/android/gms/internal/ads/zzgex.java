package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgex extends zzgeu implements ScheduledExecutorService, zzges {
    final ScheduledExecutorService zza;

    zzgex(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgfh zze = zzgfh.zze(runnable, (Object) null);
        return new zzgev(zze, scheduledExecutorService.schedule(zze, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgew zzgew = new zzgew(runnable);
        return new zzgev(zzgew, this.zza.scheduleAtFixedRate(zzgew, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgew zzgew = new zzgew(runnable);
        return new zzgev(zzgew, this.zza.scheduleWithFixedDelay(zzgew, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgfh zzgfh = new zzgfh(callable);
        return new zzgev(zzgfh, this.zza.schedule(zzgfh, j, timeUnit));
    }
}
