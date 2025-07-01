package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgwr implements zzggi {
    private static final byte[] zza = {0};
    private final zzgrn zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgwr(zzgpm zzgpm) throws GeneralSecurityException {
        this.zzb = new zzgwo(zzgpm.zzd().zzd(zzgfv.zza()));
        this.zzc = zzgpm.zzb().zzb();
        this.zzd = zzgpm.zzc().zzc();
        if (zzgpm.zzb().zzf().equals(zzgps.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzggi zza(zzgpm zzgpm) throws GeneralSecurityException {
        return new zzgwr(zzgpm);
    }

    public static zzggi zzb(zzgqb zzgqb) throws GeneralSecurityException {
        return new zzgwr(zzgqb);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzgvu.zzb(this.zzd, this.zzb.zza(zzgvu.zzb(bArr, bArr2), this.zzc));
        }
        return zzgvu.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgwr(zzgqb zzgqb) throws GeneralSecurityException {
        String valueOf = String.valueOf(String.valueOf(zzgqb.zzb().zzf()));
        this.zzb = new zzgwq("HMAC".concat(valueOf), new SecretKeySpec(zzgqb.zzd().zzd(zzgfv.zza()), "HMAC"));
        this.zzc = zzgqb.zzb().zzb();
        this.zzd = zzgqb.zzc().zzc();
        if (zzgqb.zzb().zzg().equals(zzgqj.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgwr(zzgrn zzgrn, int i) throws GeneralSecurityException {
        this.zzb = zzgrn;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgrn.zza(new byte[0], i);
    }
}
