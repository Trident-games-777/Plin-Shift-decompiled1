package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzexy implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzexy(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    public static zzexw zza(String str, zzbao zzbao, zzbzz zzbzz, ScheduledExecutorService scheduledExecutorService, zzges zzges) {
        return new zzexw(str, zzbao, zzbzz, scheduledExecutorService, zzges);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        String zza2 = ((zzeyw) this.zza).zza();
        String str = zza2;
        zzbao zza3 = zzclc.zza();
        zzbao zzbao = zza3;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        return new zzexw(zza2, zza3, (zzbzz) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzc2);
    }
}
