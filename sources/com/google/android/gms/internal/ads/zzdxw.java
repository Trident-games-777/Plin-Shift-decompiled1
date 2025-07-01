package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxw implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzdxw(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzffo zza3 = ((zzcwd) this.zzb).zza();
        zzffo zzffo = zza3;
        zzdwv zza4 = ((zzdww) this.zzc).zzb();
        zzdwv zzdwv = zza4;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        return new zzdxv(zza2, zza3, zza4, zzc2, (ScheduledExecutorService) this.zzd.zzb(), (zzecl) this.zze.zzb(), (zzfkl) this.zzf.zzb());
    }
}
