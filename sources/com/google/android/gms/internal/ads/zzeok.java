package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeok implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzeok(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeoj((ListenableFuture) this.zza.zzb(), zzfin.zzc(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
