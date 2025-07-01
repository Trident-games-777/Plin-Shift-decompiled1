package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgif {
    @Nullable
    private zzgip zza = null;
    @Nullable
    private zzgwv zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzgif() {
    }

    /* synthetic */ zzgif(zzgig zzgig) {
    }

    public final zzgif zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgif zzb(zzgwv zzgwv) {
        this.zzb = zzgwv;
        return this;
    }

    public final zzgif zzc(zzgip zzgip) {
        this.zza = zzgip;
        return this;
    }

    public final zzgih zzd() throws GeneralSecurityException {
        zzgwv zzgwv;
        zzgwu zzb2;
        zzgip zzgip = this.zza;
        if (zzgip == null || (zzgwv = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgip.zzb() != zzgwv.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgip.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzgin.zzc) {
                zzb2 = zzgoa.zza;
            } else if (this.zza.zzd() == zzgin.zzb) {
                zzb2 = zzgoa.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzgin.zza) {
                zzb2 = zzgoa.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            return new zzgih(this.zza, this.zzb, zzb2, this.zzc, (zzgig) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
