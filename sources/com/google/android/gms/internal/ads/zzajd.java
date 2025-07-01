package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzajd {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzadu zza(zzacs zzacs) throws IOException {
        return zzc(zzacs, true, false);
    }

    public static zzadu zzb(zzacs zzacs, boolean z) throws IOException {
        return zzc(zzacs, false, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        r17 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzadu zzc(com.google.android.gms.internal.ads.zzacs r25, boolean r26, boolean r27) throws java.io.IOException {
        /*
            r0 = r25
            r1 = r27
            long r2 = r0.zzd()
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r7 = 4096(0x1000, double:2.0237E-320)
            if (r6 == 0) goto L_0x0016
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r7 = r2
        L_0x0016:
            com.google.android.gms.internal.ads.zzed r9 = new com.google.android.gms.internal.ads.zzed
            r10 = 64
            r9.<init>((int) r10)
            int r7 = (int) r7
            r8 = 0
            r10 = r8
            r11 = r10
        L_0x0021:
            if (r10 >= r7) goto L_0x0126
            r13 = 8
            r9.zzI(r13)
            byte[] r14 = r9.zzN()
            r15 = 1
            boolean r14 = r0.zzm(r14, r8, r13, r15)
            if (r14 != 0) goto L_0x0035
            goto L_0x0127
        L_0x0035:
            long r16 = r9.zzu()
            int r14 = r9.zzg()
            r18 = 1
            int r18 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r18 != 0) goto L_0x005b
            r18 = r4
            byte[] r4 = r9.zzN()
            r0.zzh(r4, r13, r13)
            r4 = 16
            r9.zzK(r4)
            long r16 = r9.zzt()
            r5 = r9
        L_0x0056:
            r8 = r16
            r17 = 0
            goto L_0x0078
        L_0x005b:
            r18 = r4
            r4 = 0
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0075
            long r4 = r0.zzd()
            int r20 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r20 == 0) goto L_0x0075
            long r16 = r0.zze()
            long r4 = r4 - r16
            r16 = 8
            long r16 = r4 + r16
        L_0x0075:
            r5 = r9
            r4 = r13
            goto L_0x0056
        L_0x0078:
            long r12 = (long) r4
            int r21 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r21 >= 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzaic r0 = new com.google.android.gms.internal.ads.zzaic
            r0.<init>(r14, r8, r4)
            return r0
        L_0x0083:
            int r10 = r10 + r4
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r14 != r4) goto L_0x0098
            int r4 = (int) r8
            int r7 = r7 + r4
            if (r6 == 0) goto L_0x0093
            long r8 = (long) r7
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0093
            int r7 = (int) r2
        L_0x0093:
            r9 = r5
            r4 = r18
            r8 = 0
            goto L_0x0021
        L_0x0098:
            r4 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r14 == r4) goto L_0x0124
            r4 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r14 != r4) goto L_0x00a4
            goto L_0x0124
        L_0x00a4:
            r4 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r14 != r4) goto L_0x00ab
            r4 = 0
            goto L_0x00ac
        L_0x00ab:
            r4 = r15
        L_0x00ac:
            r4 = r4 ^ r15
            r11 = r11 | r4
            r21 = r2
            long r2 = (long) r10
            long r2 = r2 + r8
            r23 = r2
            long r2 = (long) r7
            long r23 = r23 - r12
            int r2 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x00be
            r8 = 0
            goto L_0x0129
        L_0x00be:
            long r8 = r8 - r12
            int r2 = (int) r8
            int r10 = r10 + r2
            r3 = 1718909296(0x66747970, float:2.8862439E23)
            if (r14 != r3) goto L_0x0116
            r4 = 8
            if (r2 >= r4) goto L_0x00d1
            long r0 = (long) r2
            com.google.android.gms.internal.ads.zzaic r2 = new com.google.android.gms.internal.ads.zzaic
            r2.<init>(r3, r0, r4)
            return r2
        L_0x00d1:
            r5.zzI(r2)
            byte[] r3 = r5.zzN()
            r4 = 0
            r0.zzh(r3, r4, r2)
            int r2 = r5.zzg()
            boolean r3 = zzd(r2, r1)
            r3 = r3 | r11
            r8 = 4
            r5.zzM(r8)
            int r9 = r5.zzb()
            int r9 = r9 / r8
            if (r3 != 0) goto L_0x0109
            if (r9 <= 0) goto L_0x0109
            int[] r12 = new int[r9]
            r8 = r4
        L_0x00f5:
            if (r8 >= r9) goto L_0x0107
            int r11 = r5.zzg()
            r12[r8] = r11
            boolean r11 = zzd(r11, r1)
            if (r11 == 0) goto L_0x0104
            goto L_0x010c
        L_0x0104:
            int r8 = r8 + 1
            goto L_0x00f5
        L_0x0107:
            r15 = r3
            goto L_0x010c
        L_0x0109:
            r15 = r3
            r12 = r17
        L_0x010c:
            if (r15 == 0) goto L_0x0110
            r11 = r15
            goto L_0x011c
        L_0x0110:
            com.google.android.gms.internal.ads.zzaji r0 = new com.google.android.gms.internal.ads.zzaji
            r0.<init>(r2, r12)
            return r0
        L_0x0116:
            r4 = 0
            if (r2 == 0) goto L_0x011c
            r0.zzg(r2)
        L_0x011c:
            r8 = r4
            r9 = r5
            r4 = r18
            r2 = r21
            goto L_0x0021
        L_0x0124:
            r8 = r15
            goto L_0x0129
        L_0x0126:
            r4 = r8
        L_0x0127:
            r17 = 0
        L_0x0129:
            if (r11 != 0) goto L_0x012e
            com.google.android.gms.internal.ads.zzaiz r0 = com.google.android.gms.internal.ads.zzaiz.zza
            return r0
        L_0x012e:
            r0 = r26
            if (r0 == r8) goto L_0x013a
            if (r8 == 0) goto L_0x0137
            com.google.android.gms.internal.ads.zzaiu r0 = com.google.android.gms.internal.ads.zzaiu.zza
            return r0
        L_0x0137:
            com.google.android.gms.internal.ads.zzaiu r0 = com.google.android.gms.internal.ads.zzaiu.zzb
            return r0
        L_0x013a:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajd.zzc(com.google.android.gms.internal.ads.zzacs, boolean, boolean):com.google.android.gms.internal.ads.zzadu");
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
