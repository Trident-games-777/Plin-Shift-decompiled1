package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzert implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzert(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeun zzeun;
        zzepi zza2 = ((zzepk) this.zza).zzb();
        zzepi zzepi = zza2;
        zzeqp zzeqp = (zzeqp) this.zzb.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        if (((List) this.zzc.zzb()).contains("10")) {
            zzeun = new zzeun(zzeqp, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlQ)).intValue(), scheduledExecutorService);
        } else {
            zzeun = new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlQ)).intValue(), scheduledExecutorService);
        }
        return zzeun;
    }
}
