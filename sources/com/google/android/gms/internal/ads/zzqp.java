package com.google.android.gms.internal.ads;

import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqp {
    private final AudioTrack zza;
    private final zzov zzb;
    private AudioRouting.OnRoutingChangedListener zzc = new zzqo(this);

    public zzqp(AudioTrack audioTrack, zzov zzov) {
        this.zza = audioTrack;
        this.zzb = zzov;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    /* access modifiers changed from: private */
    public void zzc(AudioRouting audioRouting) {
        if (this.zzc != null && audioRouting.getRoutedDevice() != null) {
            this.zzb.zzh(audioRouting.getRoutedDevice());
        }
    }

    public void zzb() {
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = this.zzc;
        onRoutingChangedListener.getClass();
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener2 = onRoutingChangedListener;
        this.zza.removeOnRoutingChangedListener(onRoutingChangedListener);
        this.zzc = null;
    }
}
