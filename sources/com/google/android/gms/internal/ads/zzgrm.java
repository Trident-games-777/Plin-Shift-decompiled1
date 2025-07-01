package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrm implements zzggi {
    private zzgrm(zzggi zzggi, zzgve zzgve, byte[] bArr) {
    }

    public static zzggi zza(zzgmz zzgmz) throws GeneralSecurityException {
        byte[] bArr;
        zzgow zza = zzgmz.zza(zzgfv.zza());
        zzgtx zza2 = zzgua.zza();
        zza2.zzb(zza.zzg());
        zza2.zzc(zza.zze());
        zza2.zza(zza.zzb());
        zzggi zzggi = (zzggi) zzggm.zzb((zzgua) zza2.zzbr(), zzggi.class);
        zzgve zzc = zza.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = zzgoa.zza.zzc();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            bArr = zzgoa.zza(zzgmz.zzb().intValue()).zzc();
        } else {
            bArr = zzgoa.zzb(zzgmz.zzb().intValue()).zzc();
        }
        return new zzgrm(zzggi, zzc, bArr);
    }
}
