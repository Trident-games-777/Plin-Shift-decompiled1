package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzjn {
    public static zzoj zza(Context context, zzjv zzjv, boolean z, String str) {
        zzof zzb = zzof.zzb(context);
        if (zzb == null) {
            zzdt.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzoj(LogSessionId.LOG_SESSION_ID_NONE, str);
        }
        if (z) {
            zzjv.zzy(zzb);
        }
        return new zzoj(zzb.zza(), str);
    }
}
