package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnc implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzcnc(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzg zza3 = ((zzcho) this.zzb).zzb();
        zzg zzg = zza3;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        return new zzcnb(zza2, zza3, (zzeex) this.zzc.zzb(), (zzdps) this.zzd.zzb(), zzc2, (zzges) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb());
    }
}
