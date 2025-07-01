package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzom {
    public static zzop zza(AudioManager audioManager, zzg zzg) {
        List directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(zzg.zza().zza);
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(zzgcr.zzg(12)));
        for (int i = 0; i < directProfilesForAttributes.size(); i++) {
            AudioProfile audioProfile = (AudioProfile) directProfilesForAttributes.get(i);
            if (audioProfile.getEncapsulationType() != 1) {
                int format = audioProfile.getFormat();
                if (zzen.zzJ(format) || zzop.zzb.containsKey(Integer.valueOf(format))) {
                    Integer valueOf = Integer.valueOf(format);
                    if (hashMap.containsKey(valueOf)) {
                        Set set = (Set) hashMap.get(valueOf);
                        set.getClass();
                        Set set2 = set;
                        set.addAll(zzgcr.zzg(audioProfile.getChannelMasks()));
                    } else {
                        hashMap.put(valueOf, new HashSet(zzgcr.zzg(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        zzfzl zzfzl = new zzfzl();
        for (Map.Entry entry : hashMap.entrySet()) {
            zzfzl.zzf(new zzon(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzop(zzfzl.zzi());
    }

    public static zzow zzb(AudioManager audioManager, zzg zzg) {
        if (audioManager != null) {
            try {
                AudioManager audioManager2 = audioManager;
                List audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(zzg.zza().zza);
                if (!audioDevicesForAttributes.isEmpty()) {
                    return new zzow((AudioDeviceInfo) audioDevicesForAttributes.get(0));
                }
            } catch (RuntimeException unused) {
            }
        } else {
            throw null;
        }
        return null;
    }
}
