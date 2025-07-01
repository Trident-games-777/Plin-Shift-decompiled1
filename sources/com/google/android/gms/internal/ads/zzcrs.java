package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcrs implements zzcrt {
    private final Map zza;

    zzcrs(Map map) {
        this.zza = map;
    }

    public final zzefb zza(int i, String str) {
        return (zzefb) this.zza.get(str);
    }
}
