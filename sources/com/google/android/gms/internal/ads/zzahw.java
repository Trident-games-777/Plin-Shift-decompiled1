package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzahw implements zzacr {
    private final zzed zza;
    private final zzadj zzb;
    private final zzadf zzc;
    private final zzadh zzd;
    private final zzadx zze;
    private zzacu zzf;
    private zzadx zzg;
    private zzadx zzh;
    private int zzi;
    private zzbd zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private zzahy zzp;
    private boolean zzq;

    public zzahw() {
        throw null;
    }

    public zzahw(int i) {
        this.zza = new zzed(10);
        this.zzb = new zzadj();
        this.zzc = new zzadf();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzadh();
        zzacm zzacm = new zzacm();
        this.zze = zzacm;
        this.zzh = zzacm;
        this.zzn = -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.google.android.gms.internal.ads.zzaht} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: com.google.android.gms.internal.ads.zzaht} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: com.google.android.gms.internal.ads.zzaht} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: com.google.android.gms.internal.ads.zzahx} */
    /* JADX WARNING: type inference failed for: r2v27, types: [com.google.android.gms.internal.ads.zzahy] */
    /* JADX WARNING: type inference failed for: r2v34 */
    /* JADX WARNING: type inference failed for: r2v35 */
    /* JADX WARNING: type inference failed for: r2v62 */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cd, code lost:
        if (r2 != null) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cf, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x024b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzg(com.google.android.gms.internal.ads.zzacs r36) throws java.io.IOException {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            int r2 = r0.zzi
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.zzm(r1, r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.google.android.gms.internal.ads.zzahy r2 = r0.zzp
            r8 = 1
            if (r2 != 0) goto L_0x0264
            com.google.android.gms.internal.ads.zzadj r2 = r0.zzb
            com.google.android.gms.internal.ads.zzed r14 = new com.google.android.gms.internal.ads.zzed
            int r2 = r2.zzc
            r14.<init>((int) r2)
            byte[] r2 = r14.zzN()
            com.google.android.gms.internal.ads.zzadj r9 = r0.zzb
            int r9 = r9.zzc
            r1.zzh(r2, r4, r9)
            com.google.android.gms.internal.ads.zzadj r2 = r0.zzb
            int r9 = r2.zza
            r9 = r9 & r8
            r10 = 36
            r11 = 21
            if (r9 == 0) goto L_0x0039
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0040
            r11 = r10
            goto L_0x0040
        L_0x0039:
            int r2 = r2.zze
            if (r2 == r8) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r11 = 13
        L_0x0040:
            int r2 = r14.zze()
            int r9 = r11 + 4
            r12 = 1231971951(0x496e666f, float:976486.94)
            r13 = 1447187017(0x56425249, float:5.3414667E13)
            r15 = 1483304551(0x58696e67, float:1.02664153E15)
            if (r2 < r9) goto L_0x005e
            r14.zzL(r11)
            int r2 = r14.zzg()
            if (r2 == r15) goto L_0x0072
            if (r2 != r12) goto L_0x005e
            r2 = r12
            goto L_0x0072
        L_0x005e:
            int r2 = r14.zze()
            r9 = 40
            if (r2 < r9) goto L_0x0071
            r14.zzL(r10)
            int r2 = r14.zzg()
            if (r2 != r13) goto L_0x0071
            r2 = r13
            goto L_0x0072
        L_0x0071:
            r2 = r4
        L_0x0072:
            if (r2 == r12) goto L_0x009b
            if (r2 == r13) goto L_0x007d
            if (r2 == r15) goto L_0x009b
            r1.zzj()
            r2 = 0
            goto L_0x0092
        L_0x007d:
            long r9 = r1.zzd()
            long r11 = r1.zzf()
            com.google.android.gms.internal.ads.zzadj r13 = r0.zzb
            com.google.android.gms.internal.ads.zzahz r2 = com.google.android.gms.internal.ads.zzahz.zzb(r9, r11, r13, r14)
            com.google.android.gms.internal.ads.zzadj r9 = r0.zzb
            int r9 = r9.zzc
            r1.zzk(r9)
        L_0x0092:
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r20 = 0
            goto L_0x016b
        L_0x009b:
            com.google.android.gms.internal.ads.zzadj r9 = r0.zzb
            com.google.android.gms.internal.ads.zzaia r9 = com.google.android.gms.internal.ads.zzaia.zzb(r9, r14)
            com.google.android.gms.internal.ads.zzadf r10 = r0.zzc
            boolean r11 = r10.zza()
            if (r11 != 0) goto L_0x00b5
            int r11 = r9.zzd
            if (r11 == r3) goto L_0x00b5
            int r12 = r9.zze
            if (r12 == r3) goto L_0x00b5
            r10.zza = r11
            r10.zzb = r12
        L_0x00b5:
            long r10 = r1.zzf()
            long r12 = r1.zzd()
            r16 = -1
            int r12 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x00fe
            long r12 = r9.zzc
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x00fe
            long r18 = r1.zzd()
            long r12 = r12 + r10
            int r14 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x00fe
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r5 = r1.zzd()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r20 = 0
            java.lang.String r7 = "Data size mismatch between stream ("
            r14.<init>(r7)
            r14.append(r5)
            java.lang.String r5 = ") and Xing frame ("
            r14.append(r5)
            r14.append(r12)
            java.lang.String r5 = "), using Xing value."
            r14.append(r5)
            java.lang.String r5 = r14.toString()
            java.lang.String r6 = "Mp3Extractor"
            com.google.android.gms.internal.ads.zzdt.zze(r6, r5)
            goto L_0x0105
        L_0x00fe:
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r20 = 0
        L_0x0105:
            com.google.android.gms.internal.ads.zzadj r5 = r0.zzb
            int r5 = r5.zzc
            r1.zzk(r5)
            if (r2 != r15) goto L_0x0113
            com.google.android.gms.internal.ads.zzaib r2 = com.google.android.gms.internal.ads.zzaib.zzb(r9, r10)
            goto L_0x016b
        L_0x0113:
            long r5 = r1.zzd()
            long r25 = r9.zza()
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0122
        L_0x011f:
            r2 = r20
            goto L_0x016b
        L_0x0122:
            long r12 = r9.zzc
            int r2 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r2 == 0) goto L_0x0135
            long r5 = r10 + r12
            com.google.android.gms.internal.ads.zzadj r2 = r9.zza
            int r2 = r2.zzc
        L_0x012e:
            long r14 = (long) r2
            long r12 = r12 - r14
            r28 = r5
            r21 = r12
            goto L_0x0140
        L_0x0135:
            int r2 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r2 == 0) goto L_0x011f
            long r12 = r5 - r10
            com.google.android.gms.internal.ads.zzadj r2 = r9.zza
            int r2 = r2.zzc
            goto L_0x012e
        L_0x0140:
            r23 = 8000000(0x7a1200, double:3.952525E-317)
            java.math.RoundingMode r27 = java.math.RoundingMode.HALF_UP
            long r5 = com.google.android.gms.internal.ads.zzen.zzu(r21, r23, r25, r27)
            r12 = r21
            int r32 = com.google.android.gms.internal.ads.zzgcr.zzb(r5)
            long r5 = r9.zzb
            java.math.RoundingMode r2 = java.math.RoundingMode.HALF_UP
            long r5 = com.google.android.gms.internal.ads.zzgcm.zzb(r12, r5, r2)
            int r33 = com.google.android.gms.internal.ads.zzgcr.zzb(r5)
            com.google.android.gms.internal.ads.zzadj r2 = r9.zza
            com.google.android.gms.internal.ads.zzaht r27 = new com.google.android.gms.internal.ads.zzaht
            int r2 = r2.zzc
            long r5 = (long) r2
            long r30 = r10 + r5
            r34 = 0
            r27.<init>(r28, r30, r32, r33, r34)
            r2 = r27
        L_0x016b:
            com.google.android.gms.internal.ads.zzbd r5 = r0.zzj
            long r6 = r1.zzf()
            if (r5 == 0) goto L_0x01bd
            int r9 = r5.zza()
            r10 = r4
        L_0x0178:
            if (r10 >= r9) goto L_0x01bd
            com.google.android.gms.internal.ads.zzbc r11 = r5.zzb(r10)
            boolean r12 = r11 instanceof com.google.android.gms.internal.ads.zzagq
            if (r12 == 0) goto L_0x01ba
            com.google.android.gms.internal.ads.zzagq r11 = (com.google.android.gms.internal.ads.zzagq) r11
            int r9 = r5.zza()
            r10 = r4
        L_0x0189:
            if (r10 >= r9) goto L_0x01b3
            com.google.android.gms.internal.ads.zzbc r12 = r5.zzb(r10)
            boolean r13 = r12 instanceof com.google.android.gms.internal.ads.zzagu
            if (r13 == 0) goto L_0x01b0
            com.google.android.gms.internal.ads.zzagu r12 = (com.google.android.gms.internal.ads.zzagu) r12
            java.lang.String r13 = r12.zzf
            java.lang.String r14 = "TLEN"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x01b0
            com.google.android.gms.internal.ads.zzfzo r5 = r12.zzb
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            long r9 = java.lang.Long.parseLong(r5)
            long r9 = com.google.android.gms.internal.ads.zzen.zzs(r9)
            goto L_0x01b5
        L_0x01b0:
            int r10 = r10 + 1
            goto L_0x0189
        L_0x01b3:
            r9 = r18
        L_0x01b5:
            com.google.android.gms.internal.ads.zzahv r5 = com.google.android.gms.internal.ads.zzahv.zzb(r6, r11, r9)
            goto L_0x01bf
        L_0x01ba:
            int r10 = r10 + 1
            goto L_0x0178
        L_0x01bd:
            r5 = r20
        L_0x01bf:
            boolean r6 = r0.zzq
            if (r6 == 0) goto L_0x01c9
            com.google.android.gms.internal.ads.zzahx r2 = new com.google.android.gms.internal.ads.zzahx
            r2.<init>()
            goto L_0x0207
        L_0x01c9:
            if (r5 == 0) goto L_0x01cd
            r2 = r5
            goto L_0x01d1
        L_0x01cd:
            if (r2 != 0) goto L_0x01d1
            r2 = r20
        L_0x01d1:
            if (r2 == 0) goto L_0x01d7
            r2.zzh()
            goto L_0x0207
        L_0x01d7:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r5 = 4
            r1.zzh(r2, r4, r5)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r4)
            com.google.android.gms.internal.ads.zzadj r2 = r0.zzb
            com.google.android.gms.internal.ads.zzed r5 = r0.zza
            int r5 = r5.zzg()
            r2.zza(r5)
            com.google.android.gms.internal.ads.zzaht r9 = new com.google.android.gms.internal.ads.zzaht
            long r10 = r1.zzd()
            long r12 = r1.zzf()
            com.google.android.gms.internal.ads.zzadj r2 = r0.zzb
            int r14 = r2.zzf
            int r15 = r2.zzc
            r16 = 0
            r9.<init>(r10, r12, r14, r15, r16)
            r2 = r9
        L_0x0207:
            r0.zzp = r2
            com.google.android.gms.internal.ads.zzacu r5 = r0.zzf
            r5.zzO(r2)
            com.google.android.gms.internal.ads.zzab r2 = new com.google.android.gms.internal.ads.zzab
            r2.<init>()
            com.google.android.gms.internal.ads.zzadj r5 = r0.zzb
            java.lang.String r5 = r5.zzb
            r2.zzZ(r5)
            r5 = 4096(0x1000, float:5.74E-42)
            r2.zzQ(r5)
            com.google.android.gms.internal.ads.zzadj r5 = r0.zzb
            int r5 = r5.zze
            r2.zzz(r5)
            com.google.android.gms.internal.ads.zzadj r5 = r0.zzb
            int r5 = r5.zzd
            r2.zzaa(r5)
            com.google.android.gms.internal.ads.zzadf r5 = r0.zzc
            int r5 = r5.zza
            r2.zzG(r5)
            com.google.android.gms.internal.ads.zzadf r5 = r0.zzc
            int r5 = r5.zzb
            r2.zzH(r5)
            com.google.android.gms.internal.ads.zzbd r5 = r0.zzj
            r2.zzS(r5)
            com.google.android.gms.internal.ads.zzahy r5 = r0.zzp
            int r5 = r5.zzc()
            r6 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r5 == r6) goto L_0x0254
            com.google.android.gms.internal.ads.zzahy r5 = r0.zzp
            int r5 = r5.zzc()
            r2.zzy(r5)
        L_0x0254:
            com.google.android.gms.internal.ads.zzadx r5 = r0.zzh
            com.google.android.gms.internal.ads.zzad r2 = r2.zzaf()
            r5.zzl(r2)
            long r5 = r1.zzf()
            r0.zzm = r5
            goto L_0x0280
        L_0x0264:
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r20 = 0
            long r5 = r0.zzm
            r9 = 0
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0280
            long r9 = r1.zzf()
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0280
            long r5 = r5 - r9
            int r2 = (int) r5
            r1.zzk(r2)
        L_0x0280:
            int r2 = r0.zzo
            if (r2 != 0) goto L_0x02e8
            r1.zzj()
            boolean r2 = r35.zzl(r36)
            if (r2 == 0) goto L_0x028e
            return r3
        L_0x028e:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r4)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            int r2 = r2.zzg()
            int r5 = r0.zzi
            long r5 = (long) r5
            boolean r5 = zzk(r2, r5)
            if (r5 == 0) goto L_0x02e2
            int r5 = com.google.android.gms.internal.ads.zzadk.zzb(r2)
            if (r5 != r3) goto L_0x02a9
            goto L_0x02e2
        L_0x02a9:
            com.google.android.gms.internal.ads.zzadj r5 = r0.zzb
            r5.zza(r2)
            long r5 = r0.zzk
            int r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x02c0
            com.google.android.gms.internal.ads.zzahy r2 = r0.zzp
            long r5 = r1.zzf()
            long r5 = r2.zze(r5)
            r0.zzk = r5
        L_0x02c0:
            com.google.android.gms.internal.ads.zzadj r2 = r0.zzb
            int r5 = r2.zzc
            r0.zzo = r5
            long r6 = r1.zzf()
            long r9 = (long) r5
            long r6 = r6 + r9
            r0.zzn = r6
            com.google.android.gms.internal.ads.zzahy r6 = r0.zzp
            boolean r7 = r6 instanceof com.google.android.gms.internal.ads.zzahu
            if (r7 != 0) goto L_0x02d6
            r2 = r5
            goto L_0x02e8
        L_0x02d6:
            com.google.android.gms.internal.ads.zzahu r6 = (com.google.android.gms.internal.ads.zzahu) r6
            long r3 = r0.zzl
            int r1 = r2.zzg
            long r1 = (long) r1
            long r3 = r3 + r1
            r0.zzh(r3)
            throw r20
        L_0x02e2:
            r1.zzk(r8)
            r0.zzi = r4
            return r4
        L_0x02e8:
            com.google.android.gms.internal.ads.zzadx r5 = r0.zzh
            int r1 = r5.zzf(r1, r2, r8)
            if (r1 != r3) goto L_0x02f1
            return r3
        L_0x02f1:
            int r2 = r0.zzo
            int r2 = r2 - r1
            r0.zzo = r2
            if (r2 <= 0) goto L_0x02f9
            return r4
        L_0x02f9:
            com.google.android.gms.internal.ads.zzadx r5 = r0.zzh
            long r1 = r0.zzl
            long r6 = r0.zzh(r1)
            com.google.android.gms.internal.ads.zzadj r1 = r0.zzb
            int r9 = r1.zzc
            r10 = 0
            r11 = 0
            r8 = 1
            r5.zzs(r6, r8, r9, r10, r11)
            long r1 = r0.zzl
            com.google.android.gms.internal.ads.zzadj r3 = r0.zzb
            int r3 = r3.zzg
            long r5 = (long) r3
            long r1 = r1 + r5
            r0.zzl = r1
            r0.zzo = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahw.zzg(com.google.android.gms.internal.ads.zzacs):int");
    }

    private final long zzh(long j) {
        zzadj zzadj = this.zzb;
        return this.zzk + ((j * AnimationKt.MillisToNanos) / ((long) zzadj.zzd));
    }

    private final void zzj() {
        zzahy zzahy = this.zzp;
        if ((zzahy instanceof zzaht) && zzahy.zzh()) {
            long j = this.zzn;
            if (j != -1 && j != this.zzp.zzd()) {
                this.zzp = ((zzaht) this.zzp).zzf(this.zzn);
                zzacu zzacu = this.zzf;
                zzacu.getClass();
                zzacu zzacu2 = zzacu;
                zzacu.zzO(this.zzp);
            }
        }
    }

    private static boolean zzk(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    private final boolean zzl(zzacs zzacs) throws IOException {
        zzahy zzahy = this.zzp;
        if (zzahy != null) {
            long zzd2 = zzahy.zzd();
            if (zzd2 != -1 && zzacs.zze() > zzd2 - 4) {
                return true;
            }
        }
        try {
            return !zzacs.zzm(this.zza.zzN(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzacs zzacs, boolean z) throws IOException {
        int i;
        int i2;
        int zzb2;
        zzacs.zzj();
        if (zzacs.zzf() == 0) {
            zzbd zza2 = this.zzd.zza(zzacs, (zzagi) null);
            this.zzj = zza2;
            if (zza2 != null) {
                this.zzc.zzb(zza2);
            }
            i2 = (int) zzacs.zze();
            if (!z) {
                zzacs.zzk(i2);
            }
            i = 0;
        } else {
            i2 = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (!zzl(zzacs)) {
                this.zza.zzL(0);
                int zzg2 = this.zza.zzg();
                if ((i == 0 || zzk(zzg2, (long) i)) && (zzb2 = zzadk.zzb(zzg2)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.zzb.zza(zzg2);
                        i = zzg2;
                    }
                    zzacs.zzg(zzb2 - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 != (true != z ? 131072 : 32768)) {
                        if (z) {
                            zzacs.zzj();
                            zzacs.zzg(i2 + i5);
                        } else {
                            zzacs.zzk(1);
                        }
                        i = 0;
                        i4 = i5;
                        i3 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        zzj();
                        throw new EOFException();
                    }
                }
            } else if (i3 <= 0) {
                zzj();
                throw new EOFException();
            }
        }
        if (z) {
            zzacs.zzk(i2 + i4);
        } else {
            zzacs.zzj();
        }
        this.zzi = i;
        return true;
    }

    public final void zza() {
        this.zzq = true;
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        zzdb.zzb(this.zzg);
        int i = zzen.zza;
        int zzg2 = zzg(zzacs);
        if (zzg2 == -1 && (this.zzp instanceof zzahu)) {
            if (this.zzp.zza() != zzh(this.zzl)) {
                zzahu zzahu = (zzahu) this.zzp;
                throw null;
            }
        }
        return zzg2;
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzf = zzacu;
        zzadx zzw = zzacu.zzw(0, 1);
        this.zzg = zzw;
        this.zzh = zzw;
        this.zzf.zzD();
    }

    public final void zzf(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0;
        this.zzo = 0;
        zzahy zzahy = this.zzp;
        if (zzahy instanceof zzahu) {
            zzahu zzahu = (zzahu) zzahy;
            throw null;
        }
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        return zzm(zzacs, true);
    }
}
