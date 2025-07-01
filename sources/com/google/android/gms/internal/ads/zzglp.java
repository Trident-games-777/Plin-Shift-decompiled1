package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzglp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgll(), zzgiv.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgln(), zzgiq.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzglm(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzglo(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgiq zza(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgtj zzd2 = zzgtj.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    return zzgiq.zza(zzf(zzgow.zzc()), zzgwv.zzb(zzd2.zzf().zzA(), zzggn), zzgow.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgiv zzb(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgtm.zzc(zzgox.zzc().zzh(), zzgyh.zza());
                return zzgiv.zzc(zzf(zzgox.zzc().zzg()));
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgow zzc(zzgiq zzgiq, zzggn zzggn) {
        zzgth zzb2 = zzgtj.zzb();
        byte[] zzd2 = zzgiq.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgtj) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzg(zzgiq.zzb().zzb()), zzgiq.zze());
    }

    public static /* synthetic */ zzgox zzd(zzgiv zzgiv) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgtm.zzb().zzaN());
        zza2.zza(zzg(zzgiv.zzb()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgiu zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgiu.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgiu.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzgve.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgiu.zzb;
    }

    private static zzgve zzg(zzgiu zzgiu) throws GeneralSecurityException {
        if (zzgiu.zza.equals(zzgiu)) {
            return zzgve.TINK;
        }
        if (zzgiu.zzb.equals(zzgiu)) {
            return zzgve.CRUNCHY;
        }
        if (zzgiu.zzc.equals(zzgiu)) {
            return zzgve.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgiu.toString()));
    }
}
