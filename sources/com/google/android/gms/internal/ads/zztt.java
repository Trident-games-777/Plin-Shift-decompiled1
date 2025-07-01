package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zztt implements zzvh {
    private final zzacw zza;
    private zzacr zzb;
    private zzacs zzc;

    public zztt(zzacw zzacw) {
        this.zza = zzacw;
    }

    public final int zza(zzadn zzadn) throws IOException {
        zzacr zzacr = this.zzb;
        zzacr.getClass();
        zzacr zzacr2 = zzacr;
        zzacs zzacs = this.zzc;
        zzacs.getClass();
        zzacs zzacs2 = zzacs;
        return zzacr.zzb(zzacs, zzadn);
    }

    public final long zzb() {
        zzacs zzacs = this.zzc;
        if (zzacs != null) {
            return zzacs.zzf();
        }
        return -1;
    }

    public final void zzc() {
        zzacr zzacr = this.zzb;
        if (zzacr != null && (zzacr instanceof zzahw)) {
            ((zzahw) zzacr).zza();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r1.zzf() != r3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        if (r1.zzf() != r3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007a, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzn r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzacu r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzacg r1 = new com.google.android.gms.internal.ads.zzacg
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.zzc = r1
            com.google.android.gms.internal.ads.zzacr r8 = r7.zzb
            if (r8 == 0) goto L_0x000f
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzacw r8 = r7.zza
            com.google.android.gms.internal.ads.zzacr[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzfzl r11 = com.google.android.gms.internal.ads.zzfzo.zzi(r10)
            r12 = 0
            r13 = 1
            if (r10 != r13) goto L_0x0024
            r8 = r8[r12]
            r7.zzb = r8
            goto L_0x008a
        L_0x0024:
            r14 = r12
        L_0x0025:
            if (r14 >= r10) goto L_0x0086
            r0 = r8[r14]
            boolean r2 = r0.zzi(r1)     // Catch:{ EOFException -> 0x006d, all -> 0x0057 }
            if (r2 == 0) goto L_0x0043
            r7.zzb = r0     // Catch:{ EOFException -> 0x006d, all -> 0x0057 }
            if (r0 != 0) goto L_0x003b
            long r5 = r1.zzf()
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x003c
        L_0x003b:
            r12 = r13
        L_0x003c:
            com.google.android.gms.internal.ads.zzdb.zzf(r12)
            r1.zzj()
            goto L_0x0086
        L_0x0043:
            java.util.List r0 = r0.zzd()     // Catch:{ EOFException -> 0x006d, all -> 0x0057 }
            r11.zzh(r0)     // Catch:{ EOFException -> 0x006d, all -> 0x0057 }
            com.google.android.gms.internal.ads.zzacr r0 = r7.zzb
            if (r0 != 0) goto L_0x007c
            long r5 = r1.zzf()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            goto L_0x007c
        L_0x0057:
            r0 = move-exception
            r8 = r0
            com.google.android.gms.internal.ads.zzacr r9 = r7.zzb
            if (r9 != 0) goto L_0x0065
            long r9 = r1.zzf()
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x0066
        L_0x0065:
            r12 = r13
        L_0x0066:
            com.google.android.gms.internal.ads.zzdb.zzf(r12)
            r1.zzj()
            throw r8
        L_0x006d:
            com.google.android.gms.internal.ads.zzacr r0 = r7.zzb
            if (r0 != 0) goto L_0x007c
            long r5 = r1.zzf()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r0 = r12
            goto L_0x007d
        L_0x007c:
            r0 = r13
        L_0x007d:
            com.google.android.gms.internal.ads.zzdb.zzf(r0)
            r1.zzj()
            int r14 = r14 + 1
            goto L_0x0025
        L_0x0086:
            com.google.android.gms.internal.ads.zzacr r10 = r7.zzb
            if (r10 == 0) goto L_0x0090
        L_0x008a:
            com.google.android.gms.internal.ads.zzacr r8 = r7.zzb
            r8.zze(r15)
            return
        L_0x0090:
            com.google.android.gms.internal.ads.zzws r10 = new com.google.android.gms.internal.ads.zzws
            java.lang.String r12 = ", "
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            com.google.android.gms.internal.ads.zzfzo r8 = com.google.android.gms.internal.ads.zzfzo.zzm(r8)
            com.google.android.gms.internal.ads.zzts r13 = new com.google.android.gms.internal.ads.zzts
            r13.<init>()
            java.util.List r8 = com.google.android.gms.internal.ads.zzgae.zzb(r8, r13)
            java.util.Iterator r8 = r8.iterator()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            com.google.android.gms.internal.ads.zzfwi.zzc(r13, r8, r12)
            java.lang.String r8 = r13.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "None of the available extractors ("
            r12.<init>(r13)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            r12 = r9
            android.net.Uri r12 = (android.net.Uri) r12
            com.google.android.gms.internal.ads.zzfzo r11 = r11.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztt.zzd(com.google.android.gms.internal.ads.zzn, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzacu):void");
    }

    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzf(long j, long j2) {
        zzacr zzacr = this.zzb;
        zzacr.getClass();
        zzacr zzacr2 = zzacr;
        zzacr.zzf(j, j2);
    }
}
