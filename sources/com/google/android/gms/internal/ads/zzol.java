package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzol {
    public static int zza(int i, int i2, zzg zzg) {
        for (int i3 = 10; i3 > 0; i3--) {
            int zzi = zzen.zzi(i3);
            if (zzi != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzi).build(), zzg.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzfzo<Integer> zzb(zzg zzg) {
        zzfzl zzfzl = new zzfzl();
        zzgbu zze = zzop.zzb.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if (zzen.zza >= zzen.zzh(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zzg.zza().zza)) {
                zzfzl.zzf(Integer.valueOf(intValue));
            }
        }
        zzfzl.zzf(2);
        return zzfzl.zzi();
    }
}
