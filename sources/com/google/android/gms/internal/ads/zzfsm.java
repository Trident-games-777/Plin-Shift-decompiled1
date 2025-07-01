package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzfsm implements Closeable {
    public static zzfsy zza() {
        return new zzfsy();
    }

    public static zzfsy zzb(int i, zzfsx zzfsx) {
        return new zzfsy(new zzfsk(i), new zzfsl(), zzfsx);
    }

    public static zzfsy zzc(zzfxg<Integer> zzfxg, zzfxg<Integer> zzfxg2, zzfsx zzfsx) {
        return new zzfsy(zzfxg, zzfxg2, zzfsx);
    }

    static /* synthetic */ Integer zze() {
        return -1;
    }
}
