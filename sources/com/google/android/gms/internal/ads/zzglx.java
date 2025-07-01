package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzglx implements zzgfm {
    private final zzgfm zza;
    private final byte[] zzb;

    private zzglx(zzgfm zzgfm, byte[] bArr) {
        this.zza = zzgfm;
        int length = bArr.length;
        if (length == 0 || length == 5) {
            this.zzb = bArr;
            return;
        }
        throw new IllegalArgumentException("identifier has an invalid length");
    }

    public static zzgfm zzb(zzgmz zzgmz) throws GeneralSecurityException {
        byte[] bArr;
        zzgow zza2 = zzgmz.zza(zzgfv.zza());
        zzgtx zza3 = zzgua.zza();
        zza3.zzb(zza2.zzg());
        zza3.zzc(zza2.zze());
        zza3.zza(zza2.zzb());
        zzgfm zzgfm = (zzgfm) zzggm.zzb((zzgua) zza3.zzbr(), zzgfm.class);
        zzgve zzc = zza2.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = zzgoa.zza.zzc();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(String.valueOf(zzc))));
                }
            }
            bArr = zzgoa.zza(zzgmz.zzb().intValue()).zzc();
        } else {
            bArr = zzgoa.zzb(zzgmz.zzb().intValue()).zzc();
        }
        return new zzglx(zzgfm, bArr);
    }

    public static zzgfm zzc(zzgfm zzgfm, zzgwu zzgwu) {
        return new zzglx(zzgfm, zzgwu.zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgpj.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
