package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeoj implements zzevz {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzeoj(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return 6;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzn = zzgei.zzn(this.zza, new zzeof(), this.zzb);
        if (((Integer) zzbe.zzc().zza(zzbcn.zzmg)).intValue() > 0) {
            zzbce zzbce = zzbcn.zzmg;
            zzn = zzgei.zzo(zzn, (long) ((Integer) zzbe.zzc().zza(zzbce)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgei.zzf(zzn, Throwable.class, new zzeog(), this.zzb);
    }
}
