package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpk {
    @Nullable
    private zzgpu zza = null;
    @Nullable
    private zzgwv zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzgpk() {
    }

    /* synthetic */ zzgpk(zzgpl zzgpl) {
    }

    public final zzgpk zza(zzgwv zzgwv) throws GeneralSecurityException {
        this.zzb = zzgwv;
        return this;
    }

    public final zzgpk zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpk zzc(zzgpu zzgpu) {
        this.zza = zzgpu;
        return this;
    }

    public final zzgpm zzd() throws GeneralSecurityException {
        zzgwv zzgwv;
        zzgwu zza2;
        zzgpu zzgpu = this.zza;
        if (zzgpu == null || (zzgwv = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgpu.zzc() != zzgwv.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgpu.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzf() == zzgps.zzd) {
                zza2 = zzgoa.zza;
            } else if (this.zza.zzf() == zzgps.zzc || this.zza.zzf() == zzgps.zzb) {
                zza2 = zzgoa.zza(this.zzc.intValue());
            } else if (this.zza.zzf() == zzgps.zza) {
                zza2 = zzgoa.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            return new zzgpm(this.zza, this.zzb, zza2, this.zzc, (zzgpl) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
