package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzwx {
    private final zzdc zza = zzdc.zza;

    /* access modifiers changed from: protected */
    public final zzwy zza(zzbw zzbw, int[] iArr, int i, zzyr zzyr, zzfzo zzfzo) {
        return new zzwy(zzbw, iArr, 0, zzyr, WorkRequest.MIN_BACKOFF_MILLIS, 25000, 25000, 1279, 719, 0.7f, 0.75f, zzfzo, this.zza);
    }
}
