package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcqt implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzcqt(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzcqs zzb() {
        zzcfk zza2 = ((zzcqa) this.zza).zza();
        zzcfk zzcfk = zza2;
        return new zzcqs(zza2, (Executor) this.zzb.zzb());
    }
}
