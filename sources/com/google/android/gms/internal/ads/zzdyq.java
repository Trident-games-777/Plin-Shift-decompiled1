package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyq implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdyq(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzdyp zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzdyp(zza2, (zzbyv) this.zzb.zzb());
    }
}
