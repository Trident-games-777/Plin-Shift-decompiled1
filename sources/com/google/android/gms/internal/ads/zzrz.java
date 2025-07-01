package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzrz extends Handler {
    final /* synthetic */ zzsb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzrz(zzsb zzsb, Looper looper) {
        super(looper);
        this.zza = zzsb;
    }

    public final void handleMessage(Message message) {
        zzsb.zza(this.zza, message);
    }
}
