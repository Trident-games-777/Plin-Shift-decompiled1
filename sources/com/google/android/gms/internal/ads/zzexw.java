package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzexw implements zzevz {
    private final zzbzz zza;
    private final ScheduledExecutorService zzb;
    private final zzges zzc;

    zzexw(String str, zzbao zzbao, zzbzz zzbzz, ScheduledExecutorService scheduledExecutorService, zzges zzges) {
        this.zza = zzbzz;
        this.zzb = scheduledExecutorService;
        this.zzc = zzges;
    }

    public final int zza() {
        return 43;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcW)).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzdb)).booleanValue()) {
                ListenableFuture zzn = zzgei.zzn(zzftq.zza(Tasks.forResult(null), (CancellationTokenSource) null), new zzexu(), this.zzc);
                if (((Boolean) zzbea.zza.zze()).booleanValue()) {
                    zzn = zzgei.zzo(zzn, ((Long) zzbea.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgei.zze(zzn, Exception.class, new zzexv(this), this.zzc);
            }
        }
        return zzgei.zzh(new zzexx((String) null, -1));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexx zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzexx((String) null, -1);
    }
}
