package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfpe {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfpd zzd = null;

    public zzfpe() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfpd zzfpd = (zzfpd) this.zzc.poll();
        this.zzd = zzfpd;
        if (zzfpd != null) {
            zzfpd.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfpd zzfpd) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfpd zzfpd) {
        zzfpd.zzb(this);
        this.zzc.add(zzfpd);
        if (this.zzd == null) {
            zzc();
        }
    }
}
