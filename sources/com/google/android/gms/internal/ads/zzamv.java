package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamv implements zzamm {
    private final zzanq zza;
    private String zzb;
    private zzadx zzc;
    private zzamu zzd;
    private boolean zze;
    private final boolean[] zzf = new boolean[3];
    private final zzane zzg = new zzane(32, 128);
    private final zzane zzh = new zzane(33, 128);
    private final zzane zzi = new zzane(34, 128);
    private final zzane zzj = new zzane(39, 128);
    private final zzane zzk = new zzane(40, 128);
    private long zzl;
    private long zzm = -9223372036854775807L;
    private final zzed zzn = new zzed();

    public zzamv(zzanq zzanq) {
        this.zza = zzanq;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzed r29) {
        /*
            r28 = this;
            r0 = r28
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzc
            com.google.android.gms.internal.ads.zzdb.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzen.zza
        L_0x0009:
            int r1 = r29.zzb()
            if (r1 <= 0) goto L_0x01e2
            int r1 = r29.zzd()
            int r2 = r29.zze()
            byte[] r3 = r29.zzN()
            long r4 = r0.zzl
            int r6 = r29.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzl = r4
            com.google.android.gms.internal.ads.zzadx r4 = r0.zzc
            int r5 = r29.zzb()
            r6 = r29
            r4.zzq(r6, r5)
        L_0x0030:
            if (r1 >= r2) goto L_0x0009
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzfp.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x01df
            int r5 = r4 + 3
            byte r7 = r3[r5]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            int r8 = r4 - r1
            if (r8 <= 0) goto L_0x0047
            r0.zzf(r3, r1, r4)
        L_0x0047:
            int r12 = r2 - r4
            long r9 = r0.zzl
            long r13 = (long) r12
            long r10 = r9 - r13
            if (r8 >= 0) goto L_0x0052
            int r4 = -r8
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            long r8 = r0.zzm
            com.google.android.gms.internal.ads.zzamu r13 = r0.zzd
            boolean r14 = r0.zze
            r13.zzb(r10, r12, r14)
            boolean r13 = r0.zze
            if (r13 != 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzane r13 = r0.zzg
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzane r13 = r0.zzh
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzane r13 = r0.zzi
            r13.zzd(r4)
            com.google.android.gms.internal.ads.zzane r13 = r0.zzg
            boolean r15 = r13.zze()
            if (r15 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzane r15 = r0.zzh
            boolean r16 = r15.zze()
            if (r16 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzane r14 = r0.zzi
            boolean r17 = r14.zze()
            if (r17 == 0) goto L_0x0156
            java.lang.String r1 = r0.zzb
            r18 = r5
            int r5 = r13.zzb
            int r6 = r15.zzb
            int r6 = r6 + r5
            r19 = r6
            int r6 = r14.zzb
            int r6 = r19 + r6
            byte[] r6 = new byte[r6]
            r19 = r7
            byte[] r7 = r13.zza
            r20 = r10
            r10 = 0
            java.lang.System.arraycopy(r7, r10, r6, r10, r5)
            byte[] r5 = r15.zza
            int r7 = r13.zzb
            int r11 = r15.zzb
            java.lang.System.arraycopy(r5, r10, r6, r7, r11)
            byte[] r5 = r14.zza
            int r7 = r13.zzb
            int r11 = r15.zzb
            int r7 = r7 + r11
            int r11 = r14.zzb
            java.lang.System.arraycopy(r5, r10, r6, r7, r11)
            byte[] r5 = r15.zza
            int r7 = r15.zzb
            r11 = 3
            r13 = 0
            com.google.android.gms.internal.ads.zzfj r5 = com.google.android.gms.internal.ads.zzfp.zzc(r5, r11, r7, r13)
            com.google.android.gms.internal.ads.zzfe r7 = r5.zza
            if (r7 == 0) goto L_0x00e1
            int r11 = r7.zzf
            int[] r13 = r7.zze
            int r14 = r7.zzd
            int r15 = r7.zzc
            boolean r10 = r7.zzb
            int r7 = r7.zza
            r22 = r7
            r23 = r10
            r27 = r11
            r26 = r13
            r25 = r14
            r24 = r15
            java.lang.String r13 = com.google.android.gms.internal.ads.zzdd.zzd(r22, r23, r24, r25, r26, r27)
        L_0x00e1:
            com.google.android.gms.internal.ads.zzab r7 = new com.google.android.gms.internal.ads.zzab
            r7.<init>()
            r7.zzL(r1)
            java.lang.String r1 = "video/hevc"
            r7.zzZ(r1)
            r7.zzA(r13)
            int r1 = r5.zzd
            r7.zzae(r1)
            int r1 = r5.zze
            r7.zzJ(r1)
            com.google.android.gms.internal.ads.zzk r1 = new com.google.android.gms.internal.ads.zzk
            r1.<init>()
            int r10 = r5.zzh
            r1.zzc(r10)
            int r10 = r5.zzi
            r1.zzb(r10)
            int r10 = r5.zzj
            r1.zzd(r10)
            int r10 = r5.zzb
            int r10 = r10 + 8
            r1.zzf(r10)
            int r10 = r5.zzc
            int r10 = r10 + 8
            r1.zza(r10)
            com.google.android.gms.internal.ads.zzm r1 = r1.zzg()
            r7.zzB(r1)
            float r1 = r5.zzf
            r7.zzV(r1)
            int r1 = r5.zzg
            r7.zzR(r1)
            java.util.List r1 = java.util.Collections.singletonList(r6)
            r7.zzM(r1)
            com.google.android.gms.internal.ads.zzad r1 = r7.zzaf()
            com.google.android.gms.internal.ads.zzadx r5 = r0.zzc
            r5.zzl(r1)
            int r5 = r1.zzq
            r6 = -1
            if (r5 == r6) goto L_0x0146
            r17 = 1
            goto L_0x0148
        L_0x0146:
            r17 = 0
        L_0x0148:
            com.google.android.gms.internal.ads.zzfwq.zzk(r17)
            com.google.android.gms.internal.ads.zzanq r5 = r0.zza
            int r1 = r1.zzq
            r5.zze(r1)
            r1 = 1
            r0.zze = r1
            goto L_0x015c
        L_0x0156:
            r18 = r5
            r19 = r7
            r20 = r10
        L_0x015c:
            com.google.android.gms.internal.ads.zzane r1 = r0.zzj
            boolean r1 = r1.zzd(r4)
            r5 = 5
            if (r1 == 0) goto L_0x0184
            com.google.android.gms.internal.ads.zzane r1 = r0.zzj
            byte[] r6 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfp.zzb(r6, r1)
            com.google.android.gms.internal.ads.zzed r6 = r0.zzn
            com.google.android.gms.internal.ads.zzane r7 = r0.zzj
            byte[] r7 = r7.zza
            r6.zzJ(r7, r1)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzn
            r1.zzM(r5)
            com.google.android.gms.internal.ads.zzanq r1 = r0.zza
            com.google.android.gms.internal.ads.zzed r6 = r0.zzn
            r1.zza(r8, r6)
        L_0x0184:
            com.google.android.gms.internal.ads.zzane r1 = r0.zzk
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x01ab
            com.google.android.gms.internal.ads.zzane r1 = r0.zzk
            byte[] r4 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzfp.zzb(r4, r1)
            com.google.android.gms.internal.ads.zzed r4 = r0.zzn
            com.google.android.gms.internal.ads.zzane r6 = r0.zzk
            byte[] r6 = r6.zza
            r4.zzJ(r6, r1)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzn
            r1.zzM(r5)
            com.google.android.gms.internal.ads.zzanq r1 = r0.zza
            com.google.android.gms.internal.ads.zzed r4 = r0.zzn
            r1.zza(r8, r4)
        L_0x01ab:
            r16 = 1
            int r13 = r19 >> 1
            long r14 = r0.zzm
            com.google.android.gms.internal.ads.zzamu r9 = r0.zzd
            boolean r1 = r0.zze
            r16 = r1
            r10 = r20
            r9.zze(r10, r12, r13, r14, r16)
            boolean r1 = r0.zze
            if (r1 != 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzane r1 = r0.zzg
            r1.zzc(r13)
            com.google.android.gms.internal.ads.zzane r1 = r0.zzh
            r1.zzc(r13)
            com.google.android.gms.internal.ads.zzane r1 = r0.zzi
            r1.zzc(r13)
        L_0x01cf:
            com.google.android.gms.internal.ads.zzane r1 = r0.zzj
            r1.zzc(r13)
            com.google.android.gms.internal.ads.zzane r1 = r0.zzk
            r1.zzc(r13)
            r6 = r29
            r1 = r18
            goto L_0x0030
        L_0x01df:
            r0.zzf(r3, r1, r2)
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zza(com.google.android.gms.internal.ads.zzed):void");
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zzb = zzaoa.zzb();
        this.zzc = zzacu.zzw(zzaoa.zza(), 2);
        this.zzd = new zzamu(this.zzc);
        this.zza.zzb(zzacu, zzaoa);
    }

    public final void zzc(boolean z) {
        zzdb.zzb(this.zzc);
        int i = zzen.zza;
        if (z) {
            this.zza.zzc();
            this.zzd.zza(this.zzl);
        }
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzl = 0;
        this.zzm = -9223372036854775807L;
        zzfp.zzh(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        this.zza.zzc();
        zzamu zzamu = this.zzd;
        if (zzamu != null) {
            zzamu.zzd();
        }
    }
}
