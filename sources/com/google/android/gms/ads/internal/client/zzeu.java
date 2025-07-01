package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzeu extends zzdk {
    private zzeu() {
        throw null;
    }

    /* synthetic */ zzeu(zzew zzew) {
    }

    public final void zze(zze zze) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzb = zzex.zzf().zzk;
        if (zzb != null) {
            if (zze == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zze.zza, zze.zzb, zze.zzc);
            }
            zzb.onAdInspectorClosed(adInspectorError);
        }
    }
}
