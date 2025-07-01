package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesz implements zzevz {
    private final Context zza;
    private final zzges zzb;

    zzesz(zzges zzges, Context context) {
        this.zzb = zzges;
        this.zza = context;
    }

    public final int zza() {
        return 57;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzesy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeta zzc() throws Exception {
        zzv.zzq();
        return new zzeta(zzs.zzs(this.zza));
    }
}
