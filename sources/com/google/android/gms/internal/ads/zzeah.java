package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeah implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;

    public zzeah(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp7;
        this.zzh = zzhgp8;
    }

    /* renamed from: zza */
    public final zzeag zzb() {
        zzczh zza2 = ((zzczi) this.zza).zzb();
        zzczh zzczh = zza2;
        zzdzo zza3 = ((zzdzp) this.zzb).zzb();
        zzdzo zzdzo = zza3;
        zzffo zza4 = ((zzcwd) this.zzd).zza();
        zzffo zzffo = zza4;
        VersionInfoParcel zza5 = ((zzcid) this.zze).zza();
        VersionInfoParcel versionInfoParcel = zza5;
        Context zza6 = ((zzchq) this.zzh).zza();
        Context context = zza6;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        return new zzeag(zza2, zza3, (zzfjr) this.zzc.zzb(), zza4, zza5, (zzfko) this.zzf.zzb(), (zzfkl) this.zzg.zzb(), zza6, zzc2);
    }
}
