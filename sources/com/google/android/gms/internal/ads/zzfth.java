package com.google.android.gms.internal.ads;

import java.time.Instant;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfth {
    private final String zza;
    private final Instant zzb;

    public zzfth() {
        this.zza = null;
        this.zzb = Instant.ofEpochMilli(-1);
    }

    public zzfth(String str, Instant instant) {
        this.zza = str;
        this.zzb = instant;
    }

    public final String zza() {
        return this.zza;
    }

    public final Instant zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zza != null && this.zzb.isAfter(Instant.EPOCH);
    }
}
