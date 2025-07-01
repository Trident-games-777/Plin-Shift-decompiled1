package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbf implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcbj zzc;

    zzcbf(zzcbj zzcbj, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcbj;
    }

    public final void run() {
        zzcbj zzcbj = this.zzc;
        if (zzcbj.zzq != null) {
            zzcbj.zzq.zzj(this.zza, this.zzb);
        }
    }
}
