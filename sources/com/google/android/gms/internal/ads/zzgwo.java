package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgwo implements zzgrn {
    private static final ThreadLocal zza = new zzgwn();
    private final SecretKey zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    public zzgwo(byte[] bArr) throws GeneralSecurityException {
        zzgws.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzb = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zza2 = zzgre.zza(zzb2.doFinal(new byte[16]));
        this.zzc = zza2;
        this.zzd = zzgre.zza(zza2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            return (Cipher) zza.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zzc(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 + i]);
        }
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            SecretKey secretKey = this.zzb;
            Cipher zzb2 = zzb();
            int i2 = 1;
            zzb2.init(1, secretKey);
            int length = bArr.length;
            if (length != 0) {
                i2 = 1 + ((length - 1) >> 4);
            }
            int i3 = i2 - 1;
            int i4 = i3 * 16;
            if (i2 * 16 == length) {
                bArr2 = zzgvu.zzc(bArr, i4, this.zzc, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, length);
                int length2 = copyOfRange.length;
                if (length2 < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[length2] = Byte.MIN_VALUE;
                    byte[] bArr3 = this.zzd;
                    if (copyOf.length == 16) {
                        bArr2 = zzgvu.zzc(copyOf, 0, bArr3, 0, 16);
                    } else {
                        throw new IllegalArgumentException("The lengths of x and y should match.");
                    }
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr4 = new byte[16];
            byte[] bArr5 = new byte[16];
            int i5 = 0;
            while (i5 < i3) {
                zzc(bArr4, bArr, i5 * 16, bArr5);
                if (zzb2.doFinal(bArr5, 0, 16, bArr4) == 16) {
                    i5++;
                } else {
                    throw new IllegalStateException("Cipher didn't write full block");
                }
            }
            zzc(bArr4, bArr2, 0, bArr5);
            if (zzb2.doFinal(bArr5, 0, 16, bArr4) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            } else if (i == 16) {
                return bArr4;
            } else {
                return Arrays.copyOf(bArr4, i);
            }
        } else {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
    }
}
