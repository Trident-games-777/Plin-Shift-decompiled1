package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdin implements Runnable {
    public final /* synthetic */ zzdit zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdin(zzdit zzdit, View view, boolean z, int i) {
        this.zza = zzdit;
        this.zzb = view;
        this.zzc = z;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzx(this.zzb, this.zzc, this.zzd);
    }
}
