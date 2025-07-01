package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzqd implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzpr zzb;
    public final /* synthetic */ Handler zzc;
    public final /* synthetic */ zzpo zzd;

    public /* synthetic */ zzqd(AudioTrack audioTrack, zzpr zzpr, Handler handler, zzpo zzpo) {
        this.zza = audioTrack;
        this.zzb = zzpr;
        this.zzc = handler;
        this.zzd = zzpo;
    }

    public final void run() {
        zzqw.zzI(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
