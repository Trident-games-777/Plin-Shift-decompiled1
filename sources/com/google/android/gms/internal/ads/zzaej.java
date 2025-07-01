package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaej implements zzacr {
    private final zzed zza;
    private final zzaeh zzb;
    private final boolean zzc;
    private final zzakg zzd;
    private int zze;
    private zzacu zzf;
    private zzaek zzg;
    private long zzh;
    /* access modifiers changed from: private */
    public zzaem[] zzi;
    private long zzj;
    private zzaem zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaej() {
        this(1, zzakg.zza);
    }

    private final zzaem zzg(int i) {
        for (zzaem zzaem : this.zzi) {
            if (zzaem.zzf(i)) {
                return zzaem;
            }
        }
        return null;
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zze = 0;
        if (this.zzc) {
            zzacu = new zzakj(zzacu, this.zzd);
        }
        this.zzf = zzacu;
        this.zzj = -1;
    }

    public final void zzf(long j, long j2) {
        this.zzj = -1;
        this.zzk = null;
        int i = 0;
        for (zzaem zze2 : this.zzi) {
            zze2.zze(j);
        }
        if (j == 0) {
            if (this.zzi.length != 0) {
                i = 3;
            }
            this.zze = i;
            return;
        }
        this.zze = 6;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzacs.zzh(this.zza.zzN(), 0, 12);
        this.zza.zzL(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzM(4);
        if (this.zza.zzi() == 541677121) {
            return true;
        }
        return false;
    }

    public zzaej(int i, zzakg zzakg) {
        this.zzd = zzakg;
        this.zzc = 1 != (i ^ 1) ? false : true;
        this.zza = new zzed(12);
        this.zzb = new zzaeh((zzaei) null);
        this.zzf = new zzadl();
        this.zzi = new zzaem[0];
        this.zzm = -1;
        this.zzn = -1;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r29, com.google.android.gms.internal.ads.zzadn r30) throws java.io.IOException {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            long r2 = r0.zzj
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x002b
            long r9 = r1.zzf()
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0025
            r11 = 262144(0x40000, double:1.295163E-318)
            long r11 = r11 + r9
            int r6 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x001f
            goto L_0x0025
        L_0x001f:
            long r2 = r2 - r9
            int r2 = (int) r2
            r1.zzk(r2)
            goto L_0x002b
        L_0x0025:
            r6 = r30
            r6.zza = r2
            r2 = r7
            goto L_0x002c
        L_0x002b:
            r2 = r8
        L_0x002c:
            r0.zzj = r4
            if (r2 == 0) goto L_0x0031
            return r7
        L_0x0031:
            int r2 = r0.zze
            r3 = 12
            r6 = 0
            if (r2 == 0) goto L_0x038d
            r9 = 1819436136(0x6c726468, float:1.1721368E27)
            r10 = 1414744396(0x5453494c, float:3.62987127E12)
            r11 = 2
            if (r2 == r7) goto L_0x0335
            r12 = 3
            if (r2 == r11) goto L_0x0216
            r9 = 6
            r11 = 1769369453(0x69766f6d, float:1.8620122E25)
            r13 = 4
            r14 = 0
            r16 = 8
            r18 = r4
            r4 = 16
            if (r2 == r12) goto L_0x0184
            r5 = 5
            r12 = 8
            if (r2 == r13) goto L_0x0159
            if (r2 == r5) goto L_0x00df
            long r4 = r1.zzf()
            long r13 = r0.zzn
            int r2 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0066
            r1 = -1
            return r1
        L_0x0066:
            com.google.android.gms.internal.ads.zzaem r2 = r0.zzk
            if (r2 == 0) goto L_0x0074
            boolean r1 = r2.zzg(r1)
            if (r1 != 0) goto L_0x0071
            return r8
        L_0x0071:
            r0.zzk = r6
            return r8
        L_0x0074:
            long r4 = r1.zzf()
            r13 = 1
            long r4 = r4 & r13
            int r2 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0082
            r1.zzk(r7)
        L_0x0082:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r1.zzh(r2, r8, r3)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            int r2 = r2.zzi()
            if (r2 != r10) goto L_0x00ae
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r12)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            int r2 = r2.zzi()
            if (r2 != r11) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r3 = r12
        L_0x00a7:
            r1.zzk(r3)
            r1.zzj()
            return r8
        L_0x00ae:
            com.google.android.gms.internal.ads.zzed r3 = r0.zza
            int r3 = r3.zzi()
            r4 = 1263424842(0x4b4e554a, float:1.352225E7)
            if (r2 != r4) goto L_0x00c4
            long r2 = (long) r3
            long r4 = r1.zzf()
            long r4 = r4 + r2
            long r4 = r4 + r16
            r0.zzj = r4
            return r8
        L_0x00c4:
            r1.zzk(r12)
            r1.zzj()
            com.google.android.gms.internal.ads.zzaem r2 = r0.zzg(r2)
            if (r2 != 0) goto L_0x00d9
            long r2 = (long) r3
            long r4 = r1.zzf()
            long r4 = r4 + r2
            r0.zzj = r4
            return r8
        L_0x00d9:
            r2.zzd(r3)
            r0.zzk = r2
            return r8
        L_0x00df:
            com.google.android.gms.internal.ads.zzed r2 = new com.google.android.gms.internal.ads.zzed
            int r3 = r0.zzo
            r2.<init>((int) r3)
            byte[] r3 = r2.zzN()
            int r5 = r0.zzo
            r1.zzi(r3, r8, r5)
            int r1 = r2.zzb()
            if (r1 >= r4) goto L_0x00f6
            goto L_0x010f
        L_0x00f6:
            int r1 = r2.zzd()
            r2.zzM(r12)
            int r3 = r2.zzi()
            long r5 = (long) r3
            long r10 = r0.zzm
            int r3 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0109
            goto L_0x010c
        L_0x0109:
            long r10 = r10 + r16
            r14 = r10
        L_0x010c:
            r2.zzL(r1)
        L_0x010f:
            int r1 = r2.zzb()
            if (r1 < r4) goto L_0x0136
            int r1 = r2.zzi()
            int r3 = r2.zzi()
            int r5 = r2.zzi()
            long r5 = (long) r5
            long r5 = r5 + r14
            r2.zzi()
            com.google.android.gms.internal.ads.zzaem r1 = r0.zzg(r1)
            if (r1 == 0) goto L_0x010f
            r3 = r3 & r4
            if (r3 != r4) goto L_0x0131
            r3 = r7
            goto L_0x0132
        L_0x0131:
            r3 = r8
        L_0x0132:
            r1.zzb(r5, r3)
            goto L_0x010f
        L_0x0136:
            com.google.android.gms.internal.ads.zzaem[] r1 = r0.zzi
            int r2 = r1.length
            r3 = r8
        L_0x013a:
            if (r3 >= r2) goto L_0x0144
            r4 = r1[r3]
            r4.zzc()
            int r3 = r3 + 1
            goto L_0x013a
        L_0x0144:
            r0.zzp = r7
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzf
            com.google.android.gms.internal.ads.zzaeg r2 = new com.google.android.gms.internal.ads.zzaeg
            long r3 = r0.zzh
            r2.<init>(r0, r3)
            r1.zzO(r2)
            r0.zze = r9
            long r1 = r0.zzm
            r0.zzj = r1
            return r8
        L_0x0159:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r1.zzi(r2, r8, r12)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            int r3 = r2.zzi()
            int r2 = r2.zzi()
            r4 = 829973609(0x31786469, float:3.6145826E-9)
            if (r3 != r4) goto L_0x017b
            r0.zze = r5
            r0.zzo = r2
            goto L_0x0183
        L_0x017b:
            long r3 = r1.zzf()
            long r1 = (long) r2
            long r3 = r3 + r1
            r0.zzj = r3
        L_0x0183:
            return r8
        L_0x0184:
            long r5 = r0.zzm
            int r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0196
            long r18 = r1.zzf()
            int r2 = (r18 > r5 ? 1 : (r18 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0193
            goto L_0x0196
        L_0x0193:
            r0.zzj = r5
            return r8
        L_0x0196:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r1.zzh(r2, r8, r3)
            r1.zzj()
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzaeh r2 = r0.zzb
            com.google.android.gms.internal.ads.zzed r5 = r0.zza
            r2.zza(r5)
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            com.google.android.gms.internal.ads.zzaeh r5 = r0.zzb
            int r2 = r2.zzi()
            int r5 = r5.zza
            r6 = 1179011410(0x46464952, float:12690.33)
            if (r5 != r6) goto L_0x01c1
            r1.zzk(r3)
            return r8
        L_0x01c1:
            if (r5 != r10) goto L_0x0207
            if (r2 == r11) goto L_0x01c6
            goto L_0x0207
        L_0x01c6:
            long r2 = r1.zzf()
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzaeh r5 = r0.zzb
            int r5 = r5.zzb
            long r5 = (long) r5
            long r2 = r2 + r5
            long r2 = r2 + r16
            r0.zzn = r2
            boolean r5 = r0.zzp
            if (r5 != 0) goto L_0x01fb
            com.google.android.gms.internal.ads.zzaek r5 = r0.zzg
            r5.getClass()
            r6 = r5
            com.google.android.gms.internal.ads.zzaek r6 = (com.google.android.gms.internal.ads.zzaek) r6
            int r5 = r5.zzb
            r5 = r5 & r4
            if (r5 == r4) goto L_0x01f6
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzf
            com.google.android.gms.internal.ads.zzadp r3 = new com.google.android.gms.internal.ads.zzadp
            long r4 = r0.zzh
            r3.<init>(r4, r14)
            r2.zzO(r3)
            r0.zzp = r7
            goto L_0x01fb
        L_0x01f6:
            r0.zze = r13
            r0.zzj = r2
            return r8
        L_0x01fb:
            long r1 = r1.zzf()
            r3 = 12
            long r1 = r1 + r3
            r0.zzj = r1
            r0.zze = r9
            return r8
        L_0x0207:
            long r1 = r1.zzf()
            com.google.android.gms.internal.ads.zzaeh r3 = r0.zzb
            int r3 = r3.zzb
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r16
            r0.zzj = r1
            return r8
        L_0x0216:
            int r2 = r0.zzl
            int r2 = r2 + -4
            com.google.android.gms.internal.ads.zzed r3 = new com.google.android.gms.internal.ads.zzed
            r3.<init>((int) r2)
            byte[] r4 = r3.zzN()
            r1.zzi(r4, r8, r2)
            com.google.android.gms.internal.ads.zzaen r1 = com.google.android.gms.internal.ads.zzaen.zzc(r9, r3)
            int r2 = r1.zza()
            if (r2 != r9) goto L_0x031d
            java.lang.Class<com.google.android.gms.internal.ads.zzaek> r2 = com.google.android.gms.internal.ads.zzaek.class
            com.google.android.gms.internal.ads.zzaef r2 = r1.zzb(r2)
            com.google.android.gms.internal.ads.zzaek r2 = (com.google.android.gms.internal.ads.zzaek) r2
            if (r2 == 0) goto L_0x0315
            r0.zzg = r2
            int r3 = r2.zzc
            int r2 = r2.zza
            long r3 = (long) r3
            long r9 = (long) r2
            long r3 = r3 * r9
            r0.zzh = r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.google.android.gms.internal.ads.zzfzo r1 = r1.zza
            int r3 = r1.size()
            r4 = r8
            r14 = r4
        L_0x0252:
            if (r4 >= r3) goto L_0x0301
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.ads.zzaef r5 = (com.google.android.gms.internal.ads.zzaef) r5
            int r9 = r5.zza()
            r10 = 1819440243(0x6c727473, float:1.17243986E27)
            if (r9 != r10) goto L_0x02f9
            com.google.android.gms.internal.ads.zzaen r5 = (com.google.android.gms.internal.ads.zzaen) r5
            int r9 = r14 + 1
            java.lang.Class<com.google.android.gms.internal.ads.zzael> r10 = com.google.android.gms.internal.ads.zzael.class
            com.google.android.gms.internal.ads.zzaef r10 = r5.zzb(r10)
            com.google.android.gms.internal.ads.zzael r10 = (com.google.android.gms.internal.ads.zzael) r10
            java.lang.Class<com.google.android.gms.internal.ads.zzaeo> r13 = com.google.android.gms.internal.ads.zzaeo.class
            com.google.android.gms.internal.ads.zzaef r13 = r5.zzb(r13)
            com.google.android.gms.internal.ads.zzaeo r13 = (com.google.android.gms.internal.ads.zzaeo) r13
            java.lang.String r15 = "AviExtractor"
            if (r10 != 0) goto L_0x0285
            java.lang.String r5 = "Missing Stream Header"
            com.google.android.gms.internal.ads.zzdt.zzf(r15, r5)
        L_0x0280:
            r13 = r6
            r29 = r9
            goto L_0x02f2
        L_0x0285:
            if (r13 != 0) goto L_0x028d
            java.lang.String r5 = "Missing Stream Format"
            com.google.android.gms.internal.ads.zzdt.zzf(r15, r5)
            goto L_0x0280
        L_0x028d:
            int r15 = r10.zzd
            int r6 = r10.zzb
            int r12 = r10.zzc
            com.google.android.gms.internal.ads.zzad r13 = r13.zza
            r29 = r9
            long r8 = (long) r6
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r23 = r8 * r16
            long r8 = (long) r12
            java.math.RoundingMode r27 = java.math.RoundingMode.FLOOR
            long r11 = (long) r15
            r25 = r8
            r21 = r11
            long r16 = com.google.android.gms.internal.ads.zzen.zzu(r21, r23, r25, r27)
            com.google.android.gms.internal.ads.zzab r8 = r13.zzb()
            r8.zzK(r14)
            int r9 = r10.zze
            if (r9 == 0) goto L_0x02b7
            r8.zzQ(r9)
        L_0x02b7:
            java.lang.Class<com.google.android.gms.internal.ads.zzaep> r9 = com.google.android.gms.internal.ads.zzaep.class
            com.google.android.gms.internal.ads.zzaef r5 = r5.zzb(r9)
            com.google.android.gms.internal.ads.zzaep r5 = (com.google.android.gms.internal.ads.zzaep) r5
            if (r5 == 0) goto L_0x02c6
            java.lang.String r5 = r5.zza
            r8.zzN(r5)
        L_0x02c6:
            java.lang.String r5 = r13.zzo
            int r5 = com.google.android.gms.internal.ads.zzbg.zzb(r5)
            if (r5 == r7) goto L_0x02d5
            r6 = 2
            if (r5 != r6) goto L_0x02d3
            r15 = 2
            goto L_0x02d6
        L_0x02d3:
            r13 = 0
            goto L_0x02f2
        L_0x02d5:
            r15 = r5
        L_0x02d6:
            com.google.android.gms.internal.ads.zzacu r5 = r0.zzf
            com.google.android.gms.internal.ads.zzadx r5 = r5.zzw(r14, r15)
            com.google.android.gms.internal.ads.zzad r8 = r8.zzaf()
            r5.zzl(r8)
            int r8 = r10.zzd
            com.google.android.gms.internal.ads.zzaem r13 = new com.google.android.gms.internal.ads.zzaem
            r19 = r5
            r18 = r8
            r13.<init>(r14, r15, r16, r18, r19)
            r8 = r16
            r0.zzh = r8
        L_0x02f2:
            if (r13 == 0) goto L_0x02f7
            r2.add(r13)
        L_0x02f7:
            r14 = r29
        L_0x02f9:
            int r4 = r4 + 1
            r6 = 0
            r8 = 0
            r11 = 2
            r12 = 3
            goto L_0x0252
        L_0x0301:
            r4 = r8
            com.google.android.gms.internal.ads.zzaem[] r1 = new com.google.android.gms.internal.ads.zzaem[r4]
            java.lang.Object[] r1 = r2.toArray(r1)
            com.google.android.gms.internal.ads.zzaem[] r1 = (com.google.android.gms.internal.ads.zzaem[]) r1
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzf
            r1.zzD()
            r1 = 3
            r0.zze = r1
            return r4
        L_0x0315:
            java.lang.String r1 = "AviHeader not found"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x031d:
            r2 = r6
            int r1 = r1.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected header list type "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0335:
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            byte[] r2 = r2.zzN()
            r4 = 0
            r1.zzi(r2, r4, r3)
            com.google.android.gms.internal.ads.zzed r1 = r0.zza
            r1.zzL(r4)
            com.google.android.gms.internal.ads.zzaeh r1 = r0.zzb
            com.google.android.gms.internal.ads.zzed r2 = r0.zza
            r1.zza(r2)
            int r3 = r1.zza
            if (r3 != r10) goto L_0x0379
            int r2 = r2.zzi()
            r1.zzc = r2
            com.google.android.gms.internal.ads.zzaeh r1 = r0.zzb
            int r2 = r1.zzc
            if (r2 != r9) goto L_0x0365
            int r1 = r1.zzb
            r0.zzl = r1
            r6 = 2
            r0.zze = r6
        L_0x0362:
            r20 = 0
            return r20
        L_0x0365:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "hdrl expected, found: "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0379:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "LIST expected, found: "
            r1.<init>(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x038d:
            r2 = r6
            boolean r4 = r28.zzi(r29)
            if (r4 == 0) goto L_0x039a
            r1.zzk(r3)
            r0.zze = r7
            goto L_0x0362
        L_0x039a:
            java.lang.String r1 = "AVI Header List not found"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaej.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }
}
