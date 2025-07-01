package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcpc implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzcpc(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public static zzcze zzc(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        zzcze zzcze = new zzcze(scheduledExecutorService, clock);
        zzcze zzcze2 = zzcze;
        return zzcze;
    }

    /* renamed from: zza */
    public final zzcze zzb() {
        return zzc((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
