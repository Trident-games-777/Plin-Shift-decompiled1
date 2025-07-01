package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgei extends zzgek {
    public static zzgeg zza(Iterable iterable) {
        return new zzgeg(false, zzfzo.zzk(iterable), (zzgeh) null);
    }

    public static zzgeg zzb(Iterable iterable) {
        return new zzgeg(true, zzfzo.zzk(iterable), (zzgeh) null);
    }

    @SafeVarargs
    public static zzgeg zzc(ListenableFuture... listenableFutureArr) {
        return new zzgeg(true, zzfzo.zzm(listenableFutureArr), (zzgeh) null);
    }

    public static ListenableFuture zzd(Iterable iterable) {
        return new zzgdq(zzfzo.zzk(iterable), true);
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzfwh zzfwh, Executor executor) {
        zzgcw zzgcw = new zzgcw(listenableFuture, cls, zzfwh);
        listenableFuture.addListener(zzgcw, zzgey.zzc(executor, zzgcw));
        return zzgcw;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzgdp zzgdp, Executor executor) {
        zzgcv zzgcv = new zzgcv(listenableFuture, cls, zzgdp);
        listenableFuture.addListener(zzgcv, zzgey.zzc(executor, zzgcv));
        return zzgcv;
    }

    public static ListenableFuture zzh(Object obj) {
        if (obj == null) {
            return zzgem.zza;
        }
        return new zzgem(obj);
    }

    public static ListenableFuture zzi() {
        return zzgem.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgfh zzgfh = new zzgfh(callable);
        executor.execute(zzgfh);
        return zzgfh;
    }

    public static ListenableFuture zzk(zzgdo zzgdo, Executor executor) {
        zzgfh zzgfh = new zzgfh(zzgdo);
        executor.execute(zzgfh);
        return zzgfh;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgdq(zzfzo.zzm(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzfwh zzfwh, Executor executor) {
        zzgde zzgde = new zzgde(listenableFuture, zzfwh);
        listenableFuture.addListener(zzgde, zzgey.zzc(executor, zzgde));
        return zzgde;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzgdp zzgdp, Executor executor) {
        int i = zzgdf.zzc;
        executor.getClass();
        zzgdd zzgdd = new zzgdd(listenableFuture, zzgdp);
        listenableFuture.addListener(zzgdd, zzgey.zzc(executor, zzgdd));
        return zzgdd;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return zzgfe.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgfj.zza(future);
        }
        throw new IllegalStateException(zzfxf.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgfj.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzgdx((Error) cause);
            }
            throw new zzgfi(cause);
        }
    }

    public static ListenableFuture zzg(Throwable th) {
        th.getClass();
        return new zzgel(th);
    }

    public static void zzr(ListenableFuture listenableFuture, zzgee zzgee, Executor executor) {
        zzgee.getClass();
        listenableFuture.addListener(new zzgef(listenableFuture, zzgee), executor);
    }
}
