package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbbd implements Runnable {
    public final /* synthetic */ zzbbf zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzbbd(zzbbf zzbbf, Future future) {
        this.zza = zzbbf;
        this.zzb = future;
    }

    public final void run() {
        if (this.zza.zzb.isCancelled()) {
            this.zzb.cancel(true);
        }
    }
}
