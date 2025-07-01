package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqt extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzqu zza;

    zzqt(zzqu zzqu) {
        this.zza = zzqu;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        audioTrack.equals(this.zza.zza.zzs);
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zza.zza.zzs)) {
            this.zza.zza.zzP = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        audioTrack.equals(this.zza.zza.zzs);
    }
}
