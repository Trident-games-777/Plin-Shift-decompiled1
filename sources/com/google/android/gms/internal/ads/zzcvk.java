package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvk implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzcvk(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfet zza2 = ((zzcsh) this.zzb).zza();
        zzfet zzfet = zza2;
        String zza3 = ((zzcsi) this.zzd).zza();
        String str = zza3;
        return new zzcvj((zzcxe) this.zza.zzb(), zza2, (ScheduledExecutorService) this.zzc.zzb(), zzfin.zzc(), zza3);
    }
}
