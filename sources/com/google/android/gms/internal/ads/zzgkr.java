package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkr {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgkn(), zzghj.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgkp(), zzgha.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgko(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgkq(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgha zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgrz zzd2 = zzgrz.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zzd2.zzf().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zzd2.zzg().zza() == 0) {
                    zzghf zzf2 = zzghj.zzf();
                    zzf2.zza(zzd2.zzf().zzg().zzd());
                    zzf2.zzc(zzd2.zzg().zzh().zzd());
                    zzf2.zzd(zzd2.zzf().zzf().zza());
                    zzf2.zze(zzd2.zzg().zzg().zza());
                    zzf2.zzb(zzf(zzd2.zzg().zzg().zzb()));
                    zzf2.zzf(zzg(zzgow.zzc()));
                    zzghj zzg = zzf2.zzg();
                    zzggy zza2 = zzgha.zza();
                    zza2.zzd(zzg);
                    zza2.zza(zzgwv.zzb(zzd2.zzf().zzg().zzA(), zzggn));
                    zza2.zzb(zzgwv.zzb(zzd2.zzg().zzh().zzA(), zzggn));
                    zza2.zzc(zzgow.zzf());
                    return zza2.zze();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghj zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgsc zzc2 = zzgsc.zzc(zzgox.zzc().zzh(), zzgyh.zza());
                if (zzc2.zzf().zzb() == 0) {
                    zzghf zzf2 = zzghj.zzf();
                    zzf2.zza(zzc2.zzd().zza());
                    zzf2.zzc(zzc2.zzf().zza());
                    zzf2.zzd(zzc2.zzd().zzf().zza());
                    zzf2.zze(zzc2.zzf().zzh().zza());
                    zzf2.zzb(zzf(zzc2.zzf().zzh().zzb()));
                    zzf2.zzf(zzg(zzgox.zzc().zzg()));
                    return zzf2.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgha zzgha, zzggn zzggn) {
        zzgrx zzb2 = zzgrz.zzb();
        zzgsd zzb3 = zzgsf.zzb();
        zzgsj zzb4 = zzgsl.zzb();
        zzb4.zza(zzgha.zzb().zzd());
        zzb3.zzb((zzgsl) zzb4.zzbr());
        byte[] zzd2 = zzgha.zzd().zzd(zzggn);
        zzb3.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        zzb2.zza((zzgsf) zzb3.zzbr());
        zzgto zzb5 = zzgtq.zzb();
        zzb5.zzb(zzh(zzgha.zzb()));
        byte[] zzd3 = zzgha.zze().zzd(zzggn);
        zzb5.zza(zzgxp.zzv(zzd3, 0, zzd3.length));
        zzb2.zzb((zzgtq) zzb5.zzbr());
        return zzgow.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgrz) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzi(zzgha.zzb().zzh()), zzgha.zzf());
    }

    public static /* synthetic */ zzgox zzd(zzghj zzghj) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgsa zza3 = zzgsc.zza();
        zzgsg zzb2 = zzgsi.zzb();
        zzgsj zzb3 = zzgsl.zzb();
        zzb3.zza(zzghj.zzd());
        zzb2.zzb((zzgsl) zzb3.zzbr());
        zzb2.zza(zzghj.zzb());
        zza3.zza((zzgsi) zzb2.zzbr());
        zzgtr zzc2 = zzgtt.zzc();
        zzc2.zzb(zzh(zzghj));
        zzc2.zza(zzghj.zzc());
        zza3.zzb((zzgtt) zzc2.zzbr());
        zza2.zzc(((zzgsc) zza3.zzbr()).zzaN());
        zza2.zza(zzi(zzghj.zzh()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzghg zzf(zzgtn zzgtn) throws GeneralSecurityException {
        int ordinal = zzgtn.ordinal();
        if (ordinal == 1) {
            return zzghg.zza;
        }
        if (ordinal == 2) {
            return zzghg.zzd;
        }
        if (ordinal == 3) {
            return zzghg.zzc;
        }
        if (ordinal == 4) {
            return zzghg.zze;
        }
        if (ordinal == 5) {
            return zzghg.zzb;
        }
        int zza2 = zzgtn.zza();
        throw new GeneralSecurityException("Unable to parse HashType: " + zza2);
    }

    private static zzghh zzg(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzghh.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghh.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzghh.zzb;
    }

    private static zzgtw zzh(zzghj zzghj) throws GeneralSecurityException {
        zzgtn zzgtn;
        zzgtu zzc2 = zzgtw.zzc();
        zzc2.zzb(zzghj.zze());
        zzghg zzg = zzghj.zzg();
        if (zzghg.zza.equals(zzg)) {
            zzgtn = zzgtn.SHA1;
        } else if (zzghg.zzb.equals(zzg)) {
            zzgtn = zzgtn.SHA224;
        } else if (zzghg.zzc.equals(zzg)) {
            zzgtn = zzgtn.SHA256;
        } else if (zzghg.zzd.equals(zzg)) {
            zzgtn = zzgtn.SHA384;
        } else if (zzghg.zze.equals(zzg)) {
            zzgtn = zzgtn.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(String.valueOf(zzg))));
        }
        zzc2.zza(zzgtn);
        return (zzgtw) zzc2.zzbr();
    }

    private static zzgve zzi(zzghh zzghh) throws GeneralSecurityException {
        if (zzghh.zza.equals(zzghh)) {
            return zzgve.TINK;
        }
        if (zzghh.zzb.equals(zzghh)) {
            return zzgve.CRUNCHY;
        }
        if (zzghh.zzc.equals(zzghh)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzghh))));
    }
}
