package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvn implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzdvn(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
        this.zzh = zzhgp10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zzd).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zze).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzdvr zzdvr = new zzdvr();
        zzdvr zzdvr2 = zzdvr;
        zzdvr zzdvr3 = new zzdvr();
        zzdvr zzdvr4 = zzdvr3;
        String zza4 = ((zzchv) this.zzh).zzb();
        String str = zza4;
        zzdvk zzdvk = new zzdvk((zzdvv) this.zza.zzb(), (zzdwm) this.zzb.zzb(), (zzduw) this.zzc.zzb(), zza2, zza3, (zzdvf) this.zzf.zzb(), (zzdwh) this.zzg.zzb(), zzdvr, zzdvr3, zza4);
        zzdvk zzdvk2 = zzdvk;
        return zzdvk;
    }
}
