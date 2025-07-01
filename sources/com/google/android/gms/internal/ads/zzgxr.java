package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxr extends zzgxv {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* synthetic */ zzgxr(Iterable iterable, int i, boolean z, zzgxu zzgxu) {
        super((zzgxu) null);
        this.zzh = i;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i == 0) {
            this.zzg = zzgzk.zzc;
            this.zzm = 0;
            this.zzn = 0;
            this.zzo = 0;
            return;
        }
        zzM();
    }

    private final int zzI() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzJ() throws zzgzm {
        if (this.zzf.hasNext()) {
            zzM();
            return;
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    private final void zzK(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= zzI()) {
            int i3 = i2;
            while (i3 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzJ();
                }
                int min = Math.min(i3, (int) (this.zzo - this.zzm));
                long j = (long) min;
                zzhbu.zzo(this.zzm, bArr, (long) (i2 - i3), j);
                i3 -= min;
                this.zzm += j;
            }
        } else if (i2 > 0) {
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzL() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzj;
        if (i > i2) {
            int i3 = i - i2;
            this.zzi = i3;
            this.zzh = i - i3;
            return;
        }
        this.zzi = 0;
    }

    private final void zzM() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = (long) byteBuffer.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = (long) this.zzg.limit();
        long zze2 = zzhbu.zze(this.zzg);
        this.zzm += zze2;
        this.zzn += zze2;
        this.zzo += zze2;
    }

    public final boolean zzA() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    public final boolean zzB() throws IOException {
        return zzr() != 0;
    }

    /* access modifiers changed from: package-private */
    public final long zzC() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzh2 = zzh();
            j |= ((long) (zzh2 & Byte.MAX_VALUE)) << i;
            if ((zzh2 & 128) == 0) {
                return j;
            }
        }
        throw new zzgzm("CodedInputStream encountered a malformed varint.");
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzc() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    public final int zze() throws IOException {
        return zzp();
    }

    public final int zzf() throws IOException {
        return zzi();
    }

    public final int zzg() throws IOException {
        return zzp();
    }

    public final byte zzh() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzJ();
        }
        long j = this.zzm;
        this.zzm = 1 + j;
        return zzhbu.zza(j);
    }

    public final int zzi() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 4) {
            this.zzm = 4 + j2;
            return (zzhbu.zza(j2) & 255) | ((zzhbu.zza(1 + j2) & 255) << 8) | ((zzhbu.zza(2 + j2) & 255) << Ascii.DLE) | ((zzhbu.zza(j2 + 3) & 255) << Ascii.CAN);
        }
        return (zzh() & 255) | ((zzh() & 255) << 8) | ((zzh() & 255) << Ascii.DLE) | ((zzh() & 255) << Ascii.CAN);
    }

    public final int zzj() throws IOException {
        return zzi();
    }

    public final int zzk() throws IOException {
        return zzD(zzp());
    }

    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzk = 0;
            return 0;
        }
        int zzp = zzp();
        this.zzk = zzp;
        if ((zzp >>> 3) != 0) {
            return zzp;
        }
        throw new zzgzm("Protocol message contained an invalid tag (zero).");
    }

    public final int zzm() throws IOException {
        return zzp();
    }

    public final long zzn() throws IOException {
        return zzq();
    }

    public final long zzo() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 8) {
            this.zzm = 8 + j2;
            byte zza = zzhbu.zza(1 + j2);
            long j3 = j2;
            byte zza2 = zzhbu.zza(j3 + 2);
            return (((long) zzhbu.zza(j2)) & 255) | ((((long) zza) & 255) << 8) | ((((long) zza2) & 255) << 16) | ((((long) zzhbu.zza(3 + j3)) & 255) << 24) | ((((long) zzhbu.zza(j3 + 4)) & 255) << 32) | ((((long) zzhbu.zza(j3 + 5)) & 255) << 40) | ((((long) zzhbu.zza(j3 + 6)) & 255) << 48) | ((((long) zzhbu.zza(j3 + 7)) & 255) << 56);
        }
        return ((((long) zzh()) & 255) << 56) | (((long) zzh()) & 255) | ((((long) zzh()) & 255) << 8) | ((((long) zzh()) & 255) << 16) | ((((long) zzh()) & 255) << 24) | ((((long) zzh()) & 255) << 32) | ((((long) zzh()) & 255) << 40) | ((((long) zzh()) & 255) << 48);
    }

    public final long zzs() throws IOException {
        return zzq();
    }

    public final long zzt() throws IOException {
        return zzF(zzr());
    }

    public final long zzu() throws IOException {
        return zzr();
    }

    public final zzgxp zzv() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzp];
                zzhbu.zzo(j2, bArr, 0, j3);
                this.zzm += j3;
                return new zzgxm(bArr);
            }
        }
        if (zzp > 0 && zzp <= zzI()) {
            byte[] bArr2 = new byte[zzp];
            zzK(bArr2, 0, zzp);
            return new zzgxm(bArr2);
        } else if (zzp == 0) {
            return zzgxp.zzb;
        } else {
            if (zzp < 0) {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final String zzw() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[zzp];
                zzhbu.zzo(j2, bArr, 0, j3);
                String str = new String(bArr, zzgzk.zza);
                this.zzm += j3;
                return str;
            }
        }
        if (zzp > 0 && zzp <= zzI()) {
            byte[] bArr2 = new byte[zzp];
            zzK(bArr2, 0, zzp);
            return new String(bArr2, zzgzk.zza);
        } else if (zzp == 0) {
            return "";
        } else {
            if (zzp < 0) {
                throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final String zzx() throws IOException {
        int zzp = zzp();
        if (zzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = (long) zzp;
            if (j3 <= j - j2) {
                String zzg2 = zzhbz.zzg(this.zzg, (int) (j2 - this.zzn), zzp);
                this.zzm += j3;
                return zzg2;
            }
        }
        if (zzp >= 0 && zzp <= zzI()) {
            byte[] bArr = new byte[zzp];
            zzK(bArr, 0, zzp);
            return zzhbz.zzh(bArr, 0, zzp);
        } else if (zzp == 0) {
            return "";
        } else {
            if (zzp <= 0) {
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
        this.zzj = i;
        zzL();
    }

    public final int zzd(int i) throws zzgzm {
        if (i >= 0) {
            int zzc = i + zzc();
            int i2 = this.zzj;
            if (zzc <= i2) {
                this.zzj = zzc;
                zzL();
                return i2;
            }
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzp() throws IOException {
        byte b;
        byte b2;
        long j = this.zzm;
        if (this.zzo != j) {
            long j2 = j + 1;
            byte zza = zzhbu.zza(j);
            if (zza >= 0) {
                this.zzm++;
                return zza;
            } else if (this.zzo - this.zzm >= 10) {
                long j3 = 2 + j;
                byte zza2 = (zzhbu.zza(j2) << 7) ^ zza;
                if (zza2 < 0) {
                    b = zza2 ^ Byte.MIN_VALUE;
                } else {
                    long j4 = 3 + j;
                    byte zza3 = (zzhbu.zza(j3) << Ascii.SO) ^ zza2;
                    if (zza3 >= 0) {
                        b2 = zza3 ^ 16256;
                    } else {
                        long j5 = 4 + j;
                        byte zza4 = zza3 ^ (zzhbu.zza(j4) << Ascii.NAK);
                        if (zza4 < 0) {
                            b = -2080896 ^ zza4;
                        } else {
                            j4 = 5 + j;
                            byte zza5 = zzhbu.zza(j5);
                            byte b3 = (zza4 ^ (zza5 << Ascii.FS)) ^ 266354560;
                            if (zza5 < 0) {
                                j5 = 6 + j;
                                if (zzhbu.zza(j4) < 0) {
                                    j4 = 7 + j;
                                    if (zzhbu.zza(j5) < 0) {
                                        j5 = 8 + j;
                                        if (zzhbu.zza(j4) < 0) {
                                            j4 = 9 + j;
                                            if (zzhbu.zza(j5) < 0) {
                                                long j6 = j + 10;
                                                if (zzhbu.zza(j4) >= 0) {
                                                    long j7 = j6;
                                                    b = b3;
                                                    j3 = j7;
                                                }
                                            }
                                        }
                                    }
                                }
                                b = b3;
                            }
                            b2 = b3;
                        }
                        j3 = j5;
                    }
                    j3 = j4;
                }
                this.zzm = j3;
                return b;
            }
        }
        return (int) zzC();
    }

    public final long zzr() throws IOException {
        long j;
        long j2;
        long j3;
        long j4 = this.zzm;
        if (this.zzo != j4) {
            long j5 = j4 + 1;
            byte zza = zzhbu.zza(j4);
            if (zza >= 0) {
                this.zzm++;
                return (long) zza;
            } else if (this.zzo - this.zzm >= 10) {
                long j6 = 2 + j4;
                byte zza2 = (zzhbu.zza(j5) << 7) ^ zza;
                if (zza2 < 0) {
                    j = (long) (zza2 ^ Byte.MIN_VALUE);
                } else {
                    long j7 = 3 + j4;
                    byte zza3 = (zzhbu.zza(j6) << Ascii.SO) ^ zza2;
                    if (zza3 >= 0) {
                        j = (long) (zza3 ^ 16256);
                    } else {
                        long j8 = 4 + j4;
                        byte zza4 = zza3 ^ (zzhbu.zza(j7) << Ascii.NAK);
                        if (zza4 < 0) {
                            j = (long) (-2080896 ^ zza4);
                            j6 = j8;
                        } else {
                            j7 = 5 + j4;
                            long zza5 = (((long) zzhbu.zza(j8)) << 28) ^ ((long) zza4);
                            if (zza5 >= 0) {
                                j = 266354560 ^ zza5;
                            } else {
                                long j9 = 6 + j4;
                                long zza6 = zza5 ^ (((long) zzhbu.zza(j7)) << 35);
                                if (zza6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    long j10 = 7 + j4;
                                    long zza7 = zza6 ^ (((long) zzhbu.zza(j9)) << 42);
                                    if (zza7 >= 0) {
                                        j2 = 4363953127296L ^ zza7;
                                    } else {
                                        j9 = 8 + j4;
                                        zza6 = zza7 ^ (((long) zzhbu.zza(j10)) << 49);
                                        if (zza6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j10 = 9 + j4;
                                            long zza8 = (zza6 ^ (((long) zzhbu.zza(j9)) << 56)) ^ 71499008037633920L;
                                            if (zza8 < 0) {
                                                long j11 = j4 + 10;
                                                if (((long) zzhbu.zza(j10)) >= 0) {
                                                    long j12 = zza8;
                                                    j6 = j11;
                                                    j = j12;
                                                }
                                            } else {
                                                j2 = zza8;
                                            }
                                        }
                                    }
                                    j6 = j10;
                                }
                                j = j3 ^ zza6;
                                j6 = j9;
                            }
                        }
                    }
                    j6 = j7;
                }
                this.zzm = j6;
                return j;
            }
        }
        return zzC();
    }
}
