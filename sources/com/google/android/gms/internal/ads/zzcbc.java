package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbc implements Runnable {
    final /* synthetic */ zzcbj zza;

    zzcbc(zzcbj zzcbj) {
        this.zza = zzcbj;
    }

    public final void run() {
        zzcbj zzcbj = this.zza;
        if (zzcbj.zzq != null) {
            zzcbj.zzq.zza();
        }
    }
}
