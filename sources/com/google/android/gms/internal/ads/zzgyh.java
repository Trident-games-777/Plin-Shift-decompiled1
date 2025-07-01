package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzgyh {
    static final zzgyh zza = new zzgyh(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgyh zzd;
    private final Map zze;

    zzgyh() {
        this.zze = new HashMap();
    }

    public static zzgyh zza() {
        int i = zzhas.zza;
        return zza;
    }

    public static zzgyh zzb() {
        zzgyh zzgyh = zzd;
        if (zzgyh != null) {
            return zzgyh;
        }
        synchronized (zzgyh.class) {
            zzgyh zzgyh2 = zzd;
            if (zzgyh2 != null) {
                return zzgyh2;
            }
            int i = zzhas.zza;
            zzgyh zzb2 = zzgyp.zzb(zzgyh.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzgyv zzc(zzhai zzhai, int i) {
        return (zzgyv) this.zze.get(new zzgyg(zzhai, i));
    }

    zzgyh(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
