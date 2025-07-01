package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbfe {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzbfc zza() {
        return (zzbfc) zza.get();
    }

    static zzbfd zzb() {
        return (zzbfd) zzb.get();
    }

    public static void zzc(zzbfc zzbfc) {
        zza.set(zzbfc);
    }
}
