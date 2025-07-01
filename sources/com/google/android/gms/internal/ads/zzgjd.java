package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjd extends zzggs {
    private final zzgjf zza;
    private final zzgwu zzb;
    @Nullable
    private final Integer zzc;

    private zzgjd(zzgjf zzgjf, zzgwu zzgwu, @Nullable Integer num) {
        this.zza = zzgjf;
        this.zzb = zzgwu;
        this.zzc = num;
    }

    public static zzgjd zza(zzgjf zzgjf, @Nullable Integer num) throws GeneralSecurityException {
        zzgwu zzgwu;
        if (zzgjf.zzb() == zzgje.zza) {
            if (num != null) {
                zzgwu = zzgwu.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
        } else if (zzgjf.zzb() != zzgje.zzb) {
            throw new GeneralSecurityException("Unknown Variant: ".concat(zzgjf.zzb().toString()));
        } else if (num == null) {
            zzgwu = zzgwu.zzb(new byte[0]);
        } else {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        return new zzgjd(zzgjf, zzgwu, num);
    }

    public final zzgjf zzb() {
        return this.zza;
    }

    public final zzgwu zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
