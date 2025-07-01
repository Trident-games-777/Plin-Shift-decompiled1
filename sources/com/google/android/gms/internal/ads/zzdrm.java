package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrm implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzdrm(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String str = (String) this.zza.zzb();
        Context zza2 = ((zzchq) this.zzb).zza();
        Context context = zza2;
        Executor zzc2 = zzfin.zzc();
        Map zzd = ((zzhgb) this.zzc).zzb();
        Map map = zzd;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeV)).booleanValue()) {
            zzbbl zzbbl = new zzbbl(new zzbbr(zza2));
            zzbbl.zzb(new zzdrn(str));
            set = Collections.singleton(new zzded(new zzdrp(zzbbl, zzd), zzc2));
        } else {
            set = Collections.emptySet();
        }
        zzhgf.zzb(set);
        Set set2 = set;
        return set;
    }
}
