package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzavy extends BroadcastReceiver {
    private boolean zza = true;

    zzavy(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zza = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zza = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zza;
    }
}
