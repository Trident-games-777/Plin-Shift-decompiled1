package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbh implements Runnable {
    final /* synthetic */ zzcbj zza;

    zzcbh(zzcbj zzcbj) {
        this.zza = zzcbj;
    }

    public final void run() {
        zzcbj zzcbj = this.zza;
        if (zzcbj.zzq != null) {
            if (!zzcbj.zzr) {
                zzcbj.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
