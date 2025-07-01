package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfjj {
    /* access modifiers changed from: private */
    public static final ListenableFuture zza = zzgei.zzh((Object) null);
    /* access modifiers changed from: private */
    public final zzges zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfjk zzd;

    public zzfjj(zzges zzges, ScheduledExecutorService scheduledExecutorService, zzfjk zzfjk) {
        this.zzb = zzges;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfjk;
    }

    public final zzfiz zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfiz(this, obj, Arrays.asList(listenableFutureArr), (zzfji) null);
    }

    public final zzfjh zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfjh(this, obj, (String) null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture, (zzfji) null);
    }

    /* access modifiers changed from: protected */
    public abstract String zzf(Object obj);
}
