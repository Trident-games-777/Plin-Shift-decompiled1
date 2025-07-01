package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbb implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcbj zzb;

    zzcbb(zzcbj zzcbj, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcbj;
    }

    public final void run() {
        zzcbj.zzl(this.zzb, this.zza);
        zzcbj zzcbj = this.zzb;
        if (zzcbj.zzq != null) {
            zzcbj.zzq.zzf();
        }
    }
}
