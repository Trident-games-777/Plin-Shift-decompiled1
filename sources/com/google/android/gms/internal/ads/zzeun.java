package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeun implements zzevz {
    private final zzevz zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzeun(zzevz zzevz, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzevz;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzb2 = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcq)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            zzb2 = zzgei.zzo(zzb2, j, timeUnit, this.zzc);
        }
        return zzgei.zzf(zzb2, Throwable.class, new zzeum(this), zzcaj.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcp)).booleanValue()) {
            zzevz zzevz = this.zza;
            zzbzz zzp = zzv.zzp();
            int zza2 = zzevz.zza();
            zzp.zzw(th, "OptionalSignalTimeout:" + zza2);
        }
        return zzgei.zzh((Object) null);
    }
}
