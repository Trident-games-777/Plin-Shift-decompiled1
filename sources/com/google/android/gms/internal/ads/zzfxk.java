package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfxk {
    public static zzfxg zza(zzfxg zzfxg) {
        if ((zzfxg instanceof zzfxj) || (zzfxg instanceof zzfxh)) {
            return zzfxg;
        }
        if (zzfxg instanceof Serializable) {
            return new zzfxh(zzfxg);
        }
        return new zzfxj(zzfxg);
    }
}
