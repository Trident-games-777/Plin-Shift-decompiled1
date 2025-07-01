package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbxy implements Runnable {
    public final /* synthetic */ zzbyc zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzbxy(zzbyc zzbyc, Bitmap bitmap) {
        this.zza = zzbyc;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
