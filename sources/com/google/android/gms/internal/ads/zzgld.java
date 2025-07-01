package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgld {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgkz(), zzgie.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzglb(), zzghw.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgla(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzglc(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzghw zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgsx zzd2 = zzgsx.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    zzgib zzc2 = zzgie.zzc();
                    zzc2.zzb(zzd2.zzf().zzd());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgow.zzc()));
                    zzgie zze2 = zzc2.zze();
                    zzghu zza2 = zzghw.zza();
                    zza2.zzc(zze2);
                    zza2.zzb(zzgwv.zzb(zzd2.zzf().zzA(), zzggn));
                    zza2.zza(zzgow.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgie zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgta zzf2 = zzgta.zzf(zzgox.zzc().zzh(), zzgyh.zza());
                if (zzf2.zzb() == 0) {
                    zzgib zzc2 = zzgie.zzc();
                    zzc2.zzb(zzf2.zza());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgox.zzc().zzg()));
                    return zzc2.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzghw zzghw, zzggn zzggn) {
        zzgsv zzb2 = zzgsx.zzb();
        byte[] zzd2 = zzghw.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgsx) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzg(zzghw.zzb().zzd()), zzghw.zze());
    }

    public static /* synthetic */ zzgox zzd(zzgie zzgie) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgsy zzc2 = zzgta.zzc();
        zzc2.zza(zzgie.zzb());
        zza2.zzc(((zzgta) zzc2.zzbr()).zzaN());
        zza2.zza(zzg(zzgie.zzd()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgic zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgic.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgic.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgic.zzb;
    }

    private static zzgve zzg(zzgic zzgic) throws GeneralSecurityException {
        if (zzgic.zza.equals(zzgic)) {
            return zzgve.TINK;
        }
        if (zzgic.zzb.equals(zzgic)) {
            return zzgve.CRUNCHY;
        }
        if (zzgic.zzc.equals(zzgic)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgic))));
    }
}
