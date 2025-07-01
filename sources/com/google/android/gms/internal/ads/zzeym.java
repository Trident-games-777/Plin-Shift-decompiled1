package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeym implements zzevz {
    final zzges zza;
    final List zzb;

    public zzeym(zzbbw zzbbw, zzges zzges, List list) {
        this.zza = zzges;
        this.zzb = list;
    }

    public final int zza() {
        return 48;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeyl(this));
    }
}
