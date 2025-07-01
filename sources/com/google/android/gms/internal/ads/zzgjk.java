package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgjk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgjg(), zzgjf.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgji(), zzgjd.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgjh(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgjj(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgjd zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzguu zzd2 = zzguu.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    return zzgjd.zza(zzgjf.zzc(zzd2.zzf().zzf(), zzf(zzgow.zzc())), zzgow.zzf());
                }
                String valueOf = String.valueOf(zzd2);
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + valueOf);
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgjf zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzgjf.zzc(zzgux.zzd(zzgox.zzc().zzh(), zzgyh.zza()).zzf(), zzf(zzgox.zzc().zzg()));
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgjd zzgjd, zzggn zzggn) {
        zzgus zzb2 = zzguu.zzb();
        zzguv zza2 = zzgux.zza();
        zza2.zza(zzgjd.zzb().zzd());
        zzb2.zza((zzgux) zza2.zzbr());
        return zzgow.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzguu) zzb2.zzbr()).zzaN(), zzgty.REMOTE, zzg(zzgjd.zzb().zzb()), zzgjd.zzd());
    }

    public static /* synthetic */ zzgox zzd(zzgjf zzgjf) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzguv zza3 = zzgux.zza();
        zza3.zza(zzgjf.zzd());
        zza2.zzc(((zzgux) zza3.zzbr()).zzaN());
        zza2.zza(zzg(zzgjf.zzb()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgje zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgje.zza;
        }
        if (ordinal == 3) {
            return zzgje.zzb;
        }
        int zza2 = zzgve.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zzgve zzg(zzgje zzgje) throws GeneralSecurityException {
        if (zzgje.zza.equals(zzgje)) {
            return zzgve.TINK;
        }
        if (zzgje.zzb.equals(zzgje)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgje.toString()));
    }
}
