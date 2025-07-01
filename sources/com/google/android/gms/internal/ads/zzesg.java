package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesg implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzesg(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeun zzeun;
        zzets zza2 = zzetu.zza();
        zzets zzets = zza2;
        zzeqp zzeqp = (zzeqp) this.zza.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (((List) this.zzb.zzb()).contains("24")) {
            zzeun = new zzeun(zzeqp, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlS)).intValue(), scheduledExecutorService);
        } else {
            zzeun = new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzlS)).intValue(), scheduledExecutorService);
        }
        return zzeun;
    }
}
