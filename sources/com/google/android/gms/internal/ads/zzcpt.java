package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcpt implements zzhfx {
    private final zzcpk zza;
    private final zzhgp zzb;

    public zzcpt(zzcpk zzcpk, zzhgp zzhgp) {
        this.zza = zzcpk;
        this.zzb = zzhgp;
    }

    public static Set zza(zzcpk zzcpk, zzcrf zzcrf) {
        Set singleton = Collections.singleton(new zzded(zzcrf, zzcaj.zzf));
        zzhgf.zzb(singleton);
        Set set = singleton;
        return singleton;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return zza(this.zza, (zzcrf) this.zzb.zzb());
    }
}
