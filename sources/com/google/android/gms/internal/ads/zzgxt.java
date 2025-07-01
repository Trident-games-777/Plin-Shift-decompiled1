package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxt extends zzgxv {
    private final ByteBuffer zze;
    private final long zzf;
    private long zzg;
    private long zzh;
    private final long zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzgxt(ByteBuffer byteBuffer, boolean z, zzgxu zzgxu) {
        super((zzgxu) null);
        this.zze = byteBuffer;
        long zze2 = zzhbu.zze(byteBuffer);
        this.zzf = zze2;
        this.zzg = ((long) byteBuffer.limit()) + zze2;
        long position = zze2 + ((long) byteBuffer.position());
        this.zzh = position;
        this.zzi = position;
    }

    private final int zzC() {
        return (int) (this.zzg - this.zzh);
    }

    private final void zzI() {
        long j = this.zzg + ((long) this.zzj);
        this.zzg = j;
        int i = (int) (j - this.zzi);
        int i2 = this.zzl;
        if (i > i2) {
            int i3 = i - i2;
            this.zzj = i3;
            this.zzg = j - ((long) i3);
            return;
        }
        this.zzj = 0;
    }

    public final boolean zzA() throws IOException {
        return this.zzh == this.zzg;
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
        return (int) (this.zzh - this.zzi);
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
        long j = this.zzh;
        if (this.zzg - j >= 4) {
            this.zzh = 4 + j;
            int zza = (zzhbu.zza(1 + j) & 255) << 8;
            return ((zzhbu.zza(j + 3) & 255) << Ascii.CAN) | zza | (zzhbu.zza(j) & 255) | ((zzhbu.zza(2 + j) & 255) << Ascii.DLE);
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
            this.zzk = 0;
            return 0;
        }
        int zzi2 = zzi();
        this.zzk = zzi2;
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
        long j = this.zzh;
        if (this.zzg - j >= 8) {
            this.zzh = 8 + j;
            long zza = (long) zzhbu.zza(6 + j);
            long j2 = zza;
            long zza2 = (long) zzhbu.zza(j + 7);
            return ((zza2 & 255) << 56) | (((long) zzhbu.zza(j)) & 255) | ((((long) zzhbu.zza(1 + j)) & 255) << 8) | ((((long) zzhbu.zza(2 + j)) & 255) << 16) | ((((long) zzhbu.zza(3 + j)) & 255) << 24) | ((((long) zzhbu.zza(4 + j)) & 255) << 32) | ((((long) zzhbu.zza(5 + j)) & 255) << 40) | ((j2 & 255) << 48);
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
        if (zzi2 > 0 && zzi2 <= zzC()) {
            byte[] bArr = new byte[zzi2];
            long j = (long) zzi2;
            zzhbu.zzo(this.zzh, bArr, 0, j);
            this.zzh += j;
            return new zzgxm(bArr);
        } else if (zzi2 == 0) {
            return zzgxp.zzb;
        } else {
            if (zzi2 < 0) {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final String zzw() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0 && zzi2 <= zzC()) {
            byte[] bArr = new byte[zzi2];
            long j = (long) zzi2;
            zzhbu.zzo(this.zzh, bArr, 0, j);
            String str = new String(bArr, zzgzk.zza);
            this.zzh += j;
            return str;
        } else if (zzi2 == 0) {
            return "";
        } else {
            if (zzi2 < 0) {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final String zzx() throws IOException {
        int zzi2 = zzi();
        if (zzi2 > 0 && zzi2 <= zzC()) {
            String zzg2 = zzhbz.zzg(this.zze, (int) (this.zzh - this.zzf), zzi2);
            this.zzh += (long) zzi2;
            return zzg2;
        } else if (zzi2 == 0) {
            return "";
        } else {
            if (zzi2 <= 0) {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final void zzy(int i) throws zzgzm {
        if (this.zzk != i) {
            throw new zzgzm("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void zzz(int i) {
        this.zzl = i;
        zzI();
    }

    public final int zzd(int i) throws zzgzm {
        if (i >= 0) {
            int zzc = i + zzc();
            int i2 = this.zzl;
            if (zzc <= i2) {
                this.zzl = zzc;
                zzI();
                return i2;
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* access modifiers changed from: package-private */
    public final long zzr() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            long j2 = this.zzh;
            if (j2 != this.zzg) {
                this.zzh = 1 + j2;
                byte zza = zzhbu.zza(j2);
                j |= ((long) (zza & Byte.MAX_VALUE)) << i;
                if ((zza & 128) == 0) {
                    return j;
                }
                i += 7;
            } else {
                throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        }
        throw new zzgzm("CodedInputStream encountered a malformed varint.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        if (com.google.android.gms.internal.ads.zzhbu.zza(r3) >= 0) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzi() throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.zzh
            long r2 = r9.zzg
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x0092
        L_0x000a:
            r2 = 1
            long r2 = r2 + r0
            byte r4 = com.google.android.gms.internal.ads.zzhbu.zza(r0)
            if (r4 < 0) goto L_0x0016
            r9.zzh = r2
            return r4
        L_0x0016:
            long r5 = r9.zzg
            long r5 = r5 - r2
            r7 = 9
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0092
            r5 = 2
            long r5 = r5 + r0
            byte r2 = com.google.android.gms.internal.ads.zzhbu.zza(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r4
            if (r2 >= 0) goto L_0x002e
            r0 = r2 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x008f
        L_0x002e:
            r3 = 3
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhbu.zza(r5)
            int r5 = r5 << 14
            r2 = r2 ^ r5
            if (r2 < 0) goto L_0x003e
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L_0x003c:
            r5 = r3
            goto L_0x008f
        L_0x003e:
            r5 = 4
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhbu.zza(r3)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L_0x004f
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x008f
        L_0x004f:
            r3 = 5
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhbu.zza(r5)
            int r6 = r5 << 28
            r2 = r2 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r6
            if (r5 >= 0) goto L_0x008d
            r5 = 6
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhbu.zza(r3)
            if (r3 >= 0) goto L_0x008b
            r3 = 7
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhbu.zza(r5)
            if (r5 >= 0) goto L_0x008d
            r5 = 8
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhbu.zza(r3)
            if (r3 >= 0) goto L_0x008b
            long r3 = r0 + r7
            byte r5 = com.google.android.gms.internal.ads.zzhbu.zza(r5)
            if (r5 >= 0) goto L_0x008d
            r5 = 10
            long r5 = r5 + r0
            byte r0 = com.google.android.gms.internal.ads.zzhbu.zza(r3)
            if (r0 < 0) goto L_0x0092
        L_0x008b:
            r0 = r2
            goto L_0x008f
        L_0x008d:
            r0 = r2
            goto L_0x003c
        L_0x008f:
            r9.zzh = r5
            return r0
        L_0x0092:
            long r0 = r9.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgxt.zzi():int");
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        long j3;
        byte b;
        long j4 = this.zzh;
        if (this.zzg != j4) {
            long j5 = 1 + j4;
            byte zza = zzhbu.zza(j4);
            if (zza >= 0) {
                this.zzh = j5;
                return (long) zza;
            } else if (this.zzg - j5 >= 9) {
                long j6 = 2 + j4;
                byte zza2 = (zzhbu.zza(j5) << 7) ^ zza;
                if (zza2 < 0) {
                    b = zza2 ^ Byte.MIN_VALUE;
                } else {
                    long j7 = 3 + j4;
                    byte zza3 = zza2 ^ (zzhbu.zza(j6) << Ascii.SO);
                    if (zza3 >= 0) {
                        j2 = (long) (zza3 ^ 16256);
                    } else {
                        j6 = 4 + j4;
                        byte zza4 = zza3 ^ (zzhbu.zza(j7) << Ascii.NAK);
                        if (zza4 < 0) {
                            b = -2080896 ^ zza4;
                        } else {
                            j7 = 5 + j4;
                            long zza5 = (((long) zzhbu.zza(j6)) << 28) ^ ((long) zza4);
                            if (zza5 >= 0) {
                                j2 = 266354560 ^ zza5;
                            } else {
                                long j8 = 6 + j4;
                                long zza6 = (((long) zzhbu.zza(j7)) << 35) ^ zza5;
                                if (zza6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    j = j4 + 7;
                                    long zza7 = zza6 ^ (((long) zzhbu.zza(j8)) << 42);
                                    if (zza7 >= 0) {
                                        j2 = 4363953127296L ^ zza7;
                                    } else {
                                        j8 = 8 + j4;
                                        zza6 = zza7 ^ (((long) zzhbu.zza(j)) << 49);
                                        if (zza6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j = j4 + 9;
                                            long zza8 = (zza6 ^ (((long) zzhbu.zza(j8)) << 56)) ^ 71499008037633920L;
                                            if (zza8 < 0) {
                                                long j9 = j4 + 10;
                                                if (((long) zzhbu.zza(j)) >= 0) {
                                                    j = j9;
                                                }
                                            }
                                            j2 = zza8;
                                        }
                                    }
                                    this.zzh = j;
                                    return j2;
                                }
                                j2 = j3 ^ zza6;
                                j = j8;
                                this.zzh = j;
                                return j2;
                            }
                        }
                    }
                    j = j7;
                    this.zzh = j;
                    return j2;
                }
                j2 = (long) b;
                this.zzh = j;
                return j2;
            }
        }
        return zzr();
    }
}
