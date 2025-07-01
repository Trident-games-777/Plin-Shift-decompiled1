package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcqd implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzcqd(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeth zza2 = ((zzetj) this.zza).zzb();
        zzeth zzeth = zza2;
        return new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzmf)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
