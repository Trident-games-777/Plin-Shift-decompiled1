package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzst {
    public static void zza(zzsk zzsk, zzoj zzoj) {
        LogSessionId zza = zzoj.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            zzsk.zzb.setString("log-session-id", zza.getStringId());
        }
    }
}
