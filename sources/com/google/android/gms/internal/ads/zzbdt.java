package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zza;
import com.google.android.gms.ads.nonagon.signalgeneration.zzj;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbdt implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzbdt(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    /* renamed from: zza */
    public final zzbds zzb() {
        return new zzbds((ScheduledExecutorService) this.zza.zzb(), (zzj) this.zzb.zzb(), (zza) this.zzc.zzb(), (zzdsr) this.zzd.zzb());
    }
}
