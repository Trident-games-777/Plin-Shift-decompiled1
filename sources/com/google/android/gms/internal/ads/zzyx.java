package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzyx implements Runnable {
    public final /* synthetic */ ExecutorService zza;

    public /* synthetic */ zzyx(ExecutorService executorService) {
        this.zza = executorService;
    }

    public final void run() {
        this.zza.shutdown();
    }
}
