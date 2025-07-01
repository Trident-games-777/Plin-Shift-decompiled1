package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrf implements zzgpv {
    public zzgrf(zzgpm zzgpm) throws GeneralSecurityException {
        if (!zzgmh.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
    }
}
