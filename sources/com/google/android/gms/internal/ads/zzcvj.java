package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvj implements zzcwm, zzddq, zzdbg, zzcxc, zzaym {
    /* access modifiers changed from: private */
    public final zzcxe zza;
    private final zzfet zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzgfa zze = zzgfa.zze();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();
    private final String zzh;

    zzcvj(zzcxe zzcxe, zzfet zzfet, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzcxe;
        this.zzb = zzfet;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    private final boolean zzm() {
        return this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
        zzfet zzfet = this.zzb;
        if (zzfet.zze != 3) {
            int i = zzfet.zzY;
            if (i == 0 || i == 1) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzle)).booleanValue() || !zzm()) {
                    this.zza.zza();
                }
            }
        }
    }

    public final void zzdp(zzayl zzayl) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzle)).booleanValue() && zzm() && zzayl.zzj && this.zzg.compareAndSet(false, true) && this.zzb.zze != 3) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzc(true);
            }
        }
    }

    public final void zzi() {
    }

    public final synchronized void zzj() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzc(true);
        }
    }

    public final void zzk() {
        if (this.zzb.zze != 3) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzbC)).booleanValue()) {
                zzfet zzfet = this.zzb;
                if (zzfet.zzY != 2) {
                    return;
                }
                if (zzfet.zzq == 0) {
                    this.zza.zza();
                    return;
                }
                zzgei.zzr(this.zze, new zzcvi(this), this.zzd);
                this.zzf = this.zzc.schedule(new zzcvh(this), (long) this.zzb.zzq, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void zzl() {
    }

    public final synchronized void zzq(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(new Exception());
        }
    }
}
