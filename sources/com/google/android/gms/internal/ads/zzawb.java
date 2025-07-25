package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzawb implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzawb() {
    }

    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.zzb;
        Thread newThread = this.zza.newThread(runnable);
        int andIncrement = atomicInteger.getAndIncrement();
        newThread.setName("gads-" + andIncrement);
        return newThread;
    }
}
