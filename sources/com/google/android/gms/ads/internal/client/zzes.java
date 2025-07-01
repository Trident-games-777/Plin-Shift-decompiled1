package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzes extends zzce {
    final /* synthetic */ PreloadCallback zza;
    final /* synthetic */ zzex zzb;

    zzes(zzex zzex, PreloadCallback preloadCallback) {
        this.zza = preloadCallback;
        this.zzb = zzex;
    }

    public final void zze(zzft zzft) {
        zzex.zzk(this.zzb, zzft).ifPresent(new zzeq(this));
    }

    public final void zzf(zzft zzft) {
        zzex.zzk(this.zzb, zzft).ifPresent(new zzer(this));
    }
}
