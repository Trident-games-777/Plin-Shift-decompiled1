package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqa {
    public static zzoz zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzoz.zza;
        }
        zzox zzox = new zzox();
        zzox.zza(true);
        zzox.zzc(z);
        return zzox.zzd();
    }
}
