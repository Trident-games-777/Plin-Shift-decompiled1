package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgvw implements zzgfm {
    private final zzgwm zza;
    private final zzggi zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgvw(zzgwm zzgwm, zzggi zzggi, int i, byte[] bArr) {
        this.zza = zzgwm;
        this.zzb = zzggi;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgfm zzb(zzgha zzgha) throws GeneralSecurityException {
        zzgvp zzgvp = new zzgvp(zzgha.zzd().zzd(zzgfv.zza()), zzgha.zzb().zzd());
        String valueOf = String.valueOf(String.valueOf(zzgha.zzb().zzg()));
        return new zzgvw(zzgvp, new zzgwr(new zzgwq("HMAC".concat(valueOf), new SecretKeySpec(zzgha.zze().zzd(zzgfv.zza()), "HMAC")), zzgha.zzb().zze()), zzgha.zzb().zze(), zzgha.zzc().zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int i = this.zzc;
        int length = bArr3.length;
        int length2 = bArr.length;
        if (length2 < i + length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzgpj.zzc(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, length2 - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length2 - this.zzc, length2);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            if (MessageDigest.isEqual(((zzgwr) this.zzb).zzc(zzgvu.zzb(bArr2, copyOfRange, copyOf)), copyOfRange2)) {
                return this.zza.zza(copyOfRange);
            }
            throw new GeneralSecurityException("invalid MAC");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
