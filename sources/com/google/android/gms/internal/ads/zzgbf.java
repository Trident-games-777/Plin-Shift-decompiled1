package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbf extends zzfzr {
    static final zzfzr zza = new zzgbf((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzgbf(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzgbf zzj(int r19, java.lang.Object[] r20, com.google.android.gms.internal.ads.zzfzq r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            if (r0 != 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzfzr r0 = zza
            com.google.android.gms.internal.ads.zzgbf r0 = (com.google.android.gms.internal.ads.zzgbf) r0
            return r0
        L_0x000d:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0027
            r0 = r1[r4]
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r2 = r1[r5]
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            com.google.android.gms.internal.ads.zzfyl.zzb(r0, r2)
            com.google.android.gms.internal.ads.zzgbf r0 = new com.google.android.gms.internal.ads.zzgbf
            r0.<init>(r3, r1, r5)
            return r0
        L_0x0027:
            int r6 = r1.length
            int r6 = r6 >> r5
            java.lang.String r7 = "index"
            com.google.android.gms.internal.ads.zzfwq.zzb(r0, r6, r7)
            int r6 = com.google.android.gms.internal.ads.zzfzt.zzh(r0)
            r7 = 2
            if (r0 != r5) goto L_0x004d
            r0 = r1[r4]
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r6 = r1[r5]
            java.lang.Object r6 = java.util.Objects.requireNonNull(r6)
            com.google.android.gms.internal.ads.zzfyl.zzb(r0, r6)
            r16 = r4
            r0 = r5
            r17 = r0
        L_0x0049:
            r18 = r7
            goto L_0x01ba
        L_0x004d:
            int r8 = r6 + -1
            r9 = 128(0x80, float:1.794E-43)
            r10 = 3
            r11 = -1
            if (r6 > r9) goto L_0x00d1
            byte[] r6 = new byte[r6]
            java.util.Arrays.fill(r6, r11)
            r9 = r4
            r11 = r9
        L_0x005c:
            if (r9 >= r0) goto L_0x00ba
            int r12 = r11 + r11
            int r13 = r9 + r9
            r14 = r1[r13]
            java.lang.Object r14 = java.util.Objects.requireNonNull(r14)
            r13 = r13 ^ r5
            r13 = r1[r13]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            com.google.android.gms.internal.ads.zzfyl.zzb(r14, r13)
            int r15 = r14.hashCode()
            int r15 = com.google.android.gms.internal.ads.zzfzg.zza(r15)
        L_0x007a:
            r15 = r15 & r8
            r16 = r4
            byte r4 = r6[r15]
            r17 = r5
            r5 = 255(0xff, float:3.57E-43)
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0094
            byte r4 = (byte) r12
            r6[r15] = r4
            if (r11 >= r9) goto L_0x0091
            r1[r12] = r14
            r4 = r12 ^ 1
            r1[r4] = r13
        L_0x0091:
            int r11 = r11 + 1
            goto L_0x00ac
        L_0x0094:
            r5 = r1[r4]
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x00b3
            r3 = r4 ^ 1
            com.google.android.gms.internal.ads.zzfzp r4 = new com.google.android.gms.internal.ads.zzfzp
            r5 = r1[r3]
            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)
            r4.<init>(r14, r13, r5)
            r1[r3] = r13
            r3 = r4
        L_0x00ac:
            int r9 = r9 + 1
            r4 = r16
            r5 = r17
            goto L_0x005c
        L_0x00b3:
            int r15 = r15 + 1
            r4 = r16
            r5 = r17
            goto L_0x007a
        L_0x00ba:
            r16 = r4
            r17 = r5
            if (r11 != r0) goto L_0x00c2
            r3 = r6
            goto L_0x0049
        L_0x00c2:
            java.lang.Object[] r4 = new java.lang.Object[r10]
            r4[r16] = r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r4[r17] = r5
            r4[r7] = r3
        L_0x00ce:
            r3 = r4
            goto L_0x0049
        L_0x00d1:
            r16 = r4
            r17 = r5
            r4 = 32768(0x8000, float:4.5918E-41)
            if (r6 > r4) goto L_0x0148
            short[] r4 = new short[r6]
            java.util.Arrays.fill(r4, r11)
            r5 = r16
            r6 = r5
        L_0x00e2:
            if (r5 >= r0) goto L_0x0136
            int r9 = r6 + r6
            int r11 = r5 + r5
            r12 = r1[r11]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            r11 = r11 ^ 1
            r11 = r1[r11]
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            com.google.android.gms.internal.ads.zzfyl.zzb(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfzg.zza(r13)
        L_0x0101:
            r13 = r13 & r8
            short r14 = r4[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x0118
            short r14 = (short) r9
            r4[r13] = r14
            if (r6 >= r5) goto L_0x0115
            r1[r9] = r12
            r9 = r9 ^ 1
            r1[r9] = r11
        L_0x0115:
            int r6 = r6 + 1
            goto L_0x0130
        L_0x0118:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0133
            r3 = r14 ^ 1
            com.google.android.gms.internal.ads.zzfzp r9 = new com.google.android.gms.internal.ads.zzfzp
            r13 = r1[r3]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r9.<init>(r12, r11, r13)
            r1[r3] = r11
            r3 = r9
        L_0x0130:
            int r5 = r5 + 1
            goto L_0x00e2
        L_0x0133:
            int r13 = r13 + 1
            goto L_0x0101
        L_0x0136:
            if (r6 != r0) goto L_0x0139
            goto L_0x00ce
        L_0x0139:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r16] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r5[r17] = r4
            r5[r7] = r3
            r3 = r5
            goto L_0x0049
        L_0x0148:
            int[] r4 = new int[r6]
            java.util.Arrays.fill(r4, r11)
            r5 = r16
            r6 = r5
        L_0x0150:
            if (r5 >= r0) goto L_0x01a7
            int r9 = r6 + r6
            int r12 = r5 + r5
            r13 = r1[r12]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r12 = r12 ^ 1
            r12 = r1[r12]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            com.google.android.gms.internal.ads.zzfyl.zzb(r13, r12)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.ads.zzfzg.zza(r14)
        L_0x016f:
            r14 = r14 & r8
            r15 = r4[r14]
            if (r15 != r11) goto L_0x0183
            r4[r14] = r9
            if (r6 >= r5) goto L_0x017e
            r1[r9] = r13
            r9 = r9 ^ 1
            r1[r9] = r12
        L_0x017e:
            int r6 = r6 + 1
            r18 = r7
            goto L_0x019d
        L_0x0183:
            r18 = r7
            r7 = r1[r15]
            boolean r7 = r13.equals(r7)
            if (r7 == 0) goto L_0x01a2
            r3 = r15 ^ 1
            com.google.android.gms.internal.ads.zzfzp r7 = new com.google.android.gms.internal.ads.zzfzp
            r9 = r1[r3]
            java.lang.Object r9 = java.util.Objects.requireNonNull(r9)
            r7.<init>(r13, r12, r9)
            r1[r3] = r12
            r3 = r7
        L_0x019d:
            int r5 = r5 + 1
            r7 = r18
            goto L_0x0150
        L_0x01a2:
            int r14 = r14 + 1
            r7 = r18
            goto L_0x016f
        L_0x01a7:
            r18 = r7
            if (r6 != r0) goto L_0x01ad
            r3 = r4
            goto L_0x01ba
        L_0x01ad:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r16] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r5[r17] = r4
            r5[r18] = r3
            r3 = r5
        L_0x01ba:
            boolean r4 = r3 instanceof java.lang.Object[]
            if (r4 == 0) goto L_0x01e0
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r0 = r3[r18]
            com.google.android.gms.internal.ads.zzfzp r0 = (com.google.android.gms.internal.ads.zzfzp) r0
            if (r2 == 0) goto L_0x01db
            r2.zzc = r0
            r0 = r3[r16]
            r2 = r3[r17]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r3 = r0
            r0 = r2
            goto L_0x01e0
        L_0x01db:
            java.lang.IllegalArgumentException r0 = r0.zza()
            throw r0
        L_0x01e0:
            com.google.android.gms.internal.ads.zzgbf r2 = new com.google.android.gms.internal.ads.zzgbf
            r2.<init>(r3, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbf.zzj(int, java.lang.Object[], com.google.android.gms.internal.ads.zzfzq):com.google.android.gms.internal.ads.zzgbf");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0006
        L_0x0003:
            r10 = r0
            goto L_0x009e
        L_0x0006:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L_0x0022
            r1 = 0
            r1 = r2[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x0003
            r10 = r2[r3]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            goto L_0x009e
        L_0x0022:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L_0x0027
            goto L_0x0003
        L_0x0027:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L_0x0053
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.ads.zzfzg.zza(r1)
        L_0x003a:
            r1 = r1 & r6
            byte r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0043
            goto L_0x0003
        L_0x0043:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x0050
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009e
        L_0x0050:
            int r1 = r1 + 1
            goto L_0x003a
        L_0x0053:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L_0x007f
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.ads.zzfzg.zza(r1)
        L_0x0065:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006f
            goto L_0x0003
        L_0x006f:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007c
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009e
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0065
        L_0x007f:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfzg.zza(r6)
        L_0x008b:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L_0x0092
            goto L_0x0003
        L_0x0092:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a2
            r10 = r7 ^ 1
            r10 = r2[r10]
        L_0x009e:
            if (r10 != 0) goto L_0x00a1
            return r0
        L_0x00a1:
            return r10
        L_0x00a2:
            int r6 = r6 + 1
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbf.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfzj zza() {
        return new zzgbe(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfzt zzf() {
        return new zzgbc(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfzt zzg() {
        return new zzgbd(this, new zzgbe(this.zzb, 0, this.zzd));
    }
}
