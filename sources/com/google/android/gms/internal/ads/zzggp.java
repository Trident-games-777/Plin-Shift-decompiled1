package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzggp {
    public static zzggj zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzgue zzf = zzgue.zzf(bArr, zzgyh.zza());
            zzgnz zzc = zzgnz.zzc();
            zzgox zza = zzgox.zza(zzf);
            if (!zzc.zzk(zza)) {
                return new zzgna(zza);
            }
            return zzc.zzb(zza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zzb(zzggj zzggj) throws GeneralSecurityException {
        return ((zzgox) zzgnz.zzc().zze(zzggj, zzgox.class)).zzc().zzaV();
    }
}
