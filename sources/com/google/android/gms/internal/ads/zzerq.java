package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzerq implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzerq(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeom zza2 = ((zzeoo) this.zza).zzb();
        zzeom zzeom = zza2;
        return new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzma)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
