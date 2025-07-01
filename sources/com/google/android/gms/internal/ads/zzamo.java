package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamo implements zzamm {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzadx zzc;
    private final zzaod zzd;
    private final zzed zze;
    private final zzane zzf;
    private final boolean[] zzg;
    private final zzamn zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzamo() {
        throw null;
    }

    zzamo(zzaod zzaod) {
        zzed zzed;
        this.zzd = zzaod;
        this.zzg = new boolean[4];
        this.zzh = new zzamn(128);
        if (zzaod != null) {
            this.zzf = new zzane(178, 128);
            zzed = new zzed();
        } else {
            zzed = null;
            this.zzf = null;
        }
        this.zze = zzed;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzed r21) {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzc
            com.google.android.gms.internal.ads.zzdb.zzb(r1)
            int r1 = r21.zzd()
            int r2 = r21.zze()
            byte[] r3 = r21.zzN()
            long r4 = r0.zzi
            int r6 = r21.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzi = r4
            com.google.android.gms.internal.ads.zzadx r4 = r0.zzc
            int r5 = r21.zzb()
            r6 = r21
            r4.zzq(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.zzg
            int r4 = com.google.android.gms.internal.ads.zzfp.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzamn r4 = r0.zzh
            r4.zza(r3, r1, r2)
        L_0x0039:
            com.google.android.gms.internal.ads.zzane r4 = r0.zzf
            if (r4 == 0) goto L_0x0040
            r4.zza(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r6.zzN()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x012b
            if (r8 <= 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzamn r9 = r0.zzh
            r9.zza(r3, r1, r4)
        L_0x0058:
            if (r8 >= 0) goto L_0x005c
            int r9 = -r8
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzamn r12 = r0.zzh
            boolean r9 = r12.zzc(r5, r9)
            if (r9 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzamn r9 = r0.zzh
            java.lang.String r12 = r0.zzb
            r12.getClass()
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            byte[] r13 = r9.zzc
            int r14 = r9.zza
            byte[] r13 = java.util.Arrays.copyOf(r13, r14)
            r14 = 4
            byte r15 = r13[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r16 = 5
            byte r10 = r13[r16]
            r11 = r10 & 255(0xff, float:3.57E-43)
            r17 = 6
            r18 = r14
            byte r14 = r13[r17]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r17 = 7
            r19 = r2
            byte r2 = r13[r17]
            r2 = r2 & 240(0xf0, float:3.36E-43)
            r10 = r10 & 15
            int r15 = r15 << 4
            int r11 = r11 >> 4
            r11 = r11 | r15
            int r2 = r2 >> 4
            r15 = 8
            int r10 = r10 << r15
            r10 = r10 | r14
            r14 = 2
            if (r2 == r14) goto L_0x00b6
            r14 = 3
            if (r2 == r14) goto L_0x00b1
            r14 = r18
            if (r2 == r14) goto L_0x00ac
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00bd
        L_0x00ac:
            int r2 = r10 * 121
            int r14 = r11 * 100
            goto L_0x00ba
        L_0x00b1:
            int r2 = r10 * 16
            int r14 = r11 * 9
            goto L_0x00ba
        L_0x00b6:
            int r2 = r10 * 4
            int r14 = r11 * 3
        L_0x00ba:
            float r2 = (float) r2
            float r14 = (float) r14
            float r2 = r2 / r14
        L_0x00bd:
            com.google.android.gms.internal.ads.zzab r14 = new com.google.android.gms.internal.ads.zzab
            r14.<init>()
            r14.zzL(r12)
            java.lang.String r12 = "video/mpeg2"
            r14.zzZ(r12)
            r14.zzae(r11)
            r14.zzJ(r10)
            r14.zzV(r2)
            java.util.List r2 = java.util.Collections.singletonList(r13)
            r14.zzM(r2)
            com.google.android.gms.internal.ads.zzad r2 = r14.zzaf()
            byte r10 = r13[r17]
            r10 = r10 & 15
            int r10 = r10 + -1
            r11 = 0
            if (r10 < 0) goto L_0x010c
            if (r10 >= r15) goto L_0x010c
            double[] r11 = zza
            r10 = r11[r10]
            int r9 = r9.zzb
            int r9 = r9 + 9
            byte r9 = r13[r9]
            r12 = r9 & 96
            int r12 = r12 >> 5
            r9 = r9 & 31
            if (r12 == r9) goto L_0x0105
            double r12 = (double) r12
            int r9 = r9 + 1
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 + r14
            double r14 = (double) r9
            double r12 = r12 / r14
            double r10 = r10 * r12
        L_0x0105:
            r12 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r12 = r12 / r10
            long r11 = (long) r12
        L_0x010c:
            java.lang.Long r9 = java.lang.Long.valueOf(r11)
            android.util.Pair r2 = android.util.Pair.create(r2, r9)
            com.google.android.gms.internal.ads.zzadx r9 = r0.zzc
            java.lang.Object r10 = r2.first
            com.google.android.gms.internal.ads.zzad r10 = (com.google.android.gms.internal.ads.zzad) r10
            r9.zzl(r10)
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r9 = r2.longValue()
            r0.zzl = r9
            r2 = 1
            r0.zzk = r2
            goto L_0x012d
        L_0x012b:
            r19 = r2
        L_0x012d:
            com.google.android.gms.internal.ads.zzane r2 = r0.zzf
            if (r2 == 0) goto L_0x017a
            if (r8 <= 0) goto L_0x0138
            r2.zza(r3, r1, r4)
            r1 = 0
            goto L_0x0139
        L_0x0138:
            int r1 = -r8
        L_0x0139:
            com.google.android.gms.internal.ads.zzane r2 = r0.zzf
            boolean r1 = r2.zzd(r1)
            if (r1 == 0) goto L_0x0165
            com.google.android.gms.internal.ads.zzane r1 = r0.zzf
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfp.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzed r2 = r0.zze
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            com.google.android.gms.internal.ads.zzane r8 = r0.zzf
            r9 = r2
            com.google.android.gms.internal.ads.zzed r9 = (com.google.android.gms.internal.ads.zzed) r9
            byte[] r8 = r8.zza
            r2.zzJ(r8, r1)
            com.google.android.gms.internal.ads.zzaod r1 = r0.zzd
            r2 = r1
            com.google.android.gms.internal.ads.zzaod r2 = (com.google.android.gms.internal.ads.zzaod) r2
            long r8 = r0.zzo
            com.google.android.gms.internal.ads.zzed r2 = r0.zze
            r1.zza(r8, r2)
        L_0x0165:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x017a
            byte[] r2 = r6.zzN()
            int r5 = r4 + 2
            byte r2 = r2[r5]
            r5 = 1
            if (r2 != r5) goto L_0x0179
            com.google.android.gms.internal.ads.zzane r2 = r0.zzf
            r2.zzc(r1)
        L_0x0179:
            r5 = r1
        L_0x017a:
            if (r5 == 0) goto L_0x018a
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x0181
            goto L_0x018a
        L_0x0181:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x01ec
            r2 = 1
            r0.zzp = r2
            goto L_0x01ec
        L_0x018a:
            int r13 = r19 - r4
            boolean r1 = r0.zzq
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x01b6
            boolean r1 = r0.zzk
            if (r1 == 0) goto L_0x01b6
            r1 = r8
            long r9 = r0.zzo
            int r4 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x01b7
            boolean r11 = r0.zzp
            long r14 = r0.zzi
            long r1 = r0.zzn
            long r14 = r14 - r1
            int r1 = (int) r14
            int r12 = r1 - r13
            com.google.android.gms.internal.ads.zzadx r8 = r0.zzc
            r14 = 0
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.zzs(r9, r11, r12, r13, r14)
            goto L_0x01b7
        L_0x01b6:
            r1 = r8
        L_0x01b7:
            boolean r4 = r0.zzj
            if (r4 == 0) goto L_0x01c3
            boolean r4 = r0.zzq
            if (r4 == 0) goto L_0x01c0
            goto L_0x01c3
        L_0x01c0:
            r2 = 1
            r4 = 0
            goto L_0x01e5
        L_0x01c3:
            long r8 = r0.zzi
            long r10 = (long) r13
            long r8 = r8 - r10
            r0.zzn = r8
            long r8 = r0.zzm
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x01d0
            goto L_0x01db
        L_0x01d0:
            long r8 = r0.zzo
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x01da
            long r10 = r0.zzl
            long r8 = r8 + r10
            goto L_0x01db
        L_0x01da:
            r8 = r1
        L_0x01db:
            r0.zzo = r8
            r4 = 0
            r0.zzp = r4
            r0.zzm = r1
            r2 = 1
            r0.zzj = r2
        L_0x01e5:
            if (r5 != 0) goto L_0x01e9
            r10 = r2
            goto L_0x01ea
        L_0x01e9:
            r10 = r4
        L_0x01ea:
            r0.zzq = r10
        L_0x01ec:
            r1 = r7
            r2 = r19
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.zza(com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zzb = zzaoa.zzb();
        this.zzc = zzacu.zzw(zzaoa.zza(), 2);
        zzaod zzaod = this.zzd;
        if (zzaod != null) {
            zzaod.zzb(zzacu, zzaoa);
        }
    }

    public final void zzc(boolean z) {
        zzdb.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzp;
            long j = this.zzi - this.zzn;
            this.zzc.zzs(this.zzo, z2 ? 1 : 0, (int) j, 0, (zzadw) null);
        }
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        zzfp.zzh(this.zzg);
        this.zzh.zzb();
        zzane zzane = this.zzf;
        if (zzane != null) {
            zzane.zzb();
        }
        this.zzi = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }
}
