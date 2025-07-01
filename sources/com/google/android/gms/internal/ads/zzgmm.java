package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmm {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzgmm(Map map, Map map2, zzgml zzgml) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzgmk zza() {
        return new zzgmk((zzgml) null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum enumR = (Enum) this.zzb.get(obj);
        if (enumR != null) {
            return enumR;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(String.valueOf(obj))));
    }

    public final Object zzc(Enum enumR) throws GeneralSecurityException {
        Object obj = this.zza.get(enumR);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(String.valueOf(enumR))));
    }
}
