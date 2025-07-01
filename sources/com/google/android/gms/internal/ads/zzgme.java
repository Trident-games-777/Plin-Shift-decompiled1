package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgme {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgma(), zzgkm.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgmc(), zzgkg.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgmb(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgmd(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgkg zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzgvk zzd2 = zzgvk.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    return zzgkg.zza(zzf(zzgow.zzc()), zzgwv.zzb(zzd2.zzf().zzA(), zzggn), zzgow.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgkm zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzgvn.zzd(zzgox.zzc().zzh(), zzgyh.zza()).zza() == 0) {
                    return zzgkm.zzc(zzf(zzgox.zzc().zzg()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgkg zzgkg, zzggn zzggn) {
        zzgvi zzb2 = zzgvk.zzb();
        byte[] zzd2 = zzgkg.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgvk) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzg(zzgkg.zzb().zzb()), zzgkg.zze());
    }

    public static /* synthetic */ zzgox zzd(zzgkm zzgkm) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzgvn.zzc().zzaN());
        zza2.zza(zzg(zzgkm.zzb()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgkl zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgkl.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgkl.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgkl.zzb;
    }

    private static zzgve zzg(zzgkl zzgkl) throws GeneralSecurityException {
        if (zzgkl.zza.equals(zzgkl)) {
            return zzgve.TINK;
        }
        if (zzgkl.zzb.equals(zzgkl)) {
            return zzgve.CRUNCHY;
        }
        if (zzgkl.zzc.equals(zzgkl)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgkl.toString()));
    }
}
