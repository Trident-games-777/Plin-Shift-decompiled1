package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeue implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzeue(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzffo zza2 = ((zzcwd) this.zza).zza();
        zzffo zzffo = zza2;
        zzg zza3 = ((zzcho) this.zzc).zzb();
        zzg zzg = zza3;
        return new zzeuc(zzc2, zza2, (PackageInfo) this.zzb.zzb(), zza3);
    }
}
