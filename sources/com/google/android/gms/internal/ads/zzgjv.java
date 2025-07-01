package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgjv {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgjr(), zzgjq.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgjt(), zzgjl.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgjs(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgju(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgjl zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzgva zzd2 = zzgva.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    return zzgjl.zza(zzf(zzd2.zzf(), zzgow.zzc()), zzgow.zzf());
                }
                String valueOf = String.valueOf(zzd2);
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + valueOf);
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgjq zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zzf(zzgvd.zzf(zzgox.zzc().zzh(), zzgyh.zza()), zzgox.zzc().zzg());
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgjl zzgjl, zzggn zzggn) {
        zzguy zzb2 = zzgva.zzb();
        zzb2.zza(zzg(zzgjl.zzb()));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgva) zzb2.zzbr()).zzaN(), zzgty.REMOTE, zzh(zzgjl.zzb().zzc()), zzgjl.zzd());
    }

    public static /* synthetic */ zzgox zzd(zzgjq zzgjq) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza2.zzc(zzg(zzgjq).zzaN());
        zza2.zza(zzh(zzgjq.zzc()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgjq zzf(zzgvd zzgvd, zzgve zzgve) throws GeneralSecurityException {
        zzgjn zzgjn;
        zzgjo zzgjo;
        zzguc zza2 = zzgue.zza();
        zza2.zzb(zzgvd.zza().zzi());
        zza2.zzc(zzgvd.zza().zzh());
        zza2.zza(zzgve.RAW);
        zzggj zza3 = zzggp.zza(((zzgue) zza2.zzbr()).zzaV());
        if (zza3 instanceof zzgie) {
            zzgjn = zzgjn.zza;
        } else if (zza3 instanceof zzgiv) {
            zzgjn = zzgjn.zzc;
        } else if (zza3 instanceof zzgkm) {
            zzgjn = zzgjn.zzb;
        } else if (zza3 instanceof zzghj) {
            zzgjn = zzgjn.zzd;
        } else if (zza3 instanceof zzght) {
            zzgjn = zzgjn.zze;
        } else if (zza3 instanceof zzgip) {
            zzgjn = zzgjn.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zza3.toString()));
        }
        zzgjm zzgjm = new zzgjm((zzgjp) null);
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            zzgjo = zzgjo.zza;
        } else if (ordinal == 3) {
            zzgjo = zzgjo.zzb;
        } else {
            int zza4 = zzgve.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza4);
        }
        zzgjm.zzd(zzgjo);
        zzgjm.zzc(zzgvd.zzg());
        zzgjm.zza((zzggt) zza3);
        zzgjm.zzb(zzgjn);
        return zzgjm.zze();
    }

    private static zzgvd zzg(zzgjq zzgjq) throws GeneralSecurityException {
        try {
            zzgue zzf2 = zzgue.zzf(zzggp.zzb(zzgjq.zzb()), zzgyh.zza());
            zzgvb zzb2 = zzgvd.zzb();
            zzb2.zzb(zzgjq.zzd());
            zzb2.zza(zzf2);
            return (zzgvd) zzb2.zzbr();
        } catch (zzgzm e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgve zzh(zzgjo zzgjo) throws GeneralSecurityException {
        if (zzgjo.zza.equals(zzgjo)) {
            return zzgve.TINK;
        }
        if (zzgjo.zzb.equals(zzgjo)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgjo))));
    }
}
