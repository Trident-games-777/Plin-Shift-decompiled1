package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzagk {
    public static final zzagi zza = new zzagi();

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzbd zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzagi r13, com.google.android.gms.internal.ads.zzafm r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzed r0 = new com.google.android.gms.internal.ads.zzed
            r0.<init>(r11, r12)
            int r11 = r0.zzb()
            r12 = 2
            r1 = 0
            r2 = 1
            r3 = 4
            java.lang.String r4 = "Id3Decoder"
            r5 = 0
            r6 = 10
            if (r11 >= r6) goto L_0x0021
            java.lang.String r11 = "Data too short to be an ID3 tag"
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r11)
        L_0x001e:
            r9 = r5
            goto L_0x00aa
        L_0x0021:
            int r11 = r0.zzo()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0046
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.lang.String r7 = "%06X"
            java.lang.String r11 = java.lang.String.format(r7, r11)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = "Unexpected first three bytes of ID3 tag header: 0x"
            java.lang.String r11 = r7.concat(r11)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r11)
            goto L_0x001e
        L_0x0046:
            int r11 = r0.zzm()
            r0.zzM(r2)
            int r7 = r0.zzm()
            int r8 = r0.zzl()
            if (r11 != r12) goto L_0x0061
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r11)
            goto L_0x001e
        L_0x0061:
            r9 = 3
            if (r11 != r9) goto L_0x0072
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0088
            int r9 = r0.zzg()
            r0.zzM(r9)
            int r9 = r9 + r3
            int r8 = r8 - r9
            goto L_0x0088
        L_0x0072:
            if (r11 != r3) goto L_0x0097
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0082
            int r9 = r0.zzl()
            int r10 = r9 + -4
            r0.zzM(r10)
            int r8 = r8 - r9
        L_0x0082:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0088
            int r8 = r8 + -10
        L_0x0088:
            if (r11 >= r3) goto L_0x0090
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0090
            r7 = r2
            goto L_0x0091
        L_0x0090:
            r7 = r1
        L_0x0091:
            com.google.android.gms.internal.ads.zzagj r9 = new com.google.android.gms.internal.ads.zzagj
            r9.<init>(r11, r7, r8)
            goto L_0x00aa
        L_0x0097:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Skipped ID3 tag with unsupported majorVersion="
            r7.<init>(r8)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r11)
            goto L_0x001e
        L_0x00aa:
            if (r9 != 0) goto L_0x00ad
            return r5
        L_0x00ad:
            int r11 = r0.zzd()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00b8
            r6 = 6
        L_0x00b8:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00ca
            int r12 = r9.zzc
            int r12 = zze(r0, r12)
        L_0x00ca:
            int r11 = r11 + r12
            r0.zzK(r11)
            int r11 = r9.zza
            boolean r11 = zzj(r0, r11, r6, r1)
            if (r11 != 0) goto L_0x00fc
            int r11 = r9.zza
            if (r11 != r3) goto L_0x00e6
            boolean r11 = zzj(r0, r3, r6, r2)
            if (r11 == 0) goto L_0x00e6
            r1 = r2
            goto L_0x00fc
        L_0x00e6:
            int r11 = r9.zza
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Failed to validate ID3 tag with majorVersion="
            r12.<init>(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r11)
            return r5
        L_0x00fc:
            int r11 = r0.zzb()
            if (r11 < r6) goto L_0x0110
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzagl r11 = zzl(r11, r0, r1, r6, r13)
            if (r11 == 0) goto L_0x00fc
            r14.add(r11)
            goto L_0x00fc
        L_0x0110:
            com.google.android.gms.internal.ads.zzbd r11 = new com.google.android.gms.internal.ads.zzbd
            r11.<init>((java.util.List) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.zza(byte[], int, com.google.android.gms.internal.ads.zzagi, com.google.android.gms.internal.ads.zzafm):com.google.android.gms.internal.ads.zzbd");
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            int i3 = zzd + 1;
            if ((zzd - i) % 2 == 0 && bArr[i3] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzed zzed, int i) {
        byte[] zzN = zzed.zzN();
        int zzd = zzed.zzd();
        int i2 = zzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzd + i) {
                return i;
            }
            if ((zzN[i2] & 255) == 255 && zzN[i3] == 0) {
                System.arraycopy(zzN, i2 + 2, zzN, i3, (i - (i2 - zzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static zzfzo zzf(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfzo.zzo("");
        }
        zzfzl zzfzl = new zzfzl();
        int zzc = zzc(bArr, i2, i);
        while (i2 < zzc) {
            zzfzl.zzf(new String(bArr, i2, zzc - i2, zzi(i)));
            i2 = zzb(i) + zzc;
            zzc = zzc(bArr, i2, i);
        }
        zzfzo zzi = zzfzl.zzi();
        return zzi.isEmpty() ? zzfzo.zzo("") : zzi;
    }

    private static String zzg(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzh(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzj(com.google.android.gms.internal.ads.zzed r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r1.zzd()
        L_0x0008:
            int r3 = r1.zzb()     // Catch:{ all -> 0x00a8 }
            r4 = 1
            r5 = r23
            if (r3 < r5) goto L_0x00a4
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r1.zzg()     // Catch:{ all -> 0x00a8 }
            long r8 = r1.zzu()     // Catch:{ all -> 0x00a8 }
            int r10 = r1.zzq()     // Catch:{ all -> 0x00a8 }
            goto L_0x002c
        L_0x0022:
            int r7 = r1.zzo()     // Catch:{ all -> 0x00a8 }
            int r8 = r1.zzo()     // Catch:{ all -> 0x00a8 }
            long r8 = (long) r8     // Catch:{ all -> 0x00a8 }
            r10 = r6
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x0038
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0038
            if (r10 != 0) goto L_0x0038
            goto L_0x00a4
        L_0x0038:
            r7 = 4
            if (r0 != r7) goto L_0x0068
            if (r24 != 0) goto L_0x0068
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0048
        L_0x0045:
            r4 = r6
            goto L_0x00a4
        L_0x0048:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L_0x0068:
            if (r0 != r7) goto L_0x0078
            r3 = r10 & 64
            if (r3 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = r6
        L_0x0070:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L_0x008a
        L_0x0078:
            if (r0 != r3) goto L_0x0088
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0080
            r3 = r4
            goto L_0x0081
        L_0x0080:
            r3 = r6
        L_0x0081:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            r4 = r6
            goto L_0x008a
        L_0x0088:
            r3 = r6
            r4 = r3
        L_0x008a:
            if (r4 == 0) goto L_0x008e
            int r3 = r3 + 4
        L_0x008e:
            long r3 = (long) r3     // Catch:{ all -> 0x00a8 }
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0094
            goto L_0x0045
        L_0x0094:
            int r3 = r1.zzb()     // Catch:{ all -> 0x00a8 }
            long r3 = (long) r3     // Catch:{ all -> 0x00a8 }
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x009e
            goto L_0x0045
        L_0x009e:
            int r3 = (int) r8     // Catch:{ all -> 0x00a8 }
            r1.zzM(r3)     // Catch:{ all -> 0x00a8 }
            goto L_0x0008
        L_0x00a4:
            r1.zzL(r2)
            return r4
        L_0x00a8:
            r0 = move-exception
            r1.zzL(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.zzj(com.google.android.gms.internal.ads.zzed, int, int, boolean):boolean");
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzen.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x025d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x025f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0260, code lost:
        r22 = "Id3Decoder";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0262, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0287, code lost:
        if (r9 == 67) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0309, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x030c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04f3, code lost:
        r2.zzL(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04f6, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:77:0x0108, B:124:0x0213] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:77:0x0108, B:127:0x022a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:77:0x0108, B:160:0x02f5] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b4 A[Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01d1 A[Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0272 A[Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027d A[Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x029b A[Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bd A[Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0498 A[Catch:{ Exception | OutOfMemoryError -> 0x04f7, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x04dd A[Catch:{ Exception | OutOfMemoryError -> 0x04f7, all -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015f A[Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }, ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }]), Splitter:B:77:0x0108] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzagl zzl(int r33, com.google.android.gms.internal.ads.zzed r34, boolean r35, int r36, com.google.android.gms.internal.ads.zzagi r37) {
        /*
            r1 = r33
            r2 = r34
            r0 = r35
            r3 = r36
            int r4 = r2.zzm()
            int r5 = r2.zzm()
            int r6 = r2.zzm()
            r7 = 0
            r8 = 3
            if (r1 < r8) goto L_0x001d
            int r9 = r2.zzm()
            goto L_0x001e
        L_0x001d:
            r9 = r7
        L_0x001e:
            r10 = 4
            if (r1 != r10) goto L_0x003d
            int r11 = r2.zzp()
            if (r0 != 0) goto L_0x0048
            r12 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r11 >> 8
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r14 = r11 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r11 = r11 >> 24
            int r13 = r13 << 7
            r12 = r12 | r13
            int r13 = r14 << 14
            r12 = r12 | r13
            int r11 = r11 << 21
            r11 = r11 | r12
            goto L_0x0048
        L_0x003d:
            if (r1 != r8) goto L_0x0044
            int r11 = r2.zzp()
            goto L_0x0048
        L_0x0044:
            int r11 = r2.zzo()
        L_0x0048:
            if (r1 < r8) goto L_0x004f
            int r12 = r2.zzq()
            goto L_0x0050
        L_0x004f:
            r12 = r7
        L_0x0050:
            r13 = 0
            if (r4 != 0) goto L_0x0066
            if (r5 != 0) goto L_0x0066
            if (r6 != 0) goto L_0x0066
            if (r9 != 0) goto L_0x0066
            if (r11 != 0) goto L_0x0066
            if (r12 == 0) goto L_0x005e
            goto L_0x0066
        L_0x005e:
            int r0 = r2.zze()
            r2.zzL(r0)
            return r13
        L_0x0066:
            int r14 = r2.zzd()
            int r14 = r14 + r11
            int r15 = r2.zze()
            r16 = r13
            java.lang.String r13 = "Id3Decoder"
            if (r14 <= r15) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.gms.internal.ads.zzdt.zzf(r13, r0)
            int r0 = r2.zze()
            r2.zzL(r0)
            return r16
        L_0x0082:
            if (r37 != 0) goto L_0x052e
            r15 = 1
            if (r1 != r8) goto L_0x00a6
            r17 = r12 & 64
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x008f
            r8 = r15
            goto L_0x0090
        L_0x008f:
            r8 = r7
        L_0x0090:
            if (r17 == 0) goto L_0x0095
            r17 = r15
            goto L_0x0097
        L_0x0095:
            r17 = r7
        L_0x0097:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x009d
            r12 = r15
            goto L_0x009e
        L_0x009d:
            r12 = r7
        L_0x009e:
            r20 = r7
            r19 = r17
            r17 = r12
            r12 = r8
            goto L_0x00da
        L_0x00a6:
            if (r1 != r10) goto L_0x00d2
            r8 = r12 & 64
            if (r8 == 0) goto L_0x00ae
            r8 = r15
            goto L_0x00af
        L_0x00ae:
            r8 = r7
        L_0x00af:
            r17 = r12 & 8
            if (r17 == 0) goto L_0x00b6
            r17 = r15
            goto L_0x00b8
        L_0x00b6:
            r17 = r7
        L_0x00b8:
            r19 = r12 & 4
            if (r19 == 0) goto L_0x00bf
            r19 = r15
            goto L_0x00c1
        L_0x00bf:
            r19 = r7
        L_0x00c1:
            r20 = r12 & 2
            if (r20 == 0) goto L_0x00c8
            r20 = r15
            goto L_0x00ca
        L_0x00c8:
            r20 = r7
        L_0x00ca:
            r12 = r12 & r15
            r32 = r17
            r17 = r8
            r8 = r32
            goto L_0x00da
        L_0x00d2:
            r8 = r7
            r12 = r8
            r17 = r12
            r19 = r17
            r20 = r19
        L_0x00da:
            if (r8 != 0) goto L_0x0522
            if (r19 == 0) goto L_0x00e0
            goto L_0x0522
        L_0x00e0:
            if (r17 == 0) goto L_0x00e7
            r2.zzM(r15)
            int r11 = r11 + -1
        L_0x00e7:
            if (r12 == 0) goto L_0x00ee
            r2.zzM(r10)
            int r11 = r11 + -4
        L_0x00ee:
            if (r20 == 0) goto L_0x00f4
            int r11 = zze(r2, r11)
        L_0x00f4:
            r8 = 84
            r12 = 88
            r37 = r15
            r15 = 2
            if (r4 != r8) goto L_0x0132
            if (r5 != r12) goto L_0x0132
            if (r6 != r12) goto L_0x0132
            if (r1 == r15) goto L_0x0105
            if (r9 != r12) goto L_0x0132
        L_0x0105:
            if (r11 > 0) goto L_0x0108
            goto L_0x013a
        L_0x0108:
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = r11 + -1
            byte[] r8 = new byte[r3]     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r2.zzH(r8, r7, r3)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = zzc(r8, r7, r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.nio.charset.Charset r12 = zzi(r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r10.<init>(r8, r7, r3, r12)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r7 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = r3 + r7
            com.google.android.gms.internal.ads.zzfzo r0 = zzf(r8, r0, r3)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagu r3 = new com.google.android.gms.internal.ads.zzagu     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r7 = "TXXX"
            r3.<init>(r7, r10, r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            goto L_0x01ce
        L_0x0132:
            if (r4 != r8) goto L_0x016b
            java.lang.String r0 = zzh(r1, r8, r5, r6, r9)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            if (r11 > 0) goto L_0x0142
        L_0x013a:
            r20 = r4
            r22 = r13
            r3 = r16
            goto L_0x04ed
        L_0x0142:
            int r3 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r2.zzH(r10, r7, r8)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzfzo r3 = zzf(r10, r3, r7)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagu r7 = new com.google.android.gms.internal.ads.zzagu     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r8 = r16
            r7.<init>(r0, r8, r3)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r20 = r4
            r3 = r7
        L_0x015b:
            r22 = r13
            goto L_0x04ed
        L_0x015f:
            r0 = move-exception
            goto L_0x04f3
        L_0x0162:
            r0 = move-exception
            goto L_0x0165
        L_0x0164:
            r0 = move-exception
        L_0x0165:
            r20 = r4
            r22 = r13
            goto L_0x04fa
        L_0x016b:
            r8 = 87
            if (r4 != r8) goto L_0x01b1
            if (r5 != r12) goto L_0x01af
            if (r6 != r12) goto L_0x01af
            if (r1 == r15) goto L_0x0177
            if (r9 != r12) goto L_0x01af
        L_0x0177:
            if (r11 > 0) goto L_0x0180
            r20 = r4
            r22 = r13
        L_0x017d:
            r3 = 0
            goto L_0x04ed
        L_0x0180:
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = r11 + -1
            byte[] r8 = new byte[r3]     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r2.zzH(r8, r7, r3)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = zzc(r8, r7, r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.nio.charset.Charset r12 = zzi(r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r10.<init>(r8, r7, r3, r12)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r0 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = r3 + r0
            int r0 = zzd(r8, r3)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r0 = zzg(r8, r3, r0, r7)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagw r3 = new com.google.android.gms.internal.ads.zzagw     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r7 = "WXXX"
            r3.<init>(r7, r10, r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            goto L_0x01ce
        L_0x01af:
            r12 = r8
            goto L_0x01b2
        L_0x01b1:
            r12 = r4
        L_0x01b2:
            if (r12 != r8) goto L_0x01d1
            java.lang.String r0 = zzh(r1, r8, r5, r6, r9)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            byte[] r3 = new byte[r11]     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r2.zzH(r3, r7, r11)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r8 = zzd(r3, r7)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.nio.charset.Charset r12 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r10.<init>(r3, r7, r8, r12)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagw r3 = new com.google.android.gms.internal.ads.zzagw     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r8 = 0
            r3.<init>(r0, r8, r10)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
        L_0x01ce:
            r20 = r4
            goto L_0x015b
        L_0x01d1:
            r8 = 73
            r10 = 80
            if (r12 != r10) goto L_0x01fe
            r12 = 82
            if (r5 != r12) goto L_0x01fd
            if (r6 != r8) goto L_0x01fd
            r12 = 86
            if (r9 != r12) goto L_0x01fd
            byte[] r0 = new byte[r11]     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r2.zzH(r0, r7, r11)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = zzd(r0, r7)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.lang.String r8 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r8.<init>(r0, r7, r3, r10)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            int r3 = r3 + 1
            byte[] r0 = zzk(r0, r3, r11)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            com.google.android.gms.internal.ads.zzags r3 = new com.google.android.gms.internal.ads.zzags     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            r3.<init>(r8, r0)     // Catch:{ OutOfMemoryError -> 0x0164, Exception -> 0x0162, all -> 0x015f }
            goto L_0x01ce
        L_0x01fd:
            r12 = r10
        L_0x01fe:
            r8 = 79
            r10 = 71
            if (r12 != r10) goto L_0x026a
            r12 = 69
            if (r5 != r12) goto L_0x0266
            if (r6 != r8) goto L_0x0266
            r12 = 66
            if (r9 == r12) goto L_0x0213
            if (r1 != r15) goto L_0x0211
            goto L_0x0213
        L_0x0211:
            r12 = r10
            goto L_0x026a
        L_0x0213:
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            java.nio.charset.Charset r3 = zzi(r0)     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            r2.zzH(r10, r7, r8)     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            int r12 = zzd(r10, r7)     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            java.lang.String r15 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x025f, Exception -> 0x025d, all -> 0x015f }
            r22 = r13
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r15.<init>(r10, r7, r12, r13)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r7 = com.google.android.gms.internal.ads.zzbg.zze(r15)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r12 = r12 + 1
            int r13 = zzc(r10, r12, r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r12 = zzg(r10, r12, r13, r3)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r15 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r13 = r13 + r15
            int r15 = zzc(r10, r13, r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r3 = zzg(r10, r13, r15, r3)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r0 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r15 = r15 + r0
            byte[] r0 = zzk(r10, r15, r8)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagh r8 = new com.google.android.gms.internal.ads.zzagh     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r8.<init>(r7, r12, r3, r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r20 = r4
            r3 = r8
            goto L_0x04ed
        L_0x025d:
            r0 = move-exception
            goto L_0x0260
        L_0x025f:
            r0 = move-exception
        L_0x0260:
            r22 = r13
        L_0x0262:
            r20 = r4
            goto L_0x04fa
        L_0x0266:
            r22 = r13
            r12 = r10
            goto L_0x026c
        L_0x026a:
            r22 = r13
        L_0x026c:
            r10 = 65
            r13 = 67
            if (r1 != r15) goto L_0x027d
            r8 = 80
            if (r12 != r8) goto L_0x030f
            r15 = 73
            if (r5 != r15) goto L_0x030f
            if (r6 != r13) goto L_0x030f
            goto L_0x0289
        L_0x027d:
            r8 = 80
            r15 = 73
            if (r12 != r10) goto L_0x030f
            if (r5 != r8) goto L_0x030f
            if (r6 != r15) goto L_0x030f
            if (r9 != r13) goto L_0x030f
        L_0x0289:
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.nio.charset.Charset r3 = zzi(r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r2.zzH(r10, r7, r8)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r12 = 2
            if (r1 != r12) goto L_0x02bd
            java.lang.String r12 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r15 = 3
            r12.<init>(r10, r7, r15, r13)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfwa.zza(r12)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r12 = "image/"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r7 = r12.concat(r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r12 = "image/jpg"
            boolean r12 = r12.equals(r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            if (r12 == 0) goto L_0x02bb
            java.lang.String r7 = "image/jpeg"
        L_0x02bb:
            r12 = 2
            goto L_0x02df
        L_0x02bd:
            int r12 = zzd(r10, r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.nio.charset.Charset r15 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r13.<init>(r10, r7, r12, r15)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfwa.zza(r13)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r13 = 47
            int r13 = r7.indexOf(r13)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r15 = -1
            if (r13 != r15) goto L_0x02df
            java.lang.String r13 = "image/"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            java.lang.String r7 = r13.concat(r7)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
        L_0x02df:
            int r13 = r12 + 1
            byte r13 = r10[r13]     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r24 = 2
            int r12 = r12 + 2
            int r15 = zzc(r10, r12, r0)     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r35 = r15
            java.lang.String r15 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x030c, Exception -> 0x0309, all -> 0x015f }
            r20 = r4
            int r4 = r35 - r12
            r15.<init>(r10, r12, r4, r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r0 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r0 = r35 + r0
            byte[] r0 = zzk(r10, r0, r8)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzafx r3 = new com.google.android.gms.internal.ads.zzafx     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r3.<init>(r7, r15, r13, r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x04ed
        L_0x0309:
            r0 = move-exception
            goto L_0x0262
        L_0x030c:
            r0 = move-exception
            goto L_0x0262
        L_0x030f:
            r20 = r4
            r4 = 77
            if (r12 != r13) goto L_0x035c
            r8 = 79
            if (r5 != r8) goto L_0x035c
            if (r6 != r4) goto L_0x035c
            if (r9 == r4) goto L_0x0320
            r8 = 2
            if (r1 != r8) goto L_0x035c
        L_0x0320:
            r0 = 4
            if (r11 >= r0) goto L_0x0325
            goto L_0x017d
        L_0x0325:
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.nio.charset.Charset r3 = zzi(r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r15 = 3
            byte[] r4 = new byte[r15]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r2.zzH(r4, r7, r15)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String r8 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r8.<init>(r4, r7, r15)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = r11 + -4
            byte[] r10 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r2.zzH(r10, r7, r4)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = zzc(r10, r7, r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String r12 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r12.<init>(r10, r7, r4, r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r7 = zzb(r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = r4 + r7
            int r0 = zzc(r10, r4, r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String r0 = zzg(r10, r4, r0, r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagf r3 = new com.google.android.gms.internal.ads.zzagf     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r3.<init>(r8, r12, r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x04ed
        L_0x035c:
            if (r12 != r13) goto L_0x03da
            r8 = 72
            if (r5 != r8) goto L_0x03da
            if (r6 != r10) goto L_0x03da
            r8 = 80
            if (r9 != r8) goto L_0x03da
            int r4 = r2.zzd()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            byte[] r8 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r8 = zzd(r8, r4)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            byte[] r12 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r13 = r8 - r4
            java.nio.charset.Charset r15 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r10.<init>(r12, r4, r13, r15)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r8 = r8 + 1
            r2.zzL(r8)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r25 = r2.zzg()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r26 = r2.zzg()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            long r12 = r2.zzu()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r8 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x039d
            r12 = -1
        L_0x039d:
            r27 = r12
            long r12 = r2.zzu()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r8 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x03ae
            r12 = -1
        L_0x03ae:
            r29 = r12
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r8.<init>()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = r4 + r11
        L_0x03b6:
            int r12 = r2.zzd()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            if (r12 >= r4) goto L_0x03c7
            r12 = 0
            com.google.android.gms.internal.ads.zzagl r13 = zzl(r1, r2, r0, r3, r12)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            if (r13 == 0) goto L_0x03b6
            r8.add(r13)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x03b6
        L_0x03c7:
            com.google.android.gms.internal.ads.zzagl[] r0 = new com.google.android.gms.internal.ads.zzagl[r7]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.Object[] r0 = r8.toArray(r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r31 = r0
            com.google.android.gms.internal.ads.zzagl[] r31 = (com.google.android.gms.internal.ads.zzagl[]) r31     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagb r23 = new com.google.android.gms.internal.ads.zzagb     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r24 = r10
            r23.<init>(r24, r25, r26, r27, r29, r31)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x04da
        L_0x03da:
            if (r12 != r13) goto L_0x048a
            r8 = 84
            if (r5 != r8) goto L_0x048a
            r8 = 79
            if (r6 != r8) goto L_0x048a
            if (r9 != r13) goto L_0x048a
            int r4 = r2.zzd()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            byte[] r8 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r8 = zzd(r8, r4)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            byte[] r12 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r13 = r8 - r4
            java.nio.charset.Charset r15 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r10.<init>(r12, r4, r13, r15)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r8 = r8 + 1
            r2.zzL(r8)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r8 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r12 = r8 & 2
            if (r12 == 0) goto L_0x040f
            r25 = r37
            goto L_0x0411
        L_0x040f:
            r25 = r7
        L_0x0411:
            r8 = r8 & 1
            int r12 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r15 = r7
        L_0x041a:
            if (r15 >= r12) goto L_0x0452
            int r7 = r2.zzd()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r17 = r4
            byte[] r4 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = zzd(r4, r7)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r19 = r4
            java.lang.String r4 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r24 = r10
            byte[] r10 = r2.zzN()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r21 = r12
            int r12 = r19 - r7
            r27 = r13
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4.<init>(r10, r7, r12, r13)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r27[r15] = r4     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r4 = r19 + 1
            r2.zzL(r4)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r15 = r15 + 1
            r4 = r17
            r12 = r21
            r10 = r24
            r13 = r27
            r7 = 0
            goto L_0x041a
        L_0x0452:
            r17 = r4
            r24 = r10
            r27 = r13
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r7 = r17 + r11
        L_0x045f:
            int r10 = r2.zzd()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            if (r10 >= r7) goto L_0x0470
            r12 = 0
            com.google.android.gms.internal.ads.zzagl r10 = zzl(r1, r2, r0, r3, r12)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            if (r10 == 0) goto L_0x045f
            r4.add(r10)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x045f
        L_0x0470:
            r0 = 0
            com.google.android.gms.internal.ads.zzagl[] r3 = new com.google.android.gms.internal.ads.zzagl[r0]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            java.lang.Object[] r0 = r4.toArray(r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r28 = r0
            com.google.android.gms.internal.ads.zzagl[] r28 = (com.google.android.gms.internal.ads.zzagl[]) r28     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzagd r23 = new com.google.android.gms.internal.ads.zzagd     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r0 = r37
            if (r0 == r8) goto L_0x0484
            r26 = 0
            goto L_0x0486
        L_0x0484:
            r26 = r0
        L_0x0486:
            r23.<init>(r24, r25, r26, r27, r28)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            goto L_0x04da
        L_0x048a:
            if (r12 != r4) goto L_0x04dd
            r0 = 76
            if (r5 != r0) goto L_0x04dd
            r0 = 76
            if (r6 != r0) goto L_0x04dd
            r8 = 84
            if (r9 != r8) goto L_0x04dd
            int r24 = r2.zzq()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r25 = r2.zzo()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r26 = r2.zzo()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r0 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r3 = r2.zzm()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzec r4 = new com.google.android.gms.internal.ads.zzec     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4.zzj(r2)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r7 = r11 + -10
            int r7 = r7 * 8
            int r8 = r0 + r3
            int r7 = r7 / r8
            int[] r8 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int[] r10 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r12 = 0
        L_0x04c0:
            if (r12 >= r7) goto L_0x04d1
            int r13 = r4.zzd(r0)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r15 = r4.zzd(r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r8[r12] = r13     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r10[r12] = r15     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            int r12 = r12 + 1
            goto L_0x04c0
        L_0x04d1:
            com.google.android.gms.internal.ads.zzagq r23 = new com.google.android.gms.internal.ads.zzagq     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r27 = r8
            r28 = r10
            r23.<init>(r24, r25, r26, r27, r28)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
        L_0x04da:
            r3 = r23
            goto L_0x04ed
        L_0x04dd:
            java.lang.String r0 = zzh(r1, r12, r5, r6, r9)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            byte[] r3 = new byte[r11]     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4 = 0
            r2.zzH(r3, r4, r11)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            com.google.android.gms.internal.ads.zzafz r4 = new com.google.android.gms.internal.ads.zzafz     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r4.<init>(r0, r3)     // Catch:{ OutOfMemoryError -> 0x04f9, Exception -> 0x04f7, all -> 0x015f }
            r3 = r4
        L_0x04ed:
            r2.zzL(r14)
            r13 = r3
            r0 = 0
            goto L_0x04fe
        L_0x04f3:
            r2.zzL(r14)
            throw r0
        L_0x04f7:
            r0 = move-exception
            goto L_0x04fa
        L_0x04f9:
            r0 = move-exception
        L_0x04fa:
            r2.zzL(r14)
            r13 = 0
        L_0x04fe:
            if (r13 != 0) goto L_0x0521
            r2 = r20
            java.lang.String r1 = zzh(r1, r2, r5, r6, r9)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to decode frame: id="
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = ", frameSize="
            r2.append(r1)
            r2.append(r11)
            java.lang.String r1 = r2.toString()
            r3 = r22
            com.google.android.gms.internal.ads.zzdt.zzg(r3, r1, r0)
        L_0x0521:
            return r13
        L_0x0522:
            r3 = r13
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.gms.internal.ads.zzdt.zzf(r3, r0)
            r2.zzL(r14)
            r16 = 0
            return r16
        L_0x052e:
            r2.zzL(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.zzl(int, com.google.android.gms.internal.ads.zzed, boolean, int, com.google.android.gms.internal.ads.zzagi):com.google.android.gms.internal.ads.zzagl");
    }

    private static Charset zzi(int i) {
        if (i == 1) {
            return StandardCharsets.UTF_16;
        }
        if (i == 2) {
            return StandardCharsets.UTF_16BE;
        }
        if (i != 3) {
            return StandardCharsets.ISO_8859_1;
        }
        return StandardCharsets.UTF_8;
    }
}
