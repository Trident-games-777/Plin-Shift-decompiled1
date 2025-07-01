package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdfu implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzdfu(zzdfn zzdfn, zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzfet zza3 = ((zzcsh) this.zzc).zza();
        zzfet zzfet = zza3;
        zzffo zza4 = ((zzcwd) this.zzd).zza();
        zzffo zzffo = zza4;
        zzded zzded = new zzded(new zzdfl((Context) this.zza.zzb(), zza2, zza3, zza4), zzcaj.zzf);
        zzded zzded2 = zzded;
        return zzded;
    }
}
