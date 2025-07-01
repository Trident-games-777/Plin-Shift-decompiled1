package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzery implements zzhfx {
    private final zzhgp zza;

    public zzery(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzt zzfzt;
        zzeqr zza2 = zzeqt.zza();
        zzeqr zzeqr = zza2;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzef)).booleanValue()) {
            zzfzt = zzfzt.zzo(new zzeun(zza2, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzeg)).intValue(), scheduledExecutorService));
        } else {
            zzfzt = zzfzt.zzn();
        }
        zzhgf.zzb(zzfzt);
        return zzfzt;
    }
}
