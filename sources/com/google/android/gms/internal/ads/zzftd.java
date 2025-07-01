package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public class zzftd extends Handler {
    public zzftd() {
        Looper.getMainLooper();
    }

    public final void dispatchMessage(Message message) {
        zza(message);
    }

    /* access modifiers changed from: protected */
    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzftd(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
