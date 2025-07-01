package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcag implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    zzcag() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzv.zzq();
                zzs.zzM(zzv.zzp().zzd(), th);
                throw th;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
