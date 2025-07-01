package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgvx implements zzgwa {
    private final zzgwk zza;

    /* synthetic */ zzgvx(zzgwk zzgwk, zzgwb zzgwb) {
        this.zza = zzgwk;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzgwc.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
