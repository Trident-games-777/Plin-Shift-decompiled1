package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzadg {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final float zzi;
    public final int zzj;
    public final String zzk;
    public final zzfm zzl;

    private zzadg(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, int i10, String str, zzfm zzfm) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = f;
        this.zzj = i10;
        this.zzk = str;
        this.zzl = zzfm;
    }

    public static zzadg zza(zzed zzed) throws zzbh {
        return zzc(zzed, false, (zzfm) null);
    }

    public static zzadg zzb(zzed zzed, zzfm zzfm) throws zzbh {
        return zzc(zzed, true, zzfm);
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzadg zzc(com.google.android.gms.internal.ads.zzed r42, boolean r43, com.google.android.gms.internal.ads.zzfm r44) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r0 = r42
            r1 = r43
            r2 = 4
            r3 = 1
            if (r1 == 0) goto L_0x0010
            r0.zzM(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x000c }
            goto L_0x0015
        L_0x000c:
            r0 = move-exception
            r2 = r3
            goto L_0x0271
        L_0x0010:
            r4 = 21
            r0.zzM(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
        L_0x0015:
            int r4 = r0.zzm()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            r4 = r4 & 3
            int r5 = r0.zzm()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            int r6 = r0.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            r7 = 0
            r8 = r7
            r9 = r8
        L_0x0026:
            if (r8 >= r5) goto L_0x0042
            r0.zzM(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x000c }
            int r10 = r0.zzq()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x000c }
            r11 = r7
        L_0x0030:
            if (r11 >= r10) goto L_0x003f
            int r12 = r0.zzq()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x000c }
            int r13 = r12 + 4
            int r9 = r9 + r13
            r0.zzM(r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x000c }
            int r11 = r11 + 1
            goto L_0x0030
        L_0x003f:
            int r8 = r8 + 1
            goto L_0x0026
        L_0x0042:
            r0.zzL(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            byte[] r6 = new byte[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            r11 = 1065353216(0x3f800000, float:1.0)
            r26 = r44
            r12 = r7
            r23 = r11
            r15 = -1
            r16 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            r20 = -1
            r21 = -1
            r22 = -1
            r24 = -1
            r25 = 0
            r11 = r12
        L_0x0062:
            if (r11 >= r5) goto L_0x0252
            int r13 = r0.zzm()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            r14 = 63
            r13 = r13 & r14
            int r8 = r0.zzq()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026c }
            r28 = r3
            r3 = r7
            r10 = r26
            r27 = -1
        L_0x0076:
            if (r3 >= r8) goto L_0x0244
            int r14 = r0.zzq()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r26 = r3
            byte[] r3 = com.google.android.gms.internal.ads.zzfp.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            java.lang.System.arraycopy(r3, r7, r6, r12, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r3 = r12 + 4
            byte[] r2 = r0.zzN()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r7 = r0.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            java.lang.System.arraycopy(r2, r7, r6, r3, r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r2 = 32
            if (r13 != r2) goto L_0x00a4
            if (r26 != 0) goto L_0x00a5
            int r2 = r3 + r14
            com.google.android.gms.internal.ads.zzfm r10 = com.google.android.gms.internal.ads.zzfp.zzd(r6, r3, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r31 = r3
            r29 = r4
            r3 = 0
            r4 = 0
            goto L_0x0235
        L_0x00a4:
            r2 = r13
        L_0x00a5:
            r7 = 33
            r29 = r4
            r4 = 8
            if (r2 != r7) goto L_0x0117
            if (r26 != 0) goto L_0x0113
            int r2 = r3 + r14
            com.google.android.gms.internal.ads.zzfj r2 = com.google.android.gms.internal.ads.zzfp.zzc(r6, r3, r2, r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r7 = r2.zzd     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r12 = r2.zze     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r15 = r2.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r15 = r15 + r4
            r30 = r4
            int r4 = r2.zzc     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r4 = r4 + 8
            r31 = r3
            int r3 = r2.zzh     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r16 = r3
            int r3 = r2.zzi     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r17 = r3
            int r3 = r2.zzj     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r18 = r3
            float r3 = r2.zzf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r19 = r3
            int r3 = r2.zzg     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            com.google.android.gms.internal.ads.zzfe r2 = r2.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r2 == 0) goto L_0x00fb
            r20 = r3
            int r3 = r2.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r32 = r3
            boolean r3 = r2.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r33 = r3
            int r3 = r2.zzc     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r34 = r3
            int r3 = r2.zzd     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r35 = r3
            int[] r3 = r2.zze     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r2 = r2.zzf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r37 = r2
            r36 = r3
            java.lang.String r2 = com.google.android.gms.internal.ads.zzdd.zzd(r32, r33, r34, r35, r36, r37)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r25 = r2
            goto L_0x00fd
        L_0x00fb:
            r20 = r3
        L_0x00fd:
            r21 = r18
            r23 = r19
            r24 = r20
            r3 = r26
            r18 = r4
            r19 = r16
            r20 = r17
            r4 = 0
            r16 = r12
            r17 = r15
            r15 = r7
            goto L_0x0235
        L_0x0113:
            r31 = r3
            goto L_0x0232
        L_0x0117:
            r31 = r3
            r30 = r4
            r3 = 39
            if (r2 != r3) goto L_0x0232
            if (r26 != 0) goto L_0x0232
            int r3 = r31 + r14
            int r12 = r12 + 6
            int r3 = r3 + -1
        L_0x0127:
            byte r2 = r6[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r2 != 0) goto L_0x0130
            if (r3 <= r12) goto L_0x0215
            int r3 = r3 + -1
            goto L_0x0127
        L_0x0130:
            if (r2 == 0) goto L_0x0215
            if (r3 > r12) goto L_0x0136
            goto L_0x0215
        L_0x0136:
            com.google.android.gms.internal.ads.zzfq r2 = new com.google.android.gms.internal.ads.zzfq     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r3 = r3 + 1
            r2.<init>(r6, r12, r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
        L_0x013d:
            r3 = 16
            boolean r3 = r2.zzg(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r3 == 0) goto L_0x0215
            r3 = r30
            int r4 = r2.zza(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r7 = 0
        L_0x014c:
            r12 = 255(0xff, float:3.57E-43)
            if (r4 != r12) goto L_0x0157
            int r7 = r7 + 255
            int r4 = r2.zza(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            goto L_0x014c
        L_0x0157:
            int r7 = r7 + r4
            int r4 = r2.zza(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r3 = 0
        L_0x015d:
            if (r4 != r12) goto L_0x016a
            int r3 = r3 + 255
            r4 = 8
            int r30 = r2.zza(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r4 = r30
            goto L_0x015d
        L_0x016a:
            r30 = 8
            int r3 = r3 + r4
            if (r3 == 0) goto L_0x0215
            boolean r3 = r2.zzg(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r3 != 0) goto L_0x0177
            goto L_0x0215
        L_0x0177:
            r3 = 176(0xb0, float:2.47E-43)
            if (r7 != r3) goto L_0x013d
            int r33 = r2.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            boolean r3 = r2.zzh()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r3 == 0) goto L_0x018c
            int r4 = r2.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r34 = r4
            goto L_0x018e
        L_0x018c:
            r34 = 0
        L_0x018e:
            int r4 = r2.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r36 = r27
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r7 = 0
        L_0x019f:
            if (r7 > r4) goto L_0x020b
            int r36 = r2.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r37 = r2.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r12 = 6
            r30 = r3
            int r3 = r2.zza(r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r12 = 63
            if (r3 != r12) goto L_0x01b5
            goto L_0x0215
        L_0x01b5:
            if (r3 != 0) goto L_0x01c1
            int r12 = r33 + -30
            r35 = r3
            r3 = 0
            int r12 = java.lang.Math.max(r3, r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            goto L_0x01cc
        L_0x01c1:
            r35 = r3
            r3 = 0
            int r12 = r35 + r33
            int r12 = r12 + -31
            int r12 = java.lang.Math.max(r3, r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
        L_0x01cc:
            int r39 = r2.zza(r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r30 == 0) goto L_0x01f9
            r3 = 6
            int r3 = r2.zza(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r12 = 63
            if (r3 != r12) goto L_0x01dc
            goto L_0x0215
        L_0x01dc:
            if (r3 != 0) goto L_0x01e8
            int r12 = r34 + -30
            r32 = r3
            r3 = 0
            int r12 = java.lang.Math.max(r3, r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            goto L_0x01f3
        L_0x01e8:
            r32 = r3
            r3 = 0
            int r12 = r32 + r34
            int r12 = r12 + -31
            int r12 = java.lang.Math.max(r3, r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
        L_0x01f3:
            int r41 = r2.zza(r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r40 = r32
        L_0x01f9:
            boolean r3 = r2.zzh()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r3 == 0) goto L_0x0204
            r3 = 10
            r2.zzf(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
        L_0x0204:
            int r7 = r7 + 1
            r3 = r30
            r38 = r35
            goto L_0x019f
        L_0x020b:
            com.google.android.gms.internal.ads.zzfi r32 = new com.google.android.gms.internal.ads.zzfi     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r35 = r4 + 1
            r32.<init>(r33, r34, r35, r36, r37, r38, r39, r40, r41)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r2 = r32
            goto L_0x0216
        L_0x0215:
            r2 = 0
        L_0x0216:
            if (r2 == 0) goto L_0x0232
            if (r10 == 0) goto L_0x0232
            int r2 = r2.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            com.google.android.gms.internal.ads.zzfzo r3 = r10.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            com.google.android.gms.internal.ads.zzfc r3 = (com.google.android.gms.internal.ads.zzfc) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r3 = r3.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            if (r2 != r3) goto L_0x022e
            r3 = r26
            r22 = 4
            goto L_0x0235
        L_0x022e:
            r2 = 5
            r22 = r2
            goto L_0x0233
        L_0x0232:
            r4 = 0
        L_0x0233:
            r3 = r26
        L_0x0235:
            int r12 = r31 + r14
            r0.zzM(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r3 = r3 + 1
            r7 = r4
            r4 = r29
            r2 = 4
            r14 = 63
            goto L_0x0076
        L_0x0244:
            r29 = r4
            r4 = r7
            int r11 = r11 + 1
            r26 = r10
            r3 = r28
            r4 = r29
            r2 = 4
            goto L_0x0062
        L_0x0252:
            r28 = r3
            r29 = r4
            if (r9 != 0) goto L_0x025d
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            goto L_0x0261
        L_0x025d:
            java.util.List r0 = java.util.Collections.singletonList(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
        L_0x0261:
            r13 = r0
            com.google.android.gms.internal.ads.zzadg r12 = new com.google.android.gms.internal.ads.zzadg     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            int r14 = r29 + 1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x026a }
            return r12
        L_0x026a:
            r0 = move-exception
            goto L_0x026f
        L_0x026c:
            r0 = move-exception
            r28 = r3
        L_0x026f:
            r2 = r28
        L_0x0271:
            if (r2 == r1) goto L_0x0276
            java.lang.String r1 = "HEVC config"
            goto L_0x0278
        L_0x0276:
            java.lang.String r1 = "L-HEVC config"
        L_0x0278:
            java.lang.String r2 = "Error parsing"
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadg.zzc(com.google.android.gms.internal.ads.zzed, boolean, com.google.android.gms.internal.ads.zzfm):com.google.android.gms.internal.ads.zzadg");
    }
}
