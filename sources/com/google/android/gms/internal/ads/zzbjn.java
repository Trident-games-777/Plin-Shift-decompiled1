package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjn implements zzbjr {
    zzbjn() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcfk.zzdg();
        } else if ("resume".equals(str)) {
            zzcfk.zzdh();
        }
    }
}
