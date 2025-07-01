package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcwz extends zzdcc implements zzcwq {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd = false;

    public zzcwz(zzcwy zzcwy, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        zzo(zzcwy, executor);
    }

    public final void zza(zze zze) {
        zzq(new zzcwr(zze));
    }

    public final void zzb() {
        zzq(new zzcws());
    }

    public final void zzc(zzdgu zzdgu) {
        if (!this.zzd) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzq(new zzcwu(zzdgu));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        synchronized (this) {
            zzm.zzg("Timeout waiting for show call succeed to be called.");
            zzc(new zzdgu("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        int intValue = ((Integer) zzbe.zzc().zza(zzbcn.zzkq)).intValue();
        this.zzc = this.zzb.schedule(new zzcwt(this), (long) intValue, TimeUnit.MILLISECONDS);
    }
}
