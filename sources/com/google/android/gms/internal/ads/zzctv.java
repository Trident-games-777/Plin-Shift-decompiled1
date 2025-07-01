package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzctv implements zzdbz, zzcya {
    private final Clock zza;
    private final zzctx zzb;
    private final zzffo zzc;
    private final String zzd;

    zzctv(Clock clock, zzctx zzctx, zzffo zzffo, String str) {
        this.zza = clock;
        this.zzb = zzctx;
        this.zzc = zzffo;
        this.zzd = str;
    }

    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    public final void zzs() {
        Clock clock = this.zza;
        this.zzb.zzd(this.zzc.zzf, this.zzd, clock.elapsedRealtime());
    }
}
