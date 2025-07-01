package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmi {
    private final Object zza;
    private final long zzb;
    private final Clock zzc;
    private final long zzd = (((Long) zzbe.zzc().zza(zzbcn.zzx)).longValue() * 1000);

    public zzfmi(Object obj, Clock clock) {
        this.zza = obj;
        this.zzc = clock;
        this.zzb = clock.currentTimeMillis();
    }

    public final long zza() {
        return (this.zzd + Math.min(Math.max(((Long) zzbe.zzc().zza(zzbcn.zzt)).longValue(), -900000), WorkRequest.MIN_BACKOFF_MILLIS)) - (this.zzc.currentTimeMillis() - this.zzb);
    }

    public final Object zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc.currentTimeMillis() >= this.zzb + this.zzd;
    }
}
