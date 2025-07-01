package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesb implements zzhfx {
    private final zzhgp zza;

    public zzesb(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzesv zza2 = zzesx.zza();
        zzesv zzesv = zza2;
        return new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlU)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
