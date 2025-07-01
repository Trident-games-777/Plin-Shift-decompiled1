package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzhfs {
    final LinkedHashMap zza;

    zzhfs(int i) {
        this.zza = zzhfu.zzb(i);
    }

    /* access modifiers changed from: package-private */
    public final zzhfs zza(Object obj, zzhgg zzhgg) {
        zzhgf.zza(obj, "key");
        zzhgf.zza(zzhgg, "provider");
        zzhgg zzhgg2 = zzhgg;
        this.zza.put(obj, zzhgg);
        return this;
    }
}
