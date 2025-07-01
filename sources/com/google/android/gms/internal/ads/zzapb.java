package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzapb extends Thread {
    private static final boolean zza = zzaqb.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzaoz zzd;
    private volatile boolean zze = false;
    private final zzaqc zzf;
    private final zzapg zzg;

    public zzapb(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaoz zzaoz, zzapg zzapg) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaoz;
        this.zzg = zzapg;
        this.zzf = new zzaqc(this, blockingQueue2, zzapg);
    }

    private void zzc() throws InterruptedException {
        zzapp zzapp = (zzapp) this.zzb.take();
        zzapp.zzm("cache-queue-take");
        zzapp.zzt(1);
        try {
            zzapp.zzw();
            zzaoy zza2 = this.zzd.zza(zzapp.zzj());
            if (zza2 == null) {
                zzapp.zzm("cache-miss");
                if (!this.zzf.zzc(zzapp)) {
                    this.zzc.put(zzapp);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (zza2.zza(currentTimeMillis)) {
                    zzapp.zzm("cache-hit-expired");
                    zzapp.zze(zza2);
                    if (!this.zzf.zzc(zzapp)) {
                        this.zzc.put(zzapp);
                    }
                } else {
                    zzapp.zzm("cache-hit");
                    zzapv zzh = zzapp.zzh(new zzapl(zza2.zza, zza2.zzg));
                    zzapp.zzm("cache-hit-parsed");
                    if (!zzh.zzc()) {
                        zzapp.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzapp.zzj(), true);
                        zzapp.zze((zzaoy) null);
                        if (!this.zzf.zzc(zzapp)) {
                            this.zzc.put(zzapp);
                        }
                    } else if (zza2.zzf < currentTimeMillis) {
                        zzapp.zzm("cache-hit-refresh-needed");
                        zzapp.zze(zza2);
                        zzh.zzd = true;
                        if (!this.zzf.zzc(zzapp)) {
                            this.zzg.zzb(zzapp, zzh, new zzapa(this, zzapp));
                        } else {
                            this.zzg.zzb(zzapp, zzh, (Runnable) null);
                        }
                    } else {
                        this.zzg.zzb(zzapp, zzh, (Runnable) null);
                    }
                }
            }
        } finally {
            zzapp.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzaqb.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqb.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
