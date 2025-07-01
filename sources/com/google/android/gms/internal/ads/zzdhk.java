package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdhk implements zzhfx {
    private final zzhgp zza;

    public zzdhk(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdjj zza2 = ((zzdhh) this.zza).zza();
        zzdjj zzdjj = zza2;
        if (zza2.zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzhgf.zzb(set);
        Set set2 = set;
        return set;
    }
}
