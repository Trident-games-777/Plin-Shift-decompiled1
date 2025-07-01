package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzlj {
    private final zzli zza;
    private final zzlh zzb;
    private final zzbv zzc;
    private int zzd;
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    public zzlj(zzlh zzlh, zzli zzli, zzbv zzbv, int i, zzdc zzdc, Looper looper) {
        this.zzb = zzlh;
        this.zza = zzli;
        this.zzc = zzbv;
        this.zzf = looper;
        this.zzg = i;
    }

    public final int zza() {
        return this.zzd;
    }

    public final Looper zzb() {
        return this.zzf;
    }

    public final zzli zzc() {
        return this.zza;
    }

    public final zzlj zzd() {
        zzdb.zzf(!this.zzh);
        this.zzh = true;
        this.zzb.zzm(this);
        return this;
    }

    public final zzlj zze(Object obj) {
        zzdb.zzf(!this.zzh);
        this.zze = obj;
        return this;
    }

    public final zzlj zzf(int i) {
        zzdb.zzf(!this.zzh);
        this.zzd = i;
        return this;
    }

    public final Object zzg() {
        return this.zze;
    }

    public final synchronized void zzh(boolean z) {
        this.zzi = z | this.zzi;
        this.zzj = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j) throws InterruptedException, TimeoutException {
        zzdb.zzf(this.zzh);
        zzdb.zzf(this.zzf.getThread() != Thread.currentThread());
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        while (!this.zzj) {
            if (j > 0) {
                wait(j);
                j = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzi;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
