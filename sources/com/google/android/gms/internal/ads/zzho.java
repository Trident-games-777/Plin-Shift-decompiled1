package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzho extends BroadcastReceiver implements Runnable {
    private final Handler zza;

    public zzho(zzhq zzhq, Handler handler, zzhp zzhp) {
        this.zza = handler;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zza.post(this);
        }
    }

    public final void run() {
    }
}
