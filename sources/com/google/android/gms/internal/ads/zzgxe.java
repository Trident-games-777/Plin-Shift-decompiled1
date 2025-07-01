package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgxe {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzgxd zzgxd) throws zzgzm {
        int zzh = zzh(bArr, i, zzgxd);
        int i2 = zzgxd.zza;
        if (i2 < 0) {
            throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 > bArr.length - zzh) {
            throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i2 == 0) {
            zzgxd.zzc = zzgxp.zzb;
            return zzh;
        } else {
            zzgxd.zzc = zzgxp.zzv(bArr, zzh, i2);
            return zzh + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzhbb zzhbb, byte[] bArr, int i, int i2, int i3, zzgxd zzgxd) throws IOException {
        Object zze = zzhbb.zze();
        zzhbb zzhbb2 = zzhbb;
        zzgxd zzgxd2 = zzgxd;
        int zzl = zzl(zze, zzhbb2, bArr, i, i2, i3, zzgxd2);
        zzhbb2.zzf(zze);
        zzgxd2.zzc = zze;
        return zzl;
    }

    static int zzd(zzhbb zzhbb, byte[] bArr, int i, int i2, zzgxd zzgxd) throws IOException {
        Object zze = zzhbb.zze();
        zzhbb zzhbb2 = zzhbb;
        zzgxd zzgxd2 = zzgxd;
        int zzm = zzm(zze, zzhbb2, bArr, i, i2, zzgxd2);
        zzhbb2.zzf(zze);
        zzgxd2.zzc = zze;
        return zzm;
    }

    static int zze(zzhbb zzhbb, int i, byte[] bArr, int i2, int i3, zzgzj zzgzj, zzgxd zzgxd) throws IOException {
        int zzd = zzd(zzhbb, bArr, i2, i3, zzgxd);
        zzgzj.add(zzgxd.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzgxd);
            if (i != zzgxd.zza) {
                break;
            }
            zzd = zzd(zzhbb, bArr, zzh, i3, zzgxd);
            zzgzj.add(zzgxd.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzgzj zzgzj, zzgxd zzgxd) throws IOException {
        zzgyy zzgyy = (zzgyy) zzgzj;
        int zzh = zzh(bArr, i, zzgxd);
        int i2 = zzgxd.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzgxd);
            zzgyy.zzi(zzgxd.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzhbo zzhbo, zzgxd zzgxd) throws zzgzm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                zzgxd zzgxd2 = zzgxd;
                int zzk = zzk(bArr, i2, zzgxd2);
                zzhbo.zzj(i, Long.valueOf(zzgxd2.zzb));
                return zzk;
            } else if (i4 == 1) {
                zzhbo.zzj(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                byte[] bArr2 = bArr;
                zzgxd zzgxd3 = zzgxd;
                int zzh = zzh(bArr2, i2, zzgxd3);
                int i5 = zzgxd3.zza;
                if (i5 < 0) {
                    throw new zzgzm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i5 <= bArr2.length - zzh) {
                    if (i5 == 0) {
                        zzhbo.zzj(i, zzgxp.zzb);
                    } else {
                        zzhbo.zzj(i, zzgxp.zzv(bArr2, zzh, i5));
                    }
                    return zzh + i5;
                } else {
                    throw new zzgzm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzhbo zzf = zzhbo.zzf();
                int i7 = zzgxd.zze + 1;
                zzgxd.zze = i7;
                zzo(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i2, zzgxd);
                    int i9 = zzgxd.zza;
                    if (i9 == i6) {
                        i8 = i9;
                        i2 = zzh2;
                        break;
                    }
                    i2 = zzg(i9, bArr, zzh2, i3, zzf, zzgxd);
                    i8 = i9;
                }
                zzgxd zzgxd4 = zzgxd;
                zzgxd4.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzgzm("Failed to parse the message.");
                }
                zzhbo.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzhbo.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw new zzgzm("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zzgzm("Protocol message contained an invalid tag (zero).");
        }
    }

    static int zzh(byte[] bArr, int i, zzgxd zzgxd) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxd);
        }
        zzgxd.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgxd zzgxd) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgxd.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxd.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxd.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxd.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgxd.zza = i11;
                return i12;
            }
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzgzj zzgzj, zzgxd zzgxd) {
        zzgyy zzgyy = (zzgyy) zzgzj;
        int zzh = zzh(bArr, i2, zzgxd);
        zzgyy.zzi(zzgxd.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzgxd);
            if (i != zzgxd.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzgxd);
            zzgyy.zzi(zzgxd.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i, zzgxd zzgxd) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxd.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzgxd.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzhbb zzhbb, byte[] bArr, int i, int i2, int i3, zzgxd zzgxd) throws IOException {
        int i4 = zzgxd.zze + 1;
        zzgxd.zze = i4;
        zzo(i4);
        zzhal zzhal = (zzhal) zzhbb;
        Object obj2 = obj;
        int zzc = zzhal.zzc(obj2, bArr, i, i2, i3, zzgxd);
        zzgxd.zze--;
        zzgxd.zzc = obj2;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzm(java.lang.Object r6, com.google.android.gms.internal.ads.zzhbb r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzgxd r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            zzo(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            int r6 = r5.zze
            int r6 = r6 + -1
            r5.zze = r6
            r5.zzc = r1
            return r4
        L_0x002d:
            com.google.android.gms.internal.ads.zzgzm r6 = new com.google.android.gms.internal.ads.zzgzm
            java.lang.String r7 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r6.<init>((java.lang.String) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgxe.zzm(java.lang.Object, com.google.android.gms.internal.ads.zzhbb, byte[], int, int, com.google.android.gms.internal.ads.zzgxd):int");
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzo(int i) throws zzgzm {
        if (i >= zzb) {
            throw new zzgzm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
