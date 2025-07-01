package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzekf implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzekf(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeke((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzdow) this.zzc.zzb());
    }
}
