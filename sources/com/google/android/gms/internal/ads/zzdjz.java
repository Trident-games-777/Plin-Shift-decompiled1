package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjz implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzdjz(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
        this.zzh = zzhgp9;
    }

    /* renamed from: zza */
    public final zzdjy zzb() {
        zzg zza2 = ((zzcho) this.zza).zzb();
        zzg zzg2 = zza2;
        zzffo zza3 = ((zzcwd) this.zzb).zza();
        zzffo zzffo = zza3;
        zzdiy zza4 = ((zzdjr) this.zzd).zza();
        zzdiy zzdiy = zza4;
        return new zzdjy(zza2, zza3, (zzdjd) this.zzc.zzb(), zza4, (zzdkk) this.zze.zzb(), (zzdks) this.zzf.zzb(), (Executor) this.zzg.zzb(), zzfin.zzc(), (zzdiv) this.zzh.zzb());
    }
}
