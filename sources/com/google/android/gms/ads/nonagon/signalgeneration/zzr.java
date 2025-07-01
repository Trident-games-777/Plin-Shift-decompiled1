package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdex;
import com.google.android.gms.internal.ads.zzdsh;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzr implements zzdex {
    private final zzdsh zza;
    private final zzq zzb;
    private final String zzc;

    public zzr(zzdsh zzdsh, zzq zzq, String str) {
        this.zza = zzdsh;
        this.zzb = zzq;
        this.zzc = str;
    }

    public final void zze(zzbd zzbd) {
        if (zzbd != null) {
            this.zzb.zzd(this.zzc, zzbd.zzb, this.zza);
        }
    }

    public final void zzf(String str) {
    }
}
