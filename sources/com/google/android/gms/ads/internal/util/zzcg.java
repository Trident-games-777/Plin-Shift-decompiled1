package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcg extends BroadcastReceiver {
    final /* synthetic */ zzch zza;

    zzcg(zzch zzch) {
        this.zza = zzch;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
