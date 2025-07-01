package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdfg extends zzdcc {
    private boolean zzb;

    protected zzdfg(Set set) {
        super(set);
    }

    public final void zza() {
        zzq(new zzdfd());
    }

    public final void zzb() {
        zzq(new zzdfc());
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzq(new zzdfe());
            this.zzb = true;
        }
        zzq(new zzdff());
    }

    public final synchronized void zzd() {
        zzq(new zzdfe());
        this.zzb = true;
    }
}
