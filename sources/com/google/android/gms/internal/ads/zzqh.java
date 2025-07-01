package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzqh {
    public static void zza(AudioTrack audioTrack, zzow zzow) {
        audioTrack.setPreferredDevice(zzow == null ? null : zzow.zza);
    }
}
