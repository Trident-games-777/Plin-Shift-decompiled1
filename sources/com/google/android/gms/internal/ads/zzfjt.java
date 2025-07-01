package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfjt implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzfjt(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzges zzc = zzfin.zzc();
        zzges zzges = zzc;
        zzfjq zza2 = ((zzfju) this.zzb).zzb();
        zzfjq zzfjq = zza2;
        return new zzfjr(zzc, (ScheduledExecutorService) this.zza.zzb(), zza2);
    }
}
