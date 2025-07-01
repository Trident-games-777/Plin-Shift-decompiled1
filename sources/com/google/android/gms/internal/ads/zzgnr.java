package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnr {
    private static final zzgnr zza = new zzgnr();
    private final Map zzb = new HashMap();

    public static zzgnr zza() {
        return zza;
    }

    public final synchronized void zzb(zzgnq zzgnq, Class cls) throws GeneralSecurityException {
        zzgnq zzgnq2 = (zzgnq) this.zzb.get(cls);
        if (zzgnq2 != null) {
            if (!zzgnq2.equals(zzgnq)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
        }
        this.zzb.put(cls, zzgnq);
    }
}
