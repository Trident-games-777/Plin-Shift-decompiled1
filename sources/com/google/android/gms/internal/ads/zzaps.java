package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaps {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzaoz zze;
    private final zzapi zzf;
    private final zzapj[] zzg;
    private zzapb zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzapg zzk;

    public zzaps(zzaoz zzaoz, zzapi zzapi, int i) {
        zzapg zzapg = new zzapg(new Handler(Looper.getMainLooper()));
        this.zze = zzaoz;
        this.zzf = zzapi;
        this.zzg = new zzapj[4];
        this.zzk = zzapg;
    }

    public final zzapp zza(zzapp zzapp) {
        zzapp.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzapp);
        }
        zzapp.zzg(this.zza.incrementAndGet());
        zzapp.zzm("add-to-queue");
        zzc(zzapp, 0);
        this.zzc.add(zzapp);
        return zzapp;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzapp zzapp) {
        synchronized (this.zzb) {
            this.zzb.remove(zzapp);
        }
        synchronized (this.zzi) {
            for (zzapr zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzapp, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzapp zzapp, int i) {
        synchronized (this.zzj) {
            for (zzapq zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzapb zzapb = this.zzh;
        if (zzapb != null) {
            zzapb.zzb();
        }
        zzapj[] zzapjArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzapj zzapj = zzapjArr[i];
            if (zzapj != null) {
                zzapj.zza();
            }
        }
        zzapb zzapb2 = new zzapb(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzapb2;
        zzapb2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzapj zzapj2 = new zzapj(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i2] = zzapj2;
            zzapj2.start();
        }
    }
}
