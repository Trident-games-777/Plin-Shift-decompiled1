package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyu implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdyu(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
    }

    /* renamed from: zza */
    public final zzdyt zzb() {
        Map zzd = ((zzhge) this.zza).zzd();
        Map map = zzd;
        zzges zzc = zzfin.zzc();
        zzges zzges = zzc;
        zzczh zza2 = ((zzczi) this.zzb).zzb();
        zzczh zzczh = zza2;
        return new zzdyt(zzd, zzc, zza2);
    }
}
