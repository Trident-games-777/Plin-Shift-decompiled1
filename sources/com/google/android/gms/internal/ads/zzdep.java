package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdep {
    private final List zza;
    private final zzflr zzb;
    private boolean zzc;

    public zzdep(zzfet zzfet, zzflr zzflr) {
        this.zza = zzfet.zzp;
        this.zzb = zzflr;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
