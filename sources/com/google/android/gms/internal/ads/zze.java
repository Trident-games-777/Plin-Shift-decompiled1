package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zze {
    public final AudioAttributes zza;

    /* synthetic */ zze(zzg zzg, zzf zzf) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        if (zzen.zza >= 29) {
            zzc.zza(usage, 1);
        }
        if (zzen.zza >= 32) {
            zzd.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
