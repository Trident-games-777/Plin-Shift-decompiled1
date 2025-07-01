package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyt implements zzdyv {
    private final Map zza;
    private final zzges zzb;
    /* access modifiers changed from: private */
    public final zzczh zzc;

    public zzdyt(Map map, zzges zzges, zzczh zzczh) {
        this.zza = map;
        this.zzb = zzges;
        this.zzc = zzczh;
    }

    public final ListenableFuture zzb(zzbvx zzbvx) {
        this.zzc.zzdn(zzbvx);
        ListenableFuture zzg = zzgei.zzg(new zzdwn(3));
        for (String trim : ((String) zzbe.zzc().zza(zzbcn.zzhR)).split(",")) {
            zzhgp zzhgp = (zzhgp) this.zza.get(trim.trim());
            if (zzhgp != null) {
                zzg = zzgei.zzf(zzg, zzdwn.class, new zzdyr(zzhgp, zzbvx), this.zzb);
            }
        }
        zzgei.zzr(zzg, new zzdys(this), zzcaj.zzf);
        return zzg;
    }
}
