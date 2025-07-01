package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaoh implements zzacr {
    private zzacu zza;
    private zzadx zzb;
    private int zzc = 0;
    private long zzd = -1;
    private zzaof zze;
    private int zzf = -1;
    private long zzg = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r1 != 65534) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f1, code lost:
        if (r2 == 32) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r19, com.google.android.gms.internal.ads.zzadn r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzb
            com.google.android.gms.internal.ads.zzdb.zzb(r2)
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            int r2 = r0.zzc
            r3 = -1
            r4 = 4
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0152
            r7 = 2
            r8 = -1
            if (r2 == r5) goto L_0x011f
            r10 = 3
            if (r2 == r7) goto L_0x00a5
            if (r2 == r10) goto L_0x003f
            long r10 = r0.zzg
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r5 = r6
        L_0x0025:
            com.google.android.gms.internal.ads.zzdb.zzf(r5)
            long r4 = r0.zzg
            long r7 = r1.zzf()
            long r4 = r4 - r7
            com.google.android.gms.internal.ads.zzaof r2 = r0.zze
            r2.getClass()
            r7 = r2
            com.google.android.gms.internal.ads.zzaof r7 = (com.google.android.gms.internal.ads.zzaof) r7
            boolean r1 = r2.zzc(r1, r4)
            if (r1 == 0) goto L_0x003e
            return r3
        L_0x003e:
            return r6
        L_0x003f:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzaok.zza(r1)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            r0.zzf = r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r10 = r0.zzd
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0065
            r12 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0065
            r2 = r10
        L_0x0065:
            int r5 = r0.zzf
            long r10 = (long) r5
            long r10 = r10 + r2
            r0.zzg = r10
            long r1 = r1.zzd()
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x0095
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0095
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Data exceeds input length: "
            r3.<init>(r5)
            r3.append(r10)
            java.lang.String r5 = ", "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "WavExtractor"
            com.google.android.gms.internal.ads.zzdt.zzf(r5, r3)
            r0.zzg = r1
            r10 = r1
        L_0x0095:
            com.google.android.gms.internal.ads.zzaof r1 = r0.zze
            r1.getClass()
            r2 = r1
            com.google.android.gms.internal.ads.zzaof r2 = (com.google.android.gms.internal.ads.zzaof) r2
            int r2 = r0.zzf
            r1.zza(r2, r10)
            r0.zzc = r4
            return r6
        L_0x00a5:
            com.google.android.gms.internal.ads.zzaoi r15 = com.google.android.gms.internal.ads.zzaok.zzb(r1)
            int r1 = r15.zza
            r2 = 17
            if (r1 != r2) goto L_0x00bb
            com.google.android.gms.internal.ads.zzaoe r1 = new com.google.android.gms.internal.ads.zzaoe
            com.google.android.gms.internal.ads.zzacu r2 = r0.zza
            com.google.android.gms.internal.ads.zzadx r3 = r0.zzb
            r1.<init>(r2, r3, r15)
            r0.zze = r1
            goto L_0x0109
        L_0x00bb:
            r2 = 6
            if (r1 != r2) goto L_0x00ce
            com.google.android.gms.internal.ads.zzaog r12 = new com.google.android.gms.internal.ads.zzaog
            com.google.android.gms.internal.ads.zzacu r13 = r0.zza
            com.google.android.gms.internal.ads.zzadx r14 = r0.zzb
            java.lang.String r16 = "audio/g711-alaw"
            r17 = -1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r12
            goto L_0x0109
        L_0x00ce:
            r2 = 7
            if (r1 != r2) goto L_0x00e1
            com.google.android.gms.internal.ads.zzaog r12 = new com.google.android.gms.internal.ads.zzaog
            com.google.android.gms.internal.ads.zzacu r13 = r0.zza
            com.google.android.gms.internal.ads.zzadx r14 = r0.zzb
            java.lang.String r16 = "audio/g711-mlaw"
            r17 = -1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r12
            goto L_0x0109
        L_0x00e1:
            int r2 = r15.zze
            if (r1 == r5) goto L_0x00f4
            if (r1 == r10) goto L_0x00ef
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r1 == r3) goto L_0x00f4
        L_0x00ec:
            r17 = r6
            goto L_0x00fa
        L_0x00ef:
            r3 = 32
            if (r2 != r3) goto L_0x00ec
            goto L_0x00f8
        L_0x00f4:
            int r4 = com.google.android.gms.internal.ads.zzen.zzn(r2)
        L_0x00f8:
            r17 = r4
        L_0x00fa:
            if (r17 == 0) goto L_0x010c
            com.google.android.gms.internal.ads.zzaog r12 = new com.google.android.gms.internal.ads.zzaog
            com.google.android.gms.internal.ads.zzacu r13 = r0.zza
            com.google.android.gms.internal.ads.zzadx r14 = r0.zzb
            java.lang.String r16 = "audio/raw"
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r12
        L_0x0109:
            r0.zzc = r10
            return r6
        L_0x010c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unsupported WAV format type: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x011f:
            com.google.android.gms.internal.ads.zzed r2 = new com.google.android.gms.internal.ads.zzed
            r3 = 8
            r2.<init>((int) r3)
            com.google.android.gms.internal.ads.zzaoj r4 = com.google.android.gms.internal.ads.zzaoj.zza(r1, r2)
            int r5 = r4.zza
            r10 = 1685272116(0x64733634, float:1.7945858E22)
            if (r5 == r10) goto L_0x0135
            r1.zzj()
            goto L_0x014d
        L_0x0135:
            r1.zzg(r3)
            r2.zzL(r6)
            byte[] r5 = r2.zzN()
            r1.zzh(r5, r6, r3)
            long r8 = r2.zzr()
            long r4 = r4.zzb
            int r2 = (int) r4
            int r2 = r2 + r3
            r1.zzk(r2)
        L_0x014d:
            r0.zzd = r8
            r0.zzc = r7
            return r6
        L_0x0152:
            long r7 = r1.zzf()
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x015e
            r2 = r5
            goto L_0x015f
        L_0x015e:
            r2 = r6
        L_0x015f:
            com.google.android.gms.internal.ads.zzdb.zzf(r2)
            int r2 = r0.zzf
            if (r2 == r3) goto L_0x016c
            r1.zzk(r2)
            r0.zzc = r4
            goto L_0x0181
        L_0x016c:
            boolean r2 = com.google.android.gms.internal.ads.zzaok.zzc(r1)
            if (r2 == 0) goto L_0x0182
            long r2 = r1.zze()
            long r7 = r1.zzf()
            long r2 = r2 - r7
            int r2 = (int) r2
            r1.zzk(r2)
            r0.zzc = r5
        L_0x0181:
            return r6
        L_0x0182:
            java.lang.String r1 = "Unsupported or unrecognized wav file type."
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoh.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zza = zzacu;
        this.zzb = zzacu.zzw(0, 1);
        zzacu.zzD();
    }

    public final void zzf(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzaof zzaof = this.zze;
        if (zzaof != null) {
            zzaof.zzb(j2);
        }
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        return zzaok.zzc(zzacs);
    }
}
