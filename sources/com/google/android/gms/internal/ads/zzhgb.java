package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhgb extends zzhft {
    static {
        zzhfy.zza(Collections.emptyMap());
    }

    /* synthetic */ zzhgb(Map map, zzhfz zzhfz) {
        super(map);
    }

    public static zzhga zzc(int i) {
        return new zzhga(i, (zzhfz) null);
    }

    /* renamed from: zzd */
    public final Map zzb() {
        LinkedHashMap zzb = zzhfu.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzhgg) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
