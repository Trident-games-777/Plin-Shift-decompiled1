package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzghk {
    @Nullable
    private zzght zza = null;
    @Nullable
    private zzgwv zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzghk() {
    }

    /* synthetic */ zzghk(zzghl zzghl) {
    }

    public final zzghk zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghk zzb(zzgwv zzgwv) {
        this.zzb = zzgwv;
        return this;
    }

    public final zzghk zzc(zzght zzght) {
        this.zza = zzght;
        return this;
    }

    public final zzghm zzd() throws GeneralSecurityException {
        zzgwv zzgwv;
        zzgwu zzb2;
        zzght zzght = this.zza;
        if (zzght == null || (zzgwv = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzght.zzc() != zzgwv.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzght.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zze() == zzghr.zzc) {
                zzb2 = zzgoa.zza;
            } else if (this.zza.zze() == zzghr.zzb) {
                zzb2 = zzgoa.zza(this.zzc.intValue());
            } else if (this.zza.zze() == zzghr.zza) {
                zzb2 = zzgoa.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zze()))));
            }
            return new zzghm(this.zza, this.zzb, zzb2, this.zzc, (zzghl) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
