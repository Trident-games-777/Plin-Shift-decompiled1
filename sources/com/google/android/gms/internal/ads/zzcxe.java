package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcxe extends zzdcc {
    private boolean zzb = false;

    public zzcxe(Set set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzq(new zzcxd());
            this.zzb = true;
        }
    }
}
