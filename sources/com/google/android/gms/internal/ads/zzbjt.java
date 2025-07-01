package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbjt implements zzbjr {
    private final zzbju zza;

    public zzbjt(zzbju zzbju) {
        this.zza = zzbju;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        boolean equals = DiskLruCache.VERSION.equals(map.get("transparentBackground"));
        boolean equals2 = DiskLruCache.VERSION.equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzm.zzh("Fail to parse float", e);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f);
        zzcfk.zzay(equals);
    }
}
