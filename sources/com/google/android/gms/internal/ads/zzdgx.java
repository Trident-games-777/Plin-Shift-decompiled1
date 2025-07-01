package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdgx implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;

    public zzdgx(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzcfk zza3 = ((zzdgi) this.zzb).zza();
        zzcfk zzcfk = zza3;
        zzfet zza4 = ((zzcsh) this.zzc).zza();
        zzfet zzfet = zza4;
        VersionInfoParcel zza5 = ((zzcid) this.zzd).zza();
        VersionInfoParcel versionInfoParcel = zza5;
        return new zzdgw(zza2, zza3, zza4, zza5, (zzbbs.zza.C0000zza) this.zze.zzb(), (zzeeu) this.zzf.zzb());
    }
}
