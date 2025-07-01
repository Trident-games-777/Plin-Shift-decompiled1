package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbfa {
    public static final zzbdx zza = zzbdx.zzb("gads:rendering:timeout_ms", 60000);

    static {
        zzbdx.zzb("gads:ad_loader:timeout_ms", 60000);
        zzbdx.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
