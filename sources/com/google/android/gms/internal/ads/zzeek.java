package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeek implements Runnable {
    public final /* synthetic */ zzfnh zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzeek(zzfnh zzfnh, View view) {
        this.zza = zzfnh;
        this.zzb = view;
    }

    public final void run() {
        this.zza.zze(this.zzb, zzfnd.NOT_VISIBLE, "Ad overlay");
    }
}
