package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzghu {
    @Nullable
    private zzgie zza = null;
    @Nullable
    private zzgwv zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzghu() {
    }

    /* synthetic */ zzghu(zzghv zzghv) {
    }

    public final zzghu zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghu zzb(zzgwv zzgwv) {
        this.zzb = zzgwv;
        return this;
    }

    public final zzghu zzc(zzgie zzgie) {
        this.zza = zzgie;
        return this;
    }

    public final zzghw zzd() throws GeneralSecurityException {
        zzgwv zzgwv;
        zzgwu zzb2;
        zzgie zzgie = this.zza;
        if (zzgie == null || (zzgwv = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgie.zzb() != zzgwv.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgie.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzgic.zzc) {
                zzb2 = zzgoa.zza;
            } else if (this.zza.zzd() == zzgic.zzb) {
                zzb2 = zzgoa.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzgic.zza) {
                zzb2 = zzgoa.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            return new zzghw(this.zza, this.zzb, zzb2, this.zzc, (zzghv) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
