package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenz implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzenz(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzffo zza2 = ((zzcwd) this.zzb).zza();
        zzffo zzffo = zza2;
        return new zzenx((Clock) this.zza.zzb(), zza2);
    }
}
