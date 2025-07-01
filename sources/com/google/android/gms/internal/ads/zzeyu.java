package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeyu implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzeyu(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbtk zza2 = zzcli.zza();
        zzbtk zzbtk = zza2;
        Context zza3 = ((zzchq) this.zzb).zza();
        Context context = zza3;
        return new zzeys(zza2, (ScheduledExecutorService) this.zza.zzb(), zza3);
    }
}
