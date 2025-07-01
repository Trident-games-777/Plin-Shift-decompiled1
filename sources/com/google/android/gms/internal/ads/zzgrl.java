package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgrl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgwu zzb;
    private static final zzgmm zzc;
    private static final zzgmm zzd;
    private static final zzgoi zze = zzgoi.zzb(new zzgrh(), zzgql.class, zzgox.class);
    private static final zzgoe zzf;
    private static final zzgmw zzg = zzgmw.zzb(new zzgrj(), zzgqb.class, zzgow.class);
    private static final zzgms zzh;

    static {
        zzgwu zzb2 = zzgpj.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        zzgmk zza2 = zzgmm.zza();
        zza2.zza(zzgve.RAW, zzgqj.zzd);
        zza2.zza(zzgve.TINK, zzgqj.zza);
        zza2.zza(zzgve.LEGACY, zzgqj.zzc);
        zza2.zza(zzgve.CRUNCHY, zzgqj.zzb);
        zzc = zza2.zzb();
        zzgmk zza3 = zzgmm.zza();
        zza3.zza(zzgtn.SHA1, zzgqi.zza);
        zza3.zza(zzgtn.SHA224, zzgqi.zzb);
        zza3.zza(zzgtn.SHA256, zzgqi.zzc);
        zza3.zza(zzgtn.SHA384, zzgqi.zzd);
        zza3.zza(zzgtn.SHA512, zzgqi.zze);
        zzd = zza3.zzb();
        zzf = zzgoe.zzb(new zzgri(), zzb2, zzgox.class);
        zzh = zzgms.zzb(new zzgrk(), zzb2, zzgow.class);
    }

    public static /* synthetic */ zzgow zza(zzgqb zzgqb, zzggn zzggn) {
        zzgto zzb2 = zzgtq.zzb();
        zzb2.zzb(zzf(zzgqb.zzb()));
        byte[] zzd2 = zzgqb.zzd().zzd(zzggn);
        zzb2.zza(zzgxp.zzv(zzd2, 0, zzd2.length));
        return zzgow.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgtq) zzb2.zzbr()).zzaN(), zzgty.SYMMETRIC, (zzgve) zzc.zzb(zzgqb.zzb().zzg()), zzgqb.zze());
    }

    public static /* synthetic */ zzgox zzb(zzgql zzgql) {
        zzguc zza2 = zzgue.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgtr zzc2 = zzgtt.zzc();
        zzc2.zzb(zzf(zzgql));
        zzc2.zza(zzgql.zzc());
        zza2.zzc(((zzgtt) zzc2.zzbr()).zzaN());
        zza2.zza((zzgve) zzc.zzb(zzgql.zzg()));
        return zzgox.zzb((zzgue) zza2.zzbr());
    }

    public static /* synthetic */ zzgqb zzc(zzgow zzgow, zzggn zzggn) {
        if (zzgow.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgtq zzf2 = zzgtq.zzf(zzgow.zze(), zzgyh.zza());
                if (zzf2.zza() == 0) {
                    zzgqh zze2 = zzgql.zze();
                    zze2.zzb(zzf2.zzh().zzd());
                    zze2.zzc(zzf2.zzg().zza());
                    zze2.zza((zzgqi) zzd.zzc(zzf2.zzg().zzb()));
                    zze2.zzd((zzgqj) zzc.zzc(zzgow.zzc()));
                    zzgql zze3 = zze2.zze();
                    zzgpz zza2 = zzgqb.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgwv.zzb(zzf2.zzh().zzA(), zzggn));
                    zza2.zza(zzgow.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgql zzd(zzgox zzgox) {
        if (zzgox.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgtt zzg2 = zzgtt.zzg(zzgox.zzc().zzh(), zzgyh.zza());
                if (zzg2.zzb() == 0) {
                    zzgqh zze2 = zzgql.zze();
                    zze2.zzb(zzg2.zza());
                    zze2.zzc(zzg2.zzh().zza());
                    zze2.zza((zzgqi) zzd.zzc(zzg2.zzh().zzb()));
                    zze2.zzd((zzgqj) zzc.zzc(zzgox.zzc().zzg()));
                    return zze2.zze();
                }
                int zzb2 = zzg2.zzb();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
            } catch (zzgzm e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgox.zzc().zzi())));
        }
    }

    public static void zze(zzgnz zzgnz) throws GeneralSecurityException {
        zzgnz.zzi(zze);
        zzgnz.zzh(zzf);
        zzgnz.zzg(zzg);
        zzgnz.zzf(zzh);
    }

    private static zzgtw zzf(zzgql zzgql) throws GeneralSecurityException {
        zzgtu zzc2 = zzgtw.zzc();
        zzc2.zzb(zzgql.zzb());
        zzc2.zza((zzgtn) zzd.zzb(zzgql.zzf()));
        return (zzgtw) zzc2.zzbr();
    }
}
