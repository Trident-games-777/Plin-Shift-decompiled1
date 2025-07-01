package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxr implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzdxr(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp4;
        this.zzc = zzhgp5;
    }

    /* renamed from: zza */
    public final zzdxq zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzges zzc3 = zzfir.zzc();
        zzges zzges2 = zzc3;
        zzdyj zza2 = ((zzdyk) this.zzb).zzb();
        zzdyj zzdyj = zza2;
        return new zzdxq((ScheduledExecutorService) this.zza.zzb(), zzc2, zzc3, zza2, zzhfw.zza(zzhgi.zza(this.zzc)));
    }
}
