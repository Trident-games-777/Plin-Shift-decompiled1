package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.ViewUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzand {
    public static zzanb zza(zzec zzec) throws zzbh {
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        char c2;
        int i5;
        zzec zzec2 = zzec;
        int zzd = zzec2.zzd(8);
        int i6 = 5;
        int zzd2 = zzec2.zzd(5);
        if (zzd2 == 31) {
            i = zzec2.zzd(24);
        } else {
            switch (zzd2) {
                case 0:
                    i = 96000;
                    break;
                case 1:
                    i = 88200;
                    break;
                case 2:
                    i = 64000;
                    break;
                case 3:
                    i = 48000;
                    break;
                case 4:
                    i = 44100;
                    break;
                case 5:
                    i = 32000;
                    break;
                case 6:
                    i = 24000;
                    break;
                case 7:
                    i = 22050;
                    break;
                case 8:
                    i = 16000;
                    break;
                case 9:
                    i = 12000;
                    break;
                case 10:
                    i = 11025;
                    break;
                case 11:
                    i = 8000;
                    break;
                case 12:
                    i = 7350;
                    break;
                case 15:
                    i = 57600;
                    break;
                case 16:
                    i = 51200;
                    break;
                case 17:
                    i = 40000;
                    break;
                case 18:
                    i = 38400;
                    break;
                case 19:
                    i = 34150;
                    break;
                case 20:
                    i = 28800;
                    break;
                case 21:
                    i = 25600;
                    break;
                case 22:
                    i = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
                    break;
                case 23:
                    i = 19200;
                    break;
                case 24:
                    i = 17075;
                    break;
                case 25:
                    i = 14400;
                    break;
                case 26:
                    i = 12800;
                    break;
                case 27:
                    i = 9600;
                    break;
                default:
                    throw zzbh.zzc("Unsupported sampling rate index " + zzd2);
            }
        }
        int zzd3 = zzec2.zzd(3);
        int i7 = 1;
        if (zzd3 == 0) {
            i2 = ViewUtils.EDGE_TO_EDGE_FLAGS;
        } else if (zzd3 == 1) {
            i2 = 1024;
        } else if (zzd3 == 2 || zzd3 == 3) {
            i2 = 2048;
        } else if (zzd3 == 4) {
            i2 = 4096;
        } else {
            throw zzbh.zzc("Unsupported coreSbrFrameLengthIndex " + zzd3);
        }
        if (zzd3 == 0 || zzd3 == 1) {
            c = 0;
        } else if (zzd3 == 2) {
            c = 2;
        } else if (zzd3 == 3) {
            c = 3;
        } else if (zzd3 == 4) {
            c = 1;
        } else {
            throw zzbh.zzc("Unsupported coreSbrFrameLengthIndex " + zzd3);
        }
        zzec2.zzn(2);
        zze(zzec2);
        int zzd4 = zzec2.zzd(5);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = 16;
            if (i8 < zzd4 + 1) {
                int zzd5 = zzec2.zzd(3);
                i9 += zzc(zzec2, 5, 8, 16) + 1;
                if ((zzd5 == 0 || zzd5 == 2) && zzec2.zzp()) {
                    zze(zzec2);
                }
                i8++;
            } else {
                int zzc = zzc(zzec2, 4, 8, 16) + 1;
                zzec2.zzm();
                int i11 = 0;
                while (true) {
                    double d = 2.0d;
                    if (i11 < zzc) {
                        int zzd6 = zzec2.zzd(2);
                        if (zzd6 == 0) {
                            i4 = zzd;
                            i3 = i7;
                            zzf(zzec2);
                            if (c > 0) {
                                zzd(zzec2);
                            }
                        } else if (zzd6 == i7) {
                            i3 = i7;
                            if (zzf(zzec2)) {
                                zzec2.zzm();
                            }
                            if (c > 0) {
                                zzd(zzec2);
                                i5 = zzec2.zzd(2);
                                c2 = c;
                            } else {
                                i5 = 0;
                                c2 = 0;
                            }
                            if (i5 > 0) {
                                zzec2.zzn(6);
                                int zzd7 = zzec2.zzd(2);
                                zzec2.zzn(4);
                                if (zzec2.zzp()) {
                                    zzec2.zzn(i6);
                                }
                                if (i5 == 2 || i5 == 3) {
                                    zzec2.zzn(6);
                                }
                                if (zzd7 == 2) {
                                    zzec2.zzm();
                                }
                            }
                            i4 = zzd;
                            int floor = ((int) Math.floor(Math.log((double) (i9 - 1)) / Math.log(2.0d))) + 1;
                            int zzd8 = zzec2.zzd(2);
                            if (zzd8 > 0 && zzec2.zzp()) {
                                zzec2.zzn(floor);
                            }
                            if (zzec2.zzp()) {
                                zzec2.zzn(floor);
                            }
                            if (c2 == 0 && zzd8 == 0) {
                                zzec2.zzm();
                            }
                        } else if (zzd6 != 3) {
                            i4 = zzd;
                            i3 = i7;
                        } else {
                            zzc(zzec2, 4, 8, i10);
                            int zzc2 = zzc(zzec2, 4, 8, i10);
                            i3 = i7;
                            if (zzec2.zzp()) {
                                zzc(zzec2, 8, i10, 0);
                            }
                            zzec2.zzm();
                            if (zzc2 > 0) {
                                zzec2.zzn(zzc2 * 8);
                            }
                            i4 = zzd;
                        }
                        i11++;
                        zzd = i4;
                        i7 = i3;
                        i6 = 5;
                        i10 = 16;
                    } else {
                        int i12 = zzd;
                        int i13 = i7;
                        byte[] bArr = null;
                        if (zzec2.zzp()) {
                            int zzc3 = zzc(zzec2, 2, 4, 8) + 1;
                            for (int i14 = 0; i14 < zzc3; i14++) {
                                int zzc4 = zzc(zzec2, 4, 8, 16);
                                int zzc5 = zzc(zzec2, 4, 8, 16);
                                if (zzc4 == 7) {
                                    int zzd9 = zzec2.zzd(4) + 1;
                                    zzec2.zzn(4);
                                    byte[] bArr2 = new byte[zzd9];
                                    for (int i15 = 0; i15 < zzd9; i15++) {
                                        bArr2[i15] = (byte) zzec2.zzd(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzec2.zzn(zzc5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (i) {
                            case 14700:
                            case 16000:
                                d = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d = 1.5d;
                                break;
                            case 44100:
                            case 48000:
                            case 88200:
                            case 96000:
                                d = 1.0d;
                                break;
                            default:
                                throw zzbh.zzc("Unsupported sampling rate " + i);
                        }
                        return new zzanb(i12, (int) (((double) i) * d), (int) (((double) i2) * d), bArr3, (zzanc) null);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzb(com.google.android.gms.internal.ads.zzec r18, com.google.android.gms.internal.ads.zzana r19) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r0 = r18
            r1 = r19
            r0.zzb()
            r2 = 3
            r3 = 8
            int r2 = zzc(r0, r2, r3, r3)
            r1.zza = r2
            r4 = 0
            r5 = -1
            if (r2 == r5) goto L_0x00c4
            r2 = 2
            int r6 = java.lang.Math.max(r2, r3)
            r7 = 32
            int r6 = java.lang.Math.max(r6, r7)
            r8 = 63
            r9 = 1
            if (r6 > r8) goto L_0x0026
            r6 = r9
            goto L_0x0027
        L_0x0026:
            r6 = r4
        L_0x0027:
            com.google.android.gms.internal.ads.zzdb.zzd(r6)
            r10 = 3
            r12 = 255(0xff, double:1.26E-321)
            long r14 = com.google.android.gms.internal.ads.zzgcm.zza(r10, r12)
            r16 = r10
            r10 = 4294967296(0x100000000, double:2.121995791E-314)
            com.google.android.gms.internal.ads.zzgcm.zza(r14, r10)
            int r6 = r0.zza()
            r10 = -1
            if (r6 >= r2) goto L_0x0046
        L_0x0044:
            r14 = r10
            goto L_0x006f
        L_0x0046:
            long r14 = r0.zze(r2)
            int r6 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r6 != 0) goto L_0x006f
            int r6 = r0.zza()
            if (r6 >= r3) goto L_0x0055
            goto L_0x0044
        L_0x0055:
            long r14 = r0.zze(r3)
            long r16 = r14 + r16
            int r3 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x006d
            int r3 = r0.zza()
            if (r3 >= r7) goto L_0x0066
            goto L_0x0044
        L_0x0066:
            long r6 = r0.zze(r7)
            long r14 = r16 + r6
            goto L_0x006f
        L_0x006d:
            r14 = r16
        L_0x006f:
            r1.zzb = r14
            int r3 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x0076
            return r4
        L_0x0076:
            r6 = 16
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00b1
            r6 = 0
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x00a3
            int r3 = r1.zza
            r6 = 0
            if (r3 == r9) goto L_0x009c
            if (r3 == r2) goto L_0x0095
            r2 = 17
            if (r3 == r2) goto L_0x008e
            goto L_0x00a3
        L_0x008e:
            java.lang.String r0 = "AudioTruncation packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r6)
            throw r0
        L_0x0095:
            java.lang.String r0 = "Mpegh3daFrame packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r6)
            throw r0
        L_0x009c:
            java.lang.String r0 = "Mpegh3daConfig packet with invalid packet label 0"
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r6)
            throw r0
        L_0x00a3:
            r2 = 11
            r3 = 24
            int r0 = zzc(r0, r2, r3, r3)
            r1.zzc = r0
            if (r0 == r5) goto L_0x00b0
            return r9
        L_0x00b0:
            return r4
        L_0x00b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Contains sub-stream with an invalid packet label "
            r0.<init>(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zzc(r0)
            throw r0
        L_0x00c4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzand.zzb(com.google.android.gms.internal.ads.zzec, com.google.android.gms.internal.ads.zzana):boolean");
    }

    private static int zzc(zzec zzec, int i, int i2, int i3) {
        zzdb.zzd(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        zzgck.zza(zzgck.zza(i4, i5), 1 << i3);
        if (zzec.zza() < i) {
            return -1;
        }
        int zzd = zzec.zzd(i);
        if (zzd != i4) {
            return zzd;
        }
        if (zzec.zza() < i2) {
            return -1;
        }
        int zzd2 = zzec.zzd(i2);
        int i6 = zzd + zzd2;
        if (zzd2 != i5) {
            return i6;
        }
        if (zzec.zza() < i3) {
            return -1;
        }
        return i6 + zzec.zzd(i3);
    }

    private static void zzd(zzec zzec) {
        zzec.zzn(3);
        zzec.zzn(8);
        boolean zzp = zzec.zzp();
        boolean zzp2 = zzec.zzp();
        if (zzp) {
            zzec.zzn(5);
        }
        if (zzp2) {
            zzec.zzn(6);
        }
    }

    private static void zze(zzec zzec) {
        int i;
        int zzd = zzec.zzd(2);
        int i2 = 6;
        if (zzd == 0) {
            zzec.zzn(6);
            return;
        }
        int i3 = 5;
        int zzc = zzc(zzec, 5, 8, 16) + 1;
        if (zzd == 1) {
            zzec.zzn(zzc * 7);
        } else if (zzd == 2) {
            boolean zzp = zzec.zzp();
            int i4 = true != zzp ? 5 : 1;
            if (true == zzp) {
                i3 = 7;
            }
            if (true == zzp) {
                i2 = 8;
            }
            int i5 = 0;
            while (i5 < zzc) {
                if (zzec.zzp()) {
                    zzec.zzn(7);
                    i = 0;
                } else {
                    if (zzec.zzd(2) == 3 && zzec.zzd(i3) * i4 != 0) {
                        zzec.zzm();
                    }
                    i = zzec.zzd(i2) * i4;
                    if (!(i == 0 || i == 180)) {
                        zzec.zzm();
                    }
                    zzec.zzm();
                }
                if (!(i == 0 || i == 180 || !zzec.zzp())) {
                    i5++;
                }
                i5++;
            }
        }
    }

    private static boolean zzf(zzec zzec) {
        zzec.zzn(3);
        boolean zzp = zzec.zzp();
        if (zzp) {
            zzec.zzn(13);
        }
        return zzp;
    }
}
