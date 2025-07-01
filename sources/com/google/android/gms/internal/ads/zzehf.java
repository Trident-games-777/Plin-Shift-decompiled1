package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehf implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzehf(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9) {
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
        VersionInfoParcel zza2 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzffo zza3 = ((zzcwd) this.zzc).zza();
        zzffo zzffo = zza3;
        zzbju zzbju = new zzbju();
        zzbju zzbju2 = zzbju;
        return new zzehe((Context) this.zza.zzb(), zza2, zza3, (Executor) this.zzd.zzb(), (zzdgn) this.zze.zzb(), (zzdpn) this.zzf.zzb(), zzbju, (zzeea) this.zzg.zzb(), (zzdsh) this.zzh.zzb());
    }
}
