package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgli {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgle(), zzgip.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzglg(), zzgih.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzglf(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzglh(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgih zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgtd zzd2 = zzgtd.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    zzgim zzc2 = zzgip.zzc();
                    zzc2.zza(zzd2.zzf().zzd());
                    zzc2.zzb(zzf(zzgow.zzc()));
                    zzgip zzc3 = zzc2.zzc();
                    zzgif zza2 = zzgih.zza();
                    zza2.zzc(zzc3);
                    zza2.zzb(zzgwv.zzb(zzd2.zzf().zzA(), zzggn));
                    zza2.zza(zzgow.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgip zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgtg zzf2 = zzgtg.zzf(zzgox.zzc().zzh(), zzgyh.zza());
                if (zzf2.zzb() == 0) {
                    zzgim zzc2 = zzgip.zzc();
                    zzc2.zza(zzf2.zza());
                    zzc2.zzb(zzf(zzgox.zzc().zzg()));
                    return zzc2.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgih zzgih, zzggn zzggn) {
        zzgtb zzb2 = zzgtd.zzb();
        byte[] zzd2 = zzgih.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgtd) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzg(zzgih.zzb().zzd()), zzgih.zze());
    }

    public static /* synthetic */ zzgox zzd(zzgip zzgip) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgte zzc2 = zzgtg.zzc();
        zzc2.zza(zzgip.zzb());
        zza2.zzc(((zzgtg) zzc2.zzbr()).zzaN());
        zza2.zza(zzg(zzgip.zzd()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgin zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgin.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgin.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgin.zzb;
    }

    private static zzgve zzg(zzgin zzgin) throws GeneralSecurityException {
        if (zzgin.zza.equals(zzgin)) {
            return zzgve.TINK;
        }
        if (zzgin.zzb.equals(zzgin)) {
            return zzgve.CRUNCHY;
        }
        if (zzgin.zzc.equals(zzgin)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgin))));
    }
}
