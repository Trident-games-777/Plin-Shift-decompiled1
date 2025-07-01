package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ zzk zza;
    public final /* synthetic */ Drawable zzb;

    public /* synthetic */ zzj(zzk zzk, Drawable drawable) {
        this.zza = zzk;
        this.zzb = drawable;
    }

    public final void run() {
        this.zza.zza.zzb.getWindow().setBackgroundDrawable(this.zzb);
    }
}
