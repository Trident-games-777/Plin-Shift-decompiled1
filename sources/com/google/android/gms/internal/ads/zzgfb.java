package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgfb implements Runnable {
    @CheckForNull
    zzgfe zza;

    zzgfb(zzgfe zzgfe) {
        this.zza = zzgfe;
    }

    public final void run() {
        ListenableFuture zze;
        String str;
        zzgfe zzgfe = this.zza;
        if (zzgfe != null && (zze = zzgfe.zza) != null) {
            this.zza = null;
            if (zze.isDone()) {
                zzgfe.zzs(zze);
                return;
            }
            try {
                ScheduledFuture zzv = zzgfe.zzb;
                zzgfe.zzb = null;
                str = "Timed out";
                if (zzv != null) {
                    long abs = Math.abs(zzv.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                zzgfe.zzd(new zzgfc(str + ": " + zze.toString(), (zzgfd) null));
                zze.cancel(true);
            } catch (Throwable th) {
                zze.cancel(true);
                throw th;
            }
        }
    }
}
