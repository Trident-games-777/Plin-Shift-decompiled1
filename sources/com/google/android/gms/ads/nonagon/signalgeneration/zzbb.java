package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbvx;
import com.google.android.gms.internal.ads.zzdxq;
import com.google.android.gms.internal.ads.zzgdp;
import com.google.android.gms.internal.ads.zzgei;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbb implements zzgdp {
    private final Executor zza;
    private final zzdxq zzb;

    public zzbb(Executor executor, zzdxq zzdxq) {
        this.zza = executor;
        this.zzb = zzdxq;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbvx zzbvx = (zzbvx) obj;
        return zzgei.zzn(this.zzb.zzc(zzbvx), new zzba(zzbvx), this.zza);
    }
}
