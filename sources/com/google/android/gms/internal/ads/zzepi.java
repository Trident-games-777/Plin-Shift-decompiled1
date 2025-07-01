package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepi implements zzevz {
    private final Executor zza;
    private final zzbzz zzb;

    zzepi(Executor executor, zzbzz zzbzz) {
        this.zza = executor;
        this.zzb = zzbzz;
    }

    public final int zza() {
        return 10;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcV)).booleanValue()) {
            return zzgei.zzh((Object) null);
        }
        return zzgei.zzm(this.zzb.zzk(), new zzeph(), this.zza);
    }
}
