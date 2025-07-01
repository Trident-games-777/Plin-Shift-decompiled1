package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaku implements zzaki {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf = new Canvas();
    private final zzakn zzg = new zzakn(719, 575, 0, 719, 0, 575);
    private final zzakm zzh = new zzakm(0, zzg(), zzh(), zzi());
    private final zzakt zzi;
    private Bitmap zzj;

    public zzaku(List list) {
        zzed zzed = new zzed((byte[]) list.get(0));
        int zzq = zzed.zzq();
        int zzq2 = zzed.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.zzi = new zzakt(zzq, zzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakm zzc(zzec zzec, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        zzec zzec2 = zzec;
        int i6 = 8;
        int zzd2 = zzec2.zzd(8);
        zzec2.zzn(8);
        int[] zzg2 = zzg();
        int[] zzh2 = zzh();
        int[] zzi2 = zzi();
        int i7 = i - 2;
        while (i7 > 0) {
            int zzd3 = zzec2.zzd(i6);
            int zzd4 = zzec2.zzd(i6);
            int[] iArr = (zzd4 & 128) != 0 ? zzg2 : (zzd4 & 64) != 0 ? zzh2 : zzi2;
            if ((zzd4 & 1) != 0) {
                i5 = zzec2.zzd(i6);
                i4 = zzec2.zzd(i6);
                i3 = zzec2.zzd(i6);
                i2 = zzec2.zzd(i6);
                i7 -= 6;
            } else {
                int zzd5 = zzec2.zzd(2) << 6;
                i7 -= 4;
                i3 = zzec2.zzd(4) << 4;
                i2 = zzd5;
                i5 = zzec2.zzd(6) << 2;
                i4 = zzec2.zzd(4) << 4;
            }
            if (i5 == 0) {
                i2 = 255;
            }
            if (i5 == 0) {
                i3 = 0;
            }
            if (i5 == 0) {
                i4 = 0;
            }
            double d = (double) i5;
            double d2 = (double) (i4 - 128);
            double d3 = (double) (i3 - 128);
            iArr[zzd3] = zzb((byte) (255 - (i2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            zzd2 = zzd2;
            i6 = 8;
        }
        return new zzakm(zzd2, zzg2, zzh2, zzi2);
    }

    private static zzako zzd(zzec zzec) {
        int zzd2 = zzec.zzd(16);
        zzec.zzn(4);
        int zzd3 = zzec.zzd(2);
        boolean zzp = zzec.zzp();
        zzec.zzn(1);
        byte[] bArr = zzen.zzf;
        byte[] bArr2 = zzen.zzf;
        if (zzd3 == 1) {
            zzec.zzn(zzec.zzd(8) * 16);
        } else if (zzd3 == 0) {
            int zzd4 = zzec.zzd(16);
            int zzd5 = zzec.zzd(16);
            if (zzd4 > 0) {
                bArr = new byte[zzd4];
                zzec.zzi(bArr, 0, zzd4);
            }
            if (zzd5 > 0) {
                bArr2 = new byte[zzd5];
                zzec.zzi(bArr2, 0, zzd5);
            } else {
                bArr2 = bArr;
            }
        }
        return new zzako(zzd2, zzp, bArr, bArr2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v25, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r5v6, types: [byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01fe A[LOOP:3: B:86:0x0163->B:118:0x01fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01fa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zze(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            r0 = r22
            r1 = r24
            r7 = r27
            com.google.android.gms.internal.ads.zzec r8 = new com.google.android.gms.internal.ads.zzec
            int r2 = r0.length
            r8.<init>(r0, r2)
            r2 = r25
            r9 = r26
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0013:
            int r3 = r8.zza()
            if (r3 == 0) goto L_0x020d
            r13 = 8
            int r3 = r8.zzd(r13)
            r4 = 240(0xf0, float:3.36E-43)
            if (r3 == r4) goto L_0x0205
            r14 = 3
            r15 = 4
            r4 = 1
            r5 = 2
            r16 = 0
            switch(r3) {
                case 16: goto L_0x0147;
                case 17: goto L_0x0099;
                case 18: goto L_0x0041;
                default: goto L_0x002c;
            }
        L_0x002c:
            switch(r3) {
                case 32: goto L_0x003c;
                case 33: goto L_0x0037;
                case 34: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0013
        L_0x0030:
            r3 = 16
            byte[] r11 = zzf(r3, r13, r8)
            goto L_0x0013
        L_0x0037:
            byte[] r10 = zzf(r15, r13, r8)
            goto L_0x0013
        L_0x003c:
            byte[] r12 = zzf(r15, r15, r8)
            goto L_0x0013
        L_0x0041:
            r14 = r2
            r2 = r16
        L_0x0044:
            int r3 = r8.zzd(r13)
            if (r3 == 0) goto L_0x004e
            r15 = r2
            r17 = r4
            goto L_0x0073
        L_0x004e:
            boolean r3 = r8.zzp()
            r5 = 7
            if (r3 != 0) goto L_0x0067
            int r3 = r8.zzd(r5)
            if (r3 == 0) goto L_0x0061
            r15 = r2
            r17 = r3
            r3 = r16
            goto L_0x0073
        L_0x0061:
            r15 = r4
            r3 = r16
            r17 = r3
            goto L_0x0073
        L_0x0067:
            int r3 = r8.zzd(r5)
            int r5 = r8.zzd(r13)
            r15 = r2
            r17 = r3
            r3 = r5
        L_0x0073:
            if (r17 == 0) goto L_0x008e
            if (r7 == 0) goto L_0x008e
            int r2 = r9 + 1
            r5 = r4
            float r4 = (float) r9
            r3 = r23[r3]
            r7.setColor(r3)
            float r3 = (float) r14
            int r6 = r14 + r17
            float r6 = (float) r6
            float r2 = (float) r2
            r0 = r5
            r5 = r6
            r6 = r2
            r2 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x008f
        L_0x008e:
            r0 = r4
        L_0x008f:
            int r14 = r14 + r17
            if (r15 != 0) goto L_0x0096
            r4 = r0
            r2 = r15
            goto L_0x0044
        L_0x0096:
            r2 = r14
            goto L_0x0013
        L_0x0099:
            r0 = r4
            if (r1 != r14) goto L_0x00a6
            if (r11 != 0) goto L_0x00a3
            byte[] r3 = zzc
            r17 = r3
            goto L_0x00a8
        L_0x00a3:
            r17 = r11
            goto L_0x00a8
        L_0x00a6:
            r17 = 0
        L_0x00a8:
            r4 = r16
        L_0x00aa:
            int r3 = r8.zzd(r15)
            if (r3 == 0) goto L_0x00b6
            r18 = r0
            r19 = r4
            goto L_0x0114
        L_0x00b6:
            boolean r3 = r8.zzp()
            if (r3 != 0) goto L_0x00d2
            int r3 = r8.zzd(r14)
            if (r3 == 0) goto L_0x00cb
            int r3 = r3 + 2
            r18 = r3
        L_0x00c6:
            r19 = r4
        L_0x00c8:
            r3 = r16
            goto L_0x0114
        L_0x00cb:
            r19 = r0
        L_0x00cd:
            r3 = r16
            r18 = r3
            goto L_0x0114
        L_0x00d2:
            boolean r3 = r8.zzp()
            if (r3 != 0) goto L_0x00e7
            int r3 = r8.zzd(r5)
            int r3 = r3 + r15
            int r6 = r8.zzd(r15)
        L_0x00e1:
            r18 = r3
            r19 = r4
            r3 = r6
            goto L_0x0114
        L_0x00e7:
            int r3 = r8.zzd(r5)
            if (r3 == 0) goto L_0x0111
            if (r3 == r0) goto L_0x010c
            if (r3 == r5) goto L_0x0101
            if (r3 == r14) goto L_0x00f6
            r19 = r4
            goto L_0x00cd
        L_0x00f6:
            int r3 = r8.zzd(r13)
            int r3 = r3 + 25
            int r6 = r8.zzd(r15)
            goto L_0x00e1
        L_0x0101:
            int r3 = r8.zzd(r15)
            int r3 = r3 + 9
            int r6 = r8.zzd(r15)
            goto L_0x00e1
        L_0x010c:
            r19 = r4
            r18 = r5
            goto L_0x00c8
        L_0x0111:
            r18 = r0
            goto L_0x00c6
        L_0x0114:
            if (r18 == 0) goto L_0x0135
            if (r7 == 0) goto L_0x0135
            int r4 = r9 + 1
            float r6 = (float) r9
            if (r17 == 0) goto L_0x011f
            byte r3 = r17[r3]
        L_0x011f:
            float r4 = (float) r4
            r3 = r23[r3]
            r7.setColor(r3)
            float r3 = (float) r2
            int r5 = r2 + r18
            float r5 = (float) r5
            r15 = r6
            r6 = r4
            r4 = r15
            r20 = r2
            r15 = 2
            r2 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x0138
        L_0x0135:
            r20 = r2
            r15 = r5
        L_0x0138:
            int r2 = r20 + r18
            if (r19 == 0) goto L_0x0141
            r8.zzf()
            goto L_0x0013
        L_0x0141:
            r5 = r15
            r4 = r19
            r15 = 4
            goto L_0x00aa
        L_0x0147:
            r0 = r4
            r15 = r5
            if (r1 != r14) goto L_0x0155
            if (r10 != 0) goto L_0x0152
            byte[] r3 = zzb
        L_0x014f:
            r17 = r3
            goto L_0x0161
        L_0x0152:
            r17 = r10
            goto L_0x0161
        L_0x0155:
            if (r1 != r15) goto L_0x015f
            if (r12 != 0) goto L_0x015c
            byte[] r3 = zza
            goto L_0x014f
        L_0x015c:
            r17 = r12
            goto L_0x0161
        L_0x015f:
            r17 = 0
        L_0x0161:
            r4 = r16
        L_0x0163:
            int r3 = r8.zzd(r15)
            if (r3 == 0) goto L_0x0171
            r18 = r0
            r5 = r3
        L_0x016c:
            r19 = r4
        L_0x016e:
            r3 = 4
            goto L_0x01ce
        L_0x0171:
            boolean r3 = r8.zzp()
            if (r3 == 0) goto L_0x0183
            int r3 = r8.zzd(r14)
            int r3 = r3 + r14
            int r5 = r8.zzd(r15)
        L_0x0180:
            r18 = r3
            goto L_0x016c
        L_0x0183:
            boolean r3 = r8.zzp()
            if (r3 == 0) goto L_0x0190
            r18 = r0
            r19 = r4
            r5 = r16
            goto L_0x016e
        L_0x0190:
            int r3 = r8.zzd(r15)
            if (r3 == 0) goto L_0x01c7
            if (r3 == r0) goto L_0x01bf
            if (r3 == r15) goto L_0x01ae
            if (r3 == r14) goto L_0x01a3
            r19 = r4
            r5 = r16
            r18 = r5
            goto L_0x016e
        L_0x01a3:
            int r3 = r8.zzd(r13)
            int r3 = r3 + 29
            int r5 = r8.zzd(r15)
            goto L_0x0180
        L_0x01ae:
            r3 = 4
            int r5 = r8.zzd(r3)
            int r5 = r5 + 12
            int r6 = r8.zzd(r15)
            r19 = r4
            r18 = r5
            r5 = r6
            goto L_0x01ce
        L_0x01bf:
            r3 = 4
            r19 = r4
            r18 = r15
            r5 = r16
            goto L_0x01ce
        L_0x01c7:
            r3 = 4
            r19 = r0
            r5 = r16
            r18 = r5
        L_0x01ce:
            if (r18 == 0) goto L_0x01f3
            if (r7 == 0) goto L_0x01f3
            int r4 = r9 + 1
            float r6 = (float) r9
            if (r17 == 0) goto L_0x01d9
            byte r5 = r17[r5]
        L_0x01d9:
            float r4 = (float) r4
            r5 = r23[r5]
            r7.setColor(r5)
            r5 = r3
            float r3 = (float) r2
            int r0 = r2 + r18
            float r0 = (float) r0
            r21 = r6
            r6 = r4
            r4 = r21
            r21 = r5
            r5 = r0
            r0 = r2
            r2 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x01f6
        L_0x01f3:
            r0 = r2
            r21 = r3
        L_0x01f6:
            int r2 = r0 + r18
            if (r19 == 0) goto L_0x01fe
            r8.zzf()
            goto L_0x0209
        L_0x01fe:
            r7 = r27
            r4 = r19
            r0 = 1
            goto L_0x0163
        L_0x0205:
            int r9 = r9 + 2
            r2 = r25
        L_0x0209:
            r7 = r27
            goto L_0x0013
        L_0x020d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaku.zze(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzf(int i, int i2, zzec zzec) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzec.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                int i5 = 127;
                int i6 = 1 != i4 ? 0 : 127;
                int i7 = i3 != 0 ? 127 : 0;
                if (i2 == 0) {
                    i5 = 0;
                }
                iArr[i] = zzb(255, i6, i7, i5);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = 255;
            if (i < 8) {
                int i3 = i & 2;
                int i4 = i & 4;
                int i5 = 1 != (i & 1) ? 0 : 255;
                int i6 = i3 != 0 ? 255 : 0;
                if (i4 == 0) {
                    i2 = 0;
                }
                iArr[i] = zzb(63, i5, i6, i2);
            } else {
                int i7 = i & 136;
                int i8 = 170;
                int i9 = 85;
                if (i7 == 0) {
                    int i10 = i & 16;
                    int i11 = i & 32;
                    int i12 = i & 2;
                    int i13 = i & 64;
                    int i14 = i & 4;
                    int i15 = 1 != (i & 1) ? 0 : 85;
                    int i16 = i10 != 0 ? 170 : 0;
                    int i17 = i12 != 0 ? 85 : 0;
                    int i18 = i11 != 0 ? 170 : 0;
                    if (i14 == 0) {
                        i9 = 0;
                    }
                    if (i13 == 0) {
                        i8 = 0;
                    }
                    iArr[i] = zzb(255, i15 + i16, i17 + i18, i9 + i8);
                } else if (i7 != 8) {
                    int i19 = 43;
                    if (i7 == 128) {
                        int i20 = i & 16;
                        int i21 = i & 32;
                        int i22 = i & 2;
                        int i23 = i & 64;
                        int i24 = i & 4;
                        int i25 = (1 != (i & 1) ? 0 : 43) + 127;
                        int i26 = i20 != 0 ? 85 : 0;
                        int i27 = (i22 != 0 ? 43 : 0) + 127;
                        int i28 = i21 != 0 ? 85 : 0;
                        if (i24 == 0) {
                            i19 = 0;
                        }
                        int i29 = i19 + 127;
                        if (i23 == 0) {
                            i9 = 0;
                        }
                        iArr[i] = zzb(255, i25 + i26, i27 + i28, i29 + i9);
                    } else if (i7 == 136) {
                        int i30 = i & 16;
                        int i31 = i & 32;
                        int i32 = i & 2;
                        int i33 = i & 64;
                        int i34 = i & 4;
                        int i35 = 1 != (i & 1) ? 0 : 43;
                        int i36 = i30 != 0 ? 85 : 0;
                        int i37 = i32 != 0 ? 43 : 0;
                        int i38 = i31 != 0 ? 85 : 0;
                        if (i34 == 0) {
                            i19 = 0;
                        }
                        if (i33 == 0) {
                            i9 = 0;
                        }
                        iArr[i] = zzb(255, i35 + i36, i37 + i38, i19 + i9);
                    }
                } else {
                    int i39 = i & 16;
                    int i40 = i & 32;
                    int i41 = i & 2;
                    int i42 = i & 64;
                    int i43 = i & 4;
                    int i44 = 1 != (i & 1) ? 0 : 85;
                    int i45 = i39 != 0 ? 170 : 0;
                    int i46 = i41 != 0 ? 85 : 0;
                    int i47 = i40 != 0 ? 170 : 0;
                    if (i43 == 0) {
                        i9 = 0;
                    }
                    if (i42 == 0) {
                        i8 = 0;
                    }
                    iArr[i] = zzb(127, i44 + i45, i46 + i47, i9 + i8);
                }
            }
        }
        return iArr;
    }

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        boolean z;
        zzaka zzaka;
        float f;
        float f2;
        char c;
        int i3;
        Paint paint;
        int[] iArr;
        zzakr zzakr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        zzec zzec = new zzec(bArr, i10 + i2);
        zzec.zzl(i10);
        while (true) {
            z = true;
            if (zzec.zza() < 48 || zzec.zzd(8) != 15) {
                zzakt zzakt = this.zzi;
                zzakp zzakp = zzakt.zzi;
            } else {
                zzakt zzakt2 = this.zzi;
                int zzd2 = zzec.zzd(8);
                int zzd3 = zzec.zzd(16);
                int zzd4 = zzec.zzd(16);
                int zzb2 = zzec.zzb() + zzd4;
                if (zzd4 * 8 > zzec.zza()) {
                    zzdt.zzf("DvbParser", "Data field length exceeds limit");
                    zzec.zzn(zzec.zza());
                } else {
                    switch (zzd2) {
                        case 16:
                            if (zzd3 == zzakt2.zza) {
                                zzakp zzakp2 = zzakt2.zzi;
                                int zzd5 = zzec.zzd(8);
                                int zzd6 = zzec.zzd(4);
                                int zzd7 = zzec.zzd(2);
                                zzec.zzn(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i11 = zzd4 - 2; i11 > 0; i11 -= 6) {
                                    int zzd8 = zzec.zzd(8);
                                    zzec.zzn(8);
                                    sparseArray.put(zzd8, new zzakq(zzec.zzd(16), zzec.zzd(16)));
                                }
                                zzakp zzakp3 = new zzakp(zzd5, zzd6, zzd7, sparseArray);
                                if (zzakp3.zzb == 0) {
                                    if (!(zzakp2 == null || zzakp2.zza == zzakp3.zza)) {
                                        zzakt2.zzi = zzakp3;
                                        break;
                                    }
                                } else {
                                    zzakt2.zzi = zzakp3;
                                    zzakt2.zzc.clear();
                                    zzakt2.zzd.clear();
                                    zzakt2.zze.clear();
                                    break;
                                }
                            }
                            break;
                        case 17:
                            zzakp zzakp4 = zzakt2.zzi;
                            if (zzd3 == zzakt2.zza && zzakp4 != null) {
                                int zzd9 = zzec.zzd(8);
                                zzec.zzn(4);
                                boolean zzp = zzec.zzp();
                                zzec.zzn(3);
                                int zzd10 = zzec.zzd(16);
                                int zzd11 = zzec.zzd(16);
                                int zzd12 = zzec.zzd(3);
                                int zzd13 = zzec.zzd(3);
                                zzec.zzn(2);
                                int zzd14 = zzec.zzd(8);
                                int zzd15 = zzec.zzd(8);
                                int zzd16 = zzec.zzd(4);
                                int zzd17 = zzec.zzd(2);
                                zzec.zzn(2);
                                int i12 = zzd4 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i12 > 0) {
                                    int zzd18 = zzec.zzd(16);
                                    int zzd19 = zzec.zzd(2);
                                    int zzd20 = zzec.zzd(2);
                                    int zzd21 = zzec.zzd(12);
                                    zzec.zzn(4);
                                    int zzd22 = zzec.zzd(12);
                                    int i13 = i12 - 6;
                                    if (zzd19 != 1) {
                                        if (zzd19 == 2) {
                                            zzd19 = 2;
                                        } else {
                                            i12 = i13;
                                            i5 = 0;
                                            i4 = 0;
                                            sparseArray2.put(zzd18, new zzaks(zzd19, zzd20, zzd21, zzd22, i5, i4));
                                        }
                                    }
                                    i12 -= 8;
                                    i5 = zzec.zzd(8);
                                    i4 = zzec.zzd(8);
                                    sparseArray2.put(zzd18, new zzaks(zzd19, zzd20, zzd21, zzd22, i5, i4));
                                }
                                zzakr zzakr2 = new zzakr(zzd9, zzp, zzd10, zzd11, zzd12, zzd13, zzd14, zzd15, zzd16, zzd17, sparseArray2);
                                if (zzakp4.zzb == 0 && (zzakr = (zzakr) zzakt2.zzc.get(zzakr2.zza)) != null) {
                                    int i14 = 0;
                                    while (true) {
                                        SparseArray sparseArray3 = zzakr.zzj;
                                        if (i14 < sparseArray3.size()) {
                                            zzakr2.zzj.put(sparseArray3.keyAt(i14), (zzaks) sparseArray3.valueAt(i14));
                                            i14++;
                                        }
                                    }
                                }
                                zzakt2.zzc.put(zzakr2.zza, zzakr2);
                                break;
                            }
                        case 18:
                            if (zzd3 != zzakt2.zza) {
                                if (zzd3 == zzakt2.zzb) {
                                    zzakm zzc2 = zzc(zzec, zzd4);
                                    zzakt2.zzf.put(zzc2.zza, zzc2);
                                    break;
                                }
                            } else {
                                zzakm zzc3 = zzc(zzec, zzd4);
                                zzakt2.zzd.put(zzc3.zza, zzc3);
                                break;
                            }
                            break;
                        case 19:
                            if (zzd3 != zzakt2.zza) {
                                if (zzd3 == zzakt2.zzb) {
                                    zzako zzd23 = zzd(zzec);
                                    zzakt2.zzg.put(zzd23.zza, zzd23);
                                    break;
                                }
                            } else {
                                zzako zzd24 = zzd(zzec);
                                zzakt2.zze.put(zzd24.zza, zzd24);
                                break;
                            }
                            break;
                        case 20:
                            if (zzd3 == zzakt2.zza) {
                                zzec.zzn(4);
                                boolean zzp2 = zzec.zzp();
                                zzec.zzn(3);
                                int zzd25 = zzec.zzd(16);
                                int zzd26 = zzec.zzd(16);
                                if (zzp2) {
                                    int zzd27 = zzec.zzd(16);
                                    i8 = zzec.zzd(16);
                                    i7 = zzec.zzd(16);
                                    i6 = zzec.zzd(16);
                                    i9 = zzd27;
                                } else {
                                    i8 = zzd25;
                                    i6 = zzd26;
                                    i9 = 0;
                                    i7 = 0;
                                }
                                zzakt2.zzh = new zzakn(zzd25, zzd26, i9, i8, i7, i6);
                                break;
                            }
                            break;
                    }
                    zzec.zzo(zzb2 - zzec.zzb());
                }
            }
        }
        zzakt zzakt3 = this.zzi;
        zzakp zzakp5 = zzakt3.zzi;
        if (zzakp5 == null) {
            zzaka = new zzaka(zzfzo.zzn(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakn zzakn = zzakt3.zzh;
            if (zzakn == null) {
                zzakn = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (!(bitmap != null && zzakn.zza + 1 == bitmap.getWidth() && zzakn.zzb + 1 == this.zzj.getHeight())) {
                Bitmap createBitmap = Bitmap.createBitmap(zzakn.zza + 1, zzakn.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = createBitmap;
                this.zzf.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakp5.zzc;
            int i15 = 0;
            while (i15 < sparseArray4.size()) {
                this.zzf.save();
                zzakq zzakq = (zzakq) sparseArray4.valueAt(i15);
                zzakr zzakr3 = (zzakr) this.zzi.zzc.get(sparseArray4.keyAt(i15));
                int i16 = zzakq.zza + zzakn.zzc;
                int i17 = zzakq.zzb + zzakn.zze;
                this.zzf.clipRect(i16, i17, Math.min(zzakr3.zzc + i16, zzakn.zzd), Math.min(zzakr3.zzd + i17, zzakn.zzf));
                zzakm zzakm = (zzakm) this.zzi.zzd.get(zzakr3.zzf);
                if (zzakm == null) {
                    zzakm = (zzakm) this.zzi.zzf.get(zzakr3.zzf);
                    if (zzakm == null) {
                        zzakm = this.zzh;
                    }
                }
                SparseArray sparseArray5 = zzakr3.zzj;
                int i18 = 0;
                while (i18 < sparseArray5.size()) {
                    int keyAt = sparseArray5.keyAt(i18);
                    boolean z2 = z;
                    zzaks zzaks = (zzaks) sparseArray5.valueAt(i18);
                    zzako zzako = (zzako) this.zzi.zze.get(keyAt);
                    if (zzako == null) {
                        zzako = (zzako) this.zzi.zzg.get(keyAt);
                    }
                    if (zzako != null) {
                        if (zzako.zzb) {
                            paint = null;
                        } else {
                            paint = this.zzd;
                        }
                        Paint paint2 = paint;
                        int i19 = zzakr3.zze;
                        int i20 = i16 + zzaks.zza;
                        int i21 = i17 + zzaks.zzb;
                        Canvas canvas = this.zzf;
                        if (i19 == 3) {
                            iArr = zzakm.zzd;
                        } else if (i19 == 2) {
                            iArr = zzakm.zzc;
                        } else {
                            iArr = zzakm.zzb;
                        }
                        int[] iArr2 = iArr;
                        Canvas canvas2 = canvas;
                        int i22 = i19;
                        zze(zzako.zzc, iArr2, i22, i20, i21, paint2, canvas2);
                        zze(zzako.zzd, iArr2, i22, i20, i21 + 1, paint2, canvas2);
                    }
                    i18++;
                    z = z2;
                }
                boolean z3 = z;
                float f3 = (float) i17;
                float f4 = (float) i16;
                if (zzakr3.zzb) {
                    int i23 = zzakr3.zze;
                    if (i23 == 3) {
                        i3 = zzakm.zzd[zzakr3.zzg];
                        c = 2;
                    } else {
                        c = 2;
                        if (i23 == 2) {
                            i3 = zzakm.zzc[zzakr3.zzh];
                        } else {
                            i3 = zzakm.zzb[zzakr3.zzi];
                        }
                    }
                    this.zze.setColor(i3);
                    f = f3;
                    f2 = f4;
                    this.zzf.drawRect(f2, f, (float) (zzakr3.zzc + i16), (float) (zzakr3.zzd + i17), this.zze);
                } else {
                    f = f3;
                    f2 = f4;
                    c = 2;
                }
                zzcr zzcr = new zzcr();
                zzcr.zzc(Bitmap.createBitmap(this.zzj, i16, i17, zzakr3.zzc, zzakr3.zzd));
                zzcr.zzh(f2 / ((float) zzakn.zza));
                zzcr.zzi(0);
                zzcr.zze(f / ((float) zzakn.zzb), 0);
                zzcr.zzf(0);
                zzcr.zzk(((float) zzakr3.zzc) / ((float) zzakn.zza));
                zzcr.zzd(((float) zzakr3.zzd) / ((float) zzakn.zzb));
                arrayList.add(zzcr.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i15++;
                z = z3;
                char c2 = c;
            }
            zzaka = new zzaka(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdg.zza(zzaka);
    }
}
