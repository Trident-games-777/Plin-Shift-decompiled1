package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzclq implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzclq(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzclp zzb() {
        Map zzd = ((zzhgb) this.zza).zzb();
        Map map = zzd;
        Map zzd2 = ((zzhgb) this.zzb).zzb();
        Map map2 = zzd2;
        return new zzclp(zzd, zzd2);
    }
}
