package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfis implements zzhfx {
    private final zzhgp zza;

    public zzfis(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzftc.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, (ThreadFactory) this.zza.zzb()));
        zzhgf.zzb(unconfigurableScheduledExecutorService);
        ScheduledExecutorService scheduledExecutorService = unconfigurableScheduledExecutorService;
        return unconfigurableScheduledExecutorService;
    }
}
