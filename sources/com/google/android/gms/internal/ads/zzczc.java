package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzczc implements Runnable {
    private final WeakReference zza;

    /* synthetic */ zzczc(zzcze zzcze, zzczd zzczd) {
        this.zza = new WeakReference(zzcze);
    }

    public final void run() {
        zzcze zzcze = (zzcze) this.zza.get();
        if (zzcze != null) {
            zzcze.zzq(new zzcza());
        }
    }
}
