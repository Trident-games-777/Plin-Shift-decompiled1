package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdky implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzdky(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdiy zza2 = ((zzdjr) this.zza).zza();
        zzdiy zzdiy = zza2;
        zzdjd zza3 = ((zzdhz) this.zzb).zzb();
        zzdjd zzdjd = zza3;
        return new zzdkx(zza2, zza3, (Executor) this.zzc.zzb(), zzfin.zzc());
    }
}
