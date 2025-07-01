package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcrf implements zzcya, zzaym {
    private final zzfet zza;
    private final zzcxe zzb;
    private final zzcyj zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcrf(zzfet zzfet, zzcxe zzcxe, zzcyj zzcyj) {
        this.zza = zzfet;
        this.zzb = zzcxe;
        this.zzc = zzcyj;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzdp(zzayl zzayl) {
        if (this.zza.zze == 1 && zzayl.zzj) {
            zza();
        }
        if (zzayl.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzs() {
        if (this.zza.zze != 1) {
            zza();
        }
    }
}
