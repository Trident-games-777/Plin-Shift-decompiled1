package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgfe extends zzgdy {
    /* access modifiers changed from: private */
    @CheckForNull
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    @CheckForNull
    public ScheduledFuture zzb;

    static ListenableFuture zzf(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgfe zzgfe = new zzgfe(listenableFuture);
        zzgfb zzgfb = new zzgfb(zzgfe);
        zzgfe.zzb = scheduledExecutorService.schedule(zzgfb, j, timeUnit);
        listenableFuture.addListener(zzgfb, zzgdw.INSTANCE);
        return zzgfe;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }

    private zzgfe(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        ListenableFuture listenableFuture2 = listenableFuture;
        this.zza = listenableFuture;
    }
}
