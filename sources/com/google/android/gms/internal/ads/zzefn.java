package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzefn implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzefn(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzffo zza2 = ((zzcwd) this.zze).zza();
        zzffo zzffo = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzf).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzbju zzbju = new zzbju();
        zzbju zzbju2 = zzbju;
        return new zzefm((zzcor) this.zza.zzb(), (Context) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzdpn) this.zzd.zzb(), zza2, zza3, zzbju, (zzeea) this.zzg.zzb(), (zzdsh) this.zzh.zzb());
    }
}
