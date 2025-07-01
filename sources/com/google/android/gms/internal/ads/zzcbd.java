package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbd implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcbj zzc;

    zzcbd(zzcbj zzcbj, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcbj;
    }

    public final void run() {
        zzcbj zzcbj = this.zzc;
        if (zzcbj.zzq != null) {
            zzcbj.zzq.zzb(this.zza, this.zzb);
        }
    }
}
