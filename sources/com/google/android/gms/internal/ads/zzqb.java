package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqb {
    public static zzoz zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzoz.zza;
        }
        zzox zzox = new zzox();
        boolean z2 = false;
        if (zzen.zza > 32 && playbackOffloadSupport == 2) {
            z2 = true;
        }
        zzox.zza(true);
        zzox.zzb(z2);
        zzox.zzc(z);
        return zzox.zzd();
    }
}
