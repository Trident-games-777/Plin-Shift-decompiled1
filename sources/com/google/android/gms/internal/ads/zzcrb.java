package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcrb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzcrb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcrp zza2 = ((zzcua) this.zza).zzb();
        zzcrp zzcrp = zza2;
        zzbhp zza3 = ((zzcra) this.zzb).zza();
        zzbhp zzbhp = zza3;
        Runnable zza4 = ((zzcqz) this.zzc).zza();
        Runnable runnable = zza4;
        return new zzcqw(zza2, zza3, zza4, (Executor) this.zzd.zzb());
    }
}
