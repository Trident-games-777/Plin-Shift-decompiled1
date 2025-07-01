package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkg extends zzggs {
    private final zzgkm zza;
    private final zzgwv zzb;
    private final zzgwu zzc;
    @Nullable
    private final Integer zzd;

    private zzgkg(zzgkm zzgkm, zzgwv zzgwv, zzgwu zzgwu, @Nullable Integer num) {
        this.zza = zzgkm;
        this.zzb = zzgwv;
        this.zzc = zzgwu;
        this.zzd = num;
    }

    public static zzgkg zza(zzgkl zzgkl, zzgwv zzgwv, @Nullable Integer num) throws GeneralSecurityException {
        zzgwu zzgwu;
        zzgkl zzgkl2 = zzgkl.zzc;
        if (zzgkl != zzgkl2 && num == null) {
            String obj = zzgkl.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgkl == zzgkl2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgwv.zza() == 32) {
            zzgkm zzc2 = zzgkm.zzc(zzgkl);
            if (zzc2.zzb() == zzgkl2) {
                zzgwu = zzgoa.zza;
            } else if (zzc2.zzb() == zzgkl.zzb) {
                zzgwu = zzgoa.zza(num.intValue());
            } else if (zzc2.zzb() == zzgkl.zza) {
                zzgwu = zzgoa.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzgkg(zzc2, zzgwv, zzgwu, num);
        } else {
            int zza2 = zzgwv.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }

    public final zzgkm zzb() {
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
