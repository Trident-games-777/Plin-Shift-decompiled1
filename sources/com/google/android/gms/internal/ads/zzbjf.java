package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjf implements zzgee {
    final /* synthetic */ zzcfk zza;

    zzbjf(zzcfk zzcfk) {
        this.zza = zzcfk;
    }

    public final void zza(Throwable th) {
        zzv.zzp().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcfk zzcfk = this.zza;
        new zzbv(zzcfk.getContext(), zzcfk.zzn().afmaVersion, (String) obj).zzb();
    }
}
