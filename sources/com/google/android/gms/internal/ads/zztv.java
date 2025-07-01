package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zztv implements zzup, zzuo {
    public final zzup zza;
    long zzb;
    private zzuo zzc;
    private zztu[] zzd = new zztu[0];
    private long zze = 0;

    public zztv(zzup zzup, boolean z, long j, long j2) {
        this.zza = zzup;
        this.zzb = j2;
    }

    public final long zza(long j, zzls zzls) {
        if (j == 0) {
            return 0;
        }
        long max = Math.max(0, Math.min(zzls.zzc, j));
        long j2 = zzls.zzd;
        long j3 = this.zzb;
        long max2 = Math.max(0, Math.min(j2, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j));
        if (!(max == zzls.zzc && max2 == zzls.zzd)) {
            zzls = new zzls(max, max2);
        }
        return this.zza.zza(j, zzls);
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzb2 < j) {
                return zzb2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzc2 < j) {
                return zzc2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzd() {
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long zzd2 = zzd();
            return zzd2 != -9223372036854775807L ? zzd2 : j;
        }
        long zzd3 = this.zza.zzd();
        if (zzd3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = false;
        zzdb.zzf(zzd3 >= 0);
        long j2 = this.zzb;
        if (j2 == Long.MIN_VALUE || zzd3 <= j2) {
            z = true;
        }
        zzdb.zzf(z);
        return zzd3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 > r3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zze(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zztu[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.zzc()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.gms.internal.ads.zzup r0 = r7.zza
            long r0 = r0.zze(r8)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r9 = 1
            if (r8 == 0) goto L_0x0035
            r3 = 0
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0036
            long r3 = r7.zzb
            r5 = -9223372036854775808
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0035
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 > 0) goto L_0x0036
        L_0x0035:
            r2 = r9
        L_0x0036:
            com.google.android.gms.internal.ads.zzdb.zzf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zze(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r14 > r2) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzyd[] r14, boolean[] r15, com.google.android.gms.internal.ads.zzwg[] r16, boolean[] r17, long r18) {
        /*
            r13 = this;
            r0 = r16
            int r1 = r0.length
            com.google.android.gms.internal.ads.zztu[] r2 = new com.google.android.gms.internal.ads.zztu[r1]
            r13.zzd = r2
            com.google.android.gms.internal.ads.zzwg[] r6 = new com.google.android.gms.internal.ads.zzwg[r1]
            r1 = 0
            r2 = r1
        L_0x000b:
            int r3 = r0.length
            r10 = 0
            if (r2 >= r3) goto L_0x0020
            com.google.android.gms.internal.ads.zztu[] r3 = r13.zzd
            r4 = r0[r2]
            com.google.android.gms.internal.ads.zztu r4 = (com.google.android.gms.internal.ads.zztu) r4
            r3[r2] = r4
            if (r4 == 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzwg r10 = r4.zza
        L_0x001b:
            r6[r2] = r10
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0020:
            com.google.android.gms.internal.ads.zzup r3 = r13.zza
            r4 = r14
            r5 = r15
            r7 = r17
            r8 = r18
            long r14 = r3.zzf(r4, r5, r6, r7, r8)
            boolean r2 = r13.zzq()
            r3 = 0
            if (r2 == 0) goto L_0x003a
            int r2 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x003a
            r7 = r3
            goto L_0x003c
        L_0x003a:
            r7 = r18
        L_0x003c:
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13.zze = r11
            int r2 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            r5 = 1
            if (r2 == 0) goto L_0x005a
            int r2 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0059
            long r2 = r13.zzb
            r7 = -9223372036854775808
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x005a
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r5 = r1
        L_0x005a:
            com.google.android.gms.internal.ads.zzdb.zzf(r5)
        L_0x005d:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0083
            r2 = r6[r1]
            if (r2 != 0) goto L_0x0069
            com.google.android.gms.internal.ads.zztu[] r2 = r13.zzd
            r2[r1] = r10
            goto L_0x007a
        L_0x0069:
            com.google.android.gms.internal.ads.zztu[] r3 = r13.zzd
            r4 = r3[r1]
            if (r4 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzwg r4 = r4.zza
            if (r4 == r2) goto L_0x007a
        L_0x0073:
            com.google.android.gms.internal.ads.zztu r4 = new com.google.android.gms.internal.ads.zztu
            r4.<init>(r13, r2)
            r3[r1] = r4
        L_0x007a:
            com.google.android.gms.internal.ads.zztu[] r2 = r13.zzd
            r2 = r2[r1]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x005d
        L_0x0083:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zzf(com.google.android.gms.internal.ads.zzyd[], boolean[], com.google.android.gms.internal.ads.zzwg[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void zzg(zzwi zzwi) {
        zzup zzup = (zzup) zzwi;
        zzuo zzuo = this.zzc;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzg(this);
    }

    public final zzwr zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzuo zzuo, long j) {
        this.zzc = zzuo;
        this.zza.zzl(this, j);
    }

    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    public final boolean zzo(zzko zzko) {
        return this.zza.zzo(zzko);
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }

    public final void zzi(zzup zzup) {
        zzuo zzuo = this.zzc;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzi(this);
    }
}
