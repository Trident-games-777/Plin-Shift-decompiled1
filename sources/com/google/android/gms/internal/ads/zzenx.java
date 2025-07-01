package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenx implements zzevz {
    private final Clock zza;
    private final zzffo zzb;

    zzenx(Clock clock, zzffo zzffo) {
        this.zza = clock;
        this.zzb = zzffo;
    }

    public final int zza() {
        return 4;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzh(new zzeny(this.zzb, this.zza.currentTimeMillis()));
    }
}
