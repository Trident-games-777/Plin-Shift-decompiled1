package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvs implements zzgfm {
    private static final ThreadLocal zza = new zzgvq();
    private static final ThreadLocal zzb = new zzgvr();
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final SecretKeySpec zzf;
    private final int zzg;

    private zzgvs(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgmh.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i == 12 || i == 16) {
            this.zzg = i;
            zzgws.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.zzf = secretKeySpec;
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzd2 = zzd(cipher.doFinal(new byte[16]));
            this.zzc = zzd2;
            this.zzd = zzd(zzd2);
            this.zze = bArr2;
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    public static zzgfm zzb(zzghm zzghm) throws GeneralSecurityException {
        if (zzgmh.zza(1)) {
            return new zzgvs(zzghm.zzd().zzd(zzgfv.zza()), zzghm.zzb().zzb(), zzghm.zzc().zzc());
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private static void zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    private static byte[] zzd(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b + b) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        byte b2 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b2 + b2));
        return bArr2;
    }

    private final byte[] zze(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int length;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            zzc(bArr2, this.zzc);
            return cipher.doFinal(bArr2);
        }
        byte[] bArr3 = new byte[16];
        cipher.doFinal(bArr2, 0, 16, bArr3);
        byte[] bArr4 = bArr2;
        byte[] bArr5 = bArr3;
        byte[] bArr6 = bArr4;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr5[i5] = (byte) (bArr[(i2 + i4) + i5] ^ bArr5[i5]);
            }
            cipher.doFinal(bArr5, 0, 16, bArr6);
            i4 += 16;
            byte[] bArr7 = bArr5;
            bArr5 = bArr6;
            bArr6 = bArr7;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            zzc(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            int i6 = 0;
            while (true) {
                length = copyOfRange.length;
                if (i6 >= length) {
                    break;
                }
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
                i6++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            copyOfRange = copyOf;
        }
        zzc(bArr5, copyOfRange);
        cipher.doFinal(bArr5, 0, 16, bArr6);
        return bArr6;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        int length = bArr.length;
        int length2 = ((length - bArr3.length) - this.zzg) - 16;
        if (length2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        } else if (zzgpj.zzc(bArr3, bArr)) {
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zzf);
            byte[] bArr4 = bArr;
            byte[] zze2 = zze(cipher, 0, bArr4, this.zze.length, this.zzg);
            byte[] bArr5 = bArr4;
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr6 = bArr2;
            byte[] zze3 = zze(cipher, 1, bArr6, 0, bArr6.length);
            byte[] bArr7 = bArr5;
            byte[] zze4 = zze(cipher, 2, bArr7, this.zze.length + this.zzg, length2);
            byte[] bArr8 = bArr7;
            int i = length - 16;
            byte b = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                b = (byte) (b | (((bArr8[i + i2] ^ zze3[i2]) ^ zze2[i2]) ^ zze4[i2]));
            }
            if (b == 0) {
                Cipher cipher2 = (Cipher) zzb.get();
                cipher2.init(1, this.zzf, new IvParameterSpec(zze2));
                return cipher2.doFinal(bArr8, this.zze.length + this.zzg, length2);
            }
            throw new AEADBadTagException("tag mismatch");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
