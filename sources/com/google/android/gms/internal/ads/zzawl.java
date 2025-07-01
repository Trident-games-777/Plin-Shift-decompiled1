package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzawl extends BroadcastReceiver {
    final /* synthetic */ zzawm zza;

    zzawl(zzawm zzawm) {
        this.zza = zzawm;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
