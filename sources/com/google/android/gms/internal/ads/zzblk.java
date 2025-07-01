package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzblk implements zzgdp {
    final /* synthetic */ zzblc zza;

    zzblk(zzblo zzblo, zzblc zzblc) {
        this.zza = zzblc;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcao zzcao = new zzcao();
        ((zzbli) obj).zze(this.zza, new zzblj(this, zzcao));
        return zzcao;
    }
}
