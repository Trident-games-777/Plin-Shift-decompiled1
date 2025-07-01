package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamr implements zzamm {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaod zzb;
    private final zzed zzc;
    private final boolean[] zzd;
    private final zzamp zze;
    private final zzane zzf;
    private zzamq zzg;
    private long zzh;
    private String zzi;
    private zzadx zzj;
    private boolean zzk;
    private long zzl;

    public zzamr() {
        this((zzaod) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01da A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzed r19) {
        /*
            r18 = this;
            r0 = r18
            com.google.android.gms.internal.ads.zzamq r1 = r0.zzg
            com.google.android.gms.internal.ads.zzdb.zzb(r1)
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzj
            com.google.android.gms.internal.ads.zzdb.zzb(r1)
            int r1 = r19.zzd()
            int r2 = r19.zze()
            byte[] r3 = r19.zzN()
            long r4 = r0.zzh
            int r6 = r19.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzh = r4
            com.google.android.gms.internal.ads.zzadx r4 = r0.zzj
            int r5 = r19.zzb()
            r6 = r19
            r4.zzq(r6, r5)
        L_0x002d:
            boolean[] r4 = r0.zzd
            int r4 = com.google.android.gms.internal.ads.zzfp.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x004b
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzamp r4 = r0.zze
            r4.zza(r3, r1, r2)
        L_0x003e:
            com.google.android.gms.internal.ads.zzamq r4 = r0.zzg
            r4.zza(r3, r1, r2)
            com.google.android.gms.internal.ads.zzane r4 = r0.zzf
            if (r4 == 0) goto L_0x004a
            r4.zza(r3, r1, r2)
        L_0x004a:
            return
        L_0x004b:
            byte[] r5 = r6.zzN()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0186
            if (r8 <= 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzamp r9 = r0.zze
            r9.zza(r3, r1, r4)
        L_0x0062:
            if (r8 >= 0) goto L_0x0066
            int r9 = -r8
            goto L_0x0067
        L_0x0066:
            r9 = 0
        L_0x0067:
            com.google.android.gms.internal.ads.zzamp r12 = r0.zze
            boolean r9 = r12.zzc(r5, r9)
            if (r9 == 0) goto L_0x0186
            com.google.android.gms.internal.ads.zzadx r9 = r0.zzj
            com.google.android.gms.internal.ads.zzamp r12 = r0.zze
            int r13 = r12.zzb
            java.lang.String r14 = r0.zzi
            r14.getClass()
            r15 = r14
            java.lang.String r15 = (java.lang.String) r15
            byte[] r15 = r12.zzc
            int r12 = r12.zza
            byte[] r12 = java.util.Arrays.copyOf(r15, r12)
            com.google.android.gms.internal.ads.zzec r15 = new com.google.android.gms.internal.ads.zzec
            int r10 = r12.length
            r15.<init>(r12, r10)
            r15.zzo(r13)
            r10 = 4
            r15.zzo(r10)
            r15.zzm()
            r13 = 8
            r15.zzn(r13)
            boolean r16 = r15.zzp()
            r11 = 3
            if (r16 == 0) goto L_0x00a7
            r15.zzn(r10)
            r15.zzn(r11)
        L_0x00a7:
            int r10 = r15.zzd(r10)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Invalid aspect ratio"
            java.lang.String r13 = "H263Reader"
            r17 = r2
            r2 = 15
            if (r10 != r2) goto L_0x00cc
            r2 = 8
            int r10 = r15.zzd(r2)
            int r2 = r15.zzd(r2)
            if (r2 != 0) goto L_0x00c7
            com.google.android.gms.internal.ads.zzdt.zzf(r13, r11)
            goto L_0x00d7
        L_0x00c7:
            float r10 = (float) r10
            float r2 = (float) r2
            float r16 = r10 / r2
            goto L_0x00d7
        L_0x00cc:
            r2 = 7
            if (r10 >= r2) goto L_0x00d4
            float[] r2 = zza
            r16 = r2[r10]
            goto L_0x00d7
        L_0x00d4:
            com.google.android.gms.internal.ads.zzdt.zzf(r13, r11)
        L_0x00d7:
            r2 = r16
            boolean r10 = r15.zzp()
            r11 = 2
            if (r10 == 0) goto L_0x0115
            r15.zzn(r11)
            r10 = 1
            r15.zzn(r10)
            boolean r10 = r15.zzp()
            if (r10 == 0) goto L_0x0115
            r10 = 15
            r15.zzn(r10)
            r15.zzm()
            r15.zzn(r10)
            r15.zzm()
            r15.zzn(r10)
            r15.zzm()
            r11 = 3
            r15.zzn(r11)
            r11 = 11
            r15.zzn(r11)
            r15.zzm()
            r15.zzn(r10)
            r15.zzm()
            r10 = 2
            goto L_0x0116
        L_0x0115:
            r10 = r11
        L_0x0116:
            int r10 = r15.zzd(r10)
            if (r10 == 0) goto L_0x0121
            java.lang.String r10 = "Unhandled video object layer shape"
            com.google.android.gms.internal.ads.zzdt.zzf(r13, r10)
        L_0x0121:
            r15.zzm()
            r10 = 16
            int r10 = r15.zzd(r10)
            r15.zzm()
            boolean r11 = r15.zzp()
            if (r11 == 0) goto L_0x0148
            if (r10 != 0) goto L_0x013b
            java.lang.String r10 = "Invalid vop_increment_time_resolution"
            com.google.android.gms.internal.ads.zzdt.zzf(r13, r10)
            goto L_0x0148
        L_0x013b:
            int r10 = r10 + -1
            r11 = 0
        L_0x013e:
            if (r10 <= 0) goto L_0x0145
            int r10 = r10 >> 1
            int r11 = r11 + 1
            goto L_0x013e
        L_0x0145:
            r15.zzn(r11)
        L_0x0148:
            r15.zzm()
            r10 = 13
            int r11 = r15.zzd(r10)
            r15.zzm()
            int r10 = r15.zzd(r10)
            r15.zzm()
            r15.zzm()
            com.google.android.gms.internal.ads.zzab r13 = new com.google.android.gms.internal.ads.zzab
            r13.<init>()
            r13.zzL(r14)
            java.lang.String r14 = "video/mp4v-es"
            r13.zzZ(r14)
            r13.zzae(r11)
            r13.zzJ(r10)
            r13.zzV(r2)
            java.util.List r2 = java.util.Collections.singletonList(r12)
            r13.zzM(r2)
            com.google.android.gms.internal.ads.zzad r2 = r13.zzaf()
            r9.zzl(r2)
            r10 = 1
            r0.zzk = r10
            goto L_0x0188
        L_0x0186:
            r17 = r2
        L_0x0188:
            com.google.android.gms.internal.ads.zzamq r2 = r0.zzg
            r2.zza(r3, r1, r4)
            com.google.android.gms.internal.ads.zzane r2 = r0.zzf
            if (r2 == 0) goto L_0x01da
            if (r8 <= 0) goto L_0x0198
            r2.zza(r3, r1, r4)
            r10 = 0
            goto L_0x0199
        L_0x0198:
            int r10 = -r8
        L_0x0199:
            com.google.android.gms.internal.ads.zzane r1 = r0.zzf
            boolean r1 = r1.zzd(r10)
            if (r1 == 0) goto L_0x01c5
            com.google.android.gms.internal.ads.zzane r1 = r0.zzf
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfp.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            com.google.android.gms.internal.ads.zzane r8 = r0.zzf
            r9 = r2
            com.google.android.gms.internal.ads.zzed r9 = (com.google.android.gms.internal.ads.zzed) r9
            byte[] r8 = r8.zza
            r2.zzJ(r8, r1)
            com.google.android.gms.internal.ads.zzaod r1 = r0.zzb
            r2 = r1
            com.google.android.gms.internal.ads.zzaod r2 = (com.google.android.gms.internal.ads.zzaod) r2
            long r8 = r0.zzl
            com.google.android.gms.internal.ads.zzed r2 = r0.zzc
            r1.zza(r8, r2)
        L_0x01c5:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x01da
            byte[] r2 = r6.zzN()
            int r5 = r4 + 2
            byte r2 = r2[r5]
            r10 = 1
            if (r2 != r10) goto L_0x01d9
            com.google.android.gms.internal.ads.zzane r2 = r0.zzf
            r2.zzc(r1)
        L_0x01d9:
            r5 = r1
        L_0x01da:
            int r2 = r17 - r4
            long r8 = r0.zzh
            long r10 = (long) r2
            long r8 = r8 - r10
            com.google.android.gms.internal.ads.zzamq r1 = r0.zzg
            boolean r4 = r0.zzk
            r1.zzb(r8, r2, r4)
            com.google.android.gms.internal.ads.zzamq r1 = r0.zzg
            long r8 = r0.zzl
            r1.zzc(r5, r8)
            r1 = r7
            r2 = r17
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamr.zza(com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zzi = zzaoa.zzb();
        this.zzj = zzacu.zzw(zzaoa.zza(), 2);
        this.zzg = new zzamq(this.zzj);
        zzaod zzaod = this.zzb;
        if (zzaod != null) {
            zzaod.zzb(zzacu, zzaoa);
        }
    }

    public final void zzc(boolean z) {
        zzdb.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    public final void zze() {
        zzfp.zzh(this.zzd);
        this.zze.zzb();
        zzamq zzamq = this.zzg;
        if (zzamq != null) {
            zzamq.zzd();
        }
        zzane zzane = this.zzf;
        if (zzane != null) {
            zzane.zzb();
        }
        this.zzh = 0;
        this.zzl = -9223372036854775807L;
    }

    zzamr(zzaod zzaod) {
        zzed zzed;
        this.zzb = zzaod;
        this.zzd = new boolean[4];
        this.zze = new zzamp(128);
        this.zzl = -9223372036854775807L;
        if (zzaod != null) {
            this.zzf = new zzane(178, 128);
            zzed = new zzed();
        } else {
            zzed = null;
            this.zzf = null;
        }
        this.zzc = zzed;
    }
}
