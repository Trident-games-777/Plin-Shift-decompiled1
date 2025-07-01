package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxq extends zzgxv {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk = Integer.MAX_VALUE;

    /* synthetic */ zzgxq(byte[] bArr, int i, int i2, boolean z, zzgxu zzgxu) {
        super((zzgxu) null);
        this.zze = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzC() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    public final boolean zzA() throws IOException {
        return this.zzh == this.zzf;
    }

    public final boolean zzB() throws IOException {
        return zzq() != 0;
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    public final int zzc() {
        return this.zzh - this.zzi;
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
        int i = this.zzh;
        if (this.zzf - i >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i + 4;
            int i2 = (bArr[i + 1] & 255) << 8;
            return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        int i = this.zzh;
        if (this.zzf - i >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i + 8;
            long j = (long) bArr[i + 2];
            long j2 = (long) bArr[i + 3];
            long j3 = (long) bArr[i + 4];
            long j4 = (long) bArr[i + 5];
            long j5 = (long) bArr[i + 6];
            return ((j5 & 255) << 48) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((j & 255) << 16) | ((j2 & 255) << 24) | ((j3 & 255) << 32) | ((j4 & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                zzgxp zzv = zzgxp.zzv(this.zze, i2, zzi2);
                this.zzh += zzi2;
                return zzv;
            }
        }
        if (zzi2 == 0) {
            return zzgxp.zzb;
        }
        if (zzi2 > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (zzi2 <= i3 - i4) {
                int i5 = zzi2 + i4;
                this.zzh = i5;
                return new zzgxm(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (zzi2 <= 0) {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final String zzw() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                String str = new String(this.zze, i2, zzi2, zzgzk.zza);
                this.zzh += zzi2;
                return str;
            }
        }
        if (zzi2 == 0) {
            return "";
        }
        if (zzi2 < 0) {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final String zzx() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzi2 <= i - i2) {
                String zzh2 = zzhbz.zzh(this.zze, i2, zzi2);
                this.zzh += zzi2;
                return zzh2;
            }
        }
        if (zzi2 == 0) {
            return "";
        }
        if (zzi2 <= 0) {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final void zzy(int i) throws zzgzm {
        if (this.zzj != i) {
            throw new zzgzm("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void zzz(int i) {
        this.zzk = i;
        zzC();
    }

    public final int zzd(int i) throws zzgzm {
        if (i >= 0) {
            int i2 = i + (this.zzh - this.zzi);
            if (i2 >= 0) {
                int i3 = this.zzk;
                if (i2 <= i3) {
                    this.zzk = i2;
                    zzC();
                    return i3;
                }
                throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw new zzgzm("Failed to parse the message.");
        }
        throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* access modifiers changed from: package-private */
    public final long zzr() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            int i2 = this.zzh;
            if (i2 != this.zzf) {
                byte[] bArr = this.zze;
                this.zzh = i2 + 1;
                byte b = bArr[i2];
                j |= ((long) (b & Byte.MAX_VALUE)) << i;
                if ((b & 128) == 0) {
                    return j;
                }
                i += 7;
            } else {
                throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        }
        throw new zzgzm("CodedInputStream encountered a malformed varint.");
    }

    public final int zzi() throws IOException {
        byte b;
        byte b2;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzh = i3;
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
                this.zzh = i4;
                return b;
            }
        }
        return (int) zzr();
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
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
                this.zzh = i4;
                return j;
            }
        }
        return zzr();
    }
}
