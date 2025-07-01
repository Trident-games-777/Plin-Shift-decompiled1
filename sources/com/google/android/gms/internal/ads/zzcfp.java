package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcfp implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbyh zza;
    final /* synthetic */ zzcfs zzb;

    zzcfp(zzcfs zzcfs, zzbyh zzbyh) {
        this.zza = zzbyh;
        this.zzb = zzcfs;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzZ(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
