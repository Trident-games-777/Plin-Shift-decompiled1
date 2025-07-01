package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;

    public zzdyb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
    }

    /* renamed from: zza */
    public final zzdya zzb() {
        Context zza2 = ((zzchq) this.zzb).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzc).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzffo zza4 = ((zzcwd) this.zzd).zza();
        zzffo zzffo = zza4;
        return new zzdya((zzchk) this.zza.zzb(), zza2, zza3, zza4, zzfin.zzc(), (String) this.zze.zzb(), (zzfkl) this.zzf.zzb(), (zzdsh) this.zzg.zzb());
    }
}
