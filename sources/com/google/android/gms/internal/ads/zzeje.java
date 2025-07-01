package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeje {
    private zzeiv zza;

    zzeje() {
    }

    private zzeje(zzeiv zzeiv) {
        this.zza = zzeiv;
    }

    public static zzeje zzb(zzeiv zzeiv) {
        return new zzeje(zzeiv);
    }

    public final zzeiv zza(Clock clock, zzeix zzeix, zzefg zzefg, zzflr zzflr) {
        zzeiv zzeiv = this.zza;
        return zzeiv != null ? zzeiv : new zzeiv(clock, zzeix, zzefg, zzflr);
    }
}
