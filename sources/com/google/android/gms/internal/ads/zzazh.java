package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzazh implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzazl zzb;

    zzazh(zzazl zzazl, View view) {
        this.zza = view;
        this.zzb = zzazl;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
