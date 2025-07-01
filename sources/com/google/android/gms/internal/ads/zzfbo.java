package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfbo implements zzfhw {
    private final zzfck zza;

    public zzfbo(zzfck zzfck) {
        this.zza = zzfck;
    }

    public final ListenableFuture zza(zzfhx zzfhx) {
        zzfbp zzfbp = (zzfbp) zzfhx;
        zzcvt zzcvt = null;
        return ((zzfbl) this.zza).zzb(zzfbp.zzb, zzfbp.zza, (zzcvt) null);
    }

    public final void zzb(zzfhl zzfhl) {
        zzcvt zza2 = ((zzfbl) this.zza).zza();
        zzcvt zzcvt = zza2;
        zzfhl.zza = zza2;
    }
}
