package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzxs implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzyb zza;

    zzxs(zzxt zzxt, zzyb zzyb) {
        this.zza = zzyb;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }
}
