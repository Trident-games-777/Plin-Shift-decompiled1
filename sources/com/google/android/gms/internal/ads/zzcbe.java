package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbe implements Runnable {
    final /* synthetic */ zzcbj zza;

    zzcbe(zzcbj zzcbj) {
        this.zza = zzcbj;
    }

    public final void run() {
        zzcbj zzcbj = this.zza;
        if (zzcbj.zzq != null) {
            zzcbj.zzq.zzh();
        }
    }
}
