package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgiq extends zzggs {
    private final zzgiv zza;
    private final zzgwv zzb;
    private final zzgwu zzc;
    @Nullable
    private final Integer zzd;

    private zzgiq(zzgiv zzgiv, zzgwv zzgwv, zzgwu zzgwu, @Nullable Integer num) {
        this.zza = zzgiv;
        this.zzb = zzgwv;
        this.zzc = zzgwu;
        this.zzd = num;
    }

    public static zzgiq zza(zzgiu zzgiu, zzgwv zzgwv, @Nullable Integer num) throws GeneralSecurityException {
        zzgwu zzgwu;
        zzgiu zzgiu2 = zzgiu.zzc;
        if (zzgiu != zzgiu2 && num == null) {
            String obj = zzgiu.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgiu == zzgiu2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgwv.zza() == 32) {
            zzgiv zzc2 = zzgiv.zzc(zzgiu);
            if (zzc2.zzb() == zzgiu2) {
                zzgwu = zzgoa.zza;
            } else if (zzc2.zzb() == zzgiu.zzb) {
                zzgwu = zzgoa.zza(num.intValue());
            } else if (zzc2.zzb() == zzgiu.zza) {
                zzgwu = zzgoa.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzgiq(zzc2, zzgwv, zzgwu, num);
        } else {
            int zza2 = zzgwv.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }

    public final zzgiv zzb() {
        return this.zza;
    }

    public final zzgwu zzc() {
        return this.zzc;
    }

    public final zzgwv zzd() {
        return this.zzb;
    }

    @Nullable
    public final Integer zze() {
        return this.zzd;
    }
}
