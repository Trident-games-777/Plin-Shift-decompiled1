package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzor extends AudioDeviceCallback {
    final /* synthetic */ zzov zza;

    /* synthetic */ zzor(zzov zzov, zzou zzou) {
        this.zza = zzov;
    }

    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzov zzov = this.zza;
        this.zza.zzj(zzop.zzc(zzov.zza, zzov.zzh, zzov.zzg));
    }

    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzow zzd = this.zza.zzg;
        int i = zzen.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (Objects.equals(audioDeviceInfoArr[i2], zzd)) {
                this.zza.zzg = null;
                break;
            } else {
                i2++;
            }
        }
        zzov zzov = this.zza;
        zzov.zzj(zzop.zzc(zzov.zza, zzov.zzh, zzov.zzg));
    }
}
