package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmz extends zzgfw {
    private final zzgow zza;

    public zzgmz(zzgow zzgow, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzc(zzgow, zzggn);
        this.zza = zzgow;
    }

    private static void zzc(zzgow zzgow, @Nullable zzggn zzggn) throws GeneralSecurityException {
        int i = zzgmy.zzb[zzgow.zzb().ordinal()];
    }

    public final zzgow zza(@Nullable zzggn zzggn) throws GeneralSecurityException {
        zzc(this.zza, zzggn);
        return this.zza;
    }

    @Nullable
    public final Integer zzb() {
        return this.zza.zzf();
    }
}
