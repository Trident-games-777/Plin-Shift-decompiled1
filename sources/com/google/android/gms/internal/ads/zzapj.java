package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzapj extends Thread {
    private final BlockingQueue zza;
    private final zzapi zzb;
    private final zzaoz zzc;
    private volatile boolean zzd = false;
    private final zzapg zze;

    public zzapj(BlockingQueue blockingQueue, zzapi zzapi, zzaoz zzaoz, zzapg zzapg) {
        this.zza = blockingQueue;
        this.zzb = zzapi;
        this.zzc = zzaoz;
        this.zze = zzapg;
    }

    private void zzb() throws InterruptedException {
        zzapp zzapp = (zzapp) this.zza.take();
        SystemClock.elapsedRealtime();
        zzapp.zzt(3);
        try {
            zzapp.zzm("network-queue-take");
            zzapp.zzw();
            TrafficStats.setThreadStatsTag(zzapp.zzc());
            zzapl zza2 = this.zzb.zza(zzapp);
            zzapp.zzm("network-http-complete");
            if (!zza2.zze || !zzapp.zzv()) {
                zzapv zzh = zzapp.zzh(zza2);
                zzapp.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzapp.zzj(), zzh.zzb);
                    zzapp.zzm("network-cache-written");
                }
                zzapp.zzq();
                this.zze.zzb(zzapp, zzh, (Runnable) null);
                zzapp.zzs(zzh);
                zzapp.zzt(4);
            }
            zzapp.zzp("not-modified");
            zzapp.zzr();
            zzapp.zzt(4);
        } catch (zzapy e) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzapp, e);
            zzapp.zzr();
        } catch (Exception e2) {
            zzaqb.zzc(e2, "Unhandled exception %s", e2.toString());
            zzapy zzapy = new zzapy((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzapp, zzapy);
            zzapp.zzr();
        } catch (Throwable th) {
            zzapp.zzt(4);
            throw th;
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqb.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
