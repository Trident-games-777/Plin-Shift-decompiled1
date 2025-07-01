package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeya implements zzevz {
    final zzges zza;

    public zzeya(zzbba zzbba, zzges zzges, Context context) {
        this.zza = zzges;
    }

    public final int zza() {
        return 45;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzexz(this));
    }
}
