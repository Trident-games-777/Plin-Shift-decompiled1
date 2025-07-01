package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcca implements Runnable {
    zzcca(zzccc zzccc) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
