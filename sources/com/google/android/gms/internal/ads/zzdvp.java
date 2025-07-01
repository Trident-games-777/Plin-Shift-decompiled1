package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvp implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzdvp(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        WeakReference zza3 = ((zzchr) this.zzb).zza();
        WeakReference weakReference = zza3;
        zzdwi zzdwi = new zzdwi();
        zzdwi zzdwi2 = zzdwi;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        zzdwh zzdwh = new zzdwh(zza2, zza3, (zzdvv) this.zzc.zzb(), zzdwi, zzc2);
        zzdwh zzdwh2 = zzdwh;
        return zzdwh;
    }
}
