package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfkb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzfkb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzebv zza4 = zzcik.zza();
        zzebv zzebv = zza4;
        zzbwf zza5 = zzcin.zza();
        zzbwf zzbwf = zza5;
        zzfko zzfko = new zzfko(zza2, zza3, (zzdqa) this.zzc.zzb(), zza4, zza5);
        zzfko zzfko2 = zzfko;
        return zzfko;
    }
}
