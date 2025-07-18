package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgib {
    @Nullable
    private Integer zza = null;
    @Nullable
    private Integer zzb = null;
    @Nullable
    private Integer zzc = null;
    private zzgic zzd = zzgic.zzc;

    private zzgib() {
    }

    /* synthetic */ zzgib(zzgid zzgid) {
    }

    public final zzgib zza(int i) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzgib zzc(int i) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgib zzd(zzgic zzgic) {
        this.zzd = zzgic;
        return this;
    }

    public final zzgie zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzgie(intValue, 12, 16, this.zzd, (zzgid) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }

    public final zzgib zzb(int i) throws GeneralSecurityException {
        if (i == 16 || i == 24 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }
}
