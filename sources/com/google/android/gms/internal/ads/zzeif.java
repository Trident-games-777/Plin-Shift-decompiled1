package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeif {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcrt zzc;
    private final zzeiv zzd;
    private final zzfln zze;
    private final zzgfa zzf = zzgfa.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    /* access modifiers changed from: private */
    public zzeig zzh;
    private zzfff zzi;

    zzeif(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrt zzcrt, zzeiv zzeiv, zzfln zzfln) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcrt;
        this.zzd = zzeiv;
        this.zze = zzfln;
    }

    private final synchronized ListenableFuture zzd(zzfet zzfet) {
        for (String zza2 : zzfet.zza) {
            zzefb zza3 = this.zzc.zza(zzfet.zzb, zza2);
            if (zza3 != null && zza3.zzb(this.zzi, zzfet)) {
                ListenableFuture zza4 = zza3.zza(this.zzi, zzfet);
                int i = zzfet.zzR;
                return zzgei.zzo(zza4, (long) i, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgei.zzg(new zzdwn(3));
    }

    /* access modifiers changed from: private */
    public final void zze(zzfet zzfet) {
        ListenableFuture zzd2 = zzd(zzfet);
        this.zzd.zzf(this.zzi, zzfet, zzd2, this.zze);
        zzgei.zzr(zzd2, new zzeie(this, zzfet), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfff zzfff) {
        if (!this.zzg.getAndSet(true)) {
            if (zzfff.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzeiz(3, zzejc.zzc(zzfff)));
            } else {
                this.zzi = zzfff;
                this.zzh = new zzeig(zzfff, this.zzd, this.zzf);
                this.zzd.zzk(zzfff.zzb.zza);
                zzfet zza2 = this.zzh.zza();
                while (zza2 != null) {
                    zze(zza2);
                    zza2 = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
