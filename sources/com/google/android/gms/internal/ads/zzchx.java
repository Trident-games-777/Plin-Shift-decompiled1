package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzchx implements zzhfx {
    private final zzhgp zza;

    public zzchx(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdur zzdur = (zzdur) this.zza.zzb();
        Executor zzc = zzfin.zzc();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbJ)).booleanValue()) {
            set = Collections.singleton(new zzded(zzdur, zzc));
        } else {
            set = Collections.emptySet();
        }
        zzhgf.zzb(set);
        Set set2 = set;
        return set;
    }
}
