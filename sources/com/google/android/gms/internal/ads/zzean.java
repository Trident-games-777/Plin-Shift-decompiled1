package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzean implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzean(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzeam zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzeam(zza2, (ScheduledExecutorService) this.zzb.zzb());
    }
}
