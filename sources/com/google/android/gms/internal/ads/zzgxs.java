package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxs extends zzgxv {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzgxs(InputStream inputStream, int i, zzgxu zzgxu) {
        super((zzgxu) null);
        byte[] bArr = zzgzk.zzb;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zze.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzk += read;
                    i2 += read;
                } else {
                    throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzh = i4;
            this.zzg = i - i4;
            return;
        }
        this.zzh = 0;
    }

    private final void zzK(int i) throws IOException {
        if (zzL(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw new zzgzm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    private final boolean zzL(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 > i4) {
            int i5 = this.zzk;
            if (i > (Integer.MAX_VALUE - i5) - i2 || i5 + i2 + i > this.zzl) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                i5 = this.zzk + i2;
                this.zzk = i5;
                i4 = this.zzg - i2;
                this.zzg = i4;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i4, Math.min(4096 - i4, (Integer.MAX_VALUE - i5) - i4));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzJ();
                    if (this.zzg >= i) {
                        return true;
                    }
                    return zzL(i);
                }
            } catch (zzgzm e) {
                e.zza();
                throw e;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
    }

    private final byte[] zzM(int i, boolean z) throws IOException {
        byte[] zzN = zzN(i);
        if (zzN != null) {
            return zzN;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzI = zzI(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i) throws IOException {
        if (i == 0) {
            return zzgzk.zzb;
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if (-2147483647 + i4 <= 0) {
            int i5 = this.zzl;
            if (i4 <= i5) {
                int i6 = this.zzg - i3;
                int i7 = i - i6;
                if (i7 >= 4096) {
                    try {
                        if (i7 > this.zze.available()) {
                            return null;
                        }
                    } catch (zzgzm e) {
                        e.zza();
                        throw e;
                    }
                }
                byte[] bArr = new byte[i];
                System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
                this.zzk += this.zzg;
                this.zzi = 0;
                this.zzg = 0;
                while (i6 < i) {
                    try {
                        int read = this.zze.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.zzk += read;
                            i6 += read;
                        } else {
                            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                        }
                    } catch (zzgzm e2) {
                        e2.zza();
                        throw e2;
                    }
                }
                return bArr;
            }
            zzC((i5 - i2) - i3);
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgzm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final boolean zzA() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    public final boolean zzB() throws IOException {
        return zzq() != 0;
    }

    public final void zzC(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
        } else if (i >= 0) {
            int i5 = this.zzk;
            int i6 = i5 + i3;
            int i7 = this.zzl;
            if (i6 + i <= i7) {
                this.zzk = i6;
                this.zzg = 0;
                this.zzi = 0;
                while (i4 < i) {
                    try {
                        long j = (long) (i - i4);
                        long skip = this.zze.skip(j);
                        int i8 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i8 < 0 || skip > j) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i8 == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (zzgzm e) {
                        e.zza();
                        throw e;
                    } catch (Throwable th) {
                        this.zzk += i4;
                        zzJ();
                        throw th;
                    }
                }
                this.zzk += i4;
                zzJ();
                if (i4 < i) {
                    int i9 = this.zzg;
                    int i10 = i9 - this.zzi;
                    this.zzi = i9;
                    zzK(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzg;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzi = i12;
                            zzK(1);
                        } else {
                            this.zzi = i11;
                            return;
                        }
                    }
                }
            } else {
                zzC((i7 - i5) - i3);
                throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        } else {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    public final int zzc() {
        return this.zzk + this.zzi;
    }

    public final int zze() throws IOException {
        return zzi();
    }

    public final int zzf() throws IOException {
        return zzh();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzK(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    public final int zzj() throws IOException {
        return zzh();
    }

    public final int zzk() throws IOException {
        return zzD(zzi());
    }

    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzj = 0;
            return 0;
        }
        int zzi2 = zzi();
        this.zzj = zzi2;
        if ((zzi2 >>> 3) != 0) {
            return zzi2;
        }
        throw new zzgzm("Protocol message contained an invalid tag (zero).");
    }

    public final int zzm() throws IOException {
        return zzi();
    }

    public final long zzn() throws IOException {
        return zzp();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzK(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = (long) bArr[i + 2];
        long j2 = (long) bArr[i + 3];
        long j3 = (long) bArr[i + 4];
        long j4 = (long) bArr[i + 5];
        long j5 = (long) bArr[i + 6];
        return ((j5 & 255) << 48) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((j & 255) << 16) | ((j2 & 255) << 24) | ((j3 & 255) << 32) | ((j4 & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    /* access modifiers changed from: package-private */
    public final long zzr() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.zzi == this.zzg) {
                zzK(1);
            }
            byte[] bArr = this.zzf;
            int i2 = this.zzi;
            this.zzi = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & Byte.MAX_VALUE)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new zzgzm("CodedInputStream encountered a malformed varint.");
    }

    public final long zzs() throws IOException {
        return zzp();
    }

    public final long zzt() throws IOException {
        return zzF(zzq());
    }

    public final long zzu() throws IOException {
        return zzq();
    }

    public final zzgxp zzv() throws IOException {
        int zzi2 = zzi();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzi2 <= i - i2 && zzi2 > 0) {
            zzgxp zzv = zzgxp.zzv(this.zzf, i2, zzi2);
            this.zzi += zzi2;
            return zzv;
        } else if (zzi2 == 0) {
            return zzgxp.zzb;
        } else {
            if (zzi2 >= 0) {
                byte[] zzN = zzN(zzi2);
                if (zzN != null) {
                    return zzgxp.zzv(zzN, 0, zzN.length);
                }
                int i3 = this.zzi;
                int i4 = this.zzg;
                int i5 = i4 - i3;
                this.zzk += i4;
                this.zzi = 0;
                this.zzg = 0;
                List<byte[]> zzI = zzI(zzi2 - i5);
                byte[] bArr = new byte[zzi2];
                System.arraycopy(this.zzf, i3, bArr, 0, i5);
                for (byte[] bArr2 : zzI) {
                    int length = bArr2.length;
                    System.arraycopy(bArr2, 0, bArr, i5, length);
                    i5 += length;
                }
                return new zzgxm(bArr);
            }
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    public final String zzw() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzi2 <= i - i2) {
                String str = new String(this.zzf, i2, zzi2, zzgzk.zza);
                this.zzi += zzi2;
                return str;
            }
        }
        if (zzi2 == 0) {
            return "";
        }
        if (zzi2 < 0) {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (zzi2 > this.zzg) {
            return new String(zzM(zzi2, false), zzgzk.zza);
        } else {
            zzK(zzi2);
            String str2 = new String(this.zzf, this.zzi, zzi2, zzgzk.zza);
            this.zzi += zzi2;
            return str2;
        }
    }

    public final String zzx() throws IOException {
        byte[] bArr;
        int zzi2 = zzi();
        int i = this.zzi;
        int i2 = this.zzg;
        if (zzi2 <= i2 - i && zzi2 > 0) {
            bArr = this.zzf;
            this.zzi = i + zzi2;
        } else if (zzi2 == 0) {
            return "";
        } else {
            if (zzi2 >= 0) {
                i = 0;
                if (zzi2 <= i2) {
                    zzK(zzi2);
                    bArr = this.zzf;
                    this.zzi = zzi2;
                } else {
                    bArr = zzM(zzi2, false);
                }
            } else {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
        }
        return zzhbz.zzh(bArr, i, zzi2);
    }

    public final void zzy(int i) throws zzgzm {
        if (this.zzj != i) {
            throw new zzgzm("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void zzz(int i) {
        this.zzl = i;
        zzJ();
    }

    public final int zzd(int i) throws zzgzm {
        if (i >= 0) {
            int i2 = i + this.zzk + this.zzi;
            if (i2 >= 0) {
                int i3 = this.zzl;
                if (i2 <= i3) {
                    this.zzl = i2;
                    zzJ();
                    return i3;
                }
                throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw new zzgzm("Failed to parse the message.");
        }
        throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzi() throws IOException {
        byte b;
        byte b2;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzi = i3;
                return b3;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b4 = (bArr[i3] << 7) ^ b3;
                if (b4 < 0) {
                    b = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i + 3;
                    byte b5 = (bArr[i4] << Ascii.SO) ^ b4;
                    if (b5 >= 0) {
                        b2 = b5 ^ 16256;
                    } else {
                        int i6 = i + 4;
                        byte b6 = b5 ^ (bArr[i5] << Ascii.NAK);
                        if (b6 < 0) {
                            b = -2080896 ^ b6;
                        } else {
                            i5 = i + 5;
                            byte b7 = bArr[i6];
                            byte b8 = (b6 ^ (b7 << Ascii.FS)) ^ 266354560;
                            if (b7 < 0) {
                                i6 = i + 6;
                                if (bArr[i5] < 0) {
                                    i5 = i + 7;
                                    if (bArr[i6] < 0) {
                                        i6 = i + 8;
                                        if (bArr[i5] < 0) {
                                            i5 = i + 9;
                                            if (bArr[i6] < 0) {
                                                int i7 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    byte b9 = b8;
                                                    i4 = i7;
                                                    b = b9;
                                                }
                                            }
                                        }
                                    }
                                }
                                b = b8;
                            }
                            b2 = b8;
                        }
                        i4 = i6;
                    }
                    i4 = i5;
                }
                this.zzi = i4;
                return b;
            }
        }
        return (int) zzr();
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
                return (long) b;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b2 = (bArr[i3] << 7) ^ b;
                if (b2 < 0) {
                    j = (long) (b2 ^ Byte.MIN_VALUE);
                } else {
                    int i5 = i + 3;
                    byte b3 = (bArr[i4] << Ascii.SO) ^ b2;
                    if (b3 >= 0) {
                        j = (long) (b3 ^ 16256);
                    } else {
                        int i6 = i + 4;
                        byte b4 = b3 ^ (bArr[i5] << Ascii.NAK);
                        if (b4 < 0) {
                            i4 = i6;
                            j = (long) (-2080896 ^ b4);
                        } else {
                            i5 = i + 5;
                            long j4 = (((long) bArr[i6]) << 28) ^ ((long) b4);
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (((long) bArr[i5]) << 35) ^ j4;
                                if (j5 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i7 = i + 7;
                                    long j6 = j5 ^ (((long) bArr[i4]) << 42);
                                    if (j6 >= 0) {
                                        j2 = j6 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (((long) bArr[i7]) << 49);
                                        if (j5 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i + 9;
                                            long j7 = (j5 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i + 10;
                                                if (((long) bArr[i7]) >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                j2 = j7;
                                            }
                                        }
                                    }
                                    i4 = i7;
                                }
                                j = j5 ^ j3;
                            }
                        }
                    }
                    i4 = i5;
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzr();
    }
}
