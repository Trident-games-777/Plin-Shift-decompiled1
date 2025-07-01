package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzc implements zzgdp {
    public final /* synthetic */ zzbvx zza;

    public /* synthetic */ zzdzc(zzbvx zzbvx) {
        this.zza = zzbvx;
    }

    public final ListenableFuture zza(Object obj) {
        String str = new String(zzgce.zzb((InputStream) obj), StandardCharsets.UTF_8);
        zzbvx zzbvx = this.zza;
        zzbvx.zzj = str;
        return zzgei.zzh(zzbvx);
    }
}
