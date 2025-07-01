package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajy extends zzajw {
    private zzajx zza;
    private int zzb;
    private boolean zzc;
    private zzaec zzd;
    private zzaea zze;

    zzajy() {
    }

    /* access modifiers changed from: protected */
    public final long zza(zzed zzed) {
        int i;
        int i2 = 0;
        if ((zzed.zzN()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzed.zzN()[0];
        zzajx zzajx = this.zza;
        zzdb.zzb(zzajx);
        zzajx zzajx2 = zzajx;
        if (!zzajx.zzd[(b >> 1) & (255 >>> (8 - zzajx.zze))].zza) {
            i = zzajx.zza.zze;
        } else {
            i = zzajx.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        if (zzed.zzc() < zzed.zze() + 4) {
            byte[] copyOf = Arrays.copyOf(zzed.zzN(), zzed.zze() + 4);
            zzed.zzJ(copyOf, copyOf.length);
        } else {
            zzed.zzK(zzed.zze() + 4);
        }
        long j = (long) i2;
        byte[] zzN = zzed.zzN();
        zzN[zzed.zze() - 4] = (byte) ((int) (j & 255));
        zzN[zzed.zze() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzN[zzed.zze() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzN[zzed.zze() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* access modifiers changed from: protected */
    public final void zzi(long j) {
        super.zzi(j);
        int i = 0;
        this.zzc = j != 0;
        zzaec zzaec = this.zzd;
        if (zzaec != null) {
            i = zzaec.zze;
        }
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03b5  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzed r26, long r27, com.google.android.gms.internal.ads.zzajt r29) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r29
            com.google.android.gms.internal.ads.zzajx r3 = r0.zza
            r4 = 0
            if (r3 == 0) goto L_0x0011
            com.google.android.gms.internal.ads.zzad r1 = r2.zza
            r1.getClass()
            return r4
        L_0x0011:
            com.google.android.gms.internal.ads.zzaec r6 = r0.zzd
            r11 = 1
            if (r6 != 0) goto L_0x0084
            com.google.android.gms.internal.ads.zzaed.zzd(r11, r1, r4)
            int r13 = r1.zzj()
            int r14 = r1.zzm()
            int r15 = r1.zzj()
            int r6 = r1.zzi()
            if (r6 > 0) goto L_0x002e
            r16 = -1
            goto L_0x0030
        L_0x002e:
            r16 = r6
        L_0x0030:
            int r6 = r1.zzi()
            if (r6 > 0) goto L_0x0039
            r17 = -1
            goto L_0x003b
        L_0x0039:
            r17 = r6
        L_0x003b:
            int r6 = r1.zzi()
            if (r6 > 0) goto L_0x0044
            r18 = -1
            goto L_0x0046
        L_0x0044:
            r18 = r6
        L_0x0046:
            int r3 = r1.zzm()
            r6 = r3 & 15
            double r8 = (double) r6
            r27 = 4
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = java.lang.Math.pow(r5, r8)
            int r8 = (int) r8
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> 4
            double r9 = (double) r3
            double r5 = java.lang.Math.pow(r5, r9)
            int r3 = (int) r5
            int r5 = r1.zzm()
            r5 = r5 & r11
            if (r11 == r5) goto L_0x006a
            r21 = r4
            goto L_0x006c
        L_0x006a:
            r21 = r11
        L_0x006c:
            byte[] r4 = r1.zzN()
            int r1 = r1.zze()
            byte[] r22 = java.util.Arrays.copyOf(r4, r1)
            com.google.android.gms.internal.ads.zzaec r12 = new com.google.android.gms.internal.ads.zzaec
            r20 = r3
            r19 = r8
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0.zzd = r12
            goto L_0x0090
        L_0x0084:
            r27 = 4
            com.google.android.gms.internal.ads.zzaea r5 = r0.zze
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.internal.ads.zzaea r1 = com.google.android.gms.internal.ads.zzaed.zzc(r1, r11, r11)
            r0.zze = r1
        L_0x0090:
            r7 = 0
            goto L_0x03af
        L_0x0093:
            int r8 = r1.zze()
            byte[] r8 = new byte[r8]
            byte[] r9 = r1.zzN()
            int r10 = r1.zze()
            java.lang.System.arraycopy(r9, r4, r8, r4, r10)
            int r9 = r6.zza
            r10 = 5
            com.google.android.gms.internal.ads.zzaed.zzd(r10, r1, r4)
            int r12 = r1.zzm()
            int r12 = r12 + r11
            com.google.android.gms.internal.ads.zzadz r13 = new com.google.android.gms.internal.ads.zzadz
            byte[] r14 = r1.zzN()
            r13.<init>(r14)
            int r1 = r1.zzd()
            r14 = 8
            int r1 = r1 * r14
            r13.zzc(r1)
            r1 = r4
        L_0x00c3:
            r15 = 24
            r3 = 2
            r4 = 16
            if (r1 >= r12) goto L_0x0188
            int r14 = r13.zzb(r15)
            r7 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r7) goto L_0x0170
            int r4 = r13.zzb(r4)
            int r7 = r13.zzb(r15)
            boolean r14 = r13.zzd()
            if (r14 != 0) goto L_0x00fa
            boolean r14 = r13.zzd()
            r15 = 0
        L_0x00e6:
            if (r15 >= r7) goto L_0x010c
            if (r14 == 0) goto L_0x00f4
            boolean r18 = r13.zzd()
            if (r18 == 0) goto L_0x00f7
            r13.zzc(r10)
            goto L_0x00f7
        L_0x00f4:
            r13.zzc(r10)
        L_0x00f7:
            int r15 = r15 + 1
            goto L_0x00e6
        L_0x00fa:
            r13.zzc(r10)
            r14 = 0
        L_0x00fe:
            if (r14 >= r7) goto L_0x010c
            int r15 = r7 - r14
            int r15 = com.google.android.gms.internal.ads.zzaed.zza(r15)
            int r15 = r13.zzb(r15)
            int r14 = r14 + r15
            goto L_0x00fe
        L_0x010c:
            r14 = r27
            int r15 = r13.zzb(r14)
            if (r15 > r3) goto L_0x015c
            if (r15 == r11) goto L_0x011b
            if (r15 != r3) goto L_0x0119
            goto L_0x011c
        L_0x0119:
            r14 = r11
            goto L_0x0151
        L_0x011b:
            r3 = r15
        L_0x011c:
            r15 = 32
            r13.zzc(r15)
            r13.zzc(r15)
            int r15 = r13.zzb(r14)
            int r15 = r15 + r11
            r13.zzc(r11)
            if (r3 != r11) goto L_0x0147
            if (r4 == 0) goto L_0x0143
            r14 = r11
            long r10 = (long) r7
            long r3 = (long) r4
            double r3 = (double) r3
            double r10 = (double) r10
            r19 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r19 / r3
            double r3 = java.lang.Math.pow(r10, r3)
            double r3 = java.lang.Math.floor(r3)
            long r3 = (long) r3
            goto L_0x014b
        L_0x0143:
            r14 = r11
            r3 = 0
            goto L_0x014b
        L_0x0147:
            r14 = r11
            long r3 = (long) r4
            long r10 = (long) r7
            long r3 = r3 * r10
        L_0x014b:
            long r10 = (long) r15
            long r3 = r3 * r10
            int r3 = (int) r3
            r13.zzc(r3)
        L_0x0151:
            int r1 = r1 + 1
            r11 = r14
            r27 = 4
            r4 = 0
            r10 = 5
            r14 = 8
            goto L_0x00c3
        L_0x015c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.<init>(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0170:
            r2 = 0
            int r1 = r13.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0188:
            r14 = r11
            r1 = 6
            int r7 = r13.zzb(r1)
            int r7 = r7 + r14
            r10 = 0
        L_0x0190:
            if (r10 >= r7) goto L_0x01a3
            int r11 = r13.zzb(r4)
            if (r11 != 0) goto L_0x019b
            int r10 = r10 + 1
            goto L_0x0190
        L_0x019b:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x01a3:
            int r7 = r13.zzb(r1)
            int r7 = r7 + r14
            r10 = 0
        L_0x01a9:
            r11 = 3
            if (r10 >= r7) goto L_0x0272
            int r12 = r13.zzb(r4)
            if (r12 == 0) goto L_0x0241
            if (r12 != r14) goto L_0x022d
            r14 = 5
            int r12 = r13.zzb(r14)
            int[] r14 = new int[r12]
            r1 = -1
            r15 = 0
        L_0x01bd:
            if (r15 >= r12) goto L_0x01cf
            r4 = 4
            int r3 = r13.zzb(r4)
            r14[r15] = r3
            if (r3 <= r1) goto L_0x01c9
            r1 = r3
        L_0x01c9:
            int r15 = r15 + 1
            r3 = 2
            r4 = 16
            goto L_0x01bd
        L_0x01cf:
            int r1 = r1 + 1
            int[] r3 = new int[r1]
            r4 = 0
        L_0x01d4:
            if (r4 >= r1) goto L_0x020c
            int r15 = r13.zzb(r11)
            r19 = 1
            int r15 = r15 + 1
            r3[r4] = r15
            r15 = 2
            int r23 = r13.zzb(r15)
            if (r23 <= 0) goto L_0x01ed
            r15 = 8
            r13.zzc(r15)
            goto L_0x01ef
        L_0x01ed:
            r15 = 8
        L_0x01ef:
            r24 = r1
            r11 = 0
        L_0x01f2:
            int r1 = r19 << r23
            r19 = r14
            if (r11 >= r1) goto L_0x0204
            r13.zzc(r15)
            int r11 = r11 + 1
            r14 = r19
            r15 = 8
            r19 = 1
            goto L_0x01f2
        L_0x0204:
            int r4 = r4 + 1
            r14 = r19
            r1 = r24
            r11 = 3
            goto L_0x01d4
        L_0x020c:
            r19 = r14
            r15 = 2
            r13.zzc(r15)
            r4 = 4
            int r1 = r13.zzb(r4)
            r4 = 0
            r11 = 0
            r15 = 0
        L_0x021a:
            if (r4 >= r12) goto L_0x0267
            r23 = r19[r4]
            r23 = r3[r23]
            int r11 = r11 + r23
        L_0x0222:
            if (r15 >= r11) goto L_0x022a
            r13.zzc(r1)
            int r15 = r15 + 1
            goto L_0x0222
        L_0x022a:
            int r4 = r4 + 1
            goto L_0x021a
        L_0x022d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0241:
            r15 = 8
            r13.zzc(r15)
            r1 = 16
            r13.zzc(r1)
            r13.zzc(r1)
            r1 = 6
            r13.zzc(r1)
            r13.zzc(r15)
            r4 = 4
            int r1 = r13.zzb(r4)
            r14 = 1
            int r1 = r1 + r14
            r3 = 0
        L_0x025d:
            if (r3 >= r1) goto L_0x0267
            r13.zzc(r15)
            int r3 = r3 + 1
            r15 = 8
            goto L_0x025d
        L_0x0267:
            int r10 = r10 + 1
            r1 = 6
            r3 = 2
            r4 = 16
            r14 = 1
            r15 = 24
            goto L_0x01a9
        L_0x0272:
            int r3 = r13.zzb(r1)
            r14 = 1
            int r3 = r3 + r14
            r4 = 0
        L_0x0279:
            if (r4 >= r3) goto L_0x02e8
            r7 = 16
            int r10 = r13.zzb(r7)
            r15 = 2
            if (r10 > r15) goto L_0x02e0
            r7 = 24
            r13.zzc(r7)
            r13.zzc(r7)
            r13.zzc(r7)
            int r10 = r13.zzb(r1)
            int r10 = r10 + r14
            r15 = 8
            r13.zzc(r15)
            int[] r1 = new int[r10]
            r11 = 0
        L_0x029c:
            if (r11 >= r10) goto L_0x02bd
            r12 = 3
            int r19 = r13.zzb(r12)
            boolean r20 = r13.zzd()
            if (r20 == 0) goto L_0x02af
            r7 = 5
            int r18 = r13.zzb(r7)
            goto L_0x02b2
        L_0x02af:
            r7 = 5
            r18 = 0
        L_0x02b2:
            int r18 = r18 * 8
            int r18 = r18 + r19
            r1[r11] = r18
            int r11 = r11 + 1
            r7 = 24
            goto L_0x029c
        L_0x02bd:
            r12 = 3
            r11 = 0
        L_0x02bf:
            r7 = 5
            if (r11 >= r10) goto L_0x02db
            r7 = 0
        L_0x02c3:
            if (r7 >= r15) goto L_0x02d6
            r19 = r1[r11]
            r14 = 1
            int r23 = r14 << r7
            r19 = r19 & r23
            if (r19 == 0) goto L_0x02d1
            r13.zzc(r15)
        L_0x02d1:
            int r7 = r7 + 1
            r15 = 8
            goto L_0x02c3
        L_0x02d6:
            int r11 = r11 + 1
            r15 = 8
            goto L_0x02bf
        L_0x02db:
            int r4 = r4 + 1
            r1 = 6
            r14 = 1
            goto L_0x0279
        L_0x02e0:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x02e8:
            int r3 = r13.zzb(r1)
            r14 = 1
            int r3 = r3 + r14
            r1 = 0
        L_0x02ef:
            if (r1 >= r3) goto L_0x0374
            r7 = 16
            int r4 = r13.zzb(r7)
            if (r4 == 0) goto L_0x030f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r10 = "mapping type other than 0 not supported: "
            r7.<init>(r10)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.String r7 = "VorbisUtil"
            com.google.android.gms.internal.ads.zzdt.zzc(r7, r4)
            r10 = 4
            r15 = 2
            goto L_0x0369
        L_0x030f:
            boolean r4 = r13.zzd()
            if (r4 == 0) goto L_0x031e
            r4 = 4
            int r7 = r13.zzb(r4)
            r14 = 1
            int r4 = r7 + 1
            goto L_0x0320
        L_0x031e:
            r14 = 1
            r4 = r14
        L_0x0320:
            boolean r7 = r13.zzd()
            if (r7 == 0) goto L_0x0343
            r15 = 8
            int r7 = r13.zzb(r15)
            int r7 = r7 + r14
            r10 = 0
        L_0x032e:
            if (r10 >= r7) goto L_0x0343
            int r11 = r9 + -1
            int r12 = com.google.android.gms.internal.ads.zzaed.zza(r11)
            r13.zzc(r12)
            int r11 = com.google.android.gms.internal.ads.zzaed.zza(r11)
            r13.zzc(r11)
            int r10 = r10 + 1
            goto L_0x032e
        L_0x0343:
            r15 = 2
            int r7 = r13.zzb(r15)
            if (r7 != 0) goto L_0x036c
            r14 = 1
            if (r4 <= r14) goto L_0x0357
            r7 = 0
        L_0x034e:
            if (r7 >= r9) goto L_0x0357
            r10 = 4
            r13.zzc(r10)
            int r7 = r7 + 1
            goto L_0x034e
        L_0x0357:
            r10 = 4
            r7 = 0
        L_0x0359:
            if (r7 >= r4) goto L_0x0369
            r11 = 8
            r13.zzc(r11)
            r13.zzc(r11)
            r13.zzc(r11)
            int r7 = r7 + 1
            goto L_0x0359
        L_0x0369:
            int r1 = r1 + 1
            goto L_0x02ef
        L_0x036c:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0374:
            r1 = 6
            int r1 = r13.zzb(r1)
            int r3 = r1 + 1
            com.google.android.gms.internal.ads.zzaeb[] r9 = new com.google.android.gms.internal.ads.zzaeb[r3]
            r4 = 0
        L_0x037e:
            if (r4 >= r3) goto L_0x039e
            boolean r7 = r13.zzd()
            r10 = 16
            int r11 = r13.zzb(r10)
            int r12 = r13.zzb(r10)
            r15 = 8
            int r10 = r13.zzb(r15)
            com.google.android.gms.internal.ads.zzaeb r14 = new com.google.android.gms.internal.ads.zzaeb
            r14.<init>(r7, r11, r12, r10)
            r9[r4] = r14
            int r4 = r4 + 1
            goto L_0x037e
        L_0x039e:
            boolean r3 = r13.zzd()
            if (r3 == 0) goto L_0x03fe
            r7 = r5
            com.google.android.gms.internal.ads.zzajx r5 = new com.google.android.gms.internal.ads.zzajx
            int r10 = com.google.android.gms.internal.ads.zzaed.zza(r1)
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = r5
        L_0x03af:
            r0.zza = r7
            if (r7 != 0) goto L_0x03b5
            r14 = 1
            return r14
        L_0x03b5:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.android.gms.internal.ads.zzaec r3 = r7.zza
            byte[] r4 = r3.zzg
            r1.add(r4)
            byte[] r4 = r7.zzc
            r1.add(r4)
            com.google.android.gms.internal.ads.zzaea r4 = r7.zzb
            java.lang.String[] r4 = r4.zza
            com.google.android.gms.internal.ads.zzfzo r4 = com.google.android.gms.internal.ads.zzfzo.zzm(r4)
            com.google.android.gms.internal.ads.zzbd r4 = com.google.android.gms.internal.ads.zzaed.zzb(r4)
            com.google.android.gms.internal.ads.zzab r5 = new com.google.android.gms.internal.ads.zzab
            r5.<init>()
            java.lang.String r6 = "audio/vorbis"
            r5.zzZ(r6)
            int r6 = r3.zzd
            r5.zzy(r6)
            int r6 = r3.zzc
            r5.zzU(r6)
            int r6 = r3.zza
            r5.zzz(r6)
            int r3 = r3.zzb
            r5.zzaa(r3)
            r5.zzM(r1)
            r5.zzS(r4)
            com.google.android.gms.internal.ads.zzad r1 = r5.zzaf()
            r2.zza = r1
            r14 = 1
            return r14
        L_0x03fe:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajy.zzc(com.google.android.gms.internal.ads.zzed, long, com.google.android.gms.internal.ads.zzajt):boolean");
    }
}
