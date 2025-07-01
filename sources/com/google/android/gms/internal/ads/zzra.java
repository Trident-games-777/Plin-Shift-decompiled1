package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzra implements zzpr {
    final /* synthetic */ zzrc zza;

    /* synthetic */ zzra(zzrc zzrc, zzrb zzrb) {
        this.zza = zzrc;
    }

    public final void zza(Exception exc) {
        zzdt.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }
}
