package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbw {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    /* access modifiers changed from: private */
    public final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzgbw(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = r3
        L_0x000a:
            int r5 = r11.length
            if (r4 >= r5) goto L_0x002b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L_0x0014
            r7 = r6
            goto L_0x0015
        L_0x0014:
            r7 = r3
        L_0x0015:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.gms.internal.ads.zzfwq.zzg(r7, r8, r5)
            byte r7 = r1[r5]
            if (r7 != r2) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r6 = r3
        L_0x0020:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.gms.internal.ads.zzfwq.zzg(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto L_0x000a
        L_0x002b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbw.<init>(java.lang.String, char[]):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzgbw) {
            zzgbw zzgbw = (zzgbw) obj;
            if (this.zzi != zzgbw.zzi || !Arrays.equals(this.zzf, zzgbw.zzf)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzi ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final char zza(int i) {
        return this.zzf[i];
    }

    /* access modifiers changed from: package-private */
    public final int zzb(char c) throws zzgbz {
        if (c <= 127) {
            byte b = this.zzg[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                throw new zzgbz("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
            }
            throw new zzgbz("Unrecognized character: " + c);
        }
        throw new zzgbz("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
    }

    /* access modifiers changed from: package-private */
    public final zzgbw zzc() {
        boolean z;
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr = this.zzf;
            if (i2 >= cArr.length) {
                return this;
            }
            if (zzfwa.zze(cArr[i2])) {
                int i3 = 0;
                while (true) {
                    if (i3 >= cArr.length) {
                        z = false;
                        break;
                    } else if (zzfwa.zzd(cArr[i3])) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                zzfwq.zzl(!z, "Cannot call lowerCase() on a mixed-case alphabet");
                char[] cArr2 = new char[this.zzf.length];
                while (true) {
                    char[] cArr3 = this.zzf;
                    if (i >= cArr3.length) {
                        break;
                    }
                    char c = cArr3[i];
                    if (zzfwa.zze(c)) {
                        c ^= ' ';
                    }
                    cArr2[i] = (char) c;
                    i++;
                }
                zzgbw zzgbw = new zzgbw(this.zze.concat(".lowerCase()"), cArr2);
                if (!this.zzi || zzgbw.zzi) {
                    return zzgbw;
                }
                byte[] bArr = zzgbw.zzg;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                for (int i4 = 65; i4 <= 90; i4++) {
                    int i5 = i4 | 32;
                    byte[] bArr2 = zzgbw.zzg;
                    byte b = bArr2[i4];
                    byte b2 = bArr2[i5];
                    if (b == -1) {
                        copyOf[i4] = b2;
                    } else {
                        char c2 = (char) i4;
                        char c3 = (char) i5;
                        if (b2 == -1) {
                            copyOf[i5] = b;
                        } else {
                            throw new IllegalStateException(zzfxf.zzb("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c2), Character.valueOf(c3)));
                        }
                    }
                }
                return new zzgbw(zzgbw.zze.concat(".ignoreCase()"), zzgbw.zzf, copyOf, true);
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(int i) {
        return this.zzh[i % this.zzc];
    }

    public final boolean zze(char c) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzgbw(String str, char[] cArr, byte[] bArr, boolean z) {
        String str2 = str;
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzc2 = zzgck.zzc(length, RoundingMode.UNNECESSARY);
            this.zzb = zzc2;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzc2);
            int i = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i;
            this.zzd = zzc2 >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < this.zzd; i2++) {
                zArr[zzgck.zzb(i2 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = z;
        } catch (ArithmeticException e) {
            int length2 = cArr.length;
            throw new IllegalArgumentException("Illegal alphabet length " + length2, e);
        }
    }
}
