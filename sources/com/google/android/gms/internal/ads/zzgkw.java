package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgks(), zzght.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgku(), zzghm.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgkt(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgkv(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzghm zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgso zzd2 = zzgso.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    zzghq zzd3 = zzght.zzd();
                    zzd3.zzb(zzd2.zzg().zzd());
                    zzd3.zza(zzd2.zzf().zza());
                    zzd3.zzc(16);
                    zzd3.zzd(zzf(zzgow.zzc()));
                    zzght zze2 = zzd3.zze();
                    zzghk zza2 = zzghm.zza();
                    zza2.zzc(zze2);
                    zza2.zzb(zzgwv.zzb(zzd2.zzg().zzA(), zzggn));
                    zza2.zza(zzgow.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzght zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgsr zzd2 = zzgsr.zzd(zzgox.zzc().zzh(), zzgyh.zza());
                zzghq zzd3 = zzght.zzd();
                zzd3.zzb(zzd2.zza());
                zzd3.zza(zzd2.zzf().zza());
                zzd3.zzc(16);
                zzd3.zzd(zzf(zzgox.zzc().zzg()));
                return zzd3.zze();
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzghm zzghm, zzggn zzggn) {
        zzgsm zzb2 = zzgso.zzb();
        zzb2.zzb(zzg(zzghm.zzb()));
        byte[] zzd2 = zzghm.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgso) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzh(zzghm.zzb().zze()), zzghm.zze());
    }

    public static /* synthetic */ zzgox zzd(zzght zzght) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgsp zzb2 = zzgsr.zzb();
        zzb2.zzb(zzg(zzght));
        zzb2.zza(zzght.zzc());
        zza2.zzc(((zzgsr) zzb2.zzbr()).zzaN());
        zza2.zza(zzh(zzght.zze()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzghr zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzghr.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghr.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzghr.zzb;
    }

    private static zzgsu zzg(zzght zzght) throws GeneralSecurityException {
        zzgss zzb2 = zzgsu.zzb();
        zzb2.zza(zzght.zzb());
        return (zzgsu) zzb2.zzbr();
    }

    private static zzgve zzh(zzghr zzghr) throws GeneralSecurityException {
        if (zzghr.zza.equals(zzghr)) {
            return zzgve.TINK;
        }
        if (zzghr.zzb.equals(zzghr)) {
            return zzgve.CRUNCHY;
        }
        if (zzghr.zzc.equals(zzghr)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghr))));
    }
}
