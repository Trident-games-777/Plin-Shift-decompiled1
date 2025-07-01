package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcps implements zzhfx {
    private final zzcpk zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzcps(zzcpk zzcpk, zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzcpk;
        this.zzb = zzhgp;
        this.zzc = zzhgp2;
        this.zzd = zzhgp3;
        this.zze = zzhgp4;
    }

    public static zzded zza(zzcpk zzcpk, Context context, VersionInfoParcel versionInfoParcel, zzfet zzfet, zzffo zzffo) {
        zzded zzded = new zzded(new zzcpi(context, versionInfoParcel, zzfet, zzffo), zzcaj.zzf);
        zzded zzded2 = zzded;
        return zzded;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzc).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzfet zza3 = ((zzcsh) this.zzd).zza();
        zzfet zzfet = zza3;
        zzffo zza4 = ((zzcwd) this.zze).zza();
        zzffo zzffo = zza4;
        return zza(this.zza, (Context) this.zzb.zzb(), zza2, zza3, zza4);
    }
}
