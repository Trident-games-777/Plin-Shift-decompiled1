package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjl extends zzggs {
    private final zzgjq zza;
    private final zzgwu zzb;
    @Nullable
    private final Integer zzc;

    private zzgjl(zzgjq zzgjq, zzgwu zzgwu, @Nullable Integer num) {
        this.zza = zzgjq;
        this.zzb = zzgwu;
        this.zzc = num;
    }

    public static zzgjl zza(zzgjq zzgjq, @Nullable Integer num) throws GeneralSecurityException {
        zzgwu zzgwu;
        if (zzgjq.zzc() == zzgjo.zzb) {
            if (num == null) {
                zzgwu = zzgoa.zza;
            } else {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
        } else if (zzgjq.zzc() != zzgjo.zza) {
            throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(String.valueOf(zzgjq.zzc()))));
        } else if (num != null) {
            zzgwu = zzgoa.zzb(num.intValue());
        } else {
            throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
        }
        return new zzgjl(zzgjq, zzgwu, num);
    }

    public final zzgjq zzb() {
        return this.zza;
    }

    public final zzgwu zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
