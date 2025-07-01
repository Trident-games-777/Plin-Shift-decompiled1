package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzekt implements zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcwk zzb;
    private final zzcxe zzc;
    private final zzden zzd;
    private final zzdef zze;
    private final zzcny zzf;

    zzekt(zzcwk zzcwk, zzcxe zzcxe, zzden zzden, zzdef zzdef, zzcny zzcny) {
        this.zzb = zzcwk;
        this.zzc = zzcxe;
        this.zzd = zzden;
        this.zze = zzdef;
        this.zzf = zzcny;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzr();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
