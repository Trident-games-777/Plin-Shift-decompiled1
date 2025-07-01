package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzech {
    private final zzecd zza;
    private final zzges zzb;

    public zzech(zzecd zzecd, zzges zzges) {
        this.zza = zzecd;
        this.zzb = zzges;
    }

    public final void zza(zzfiv zzfiv) {
        zzecd zzecd = this.zza;
        Objects.requireNonNull(zzecd);
        zzgei.zzr(this.zzb.zzb(new zzecf(zzecd)), new zzecg(this, zzfiv), this.zzb);
    }
}
