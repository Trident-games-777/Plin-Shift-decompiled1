package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcsf {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcsf(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    static /* bridge */ /* synthetic */ void zzb(zzcsf zzcsf, List list, zzgee zzgee) {
        if (list == null || list.isEmpty()) {
            zzcsf.zza.execute(new zzcsa(zzgee));
            return;
        }
        ListenableFuture zzh = zzgei.zzh((Object) null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzh = zzgei.zzn(zzgei.zzf(zzh, Throwable.class, new zzcsb(zzgee), zzcsf.zza), new zzcsc(zzcsf, zzgee, (ListenableFuture) it.next()), zzcsf.zza);
        }
        zzgei.zzr(zzh, new zzcse(zzcsf, zzgee), zzcsf.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzgee zzgee, ListenableFuture listenableFuture, zzcrq zzcrq) throws Exception {
        if (zzcrq != null) {
            zzgee.zzb(zzcrq);
        }
        return zzgei.zzo(listenableFuture, ((Long) zzbfa.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgee zzgee) {
        zzgei.zzr(this.zzc, new zzcsd(this, zzgee), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
