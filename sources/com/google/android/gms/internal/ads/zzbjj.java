package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjj implements zzbjr {
    zzbjj() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ((zzcfk) obj).zzao(DiskLruCache.VERSION.equals(map.get("custom_close")));
    }
}
