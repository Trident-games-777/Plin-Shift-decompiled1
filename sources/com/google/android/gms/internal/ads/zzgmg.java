package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmg implements zzgfm {
    private static final byte[] zza = zzgwl.zza("7a806c");
    private static final byte[] zzb = zzgwl.zza("46bb91c3c5");
    private static final byte[] zzc = zzgwl.zza("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] zzd = zzgwl.zza("bae8e37fc83441b16034566b");
    private static final byte[] zze = zzgwl.zza("af60eb711bd85bc1e4d3e0a462e074eea428a8");
    private static final ThreadLocal zzf = new zzgmf();
    private final SecretKey zzg;
    private final byte[] zzh;

    private zzgmg(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zzh = bArr2;
        zzgws.zza(bArr.length);
        this.zzg = new SecretKeySpec(bArr, "AES");
    }

    public static zzgfm zzb(zzgih zzgih) throws GeneralSecurityException {
        return new zzgmg(zzgih.zzd().zzd(zzgfv.zza()), zzgih.zzc().zzc());
    }

    /* access modifiers changed from: private */
    public static boolean zzd(Cipher cipher) {
        try {
            byte[] bArr = zzd;
            cipher.init(2, new SecretKeySpec(zzc, "AES"), new GCMParameterSpec(128, bArr, 0, bArr.length));
            cipher.updateAAD(zzb);
            byte[] bArr2 = zze;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), zza);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    private final byte[] zze(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = (Cipher) zzf.get();
        if (cipher != null) {
            int length = bArr.length;
            if (length >= 28) {
                cipher.init(2, this.zzg, new GCMParameterSpec(128, bArr, 0, 12));
                if (!(bArr2 == null || bArr2.length == 0)) {
                    cipher.updateAAD(bArr2);
                }
                return cipher.doFinal(bArr, 12, length - 12);
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzh;
        if (bArr3.length == 0) {
            return zze(bArr, bArr2);
        }
        if (zzgpj.zzc(bArr3, bArr)) {
            byte[] bArr4 = this.zzh;
            return zze(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
