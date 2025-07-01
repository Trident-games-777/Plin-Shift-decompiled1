package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrd {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgoi zzc = zzgoi.zzb(new zzgqz(), zzgpu.class, zzgox.class);
    private static final zzgoe zzd;
    private static final zzgmw zze = zzgmw.zzb(new zzgrb(), zzgpm.class, zzgow.class);
    private static final zzgms zzf;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        zzd = zzgoe.zzb(new zzgra(), zzb2, zzgox.class);
        zzf = zzgms.zzb(new zzgrc(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgow zza(zzgpm zzgpm, zzggn zzggn) {
        zzgro zzb2 = zzgrq.zzb();
        zzb2.zzb(zzg(zzgpm.zzb()));
        byte[] zzd2 = zzgpm.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgrq) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, zzh(zzgpm.zzb().zzf()), zzgpm.zze());
    }

    public static /* synthetic */ zzgox zzb(zzgpu zzgpu) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgrr zzb2 = zzgrt.zzb();
        zzb2.zzb(zzg(zzgpu));
        zzb2.zza(zzgpu.zzc());
        zza2.zzc(((zzgrt) zzb2.zzbr()).zzaN());
        zza2.zza(zzh(zzgpu.zzf()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static /* synthetic */ zzgpm zzc(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgrq zzd2 = zzgrq.zzd(zzgow.zze(), zzgyh.zza());
                if (zzd2.zza() == 0) {
                    zzgpr zze2 = zzgpu.zze();
                    zze2.zza(zzd2.zzg().zzd());
                    zze2.zzb(zzd2.zzf().zza());
                    zze2.zzc(zzf(zzgow.zzc()));
                    zzgpu zzd3 = zze2.zzd();
                    zzgpk zza2 = zzgpm.zza();
                    zza2.zzc(zzd3);
                    zza2.zza(zzgwv.zzb(zzd2.zzg().zzA(), zzggn));
                    zza2.zzb(zzgow.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgpu zzd(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgrt zzd2 = zzgrt.zzd(zzgox.zzc().zzh(), zzgyh.zza());
                zzgpr zze2 = zzgpu.zze();
                zze2.zza(zzd2.zza());
                zze2.zzb(zzd2.zzf().zza());
                zze2.zzc(zzf(zzgox.zzc().zzg()));
                return zze2.zzd();
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zzc);
        zzgnz.zzh(zzd);
        zzgnz.zzg(zze);
        zzgnz.zzf(zzf);
    }

    private static zzgps zzf(zzgve zzgve) throws GeneralSecurityException {
        int ordinal = zzgve.ordinal();
        if (ordinal == 1) {
            return zzgps.zza;
        }
        if (ordinal == 2) {
            return zzgps.zzc;
        }
        if (ordinal == 3) {
            return zzgps.zzd;
        }
        if (ordinal == 4) {
            return zzgps.zzb;
        }
        int zza2 = zzgve.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zzgrw zzg(zzgpu zzgpu) {
        zzgru zzb2 = zzgrw.zzb();
        zzb2.zza(zzgpu.zzb());
        return (zzgrw) zzb2.zzbr();
    }

    private static zzgve zzh(zzgps zzgps) throws GeneralSecurityException {
        if (zzgps.zza.equals(zzgps)) {
            return zzgve.TINK;
        }
        if (zzgps.zzb.equals(zzgps)) {
            return zzgve.CRUNCHY;
        }
        if (zzgps.zzd.equals(zzgps)) {
            return zzgve.RAW;
        }
        if (zzgps.zzc.equals(zzgps)) {
            return zzgve.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgps))));
    }
}
