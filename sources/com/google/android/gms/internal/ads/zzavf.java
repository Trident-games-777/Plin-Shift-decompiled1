package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzavf {
    private final ListenableFuture zza;

    public zzavf(Context context, Executor executor) {
        this.zza = zzgei.zzj(new zzave(this, context), executor);
    }

    public final ListenableFuture zza() {
        return this.zza;
    }
}
