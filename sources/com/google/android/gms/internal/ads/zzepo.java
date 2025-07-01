package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepo implements zzevz {
    final zzbzz zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzges zzd;
    private final Context zze;

    zzepo(Context context, zzbzz zzbzz, ScheduledExecutorService scheduledExecutorService, zzges zzges) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzda)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbzz;
        this.zzc = scheduledExecutorService;
        this.zzd = zzges;
    }

    public final int zza() {
        return 11;
    }

    public final ListenableFuture zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcW)).booleanValue()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzdb)).booleanValue()) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzcX)).booleanValue()) {
                    return zzgei.zzm(zzftq.zza(this.zzb.getAppSetIdInfo(), (CancellationTokenSource) null), new zzepl(), zzcaj.zzf);
                }
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzda)).booleanValue()) {
                    task = zzfgt.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzgei.zzh(new zzepp((String) null, -1));
                }
                ListenableFuture zzn = zzgei.zzn(zzftq.zza(task, (CancellationTokenSource) null), new zzepm(), zzcaj.zzf);
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzcY)).booleanValue()) {
                    zzn = zzgei.zzo(zzn, ((Long) zzbe.zzc().zza(zzbcn.zzcZ)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgei.zze(zzn, Exception.class, new zzepn(this), this.zzd);
            }
        }
        return zzgei.zzh(new zzepp((String) null, -1));
    }
}
