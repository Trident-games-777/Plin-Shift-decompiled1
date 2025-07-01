package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesj implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzesj(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeuu zza2 = ((zzeuw) this.zza).zzb();
        zzeuu zzeuu = zza2;
        return new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlP)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
