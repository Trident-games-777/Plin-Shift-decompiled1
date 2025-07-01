package com.google.android.gms.internal.ads;

import androidx.webkit.Profile;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcaj {
    public static final zzges zza;
    public static final zzges zzb;
    public static final zzges zzc;
    public static final ScheduledExecutorService zzd = new zzcae(3, new zzcaf("Schedule"));
    public static final zzges zze = new zzcah(new zzcag(), (zzcai) null);
    public static final zzges zzf = new zzcah(zzgey.zzb(), (zzcai) null);

    static {
        ExecutorService executorService;
        ExecutorService executorService2;
        ExecutorService executorService3;
        if (ClientLibraryUtils.isPackageSide()) {
            zzftc.zza();
            executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcaf(Profile.DEFAULT_PROFILE_NAME)));
        } else {
            if (zzbe.zzc().zzb(zzbcn.zzkU) != null) {
                if (((Boolean) zzbe.zzc().zzb(zzbcn.zzkU)).booleanValue()) {
                    if (zzbe.zzc().zzb(zzbcn.zzkV) != null) {
                        if (zzbe.zzc().zzb(zzbcn.zzkW) != null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzbe.zzc().zzb(zzbcn.zzkV)).intValue(), ((Integer) zzbe.zzc().zzb(zzbcn.zzkV)).intValue(), 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcaf(Profile.DEFAULT_PROFILE_NAME));
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            threadPoolExecutor.allowCoreThreadTimeOut(((Boolean) zzbe.zzc().zzb(zzbcn.zzkW)).booleanValue());
                            executorService = threadPoolExecutor;
                        }
                    }
                }
            }
            executorService = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), new zzcaf(Profile.DEFAULT_PROFILE_NAME));
        }
        zza = new zzcah(executorService, (zzcai) null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService2 = zzftc.zza().zzc(5, new zzcaf("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcaf("Loader"));
            ThreadPoolExecutor threadPoolExecutor4 = threadPoolExecutor3;
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorService2 = threadPoolExecutor3;
        }
        zzb = new zzcah(executorService2, (zzcai) null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorService3 = zzftc.zza().zzb(new zzcaf("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcaf("Activeview"));
            ThreadPoolExecutor threadPoolExecutor6 = threadPoolExecutor5;
            threadPoolExecutor5.allowCoreThreadTimeOut(true);
            executorService3 = threadPoolExecutor5;
        }
        zzc = new zzcah(executorService3, (zzcai) null);
    }
}
