package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzhh {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzhh(MediaCodec.CryptoInfo cryptoInfo, zzhi zzhi) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzhh zzhh, int i, int i2) {
        zzhh.zzb.set(i, i2);
        zzhh.zza.setPattern(zzhh.zzb);
    }
}
