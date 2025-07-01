package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetv implements zzevz {
    private final zzfes zza;

    zzetv(zzfes zzfes) {
        this.zza = zzfes;
    }

    public final int zza() {
        return 25;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzh(new zzetw(this.zza));
    }
}
