package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdpp implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;
    private final zzhgp zzi;

    public zzdpp(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcfx zza2 = zzckx.zza();
        zzcfx zzcfx = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzd).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zza zza4 = ((zzckf) this.zze).zza();
        zza zza5 = zza4;
        return new zzdpn(zza2, (Context) this.zza.zzb(), (zzavc) this.zzb.zzb(), (zzbdu) this.zzc.zzb(), zza3, zza4, (zzbbl) this.zzf.zzb(), (zzcze) this.zzg.zzb(), (zzeea) this.zzh.zzb(), (zzffs) this.zzi.zzb());
    }
}
