package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzok {
    private static zzfzt<Integer> zzb() {
        zzfzs zzfzs = new zzfzs();
        zzfzs.zzg(8, 7);
        if (zzen.zza >= 31) {
            zzfzs.zzg(26, 27);
        }
        if (zzen.zza >= 33) {
            zzfzs.zzf(30);
        }
        return zzfzs.zzi();
    }

    public static boolean zza(AudioManager audioManager, zzow zzow) {
        AudioDeviceInfo[] audioDeviceInfoArr;
        if (zzow == null) {
            audioManager.getClass();
            AudioManager audioManager2 = audioManager;
            audioDeviceInfoArr = audioManager.getDevices(2);
        } else {
            audioDeviceInfoArr = new AudioDeviceInfo[]{zzow.zza};
        }
        zzfzt<Integer> zzb = zzb();
        for (AudioDeviceInfo type : audioDeviceInfoArr) {
            if (zzb.contains(Integer.valueOf(type.getType()))) {
                return true;
            }
        }
        return false;
    }
}
