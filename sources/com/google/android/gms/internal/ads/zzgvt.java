package com.google.android.gms.internal.ads;

import android.os.Build;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvt implements zzgfm {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzgvt(byte[] bArr, zzgwu zzgwu) throws GeneralSecurityException {
        if (zzgmh.zza(2)) {
            int i = zzgky.zza;
            zzgws.zza(bArr.length);
            this.zza = new SecretKeySpec(bArr, "AES");
            this.zzb = zzgwu.zzc();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static zzgfm zzb(zzghw zzghw) throws GeneralSecurityException {
        return new zzgvt(zzghw.zzd().zzd(zzgfv.zza()), zzghw.zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Integer num;
        if (bArr != null) {
            byte[] bArr3 = this.zzb;
            int length = bArr.length;
            if (length < bArr3.length + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzgpj.zzc(bArr3, bArr)) {
                byte[] bArr4 = this.zzb;
                int i = zzgky.zza;
                if (!Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
                    num = null;
                } else {
                    num = Integer.valueOf(Build.VERSION.SDK_INT);
                }
                if (num != null) {
                    num.intValue();
                }
                GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, bArr4.length, 12);
                SecretKey secretKey = this.zza;
                Cipher zza2 = zzgky.zza();
                zza2.init(2, secretKey, gCMParameterSpec);
                if (!(bArr2 == null || bArr2.length == 0)) {
                    zza2.updateAAD(bArr2);
                }
                int length2 = this.zzb.length;
                return zza2.doFinal(bArr, length2 + 12, (length - length2) - 12);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }
}
