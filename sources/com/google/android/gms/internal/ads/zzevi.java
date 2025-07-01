package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzevi implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzevi(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzffo zza2 = ((zzcwd) this.zze).zza();
        zzffo zzffo = zza2;
        return new zzevg(zzc2, (ScheduledExecutorService) this.zza.zzb(), (String) this.zzb.zzb(), (zzelo) this.zzc.zzb(), (Context) this.zzd.zzb(), zza2, (zzelk) this.zzf.zzb(), (zzdqd) this.zzg.zzb(), (zzdur) this.zzh.zzb());
    }
}
