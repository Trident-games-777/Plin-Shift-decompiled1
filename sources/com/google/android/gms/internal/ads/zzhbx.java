package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbx extends zzhbw {
    zzhbx() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0080, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -62
            r2 = -16
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -65
            r7 = -1
            if (r12 == 0) goto L_0x0084
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x0022
            if (r8 < r1) goto L_0x0021
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0021
        L_0x001e:
            r14 = r12
            goto L_0x0084
        L_0x0021:
            return r7
        L_0x0022:
            int r9 = r12 >> 8
            int r9 = ~r9
            if (r8 >= r2) goto L_0x004b
            byte r12 = (byte) r9
            if (r12 != 0) goto L_0x0039
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x0034
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x0039
        L_0x0034:
            int r12 = com.google.android.gms.internal.ads.zzhbz.zzj(r8, r14)
            return r12
        L_0x0039:
            if (r12 > r6) goto L_0x004a
            if (r8 != r5) goto L_0x003f
            if (r12 < r4) goto L_0x004a
        L_0x003f:
            if (r8 != r0) goto L_0x0043
            if (r12 >= r4) goto L_0x004a
        L_0x0043:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x004a
            goto L_0x001e
        L_0x004a:
            return r7
        L_0x004b:
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005c
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 >= r15) goto L_0x0057
            r14 = r12
            r12 = r3
            goto L_0x005e
        L_0x0057:
            int r12 = com.google.android.gms.internal.ads.zzhbz.zzj(r8, r9)
            return r12
        L_0x005c:
            int r12 = r12 >> 16
        L_0x005e:
            if (r12 != 0) goto L_0x006f
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x006a
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x006f
        L_0x006a:
            int r12 = com.google.android.gms.internal.ads.zzhbz.zzk(r8, r9, r14)
            return r12
        L_0x006f:
            if (r9 > r6) goto L_0x0083
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0083
            if (r12 > r6) goto L_0x0083
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0083
            goto L_0x001e
        L_0x0083:
            return r7
        L_0x0084:
            if (r14 >= r15) goto L_0x008d
            byte r12 = r13[r14]
            if (r12 < 0) goto L_0x008d
            int r14 = r14 + 1
            goto L_0x0084
        L_0x008d:
            if (r14 < r15) goto L_0x0090
            return r3
        L_0x0090:
            if (r14 < r15) goto L_0x0093
            return r3
        L_0x0093:
            int r12 = r14 + 1
            byte r8 = r13[r14]
            if (r8 >= 0) goto L_0x00f0
            if (r8 >= r5) goto L_0x00a7
            if (r12 < r15) goto L_0x009e
            return r8
        L_0x009e:
            if (r8 < r1) goto L_0x00a6
            int r14 = r14 + 2
            byte r12 = r13[r12]
            if (r12 <= r6) goto L_0x0090
        L_0x00a6:
            return r7
        L_0x00a7:
            if (r8 >= r2) goto L_0x00cb
            int r9 = r15 + -1
            if (r12 < r9) goto L_0x00b2
            int r12 = com.google.android.gms.internal.ads.zzhbz.zzc(r13, r12, r15)
            return r12
        L_0x00b2:
            int r9 = r14 + 2
            byte r12 = r13[r12]
            if (r12 > r6) goto L_0x00ca
            if (r8 != r5) goto L_0x00be
            if (r12 < r4) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            return r7
        L_0x00be:
            if (r8 != r0) goto L_0x00c4
            if (r12 >= r4) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            return r7
        L_0x00c4:
            int r14 = r14 + 3
            byte r12 = r13[r9]
            if (r12 <= r6) goto L_0x0090
        L_0x00ca:
            return r7
        L_0x00cb:
            int r9 = r15 + -2
            if (r12 < r9) goto L_0x00d4
            int r12 = com.google.android.gms.internal.ads.zzhbz.zzc(r13, r12, r15)
            return r12
        L_0x00d4:
            int r9 = r14 + 2
            byte r12 = r13[r12]
            if (r12 > r6) goto L_0x00ef
            int r8 = r8 << 28
            int r12 = r12 + 112
            int r8 = r8 + r12
            int r12 = r8 >> 30
            if (r12 != 0) goto L_0x00ef
            int r12 = r14 + 3
            byte r8 = r13[r9]
            if (r8 > r6) goto L_0x00ef
            int r14 = r14 + 4
            byte r12 = r13[r12]
            if (r12 <= r6) goto L_0x0090
        L_0x00ef:
            return r7
        L_0x00f0:
            r14 = r12
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbx.zza(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzb(byte[] bArr, int i, int i2) throws zzgzm {
        int i3;
        int length = bArr.length;
        if ((((length - i) - i2) | i | i2) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r9 < i4) {
                byte b = bArr[r9];
                if (!zzhbv.zzd(b)) {
                    break;
                }
                i = r9 + 1;
                cArr[i5] = (char) b;
                i5++;
            }
            int i6 = i5;
            while (r9 < i4) {
                int i7 = r9 + 1;
                byte b2 = bArr[r9];
                if (zzhbv.zzd(b2)) {
                    cArr[i6] = (char) b2;
                    i6++;
                    r9 = i7;
                    while (r9 < i4) {
                        byte b3 = bArr[r9];
                        if (!zzhbv.zzd(b3)) {
                            break;
                        }
                        r9++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                } else {
                    if (zzhbv.zzf(b2)) {
                        if (i7 < i4) {
                            i3 = i6 + 1;
                            r9 = r9 + 2;
                            zzhbv.zzc(b2, bArr[i7], cArr, i6);
                        } else {
                            throw new zzgzm("Protocol message had invalid UTF-8.");
                        }
                    } else if (zzhbv.zze(b2)) {
                        if (i7 < i4 - 1) {
                            i3 = i6 + 1;
                            int i8 = r9 + 2;
                            r9 = r9 + 3;
                            zzhbv.zzb(b2, bArr[i7], bArr[i8], cArr, i6);
                        } else {
                            throw new zzgzm("Protocol message had invalid UTF-8.");
                        }
                    } else if (i7 < i4 - 2) {
                        int i9 = r9 + 3;
                        r9 += 4;
                        zzhbv.zza(b2, bArr[i7], bArr[r9 + 2], bArr[i9], cArr, i6);
                        i6 += 2;
                    } else {
                        throw new zzgzm("Protocol message had invalid UTF-8.");
                    }
                    i6 = i3;
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}
