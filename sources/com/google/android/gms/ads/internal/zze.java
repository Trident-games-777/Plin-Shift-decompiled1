package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdsm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzdsm zza;
    public final /* synthetic */ Long zzb;

    public /* synthetic */ zze(zzf zzf, zzdsm zzdsm, Long l) {
        this.zza = zzdsm;
        this.zzb = l;
    }

    public final void run() {
        zzf.zzf(this.zza, "cld_r", zzv.zzC().elapsedRealtime() - this.zzb.longValue());
    }
}
