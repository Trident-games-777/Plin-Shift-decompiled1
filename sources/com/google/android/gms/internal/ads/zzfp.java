package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfp {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        int i3 = i2 - i;
        boolean z2 = false;
        zzdb.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzh(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzh(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        zzh(zArr);
                        return i6;
                    }
                    i5 = i6;
                }
                i5 += 3;
            }
            if (i3 <= 2 ? i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !(zArr[2] && bArr[i2 - 2] == 0 && bArr[i4] == 1) : !(bArr[i2 - 3] == 0 && bArr[i2 - 2] == 0 && bArr[i4] == 1)) {
                z = false;
            } else {
                z = true;
            }
            zArr[0] = z;
            zArr[1] = i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : bArr[i2 + -2] == 0 && bArr[i4] == 0;
            if (bArr[i4] == 0) {
                z2 = true;
            }
            zArr[2] = z2;
            return i2;
        } else {
            zzh(zArr);
            return i - 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfj zzc(byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzfm r35) {
        /*
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r35
            com.google.android.gms.internal.ads.zzfq r4 = new com.google.android.gms.internal.ads.zzfq
            r4.<init>(r0, r1, r2)
            com.google.android.gms.internal.ads.zzfd r6 = zzl(r4)
            com.google.android.gms.internal.ads.zzfq r4 = new com.google.android.gms.internal.ads.zzfq
            r5 = 2
            int r1 = r1 + r5
            r4.<init>(r0, r1, r2)
            r0 = 4
            r4.zzf(r0)
            r1 = 3
            int r2 = r4.zza(r1)
            int r7 = r6.zzb
            r8 = 1
            if (r7 == 0) goto L_0x002c
            r7 = 7
            if (r2 != r7) goto L_0x002c
            r2 = r7
            r7 = r8
            goto L_0x002d
        L_0x002c:
            r7 = 0
        L_0x002d:
            r10 = -1
            if (r3 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzfzo r11 = r3.zza
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0050
            int r11 = r6.zzb
            com.google.android.gms.internal.ads.zzfzo r12 = r3.zza
            int r12 = r12.size()
            int r12 = r12 + r10
            com.google.android.gms.internal.ads.zzfzo r13 = r3.zza
            int r11 = java.lang.Math.min(r11, r12)
            java.lang.Object r11 = r13.get(r11)
            com.google.android.gms.internal.ads.zzfc r11 = (com.google.android.gms.internal.ads.zzfc) r11
            int r11 = r11.zza
            goto L_0x0051
        L_0x0050:
            r11 = 0
        L_0x0051:
            r12 = 0
            if (r7 != 0) goto L_0x005d
            r4.zze()
            com.google.android.gms.internal.ads.zzfe r12 = zzm(r4, r8, r2, r12)
        L_0x005b:
            r13 = r11
            goto L_0x0078
        L_0x005d:
            if (r3 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzff r13 = r3.zzb
            int[] r14 = r13.zzb
            r14 = r14[r11]
            com.google.android.gms.internal.ads.zzfzo r13 = r13.zza
            int r13 = r13.size()
            if (r13 <= r14) goto L_0x005b
            com.google.android.gms.internal.ads.zzff r12 = r3.zzb
            com.google.android.gms.internal.ads.zzfzo r12 = r12.zza
            java.lang.Object r12 = r12.get(r14)
            com.google.android.gms.internal.ads.zzfe r12 = (com.google.android.gms.internal.ads.zzfe) r12
            goto L_0x005b
        L_0x0078:
            int r11 = r4.zzc()
            r14 = 8
            if (r7 == 0) goto L_0x00bf
            boolean r15 = r4.zzh()
            if (r15 == 0) goto L_0x008b
            int r15 = r4.zza(r14)
            goto L_0x008c
        L_0x008b:
            r15 = r10
        L_0x008c:
            if (r3 == 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzfh r9 = r3.zzc
            if (r9 == 0) goto L_0x00b7
            if (r15 != r10) goto L_0x0098
            int[] r15 = r9.zzb
            r15 = r15[r13]
        L_0x0098:
            if (r15 == r10) goto L_0x00b7
            com.google.android.gms.internal.ads.zzfzo r9 = r9.zza
            int r9 = r9.size()
            if (r9 <= r15) goto L_0x00b7
            com.google.android.gms.internal.ads.zzfh r9 = r3.zzc
            com.google.android.gms.internal.ads.zzfzo r9 = r9.zza
            java.lang.Object r9 = r9.get(r15)
            com.google.android.gms.internal.ads.zzfg r9 = (com.google.android.gms.internal.ads.zzfg) r9
            int r15 = r9.zza
            int r10 = r9.zzd
            int r14 = r9.zze
            int r5 = r9.zzb
            int r9 = r9.zzc
            goto L_0x00fe
        L_0x00b7:
            r0 = r7
            r7 = r12
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            goto L_0x0104
        L_0x00bf:
            int r15 = r4.zzc()
            if (r15 != r1) goto L_0x00ca
            r4.zze()
            r5 = r1
            goto L_0x00cb
        L_0x00ca:
            r5 = r15
        L_0x00cb:
            int r9 = r4.zzc()
            int r10 = r4.zzc()
            boolean r14 = r4.zzh()
            if (r14 == 0) goto L_0x00f4
            int r14 = r4.zzc()
            int r1 = r4.zzc()
            int r0 = r4.zzc()
            int r8 = r4.zzc()
            int r1 = zzk(r9, r5, r14, r1)
            int r0 = zzj(r10, r5, r0, r8)
            r14 = r0
            r10 = r1
            goto L_0x00f6
        L_0x00f4:
            r14 = r10
            r10 = r9
        L_0x00f6:
            int r5 = r4.zzc()
            int r9 = r4.zzc()
        L_0x00fe:
            r0 = r7
            r7 = r12
            r8 = r15
            r12 = r10
            r10 = r9
            r9 = r5
        L_0x0104:
            int r1 = r4.zzc()
            if (r0 != 0) goto L_0x012c
            boolean r5 = r4.zzh()
            r15 = 1
            if (r15 == r5) goto L_0x0113
            r5 = r2
            goto L_0x0114
        L_0x0113:
            r5 = 0
        L_0x0114:
            r15 = -1
        L_0x0115:
            if (r5 > r2) goto L_0x012d
            r4.zzc()
            r20 = r0
            int r0 = r4.zzc()
            int r15 = java.lang.Math.max(r0, r15)
            r4.zzc()
            int r5 = r5 + 1
            r0 = r20
            goto L_0x0115
        L_0x012c:
            r15 = -1
        L_0x012d:
            r20 = r0
            r4.zzc()
            r4.zzc()
            r4.zzc()
            r4.zzc()
            r4.zzc()
            r4.zzc()
            boolean r0 = r4.zzh()
            if (r0 == 0) goto L_0x01a2
            r0 = 6
            if (r20 == 0) goto L_0x0154
            boolean r2 = r4.zzh()
            if (r2 == 0) goto L_0x0154
            r4.zzf(r0)
            goto L_0x01a2
        L_0x0154:
            boolean r2 = r4.zzh()
            if (r2 == 0) goto L_0x01a2
            r2 = 0
            r5 = 4
        L_0x015c:
            if (r2 >= r5) goto L_0x01a2
            r18 = r5
            r5 = 0
        L_0x0161:
            if (r5 >= r0) goto L_0x019a
            boolean r20 = r4.zzh()
            if (r20 != 0) goto L_0x0170
            r4.zzc()
            r20 = r1
        L_0x016e:
            r0 = 3
            goto L_0x0190
        L_0x0170:
            int r20 = r2 + r2
            int r20 = r20 + 4
            r19 = 1
            int r0 = r19 << r20
            r20 = r1
            r1 = 64
            int r0 = java.lang.Math.min(r1, r0)
            r1 = r19
            if (r2 <= r1) goto L_0x0187
            r4.zzb()
        L_0x0187:
            r1 = 0
        L_0x0188:
            if (r1 >= r0) goto L_0x016e
            r4.zzb()
            int r1 = r1 + 1
            goto L_0x0188
        L_0x0190:
            if (r2 != r0) goto L_0x0194
            r0 = 3
            goto L_0x0195
        L_0x0194:
            r0 = 1
        L_0x0195:
            int r5 = r5 + r0
            r1 = r20
            r0 = 6
            goto L_0x0161
        L_0x019a:
            r20 = r1
            int r2 = r2 + 1
            r5 = r18
            r0 = 6
            goto L_0x015c
        L_0x01a2:
            r20 = r1
            r0 = 2
            r4.zzf(r0)
            boolean r0 = r4.zzh()
            if (r0 == 0) goto L_0x01bc
            r0 = 8
            r4.zzf(r0)
            r4.zzc()
            r4.zzc()
            r4.zze()
        L_0x01bc:
            int r0 = r4.zzc()
            r1 = 0
            int[] r2 = new int[r1]
            int[] r5 = new int[r1]
            r18 = r2
            r21 = r5
            r2 = -1
            r5 = -1
        L_0x01cb:
            if (r1 >= r0) goto L_0x02fe
            if (r1 == 0) goto L_0x02a1
            boolean r22 = r4.zzh()
            if (r22 == 0) goto L_0x02a1
            r22 = r0
            int r0 = r2 + r5
            boolean r23 = r4.zzh()
            int r24 = r4.zzc()
            r19 = 1
            int r24 = r24 + 1
            int r23 = r23 + r23
            int r23 = 1 - r23
            r25 = r1
            int r1 = r0 + 1
            r26 = r6
            boolean[] r6 = new boolean[r1]
            r27 = r6
            r6 = 0
        L_0x01f4:
            if (r6 > r0) goto L_0x020a
            boolean r28 = r4.zzh()
            if (r28 != 0) goto L_0x0203
            boolean r28 = r4.zzh()
            r27[r6] = r28
            goto L_0x0205
        L_0x0203:
            r27[r6] = r19
        L_0x0205:
            int r6 = r6 + 1
            r19 = 1
            goto L_0x01f4
        L_0x020a:
            int r6 = r5 + -1
            r28 = r0
            int[] r0 = new int[r1]
            int[] r1 = new int[r1]
            r29 = 0
        L_0x0214:
            int r30 = r23 * r24
            if (r6 < 0) goto L_0x022d
            r31 = r21[r6]
            int r31 = r31 + r30
            if (r31 >= 0) goto L_0x022a
            int r30 = r2 + r6
            boolean r30 = r27[r30]
            if (r30 == 0) goto L_0x022a
            int r30 = r29 + 1
            r0[r29] = r31
            r29 = r30
        L_0x022a:
            int r6 = r6 + -1
            goto L_0x0214
        L_0x022d:
            if (r30 >= 0) goto L_0x0239
            boolean r6 = r27[r28]
            if (r6 == 0) goto L_0x0239
            int r6 = r29 + 1
            r0[r29] = r30
            r29 = r6
        L_0x0239:
            r23 = r7
            r6 = r29
            r7 = 0
        L_0x023e:
            if (r7 >= r2) goto L_0x0253
            r24 = r18[r7]
            int r24 = r24 + r30
            if (r24 >= 0) goto L_0x0250
            boolean r29 = r27[r7]
            if (r29 == 0) goto L_0x0250
            int r29 = r6 + 1
            r0[r6] = r24
            r6 = r29
        L_0x0250:
            int r7 = r7 + 1
            goto L_0x023e
        L_0x0253:
            int[] r0 = java.util.Arrays.copyOf(r0, r6)
            int r7 = r2 + -1
            r24 = 0
        L_0x025b:
            if (r7 < 0) goto L_0x0270
            r29 = r18[r7]
            int r29 = r29 + r30
            if (r29 <= 0) goto L_0x026d
            boolean r31 = r27[r7]
            if (r31 == 0) goto L_0x026d
            int r31 = r24 + 1
            r1[r24] = r29
            r24 = r31
        L_0x026d:
            int r7 = r7 + -1
            goto L_0x025b
        L_0x0270:
            if (r30 <= 0) goto L_0x027c
            boolean r7 = r27[r28]
            if (r7 == 0) goto L_0x027c
            int r7 = r24 + 1
            r1[r24] = r30
            r24 = r7
        L_0x027c:
            r18 = r0
            r7 = r24
            r0 = 0
        L_0x0281:
            if (r0 >= r5) goto L_0x0298
            r24 = r21[r0]
            int r24 = r24 + r30
            if (r24 <= 0) goto L_0x0295
            int r28 = r2 + r0
            boolean r28 = r27[r28]
            if (r28 == 0) goto L_0x0295
            int r28 = r7 + 1
            r1[r7] = r24
            r7 = r28
        L_0x0295:
            int r0 = r0 + 1
            goto L_0x0281
        L_0x0298:
            int[] r0 = java.util.Arrays.copyOf(r1, r7)
            r21 = r0
            r2 = r6
            r5 = r7
            goto L_0x02f4
        L_0x02a1:
            r22 = r0
            r25 = r1
            r26 = r6
            r23 = r7
            int r0 = r4.zzc()
            int r1 = r4.zzc()
            int[] r2 = new int[r0]
            r5 = 0
        L_0x02b4:
            if (r5 >= r0) goto L_0x02cf
            if (r5 <= 0) goto L_0x02bd
            int r6 = r5 + -1
            r6 = r2[r6]
            goto L_0x02be
        L_0x02bd:
            r6 = 0
        L_0x02be:
            int r7 = r4.zzc()
            r19 = 1
            int r7 = r7 + 1
            int r6 = r6 - r7
            r2[r5] = r6
            r4.zze()
            int r5 = r5 + 1
            goto L_0x02b4
        L_0x02cf:
            int[] r5 = new int[r1]
            r6 = 0
        L_0x02d2:
            if (r6 >= r1) goto L_0x02ee
            if (r6 <= 0) goto L_0x02db
            int r7 = r6 + -1
            r7 = r5[r7]
            goto L_0x02dc
        L_0x02db:
            r7 = 0
        L_0x02dc:
            int r18 = r4.zzc()
            r19 = 1
            int r18 = r18 + 1
            int r7 = r7 + r18
            r5[r6] = r7
            r4.zze()
            int r6 = r6 + 1
            goto L_0x02d2
        L_0x02ee:
            r18 = r2
            r21 = r5
            r2 = r0
            r5 = r1
        L_0x02f4:
            int r1 = r25 + 1
            r0 = r22
            r7 = r23
            r6 = r26
            goto L_0x01cb
        L_0x02fe:
            r26 = r6
            r23 = r7
            boolean r0 = r4.zzh()
            if (r0 == 0) goto L_0x0317
            int r0 = r4.zzc()
            r1 = 0
        L_0x030d:
            if (r1 >= r0) goto L_0x0317
            int r2 = r20 + 5
            r4.zzf(r2)
            int r1 = r1 + 1
            goto L_0x030d
        L_0x0317:
            r0 = 2
            r4.zzf(r0)
            boolean r1 = r4.zzh()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x03e6
            boolean r1 = r4.zzh()
            if (r1 == 0) goto L_0x0362
            r1 = 8
            int r5 = r4.zza(r1)
            r1 = 255(0xff, float:3.57E-43)
            if (r5 != r1) goto L_0x0345
            r1 = 16
            int r5 = r4.zza(r1)
            int r1 = r4.zza(r1)
            if (r5 == 0) goto L_0x0362
            if (r1 == 0) goto L_0x0362
            float r2 = (float) r5
            float r1 = (float) r1
            float r2 = r2 / r1
            goto L_0x0362
        L_0x0345:
            r1 = 17
            if (r5 >= r1) goto L_0x034f
            float[] r1 = zzb
            r1 = r1[r5]
            r2 = r1
            goto L_0x0362
        L_0x034f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "Unexpected aspect_ratio_idc value: "
            r1.<init>(r6)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "NalUnitUtil"
            com.google.android.gms.internal.ads.zzdt.zzf(r5, r1)
        L_0x0362:
            boolean r1 = r4.zzh()
            if (r1 == 0) goto L_0x036b
            r4.zze()
        L_0x036b:
            boolean r1 = r4.zzh()
            if (r1 == 0) goto L_0x039e
            r1 = 3
            r4.zzf(r1)
            boolean r1 = r4.zzh()
            r3 = 1
            if (r3 == r1) goto L_0x037e
            r5 = r0
            goto L_0x037f
        L_0x037e:
            r5 = r3
        L_0x037f:
            boolean r0 = r4.zzh()
            if (r0 == 0) goto L_0x039b
            r0 = 8
            int r1 = r4.zza(r0)
            int r3 = r4.zza(r0)
            r4.zzf(r0)
            int r0 = com.google.android.gms.internal.ads.zzm.zza(r1)
            int r1 = com.google.android.gms.internal.ads.zzm.zzb(r3)
            goto L_0x03c8
        L_0x039b:
            r0 = -1
            r1 = -1
            goto L_0x03c8
        L_0x039e:
            if (r3 == 0) goto L_0x03c5
            com.google.android.gms.internal.ads.zzfl r0 = r3.zzd
            if (r0 == 0) goto L_0x03c5
            int[] r1 = r0.zzb
            r1 = r1[r13]
            com.google.android.gms.internal.ads.zzfzo r0 = r0.zza
            int r0 = r0.size()
            if (r0 <= r1) goto L_0x03c5
            com.google.android.gms.internal.ads.zzfl r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfzo r0 = r0.zza
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzfk r0 = (com.google.android.gms.internal.ads.zzfk) r0
            int r1 = r0.zza
            int r3 = r0.zzb
            int r0 = r0.zzc
            r5 = r1
            r1 = r0
            r0 = r5
            r5 = r3
            goto L_0x03c8
        L_0x03c5:
            r0 = -1
            r1 = -1
            r5 = -1
        L_0x03c8:
            boolean r3 = r4.zzh()
            if (r3 == 0) goto L_0x03d4
            r4.zzc()
            r4.zzc()
        L_0x03d4:
            r4.zze()
            boolean r3 = r4.zzh()
            if (r3 == 0) goto L_0x03de
            int r14 = r14 + r14
        L_0x03de:
            r16 = r0
            r18 = r1
            r17 = r5
            r13 = r14
            goto L_0x03ed
        L_0x03e6:
            r13 = r14
            r16 = -1
            r17 = -1
            r18 = -1
        L_0x03ed:
            r14 = r2
            com.google.android.gms.internal.ads.zzfj r5 = new com.google.android.gms.internal.ads.zzfj
            r7 = r23
            r6 = r26
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzc(byte[], int, int, com.google.android.gms.internal.ads.zzfm):com.google.android.gms.internal.ads.zzfj");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfm zzd(byte[] r37, int r38, int r39) {
        /*
            com.google.android.gms.internal.ads.zzfq r0 = new com.google.android.gms.internal.ads.zzfq
            r1 = r37
            r2 = r38
            r3 = r39
            r0.<init>(r1, r2, r3)
            com.google.android.gms.internal.ads.zzfd r2 = zzl(r0)
            r1 = 4
            r0.zzf(r1)
            boolean r3 = r0.zzh()
            boolean r4 = r0.zzh()
            r5 = 6
            int r6 = r0.zza(r5)
            int r7 = r6 + 1
            r8 = 3
            int r9 = r0.zza(r8)
            r10 = 17
            r0.zzf(r10)
            r10 = 1
            r11 = 0
            com.google.android.gms.internal.ads.zzfe r12 = zzm(r0, r10, r9, r11)
            boolean r13 = r0.zzh()
            r14 = 0
            if (r10 == r13) goto L_0x003b
            r13 = r9
            goto L_0x003c
        L_0x003b:
            r13 = r14
        L_0x003c:
            if (r13 > r9) goto L_0x004a
            r0.zzc()
            r0.zzc()
            r0.zzc()
            int r13 = r13 + 1
            goto L_0x003c
        L_0x004a:
            int r13 = r0.zza(r5)
            int r15 = r0.zzc()
            int r15 = r15 + r10
            com.google.android.gms.internal.ads.zzfzo r11 = com.google.android.gms.internal.ads.zzfzo.zzo(r12)
            r16 = r4
            com.google.android.gms.internal.ads.zzff r4 = new com.google.android.gms.internal.ads.zzff
            r38 = r5
            int[] r5 = new int[r10]
            r4.<init>(r11, r5)
            r5 = 2
            if (r7 < r5) goto L_0x0069
            if (r15 < r5) goto L_0x0069
            r11 = r10
            goto L_0x006a
        L_0x0069:
            r11 = r14
        L_0x006a:
            if (r3 == 0) goto L_0x0070
            if (r16 == 0) goto L_0x0070
            r3 = r10
            goto L_0x0071
        L_0x0070:
            r3 = r14
        L_0x0071:
            r39 = r10
            int r10 = r13 + 1
            if (r11 == 0) goto L_0x085a
            if (r3 == 0) goto L_0x085a
            if (r10 >= r7) goto L_0x007d
            goto L_0x085a
        L_0x007d:
            int[] r3 = new int[r5]
            r3[r39] = r10
            r3[r14] = r15
            java.lang.Class r11 = java.lang.Integer.TYPE
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r11, r3)
            int[][] r3 = (int[][]) r3
            int[] r11 = new int[r15]
            int[] r5 = new int[r15]
            r17 = r3[r14]
            r17[r14] = r14
            r11[r14] = r39
            r5[r14] = r14
            r8 = r39
        L_0x0099:
            if (r8 >= r15) goto L_0x00b8
            r19 = r14
        L_0x009d:
            if (r14 > r13) goto L_0x00b4
            boolean r20 = r0.zzh()
            if (r20 == 0) goto L_0x00af
            r20 = r3[r8]
            int r21 = r19 + 1
            r20[r19] = r14
            r5[r8] = r14
            r19 = r21
        L_0x00af:
            r11[r8] = r19
            int r14 = r14 + 1
            goto L_0x009d
        L_0x00b4:
            int r8 = r8 + 1
            r14 = 0
            goto L_0x0099
        L_0x00b8:
            boolean r8 = r0.zzh()
            if (r8 == 0) goto L_0x016c
            r8 = 64
            r0.zzf(r8)
            boolean r8 = r0.zzh()
            if (r8 == 0) goto L_0x00cc
            r0.zzc()
        L_0x00cc:
            int r8 = r0.zzc()
            r1 = 0
        L_0x00d1:
            if (r1 >= r8) goto L_0x016c
            r0.zzc()
            if (r1 == 0) goto L_0x00e6
            boolean r20 = r0.zzh()
            if (r20 == 0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            r20 = 0
            r21 = 0
        L_0x00e3:
            r22 = 0
            goto L_0x010d
        L_0x00e6:
            boolean r20 = r0.zzh()
            boolean r21 = r0.zzh()
            if (r20 != 0) goto L_0x00f2
            if (r21 == 0) goto L_0x00e3
        L_0x00f2:
            boolean r22 = r0.zzh()
            if (r22 == 0) goto L_0x00fd
            r14 = 19
            r0.zzf(r14)
        L_0x00fd:
            r14 = 8
            r0.zzf(r14)
            if (r22 == 0) goto L_0x0108
            r14 = 4
            r0.zzf(r14)
        L_0x0108:
            r14 = 15
            r0.zzf(r14)
        L_0x010d:
            r14 = 0
        L_0x010e:
            if (r14 > r9) goto L_0x0162
            boolean r23 = r0.zzh()
            if (r23 != 0) goto L_0x0127
            boolean r23 = r0.zzh()
            if (r23 == 0) goto L_0x011d
            goto L_0x0127
        L_0x011d:
            boolean r23 = r0.zzh()
            if (r23 == 0) goto L_0x012a
            r24 = r1
            r1 = 0
            goto L_0x0132
        L_0x0127:
            r0.zzc()
        L_0x012a:
            int r23 = r0.zzc()
            r24 = r1
            r1 = r23
        L_0x0132:
            r23 = r2
            int r2 = r20 + r21
            r25 = r3
            r3 = 0
        L_0x0139:
            if (r3 >= r2) goto L_0x0159
            r26 = r2
            r2 = 0
        L_0x013e:
            if (r2 > r1) goto L_0x0154
            r0.zzc()
            r0.zzc()
            if (r22 == 0) goto L_0x014e
            r0.zzc()
            r0.zzc()
        L_0x014e:
            r0.zze()
            int r2 = r2 + 1
            goto L_0x013e
        L_0x0154:
            int r3 = r3 + 1
            r2 = r26
            goto L_0x0139
        L_0x0159:
            int r14 = r14 + 1
            r2 = r23
            r1 = r24
            r3 = r25
            goto L_0x010e
        L_0x0162:
            r24 = r1
            r23 = r2
            r25 = r3
            int r1 = r24 + 1
            goto L_0x00d1
        L_0x016c:
            r23 = r2
            r25 = r3
            boolean r1 = r0.zzh()
            if (r1 != 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r2 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x0181:
            r2 = r23
            r0.zzd()
            r1 = 0
            com.google.android.gms.internal.ads.zzfe r3 = zzm(r0, r1, r9, r12)
            boolean r1 = r0.zzh()
            r8 = 16
            boolean[] r14 = new boolean[r8]
            r20 = r1
            r1 = 0
            r2 = 0
        L_0x0197:
            if (r1 >= r8) goto L_0x01a6
            boolean r21 = r0.zzh()
            r14[r1] = r21
            if (r21 == 0) goto L_0x01a3
            int r2 = r2 + 1
        L_0x01a3:
            int r1 = r1 + 1
            goto L_0x0197
        L_0x01a6:
            if (r2 == 0) goto L_0x084f
            boolean r1 = r14[r39]
            if (r1 != 0) goto L_0x01ae
            goto L_0x084f
        L_0x01ae:
            int r1 = r2 + 1
            int[] r8 = new int[r2]
            r22 = r4
            r24 = r5
            r4 = 0
        L_0x01b7:
            int r5 = r2 - r20
            if (r4 >= r5) goto L_0x01c5
            r5 = 3
            int r26 = r0.zza(r5)
            r8[r4] = r26
            int r4 = r4 + 1
            goto L_0x01b7
        L_0x01c5:
            int[] r1 = new int[r1]
            if (r20 == 0) goto L_0x01e2
            r4 = r39
        L_0x01cb:
            if (r4 >= r2) goto L_0x01e0
            r5 = 0
        L_0x01ce:
            if (r5 >= r4) goto L_0x01dd
            r26 = r1[r4]
            r27 = r8[r5]
            int r27 = r27 + 1
            int r26 = r26 + r27
            r1[r4] = r26
            int r5 = r5 + 1
            goto L_0x01ce
        L_0x01dd:
            int r4 = r4 + 1
            goto L_0x01cb
        L_0x01e0:
            r1[r2] = r38
        L_0x01e2:
            r4 = 2
            int[] r5 = new int[r4]
            r5[r39] = r2
            r18 = 0
            r5[r18] = r7
            java.lang.Class r4 = java.lang.Integer.TYPE
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r5)
            int[][] r4 = (int[][]) r4
            int[] r5 = new int[r7]
            r5[r18] = r18
            boolean r26 = r0.zzh()
            r27 = r1
            r28 = r4
            r1 = r39
        L_0x0201:
            if (r1 >= r7) goto L_0x0252
            if (r26 == 0) goto L_0x0210
            r4 = r38
            r29 = -1
            int r30 = r0.zza(r4)
            r5[r1] = r30
            goto L_0x0216
        L_0x0210:
            r4 = r38
            r29 = -1
            r5[r1] = r1
        L_0x0216:
            if (r20 != 0) goto L_0x0231
            r4 = 0
        L_0x0219:
            if (r4 >= r2) goto L_0x022e
            r29 = r28[r1]
            r30 = r8[r4]
            r31 = r1
            int r1 = r30 + 1
            int r1 = r0.zza(r1)
            r29[r4] = r1
            int r4 = r4 + 1
            r1 = r31
            goto L_0x0219
        L_0x022e:
            r31 = r1
            goto L_0x024d
        L_0x0231:
            r31 = r1
            r1 = 0
        L_0x0234:
            if (r1 >= r2) goto L_0x024d
            r4 = r28[r31]
            r30 = r5[r31]
            int r32 = r1 + 1
            r33 = r27[r32]
            int r33 = r39 << r33
            int r33 = r33 + -1
            r30 = r30 & r33
            r33 = r27[r1]
            int r30 = r30 >> r33
            r4[r1] = r30
            r1 = r32
            goto L_0x0234
        L_0x024d:
            int r1 = r31 + 1
            r38 = 6
            goto L_0x0201
        L_0x0252:
            r29 = -1
            int[] r1 = new int[r10]
            r2 = r39
            r4 = 0
        L_0x0259:
            if (r4 >= r7) goto L_0x02a0
            r8 = r5[r4]
            r1[r8] = r29
            r26 = r1
            r8 = 0
            r20 = 0
        L_0x0264:
            r1 = 16
            if (r8 >= r1) goto L_0x0282
            boolean r1 = r14[r8]
            if (r1 == 0) goto L_0x027c
            r1 = r39
            if (r8 != r1) goto L_0x0279
            r8 = r5[r4]
            r27 = r28[r4]
            r27 = r27[r20]
            r26[r8] = r27
            r8 = r1
        L_0x0279:
            int r20 = r20 + 1
            goto L_0x027e
        L_0x027c:
            r1 = r39
        L_0x027e:
            int r8 = r8 + r1
            r39 = r1
            goto L_0x0264
        L_0x0282:
            if (r4 <= 0) goto L_0x0299
            r1 = 0
        L_0x0285:
            if (r1 >= r4) goto L_0x0297
            r8 = r5[r4]
            r8 = r26[r8]
            r20 = r5[r1]
            r27 = r1
            r1 = r26[r20]
            if (r8 != r1) goto L_0x0294
            goto L_0x0299
        L_0x0294:
            int r1 = r27 + 1
            goto L_0x0285
        L_0x0297:
            int r2 = r2 + 1
        L_0x0299:
            int r4 = r4 + 1
            r1 = r26
            r39 = 1
            goto L_0x0259
        L_0x02a0:
            r26 = r1
            r1 = 4
            int r4 = r0.zza(r1)
            r1 = 2
            if (r2 < r1) goto L_0x0842
            if (r4 != 0) goto L_0x02ae
            goto L_0x0842
        L_0x02ae:
            int[] r1 = new int[r2]
            r8 = 0
        L_0x02b1:
            if (r8 >= r2) goto L_0x02bc
            int r14 = r0.zza(r4)
            r1[r8] = r14
            int r8 = r8 + 1
            goto L_0x02b1
        L_0x02bc:
            int[] r4 = new int[r10]
            r8 = 0
        L_0x02bf:
            if (r8 >= r7) goto L_0x02cc
            r14 = r5[r8]
            int r14 = java.lang.Math.min(r14, r13)
            r4[r14] = r8
            int r8 = r8 + 1
            goto L_0x02bf
        L_0x02cc:
            com.google.android.gms.internal.ads.zzfzl r8 = new com.google.android.gms.internal.ads.zzfzl
            r8.<init>()
            r14 = 0
        L_0x02d2:
            if (r14 > r13) goto L_0x02fc
            r20 = r1
            r1 = r26[r14]
            r38 = r2
            int r2 = r38 + -1
            int r1 = java.lang.Math.min(r1, r2)
            if (r1 < 0) goto L_0x02e5
            r1 = r20[r1]
            goto L_0x02e7
        L_0x02e5:
            r1 = r29
        L_0x02e7:
            com.google.android.gms.internal.ads.zzfc r2 = new com.google.android.gms.internal.ads.zzfc
            r27 = r4
            r4 = r27[r14]
            r2.<init>(r4, r1)
            r8.zzf(r2)
            int r14 = r14 + 1
            r2 = r38
            r1 = r20
            r4 = r27
            goto L_0x02d2
        L_0x02fc:
            com.google.android.gms.internal.ads.zzfzo r1 = r8.zzi()
            r2 = 0
            java.lang.Object r4 = r1.get(r2)
            com.google.android.gms.internal.ads.zzfc r4 = (com.google.android.gms.internal.ads.zzfc) r4
            int r2 = r4.zzb
            r4 = r29
            if (r2 != r4) goto L_0x031a
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = r22
            r2 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x031a:
            r4 = r22
            r8 = 1
        L_0x031d:
            r2 = r23
            if (r8 > r13) goto L_0x0332
            java.lang.Object r14 = r1.get(r8)
            com.google.android.gms.internal.ads.zzfc r14 = (com.google.android.gms.internal.ads.zzfc) r14
            int r14 = r14.zzb
            r23 = r2
            r2 = -1
            if (r14 == r2) goto L_0x032f
            goto L_0x0336
        L_0x032f:
            int r8 = r8 + 1
            goto L_0x031d
        L_0x0332:
            r23 = r2
            r2 = -1
            r8 = r2
        L_0x0336:
            if (r8 != r2) goto L_0x0343
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r2 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x0343:
            r2 = r23
            r13 = 2
            int[] r14 = new int[r13]
            r20 = 1
            r14[r20] = r7
            r18 = 0
            r14[r18] = r7
            java.lang.Class r13 = java.lang.Boolean.TYPE
            java.lang.Object r13 = java.lang.reflect.Array.newInstance(r13, r14)
            boolean[][] r13 = (boolean[][]) r13
            r14 = 2
            int[] r2 = new int[r14]
            r2[r20] = r7
            r2[r18] = r7
            java.lang.Class r14 = java.lang.Boolean.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r14, r2)
            boolean[][] r2 = (boolean[][]) r2
            r14 = 1
        L_0x0368:
            if (r14 >= r7) goto L_0x0383
            r38 = r2
            r2 = 0
        L_0x036d:
            if (r2 >= r14) goto L_0x037e
            r20 = r13[r14]
            r22 = r38[r14]
            boolean r26 = r0.zzh()
            r22[r2] = r26
            r20[r2] = r26
            int r2 = r2 + 1
            goto L_0x036d
        L_0x037e:
            int r14 = r14 + 1
            r2 = r38
            goto L_0x0368
        L_0x0383:
            r38 = r2
            r2 = 1
        L_0x0386:
            if (r2 >= r7) goto L_0x03ae
            r14 = 0
        L_0x0389:
            if (r14 >= r6) goto L_0x03a9
            r22 = r4
            r4 = 0
        L_0x038e:
            if (r4 >= r2) goto L_0x03a4
            r20 = r38[r2]
            boolean r26 = r20[r4]
            if (r26 == 0) goto L_0x03a1
            r26 = r38[r4]
            boolean r26 = r26[r14]
            if (r26 == 0) goto L_0x03a1
            r26 = 1
            r20[r14] = r26
            goto L_0x03a4
        L_0x03a1:
            int r4 = r4 + 1
            goto L_0x038e
        L_0x03a4:
            int r14 = r14 + 1
            r4 = r22
            goto L_0x0389
        L_0x03a9:
            r22 = r4
            int r2 = r2 + 1
            goto L_0x0386
        L_0x03ae:
            r22 = r4
            int[] r2 = new int[r10]
            r4 = 0
        L_0x03b3:
            if (r4 >= r7) goto L_0x03ca
            r14 = 0
            r20 = 0
        L_0x03b8:
            if (r14 >= r4) goto L_0x03c3
            r26 = r13[r4]
            boolean r26 = r26[r14]
            int r20 = r20 + r26
            int r14 = r14 + 1
            goto L_0x03b8
        L_0x03c3:
            r14 = r5[r4]
            r2[r14] = r20
            int r4 = r4 + 1
            goto L_0x03b3
        L_0x03ca:
            r4 = 0
            r14 = 0
        L_0x03cc:
            if (r4 >= r7) goto L_0x03d9
            r20 = r5[r4]
            r20 = r2[r20]
            if (r20 != 0) goto L_0x03d6
            int r14 = r14 + 1
        L_0x03d6:
            int r4 = r4 + 1
            goto L_0x03cc
        L_0x03d9:
            r4 = 1
            if (r14 <= r4) goto L_0x03e9
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = r22
            r2 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x03e9:
            r4 = r22
            int[] r14 = new int[r7]
            r20 = r2
            int[] r2 = new int[r15]
            boolean r22 = r0.zzh()
            if (r22 == 0) goto L_0x0408
            r22 = r2
            r2 = 0
        L_0x03fa:
            if (r2 >= r7) goto L_0x040e
            r26 = r2
            r2 = 3
            int r27 = r0.zza(r2)
            r14[r26] = r27
            int r2 = r26 + 1
            goto L_0x03fa
        L_0x0408:
            r22 = r2
            r2 = 0
            java.util.Arrays.fill(r14, r2, r7, r9)
        L_0x040e:
            r2 = 0
        L_0x040f:
            if (r2 >= r15) goto L_0x043d
            r26 = r2
            r27 = r4
            r28 = r5
            r2 = 0
            r4 = 0
        L_0x0419:
            r5 = r11[r26]
            if (r2 >= r5) goto L_0x0432
            r5 = r25[r26]
            r5 = r5[r2]
            java.lang.Object r5 = r1.get(r5)
            com.google.android.gms.internal.ads.zzfc r5 = (com.google.android.gms.internal.ads.zzfc) r5
            int r5 = r5.zza
            r5 = r14[r5]
            int r4 = java.lang.Math.max(r4, r5)
            int r2 = r2 + 1
            goto L_0x0419
        L_0x0432:
            int r4 = r4 + 1
            r22[r26] = r4
            int r2 = r26 + 1
            r4 = r27
            r5 = r28
            goto L_0x040f
        L_0x043d:
            r27 = r4
            r28 = r5
            boolean r2 = r0.zzh()
            if (r2 == 0) goto L_0x045e
            r2 = 0
        L_0x0448:
            if (r2 >= r6) goto L_0x045e
            int r4 = r2 + 1
            r5 = r4
        L_0x044d:
            if (r5 >= r7) goto L_0x045c
            r14 = r13[r5]
            boolean r14 = r14[r2]
            if (r14 == 0) goto L_0x0459
            r14 = 3
            r0.zzf(r14)
        L_0x0459:
            int r5 = r5 + 1
            goto L_0x044d
        L_0x045c:
            r2 = r4
            goto L_0x0448
        L_0x045e:
            r0.zze()
            int r2 = r0.zzc()
            r4 = 1
            int r2 = r2 + r4
            com.google.android.gms.internal.ads.zzfzl r5 = new com.google.android.gms.internal.ads.zzfzl
            r5.<init>()
            r5.zzf(r12)
            if (r2 <= r4) goto L_0x0485
            r5.zzf(r3)
            r4 = 2
        L_0x0475:
            if (r4 >= r2) goto L_0x0485
            boolean r6 = r0.zzh()
            com.google.android.gms.internal.ads.zzfe r3 = zzm(r0, r6, r9, r3)
            r5.zzf(r3)
            int r4 = r4 + 1
            goto L_0x0475
        L_0x0485:
            com.google.android.gms.internal.ads.zzfzo r3 = r5.zzi()
            int r4 = r0.zzc()
            int r4 = r4 + r15
            if (r4 <= r15) goto L_0x049d
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r2 = r23
            r4 = r27
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x049d:
            r14 = 2
            int r5 = r0.zza(r14)
            int[] r6 = new int[r14]
            r26 = 1
            r6[r26] = r10
            r9 = 0
            r6[r9] = r4
            java.lang.Class r12 = java.lang.Boolean.TYPE
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r12, r6)
            boolean[][] r6 = (boolean[][]) r6
            int[] r12 = new int[r4]
            int[] r14 = new int[r4]
            r18 = r9
        L_0x04b9:
            if (r9 >= r15) goto L_0x050f
            r12[r9] = r18
            r26 = r6
            r6 = r24[r9]
            r14[r9] = r6
            if (r5 != 0) goto L_0x04dc
            r6 = r26[r9]
            r29 = r9
            r9 = r11[r29]
            r30 = r11
            r31 = r12
            r11 = r18
            r12 = 1
            java.util.Arrays.fill(r6, r11, r9, r12)
            r6 = r30[r29]
            r31[r29] = r6
        L_0x04d9:
            r18 = 0
            goto L_0x0506
        L_0x04dc:
            r29 = r9
            r30 = r11
            r31 = r12
            r12 = 1
            if (r5 != r12) goto L_0x04fe
            r9 = 0
        L_0x04e6:
            r11 = r30[r29]
            if (r9 >= r11) goto L_0x04fa
            r11 = r26[r29]
            r12 = r25[r29]
            r12 = r12[r9]
            if (r12 != r6) goto L_0x04f4
            r12 = 1
            goto L_0x04f5
        L_0x04f4:
            r12 = 0
        L_0x04f5:
            r11[r9] = r12
            int r9 = r9 + 1
            goto L_0x04e6
        L_0x04fa:
            r12 = 1
            r31[r29] = r12
            goto L_0x04d9
        L_0x04fe:
            r18 = 0
            r6 = r26[r18]
            r6[r18] = r12
            r31[r18] = r12
        L_0x0506:
            int r9 = r29 + 1
            r6 = r26
            r11 = r30
            r12 = r31
            goto L_0x04b9
        L_0x050f:
            r26 = r6
            r30 = r11
            r31 = r12
            r12 = 1
            int[] r6 = new int[r10]
            r9 = 2
            int[] r11 = new int[r9]
            r11[r12] = r10
            r11[r18] = r4
            java.lang.Class r10 = java.lang.Boolean.TYPE
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r11)
            boolean[][] r10 = (boolean[][]) r10
            r11 = 1
            r12 = 0
        L_0x0529:
            if (r11 >= r4) goto L_0x0611
            r24 = r5
            if (r5 != r9) goto L_0x0551
            r9 = 0
        L_0x0530:
            r5 = r30[r11]
            if (r9 >= r5) goto L_0x0551
            r5 = r26[r11]
            boolean r29 = r0.zzh()
            r5[r9] = r29
            r5 = r31[r11]
            r29 = r26[r11]
            boolean r29 = r29[r9]
            int r5 = r5 + r29
            r31[r11] = r5
            if (r29 == 0) goto L_0x054e
            r5 = r25[r11]
            r5 = r5[r9]
            r14[r11] = r5
        L_0x054e:
            int r9 = r9 + 1
            goto L_0x0530
        L_0x0551:
            if (r12 != 0) goto L_0x057d
            r5 = r25[r11]
            r18 = 0
            r5 = r5[r18]
            if (r5 != 0) goto L_0x057a
            r5 = r26[r11]
            boolean r5 = r5[r18]
            if (r5 == 0) goto L_0x057a
            r9 = r18
            r5 = 1
        L_0x0564:
            r12 = r30[r11]
            if (r5 >= r12) goto L_0x0578
            r12 = r25[r11]
            r12 = r12[r5]
            if (r12 != r8) goto L_0x0575
            r12 = r26[r11]
            boolean r12 = r12[r8]
            if (r12 == 0) goto L_0x0575
            r9 = r11
        L_0x0575:
            int r5 = r5 + 1
            goto L_0x0564
        L_0x0578:
            r12 = r9
            goto L_0x057f
        L_0x057a:
            r12 = r18
            goto L_0x057f
        L_0x057d:
            r18 = 0
        L_0x057f:
            r5 = r18
        L_0x0581:
            r9 = r30[r11]
            if (r5 >= r9) goto L_0x05f4
            r9 = 1
            if (r2 <= r9) goto L_0x05e7
            r9 = r10[r11]
            r29 = r26[r11]
            boolean r29 = r29[r5]
            r9[r5] = r29
            r29 = r8
            double r8 = (double) r2
            r32 = r2
            java.math.RoundingMode r2 = java.math.RoundingMode.CEILING
            int r2 = com.google.android.gms.internal.ads.zzgch.zza(r8, r2)
            r8 = r10[r11]
            boolean r8 = r8[r5]
            if (r8 != 0) goto L_0x05d0
            r8 = r25[r11]
            r8 = r8[r5]
            java.lang.Object r8 = r1.get(r8)
            com.google.android.gms.internal.ads.zzfc r8 = (com.google.android.gms.internal.ads.zzfc) r8
            int r8 = r8.zza
            r9 = r18
        L_0x05af:
            if (r9 >= r5) goto L_0x05d0
            r33 = r25[r11]
            r34 = r5
            r5 = r33[r9]
            java.lang.Object r5 = r1.get(r5)
            com.google.android.gms.internal.ads.zzfc r5 = (com.google.android.gms.internal.ads.zzfc) r5
            int r5 = r5.zza
            r33 = r38[r8]
            boolean r5 = r33[r5]
            if (r5 == 0) goto L_0x05cb
            r5 = r10[r11]
            r9 = 1
            r5[r34] = r9
            goto L_0x05d2
        L_0x05cb:
            int r9 = r9 + 1
            r5 = r34
            goto L_0x05af
        L_0x05d0:
            r34 = r5
        L_0x05d2:
            r5 = r10[r11]
            boolean r5 = r5[r34]
            if (r5 == 0) goto L_0x05ed
            if (r12 <= 0) goto L_0x05e3
            if (r11 != r12) goto L_0x05e3
            int r2 = r0.zza(r2)
            r6[r34] = r2
            goto L_0x05ed
        L_0x05e3:
            r0.zzf(r2)
            goto L_0x05ed
        L_0x05e7:
            r32 = r2
            r34 = r5
            r29 = r8
        L_0x05ed:
            int r5 = r34 + 1
            r8 = r29
            r2 = r32
            goto L_0x0581
        L_0x05f4:
            r32 = r2
            r29 = r8
            r2 = r31[r11]
            r9 = 1
            if (r2 != r9) goto L_0x0606
            r2 = r14[r11]
            r2 = r20[r2]
            if (r2 <= 0) goto L_0x0606
            r0.zze()
        L_0x0606:
            int r11 = r11 + 1
            r5 = r24
            r8 = r29
            r2 = r32
            r9 = 2
            goto L_0x0529
        L_0x0611:
            r18 = 0
            if (r12 != 0) goto L_0x0622
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r2 = r23
            r4 = r27
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x0622:
            r2 = r23
            int r5 = r0.zzc()
            int r8 = r5 + 1
            com.google.android.gms.internal.ads.zzfzl r9 = com.google.android.gms.internal.ads.zzfzo.zzi(r8)
            int[] r11 = new int[r7]
            r12 = r18
        L_0x0632:
            if (r12 >= r8) goto L_0x06b4
            r38 = r1
            r14 = 16
            int r1 = r0.zza(r14)
            r23 = r2
            int r2 = r0.zza(r14)
            boolean r21 = r0.zzh()
            if (r21 == 0) goto L_0x0663
            r24 = r10
            r14 = 2
            int r10 = r0.zza(r14)
            r14 = 3
            if (r10 != r14) goto L_0x0655
            r0.zze()
        L_0x0655:
            r14 = 4
            int r25 = r0.zza(r14)
            int r26 = r0.zza(r14)
            r33 = r25
            r34 = r26
            goto L_0x066b
        L_0x0663:
            r24 = r10
            r10 = r18
            r33 = r10
            r34 = r33
        L_0x066b:
            boolean r14 = r0.zzh()
            if (r14 == 0) goto L_0x0690
            int r14 = r0.zzc()
            r25 = r12
            int r12 = r0.zzc()
            r26 = r13
            int r13 = r0.zzc()
            r27 = r3
            int r3 = r0.zzc()
            int r1 = zzk(r1, r10, r14, r12)
            int r2 = zzj(r2, r10, r13, r3)
            goto L_0x0696
        L_0x0690:
            r27 = r3
            r25 = r12
            r26 = r13
        L_0x0696:
            r35 = r1
            r36 = r2
            com.google.android.gms.internal.ads.zzfg r31 = new com.google.android.gms.internal.ads.zzfg
            r32 = r10
            r31.<init>(r32, r33, r34, r35, r36)
            r1 = r31
            r9.zzf(r1)
            int r12 = r25 + 1
            r1 = r38
            r2 = r23
            r10 = r24
            r13 = r26
            r3 = r27
            goto L_0x0632
        L_0x06b4:
            r38 = r1
            r23 = r2
            r27 = r3
            r24 = r10
            r26 = r13
            r12 = 1
            if (r8 <= r12) goto L_0x06da
            boolean r1 = r0.zzh()
            if (r1 == 0) goto L_0x06da
            double r1 = (double) r8
            java.math.RoundingMode r3 = java.math.RoundingMode.CEILING
            int r1 = com.google.android.gms.internal.ads.zzgch.zza(r1, r3)
            r2 = 1
        L_0x06cf:
            if (r2 >= r7) goto L_0x06e6
            int r3 = r0.zza(r1)
            r11[r2] = r3
            int r2 = r2 + 1
            goto L_0x06cf
        L_0x06da:
            r1 = 1
        L_0x06db:
            if (r1 >= r7) goto L_0x06e6
            int r2 = java.lang.Math.min(r1, r5)
            r11[r1] = r2
            int r1 = r1 + 1
            goto L_0x06db
        L_0x06e6:
            com.google.android.gms.internal.ads.zzfh r5 = new com.google.android.gms.internal.ads.zzfh
            com.google.android.gms.internal.ads.zzfzo r1 = r9.zzi()
            r5.<init>(r1, r11)
            r14 = 2
            r0.zzf(r14)
            r1 = 1
        L_0x06f4:
            if (r1 >= r7) goto L_0x0702
            r2 = r28[r1]
            r2 = r20[r2]
            if (r2 != 0) goto L_0x06ff
            r0.zze()
        L_0x06ff:
            int r1 = r1 + 1
            goto L_0x06f4
        L_0x0702:
            r1 = 1
        L_0x0703:
            if (r1 >= r4) goto L_0x073e
            boolean r2 = r0.zzh()
            r3 = r18
        L_0x070b:
            r8 = r22[r1]
            if (r3 >= r8) goto L_0x073b
            if (r3 <= 0) goto L_0x0718
            if (r2 == 0) goto L_0x0718
            boolean r8 = r0.zzh()
            goto L_0x071e
        L_0x0718:
            if (r3 != 0) goto L_0x071c
            r8 = 1
            goto L_0x071e
        L_0x071c:
            r8 = r18
        L_0x071e:
            if (r8 == 0) goto L_0x0738
            r8 = r18
        L_0x0722:
            r9 = r30[r1]
            if (r8 >= r9) goto L_0x0732
            r9 = r24[r1]
            boolean r9 = r9[r8]
            if (r9 == 0) goto L_0x072f
            r0.zzc()
        L_0x072f:
            int r8 = r8 + 1
            goto L_0x0722
        L_0x0732:
            r0.zzc()
            r0.zzc()
        L_0x0738:
            int r3 = r3 + 1
            goto L_0x070b
        L_0x073b:
            int r1 = r1 + 1
            goto L_0x0703
        L_0x073e:
            int r1 = r0.zzc()
            r16 = 2
            int r1 = r1 + 2
            boolean r2 = r0.zzh()
            if (r2 == 0) goto L_0x0750
            r0.zzf(r1)
            goto L_0x0766
        L_0x0750:
            r2 = 1
        L_0x0751:
            if (r2 >= r7) goto L_0x0766
            r3 = r18
        L_0x0755:
            if (r3 >= r2) goto L_0x0763
            r4 = r26[r2]
            boolean r4 = r4[r3]
            if (r4 == 0) goto L_0x0760
            r0.zzf(r1)
        L_0x0760:
            int r3 = r3 + 1
            goto L_0x0755
        L_0x0763:
            int r2 = r2 + 1
            goto L_0x0751
        L_0x0766:
            int r1 = r0.zzc()
            r2 = 1
        L_0x076b:
            if (r2 > r1) goto L_0x0775
            r14 = 8
            r0.zzf(r14)
            int r2 = r2 + 1
            goto L_0x076b
        L_0x0775:
            boolean r1 = r0.zzh()
            if (r1 == 0) goto L_0x082f
            r0.zzd()
            boolean r1 = r0.zzh()
            if (r1 != 0) goto L_0x078a
            boolean r1 = r0.zzh()
            if (r1 == 0) goto L_0x078d
        L_0x078a:
            r0.zze()
        L_0x078d:
            boolean r1 = r0.zzh()
            boolean r2 = r0.zzh()
            if (r1 != 0) goto L_0x0799
            if (r2 == 0) goto L_0x07c9
        L_0x0799:
            r3 = r18
        L_0x079b:
            if (r3 >= r15) goto L_0x07c9
            r4 = r18
        L_0x079f:
            r8 = r22[r3]
            if (r4 >= r8) goto L_0x07c6
            if (r1 == 0) goto L_0x07aa
            boolean r8 = r0.zzh()
            goto L_0x07ac
        L_0x07aa:
            r8 = r18
        L_0x07ac:
            if (r2 == 0) goto L_0x07b3
            boolean r9 = r0.zzh()
            goto L_0x07b5
        L_0x07b3:
            r9 = r18
        L_0x07b5:
            if (r8 == 0) goto L_0x07bc
            r8 = 32
            r0.zzf(r8)
        L_0x07bc:
            if (r9 == 0) goto L_0x07c3
            r8 = 18
            r0.zzf(r8)
        L_0x07c3:
            int r4 = r4 + 1
            goto L_0x079f
        L_0x07c6:
            int r3 = r3 + 1
            goto L_0x079b
        L_0x07c9:
            boolean r1 = r0.zzh()
            if (r1 == 0) goto L_0x07d7
            r14 = 4
            int r2 = r0.zza(r14)
            r9 = 1
            int r2 = r2 + r9
            goto L_0x07d9
        L_0x07d7:
            r9 = 1
            r2 = r7
        L_0x07d9:
            com.google.android.gms.internal.ads.zzfzl r3 = com.google.android.gms.internal.ads.zzfzo.zzi(r2)
            int[] r4 = new int[r7]
            r8 = r18
        L_0x07e1:
            if (r8 >= r2) goto L_0x0812
            r14 = 3
            r0.zzf(r14)
            boolean r10 = r0.zzh()
            if (r9 == r10) goto L_0x07f0
            r9 = r16
            goto L_0x07f1
        L_0x07f0:
            r9 = 1
        L_0x07f1:
            r10 = 8
            int r11 = r0.zza(r10)
            int r11 = com.google.android.gms.internal.ads.zzm.zza(r11)
            int r12 = r0.zza(r10)
            int r12 = com.google.android.gms.internal.ads.zzm.zzb(r12)
            r0.zzf(r10)
            com.google.android.gms.internal.ads.zzfk r13 = new com.google.android.gms.internal.ads.zzfk
            r13.<init>(r11, r9, r12)
            r3.zzf(r13)
            int r8 = r8 + 1
            r9 = 1
            goto L_0x07e1
        L_0x0812:
            if (r1 == 0) goto L_0x0825
            r9 = 1
            if (r2 <= r9) goto L_0x0825
            r14 = r18
        L_0x0819:
            if (r14 >= r7) goto L_0x0825
            r1 = 4
            int r2 = r0.zza(r1)
            r4[r14] = r2
            int r14 = r14 + 1
            goto L_0x0819
        L_0x0825:
            com.google.android.gms.internal.ads.zzfl r11 = new com.google.android.gms.internal.ads.zzfl
            com.google.android.gms.internal.ads.zzfzo r0 = r3.zzi()
            r11.<init>(r0, r4)
            goto L_0x0830
        L_0x082f:
            r11 = 0
        L_0x0830:
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            com.google.android.gms.internal.ads.zzff r4 = new com.google.android.gms.internal.ads.zzff
            r0 = r27
            r4.<init>(r0, r6)
            r3 = r38
            r6 = r11
            r2 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x0842:
            r4 = r22
            r2 = r23
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x084f:
            r2 = r23
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L_0x085a:
            com.google.android.gms.internal.ads.zzfm r1 = new com.google.android.gms.internal.ads.zzfm
            r5 = 0
            r6 = 0
            r3 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzd(byte[], int, int):com.google.android.gms.internal.ads.zzfm");
    }

    public static zzfn zze(byte[] bArr, int i, int i2) {
        zzfq zzfq = new zzfq(bArr, 4, i2);
        int zzc2 = zzfq.zzc();
        int zzc3 = zzfq.zzc();
        zzfq.zze();
        return new zzfn(zzc2, zzc3, zzfq.zzh());
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfo zzf(byte[] r32, int r33, int r34) {
        /*
            com.google.android.gms.internal.ads.zzfq r0 = new com.google.android.gms.internal.ads.zzfq
            r1 = r32
            r2 = r33
            r3 = r34
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r2 = r0.zza(r1)
            int r5 = r0.zza(r1)
            int r6 = r0.zza(r1)
            int r7 = r0.zzc()
            r3 = 86
            r4 = 44
            r8 = 122(0x7a, float:1.71E-43)
            r9 = 110(0x6e, float:1.54E-43)
            r10 = 244(0xf4, float:3.42E-43)
            r11 = 3
            r14 = 1
            r15 = 100
            if (r2 == r15) goto L_0x0053
            if (r2 == r9) goto L_0x0053
            if (r2 == r8) goto L_0x0053
            if (r2 == r10) goto L_0x0053
            if (r2 == r4) goto L_0x0053
            r13 = 83
            if (r2 == r13) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            r13 = 118(0x76, float:1.65E-43)
            if (r2 == r13) goto L_0x0053
            r13 = 128(0x80, float:1.794E-43)
            if (r2 == r13) goto L_0x0053
            r13 = 138(0x8a, float:1.93E-43)
            if (r2 != r13) goto L_0x0049
            r2 = r13
            goto L_0x0053
        L_0x0049:
            r13 = r14
            r33 = 16
            r12 = 0
            r16 = 0
            r18 = 0
            goto L_0x00b5
        L_0x0053:
            int r13 = r0.zzc()
            if (r13 != r11) goto L_0x005f
            boolean r16 = r0.zzh()
            r12 = r11
            goto L_0x0062
        L_0x005f:
            r12 = r13
            r16 = 0
        L_0x0062:
            r33 = 16
            int r17 = r0.zzc()
            int r18 = r0.zzc()
            r0.zze()
            boolean r19 = r0.zzh()
            if (r19 == 0) goto L_0x00b3
            if (r12 == r11) goto L_0x0079
            r12 = r1
            goto L_0x007b
        L_0x0079:
            r12 = 12
        L_0x007b:
            r1 = 0
        L_0x007c:
            if (r1 >= r12) goto L_0x00b3
            boolean r19 = r0.zzh()
            if (r19 == 0) goto L_0x00aa
            r10 = 6
            if (r1 >= r10) goto L_0x008a
            r10 = r33
            goto L_0x008c
        L_0x008a:
            r10 = 64
        L_0x008c:
            r8 = 0
            r20 = 8
            r21 = 8
        L_0x0091:
            if (r8 >= r10) goto L_0x00aa
            if (r20 == 0) goto L_0x00a1
            int r20 = r0.zzb()
            int r9 = r21 + r20
            int r9 = r9 + 256
            int r9 = r9 % 256
            r20 = r9
        L_0x00a1:
            if (r20 == 0) goto L_0x00a5
            r21 = r20
        L_0x00a5:
            int r8 = r8 + 1
            r9 = 110(0x6e, float:1.54E-43)
            goto L_0x0091
        L_0x00aa:
            int r1 = r1 + 1
            r8 = 122(0x7a, float:1.71E-43)
            r9 = 110(0x6e, float:1.54E-43)
            r10 = 244(0xf4, float:3.42E-43)
            goto L_0x007c
        L_0x00b3:
            r12 = r17
        L_0x00b5:
            int r1 = r0.zzc()
            int r1 = r1 + 4
            int r8 = r0.zzc()
            if (r8 != 0) goto L_0x00cc
            int r9 = r0.zzc()
            int r9 = r9 + 4
            r3 = 244(0xf4, float:3.42E-43)
        L_0x00c9:
            r19 = 0
            goto L_0x00f4
        L_0x00cc:
            if (r8 != r14) goto L_0x00f0
            boolean r8 = r0.zzh()
            r0.zzb()
            r0.zzb()
            int r9 = r0.zzc()
            long r9 = (long) r9
            r15 = 0
        L_0x00de:
            long r3 = (long) r15
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x00e9
            r0.zzc()
            int r15 = r15 + 1
            goto L_0x00de
        L_0x00e9:
            r19 = r8
            r8 = r14
            r3 = 244(0xf4, float:3.42E-43)
            r9 = 0
            goto L_0x00f4
        L_0x00f0:
            r3 = 244(0xf4, float:3.42E-43)
            r9 = 0
            goto L_0x00c9
        L_0x00f4:
            int r4 = r0.zzc()
            r0.zze()
            int r10 = r0.zzc()
            int r10 = r10 + r14
            int r15 = r0.zzc()
            int r15 = r15 + r14
            r24 = r15
            boolean r15 = r0.zzh()
            int r25 = 2 - r15
            if (r15 != 0) goto L_0x0112
            r0.zze()
        L_0x0112:
            int r24 = r24 * r25
            r0.zze()
            int r10 = r10 * 16
            int r24 = r24 * 16
            boolean r26 = r0.zzh()
            r27 = 2
            if (r26 == 0) goto L_0x0153
            int r26 = r0.zzc()
            int r28 = r0.zzc()
            int r29 = r0.zzc()
            int r30 = r0.zzc()
            if (r13 != 0) goto L_0x0138
            r31 = r14
            goto L_0x0147
        L_0x0138:
            if (r13 != r11) goto L_0x013d
            r31 = r14
            goto L_0x013f
        L_0x013d:
            r31 = r27
        L_0x013f:
            if (r13 != r14) goto L_0x0144
            r13 = r27
            goto L_0x0145
        L_0x0144:
            r13 = r14
        L_0x0145:
            int r25 = r25 * r13
        L_0x0147:
            int r26 = r26 + r28
            int r26 = r26 * r31
            int r10 = r10 - r26
            int r29 = r29 + r30
            int r29 = r29 * r25
            int r24 = r24 - r29
        L_0x0153:
            r13 = 44
            if (r2 == r13) goto L_0x016a
            r13 = 86
            if (r2 == r13) goto L_0x016a
            r13 = 100
            if (r2 == r13) goto L_0x016a
            r13 = 110(0x6e, float:1.54E-43)
            if (r2 == r13) goto L_0x016a
            r13 = 122(0x7a, float:1.71E-43)
            if (r2 == r13) goto L_0x016a
            if (r2 != r3) goto L_0x0170
            r2 = r3
        L_0x016a:
            r3 = r5 & 16
            if (r3 == 0) goto L_0x0170
            r13 = 0
            goto L_0x0172
        L_0x0170:
            r13 = r33
        L_0x0172:
            boolean r3 = r0.zzh()
            r17 = 1065353216(0x3f800000, float:1.0)
            r20 = -1
            if (r3 == 0) goto L_0x025b
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x01be
            r3 = 8
            int r14 = r0.zza(r3)
            r3 = 255(0xff, float:3.57E-43)
            if (r14 != r3) goto L_0x01a0
            r3 = r33
            int r14 = r0.zza(r3)
            int r3 = r0.zza(r3)
            if (r14 == 0) goto L_0x01be
            if (r3 == 0) goto L_0x01be
            float r14 = (float) r14
            float r3 = (float) r3
            float r14 = r14 / r3
            r17 = r14
            goto L_0x01be
        L_0x01a0:
            r3 = 17
            if (r14 >= r3) goto L_0x01ab
            float[] r3 = zzb
            r3 = r3[r14]
            r17 = r3
            goto L_0x01be
        L_0x01ab:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r11 = "Unexpected aspect_ratio_idc value: "
            r3.<init>(r11)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            java.lang.String r11 = "NalUnitUtil"
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r3)
        L_0x01be:
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x01c7
            r0.zze()
        L_0x01c7:
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x01fe
            r3 = 3
            r0.zzf(r3)
            boolean r3 = r0.zzh()
            r11 = 1
            if (r11 == r3) goto L_0x01db
            r14 = r27
            goto L_0x01dc
        L_0x01db:
            r14 = r11
        L_0x01dc:
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x01f8
            r3 = 8
            int r11 = r0.zza(r3)
            int r20 = r0.zza(r3)
            r0.zzf(r3)
            int r3 = com.google.android.gms.internal.ads.zzm.zza(r11)
            int r11 = com.google.android.gms.internal.ads.zzm.zzb(r20)
            goto L_0x01fb
        L_0x01f8:
            r3 = r20
            r11 = r3
        L_0x01fb:
            r20 = r14
            goto L_0x0201
        L_0x01fe:
            r3 = r20
            r11 = r3
        L_0x0201:
            boolean r14 = r0.zzh()
            if (r14 == 0) goto L_0x020d
            r0.zzc()
            r0.zzc()
        L_0x020d:
            boolean r14 = r0.zzh()
            if (r14 == 0) goto L_0x0218
            r14 = 65
            r0.zzf(r14)
        L_0x0218:
            boolean r14 = r0.zzh()
            if (r14 == 0) goto L_0x0221
            zzn(r0)
        L_0x0221:
            boolean r21 = r0.zzh()
            if (r21 == 0) goto L_0x022a
            zzn(r0)
        L_0x022a:
            if (r14 != 0) goto L_0x022e
            if (r21 == 0) goto L_0x0231
        L_0x022e:
            r0.zze()
        L_0x0231:
            r0.zze()
            boolean r14 = r0.zzh()
            if (r14 == 0) goto L_0x0250
            r0.zze()
            r0.zzc()
            r0.zzc()
            r0.zzc()
            r0.zzc()
            int r13 = r0.zzc()
            r0.zzc()
        L_0x0250:
            r22 = r11
            r23 = r13
            r11 = r17
            r21 = r20
            r20 = r3
            goto L_0x0263
        L_0x025b:
            r23 = r13
            r11 = r17
            r21 = r20
            r22 = r21
        L_0x0263:
            com.google.android.gms.internal.ads.zzfo r3 = new com.google.android.gms.internal.ads.zzfo
            r17 = r8
            r14 = r16
            r13 = r18
            r16 = r1
            r8 = r4
            r18 = r9
            r9 = r10
            r10 = r24
            r4 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzf(byte[], int, int):com.google.android.gms.internal.ads.zzfo");
    }

    public static String zzg(List list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = (byte[]) list.get(i);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                zzfzl zzfzl = new zzfzl();
                int i2 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i2 >= length2) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, length2, zArr);
                    if (zza2 != length2) {
                        zzfzl.zzf(Integer.valueOf(zza2));
                    }
                    i2 = zza2 + 3;
                }
                zzfzo zzi = zzfzl.zzi();
                for (int i3 = 0; i3 < zzi.size(); i3++) {
                    if (((Integer) zzi.get(i3)).intValue() + 3 < length) {
                        zzfq zzfq = new zzfq(bArr, ((Integer) zzi.get(i3)).intValue() + 3, length);
                        zzfd zzl = zzl(zzfq);
                        if (zzl.zza == 33 && zzl.zzb == 0) {
                            zzfq.zzf(4);
                            int zza3 = zzfq.zza(3);
                            zzfq.zze();
                            zzfe zzm = zzm(zzfq, true, zza3, (zzfe) null);
                            return zzdd.zzd(zzm.zza, zzm.zzb, zzm.zzc, zzm.zzd, zzm.zze, zzm.zzf);
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static void zzh(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean zzi(byte b) {
        if (((b & 96) >> 5) != 0) {
            return true;
        }
        byte b2 = b & Ascii.US;
        return (b2 == 1 || b2 == 9 || b2 == 14) ? false : true;
    }

    private static int zzj(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 == 1) {
            i5 = 2;
        }
        return i - (i5 * (i3 + i4));
    }

    private static int zzk(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (!(i2 == 1 || i2 == 2)) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    private static zzfd zzl(zzfq zzfq) {
        zzfq.zze();
        return new zzfd(zzfq.zza(6), zzfq.zza(6), zzfq.zza(3) - 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfe zzm(com.google.android.gms.internal.ads.zzfq r18, boolean r19, int r20, com.google.android.gms.internal.ads.zzfe r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 8
            r6 = 0
            if (r19 == 0) goto L_0x003c
            r2 = 2
            int r2 = r0.zza(r2)
            boolean r7 = r0.zzh()
            r8 = 5
            int r8 = r0.zza(r8)
            r9 = r6
            r10 = r9
        L_0x001e:
            r11 = 32
            if (r9 >= r11) goto L_0x002e
            boolean r11 = r0.zzh()
            if (r11 == 0) goto L_0x002b
            r11 = 1
            int r11 = r11 << r9
            r10 = r10 | r11
        L_0x002b:
            int r9 = r9 + 1
            goto L_0x001e
        L_0x002e:
            r9 = r6
        L_0x002f:
            if (r9 >= r3) goto L_0x003a
            int r11 = r0.zza(r5)
            r4[r9] = r11
            int r9 = r9 + 1
            goto L_0x002f
        L_0x003a:
            r12 = r2
            goto L_0x0049
        L_0x003c:
            if (r2 == 0) goto L_0x004f
            int r3 = r2.zza
            boolean r7 = r2.zzb
            int r8 = r2.zzc
            int r10 = r2.zzd
            int[] r4 = r2.zze
            r12 = r3
        L_0x0049:
            r16 = r4
            r13 = r7
            r14 = r8
            r15 = r10
            goto L_0x0055
        L_0x004f:
            r16 = r4
            r12 = r6
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x0055:
            int r17 = r0.zza(r5)
            r2 = r6
        L_0x005a:
            if (r6 >= r1) goto L_0x006f
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x0064
            int r2 = r2 + 88
        L_0x0064:
            boolean r3 = r0.zzh()
            if (r3 == 0) goto L_0x006c
            int r2 = r2 + 8
        L_0x006c:
            int r6 = r6 + 1
            goto L_0x005a
        L_0x006f:
            r0.zzf(r2)
            if (r1 <= 0) goto L_0x0079
            int r5 = r5 - r1
            int r5 = r5 + r5
            r0.zzf(r5)
        L_0x0079:
            com.google.android.gms.internal.ads.zzfe r11 = new com.google.android.gms.internal.ads.zzfe
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzm(com.google.android.gms.internal.ads.zzfq, boolean, int, com.google.android.gms.internal.ads.zzfe):com.google.android.gms.internal.ads.zzfe");
    }

    private static void zzn(zzfq zzfq) {
        int zzc2 = zzfq.zzc() + 1;
        zzfq.zzf(8);
        for (int i = 0; i < zzc2; i++) {
            zzfq.zzc();
            zzfq.zzc();
            zzfq.zze();
        }
        zzfq.zzf(20);
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    int i5 = i3 + 1;
                    if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    }
                    i3 = i5;
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i4) {
                try {
                    int i9 = zzd[i6] - i7;
                    System.arraycopy(bArr, i7, bArr, i8, i9);
                    int i10 = i8 + i9;
                    int i11 = i10 + 1;
                    bArr[i10] = 0;
                    i8 = i10 + 2;
                    bArr[i11] = 0;
                    i7 += i9 + 3;
                    i6++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            System.arraycopy(bArr, i7, bArr, i8, i2 - i8);
        }
        return i2;
    }
}
