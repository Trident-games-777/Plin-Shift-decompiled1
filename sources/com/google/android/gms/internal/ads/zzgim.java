package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgim {
    @Nullable
    private Integer zza = null;
    private zzgin zzb = zzgin.zzc;

    private zzgim() {
    }

    /* synthetic */ zzgim(zzgio zzgio) {
    }

    public final zzgim zzb(zzgin zzgin) {
        this.zzb = zzgin;
        return this;
    }

    public final zzgip zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzgip(num.intValue(), this.zzb, (zzgio) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }

    public final zzgim zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }
}
