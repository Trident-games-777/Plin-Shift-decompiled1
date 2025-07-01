package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegw implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzegw(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp6;
    }

    /* renamed from: zza */
    public final zzegv zzb() {
        zzegc zza2 = ((zzegd) this.zzb).zzb();
        zzegc zzegc = zza2;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        return new zzegv((zzcqh) this.zza.zzb(), zza2, (zzcwo) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), zzc2, (zzdsh) this.zze.zzb());
    }
}
