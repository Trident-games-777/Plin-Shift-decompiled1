package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzboy {
    private static zzboy zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzboy() {
    }

    public static zzboy zza() {
        if (zza == null) {
            zza = new zzboy();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbox(this, context, str));
        thread.start();
        return thread;
    }
}
