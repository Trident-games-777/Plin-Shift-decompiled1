package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhas {
    public static final /* synthetic */ int zza = 0;
    private static final zzhas zzb = new zzhas();
    private final zzhbc zzc = new zzhaa();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zzhas() {
    }

    public static zzhas zza() {
        return zzb;
    }

    public final zzhbb zzb(Class cls) {
        zzgzk.zzc(cls, "messageType");
        zzhbb zzhbb = (zzhbb) this.zzd.get(cls);
        if (zzhbb != null) {
            return zzhbb;
        }
        zzhbb zza2 = this.zzc.zza(cls);
        zzgzk.zzc(cls, "messageType");
        zzhbb zzhbb2 = (zzhbb) this.zzd.putIfAbsent(cls, zza2);
        return zzhbb2 == null ? zza2 : zzhbb2;
    }
}
