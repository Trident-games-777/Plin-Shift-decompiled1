package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeys implements zzevz {
    final ScheduledExecutorService zza;

    public zzeys(zzbtk zzbtk, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    public final int zza() {
        return 49;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzm(zzgei.zzo(zzgei.zzh(new Bundle()), ((Long) zzbe.zzc().zza(zzbcn.zzej)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzeyr(), zzcaj.zza);
    }
}
