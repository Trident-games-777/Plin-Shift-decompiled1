package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfgn {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzges zzc;

    public zzfgn(Callable callable, zzges zzges) {
        this.zzb = callable;
        this.zzc = zzges;
    }

    public final synchronized ListenableFuture zza() {
        zzc(1);
        return (ListenableFuture) this.zza.poll();
    }

    public final synchronized void zzb(ListenableFuture listenableFuture) {
        this.zza.addFirst(listenableFuture);
    }

    public final synchronized void zzc(int i) {
        int size = i - this.zza.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
