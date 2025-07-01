package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbz {
    private static final zzhbw zza = new zzhbx();

    static {
        if (zzhbu.zzA() && zzhbu.zzB()) {
            int i = zzgxc.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b = bArr[i - 1];
        if (i3 != 0) {
            if (i3 == 1) {
                return zzj(b, bArr[i]);
            }
            if (i3 == 2) {
                return zzk(b, bArr[i], bArr[i + 1]);
            }
            throw new AssertionError();
        } else if (b > -12) {
            return -1;
        } else {
            return b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            int r0 = r8.length()
            r1 = 0
        L_0x0005:
            int r2 = r10 + r11
            r3 = 128(0x80, float:1.794E-43)
            if (r1 >= r0) goto L_0x001b
            int r4 = r1 + r10
            if (r4 >= r2) goto L_0x001b
            char r5 = r8.charAt(r1)
            if (r5 >= r3) goto L_0x001b
            byte r2 = (byte) r5
            r9[r4] = r2
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001b:
            if (r1 != r0) goto L_0x001f
            int r10 = r10 + r0
            return r10
        L_0x001f:
            int r10 = r10 + r1
        L_0x0020:
            if (r1 >= r0) goto L_0x00fd
            char r11 = r8.charAt(r1)
            if (r11 >= r3) goto L_0x0032
            if (r10 >= r2) goto L_0x0032
            int r4 = r10 + 1
            byte r11 = (byte) r11
            r9[r10] = r11
            r10 = r4
            goto L_0x00b8
        L_0x0032:
            r4 = 2048(0x800, float:2.87E-42)
            if (r11 >= r4) goto L_0x004d
            int r4 = r2 + -2
            if (r10 > r4) goto L_0x004d
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r11 >>> 6
            r6 = r6 | 960(0x3c0, float:1.345E-42)
            byte r6 = (byte) r6
            r9[r10] = r6
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r5
            goto L_0x00b8
        L_0x004d:
            r4 = 57343(0xdfff, float:8.0355E-41)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r11 < r5) goto L_0x0057
            if (r11 <= r4) goto L_0x0078
        L_0x0057:
            int r6 = r2 + -3
            if (r10 > r6) goto L_0x0078
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r10 + 3
            int r7 = r11 >>> 12
            r7 = r7 | 480(0x1e0, float:6.73E-43)
            byte r7 = (byte) r7
            r9[r10] = r7
            int r10 = r11 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r5] = r10
            r10 = r6
            goto L_0x00b8
        L_0x0078:
            int r6 = r2 + -4
            if (r10 > r6) goto L_0x00c5
            int r4 = r1 + 1
            int r5 = r8.length()
            if (r4 == r5) goto L_0x00bd
            char r1 = r8.charAt(r4)
            boolean r5 = java.lang.Character.isSurrogatePair(r11, r1)
            if (r5 == 0) goto L_0x00bc
            int r5 = r10 + 1
            int r6 = r10 + 2
            int r7 = r10 + 3
            int r11 = java.lang.Character.toCodePoint(r11, r1)
            int r1 = r11 >>> 18
            r1 = r1 | 240(0xf0, float:3.36E-43)
            byte r1 = (byte) r1
            r9[r10] = r1
            int r1 = r11 >>> 12
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r5] = r1
            int r1 = r11 >>> 6
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r6] = r1
            int r10 = r10 + 4
            r11 = r11 & 63
            r11 = r11 | r3
            byte r11 = (byte) r11
            r9[r7] = r11
            r1 = r4
        L_0x00b8:
            int r1 = r1 + 1
            goto L_0x0020
        L_0x00bc:
            r1 = r4
        L_0x00bd:
            com.google.android.gms.internal.ads.zzhby r8 = new com.google.android.gms.internal.ads.zzhby
            int r1 = r1 + -1
            r8.<init>(r1, r0)
            throw r8
        L_0x00c5:
            if (r11 < r5) goto L_0x00e1
            if (r11 > r4) goto L_0x00e1
            int r9 = r1 + 1
            int r2 = r8.length()
            if (r9 == r2) goto L_0x00db
            char r8 = r8.charAt(r9)
            boolean r8 = java.lang.Character.isSurrogatePair(r11, r8)
            if (r8 != 0) goto L_0x00e1
        L_0x00db:
            com.google.android.gms.internal.ads.zzhby r8 = new com.google.android.gms.internal.ads.zzhby
            r8.<init>(r1, r0)
            throw r8
        L_0x00e1:
            java.lang.ArrayIndexOutOfBoundsException r8 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed writing "
            r9.<init>(r0)
            r9.append(r11)
            java.lang.String r11 = " at index "
            r9.append(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00fd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbz.zzd(java.lang.String, byte[], int, int):int");
    }

    static int zze(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = str.length();
                while (i2 < length2) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzhby(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    static int zzf(int i, byte[] bArr, int i2, int i3) {
        return zza.zza(i, bArr, i2, i3);
    }

    static String zzg(ByteBuffer byteBuffer, int i, int i2) throws zzgzm {
        zzhbw zzhbw = zza;
        if (byteBuffer.hasArray()) {
            return zzhbw.zzb(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        } else if (byteBuffer.isDirect()) {
            return zzhbx.zzc(byteBuffer, i, i2);
        } else {
            return zzhbw.zzc(byteBuffer, i, i2);
        }
    }

    static String zzh(byte[] bArr, int i, int i2) throws zzgzm {
        return zza.zzb(bArr, i, i2);
    }

    static boolean zzi(byte[] bArr, int i, int i2) {
        return zza.zza(0, bArr, i, i2) == 0;
    }

    /* access modifiers changed from: private */
    public static int zzj(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    public static int zzk(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }
}
