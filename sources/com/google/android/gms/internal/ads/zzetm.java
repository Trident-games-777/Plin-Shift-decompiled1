package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetm implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzetm(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzetk zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzetk(zza2, (Intent) this.zzb.zzb());
    }
}
