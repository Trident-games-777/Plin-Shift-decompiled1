package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzggy {
    @Nullable
    private zzghj zza = null;
    @Nullable
    private zzgwv zzb = null;
    @Nullable
    private zzgwv zzc = null;
    @Nullable
    private Integer zzd = null;

    private zzggy() {
    }

    /* synthetic */ zzggy(zzggz zzggz) {
    }

    public final zzggy zza(zzgwv zzgwv) {
        this.zzb = zzgwv;
        return this;
    }

    public final zzggy zzb(zzgwv zzgwv) {
        this.zzc = zzgwv;
        return this;
    }

    public final zzggy zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzggy zzd(zzghj zzghj) {
        this.zza = zzghj;
        return this;
    }

    public final zzgha zze() throws GeneralSecurityException {
        zzgwu zzb2;
        zzghj zzghj = this.zza;
        if (zzghj != null) {
            zzgwv zzgwv = this.zzb;
            if (zzgwv == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzghj.zzb() != zzgwv.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzghj.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzghh.zzc) {
                    zzb2 = zzgoa.zza;
                } else if (this.zza.zzh() == zzghh.zzb) {
                    zzb2 = zzgoa.zza(this.zzd.intValue());
                } else if (this.zza.zzh() == zzghh.zza) {
                    zzb2 = zzgoa.zzb(this.zzd.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzh()))));
                }
                return new zzgha(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzggz) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
