package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegd implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;

    public zzegd(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
    }

    /* renamed from: zza */
    public final zzegc zzb() {
        zzffo zza2 = ((zzcwd) this.zze).zza();
        zzffo zzffo = zza2;
        return new zzegc((zzcqh) this.zza.zzb(), (Context) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzdpn) this.zzd.zzb(), zza2, (zzfwh) this.zzf.zzb(), (zzdsh) this.zzg.zzb());
    }
}
