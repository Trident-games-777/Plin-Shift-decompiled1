package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzsk {
    public final zzsq zza;
    public final MediaFormat zzb;
    public final zzad zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;
    public final zzsj zzf;

    private zzsk(zzsq zzsq, MediaFormat mediaFormat, zzad zzad, Surface surface, MediaCrypto mediaCrypto, zzsj zzsj) {
        this.zza = zzsq;
        this.zzb = mediaFormat;
        this.zzc = zzad;
        this.zzd = surface;
        this.zzf = zzsj;
    }

    public static zzsk zza(zzsq zzsq, MediaFormat mediaFormat, zzad zzad, MediaCrypto mediaCrypto, zzsj zzsj) {
        return new zzsk(zzsq, mediaFormat, zzad, (Surface) null, (MediaCrypto) null, zzsj);
    }

    public static zzsk zzb(zzsq zzsq, MediaFormat mediaFormat, zzad zzad, Surface surface, MediaCrypto mediaCrypto) {
        return new zzsk(zzsq, mediaFormat, zzad, surface, (MediaCrypto) null, (zzsj) null);
    }
}
