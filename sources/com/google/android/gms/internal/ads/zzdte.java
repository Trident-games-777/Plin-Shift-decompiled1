package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdte implements zzhfx {
    private final zzdta zza;
    private final zzhgp zzb;

    public zzdte(zzdta zzdta, zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzdta;
        this.zzb = zzhgp;
    }

    public static Set zza(zzdta zzdta, zzdtk zzdtk, Executor executor) {
        Set zzd = zzdta.zzd(zzdtk, executor);
        zzhgf.zzb(zzd);
        Set set = zzd;
        return zzd;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza(this.zza, (zzdtk) this.zzb.zzb(), zzfin.zzc());
    }
}
