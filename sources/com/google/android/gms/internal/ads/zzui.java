package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzui {
    private static final AtomicLong zza = new AtomicLong();

    public zzui(long j, zzgi zzgi, long j2) {
        Uri uri = zzgi.zza;
        Collections.emptyMap();
    }

    public zzui(long j, zzgi zzgi, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
