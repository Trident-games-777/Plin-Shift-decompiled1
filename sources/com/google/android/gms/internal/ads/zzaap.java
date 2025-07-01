package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaap {
    private final zzaao zza;
    private final zzaat zzb;
    private boolean zzc;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzf;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private boolean zzi;
    private float zzj = 1.0f;
    private zzdc zzk = zzdc.zza;

    public zzaap(Context context, zzaao zzaao, long j) {
        this.zza = zzaao;
        this.zzb = new zzaat(context);
    }

    private final void zzq(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        if (r15 > 100000) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r3 >= r26) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
        if (r0.zzc != false) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(long r20, long r22, long r24, long r26, boolean r28, com.google.android.gms.internal.ads.zzaan r29) throws com.google.android.gms.internal.ads.zzig {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            r5 = r29
            com.google.android.gms.internal.ads.zzaan.zzg(r5)
            long r6 = r0.zze
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0018
            r0.zze = r3
        L_0x0018:
            long r6 = r0.zzg
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzaat r6 = r0.zzb
            r6.zzd(r1)
            r0.zzg = r1
        L_0x0025:
            long r1 = r1 - r3
            float r6 = r0.zzj
            double r6 = (double) r6
            boolean r10 = r0.zzc
            double r1 = (double) r1
            double r1 = r1 / r6
            long r1 = (long) r1
            if (r10 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzdc r6 = r0.zzk
            long r6 = r6.zzb()
            long r6 = com.google.android.gms.internal.ads.zzen.zzs(r6)
            long r6 = r6 - r24
            long r1 = r1 - r6
        L_0x003d:
            r5.zza = r1
            long r1 = r5.zza
            long r6 = r0.zzh
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r10 = -30000(0xffffffffffff8ad0, double:NaN)
            r7 = 3
            r12 = 2
            r13 = 0
            r14 = 1
            if (r6 == 0) goto L_0x0059
            boolean r6 = r0.zzi
            if (r6 != 0) goto L_0x0059
            r20 = r7
            r17 = r8
            goto L_0x009c
        L_0x0059:
            int r6 = r0.zzd
            if (r6 == 0) goto L_0x0093
            if (r6 == r14) goto L_0x009b
            if (r6 == r12) goto L_0x008a
            if (r6 != r7) goto L_0x0084
            com.google.android.gms.internal.ads.zzdc r6 = r0.zzk
            long r15 = r6.zzb()
            long r15 = com.google.android.gms.internal.ads.zzen.zzs(r15)
            r20 = r7
            r17 = r8
            long r7 = r0.zzf
            long r15 = r15 - r7
            boolean r6 = r0.zzc
            if (r6 == 0) goto L_0x009c
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x009c
            r1 = 100000(0x186a0, double:4.94066E-319)
            int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x009c
            goto L_0x009b
        L_0x0084:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x008a:
            r20 = r7
            r17 = r8
            int r1 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r1 < 0) goto L_0x009c
            goto L_0x009b
        L_0x0093:
            r20 = r7
            r17 = r8
            boolean r1 = r0.zzc
            if (r1 == 0) goto L_0x009c
        L_0x009b:
            return r13
        L_0x009c:
            boolean r1 = r0.zzc
            r2 = 5
            if (r1 == 0) goto L_0x0108
            long r6 = r0.zze
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x00a8
            goto L_0x0108
        L_0x00a8:
            com.google.android.gms.internal.ads.zzdc r1 = r0.zzk
            long r6 = r1.zzc()
            com.google.android.gms.internal.ads.zzaat r1 = r0.zzb
            long r8 = r5.zza
            r15 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r15
            long r8 = r8 + r6
            long r8 = r1.zza(r8)
            r5.zzb = r8
            long r8 = r5.zzb
            long r8 = r8 - r6
            long r8 = r8 / r15
            r5.zza = r8
            long r6 = r0.zzh
            int r1 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x00d3
            boolean r1 = r0.zzi
            if (r1 != 0) goto L_0x00d3
            r13 = r14
        L_0x00d3:
            com.google.android.gms.internal.ads.zzaao r1 = r0.zza
            long r6 = r5.zza
            r8 = -500000(0xfffffffffff85ee0, double:NaN)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ed
            if (r28 != 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzaai r1 = (com.google.android.gms.internal.ads.zzaai) r1
            boolean r1 = r1.zzaT(r3, r13)
            if (r1 != 0) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r1 = 4
            return r1
        L_0x00ed:
            long r3 = r5.zza
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x00fb
            if (r28 != 0) goto L_0x00fb
            if (r13 == 0) goto L_0x00fa
            return r20
        L_0x00fa:
            return r12
        L_0x00fb:
            long r3 = r5.zza
            r5 = 50000(0xc350, double:2.47033E-319)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0107
            return r2
        L_0x0107:
            return r14
        L_0x0108:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaap.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzaan):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    public final void zzd() {
        zzq(0);
    }

    public final void zze(boolean z) {
        this.zzd = z ? 1 : 0;
    }

    public final void zzf() {
        zzq(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzen.zzs(this.zzk.zzb());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzq(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzj(int i) {
        this.zzb.zzj(i);
    }

    public final void zzk(zzdc zzdc) {
        this.zzk = zzdc;
    }

    public final void zzl(float f) {
        this.zzb.zzc(f);
    }

    public final void zzm(Surface surface) {
        this.zzb.zzi(surface);
        zzq(1);
    }

    public final void zzn(float f) {
        if (f != this.zzj) {
            this.zzj = f;
            this.zzb.zze(f);
        }
    }

    public final boolean zzo(boolean z) {
        boolean z2 = true;
        if (!z || this.zzd != 3) {
            if (this.zzh == -9223372036854775807L) {
                return false;
            }
            if (this.zzk.zzb() >= this.zzh) {
                z2 = false;
            }
            return z2;
        }
        this.zzh = -9223372036854775807L;
        return z2;
    }

    public final boolean zzp() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzen.zzs(this.zzk.zzb());
        return i != 3;
    }
}
