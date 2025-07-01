package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgef implements Runnable {
    final Future zza;
    final zzgee zzb;

    zzgef(Future future, zzgee zzgee) {
        this.zza = future;
        this.zzb = zzgee;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzgfk) || (zza2 = zzgfl.zza((zzgfk) future)) == null) {
            try {
                this.zzb.zzb(zzgei.zzp(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Throwable th) {
                this.zzb.zza(th);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfwk zza2 = zzfwm.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
