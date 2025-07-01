package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfoa extends BroadcastReceiver {
    final /* synthetic */ zzfob zza;

    zzfoa(zzfob zzfob) {
        this.zza = zzfob;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzfob zzfob = this.zza;
            zzfob.zzd(true, zzfob.zzd);
            this.zza.zzc = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfob zzfob2 = this.zza;
            zzfob2.zzd(false, zzfob2.zzd);
            this.zza.zzc = false;
        }
    }
}
