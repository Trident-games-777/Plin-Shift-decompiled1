package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjo implements zzbjr {
    zzbjo() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        if (map.keySet().contains("start")) {
            zzcfk.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcfk.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcfk.zzN().zzk();
        }
    }
}
