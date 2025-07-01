package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgcb {
    private static final zzgcb zza = new zzgbx("base16()", "0123456789ABCDEF");

    static {
        new zzgby("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        new zzgby("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new zzgca("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzgca("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    }

    zzgcb() {
    }

    public static zzgcb zzi() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(byte[] bArr, CharSequence charSequence) throws zzgbz;

    /* access modifiers changed from: package-private */
    public abstract void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);

    /* access modifiers changed from: package-private */
    public abstract int zze(int i);

    public abstract zzgcb zzf();

    /* access modifiers changed from: package-private */
    public CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public final String zzj(byte[] bArr, int i, int i2) {
        zzfwq.zzj(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zze(i2));
        try {
            zzc(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence zzg = zzg(charSequence);
            int zzd = zzd(zzg.length());
            byte[] bArr = new byte[zzd];
            int zza2 = zza(bArr, zzg);
            if (zza2 == zzd) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzgbz e) {
            throw new IllegalArgumentException(e);
        }
    }
}
