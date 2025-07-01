package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcfl implements Runnable {
    public final /* synthetic */ zzcfs zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzbyh zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcfl(zzcfs zzcfs, View view, zzbyh zzbyh, int i) {
        this.zza = zzcfs;
        this.zzb = view;
        this.zzc = zzbyh;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
