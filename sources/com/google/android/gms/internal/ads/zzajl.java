package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzajl implements zzajr {
    private final zzajq zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzajw zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajl(zzajw zzajw, long j, long j2, long j3, long j4, boolean z) {
        zzdb.zzd(j >= 0 && j2 > j);
        this.zzd = zzajw;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzajq();
    }

    public final /* bridge */ /* synthetic */ zzadq zze() {
        if (this.zzf != 0) {
            return new zzajj(this, (zzajk) null);
        }
        return null;
    }

    public final void zzg(long j) {
        this.zzh = Math.max(0, Math.min(j, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzacs r25) throws java.io.IOException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            int r2 = r0.zze
            r3 = 0
            r4 = 1
            r6 = -1
            if (r2 == 0) goto L_0x00f9
            if (r2 == r4) goto L_0x010c
            r4 = 2
            r10 = 3
            if (r2 == r4) goto L_0x001b
            if (r2 == r10) goto L_0x0015
            return r6
        L_0x0015:
            r20 = r6
            r15 = 2
            goto L_0x00c0
        L_0x001b:
            long r11 = r0.zzi
            long r13 = r0.zzj
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x002a
            r13 = r6
            r20 = r13
        L_0x0026:
            r15 = 2
            goto L_0x00b9
        L_0x002a:
            long r11 = r1.zzf()
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            boolean r2 = r2.zzc(r1, r13)
            if (r2 != 0) goto L_0x0047
            long r13 = r0.zzi
            int r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x003f
            r20 = r6
            goto L_0x0026
        L_0x003f:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0047:
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r2.zzb(r1, r3)
            r1.zzj()
            long r13 = r0.zzh
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r15 = 2
            long r8 = r2.zzb
            long r13 = r13 - r8
            int r4 = r2.zzd
            int r2 = r2.zze
            int r4 = r4 + r2
            r17 = 0
            int r2 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x006e
            r17 = 72000(0x11940, double:3.55727E-319)
            int r17 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r17 >= 0) goto L_0x006e
            r13 = r6
            r20 = r13
            goto L_0x00b9
        L_0x006e:
            if (r2 >= 0) goto L_0x0075
            r0.zzj = r11
            r0.zzl = r8
            goto L_0x0080
        L_0x0075:
            long r11 = (long) r4
            long r17 = r1.zzf()
            long r11 = r17 + r11
            r0.zzi = r11
            r0.zzk = r8
        L_0x0080:
            long r8 = r0.zzj
            long r11 = r0.zzi
            long r17 = r8 - r11
            r19 = 100000(0x186a0, double:4.94066E-319)
            int r19 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r19 >= 0) goto L_0x0093
            r0.zzj = r11
            r20 = r6
            r13 = r11
            goto L_0x00b9
        L_0x0093:
            long r3 = (long) r4
            if (r2 > 0) goto L_0x0099
            r20 = r15
            goto L_0x009b
        L_0x0099:
            r20 = 1
        L_0x009b:
            long r22 = r1.zzf()
            long r3 = r3 * r20
            long r22 = r22 - r3
            long r13 = r13 * r17
            long r2 = r0.zzl
            r20 = r6
            long r5 = r0.zzk
            long r2 = r2 - r5
            long r13 = r13 / r2
            long r2 = r22 + r13
            long r8 = r8 + r20
            long r2 = java.lang.Math.min(r2, r8)
            long r13 = java.lang.Math.max(r11, r2)
        L_0x00b9:
            int r2 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r2 == 0) goto L_0x00be
            return r13
        L_0x00be:
            r0.zze = r10
        L_0x00c0:
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r3 = r20
            r2.zzc(r1, r3)
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            long r3 = r2.zzb
            long r5 = r0.zzh
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e2
            r1.zzj()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            long r1 = r1 + r15
            long r1 = -r1
            return r1
        L_0x00e2:
            int r3 = r2.zzd
            int r2 = r2.zze
            int r3 = r3 + r2
            r1.zzk(r3)
            long r2 = r1.zzf()
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
            r20 = -1
            goto L_0x00c0
        L_0x00f9:
            long r2 = r1.zzf()
            r0.zzg = r2
            r0.zze = r4
            long r5 = r0.zzc
            r7 = -65307(0xffffffffffff00e5, double:NaN)
            long r5 = r5 + r7
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x010c
            return r5
        L_0x010c:
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r5 = -1
            boolean r2 = r2.zzc(r1, r5)
            if (r2 == 0) goto L_0x016c
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            int r3 = r2.zzd
            int r2 = r2.zze
            int r3 = r3 + r2
            r1.zzk(r3)
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            long r2 = r2.zzb
        L_0x012f:
            com.google.android.gms.internal.ads.zzajq r5 = r0.zza
            int r6 = r5.zza
            r7 = 4
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0164
            r6 = -1
            boolean r5 = r5.zzc(r1, r6)
            if (r5 == 0) goto L_0x0164
            long r8 = r1.zzf()
            long r10 = r0.zzc
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzajq r5 = r0.zza
            boolean r5 = r5.zzb(r1, r4)
            if (r5 == 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzajq r5 = r0.zza
            int r8 = r5.zzd
            int r5 = r5.zze
            int r8 = r8 + r5
            boolean r5 = com.google.android.gms.internal.ads.zzacv.zze(r1, r8)
            if (r5 != 0) goto L_0x015f
            goto L_0x0164
        L_0x015f:
            com.google.android.gms.internal.ads.zzajq r2 = r0.zza
            long r2 = r2.zzb
            goto L_0x012f
        L_0x0164:
            r0.zzf = r2
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x016c:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajl.zzd(com.google.android.gms.internal.ads.zzacs):long");
    }
}
