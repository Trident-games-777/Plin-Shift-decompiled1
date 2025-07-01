package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.compose.material3.MenuKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzain {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);

    static {
        int i = zzen.zza;
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    public static zzbd zzb(zzes zzes) {
        zzer zzer;
        zzet zzb2 = zzes.zzb(1751411826);
        zzet zzb3 = zzes.zzb(1801812339);
        zzet zzb4 = zzes.zzb(1768715124);
        if (!(zzb2 == null || zzb3 == null || zzb4 == null || zzi(zzb2.zza) != 1835299937)) {
            zzed zzed = zzb3.zza;
            zzed.zzL(12);
            int zzg = zzed.zzg();
            String[] strArr = new String[zzg];
            for (int i = 0; i < zzg; i++) {
                int zzg2 = zzed.zzg();
                zzed.zzM(4);
                strArr[i] = zzed.zzB(zzg2 - 8, StandardCharsets.UTF_8);
            }
            zzed zzed2 = zzb4.zza;
            zzed2.zzL(8);
            ArrayList arrayList = new ArrayList();
            while (zzed2.zzb() > 8) {
                int zzd = zzed2.zzd() + zzed2.zzg();
                int zzg3 = zzed2.zzg() - 1;
                if (zzg3 < 0 || zzg3 >= zzg) {
                    zzdt.zzf("BoxParsers", "Skipped metadata with unknown key index: " + zzg3);
                } else {
                    String str = strArr[zzg3];
                    while (true) {
                        int zzd2 = zzed2.zzd();
                        if (zzd2 >= zzd) {
                            zzer = null;
                            break;
                        }
                        int zzg4 = zzed2.zzg();
                        if (zzed2.zzg() == 1684108385) {
                            int zzg5 = zzed2.zzg();
                            int zzg6 = zzed2.zzg();
                            int i2 = zzg4 - 16;
                            byte[] bArr = new byte[i2];
                            zzed2.zzH(bArr, 0, i2);
                            zzer = new zzer(str, bArr, zzg6, zzg5);
                            break;
                        }
                        zzed2.zzL(zzd2 + zzg4);
                    }
                    if (zzer != null) {
                        arrayList.add(zzer);
                    }
                }
                zzed2.zzL(zzd);
            }
            if (!arrayList.isEmpty()) {
                return new zzbd((List) arrayList);
            }
        }
        return null;
    }

    public static zzbd zzc(zzet zzet) {
        int i;
        zzed zzed = zzet.zza;
        zzed.zzL(8);
        zzbd zzbd = new zzbd(-9223372036854775807L, new zzbc[0]);
        while (zzed.zzb() >= 8) {
            int zzd = zzed.zzd();
            int zzg = zzed.zzg() + zzd;
            int zzg2 = zzed.zzg();
            zzbd zzbd2 = null;
            if (zzg2 == 1835365473) {
                zzed.zzL(zzd);
                zzed.zzM(8);
                zzg(zzed);
                while (true) {
                    if (zzed.zzd() >= zzg) {
                        break;
                    }
                    int zzd2 = zzed.zzd();
                    int zzg3 = zzed.zzg() + zzd2;
                    if (zzed.zzg() == 1768715124) {
                        zzed.zzL(zzd2);
                        zzed.zzM(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzed.zzd() < zzg3) {
                            zzbc zza2 = zzaiv.zza(zzed);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzbd2 = new zzbd((List) arrayList);
                        }
                    } else {
                        zzed.zzL(zzg3);
                    }
                }
                zzbd = zzbd.zzd(zzbd2);
            } else if (zzg2 == 1936553057) {
                zzed.zzL(zzd);
                zzed.zzM(12);
                while (true) {
                    if (zzed.zzd() >= zzg) {
                        break;
                    }
                    int zzd3 = zzed.zzd();
                    int zzg4 = zzed.zzg();
                    if (zzed.zzg() != 1935766900) {
                        zzed.zzL(zzd3 + zzg4);
                    } else if (zzg4 >= 16) {
                        zzed.zzM(4);
                        int i2 = -1;
                        int i3 = 0;
                        for (int i4 = 0; i4 < 2; i4++) {
                            int zzm = zzed.zzm();
                            int zzm2 = zzed.zzm();
                            if (zzm == 0) {
                                i2 = zzm2;
                            } else if (zzm == 1) {
                                i3 = zzm2;
                            }
                        }
                        if (i2 == 12) {
                            i = 240;
                        } else if (i2 == 13) {
                            i = MenuKt.InTransitionDuration;
                        } else {
                            if (i2 == 21 && zzed.zzb() >= 8 && zzed.zzd() + 8 <= zzg) {
                                int zzg5 = zzed.zzg();
                                int zzg6 = zzed.zzg();
                                if (zzg5 >= 12 && zzg6 == 1936877170) {
                                    i = zzed.zzn();
                                }
                            }
                            i = -2147483647;
                        }
                        if (i != -2147483647) {
                            zzbd2 = new zzbd(-9223372036854775807L, new zzahg((float) i, i3));
                        }
                    }
                }
                zzbd = zzbd.zzd(zzbd2);
            } else if (zzg2 == -1451722374) {
                zzbd = zzbd.zzd(zzk(zzed));
            }
            zzed.zzL(zzg);
        }
        return zzbd;
    }

    public static zzfb zzd(zzed zzed) {
        long j;
        long j2;
        zzed.zzL(8);
        if (zza(zzed.zzg()) == 0) {
            j2 = zzed.zzu();
            j = zzed.zzu();
        } else {
            j2 = zzed.zzt();
            j = zzed.zzt();
        }
        return new zzfb(j2, j, zzed.zzu());
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x026a A[LOOP:7: B:100:0x026a->B:104:0x0275, LOOP_START, PHI: r16 
      PHI: (r16v13 int) = (r16v11 int), (r16v14 int) binds: [B:99:0x0268, B:104:0x0275] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzajh zze(com.google.android.gms.internal.ads.zzaje r40, com.google.android.gms.internal.ads.zzes r41, com.google.android.gms.internal.ads.zzadf r42) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r1 = r40
            r0 = r41
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzet r3 = r0.zzb(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0016
            com.google.android.gms.internal.ads.zzad r5 = r1.zzf
            com.google.android.gms.internal.ads.zzaij r6 = new com.google.android.gms.internal.ads.zzaij
            r6.<init>(r3, r5)
            goto L_0x0024
        L_0x0016:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzet r3 = r0.zzb(r3)
            if (r3 == 0) goto L_0x059b
            com.google.android.gms.internal.ads.zzaik r6 = new com.google.android.gms.internal.ads.zzaik
            r6.<init>(r3)
        L_0x0024:
            int r3 = r6.zzb()
            r5 = 0
            if (r3 != 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzajh r0 = new com.google.android.gms.internal.ads.zzajh
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            long[] r4 = new long[r5]
            int[] r6 = new int[r5]
            r7 = 0
            r5 = r4
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x003d:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzet r7 = r0.zzb(r7)
            if (r7 != 0) goto L_0x0055
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzet r7 = r0.zzb(r7)
            r7.getClass()
            r9 = r7
            com.google.android.gms.internal.ads.zzet r9 = (com.google.android.gms.internal.ads.zzet) r9
            r9 = 1
            goto L_0x0056
        L_0x0055:
            r9 = r5
        L_0x0056:
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzet r10 = r0.zzb(r10)
            r10.getClass()
            r11 = r10
            com.google.android.gms.internal.ads.zzet r11 = (com.google.android.gms.internal.ads.zzet) r11
            com.google.android.gms.internal.ads.zzed r10 = r10.zza
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzet r11 = r0.zzb(r11)
            r11.getClass()
            r12 = r11
            com.google.android.gms.internal.ads.zzet r12 = (com.google.android.gms.internal.ads.zzet) r12
            com.google.android.gms.internal.ads.zzed r11 = r11.zza
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzet r12 = r0.zzb(r12)
            if (r12 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzed r12 = r12.zza
            goto L_0x0081
        L_0x0080:
            r12 = r4
        L_0x0081:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzet r0 = r0.zzb(r13)
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzed r0 = r0.zza
            goto L_0x008e
        L_0x008d:
            r0 = r4
        L_0x008e:
            com.google.android.gms.internal.ads.zzed r7 = r7.zza
            com.google.android.gms.internal.ads.zzaid r13 = new com.google.android.gms.internal.ads.zzaid
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.zzL(r7)
            int r9 = r11.zzp()
            r10 = -1
            int r9 = r9 + r10
            int r14 = r11.zzp()
            int r15 = r11.zzp()
            if (r0 == 0) goto L_0x00b2
            r0.zzL(r7)
            int r16 = r0.zzp()
            goto L_0x00b4
        L_0x00b2:
            r16 = r5
        L_0x00b4:
            if (r12 == 0) goto L_0x00cb
            r12.zzL(r7)
            int r7 = r12.zzp()
            if (r7 <= 0) goto L_0x00c7
            int r4 = r12.zzp()
            int r4 = r4 + r10
            r17 = r5
            goto L_0x00cf
        L_0x00c7:
            r12 = r4
            r17 = r5
            goto L_0x00ce
        L_0x00cb:
            r7 = r5
            r17 = r7
        L_0x00ce:
            r4 = r10
        L_0x00cf:
            int r5 = r6.zza()
            r18 = 1
            com.google.android.gms.internal.ads.zzad r8 = r1.zzf
            java.lang.String r8 = r8.zzo
            r19 = r6
            r41 = r7
            r20 = r10
            if (r5 == r10) goto L_0x0191
            java.lang.String r10 = "audio/raw"
            boolean r10 = r10.equals(r8)
            if (r10 != 0) goto L_0x00f9
            java.lang.String r10 = "audio/g711-mlaw"
            boolean r10 = r10.equals(r8)
            if (r10 != 0) goto L_0x00f9
            java.lang.String r10 = "audio/g711-alaw"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x0191
        L_0x00f9:
            if (r9 != 0) goto L_0x0191
            if (r16 != 0) goto L_0x018c
            if (r41 != 0) goto L_0x018c
            int r0 = r13.zza
            long[] r4 = new long[r0]
            int[] r8 = new int[r0]
        L_0x0105:
            boolean r9 = r13.zza()
            if (r9 == 0) goto L_0x0116
            int r9 = r13.zzb
            long r10 = r13.zzd
            r4[r9] = r10
            int r10 = r13.zzc
            r8[r9] = r10
            goto L_0x0105
        L_0x0116:
            long r9 = (long) r15
            r11 = 8192(0x2000, float:1.14794E-41)
            int r11 = r11 / r5
            r12 = r17
            r13 = r12
        L_0x011d:
            if (r12 >= r0) goto L_0x012b
            r14 = r8[r12]
            int r15 = com.google.android.gms.internal.ads.zzen.zza
            int r14 = r14 + r11
            int r14 = r14 + -1
            int r14 = r14 / r11
            int r13 = r13 + r14
            int r12 = r12 + 1
            goto L_0x011d
        L_0x012b:
            long[] r12 = new long[r13]
            int[] r14 = new int[r13]
            long[] r15 = new long[r13]
            int[] r13 = new int[r13]
            r6 = r17
            r7 = r6
            r16 = r7
            r19 = r16
            r21 = 0
        L_0x013c:
            if (r6 >= r0) goto L_0x0187
            r20 = r8[r6]
            r23 = r4[r6]
            r25 = r19
            r19 = r0
            r0 = r16
            r16 = r25
            r24 = r23
            r23 = r4
            r4 = r20
        L_0x0150:
            if (r4 <= 0) goto L_0x0178
            int r20 = java.lang.Math.min(r11, r4)
            r12[r16] = r24
            r41 = r4
            int r4 = r5 * r20
            r14[r16] = r4
            int r0 = java.lang.Math.max(r0, r4)
            r26 = r5
            long r4 = (long) r7
            long r4 = r4 * r9
            r15[r16] = r4
            r13[r16] = r18
            r4 = r14[r16]
            long r4 = (long) r4
            long r24 = r24 + r4
            int r7 = r7 + r20
            int r4 = r41 - r20
            int r16 = r16 + 1
            r5 = r26
            goto L_0x0150
        L_0x0178:
            r26 = r5
            int r6 = r6 + 1
            r4 = r16
            r16 = r0
            r0 = r19
            r19 = r4
            r4 = r23
            goto L_0x013c
        L_0x0187:
            long r4 = (long) r7
            long r9 = r9 * r4
            r4 = r9
            goto L_0x0316
        L_0x018c:
            r21 = 0
            r9 = r17
            goto L_0x0193
        L_0x0191:
            r21 = 0
        L_0x0193:
            long[] r5 = new long[r3]
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            int[] r8 = new int[r3]
            r25 = r41
            r41 = r0
            r24 = r9
            r31 = r11
            r0 = r17
            r9 = r0
            r10 = r9
            r23 = r10
            r26 = r23
            r27 = r21
            r29 = r27
        L_0x01af:
            java.lang.String r11 = "BoxParsers"
            if (r10 >= r3) goto L_0x0260
            r32 = r27
            r27 = r18
        L_0x01b7:
            if (r23 != 0) goto L_0x01cf
            boolean r27 = r13.zza()
            if (r27 == 0) goto L_0x01cc
            r28 = r3
            long r2 = r13.zzd
            r32 = r2
            int r2 = r13.zzc
            r23 = r2
            r3 = r28
            goto L_0x01b7
        L_0x01cc:
            r2 = r17
            goto L_0x01d1
        L_0x01cf:
            r2 = r23
        L_0x01d1:
            r28 = r3
            if (r27 != 0) goto L_0x01f1
            java.lang.String r2 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r2)
            long[] r2 = java.util.Arrays.copyOf(r5, r10)
            int[] r3 = java.util.Arrays.copyOf(r6, r10)
            long[] r4 = java.util.Arrays.copyOf(r7, r10)
            int[] r5 = java.util.Arrays.copyOf(r8, r10)
            r12 = r2
            r6 = r3
            r15 = r4
            r13 = r5
            r3 = r10
            goto L_0x0265
        L_0x01f1:
            if (r41 != 0) goto L_0x01f4
            goto L_0x0207
        L_0x01f4:
            if (r26 != 0) goto L_0x0205
            if (r16 <= 0) goto L_0x0203
            int r16 = r16 + -1
            int r26 = r41.zzp()
            int r0 = r41.zzg()
            goto L_0x01f4
        L_0x0203:
            r26 = r17
        L_0x0205:
            int r26 = r26 + -1
        L_0x0207:
            r5[r10] = r32
            int r3 = r19.zzc()
            r6[r10] = r3
            if (r3 <= r9) goto L_0x0212
            r9 = r3
        L_0x0212:
            r23 = r2
            long r2 = (long) r0
            long r2 = r29 + r2
            r7[r10] = r2
            if (r12 != 0) goto L_0x021e
            r2 = r18
            goto L_0x0220
        L_0x021e:
            r2 = r17
        L_0x0220:
            r8[r10] = r2
            if (r10 != r4) goto L_0x0237
            r8[r10] = r18
            int r25 = r25 + -1
            if (r25 <= 0) goto L_0x0237
            r12.getClass()
            r2 = r12
            com.google.android.gms.internal.ads.zzed r2 = (com.google.android.gms.internal.ads.zzed) r2
            int r2 = r12.zzp()
            int r2 = r2 + -1
            r4 = r2
        L_0x0237:
            long r2 = (long) r15
            long r29 = r29 + r2
            int r14 = r14 + -1
            if (r14 != 0) goto L_0x024f
            if (r24 <= 0) goto L_0x024d
            int r2 = r31.zzp()
            int r3 = r31.zzg()
            int r24 = r24 + -1
            r14 = r2
            r15 = r3
            goto L_0x024f
        L_0x024d:
            r14 = r17
        L_0x024f:
            r2 = r6[r10]
            long r2 = (long) r2
            long r2 = r32 + r2
            int r23 = r23 + -1
            int r10 = r10 + 1
            r38 = r2
            r3 = r28
            r27 = r38
            goto L_0x01af
        L_0x0260:
            r28 = r3
            r12 = r5
            r15 = r7
            r13 = r8
        L_0x0265:
            long r4 = (long) r0
            long r4 = r29 + r4
            if (r41 == 0) goto L_0x027b
        L_0x026a:
            if (r16 <= 0) goto L_0x027b
            int r0 = r41.zzp()
            if (r0 == 0) goto L_0x0275
            r0 = r17
            goto L_0x027d
        L_0x0275:
            r41.zzg()
            int r16 = r16 + -1
            goto L_0x026a
        L_0x027b:
            r0 = r18
        L_0x027d:
            if (r25 != 0) goto L_0x02bb
            if (r14 != 0) goto L_0x02b1
            if (r23 != 0) goto L_0x02aa
            if (r24 != 0) goto L_0x02a2
            if (r26 != 0) goto L_0x0299
            if (r0 != 0) goto L_0x0293
            r41 = r3
            r0 = r17
            r2 = r0
            r7 = r2
            r8 = r7
            r10 = r8
            r14 = r10
            goto L_0x02c6
        L_0x0293:
            r41 = r3
            r19 = r4
            goto L_0x030f
        L_0x0299:
            r10 = r0
            r41 = r3
            r0 = r17
            r2 = r0
            r7 = r2
            r14 = r7
            goto L_0x02c4
        L_0x02a2:
            r10 = r0
            r41 = r3
            r0 = r17
            r2 = r0
            r14 = r2
            goto L_0x02b8
        L_0x02aa:
            r10 = r0
            r41 = r3
            r0 = r17
            r14 = r0
            goto L_0x02b6
        L_0x02b1:
            r10 = r0
            r41 = r3
            r0 = r17
        L_0x02b6:
            r2 = r23
        L_0x02b8:
            r7 = r24
            goto L_0x02c4
        L_0x02bb:
            r10 = r0
            r41 = r3
            r2 = r23
            r7 = r24
            r0 = r25
        L_0x02c4:
            r8 = r26
        L_0x02c6:
            int r3 = r1.zza
            r19 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Inconsistent stbl box for track "
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = ": remainingSynchronizationSamples "
            r4.append(r3)
            r4.append(r0)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r4.append(r0)
            r4.append(r14)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r4.append(r0)
            r4.append(r7)
            java.lang.String r0 = ", remainingSamplesAtTimestampOffset "
            r4.append(r0)
            r4.append(r8)
            r0 = r18
            if (r0 == r10) goto L_0x0303
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0305
        L_0x0303:
            java.lang.String r0 = ""
        L_0x0305:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r0)
        L_0x030f:
            r3 = r41
            r14 = r6
            r16 = r9
            r4 = r19
        L_0x0316:
            r2 = r12
            long r8 = r1.zzc
            java.math.RoundingMode r10 = java.math.RoundingMode.FLOOR
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r4, r6, r8, r10)
            long[] r0 = r1.zzh
            r9 = 1000000(0xf4240, double:4.940656E-318)
            if (r0 != 0) goto L_0x0339
            long r3 = r1.zzc
            com.google.android.gms.internal.ads.zzen.zzF(r15, r9, r3)
            com.google.android.gms.internal.ads.zzajh r0 = new com.google.android.gms.internal.ads.zzajh
            r6 = r13
            r3 = r14
            r5 = r15
            r4 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0339:
            r7 = r3
            r19 = r4
            r6 = r13
            r3 = r14
            r5 = r15
            r4 = r16
            int r8 = r0.length
            r11 = 1
            if (r8 != r11) goto L_0x0402
            int r8 = r1.zzb
            if (r8 != r11) goto L_0x0402
            int r8 = r5.length
            r11 = 2
            if (r8 < r11) goto L_0x0402
            long[] r11 = r1.zzi
            r11.getClass()
            long[] r11 = (long[]) r11
            r11 = r11[r17]
            r23 = r0[r17]
            long r13 = r1.zzc
            long r9 = r1.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r27 = r9
            r25 = r13
            long r9 = com.google.android.gms.internal.ads.zzen.zzu(r23, r25, r27, r29)
            long r9 = r9 + r11
            int r0 = r8 + -1
            r13 = 4
            int r13 = java.lang.Math.min(r13, r0)
            r14 = r17
            int r13 = java.lang.Math.max(r14, r13)
            int r8 = r8 + -4
            int r0 = java.lang.Math.min(r8, r0)
            int r0 = java.lang.Math.max(r14, r0)
            r23 = r5[r14]
            int r8 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r8 > 0) goto L_0x0402
            r13 = r5[r13]
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 >= 0) goto L_0x0402
            r13 = r5[r0]
            int r0 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x0402
            int r0 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r0 > 0) goto L_0x0402
            long r25 = r11 - r23
            com.google.android.gms.internal.ads.zzad r0 = r1.zzf
            int r0 = r0.zzD
            long r11 = (long) r0
            long r13 = r1.zzc
            java.math.RoundingMode r31 = java.math.RoundingMode.FLOOR
            r27 = r11
            r29 = r13
            long r11 = com.google.android.gms.internal.ads.zzen.zzu(r25, r27, r29, r31)
            com.google.android.gms.internal.ads.zzad r0 = r1.zzf
            int r0 = r0.zzD
            long r13 = (long) r0
            r41 = r2
            r0 = r3
            long r2 = r1.zzc
            long r23 = r19 - r9
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r27 = r2
            r25 = r13
            long r2 = com.google.android.gms.internal.ads.zzen.zzu(r23, r25, r27, r29)
            int r8 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r8 != 0) goto L_0x03cc
            int r8 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r8 == 0) goto L_0x03c8
            r11 = r21
            goto L_0x03cc
        L_0x03c8:
            r2 = r41
            r3 = r0
            goto L_0x0402
        L_0x03cc:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x03c8
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x03d8
            goto L_0x03c8
        L_0x03d8:
            int r7 = (int) r11
            r8 = r42
            r8.zza = r7
            int r2 = (int) r2
            r8.zzb = r2
            long r2 = r1.zzc
            r7 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzen.zzF(r5, r7, r2)
            long[] r2 = r1.zzh
            r17 = 0
            r7 = r2[r17]
            long r11 = r1.zzd
            java.math.RoundingMode r13 = java.math.RoundingMode.FLOOR
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r7, r9, r11, r13)
            r3 = r0
            com.google.android.gms.internal.ads.zzajh r0 = new com.google.android.gms.internal.ads.zzajh
            r2 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0402:
            long[] r0 = r1.zzh
            int r8 = r0.length
            r11 = 1
            if (r8 != r11) goto L_0x0446
            r17 = 0
            r8 = r0[r17]
            int r0 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x0445
            long[] r0 = r1.zzi
            r0.getClass()
            long[] r0 = (long[]) r0
            r7 = r0[r17]
            r0 = 0
        L_0x041a:
            int r9 = r5.length
            if (r0 >= r9) goto L_0x0432
            r9 = r5[r0]
            long r11 = r9 - r7
            long r9 = r1.zzc
            java.math.RoundingMode r17 = java.math.RoundingMode.FLOOR
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r9
            long r9 = com.google.android.gms.internal.ads.zzen.zzu(r11, r13, r15, r17)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x041a
        L_0x0432:
            long r9 = r19 - r7
            long r13 = r1.zzc
            java.math.RoundingMode r15 = java.math.RoundingMode.FLOOR
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r9, r11, r13, r15)
            com.google.android.gms.internal.ads.zzajh r0 = new com.google.android.gms.internal.ads.zzajh
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0445:
            r8 = 1
        L_0x0446:
            int r0 = r1.zzb
            r11 = 1
            if (r0 != r11) goto L_0x044d
            r0 = 1
            goto L_0x044e
        L_0x044d:
            r0 = 0
        L_0x044e:
            long[] r9 = r1.zzi
            int[] r10 = new int[r8]
            int[] r8 = new int[r8]
            r9.getClass()
            long[] r9 = (long[]) r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x045d:
            long[] r15 = r1.zzh
            r41 = r4
            int r4 = r15.length
            if (r14 >= r4) goto L_0x04be
            r4 = r8
            r42 = r9
            r8 = r42[r14]
            r19 = -1
            int r16 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r16 == 0) goto L_0x04af
            r23 = r15[r14]
            r16 = r14
            long r14 = r1.zzc
            r25 = r14
            long r14 = r1.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r27 = r14
            long r14 = com.google.android.gms.internal.ads.zzen.zzu(r23, r25, r27, r29)
            r19 = r4
            r4 = 1
            int r18 = com.google.android.gms.internal.ads.zzen.zzd(r5, r8, r4, r4)
            r10[r16] = r18
            long r8 = r8 + r14
            r14 = 0
            int r8 = com.google.android.gms.internal.ads.zzen.zza(r5, r8, r0, r14)
            r19[r16] = r8
        L_0x0492:
            r8 = r10[r16]
            r9 = r19[r16]
            if (r8 >= r9) goto L_0x04a3
            r15 = r6[r8]
            r15 = r15 & r4
            if (r15 != 0) goto L_0x04a3
            int r8 = r8 + 1
            r10[r16] = r8
            r4 = 1
            goto L_0x0492
        L_0x04a3:
            int r4 = r9 - r8
            int r11 = r11 + r4
            if (r13 == r8) goto L_0x04aa
            r4 = 1
            goto L_0x04ab
        L_0x04aa:
            r4 = r14
        L_0x04ab:
            r4 = r4 | r12
            r12 = r4
            r13 = r9
            goto L_0x04b4
        L_0x04af:
            r19 = r4
            r16 = r14
            r14 = 0
        L_0x04b4:
            int r4 = r16 + 1
            r9 = r42
            r14 = r4
            r8 = r19
            r4 = r41
            goto L_0x045d
        L_0x04be:
            r19 = r8
            r14 = 0
            if (r11 == r7) goto L_0x04c5
            r0 = 1
            goto L_0x04c6
        L_0x04c5:
            r0 = r14
        L_0x04c6:
            r0 = r0 | r12
            if (r0 == 0) goto L_0x04cc
            long[] r4 = new long[r11]
            goto L_0x04cd
        L_0x04cc:
            r4 = r2
        L_0x04cd:
            if (r0 == 0) goto L_0x04d2
            int[] r7 = new int[r11]
            goto L_0x04d3
        L_0x04d2:
            r7 = r3
        L_0x04d3:
            r8 = 1
            if (r8 != r0) goto L_0x04d9
            r16 = r14
            goto L_0x04db
        L_0x04d9:
            r16 = r41
        L_0x04db:
            if (r0 == 0) goto L_0x04e0
            int[] r13 = new int[r11]
            goto L_0x04e1
        L_0x04e0:
            r13 = r6
        L_0x04e1:
            long[] r8 = new long[r11]
            r9 = r14
            r23 = r21
        L_0x04e6:
            long[] r11 = r1.zzh
            int r11 = r11.length
            if (r14 >= r11) goto L_0x057b
            long[] r11 = r1.zzi
            r11 = r11[r14]
            r15 = r10[r14]
            r41 = r0
            r0 = r19[r14]
            r17 = r5
            if (r41 == 0) goto L_0x0504
            int r5 = r0 - r15
            java.lang.System.arraycopy(r2, r15, r4, r9, r5)
            java.lang.System.arraycopy(r3, r15, r7, r9, r5)
            java.lang.System.arraycopy(r6, r15, r13, r9, r5)
        L_0x0504:
            r5 = r16
        L_0x0506:
            if (r15 >= r0) goto L_0x055c
            r20 = r2
            r30 = r3
            long r2 = r1.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = 1000000(0xf4240, double:4.940656E-318)
            r27 = r2
            long r2 = com.google.android.gms.internal.ads.zzen.zzu(r23, r25, r27, r29)
            r25 = r17[r15]
            long r31 = r25 - r11
            r25 = r2
            long r2 = r1.zzc
            java.math.RoundingMode r37 = java.math.RoundingMode.FLOOR
            r33 = 1000000(0xf4240, double:4.940656E-318)
            r35 = r2
            long r2 = com.google.android.gms.internal.ads.zzen.zzu(r31, r33, r35, r37)
            r42 = r0
            int r0 = r1.zzb
            r31 = r4
            r4 = 1
            if (r0 == r4) goto L_0x053d
            r0 = r5
            r4 = r21
            long r2 = java.lang.Math.max(r4, r2)
            goto L_0x0540
        L_0x053d:
            r0 = r5
            r4 = r21
        L_0x0540:
            long r2 = r25 + r2
            r8[r9] = r2
            if (r41 == 0) goto L_0x054c
            r2 = r7[r9]
            if (r2 <= r0) goto L_0x054c
            r0 = r30[r15]
        L_0x054c:
            int r9 = r9 + 1
            int r15 = r15 + 1
            r21 = r4
            r2 = r20
            r3 = r30
            r4 = r31
            r5 = r0
            r0 = r42
            goto L_0x0506
        L_0x055c:
            r20 = r2
            r30 = r3
            r31 = r4
            r0 = r5
            r4 = r21
            long[] r2 = r1.zzh
            r2 = r2[r14]
            long r23 = r23 + r2
            int r14 = r14 + 1
            r16 = r0
            r5 = r17
            r2 = r20
            r3 = r30
            r4 = r31
            r0 = r41
            goto L_0x04e6
        L_0x057b:
            r31 = r4
            long r2 = r1.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = 1000000(0xf4240, double:4.940656E-318)
            r27 = r2
            long r2 = com.google.android.gms.internal.ads.zzen.zzu(r23, r25, r27, r29)
            com.google.android.gms.internal.ads.zzajh r0 = new com.google.android.gms.internal.ads.zzajh
            r5 = r8
            r6 = r13
            r4 = r16
            r38 = r2
            r3 = r7
            r7 = r38
            r2 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x059b:
            java.lang.String r0 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zze(com.google.android.gms.internal.ads.zzaje, com.google.android.gms.internal.ads.zzes, com.google.android.gms.internal.ads.zzadf):com.google.android.gms.internal.ads.zzajh");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v72, resolved type: com.google.android.gms.internal.ads.zzfzo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v105, resolved type: com.google.android.gms.internal.ads.zzfzo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v56, resolved type: com.google.android.gms.internal.ads.zzfzo} */
    /* JADX WARNING: Code restructure failed: missing block: B:457:0x09a4, code lost:
        if (r8.zzd(1) > 0) goto L_0x09a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:468:0x09c5, code lost:
        if (r9 == 1) goto L_0x09c7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x05ed  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0609  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0628  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0634  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x063c  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x064e  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x08d0  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x08ea  */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x09d6  */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x0a07  */
    /* JADX WARNING: Removed duplicated region for block: B:572:0x0c22  */
    /* JADX WARNING: Removed duplicated region for block: B:573:0x0c24  */
    /* JADX WARNING: Removed duplicated region for block: B:622:0x0db0  */
    /* JADX WARNING: Removed duplicated region for block: B:623:0x0db4  */
    /* JADX WARNING: Removed duplicated region for block: B:626:0x0de7  */
    /* JADX WARNING: Removed duplicated region for block: B:627:0x0e1a  */
    /* JADX WARNING: Removed duplicated region for block: B:635:0x0e25 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzf(com.google.android.gms.internal.ads.zzes r68, com.google.android.gms.internal.ads.zzadf r69, long r70, com.google.android.gms.internal.ads.zzw r72, boolean r73, boolean r74, com.google.android.gms.internal.ads.zzfwh r75) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r0 = r68
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r13 = 0
        L_0x0008:
            java.util.List r1 = r0.zzc
            int r1 = r1.size()
            if (r13 >= r1) goto L_0x0e2d
            java.util.List r1 = r0.zzc
            java.lang.Object r1 = r1.get(r13)
            r14 = r1
            com.google.android.gms.internal.ads.zzes r14 = (com.google.android.gms.internal.ads.zzes) r14
            int r1 = r14.zzd
            r2 = 1953653099(0x7472616b, float:7.681346E31)
            if (r1 == r2) goto L_0x0029
            r3 = r69
            r0 = r75
            r2 = r11
            r32 = r13
            goto L_0x0e1e
        L_0x0029:
            r1 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzet r1 = r0.zzb(r1)
            r1.getClass()
            r2 = r1
            com.google.android.gms.internal.ads.zzet r2 = (com.google.android.gms.internal.ads.zzet) r2
            r2 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzes r2 = r14.zza(r2)
            r2.getClass()
            r3 = r2
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzet r3 = r2.zzb(r3)
            r3.getClass()
            r4 = r3
            com.google.android.gms.internal.ads.zzet r4 = (com.google.android.gms.internal.ads.zzet) r4
            com.google.android.gms.internal.ads.zzed r3 = r3.zza
            int r3 = zzi(r3)
            r4 = 1936684398(0x736f756e, float:1.8971874E31)
            r6 = -1
            if (r3 != r4) goto L_0x005e
            r3 = 1
            goto L_0x0084
        L_0x005e:
            r4 = 1986618469(0x76696465, float:1.1834389E33)
            if (r3 != r4) goto L_0x0065
            r3 = 2
            goto L_0x0084
        L_0x0065:
            r4 = 1952807028(0x74657874, float:7.272211E31)
            if (r3 == r4) goto L_0x0083
            r4 = 1935832172(0x7362746c, float:1.7941596E31)
            if (r3 == r4) goto L_0x0083
            r4 = 1937072756(0x73756274, float:1.944137E31)
            if (r3 == r4) goto L_0x0083
            r4 = 1668047728(0x636c6370, float:4.3605968E21)
            if (r3 != r4) goto L_0x007a
            goto L_0x0083
        L_0x007a:
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r3 != r4) goto L_0x0081
            r3 = 5
            goto L_0x0084
        L_0x0081:
            r3 = r6
            goto L_0x0084
        L_0x0083:
            r3 = 3
        L_0x0084:
            if (r3 != r6) goto L_0x0090
            r0 = r75
            r33 = r11
            r32 = r13
            r1 = r14
        L_0x008d:
            r4 = 0
            goto L_0x0ddf
        L_0x0090:
            r9 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzet r9 = r14.zzb(r9)
            r9.getClass()
            r10 = r9
            com.google.android.gms.internal.ads.zzet r10 = (com.google.android.gms.internal.ads.zzet) r10
            com.google.android.gms.internal.ads.zzed r9 = r9.zza
            r10 = 8
            r9.zzL(r10)
            int r16 = r9.zzg()
            int r16 = zza(r16)
            r17 = 5
            r15 = 16
            if (r16 != 0) goto L_0x00b4
            r4 = r10
            goto L_0x00b5
        L_0x00b4:
            r4 = r15
        L_0x00b5:
            r9.zzM(r4)
            int r4 = r9.zzg()
            r8 = 4
            r9.zzM(r8)
            int r20 = r9.zzd()
            r5 = 0
        L_0x00c5:
            if (r16 != 0) goto L_0x00c9
            r7 = r8
            goto L_0x00ca
        L_0x00c9:
            r7 = r10
        L_0x00ca:
            r23 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 >= r7) goto L_0x00f3
            byte[] r7 = r9.zzN()
            int r25 = r20 + r5
            byte r7 = r7[r25]
            if (r7 == r6) goto L_0x00f0
            if (r16 != 0) goto L_0x00e2
            long r25 = r9.zzu()
            goto L_0x00e6
        L_0x00e2:
            long r25 = r9.zzw()
        L_0x00e6:
            r27 = 0
            int r5 = (r25 > r27 ? 1 : (r25 == r27 ? 0 : -1))
            if (r5 != 0) goto L_0x00ed
            goto L_0x00f6
        L_0x00ed:
            r6 = r25
            goto L_0x00f8
        L_0x00f0:
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x00f3:
            r9.zzM(r7)
        L_0x00f6:
            r6 = r23
        L_0x00f8:
            r9.zzM(r15)
            int r16 = r9.zzg()
            int r5 = r9.zzg()
            r9.zzM(r8)
            int r8 = r9.zzg()
            int r9 = r9.zzg()
            r15 = 65536(0x10000, float:9.18355E-41)
            r12 = -65536(0xffffffffffff0000, float:NaN)
            if (r16 != 0) goto L_0x0121
            if (r5 != r15) goto L_0x011f
            if (r8 != r12) goto L_0x011e
            if (r9 != 0) goto L_0x011d
            r5 = 90
            goto L_0x0141
        L_0x011d:
            r8 = r12
        L_0x011e:
            r5 = r15
        L_0x011f:
            r16 = 0
        L_0x0121:
            if (r16 != 0) goto L_0x0132
            if (r5 != r12) goto L_0x012f
            if (r8 != r15) goto L_0x012c
            if (r9 != 0) goto L_0x012d
            r5 = 270(0x10e, float:3.78E-43)
            goto L_0x0141
        L_0x012c:
            r15 = r8
        L_0x012d:
            r5 = r12
            goto L_0x0130
        L_0x012f:
            r15 = r8
        L_0x0130:
            r8 = 0
            goto L_0x0135
        L_0x0132:
            r15 = r8
            r8 = r16
        L_0x0135:
            if (r8 != r12) goto L_0x0140
            if (r5 != 0) goto L_0x0140
            if (r15 != 0) goto L_0x0140
            if (r9 != r12) goto L_0x0140
            r5 = 180(0xb4, float:2.52E-43)
            goto L_0x0141
        L_0x0140:
            r5 = 0
        L_0x0141:
            com.google.android.gms.internal.ads.zzail r12 = new com.google.android.gms.internal.ads.zzail
            r12.<init>(r4, r6, r5)
            int r4 = (r70 > r23 ? 1 : (r70 == r23 ? 0 : -1))
            if (r4 != 0) goto L_0x0151
            long r4 = r12.zzb
            r32 = r4
            goto L_0x0153
        L_0x0151:
            r32 = r70
        L_0x0153:
            com.google.android.gms.internal.ads.zzed r1 = r1.zza
            com.google.android.gms.internal.ads.zzfb r1 = zzd(r1)
            long r4 = r1.zzc
            int r1 = (r32 > r23 ? 1 : (r32 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x0162
            r36 = r4
            goto L_0x016d
        L_0x0162:
            r34 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r38 = java.math.RoundingMode.FLOOR
            r36 = r4
            long r23 = com.google.android.gms.internal.ads.zzen.zzu(r32, r34, r36, r38)
        L_0x016d:
            r1 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzes r1 = r2.zza(r1)
            r1.getClass()
            r4 = r1
            com.google.android.gms.internal.ads.zzes r4 = (com.google.android.gms.internal.ads.zzes) r4
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzes r1 = r1.zza(r4)
            r1.getClass()
            r4 = r1
            com.google.android.gms.internal.ads.zzes r4 = (com.google.android.gms.internal.ads.zzes) r4
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzet r2 = r2.zzb(r4)
            r2.getClass()
            r4 = r2
            com.google.android.gms.internal.ads.zzet r4 = (com.google.android.gms.internal.ads.zzet) r4
            com.google.android.gms.internal.ads.zzed r2 = r2.zza
            r2.zzL(r10)
            int r4 = r2.zzg()
            int r4 = zza(r4)
            if (r4 != 0) goto L_0x01a5
            r5 = r10
            goto L_0x01a7
        L_0x01a5:
            r5 = 16
        L_0x01a7:
            r2.zzM(r5)
            if (r4 != 0) goto L_0x01ae
            r4 = 4
            goto L_0x01af
        L_0x01ae:
            r4 = r10
        L_0x01af:
            long r5 = r2.zzu()
            r2.zzM(r4)
            int r2 = r2.zzq()
            int r4 = r2 >> 10
            int r7 = r2 >> 5
            r2 = r2 & 31
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r4 = r4 & 31
            int r4 = r4 + 96
            char r4 = (char) r4
            r8.append(r4)
            r4 = r7 & 31
            int r4 = r4 + 96
            char r4 = (char) r4
            r8.append(r4)
            int r2 = r2 + 96
            char r2 = (char) r2
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            android.util.Pair r15 = android.util.Pair.create(r4, r2)
            r2 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzet r1 = r1.zzb(r2)
            if (r1 == 0) goto L_0x0e25
            int r5 = r12.zza
            int r2 = r12.zzc
            java.lang.Object r4 = r15.second
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.gms.internal.ads.zzed r1 = r1.zza
            r4 = 12
            r1.zzL(r4)
            int r7 = r1.zzg()
            com.google.android.gms.internal.ads.zzaii r9 = new com.google.android.gms.internal.ads.zzaii
            r9.<init>(r7)
            r8 = r10
            r10 = 0
        L_0x020f:
            if (r10 >= r7) goto L_0x0d23
            r16 = r3
            int r3 = r1.zzd()
            r27 = r4
            int r4 = r1.zzg()
            if (r4 <= 0) goto L_0x0221
            r8 = 1
            goto L_0x0222
        L_0x0221:
            r8 = 0
        L_0x0222:
            java.lang.String r0 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r0)
            r8 = r2
            int r2 = r1.zzg()
            r29 = r3
            r3 = 1635148593(0x61766331, float:2.840654E20)
            if (r2 == r3) goto L_0x0421
            r3 = 1635148595(0x61766333, float:2.8406544E20)
            if (r2 == r3) goto L_0x0421
            r3 = 1701733238(0x656e6376, float:7.035987E22)
            if (r2 == r3) goto L_0x0421
            r3 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r2 == r3) goto L_0x0421
            r3 = 1836070006(0x6d703476, float:4.646239E27)
            if (r2 == r3) goto L_0x0421
            r3 = 1752589105(0x68766331, float:4.6541277E24)
            if (r2 == r3) goto L_0x0421
            r3 = 1751479857(0x68657631, float:4.3344087E24)
            if (r2 == r3) goto L_0x0421
            r3 = 1932670515(0x73323633, float:1.4119387E31)
            if (r2 == r3) goto L_0x0421
            r3 = 1211250227(0x48323633, float:182488.8)
            if (r2 == r3) goto L_0x0421
            r3 = 1987063864(0x76703038, float:1.21789965E33)
            if (r2 == r3) goto L_0x0421
            r3 = 1987063865(0x76703039, float:1.2178997E33)
            if (r2 == r3) goto L_0x0421
            r3 = 1635135537(0x61763031, float:2.8383572E20)
            if (r2 == r3) goto L_0x0421
            r3 = 1685479798(0x64766176, float:1.8179687E22)
            if (r2 == r3) goto L_0x0421
            r3 = 1685479729(0x64766131, float:1.817961E22)
            if (r2 == r3) goto L_0x0421
            r3 = 1685481573(0x64766865, float:1.8181686E22)
            if (r2 == r3) goto L_0x0421
            r3 = 1685481521(0x64766831, float:1.8181627E22)
            if (r2 != r3) goto L_0x0280
            goto L_0x0421
        L_0x0280:
            r0 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r2 == r0) goto L_0x03ef
            r0 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r2 == r0) goto L_0x03ef
            r0 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r2 == r0) goto L_0x03ef
            r0 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r2 == r0) goto L_0x03ef
            r0 = 1685353315(0x64747363, float:1.803728E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1685353317(0x64747365, float:1.8037282E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1685353320(0x64747368, float:1.8037286E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1685353324(0x6474736c, float:1.803729E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1685353336(0x64747378, float:1.8037304E22)
            if (r2 == r0) goto L_0x03ef
            r0 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r2 == r0) goto L_0x03ef
            r0 = 1935767394(0x73617762, float:1.7863284E31)
            if (r2 == r0) goto L_0x03ef
            r0 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r2 == r0) goto L_0x03ef
            r0 = 1936684916(0x736f7774, float:1.89725E31)
            if (r2 == r0) goto L_0x03ef
            r0 = 1953984371(0x74776f73, float:7.841539E31)
            if (r2 == r0) goto L_0x03ef
            r0 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r2 == r0) goto L_0x03ef
            r0 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r2 == r0) goto L_0x03ef
            r0 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r2 == r0) goto L_0x03ef
            r0 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r2 == r0) goto L_0x03ef
            r0 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r2 == r0) goto L_0x03ef
            r0 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r2 == r0) goto L_0x03ef
            r0 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r2 == r0) goto L_0x03ef
            r0 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r2 == r0) goto L_0x03ef
            r0 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r2 == r0) goto L_0x03ef
            r0 = 1767992678(0x69616d66, float:1.7032808E25)
            if (r2 != r0) goto L_0x0304
            goto L_0x03ef
        L_0x0304:
            r0 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r2 == r0) goto L_0x0372
            r0 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 == r0) goto L_0x0372
            r0 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 == r0) goto L_0x0372
            r0 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 == r0) goto L_0x0372
            r0 = 1664495672(0x63363038, float:3.360782E21)
            if (r2 != r0) goto L_0x031e
            goto L_0x0372
        L_0x031e:
            r0 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r2 != r0) goto L_0x0344
            int r3 = r29 + 16
            r1.zzL(r3)
            r0 = 0
            r1.zzy(r0)
            java.lang.String r2 = r1.zzy(r0)
            if (r2 == 0) goto L_0x035c
            com.google.android.gms.internal.ads.zzab r0 = new com.google.android.gms.internal.ads.zzab
            r0.<init>()
            r0.zzK(r5)
            r0.zzZ(r2)
            com.google.android.gms.internal.ads.zzad r0 = r0.zzaf()
            r9.zzb = r0
            goto L_0x035c
        L_0x0344:
            r0 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r2 != r0) goto L_0x035c
            com.google.android.gms.internal.ads.zzab r0 = new com.google.android.gms.internal.ads.zzab
            r0.<init>()
            r0.zzK(r5)
            java.lang.String r2 = "application/x-camera-motion"
            r0.zzZ(r2)
            com.google.android.gms.internal.ads.zzad r0 = r0.zzaf()
            r9.zzb = r0
        L_0x035c:
            r52 = r4
            r22 = r6
            r19 = r7
            r27 = r10
            r33 = r11
            r25 = r12
            r32 = r13
            r35 = r14
            r34 = r15
            r3 = 3
            r11 = -1
            goto L_0x0d03
        L_0x0372:
            int r3 = r29 + 16
            r1.zzL(r3)
            r0 = 1414810956(0x54544d4c, float:3.64731957E12)
            r32 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != r0) goto L_0x038c
            java.lang.String r0 = "application/ttml+xml"
        L_0x0383:
            r2 = r0
        L_0x0384:
            r19 = r1
            r0 = r32
            r3 = 0
        L_0x0389:
            r32 = r4
            goto L_0x03bd
        L_0x038c:
            r0 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 != r0) goto L_0x03a5
            int r0 = r4 + -16
            byte[] r2 = new byte[r0]
            r3 = 0
            r1.zzH(r2, r3, r0)
            com.google.android.gms.internal.ads.zzfzo r0 = com.google.android.gms.internal.ads.zzfzo.zzo(r2)
            java.lang.String r2 = "application/x-quicktime-tx3g"
            r3 = r0
            r19 = r1
            r0 = r32
            goto L_0x0389
        L_0x03a5:
            r0 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 != r0) goto L_0x03ad
            java.lang.String r0 = "application/x-mp4-vtt"
            goto L_0x0383
        L_0x03ad:
            r0 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 != r0) goto L_0x03b7
            r32 = 0
            java.lang.String r0 = "application/ttml+xml"
            goto L_0x0383
        L_0x03b7:
            r0 = 1
            r9.zzd = r0
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x0384
        L_0x03bd:
            com.google.android.gms.internal.ads.zzab r4 = new com.google.android.gms.internal.ads.zzab
            r4.<init>()
            r4.zzK(r5)
            r4.zzZ(r2)
            r4.zzP(r6)
            r4.zzad(r0)
            r4.zzM(r3)
            com.google.android.gms.internal.ads.zzad r0 = r4.zzaf()
            r9.zzb = r0
            r22 = r6
            r27 = r10
            r33 = r11
            r25 = r12
            r35 = r14
            r34 = r15
            r1 = r19
            r52 = r32
            r3 = 3
            r11 = -1
            r19 = r7
            r32 = r13
            goto L_0x0d03
        L_0x03ef:
            r19 = r7
            r0 = r8
            r25 = r12
            r3 = r29
            r12 = 4
            r18 = 0
            r20 = -1
            r21 = 3
            r22 = 2
            r28 = 8
            r30 = 1
            r8 = r72
            r7 = r74
            zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r8 = r0
            r29 = r3
            r52 = r4
            r22 = r6
            r27 = r10
            r33 = r11
            r32 = r13
            r35 = r14
            r34 = r15
            r11 = r20
            r3 = r21
            goto L_0x0d03
        L_0x0421:
            r19 = r7
            r7 = r8
            r25 = r12
            r3 = r29
            r12 = 0
            r8 = r72
            int r12 = r3 + 16
            r1.zzL(r12)
            r12 = 16
            r1.zzM(r12)
            int r12 = r1.zzq()
            r22 = r6
            int r6 = r1.zzq()
            r27 = r10
            r10 = 50
            r1.zzM(r10)
            int r10 = r1.zzd()
            r32 = r13
            r13 = 1701733238(0x656e6376, float:7.035987E22)
            if (r2 != r13) goto L_0x048c
            android.util.Pair r2 = zzj(r1, r3, r4)
            if (r2 == 0) goto L_0x047e
            java.lang.Object r13 = r2.first
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r8 != 0) goto L_0x0466
            r29 = r3
            r28 = 0
            goto L_0x0474
        L_0x0466:
            r29 = r3
            java.lang.Object r3 = r2.second
            com.google.android.gms.internal.ads.zzajf r3 = (com.google.android.gms.internal.ads.zzajf) r3
            java.lang.String r3 = r3.zzb
            com.google.android.gms.internal.ads.zzw r3 = r8.zzb(r3)
            r28 = r3
        L_0x0474:
            com.google.android.gms.internal.ads.zzajf[] r3 = r9.zza
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzajf r2 = (com.google.android.gms.internal.ads.zzajf) r2
            r3[r27] = r2
            r2 = r13
            goto L_0x0485
        L_0x047e:
            r29 = r3
            r2 = 1701733238(0x656e6376, float:7.035987E22)
            r28 = r8
        L_0x0485:
            r1.zzL(r10)
            r3 = r2
            r2 = r28
            goto L_0x0490
        L_0x048c:
            r29 = r3
            r3 = r2
            r2 = r8
        L_0x0490:
            r13 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r3 != r13) goto L_0x0498
            java.lang.String r13 = "video/mpeg"
            goto L_0x04a9
        L_0x0498:
            r13 = 1211250227(0x48323633, float:182488.8)
            if (r3 != r13) goto L_0x04a8
            java.lang.String r3 = "video/3gpp"
            r13 = 1211250227(0x48323633, float:182488.8)
            r67 = r13
            r13 = r3
            r3 = r67
            goto L_0x04a9
        L_0x04a8:
            r13 = 0
        L_0x04a9:
            r28 = 1065353216(0x3f800000, float:1.0)
            r38 = r2
            r51 = r5
            r47 = r6
            r46 = r7
            r7 = r10
            r33 = r11
            r48 = r12
            r8 = r13
            r35 = r14
            r34 = r15
            r50 = r28
            r2 = -1
            r6 = 8
            r10 = -1
            r11 = 0
            r12 = 8
            r13 = 0
            r14 = -1
            r15 = -1
            r28 = 0
            r30 = 0
            r43 = -1
            r44 = 0
            r45 = 0
            r49 = 0
        L_0x04d5:
            int r5 = r7 - r29
            if (r5 >= r4) goto L_0x0c62
            r1.zzL(r7)
            int r5 = r1.zzd()
            int r52 = r1.zzg()
            if (r52 != 0) goto L_0x04f4
            int r52 = r1.zzd()
            r53 = r7
            int r7 = r52 - r29
            if (r7 != r4) goto L_0x04f2
            goto L_0x0c62
        L_0x04f2:
            r7 = 0
            goto L_0x04f8
        L_0x04f4:
            r53 = r7
            r7 = r52
        L_0x04f8:
            if (r7 <= 0) goto L_0x04fe
            r52 = r4
            r4 = 1
            goto L_0x0501
        L_0x04fe:
            r52 = r4
            r4 = 0
        L_0x0501:
            com.google.android.gms.internal.ads.zzacv.zzb(r4, r0)
            int r4 = r1.zzg()
            r54 = r5
            r5 = 1635148611(0x61766343, float:2.8406573E20)
            if (r4 != r5) goto L_0x055a
            int r5 = r54 + 8
            if (r8 != 0) goto L_0x0515
            r8 = 1
            goto L_0x0516
        L_0x0515:
            r8 = 0
        L_0x0516:
            r12 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r12)
            r1.zzL(r5)
            com.google.android.gms.internal.ads.zzabv r2 = com.google.android.gms.internal.ads.zzabv.zza(r1)
            java.util.List r4 = r2.zza
            int r5 = r2.zzb
            r9.zzc = r5
            if (r45 != 0) goto L_0x052f
            float r5 = r2.zzk
            r50 = r5
            r8 = 0
            goto L_0x0530
        L_0x052f:
            r8 = 1
        L_0x0530:
            java.lang.String r5 = r2.zzl
            int r6 = r2.zzj
            int r10 = r2.zzg
            int r12 = r2.zzh
            int r13 = r2.zzi
            int r14 = r2.zze
            int r2 = r2.zzf
            java.lang.String r43 = "video/avc"
            r58 = r0
            r56 = r3
            r49 = r5
            r45 = r8
            r55 = r9
            r59 = r11
            r8 = r43
            r3 = 3
            r11 = -1
            r43 = r6
            r6 = r14
            r14 = r12
            r12 = r2
            r2 = r10
        L_0x0556:
            r10 = r13
        L_0x0557:
            r13 = r4
            goto L_0x0c54
        L_0x055a:
            r5 = 1752589123(0x68766343, float:4.6541328E24)
            if (r4 != r5) goto L_0x05b1
            int r5 = r54 + 8
            if (r8 != 0) goto L_0x0565
            r8 = 1
            goto L_0x0566
        L_0x0565:
            r8 = 0
        L_0x0566:
            r12 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r12)
            r1.zzL(r5)
            com.google.android.gms.internal.ads.zzadg r2 = com.google.android.gms.internal.ads.zzadg.zza(r1)
            java.util.List r4 = r2.zza
            int r5 = r2.zzb
            r9.zzc = r5
            if (r45 != 0) goto L_0x057f
            float r5 = r2.zzi
            r50 = r5
            r8 = 0
            goto L_0x0580
        L_0x057f:
            r8 = 1
        L_0x0580:
            int r5 = r2.zzj
            java.lang.String r6 = r2.zzk
            int r10 = r2.zzh
            r11 = -1
            if (r10 == r11) goto L_0x058a
            goto L_0x058b
        L_0x058a:
            r10 = r15
        L_0x058b:
            int r11 = r2.zze
            int r12 = r2.zzf
            int r13 = r2.zzg
            int r14 = r2.zzc
            int r15 = r2.zzd
            com.google.android.gms.internal.ads.zzfm r2 = r2.zzl
            java.lang.String r43 = "video/hevc"
            r58 = r0
            r59 = r2
            r56 = r3
            r49 = r6
            r45 = r8
            r55 = r9
            r2 = r11
            r6 = r14
            r8 = r43
            r3 = 3
            r11 = -1
            r43 = r5
            r14 = r12
            r12 = r15
            r15 = r10
            goto L_0x0556
        L_0x05b1:
            r5 = 1818785347(0x6c687643, float:1.12411706E27)
            if (r4 != r5) goto L_0x0664
            int r5 = r54 + 8
            java.lang.String r4 = "video/hevc"
            boolean r4 = r4.equals(r8)
            java.lang.String r8 = "lhvC must follow hvcC atom"
            com.google.android.gms.internal.ads.zzacv.zzb(r4, r8)
            if (r11 == 0) goto L_0x05d3
            com.google.android.gms.internal.ads.zzfzo r4 = r11.zza
            int r4 = r4.size()
            r8 = 2
            if (r4 < r8) goto L_0x05d1
            r4 = r11
            r11 = 1
            goto L_0x05d5
        L_0x05d1:
            r4 = r11
            goto L_0x05d4
        L_0x05d3:
            r4 = 0
        L_0x05d4:
            r11 = 0
        L_0x05d5:
            java.lang.String r8 = "must have at least two layers"
            com.google.android.gms.internal.ads.zzacv.zzb(r11, r8)
            r1.zzL(r5)
            r4.getClass()
            r5 = r4
            com.google.android.gms.internal.ads.zzfm r5 = (com.google.android.gms.internal.ads.zzfm) r5
            com.google.android.gms.internal.ads.zzadg r5 = com.google.android.gms.internal.ads.zzadg.zzb(r1, r4)
            int r8 = r9.zzc
            int r11 = r5.zzb
            if (r8 != r11) goto L_0x05ef
            r8 = 1
            goto L_0x05f0
        L_0x05ef:
            r8 = 0
        L_0x05f0:
            java.lang.String r11 = "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
            int r8 = r5.zze
            r11 = -1
            if (r8 == r11) goto L_0x0604
            if (r2 != r8) goto L_0x05fe
            r8 = 1
            goto L_0x05ff
        L_0x05fe:
            r8 = 0
        L_0x05ff:
            java.lang.String r11 = "colorSpace must be the same for both views"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
        L_0x0604:
            int r8 = r5.zzf
            r11 = -1
            if (r8 == r11) goto L_0x0613
            if (r14 != r8) goto L_0x060d
            r8 = 1
            goto L_0x060e
        L_0x060d:
            r8 = 0
        L_0x060e:
            java.lang.String r11 = "colorRange must be the same for both views"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
        L_0x0613:
            int r8 = r5.zzg
            r11 = -1
            if (r8 == r11) goto L_0x0622
            if (r10 != r8) goto L_0x061c
            r8 = 1
            goto L_0x061d
        L_0x061c:
            r8 = 0
        L_0x061d:
            java.lang.String r11 = "colorTransfer must be the same for both views"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
        L_0x0622:
            int r8 = r5.zzc
            if (r6 != r8) goto L_0x0628
            r8 = 1
            goto L_0x0629
        L_0x0628:
            r8 = 0
        L_0x0629:
            java.lang.String r11 = "bitdepthLuma must be the same for both views"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
            int r8 = r5.zzd
            if (r12 != r8) goto L_0x0634
            r8 = 1
            goto L_0x0635
        L_0x0634:
            r8 = 0
        L_0x0635:
            java.lang.String r11 = "bitdepthChroma must be the same for both views"
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r11)
            if (r13 == 0) goto L_0x064e
            com.google.android.gms.internal.ads.zzfzl r8 = new com.google.android.gms.internal.ads.zzfzl
            r8.<init>()
            r8.zzh(r13)
            java.util.List r11 = r5.zza
            r8.zzh(r11)
            com.google.android.gms.internal.ads.zzfzo r13 = r8.zzi()
            goto L_0x0654
        L_0x064e:
            java.lang.String r8 = "initializationData must be already set from hvcC atom"
            r11 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r11, r8)
        L_0x0654:
            java.lang.String r5 = r5.zzk
            java.lang.String r8 = "video/mv-hevc"
            r58 = r0
            r56 = r3
            r59 = r4
            r49 = r5
            r55 = r9
            goto L_0x0ad7
        L_0x0664:
            r5 = 1986361461(0x76657875, float:1.16355385E33)
            if (r4 != r5) goto L_0x07a9
            int r5 = r54 + 8
            r1.zzL(r5)
            int r4 = r1.zzd()
            r55 = r9
            r5 = 0
        L_0x0675:
            int r9 = r4 - r54
            if (r9 >= r7) goto L_0x072b
            r1.zzL(r4)
            int r9 = r1.zzg()
            if (r9 <= 0) goto L_0x0686
            r56 = r4
            r4 = 1
            goto L_0x0689
        L_0x0686:
            r56 = r4
            r4 = 0
        L_0x0689:
            com.google.android.gms.internal.ads.zzacv.zzb(r4, r0)
            int r4 = r1.zzg()
            r57 = r12
            r12 = 1702454643(0x65796573, float:7.360879E22)
            if (r4 != r12) goto L_0x0717
            int r4 = r56 + 8
            r1.zzL(r4)
            int r4 = r1.zzd()
        L_0x06a0:
            int r5 = r4 - r56
            if (r5 >= r9) goto L_0x070b
            r1.zzL(r4)
            int r5 = r1.zzg()
            if (r5 <= 0) goto L_0x06af
            r12 = 1
            goto L_0x06b0
        L_0x06af:
            r12 = 0
        L_0x06b0:
            com.google.android.gms.internal.ads.zzacv.zzb(r12, r0)
            int r12 = r1.zzg()
            r58 = r0
            r0 = 1937011305(0x73747269, float:1.936708E31)
            if (r12 != r0) goto L_0x06ff
            r12 = 4
            r1.zzM(r12)
            int r0 = r1.zzm()
            r4 = r0 & 1
            r5 = r0 & 2
            r12 = 2
            if (r5 != r12) goto L_0x06cf
            r5 = 1
            goto L_0x06d0
        L_0x06cf:
            r5 = 0
        L_0x06d0:
            r12 = r0 & 8
            r59 = r0
            r0 = 8
            if (r12 != r0) goto L_0x06da
            r12 = 1
            goto L_0x06db
        L_0x06da:
            r12 = 0
        L_0x06db:
            r41 = r0
            r0 = r59 & 4
            r59 = r9
            r9 = 4
            if (r0 != r9) goto L_0x06e6
            r0 = 1
            goto L_0x06e7
        L_0x06e6:
            r0 = 0
        L_0x06e7:
            r9 = 1
            if (r9 == r4) goto L_0x06ee
            r42 = r9
            r4 = 0
            goto L_0x06f1
        L_0x06ee:
            r4 = r9
            r42 = r4
        L_0x06f1:
            com.google.android.gms.internal.ads.zzaif r9 = new com.google.android.gms.internal.ads.zzaif
            r60 = r6
            com.google.android.gms.internal.ads.zzaih r6 = new com.google.android.gms.internal.ads.zzaih
            r6.<init>(r4, r5, r12, r0)
            r9.<init>(r6)
            r5 = r9
            goto L_0x0721
        L_0x06ff:
            r60 = r6
            r59 = r9
            r41 = 8
            r42 = 1
            int r4 = r4 + r5
            r0 = r58
            goto L_0x06a0
        L_0x070b:
            r58 = r0
            r60 = r6
            r59 = r9
            r41 = 8
            r42 = 1
            r5 = 0
            goto L_0x0721
        L_0x0717:
            r58 = r0
            r60 = r6
            r59 = r9
            r41 = 8
            r42 = 1
        L_0x0721:
            int r4 = r56 + r59
            r12 = r57
            r0 = r58
            r6 = r60
            goto L_0x0675
        L_0x072b:
            r58 = r0
            r60 = r6
            r57 = r12
            r41 = 8
            r42 = 1
            if (r5 != 0) goto L_0x0739
            r4 = 0
            goto L_0x073e
        L_0x0739:
            com.google.android.gms.internal.ads.zzaim r4 = new com.google.android.gms.internal.ads.zzaim
            r4.<init>(r5)
        L_0x073e:
            if (r4 == 0) goto L_0x079d
            if (r11 == 0) goto L_0x0768
            com.google.android.gms.internal.ads.zzfzo r0 = r11.zza
            int r0 = r0.size()
            r12 = 2
            if (r0 < r12) goto L_0x0769
            boolean r0 = r4.zzb()
            java.lang.String r5 = "both eye views must be marked as available"
            com.google.android.gms.internal.ads.zzacv.zzb(r0, r5)
            com.google.android.gms.internal.ads.zzaif r0 = r4.zza
            com.google.android.gms.internal.ads.zzaih r0 = r0.zza
            boolean r0 = r0.zzc
            r0 = r0 ^ 1
            java.lang.String r4 = "for MV-HEVC, eye_views_reversed must be set to false"
            com.google.android.gms.internal.ads.zzacv.zzb(r0, r4)
            goto L_0x079d
        L_0x0768:
            r11 = 0
        L_0x0769:
            r5 = -1
            if (r15 != r5) goto L_0x0791
            com.google.android.gms.internal.ads.zzaif r0 = r4.zza
            com.google.android.gms.internal.ads.zzaih r0 = r0.zza
            boolean r0 = r0.zzc
            r9 = r42
            r56 = r3
            r59 = r11
            if (r9 == r0) goto L_0x0789
            r12 = r57
            r6 = r60
            r3 = 3
            r11 = -1
            r15 = 4
            goto L_0x0c54
        L_0x0789:
            r15 = r17
            r12 = r57
            r6 = r60
            goto L_0x0ad7
        L_0x0791:
            r56 = r3
            r59 = r11
            r12 = r57
            r6 = r60
            r3 = 3
            r11 = r5
            goto L_0x0c54
        L_0x079d:
            r56 = r3
            r59 = r11
            r66 = r13
            r61 = r14
            r3 = 3
        L_0x07a6:
            r11 = -1
            goto L_0x0c4c
        L_0x07a9:
            r58 = r0
            r60 = r6
            r55 = r9
            r57 = r12
            r41 = 8
            r0 = 1685480259(0x64766343, float:1.8180206E22)
            if (r4 == r0) goto L_0x0c35
            r0 = 1685485123(0x64767643, float:1.8185683E22)
            if (r4 != r0) goto L_0x07bf
            goto L_0x0c35
        L_0x07bf:
            r0 = 1987076931(0x76706343, float:1.21891066E33)
            r6 = 7
            if (r4 != r0) goto L_0x0855
            if (r8 != 0) goto L_0x07c9
            r8 = 1
            goto L_0x07ca
        L_0x07c9:
            r8 = 0
        L_0x07ca:
            r12 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r12)
            int r0 = r54 + 12
            r1.zzL(r0)
            int r0 = r1.zzm()
            byte r0 = (byte) r0
            int r2 = r1.zzm()
            byte r2 = (byte) r2
            int r4 = r1.zzm()
            int r8 = r4 >> 4
            int r9 = r4 >> 1
            r9 = r9 & r6
            r10 = 1987063864(0x76703038, float:1.21789965E33)
            if (r3 != r10) goto L_0x07ee
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            goto L_0x07f0
        L_0x07ee:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
        L_0x07f0:
            java.lang.String r12 = "video/x-vnd.on2.vp9"
            boolean r12 = r10.equals(r12)
            if (r12 == 0) goto L_0x082c
            byte r12 = (byte) r8
            byte r9 = (byte) r9
            int r13 = com.google.android.gms.internal.ads.zzdd.zza
            r14 = 12
            byte[] r13 = new byte[r14]
            r5 = 1
            r31 = 0
            r39 = 10
            r13[r31] = r5
            r13[r5] = r5
            r40 = 2
            r13[r40] = r0
            r0 = 3
            r13[r0] = r40
            r18 = 4
            r13[r18] = r5
            r13[r17] = r2
            r2 = 6
            r13[r2] = r0
            r13[r6] = r5
            r13[r41] = r12
            r2 = 9
            r13[r2] = r18
            r13[r39] = r5
            r2 = 11
            r13[r2] = r9
            com.google.android.gms.internal.ads.zzfzo r13 = com.google.android.gms.internal.ads.zzfzo.zzo(r13)
            goto L_0x0830
        L_0x082c:
            r0 = 3
            r5 = 1
            r14 = 12
        L_0x0830:
            r2 = r4 & 1
            int r4 = r1.zzm()
            int r6 = r1.zzm()
            int r4 = com.google.android.gms.internal.ads.zzm.zza(r4)
            if (r5 == r2) goto L_0x0842
            r2 = 2
            goto L_0x0843
        L_0x0842:
            r2 = 1
        L_0x0843:
            int r5 = com.google.android.gms.internal.ads.zzm.zzb(r6)
            r14 = r2
            r56 = r3
            r2 = r4
            r6 = r8
            r12 = r6
            r8 = r10
            r59 = r11
            r11 = -1
            r3 = r0
            r10 = r5
            goto L_0x0c54
        L_0x0855:
            r0 = 3
            r5 = 12
            r39 = 10
            r9 = 1635135811(0x61763143, float:2.8384055E20)
            java.lang.String r12 = "BoxParsers"
            if (r4 != r9) goto L_0x0a31
            int r2 = r54 + 8
            int r4 = r7 + -8
            byte[] r8 = new byte[r4]
            r9 = 0
            r1.zzH(r8, r9, r4)
            com.google.android.gms.internal.ads.zzfzo r4 = com.google.android.gms.internal.ads.zzfzo.zzo(r8)
            r1.zzL(r2)
            com.google.android.gms.internal.ads.zzk r2 = new com.google.android.gms.internal.ads.zzk
            r2.<init>()
            com.google.android.gms.internal.ads.zzec r8 = new com.google.android.gms.internal.ads.zzec
            byte[] r10 = r1.zzN()
            int r13 = r10.length
            r8.<init>(r10, r13)
            int r10 = r1.zzd()
            int r10 = r10 * 8
            r8.zzl(r10)
            r10 = 1
            r8.zzo(r10)
            int r13 = r8.zzd(r0)
            r14 = 6
            r8.zzn(r14)
            boolean r14 = r8.zzp()
            boolean r9 = r8.zzp()
            r6 = 2
            if (r13 != r6) goto L_0x08b2
            if (r14 == 0) goto L_0x08b0
            if (r10 == r9) goto L_0x08a8
            r9 = r39
            goto L_0x08a9
        L_0x08a8:
            r9 = r5
        L_0x08a9:
            r2.zzf(r9)
            r2.zza(r9)
            goto L_0x08c1
        L_0x08b0:
            r13 = r6
            r14 = 0
        L_0x08b2:
            if (r13 > r6) goto L_0x08c1
            if (r10 == r14) goto L_0x08b9
            r6 = r41
            goto L_0x08bb
        L_0x08b9:
            r6 = r39
        L_0x08bb:
            r2.zzf(r6)
            r2.zza(r6)
        L_0x08c1:
            r6 = 13
            r8.zzn(r6)
            r8.zzm()
            r9 = 4
            int r13 = r8.zzd(r9)
            if (r13 == r10) goto L_0x08ea
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Unsupported obu_type: "
            r6.<init>(r8)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
        L_0x08e5:
            r10 = r17
            r5 = 4
            goto L_0x0a16
        L_0x08ea:
            boolean r9 = r8.zzp()
            if (r9 == 0) goto L_0x08fa
            java.lang.String r6 = "Unsupported obu_extension_flag"
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
            goto L_0x08e5
        L_0x08fa:
            boolean r9 = r8.zzp()
            r8.zzm()
            if (r9 == 0) goto L_0x0917
            r9 = r41
            int r10 = r8.zzd(r9)
            r9 = 127(0x7f, float:1.78E-43)
            if (r10 <= r9) goto L_0x0917
            java.lang.String r6 = "Excessive obu_size"
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
            goto L_0x08e5
        L_0x0917:
            int r9 = r8.zzd(r0)
            r8.zzm()
            boolean r10 = r8.zzp()
            if (r10 == 0) goto L_0x092e
            java.lang.String r6 = "Unsupported reduced_still_picture_header"
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
            goto L_0x08e5
        L_0x092e:
            boolean r10 = r8.zzp()
            if (r10 == 0) goto L_0x093e
            java.lang.String r6 = "Unsupported timing_info_present_flag"
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
            goto L_0x08e5
        L_0x093e:
            boolean r10 = r8.zzp()
            if (r10 == 0) goto L_0x094e
            java.lang.String r6 = "Unsupported initial_display_delay_present_flag"
            com.google.android.gms.internal.ads.zzdt.zze(r12, r6)
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
            goto L_0x08e5
        L_0x094e:
            r10 = r17
            int r12 = r8.zzd(r10)
            r13 = 0
        L_0x0955:
            if (r13 > r12) goto L_0x0969
            r8.zzn(r5)
            int r14 = r8.zzd(r10)
            r5 = 7
            if (r14 <= r5) goto L_0x0964
            r8.zzm()
        L_0x0964:
            int r13 = r13 + 1
            r5 = 12
            goto L_0x0955
        L_0x0969:
            r5 = 4
            int r12 = r8.zzd(r5)
            int r13 = r8.zzd(r5)
            r42 = 1
            int r12 = r12 + 1
            r8.zzn(r12)
            int r13 = r13 + 1
            r8.zzn(r13)
            boolean r12 = r8.zzp()
            if (r12 == 0) goto L_0x0989
            r12 = 7
            r8.zzn(r12)
            goto L_0x098a
        L_0x0989:
            r12 = 7
        L_0x098a:
            r8.zzn(r12)
            boolean r12 = r8.zzp()
            if (r12 == 0) goto L_0x0997
            r13 = 2
            r8.zzn(r13)
        L_0x0997:
            boolean r13 = r8.zzp()
            if (r13 == 0) goto L_0x099f
            r13 = 1
            goto L_0x09a6
        L_0x099f:
            r13 = 1
            int r14 = r8.zzd(r13)
            if (r14 <= 0) goto L_0x09af
        L_0x09a6:
            boolean r14 = r8.zzp()
            if (r14 != 0) goto L_0x09af
            r8.zzn(r13)
        L_0x09af:
            if (r12 == 0) goto L_0x09b4
            r8.zzn(r0)
        L_0x09b4:
            r8.zzn(r0)
            boolean r12 = r8.zzp()
            r13 = 2
            if (r9 != r13) goto L_0x09c4
            if (r12 == 0) goto L_0x09c9
            r8.zzm()
            goto L_0x09c9
        L_0x09c4:
            r13 = 1
            if (r9 != r13) goto L_0x09c9
        L_0x09c7:
            r9 = 0
            goto L_0x09d0
        L_0x09c9:
            boolean r9 = r8.zzp()
            if (r9 == 0) goto L_0x09c7
            r9 = 1
        L_0x09d0:
            boolean r12 = r8.zzp()
            if (r12 == 0) goto L_0x0a12
            r12 = 8
            int r13 = r8.zzd(r12)
            int r14 = r8.zzd(r12)
            int r17 = r8.zzd(r12)
            if (r9 != 0) goto L_0x09f4
            r9 = 1
            if (r13 != r9) goto L_0x09f5
            if (r14 != r6) goto L_0x09f2
            if (r17 != 0) goto L_0x09f0
            r8 = r9
            r12 = r8
            goto L_0x09fc
        L_0x09f0:
            r13 = r9
            goto L_0x09f6
        L_0x09f2:
            r13 = r9
            goto L_0x09f5
        L_0x09f4:
            r9 = 1
        L_0x09f5:
            r6 = r14
        L_0x09f6:
            int r8 = r8.zzd(r9)
            r12 = r8
            r8 = r13
        L_0x09fc:
            int r8 = com.google.android.gms.internal.ads.zzm.zza(r8)
            r2.zzc(r8)
            if (r12 != r9) goto L_0x0a07
            r8 = 1
            goto L_0x0a08
        L_0x0a07:
            r8 = 2
        L_0x0a08:
            r2.zzb(r8)
            int r6 = com.google.android.gms.internal.ads.zzm.zzb(r6)
            r2.zzd(r6)
        L_0x0a12:
            com.google.android.gms.internal.ads.zzm r2 = r2.zzg()
        L_0x0a16:
            int r6 = r2.zzf
            int r8 = r2.zzg
            int r9 = r2.zzb
            int r12 = r2.zzc
            int r2 = r2.zzd
            java.lang.String r13 = "video/av01"
            r56 = r3
            r17 = r10
            r59 = r11
            r14 = r12
            r11 = -1
            r3 = r0
            r10 = r2
            r12 = r8
            r2 = r9
            r8 = r13
            goto L_0x0557
        L_0x0a31:
            r5 = 4
            r6 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r4 != r6) goto L_0x0a61
            if (r28 != 0) goto L_0x0a3e
            java.nio.ByteBuffer r4 = zzm()
            goto L_0x0a40
        L_0x0a3e:
            r4 = r28
        L_0x0a40:
            r6 = 21
            r4.position(r6)
            short r6 = r1.zzE()
            r4.putShort(r6)
            short r6 = r1.zzE()
            r4.putShort(r6)
            r56 = r3
            r28 = r4
            r59 = r11
            r12 = r57
            r6 = r60
            r11 = -1
            r3 = r0
            goto L_0x0c54
        L_0x0a61:
            r6 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r4 != r6) goto L_0x0adb
            if (r28 != 0) goto L_0x0a6d
            java.nio.ByteBuffer r4 = zzm()
            goto L_0x0a6f
        L_0x0a6d:
            r4 = r28
        L_0x0a6f:
            short r6 = r1.zzE()
            short r9 = r1.zzE()
            short r12 = r1.zzE()
            short r5 = r1.zzE()
            short r0 = r1.zzE()
            r56 = r3
            short r3 = r1.zzE()
            r59 = r11
            short r11 = r1.zzE()
            r61 = r14
            short r14 = r1.zzE()
            long r62 = r1.zzu()
            long r64 = r1.zzu()
            r66 = r13
            r13 = 1
            r4.position(r13)
            r4.putShort(r0)
            r4.putShort(r3)
            r4.putShort(r6)
            r4.putShort(r9)
            r4.putShort(r12)
            r4.putShort(r5)
            r4.putShort(r11)
            r4.putShort(r14)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r62 / r5
            int r0 = (int) r5
            short r0 = (short) r0
            r4.putShort(r0)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r64 / r5
            int r0 = (int) r5
            short r0 = (short) r0
            r4.putShort(r0)
            r28 = r4
        L_0x0acf:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
        L_0x0ad7:
            r3 = 3
        L_0x0ad8:
            r11 = -1
            goto L_0x0c54
        L_0x0adb:
            r56 = r3
            r59 = r11
            r66 = r13
            r61 = r14
            r0 = 1681012275(0x64323633, float:1.3149704E22)
            if (r4 != r0) goto L_0x0af5
            if (r8 != 0) goto L_0x0aec
            r8 = 1
            goto L_0x0aed
        L_0x0aec:
            r8 = 0
        L_0x0aed:
            r0 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r0)
            java.lang.String r3 = "video/3gpp"
        L_0x0af3:
            r8 = r3
            goto L_0x0acf
        L_0x0af5:
            r0 = 0
            r3 = 1702061171(0x65736473, float:7.183675E22)
            if (r4 != r3) goto L_0x0b25
            if (r8 != 0) goto L_0x0aff
            r8 = 1
            goto L_0x0b00
        L_0x0aff:
            r8 = 0
        L_0x0b00:
            com.google.android.gms.internal.ads.zzacv.zzb(r8, r0)
            r0 = r54
            com.google.android.gms.internal.ads.zzaie r0 = zzl(r1, r0)
            java.lang.String r3 = r0.zza
            byte[] r4 = r0.zzb
            if (r4 == 0) goto L_0x0b22
            com.google.android.gms.internal.ads.zzfzo r4 = com.google.android.gms.internal.ads.zzfzo.zzo(r4)
            r30 = r0
            r8 = r3
            r13 = r4
            r12 = r57
            r6 = r60
            r14 = r61
            goto L_0x0ad7
        L_0x0b22:
            r30 = r0
            goto L_0x0af3
        L_0x0b25:
            r0 = r54
            r3 = 1885434736(0x70617370, float:2.7909473E29)
            if (r4 != r3) goto L_0x0b4c
            int r5 = r0 + 8
            r1.zzL(r5)
            int r0 = r1.zzp()
            int r3 = r1.zzp()
            float r0 = (float) r0
            float r3 = (float) r3
            float r0 = r0 / r3
            r50 = r0
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            r3 = 3
            r11 = -1
            r45 = 1
            goto L_0x0c54
        L_0x0b4c:
            r3 = 1937126244(0x73763364, float:1.9506033E31)
            if (r4 != r3) goto L_0x0b84
            int r5 = r0 + 8
        L_0x0b53:
            int r3 = r5 - r0
            if (r3 >= r7) goto L_0x0b76
            r1.zzL(r5)
            int r3 = r1.zzg()
            int r3 = r3 + r5
            int r4 = r1.zzg()
            r6 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r4 != r6) goto L_0x0b74
            byte[] r0 = r1.zzN()
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r5, r3)
            r44 = r0
            goto L_0x0acf
        L_0x0b74:
            r5 = r3
            goto L_0x0b53
        L_0x0b76:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            r3 = 3
            r11 = -1
            r44 = 0
            goto L_0x0c54
        L_0x0b84:
            r0 = 1936995172(0x73743364, float:1.9347576E31)
            if (r4 != r0) goto L_0x0bd2
            int r0 = r1.zzm()
            r3 = 3
            r1.zzM(r3)
            if (r0 != 0) goto L_0x07a6
            int r0 = r1.zzm()
            if (r0 == 0) goto L_0x0bc6
            r9 = 1
            if (r0 == r9) goto L_0x0bba
            r12 = 2
            if (r0 == r12) goto L_0x0bae
            if (r0 == r3) goto L_0x0ba3
            goto L_0x07a6
        L_0x0ba3:
            r15 = r3
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            goto L_0x0ad8
        L_0x0bae:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            r11 = -1
            r15 = 2
            goto L_0x0c54
        L_0x0bba:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            r11 = -1
            r15 = 1
            goto L_0x0c54
        L_0x0bc6:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
            r11 = -1
            r15 = 0
            goto L_0x0c54
        L_0x0bd2:
            r3 = 3
            r0 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r4 != r0) goto L_0x07a6
            r11 = -1
            if (r2 != r11) goto L_0x0c4c
            if (r10 != r11) goto L_0x0c33
            int r0 = r1.zzg()
            r2 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 == r2) goto L_0x0bfc
            r2 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r0 != r2) goto L_0x0bec
            goto L_0x0bfc
        L_0x0bec:
            java.lang.String r2 = "Unsupported color type: "
            java.lang.String r0 = com.google.android.gms.internal.ads.zzev.zze(r0)
            java.lang.String r0 = r2.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r0)
            r2 = r11
            r10 = r2
            goto L_0x0c4c
        L_0x0bfc:
            int r0 = r1.zzq()
            int r2 = r1.zzq()
            r12 = 2
            r1.zzM(r12)
            r4 = 19
            if (r7 != r4) goto L_0x0c1a
            int r4 = r1.zzm()
            r4 = r4 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0c18
            r7 = 19
            r4 = 1
            goto L_0x0c1b
        L_0x0c18:
            r7 = 19
        L_0x0c1a:
            r4 = 0
        L_0x0c1b:
            int r0 = com.google.android.gms.internal.ads.zzm.zza(r0)
            r9 = 1
            if (r9 == r4) goto L_0x0c24
            r4 = 2
            goto L_0x0c25
        L_0x0c24:
            r4 = 1
        L_0x0c25:
            int r2 = com.google.android.gms.internal.ads.zzm.zzb(r2)
            r10 = r2
            r14 = r4
            r12 = r57
            r6 = r60
            r13 = r66
            r2 = r0
            goto L_0x0c54
        L_0x0c33:
            r2 = r11
            goto L_0x0c4c
        L_0x0c35:
            r56 = r3
            r59 = r11
            r66 = r13
            r61 = r14
            r3 = 3
            r11 = -1
            com.google.android.gms.internal.ads.zzacn r0 = com.google.android.gms.internal.ads.zzacn.zza(r1)
            if (r0 == 0) goto L_0x0c4c
            java.lang.String r0 = r0.zza
            java.lang.String r4 = "video/dolby-vision"
            r49 = r0
            r8 = r4
        L_0x0c4c:
            r12 = r57
            r6 = r60
            r14 = r61
            r13 = r66
        L_0x0c54:
            int r7 = r53 + r7
            r4 = r52
            r9 = r55
            r3 = r56
            r0 = r58
            r11 = r59
            goto L_0x04d5
        L_0x0c62:
            r52 = r4
            r60 = r6
            r55 = r9
            r57 = r12
            r66 = r13
            r61 = r14
            r3 = 3
            r11 = -1
            if (r8 != 0) goto L_0x0c7a
            r8 = r46
            r5 = r51
            r9 = r55
            goto L_0x0d03
        L_0x0c7a:
            com.google.android.gms.internal.ads.zzab r0 = new com.google.android.gms.internal.ads.zzab
            r0.<init>()
            r5 = r51
            r0.zzK(r5)
            r0.zzZ(r8)
            r4 = r49
            r0.zzA(r4)
            r4 = r48
            r0.zzae(r4)
            r4 = r47
            r0.zzJ(r4)
            r4 = r50
            r0.zzV(r4)
            r8 = r46
            r0.zzY(r8)
            r4 = r44
            r0.zzW(r4)
            r0.zzac(r15)
            r13 = r66
            r0.zzM(r13)
            r4 = r43
            r0.zzR(r4)
            r4 = r38
            r0.zzF(r4)
            com.google.android.gms.internal.ads.zzk r4 = new com.google.android.gms.internal.ads.zzk
            r4.<init>()
            r4.zzc(r2)
            r14 = r61
            r4.zzb(r14)
            r4.zzd(r10)
            if (r28 == 0) goto L_0x0cce
            byte[] r2 = r28.array()
            goto L_0x0ccf
        L_0x0cce:
            r2 = 0
        L_0x0ccf:
            r4.zze(r2)
            r6 = r60
            r4.zzf(r6)
            r12 = r57
            r4.zza(r12)
            com.google.android.gms.internal.ads.zzm r2 = r4.zzg()
            r0.zzB(r2)
            if (r30 == 0) goto L_0x0cfb
            long r6 = r30.zzc
            int r2 = com.google.android.gms.internal.ads.zzgcr.zze(r6)
            r0.zzy(r2)
            long r6 = r30.zzd
            int r2 = com.google.android.gms.internal.ads.zzgcr.zze(r6)
            r0.zzU(r2)
        L_0x0cfb:
            com.google.android.gms.internal.ads.zzad r0 = r0.zzaf()
            r9 = r55
            r9.zzb = r0
        L_0x0d03:
            int r0 = r29 + r52
            r1.zzL(r0)
            int r10 = r27 + 1
            r0 = r68
            r2 = r8
            r3 = r16
            r7 = r19
            r6 = r22
            r12 = r25
            r13 = r32
            r11 = r33
            r15 = r34
            r14 = r35
            r4 = 12
            r8 = 8
            goto L_0x020f
        L_0x0d23:
            r16 = r3
            r33 = r11
            r25 = r12
            r32 = r13
            r35 = r14
            r34 = r15
            if (r73 != 0) goto L_0x0da6
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r1 = r35
            com.google.android.gms.internal.ads.zzes r0 = r1.zza(r0)
            if (r0 == 0) goto L_0x0da8
            r2 = 1701606260(0x656c7374, float:6.9788014E22)
            com.google.android.gms.internal.ads.zzet r0 = r0.zzb(r2)
            if (r0 != 0) goto L_0x0d47
            r4 = 0
            goto L_0x0d96
        L_0x0d47:
            com.google.android.gms.internal.ads.zzed r0 = r0.zza
            r8 = 8
            r0.zzL(r8)
            int r2 = r0.zzg()
            int r2 = zza(r2)
            int r3 = r0.zzp()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r6 = 0
        L_0x0d5f:
            if (r6 >= r3) goto L_0x0d92
            r13 = 1
            if (r2 != r13) goto L_0x0d69
            long r7 = r0.zzw()
            goto L_0x0d6d
        L_0x0d69:
            long r7 = r0.zzu()
        L_0x0d6d:
            r4[r6] = r7
            if (r2 != r13) goto L_0x0d76
            long r7 = r0.zzt()
            goto L_0x0d7b
        L_0x0d76:
            int r7 = r0.zzg()
            long r7 = (long) r7
        L_0x0d7b:
            r5[r6] = r7
            short r7 = r0.zzE()
            if (r7 != r13) goto L_0x0d8a
            r12 = 2
            r0.zzM(r12)
            int r6 = r6 + 1
            goto L_0x0d5f
        L_0x0d8a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0d92:
            android.util.Pair r4 = android.util.Pair.create(r4, r5)
        L_0x0d96:
            if (r4 == 0) goto L_0x0da8
            java.lang.Object r0 = r4.first
            long[] r0 = (long[]) r0
            java.lang.Object r2 = r4.second
            r4 = r2
            long[] r4 = (long[]) r4
            r29 = r0
            r30 = r4
            goto L_0x0dac
        L_0x0da6:
            r1 = r35
        L_0x0da8:
            r29 = 0
            r30 = 0
        L_0x0dac:
            com.google.android.gms.internal.ads.zzad r0 = r9.zzb
            if (r0 != 0) goto L_0x0db4
            r0 = r75
            goto L_0x008d
        L_0x0db4:
            r18 = r16
            com.google.android.gms.internal.ads.zzaje r16 = new com.google.android.gms.internal.ads.zzaje
            int r17 = r25.zza
            r0 = r34
            java.lang.Object r0 = r0.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r19 = r0.longValue()
            com.google.android.gms.internal.ads.zzad r0 = r9.zzb
            int r2 = r9.zzd
            com.google.android.gms.internal.ads.zzajf[] r3 = r9.zza
            int r4 = r9.zzc
            r25 = r0
            r26 = r2
            r27 = r3
            r28 = r4
            r21 = r36
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r0 = r75
            r4 = r16
        L_0x0ddf:
            java.lang.Object r2 = r0.apply(r4)
            com.google.android.gms.internal.ads.zzaje r2 = (com.google.android.gms.internal.ads.zzaje) r2
            if (r2 == 0) goto L_0x0e1a
            r3 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzes r1 = r1.zza(r3)
            r1.getClass()
            r3 = r1
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            r3 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzes r1 = r1.zza(r3)
            r1.getClass()
            r3 = r1
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            r3 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzes r1 = r1.zza(r3)
            r1.getClass()
            r3 = r1
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            r3 = r69
            com.google.android.gms.internal.ads.zzajh r1 = zze(r2, r1, r3)
            r2 = r33
            r2.add(r1)
            goto L_0x0e1e
        L_0x0e1a:
            r3 = r69
            r2 = r33
        L_0x0e1e:
            int r13 = r32 + 1
            r0 = r68
            r11 = r2
            goto L_0x0008
        L_0x0e25:
            java.lang.String r0 = "Malformed sample table (stbl) missing sample description (stsd)"
            r12 = 0
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r12)
            throw r0
        L_0x0e2d:
            r2 = r11
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zzf(com.google.android.gms.internal.ads.zzes, com.google.android.gms.internal.ads.zzadf, long, com.google.android.gms.internal.ads.zzw, boolean, boolean, com.google.android.gms.internal.ads.zzfwh):java.util.List");
    }

    public static void zzg(zzed zzed) {
        int zzd = zzed.zzd();
        zzed.zzM(4);
        if (zzed.zzg() != 1751411826) {
            zzd += 4;
        }
        zzed.zzL(zzd);
    }

    private static int zzh(zzed zzed) {
        int zzm = zzed.zzm();
        int i = zzm & 127;
        while ((zzm & 128) == 128) {
            zzm = zzed.zzm();
            i = (i << 7) | (zzm & 127);
        }
        return i;
    }

    private static int zzi(zzed zzed) {
        zzed.zzL(16);
        return zzed.zzg();
    }

    private static Pair zzj(zzed zzed, int i, int i2) throws zzbh {
        Pair pair;
        Integer num;
        zzajf zzajf;
        int i3;
        int i4;
        boolean z;
        Integer num2;
        zzed zzed2 = zzed;
        int zzd = zzed2.zzd();
        while (zzd - i < i2) {
            zzed2.zzL(zzd);
            int zzg = zzed2.zzg();
            boolean z2 = true;
            zzacv.zzb(zzg > 0, "childAtomSize must be positive");
            if (zzed2.zzg() == 1936289382) {
                int i5 = zzd + 8;
                int i6 = 0;
                int i7 = -1;
                Integer num3 = null;
                String str = null;
                while (i5 - zzd < zzg) {
                    zzed2.zzL(i5);
                    int zzg2 = zzed2.zzg();
                    int zzg3 = zzed2.zzg();
                    if (zzg3 == 1718775137) {
                        num3 = Integer.valueOf(zzed2.zzg());
                    } else if (zzg3 == 1935894637) {
                        zzed2.zzM(4);
                        str = zzed2.zzB(4, StandardCharsets.UTF_8);
                    } else if (zzg3 == 1935894633) {
                        i7 = i5;
                        i6 = zzg2;
                    }
                    i5 += zzg2;
                }
                byte[] bArr = null;
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    zzacv.zzb(num3 != null, "frma atom is mandatory");
                    zzacv.zzb(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = num3;
                            zzajf = null;
                            break;
                        }
                        zzed2.zzL(i8);
                        int zzg4 = zzed2.zzg();
                        if (zzed2.zzg() == 1952804451) {
                            int zza2 = zza(zzed2.zzg());
                            zzed2.zzM(1);
                            if (zza2 == 0) {
                                zzed2.zzM(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzm = zzed2.zzm();
                                i3 = zzm & 15;
                                i4 = (zzm & 240) >> 4;
                            }
                            if (zzed2.zzm() == 1) {
                                num2 = num3;
                                z = true;
                            } else {
                                num2 = num3;
                                z = false;
                            }
                            int zzm2 = zzed2.zzm();
                            byte[] bArr2 = new byte[16];
                            zzed2.zzH(bArr2, 0, 16);
                            if (z && zzm2 == 0) {
                                int zzm3 = zzed2.zzm();
                                byte[] bArr3 = new byte[zzm3];
                                zzed2.zzH(bArr3, 0, zzm3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzajf = new zzajf(z, str, zzm2, bArr2, i4, i3, bArr);
                        } else {
                            Integer num4 = num3;
                            i8 += zzg4;
                        }
                    }
                    if (zzajf == null) {
                        z2 = false;
                    }
                    zzacv.zzb(z2, "tenc atom is mandatory");
                    int i9 = zzen.zza;
                    zzajf zzajf2 = zzajf;
                    pair = Pair.create(num, zzajf);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzd += zzg;
        }
        return null;
    }

    private static zzbd zzk(zzed zzed) {
        short zzE = zzed.zzE();
        zzed.zzM(2);
        String zzB = zzed.zzB(zzE, StandardCharsets.UTF_8);
        int max = Math.max(zzB.lastIndexOf(43), zzB.lastIndexOf(45));
        try {
            return new zzbd(-9223372036854775807L, new zzey(Float.parseFloat(zzB.substring(0, max)), Float.parseFloat(zzB.substring(max, zzB.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzaie zzl(zzed zzed, int i) {
        zzed.zzL(i + 12);
        zzed.zzM(1);
        zzh(zzed);
        zzed.zzM(2);
        int zzm = zzed.zzm();
        if ((zzm & 128) != 0) {
            zzed.zzM(2);
        }
        if ((zzm & 64) != 0) {
            zzed.zzM(zzed.zzm());
        }
        if ((zzm & 32) != 0) {
            zzed.zzM(2);
        }
        zzed.zzM(1);
        zzh(zzed);
        String zzd = zzbg.zzd(zzed.zzm());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzaie(zzd, (byte[]) null, -1, -1);
        }
        zzed.zzM(4);
        long zzu = zzed.zzu();
        long zzu2 = zzed.zzu();
        zzed.zzM(1);
        int zzh = zzh(zzed);
        long j = zzu2;
        byte[] bArr = new byte[zzh];
        zzed.zzH(bArr, 0, zzh);
        if (j <= 0) {
            j = -1;
        }
        return new zzaie(zzd, bArr, j, zzu > 0 ? zzu : -1);
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015b, code lost:
        if (r9 == -1) goto L_0x0144;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzn(com.google.android.gms.internal.ads.zzed r29, int r30, int r31, int r32, int r33, java.lang.String r34, boolean r35, com.google.android.gms.internal.ads.zzw r36, com.google.android.gms.internal.ads.zzaii r37, int r38) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r0 = r29
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r36
            r6 = r37
            int r7 = r1 + 16
            r0.zzL(r7)
            r7 = 6
            r8 = 8
            if (r35 == 0) goto L_0x0020
            int r10 = r0.zzq()
            r0.zzM(r7)
            goto L_0x0024
        L_0x0020:
            r0.zzM(r8)
            r10 = 0
        L_0x0024:
            r13 = 32
            r14 = 4
            r11 = 2
            r17 = 3
            r12 = 1
            r9 = 16
            if (r10 == 0) goto L_0x008a
            if (r10 != r12) goto L_0x0032
            goto L_0x008a
        L_0x0032:
            if (r10 != r11) goto L_0x056a
            r0.zzM(r9)
            long r19 = r0.zzt()
            double r19 = java.lang.Double.longBitsToDouble(r19)
            r21 = r11
            long r11 = java.lang.Math.round(r19)
            int r7 = (int) r11
            int r10 = r0.zzp()
            r0.zzM(r14)
            int r11 = r0.zzp()
            int r12 = r0.zzp()
            r19 = r12 & 1
            r12 = r12 & 2
            if (r19 != 0) goto L_0x0080
            if (r11 != r8) goto L_0x0060
            r9 = r17
            goto L_0x0085
        L_0x0060:
            if (r11 != r9) goto L_0x006a
            if (r12 == 0) goto L_0x0067
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0085
        L_0x0067:
            r9 = r21
            goto L_0x0085
        L_0x006a:
            r9 = 24
            if (r11 != r9) goto L_0x0076
            if (r12 == 0) goto L_0x0073
            r9 = 1342177280(0x50000000, float:8.5899346E9)
            goto L_0x0085
        L_0x0073:
            r9 = 21
            goto L_0x0085
        L_0x0076:
            if (r11 != r13) goto L_0x0084
            if (r12 == 0) goto L_0x007d
            r9 = 1610612736(0x60000000, float:3.6893488E19)
            goto L_0x0085
        L_0x007d:
            r9 = 22
            goto L_0x0085
        L_0x0080:
            if (r11 != r13) goto L_0x0084
            r9 = r14
            goto L_0x0085
        L_0x0084:
            r9 = -1
        L_0x0085:
            r0.zzM(r8)
            r11 = 0
            goto L_0x00ac
        L_0x008a:
            r21 = r11
            int r8 = r0.zzq()
            r0.zzM(r7)
            int r7 = r0.zzn()
            int r11 = r0.zzd()
            int r11 = r11 + -4
            r0.zzL(r11)
            int r11 = r0.zzg()
            r12 = 1
            if (r10 != r12) goto L_0x00aa
            r0.zzM(r9)
        L_0x00aa:
            r10 = r8
            r9 = -1
        L_0x00ac:
            int r8 = r0.zzd()
            r12 = 1701733217(0x656e6361, float:7.0359778E22)
            r19 = r13
            r14 = r30
            if (r14 != r12) goto L_0x00e4
            android.util.Pair r14 = zzj(r0, r1, r2)
            if (r14 == 0) goto L_0x00df
            java.lang.Object r12 = r14.first
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r5 != 0) goto L_0x00cb
            r13 = 0
            goto L_0x00d6
        L_0x00cb:
            java.lang.Object r13 = r14.second
            com.google.android.gms.internal.ads.zzajf r13 = (com.google.android.gms.internal.ads.zzajf) r13
            java.lang.String r13 = r13.zzb
            com.google.android.gms.internal.ads.zzw r5 = r5.zzb(r13)
            r13 = r5
        L_0x00d6:
            com.google.android.gms.internal.ads.zzajf[] r5 = r6.zza
            java.lang.Object r14 = r14.second
            com.google.android.gms.internal.ads.zzajf r14 = (com.google.android.gms.internal.ads.zzajf) r14
            r5[r38] = r14
            goto L_0x00e0
        L_0x00df:
            r13 = r5
        L_0x00e0:
            r0.zzL(r8)
            goto L_0x00e6
        L_0x00e4:
            r13 = r5
            r12 = r14
        L_0x00e6:
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            java.lang.String r14 = "audio/mhm1"
            java.lang.String r15 = "audio/ac4"
            if (r12 != r5) goto L_0x00f3
            java.lang.String r5 = "audio/ac3"
            goto L_0x01b7
        L_0x00f3:
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r12 != r5) goto L_0x00fc
            java.lang.String r5 = "audio/eac3"
            goto L_0x01b7
        L_0x00fc:
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r12 != r5) goto L_0x0104
            r5 = r15
            goto L_0x01b7
        L_0x0104:
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r12 != r5) goto L_0x010d
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x01b7
        L_0x010d:
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r12 == r5) goto L_0x01b5
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r12 != r5) goto L_0x0119
            goto L_0x01b5
        L_0x0119:
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r12 != r5) goto L_0x0122
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x01b7
        L_0x0122:
            r5 = 1685353336(0x64747378, float:1.8037304E22)
            if (r12 != r5) goto L_0x012b
            java.lang.String r5 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x01b7
        L_0x012b:
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r12 != r5) goto L_0x0134
            java.lang.String r5 = "audio/3gpp"
            goto L_0x01b7
        L_0x0134:
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r12 != r5) goto L_0x013d
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x01b7
        L_0x013d:
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            java.lang.String r23 = "audio/raw"
            if (r12 != r5) goto L_0x014a
        L_0x0144:
            r9 = r21
        L_0x0146:
            r5 = r23
            goto L_0x01b7
        L_0x014a:
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r12 != r5) goto L_0x0155
            r5 = r23
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x01b7
        L_0x0155:
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r12 != r5) goto L_0x015e
            r5 = -1
            if (r9 != r5) goto L_0x0146
            goto L_0x0144
        L_0x015e:
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r12 == r5) goto L_0x01b2
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r12 != r5) goto L_0x0169
            goto L_0x01b2
        L_0x0169:
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r12 != r5) goto L_0x0171
            java.lang.String r5 = "audio/mha1"
            goto L_0x01b7
        L_0x0171:
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r12 != r5) goto L_0x0178
            r5 = r14
            goto L_0x01b7
        L_0x0178:
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r12 != r5) goto L_0x0180
            java.lang.String r5 = "audio/alac"
            goto L_0x01b7
        L_0x0180:
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r12 != r5) goto L_0x0188
            java.lang.String r5 = "audio/g711-alaw"
            goto L_0x01b7
        L_0x0188:
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r12 != r5) goto L_0x0190
            java.lang.String r5 = "audio/g711-mlaw"
            goto L_0x01b7
        L_0x0190:
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r12 != r5) goto L_0x0198
            java.lang.String r5 = "audio/opus"
            goto L_0x01b7
        L_0x0198:
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r12 != r5) goto L_0x01a0
            java.lang.String r5 = "audio/flac"
            goto L_0x01b7
        L_0x01a0:
            r5 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r12 != r5) goto L_0x01a8
            java.lang.String r5 = "audio/true-hd"
            goto L_0x01b7
        L_0x01a8:
            r5 = 1767992678(0x69616d66, float:1.7032808E25)
            if (r12 != r5) goto L_0x01b0
            java.lang.String r5 = "audio/iamf"
            goto L_0x01b7
        L_0x01b0:
            r5 = 0
            goto L_0x01b7
        L_0x01b2:
            java.lang.String r5 = "audio/mpeg"
            goto L_0x01b7
        L_0x01b5:
            java.lang.String r5 = "audio/vnd.dts.hd"
        L_0x01b7:
            r23 = r9
            r1 = 0
            r12 = 0
            r16 = 0
        L_0x01bd:
            int r9 = r8 - r31
            if (r9 >= r2) goto L_0x0520
            r0.zzL(r8)
            int r9 = r0.zzg()
            if (r9 <= 0) goto L_0x01cc
            r2 = 1
            goto L_0x01cd
        L_0x01cc:
            r2 = 0
        L_0x01cd:
            r36 = r12
            java.lang.String r12 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzacv.zzb(r2, r12)
            int r2 = r0.zzg()
            r38 = r7
            r7 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r2 != r7) goto L_0x0231
            int r2 = r8 + 8
            r0.zzL(r2)
            r12 = 1
            r0.zzM(r12)
            int r2 = r0.zzm()
            r0.zzM(r12)
            boolean r7 = java.util.Objects.equals(r5, r14)
            if (r7 == 0) goto L_0x0204
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r7 = "mhm1.%02X"
            java.lang.String r2 = java.lang.String.format(r7, r2)
            goto L_0x0212
        L_0x0204:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r7 = "mha1.%02X"
            java.lang.String r2 = java.lang.String.format(r7, r2)
        L_0x0212:
            r12 = r2
            int r2 = r0.zzq()
            byte[] r7 = new byte[r2]
            r36 = r12
            r12 = 0
            r0.zzH(r7, r12, r2)
            if (r1 != 0) goto L_0x0226
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzo(r7)
            goto L_0x024d
        L_0x0226:
            java.lang.Object r1 = r1.get(r12)
            byte[] r1 = (byte[]) r1
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzp(r7, r1)
            goto L_0x0261
        L_0x0231:
            r7 = 1835557200(0x6d686150, float:4.4948854E27)
            if (r2 != r7) goto L_0x0275
            int r2 = r8 + 8
            r0.zzL(r2)
            int r2 = r0.zzm()
            if (r2 <= 0) goto L_0x026c
            byte[] r7 = new byte[r2]
            r12 = 0
            r0.zzH(r7, r12, r2)
            if (r1 != 0) goto L_0x0257
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzo(r7)
        L_0x024d:
            r0 = r36
            r7 = r38
            r38 = r8
            r18 = r9
            goto L_0x0517
        L_0x0257:
            java.lang.Object r1 = r1.get(r12)
            byte[] r1 = (byte[]) r1
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzp(r1, r7)
        L_0x0261:
            r0 = r36
            r7 = r38
            r38 = r8
            r18 = r9
            r12 = 0
            goto L_0x0517
        L_0x026c:
            r7 = r38
        L_0x026e:
            r38 = r8
            r18 = r9
            r12 = 0
            goto L_0x0515
        L_0x0275:
            r7 = 1702061171(0x65736473, float:7.183675E22)
            if (r2 == r7) goto L_0x0462
            if (r35 == 0) goto L_0x02c2
            r7 = 2002876005(0x77617665, float:4.5729223E33)
            if (r2 != r7) goto L_0x02c2
            int r2 = r0.zzd()
            if (r2 < r8) goto L_0x0289
            r7 = 1
            goto L_0x028a
        L_0x0289:
            r7 = 0
        L_0x028a:
            r25 = r2
            r2 = 0
            com.google.android.gms.internal.ads.zzacv.zzb(r7, r2)
            r2 = r25
        L_0x0292:
            int r7 = r2 - r8
            if (r7 >= r9) goto L_0x02bd
            r0.zzL(r2)
            int r7 = r0.zzg()
            if (r7 <= 0) goto L_0x02a3
            r25 = r2
            r2 = 1
            goto L_0x02a6
        L_0x02a3:
            r25 = r2
            r2 = 0
        L_0x02a6:
            com.google.android.gms.internal.ads.zzacv.zzb(r2, r12)
            int r2 = r0.zzg()
            r26 = r7
            r7 = 1702061171(0x65736473, float:7.183675E22)
            if (r2 == r7) goto L_0x02b7
            int r2 = r25 + r26
            goto L_0x0292
        L_0x02b7:
            r7 = r38
            r2 = r25
            goto L_0x0465
        L_0x02bd:
            r7 = r38
            r2 = -1
            goto L_0x0465
        L_0x02c2:
            r7 = 1684103987(0x64616333, float:1.6630662E22)
            if (r2 != r7) goto L_0x02d7
            int r2 = r8 + 8
            r0.zzL(r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            com.google.android.gms.internal.ads.zzad r2 = com.google.android.gms.internal.ads.zzabr.zzc(r0, r2, r4, r13)
            r6.zzb = r2
            goto L_0x026c
        L_0x02d7:
            r7 = 1684366131(0x64656333, float:1.692581E22)
            if (r2 != r7) goto L_0x02ec
            int r2 = r8 + 8
            r0.zzL(r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            com.google.android.gms.internal.ads.zzad r2 = com.google.android.gms.internal.ads.zzabr.zzd(r0, r2, r4, r13)
            r6.zzb = r2
            goto L_0x026c
        L_0x02ec:
            r7 = 1684103988(0x64616334, float:1.6630663E22)
            if (r2 != r7) goto L_0x033c
            int r2 = r8 + 8
            r0.zzL(r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            int r7 = com.google.android.gms.internal.ads.zzabu.zza
            r12 = 1
            r0.zzM(r12)
            int r7 = r0.zzm()
            r7 = r7 & 32
            com.google.android.gms.internal.ads.zzab r12 = new com.google.android.gms.internal.ads.zzab
            r12.<init>()
            r12.zzL(r2)
            r12.zzZ(r15)
            r2 = r21
            r12.zzz(r2)
            int r2 = r7 >> 5
            r7 = 1
            if (r7 == r2) goto L_0x031f
            r2 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0322
        L_0x031f:
            r2 = 48000(0xbb80, float:6.7262E-41)
        L_0x0322:
            r12.zzaa(r2)
            r12.zzF(r13)
            r12.zzP(r4)
            com.google.android.gms.internal.ads.zzad r2 = r12.zzaf()
            r6.zzb = r2
            r7 = r38
            r38 = r8
            r18 = r9
            r12 = 0
            r21 = 2
            goto L_0x0515
        L_0x033c:
            r7 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r2 != r7) goto L_0x0364
            if (r11 <= 0) goto L_0x0350
            r0 = r36
            r38 = r8
            r18 = r9
            r7 = r11
            r10 = 2
        L_0x034b:
            r12 = 0
            r21 = 2
            goto L_0x0517
        L_0x0350:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r7 = 0
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r7)
            throw r0
        L_0x0364:
            r7 = 0
            r12 = 1684305011(0x64647473, float:1.6856995E22)
            if (r2 == r12) goto L_0x043e
            r12 = 1969517683(0x75647473, float:2.8960097E32)
            if (r2 != r12) goto L_0x0371
            goto L_0x043e
        L_0x0371:
            r12 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r2 != r12) goto L_0x0396
            int r1 = r8 + 8
            int r2 = r9 + -8
            byte[] r12 = zzb
            int r7 = r12.length
            int r7 = r7 + r2
            byte[] r7 = java.util.Arrays.copyOf(r12, r7)
            r0.zzL(r1)
            int r1 = r12.length
            r0.zzH(r7, r1, r2)
            java.util.List r1 = com.google.android.gms.internal.ads.zzadm.zze(r7)
            r0 = r36
            r7 = r38
            r38 = r8
            r18 = r9
            goto L_0x034b
        L_0x0396:
            r7 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r2 != r7) goto L_0x03c6
            int r1 = r8 + 12
            int r2 = r9 + -12
            int r7 = r9 + -8
            byte[] r7 = new byte[r7]
            r12 = 102(0x66, float:1.43E-43)
            r18 = 0
            r7[r18] = r12
            r12 = 76
            r22 = 1
            r7[r22] = r12
            r12 = 97
            r21 = 2
            r7[r21] = r12
            r12 = 67
            r7[r17] = r12
            r0.zzL(r1)
            r12 = 4
            r0.zzH(r7, r12, r2)
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzo(r7)
            goto L_0x0261
        L_0x03c6:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 4
            r21 = 2
            if (r2 != r7) goto L_0x0420
            int r1 = r8 + 12
            int r2 = r9 + -12
            byte[] r10 = new byte[r2]
            r0.zzL(r1)
            r1 = 0
            r0.zzH(r10, r1, r2)
            int r1 = com.google.android.gms.internal.ads.zzdd.zza
            com.google.android.gms.internal.ads.zzed r1 = new com.google.android.gms.internal.ads.zzed
            r1.<init>((byte[]) r10)
            r2 = 9
            r1.zzL(r2)
            int r2 = r1.zzm()
            r7 = 20
            r1.zzL(r7)
            int r1 = r1.zzp()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            android.util.Pair r1 = android.util.Pair.create(r1, r2)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzfzo r7 = com.google.android.gms.internal.ads.zzfzo.zzo(r10)
            r0 = r36
            r10 = r1
            r1 = r7
            r38 = r8
            r18 = r9
            r12 = 0
            r7 = r2
            goto L_0x0517
        L_0x0420:
            r7 = 1767990114(0x69616362, float:1.7029852E25)
            if (r2 != r7) goto L_0x026c
            int r1 = r8 + 9
            r0.zzL(r1)
            long r1 = r0.zzv()
            int r1 = com.google.android.gms.internal.ads.zzgcr.zzb(r1)
            byte[] r2 = new byte[r1]
            r7 = 0
            r0.zzH(r2, r7, r1)
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzo(r2)
            goto L_0x0261
        L_0x043e:
            r12 = 4
            r21 = 2
            com.google.android.gms.internal.ads.zzab r2 = new com.google.android.gms.internal.ads.zzab
            r2.<init>()
            r2.zzK(r3)
            r2.zzZ(r5)
            r2.zzz(r10)
            r7 = r38
            r2.zzaa(r7)
            r2.zzF(r13)
            r2.zzP(r4)
            com.google.android.gms.internal.ads.zzad r2 = r2.zzaf()
            r6.zzb = r2
            goto L_0x026e
        L_0x0462:
            r7 = r38
            r2 = r8
        L_0x0465:
            r12 = -1
            if (r2 == r12) goto L_0x026e
            com.google.android.gms.internal.ads.zzaie r16 = zzl(r0, r2)
            java.lang.String r2 = r16.zza
            byte[] r5 = r16.zzb
            if (r5 == 0) goto L_0x050c
            java.lang.String r1 = "audio/vorbis"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x04ed
            com.google.android.gms.internal.ads.zzed r1 = new com.google.android.gms.internal.ads.zzed
            r1.<init>((byte[]) r5)
            r12 = 1
            r1.zzM(r12)
            r27 = 0
        L_0x0489:
            int r22 = r1.zzb()
            r12 = 255(0xff, float:3.57E-43)
            if (r22 <= 0) goto L_0x04a5
            int r0 = r1.zzf()
            if (r0 != r12) goto L_0x04a5
            r0 = 1
            r1.zzM(r0)
            r0 = r27
            int r0 = r0 + 255
            r27 = r0
            r12 = 1
            r0 = r29
            goto L_0x0489
        L_0x04a5:
            r0 = r27
            int r24 = r1.zzm()
            int r0 = r0 + r24
            r28 = 0
        L_0x04af:
            int r24 = r1.zzb()
            r38 = r8
            if (r24 <= 0) goto L_0x04ca
            int r8 = r1.zzf()
            if (r8 != r12) goto L_0x04ca
            r8 = 1
            r1.zzM(r8)
            r8 = r28
            int r8 = r8 + 255
            r28 = r8
            r8 = r38
            goto L_0x04af
        L_0x04ca:
            r8 = r28
            int r12 = r1.zzm()
            int r28 = r8 + r12
            byte[] r8 = new byte[r0]
            int r1 = r1.zzd()
            r12 = 0
            java.lang.System.arraycopy(r5, r1, r8, r12, r0)
            int r1 = r1 + r0
            int r0 = r5.length
            int r1 = r1 + r28
            int r0 = r0 - r1
            r18 = r9
            byte[] r9 = new byte[r0]
            java.lang.System.arraycopy(r5, r1, r9, r12, r0)
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzp(r8, r9)
            goto L_0x0511
        L_0x04ed:
            r38 = r8
            r18 = r9
            r12 = 0
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0505
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzabo.zza(r5)
            int r7 = r0.zza
            int r10 = r0.zzb
            java.lang.String r0 = r0.zzc
            goto L_0x0507
        L_0x0505:
            r0 = r36
        L_0x0507:
            com.google.android.gms.internal.ads.zzfzo r1 = com.google.android.gms.internal.ads.zzfzo.zzo(r5)
            goto L_0x0513
        L_0x050c:
            r38 = r8
            r18 = r9
            r12 = 0
        L_0x0511:
            r0 = r36
        L_0x0513:
            r5 = r2
            goto L_0x0517
        L_0x0515:
            r0 = r36
        L_0x0517:
            int r8 = r38 + r18
            r2 = r32
            r12 = r0
            r0 = r29
            goto L_0x01bd
        L_0x0520:
            r36 = r12
            com.google.android.gms.internal.ads.zzad r0 = r6.zzb
            if (r0 != 0) goto L_0x056a
            if (r5 == 0) goto L_0x056a
            com.google.android.gms.internal.ads.zzab r0 = new com.google.android.gms.internal.ads.zzab
            r0.<init>()
            r0.zzK(r3)
            r0.zzZ(r5)
            r2 = r36
            r0.zzA(r2)
            r0.zzz(r10)
            r0.zzaa(r7)
            r9 = r23
            r0.zzT(r9)
            r0.zzM(r1)
            r0.zzF(r13)
            r0.zzP(r4)
            if (r16 == 0) goto L_0x0564
            long r1 = r16.zzc
            int r1 = com.google.android.gms.internal.ads.zzgcr.zze(r1)
            r0.zzy(r1)
            long r1 = r16.zzd
            int r1 = com.google.android.gms.internal.ads.zzgcr.zze(r1)
            r0.zzU(r1)
        L_0x0564:
            com.google.android.gms.internal.ads.zzad r0 = r0.zzaf()
            r6.zzb = r0
        L_0x056a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zzn(com.google.android.gms.internal.ads.zzed, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzw, com.google.android.gms.internal.ads.zzaii, int):void");
    }
}
