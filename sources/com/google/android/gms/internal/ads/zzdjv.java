package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdjv implements Runnable {
    public final /* synthetic */ zzdjy zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdjv(zzdjy zzdjy, ViewGroup viewGroup) {
        this.zza = zzdjy;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
