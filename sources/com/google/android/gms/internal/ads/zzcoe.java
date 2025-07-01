package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcoe implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzcoe(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcny zzcny = (zzcny) this.zza.zzb();
        Executor zzc = zzfin.zzc();
        if (((JSONObject) this.zzb.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzded(zzcny, zzc));
        }
        zzhgf.zzb(set);
        Set set2 = set;
        return set;
    }
}
