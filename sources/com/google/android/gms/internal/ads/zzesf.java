package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesf implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzesf(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeto zza2 = ((zzetq) this.zza).zzb();
        zzeto zzeto = zza2;
        return new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlT)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
