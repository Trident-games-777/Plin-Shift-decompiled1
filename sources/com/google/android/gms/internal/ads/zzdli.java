package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdli implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdli(zzdlb zzdlb, zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdom zza2 = ((zzdon) this.zza).zzb();
        zzdom zzdom = zza2;
        zzded zzded = new zzded(zza2, (Executor) this.zzb.zzb());
        zzded zzded2 = zzded;
        return zzded;
    }
}
