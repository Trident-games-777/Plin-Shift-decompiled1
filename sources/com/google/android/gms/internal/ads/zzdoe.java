package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdoe implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;
    private final zzhgp zzi;
    private final zzhgp zzj;

    public zzdoe(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10, zzhgp zzhgp11) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
        this.zzj = zzhgp11;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzd).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zza zza4 = ((zzckf) this.zze).zza();
        zza zza5 = zza4;
        zzcfx zza6 = zzckx.zza();
        zzcfx zzcfx = zza6;
        return new zzdnz(zza2, (Executor) this.zzb.zzb(), (zzavc) this.zzc.zzb(), zza3, zza4, zza6, (zzedp) this.zzf.zzb(), (zzflr) this.zzg.zzb(), (zzdsm) this.zzh.zzb(), (zzeea) this.zzi.zzb(), (zzffs) this.zzj.zzb());
    }
}
