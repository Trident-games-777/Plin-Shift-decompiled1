package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzffz implements zzgee {
    final /* synthetic */ zzfga zza;
    final /* synthetic */ int zzb;

    zzffz(zzfga zzfga, int i) {
        this.zzb = i;
        this.zza = zzfga;
    }

    public final void zza(Throwable th) {
        zzv.zzp().zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i = this.zzb;
        this.zza.zzb((String) obj, i);
    }
}
