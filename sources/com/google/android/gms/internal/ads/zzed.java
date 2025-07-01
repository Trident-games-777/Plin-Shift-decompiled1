package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzed {
    private static final char[] zza = {13, 10};
    private static final char[] zzb = {10};
    private static final zzfzt zzc = zzfzt.zzr(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzed() {
        this.zzd = zzen.zzf;
    }

    public zzed(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
    }

    private final char zzO(Charset charset, char[] cArr) {
        int zzP = zzP(charset);
        if (zzP != 0) {
            int i = zzP >> 16;
            for (char c : cArr) {
                char c2 = (char) i;
                if (c == c2) {
                    this.zze += (char) zzP;
                    return c2;
                }
            }
        }
        return 0;
    }

    private final int zzP(Charset charset) {
        byte b;
        char zzb2;
        int i = 1;
        if (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) {
            int i2 = this.zzf;
            int i3 = this.zze;
            if (i2 - i3 > 0) {
                b = (byte) zzgco.zza((long) (this.zzd[i3] & 255));
                return (zzgco.zza((long) b) << 16) + i;
            }
        }
        if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
            int i4 = this.zzf;
            int i5 = this.zze;
            if (i4 - i5 >= 2) {
                byte[] bArr = this.zzd;
                zzb2 = zzgco.zzb(bArr[i5], bArr[i5 + 1]);
                b = (byte) zzb2;
                i = 2;
                return (zzgco.zza((long) b) << 16) + i;
            }
        }
        if (!charset.equals(StandardCharsets.UTF_16LE)) {
            return 0;
        }
        int i6 = this.zzf;
        int i7 = this.zze;
        if (i6 - i7 < 2) {
            return 0;
        }
        byte[] bArr2 = this.zzd;
        zzb2 = zzgco.zzb(bArr2[i7 + 1], bArr2[i7]);
        b = (byte) zzb2;
        i = 2;
        return (zzgco.zza((long) b) << 16) + i;
    }

    public final String zzA(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zze;
        int i3 = (i2 + i) - 1;
        String zzC = zzen.zzC(this.zzd, i2, (i3 >= this.zzf || this.zzd[i3] != 0) ? i : i - 1);
        this.zze += i;
        return zzC;
    }

    public final String zzB(int i, Charset charset) {
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String str = new String(bArr, i2, i, charset);
        this.zze = i2 + i;
        return str;
    }

    public final Charset zzC() {
        int i = this.zzf;
        int i2 = this.zze;
        int i3 = i - i2;
        if (i3 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.zze = i2 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (i3 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b = bArr2[i2];
        if (b == -2) {
            if (bArr2[i2 + 1] != -1) {
                return null;
            }
            this.zze = i2 + 2;
            return StandardCharsets.UTF_16BE;
        } else if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        } else {
            this.zze = i2 + 2;
            return StandardCharsets.UTF_16LE;
        }
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        this.zze = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
    }

    public final short zzE() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        this.zze = i + 2;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public final void zzF(int i) {
        byte[] bArr = this.zzd;
        if (i > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i);
        }
    }

    public final void zzG(zzec zzec, int i) {
        zzH(zzec.zza, 0, i);
        zzec.zzl(0);
    }

    public final void zzH(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zzd, this.zze, bArr, i, i2);
        this.zze += i2;
    }

    public final void zzI(int i) {
        byte[] bArr = this.zzd;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzJ(bArr, i);
    }

    public final void zzJ(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
        this.zze = 0;
    }

    public final void zzK(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzd.length) {
            z = true;
        }
        zzdb.zzd(z);
        this.zzf = i;
    }

    public final void zzL(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzf) {
            z = true;
        }
        zzdb.zzd(z);
        this.zze = i;
    }

    public final void zzM(int i) {
        zzL(this.zze + i);
    }

    public final byte[] zzN() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzdb.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        return (char) (zzP(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        int i4 = i + 3;
        this.zze = i4;
        this.zze = i + 4;
        return (bArr[i4] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i2] & 255) << Ascii.DLE) | ((bArr[i3] & 255) << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        this.zze = i + 3;
        return (bArr[i3] & 255) | (((bArr[i] & 255) << Ascii.CAN) >> 8) | ((bArr[i2] & 255) << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        int i4 = i + 3;
        this.zze = i4;
        this.zze = i + 4;
        int i5 = (bArr[i2] & 255) << 8;
        return ((bArr[i4] & 255) << Ascii.CAN) | i5 | (bArr[i] & 255) | ((bArr[i3] & 255) << Ascii.DLE);
    }

    public final int zzj() {
        int zzi = zzi();
        if (zzi >= 0) {
            return zzi;
        }
        throw new IllegalStateException("Top bit not zero: " + zzi);
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        this.zze = i + 2;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        this.zze = i + 1;
        return bArr[i] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        this.zze = i + 2;
        this.zze = i + 4;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        this.zze = i + 3;
        return (bArr[i3] & 255) | ((bArr[i] & 255) << Ascii.DLE) | ((bArr[i2] & 255) << 8);
    }

    public final int zzp() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException("Top bit not zero: " + zzg);
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        this.zze = i + 2;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        long j = (long) bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j2 = (long) bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j3 = (long) bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j4 = (long) bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        byte[] bArr2 = bArr;
        int i8 = i;
        long j5 = (long) bArr[i6];
        int i9 = i8 + 7;
        this.zze = i9;
        long j6 = j5;
        long j7 = (long) bArr2[i7];
        this.zze = i8 + 8;
        return ((((long) bArr2[i9]) & 255) << 56) | (255 & ((long) bArr[i])) | ((j & 255) << 8) | ((j2 & 255) << 16) | ((j3 & 255) << 24) | ((j4 & 255) << 32) | ((j6 & 255) << 40) | ((j7 & 255) << 48);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        long j = (long) bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j2 = (long) bArr[i3];
        this.zze = i + 4;
        return ((((long) bArr[i4]) & 255) << 24) | (((long) bArr[i]) & 255) | ((j & 255) << 8) | ((j2 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        long j = (long) bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j2 = (long) bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j3 = (long) bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j4 = (long) bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        byte[] bArr2 = bArr;
        int i8 = i;
        long j5 = (long) bArr[i6];
        int i9 = i8 + 7;
        this.zze = i9;
        long j6 = j5;
        long j7 = (long) bArr2[i7];
        this.zze = i8 + 8;
        return (((long) bArr2[i9]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((j & 255) << 48) | ((j2 & 255) << 40) | ((j3 & 255) << 32) | ((j4 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = i + 2;
        this.zze = i3;
        long j = (long) bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        this.zze = i + 4;
        long j2 = j & 255;
        return (((long) bArr[i4]) & 255) | ((((long) bArr[i]) & 255) << 24) | (j2 << 16) | ((((long) bArr[i3]) & 255) << 8);
    }

    public final long zzw() {
        long zzt = zzt();
        if (zzt >= 0) {
            return zzt;
        }
        throw new IllegalStateException("Top bit not zero: " + zzt);
    }

    public final long zzx() {
        int i;
        int i2;
        long j = (long) this.zzd[this.zze];
        int i3 = 7;
        while (true) {
            i = 0;
            i2 = 1;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i != 0) {
            while (i2 < i) {
                byte b = this.zzd[this.zze + i2];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & Utf8.REPLACEMENT_BYTE));
                    i2++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.zze += i;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }

    public final String zzy(char c) {
        int i = this.zzf;
        int i2 = this.zze;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.zzf && this.zzd[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zzd;
        int i3 = this.zze;
        String zzC = zzen.zzC(bArr, i3, i2 - i3);
        this.zze = i2;
        if (i2 < this.zzf) {
            this.zze = i2 + 1;
        }
        return zzC;
    }

    public final String zzz(Charset charset) {
        zzdb.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        if (this.zzf - this.zze == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            zzC();
        }
        int i = 1;
        if (!charset.equals(StandardCharsets.UTF_8) && !charset.equals(StandardCharsets.US_ASCII)) {
            i = 2;
            if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
                throw new IllegalArgumentException("Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
            }
        }
        int i2 = this.zze;
        while (true) {
            int i3 = this.zzf;
            if (i2 >= i3 - (i - 1)) {
                i2 = i3;
                break;
            } else if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && zzen.zzL(this.zzd[i2])) {
                break;
            } else {
                if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                    byte[] bArr = this.zzd;
                    if (bArr[i2] == 0 && zzen.zzL(bArr[i2 + 1])) {
                        break;
                    }
                }
                if (charset.equals(StandardCharsets.UTF_16LE)) {
                    byte[] bArr2 = this.zzd;
                    if (bArr2[i2 + 1] == 0 && zzen.zzL(bArr2[i2])) {
                        break;
                    }
                }
                i2 += i;
            }
        }
        String zzB = zzB(i2 - this.zze, charset);
        if (this.zze != this.zzf && zzO(charset, zza) == 13) {
            zzO(charset, zzb);
        }
        return zzB;
    }

    public zzed(int i) {
        this.zzd = new byte[i];
        this.zzf = i;
    }

    public final long zzv() {
        int i = 0;
        long j = 0;
        while (i < 9) {
            if (this.zze != this.zzf) {
                long zzm = (long) zzm();
                j |= (127 & zzm) << (i * 7);
                if ((zzm & 128) == 0) {
                    return j;
                }
                i++;
            } else {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
        }
        return j;
    }

    public zzed(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}
