package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdqx implements zzhfx {
    private final zzhgp zza;

    public zzdqx(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        Executor zzc = zzfin.zzc();
        zzdrp zza2 = ((zzdrq) this.zza).zzb();
        zzdrp zzdrp = zza2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeV)).booleanValue()) {
            set = Collections.singleton(new zzded(zza2, zzc));
        } else {
            set = Collections.emptySet();
        }
        zzhgf.zzb(set);
        Set set2 = set;
        return set;
    }
}
