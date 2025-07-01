package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeup implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzeup(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo zza2 = ((zzdxg) this.zza).zzb();
        ApplicationInfo applicationInfo = zza2;
        Context zza3 = ((zzchq) this.zzc).zza();
        Context context = zza3;
        return new zzeuo(zza2, (PackageInfo) this.zzb.zzb(), zza3, (zzdsh) this.zzd.zzb());
    }
}
