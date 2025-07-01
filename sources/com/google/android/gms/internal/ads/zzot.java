package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzot extends BroadcastReceiver {
    final /* synthetic */ zzov zza;

    /* synthetic */ zzot(zzov zzov, zzou zzou) {
        this.zza = zzov;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast()) {
            zzov zzov = this.zza;
            zzov.zzj(zzop.zzd(context, intent, zzov.zzh, zzov.zzg));
        }
    }
}
