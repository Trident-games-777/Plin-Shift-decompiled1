package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzait implements zzacr {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzad zzb;
    private long zzA;
    private zzais zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private zzacu zzH;
    private zzadx[] zzI;
    private zzadx[] zzJ;
    private boolean zzK;
    private final zzakg zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzed zzg;
    private final zzed zzh;
    private final zzed zzi;
    private final byte[] zzj;
    private final zzed zzk;
    private final zzafp zzl;
    private final zzed zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzft zzp;
    private zzfzo zzq;
    private int zzr;
    private int zzs;
    private long zzt;
    private int zzu;
    private zzed zzv;
    private long zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    static {
        zzab zzab = new zzab();
        zzab.zzZ("application/x-emsg");
        zzb = zzab.zzaf();
    }

    @Deprecated
    public zzait() {
        this(zzakg.zza, 32, (zzek) null, (zzaje) null, zzfzo.zzn(), (zzadx) null);
    }

    private static int zzg(int i) throws zzbh {
        if (i >= 0) {
            return i;
        }
        throw zzbh.zza("Unexpected negative value: " + i, (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzw zzh(java.util.List r19) {
        /*
            int r0 = r19.size()
            r1 = 0
            r3 = r1
            r4 = 0
        L_0x0007:
            if (r3 >= r0) goto L_0x0121
            r5 = r19
            java.lang.Object r6 = r5.get(r3)
            com.google.android.gms.internal.ads.zzet r6 = (com.google.android.gms.internal.ads.zzet) r6
            int r7 = r6.zzd
            r8 = 1886614376(0x70737368, float:3.013775E29)
            if (r7 != r8) goto L_0x011a
            if (r4 != 0) goto L_0x001f
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001f:
            com.google.android.gms.internal.ads.zzed r6 = r6.zza
            byte[] r6 = r6.zzN()
            com.google.android.gms.internal.ads.zzed r7 = new com.google.android.gms.internal.ads.zzed
            r7.<init>((byte[]) r6)
            int r9 = r7.zze()
            r10 = 32
            if (r9 >= r10) goto L_0x0037
        L_0x0032:
            r16 = r3
        L_0x0034:
            r2 = 0
            goto L_0x00fe
        L_0x0037:
            r7.zzL(r1)
            int r9 = r7.zzb()
            int r10 = r7.zzg()
            java.lang.String r11 = "PsshAtomUtil"
            if (r10 == r9) goto L_0x0060
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Advertised atom size ("
            r7.<init>(r8)
            r7.append(r10)
            java.lang.String r8 = ") does not match buffer size: "
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r7)
            goto L_0x0032
        L_0x0060:
            int r9 = r7.zzg()
            if (r9 == r8) goto L_0x0078
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Atom type is not pssh: "
            r7.<init>(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r7)
            goto L_0x0032
        L_0x0078:
            int r8 = r7.zzg()
            int r8 = com.google.android.gms.internal.ads.zzain.zza(r8)
            r9 = 1
            if (r8 <= r9) goto L_0x0095
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Unsupported pssh version: "
            r7.<init>(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r7)
            goto L_0x0032
        L_0x0095:
            java.util.UUID r10 = new java.util.UUID
            long r12 = r7.zzt()
            long r14 = r7.zzt()
            r10.<init>(r12, r14)
            if (r8 != r9) goto L_0x00cc
            int r9 = r7.zzp()
            java.util.UUID[] r12 = new java.util.UUID[r9]
            r13 = r1
        L_0x00ab:
            if (r13 >= r9) goto L_0x00c9
            java.util.UUID r14 = new java.util.UUID
            r16 = r3
            long r2 = r7.zzt()
            r17 = r12
            r18 = r13
            long r12 = r7.zzt()
            r14.<init>(r2, r12)
            r17[r18] = r14
            int r13 = r18 + 1
            r3 = r16
            r12 = r17
            goto L_0x00ab
        L_0x00c9:
            r17 = r12
            goto L_0x00cd
        L_0x00cc:
            r12 = 0
        L_0x00cd:
            r16 = r3
            int r2 = r7.zzp()
            int r3 = r7.zzb()
            if (r2 == r3) goto L_0x00f4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Atom data size ("
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r2 = ") does not match the bytes left: "
            r7.append(r2)
            r7.append(r3)
            java.lang.String r2 = r7.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r2)
            goto L_0x0034
        L_0x00f4:
            byte[] r3 = new byte[r2]
            r7.zzH(r3, r1, r2)
            com.google.android.gms.internal.ads.zzaja r2 = new com.google.android.gms.internal.ads.zzaja
            r2.<init>(r10, r8, r3, r12)
        L_0x00fe:
            if (r2 != 0) goto L_0x0102
            r2 = 0
            goto L_0x0104
        L_0x0102:
            java.util.UUID r2 = r2.zza
        L_0x0104:
            if (r2 != 0) goto L_0x010e
            java.lang.String r2 = "FragmentedMp4Extractor"
            java.lang.String r3 = "Skipped pssh atom (failed to extract uuid)"
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r3)
            goto L_0x011c
        L_0x010e:
            com.google.android.gms.internal.ads.zzv r3 = new com.google.android.gms.internal.ads.zzv
            java.lang.String r7 = "video/mp4"
            r15 = 0
            r3.<init>(r2, r15, r7, r6)
            r4.add(r3)
            goto L_0x011d
        L_0x011a:
            r16 = r3
        L_0x011c:
            r15 = 0
        L_0x011d:
            int r3 = r16 + 1
            goto L_0x0007
        L_0x0121:
            r15 = 0
            if (r4 != 0) goto L_0x0125
            return r15
        L_0x0125:
            com.google.android.gms.internal.ads.zzw r0 = new com.google.android.gms.internal.ads.zzw
            r0.<init>((java.util.List) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzait.zzh(java.util.List):com.google.android.gms.internal.ads.zzw");
    }

    private final void zzj() {
        this.zzr = 0;
        this.zzu = 0;
    }

    private static void zzk(zzed zzed, int i, zzajg zzajg) throws zzbh {
        zzed.zzL(i + 8);
        int zzg2 = zzed.zzg();
        int i2 = zzain.zza;
        if ((zzg2 & 1) == 0) {
            boolean z = (zzg2 & 2) != 0;
            int zzp2 = zzed.zzp();
            if (zzp2 == 0) {
                Arrays.fill(zzajg.zzl, 0, zzajg.zze, false);
                return;
            }
            int i3 = zzajg.zze;
            if (zzp2 == i3) {
                Arrays.fill(zzajg.zzl, 0, zzp2, z);
                zzajg.zza(zzed.zzb());
                zzed zzed2 = zzajg.zzn;
                zzed.zzH(zzed2.zzN(), 0, zzed2.zze());
                zzajg.zzn.zzL(0);
                zzajg.zzo = false;
                return;
            }
            throw zzbh.zza("Senc sample count " + zzp2 + " is different from fragment sample count" + i3, (Throwable) null);
        }
        throw zzbh.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0348, code lost:
        if (com.google.android.gms.internal.ads.zzen.zzu(r37 + r7[0], androidx.compose.animation.core.AnimationKt.MillisToNanos, r1.zzd, java.math.RoundingMode.FLOOR) < r1.zze) goto L_0x0356;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzl(long r53) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r52 = this;
            r0 = r52
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0705
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzes r1 = (com.google.android.gms.internal.ads.zzes) r1
            long r1 = r1.zza
            int r1 = (r1 > r53 ? 1 : (r1 == r53 ? 0 : -1))
            if (r1 != 0) goto L_0x0705
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzes r2 = (com.google.android.gms.internal.ads.zzes) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r8 = 8
            if (r1 != r3) goto L_0x014c
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzw r1 = zzh(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzes r3 = r2.zza(r3)
            r3.getClass()
            r9 = r3
            com.google.android.gms.internal.ads.zzes r9 = (com.google.android.gms.internal.ads.zzes) r9
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List r9 = r3.zzb
            int r9 = r9.size()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13 = 0
        L_0x0050:
            if (r13 >= r9) goto L_0x00bd
            java.util.List r14 = r3.zzb
            java.lang.Object r14 = r14.get(r13)
            com.google.android.gms.internal.ads.zzet r14 = (com.google.android.gms.internal.ads.zzet) r14
            int r15 = r14.zzd
            r16 = 16
            r7 = 1953654136(0x74726578, float:7.6818474E31)
            if (r15 != r7) goto L_0x009b
            com.google.android.gms.internal.ads.zzed r7 = r14.zza
            r7.zzL(r6)
            int r14 = r7.zzg()
            int r15 = r7.zzg()
            int r15 = r15 + -1
            int r11 = r7.zzg()
            int r6 = r7.zzg()
            int r7 = r7.zzg()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.ads.zzaio r10 = new com.google.android.gms.internal.ads.zzaio
            r10.<init>(r15, r11, r6, r7)
            android.util.Pair r6 = android.util.Pair.create(r14, r10)
            java.lang.Object r7 = r6.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.second
            com.google.android.gms.internal.ads.zzaio r6 = (com.google.android.gms.internal.ads.zzaio) r6
            r12.put(r7, r6)
            goto L_0x00b8
        L_0x009b:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r15 != r6) goto L_0x00b8
            com.google.android.gms.internal.ads.zzed r4 = r14.zza
            r4.zzL(r8)
            int r5 = r4.zzg()
            int r5 = com.google.android.gms.internal.ads.zzain.zza(r5)
            if (r5 != 0) goto L_0x00b4
            long r4 = r4.zzu()
            goto L_0x00b8
        L_0x00b4:
            long r4 = r4.zzw()
        L_0x00b8:
            int r13 = r13 + 1
            r6 = 12
            goto L_0x0050
        L_0x00bd:
            r16 = 16
            com.google.android.gms.internal.ads.zzadf r3 = new com.google.android.gms.internal.ads.zzadf
            r3.<init>()
            int r6 = r0.zzd
            r6 = r6 & 16
            if (r6 == 0) goto L_0x00cc
            r7 = 1
            goto L_0x00cd
        L_0x00cc:
            r7 = 0
        L_0x00cd:
            com.google.android.gms.internal.ads.zzaip r9 = new com.google.android.gms.internal.ads.zzaip
            r9.<init>(r0)
            r8 = 0
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzain.zzf(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != 0) goto L_0x011d
            r11 = 0
        L_0x00e5:
            if (r11 >= r2) goto L_0x0116
            java.lang.Object r3 = r1.get(r11)
            com.google.android.gms.internal.ads.zzajh r3 = (com.google.android.gms.internal.ads.zzajh) r3
            com.google.android.gms.internal.ads.zzaje r4 = r3.zza
            com.google.android.gms.internal.ads.zzais r5 = new com.google.android.gms.internal.ads.zzais
            com.google.android.gms.internal.ads.zzacu r6 = r0.zzH
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzadx r6 = r6.zzw(r11, r7)
            int r7 = r4.zza
            com.google.android.gms.internal.ads.zzaio r7 = zzm(r12, r7)
            r5.<init>(r6, r3, r7)
            android.util.SparseArray r3 = r0.zzf
            int r6 = r4.zza
            r3.put(r6, r5)
            long r5 = r0.zzz
            long r3 = r4.zze
            long r3 = java.lang.Math.max(r5, r3)
            r0.zzz = r3
            int r11 = r11 + 1
            goto L_0x00e5
        L_0x0116:
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzH
            r1.zzD()
            goto L_0x0002
        L_0x011d:
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0127
            r10 = 1
            goto L_0x0128
        L_0x0127:
            r10 = 0
        L_0x0128:
            com.google.android.gms.internal.ads.zzdb.zzf(r10)
            r11 = 0
        L_0x012c:
            if (r11 >= r2) goto L_0x0002
            java.lang.Object r3 = r1.get(r11)
            com.google.android.gms.internal.ads.zzajh r3 = (com.google.android.gms.internal.ads.zzajh) r3
            com.google.android.gms.internal.ads.zzaje r4 = r3.zza
            android.util.SparseArray r5 = r0.zzf
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzais r5 = (com.google.android.gms.internal.ads.zzais) r5
            int r4 = r4.zza
            com.google.android.gms.internal.ads.zzaio r4 = zzm(r12, r4)
            r5.zzh(r3, r4)
            int r11 = r11 + 1
            goto L_0x012c
        L_0x014c:
            r16 = 16
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x06f0
            android.util.SparseArray r1 = r0.zzf
            int r3 = r0.zzd
            byte[] r6 = r0.zzj
            java.util.List r7 = r2.zzc
            int r7 = r7.size()
            r9 = 0
        L_0x0160:
            if (r9 >= r7) goto L_0x065d
            java.util.List r11 = r2.zzc
            java.lang.Object r11 = r11.get(r9)
            com.google.android.gms.internal.ads.zzes r11 = (com.google.android.gms.internal.ads.zzes) r11
            int r12 = r11.zzd
            r13 = 1953653094(0x74726166, float:7.6813435E31)
            if (r12 != r13) goto L_0x063d
            r12 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzet r12 = r11.zzb(r12)
            r12.getClass()
            r13 = r12
            com.google.android.gms.internal.ads.zzet r13 = (com.google.android.gms.internal.ads.zzet) r13
            com.google.android.gms.internal.ads.zzed r12 = r12.zza
            r12.zzL(r8)
            int r13 = r12.zzg()
            int r14 = com.google.android.gms.internal.ads.zzain.zza
            int r14 = r12.zzg()
            java.lang.Object r14 = r1.get(r14)
            com.google.android.gms.internal.ads.zzais r14 = (com.google.android.gms.internal.ads.zzais) r14
            if (r14 != 0) goto L_0x019c
            r14 = 0
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x01ea
        L_0x019c:
            r15 = r13 & 1
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r15 == 0) goto L_0x01af
            long r4 = r12.zzw()
            com.google.android.gms.internal.ads.zzajg r15 = r14.zzb
            r15.zzb = r4
            r15.zzc = r4
        L_0x01af:
            com.google.android.gms.internal.ads.zzaio r4 = r14.zze
            r5 = r13 & 2
            if (r5 == 0) goto L_0x01bc
            int r5 = r12.zzg()
            int r5 = r5 + -1
            goto L_0x01be
        L_0x01bc:
            int r5 = r4.zza
        L_0x01be:
            r15 = r13 & 8
            if (r15 == 0) goto L_0x01c7
            int r15 = r12.zzg()
            goto L_0x01c9
        L_0x01c7:
            int r15 = r4.zzb
        L_0x01c9:
            r21 = r13 & 16
            if (r21 == 0) goto L_0x01d4
            int r21 = r12.zzg()
            r10 = r21
            goto L_0x01d6
        L_0x01d4:
            int r10 = r4.zzc
        L_0x01d6:
            r13 = r13 & 32
            if (r13 == 0) goto L_0x01df
            int r4 = r12.zzg()
            goto L_0x01e1
        L_0x01df:
            int r4 = r4.zzd
        L_0x01e1:
            com.google.android.gms.internal.ads.zzajg r12 = r14.zzb
            com.google.android.gms.internal.ads.zzaio r13 = new com.google.android.gms.internal.ads.zzaio
            r13.<init>(r5, r15, r10, r4)
            r12.zza = r13
        L_0x01ea:
            if (r14 != 0) goto L_0x01fc
            r23 = r1
            r22 = r3
            r30 = r7
            r31 = r9
            r12 = r16
            r7 = 1
            r9 = 0
            r10 = 12
            goto L_0x0650
        L_0x01fc:
            com.google.android.gms.internal.ads.zzajg r4 = r14.zzb
            long r12 = r4.zzp
            boolean r5 = r4.zzq
            r14.zzi()
            r10 = 1
            r14.zzl = true
            r15 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzet r15 = r11.zzb(r15)
            if (r15 == 0) goto L_0x0233
            r18 = r3 & 2
            if (r18 != 0) goto L_0x0233
            com.google.android.gms.internal.ads.zzed r5 = r15.zza
            r5.zzL(r8)
            int r12 = r5.zzg()
            int r12 = com.google.android.gms.internal.ads.zzain.zza(r12)
            if (r12 != r10) goto L_0x022a
            long r12 = r5.zzw()
            goto L_0x022e
        L_0x022a:
            long r12 = r5.zzu()
        L_0x022e:
            r4.zzp = r12
            r4.zzq = r10
            goto L_0x0237
        L_0x0233:
            r4.zzp = r12
            r4.zzq = r5
        L_0x0237:
            java.util.List r5 = r11.zzb
            int r10 = r5.size()
            r12 = 0
            r13 = 0
            r15 = 0
        L_0x0240:
            r8 = 1953658222(0x7472756e, float:7.683823E31)
            if (r12 >= r10) goto L_0x026c
            java.lang.Object r22 = r5.get(r12)
            r23 = r1
            r1 = r22
            com.google.android.gms.internal.ads.zzet r1 = (com.google.android.gms.internal.ads.zzet) r1
            r22 = r3
            int r3 = r1.zzd
            if (r3 != r8) goto L_0x0265
            com.google.android.gms.internal.ads.zzed r1 = r1.zza
            r3 = 12
            r1.zzL(r3)
            int r1 = r1.zzp()
            if (r1 <= 0) goto L_0x0265
            int r15 = r15 + r1
            int r13 = r13 + 1
        L_0x0265:
            int r12 = r12 + 1
            r3 = r22
            r1 = r23
            goto L_0x0240
        L_0x026c:
            r23 = r1
            r22 = r3
            r1 = 0
            r14.zzh = r1
            r14.zzg = r1
            r14.zzf = r1
            com.google.android.gms.internal.ads.zzajg r1 = r14.zzb
            r1.zzd = r13
            r1.zze = r15
            int[] r3 = r1.zzg
            int r3 = r3.length
            if (r3 >= r13) goto L_0x028a
            long[] r3 = new long[r13]
            r1.zzf = r3
            int[] r3 = new int[r13]
            r1.zzg = r3
        L_0x028a:
            int[] r3 = r1.zzh
            int r3 = r3.length
            if (r3 >= r15) goto L_0x02a3
            int r15 = r15 * 125
            int r15 = r15 / 100
            int[] r3 = new int[r15]
            r1.zzh = r3
            long[] r3 = new long[r15]
            r1.zzi = r3
            boolean[] r3 = new boolean[r15]
            r1.zzj = r3
            boolean[] r3 = new boolean[r15]
            r1.zzl = r3
        L_0x02a3:
            r1 = 0
            r3 = 0
            r12 = 0
        L_0x02a6:
            r24 = 0
            if (r1 >= r10) goto L_0x0425
            java.lang.Object r15 = r5.get(r1)
            com.google.android.gms.internal.ads.zzet r15 = (com.google.android.gms.internal.ads.zzet) r15
            int r13 = r15.zzd
            if (r13 != r8) goto L_0x040a
            int r13 = r3 + 1
            com.google.android.gms.internal.ads.zzed r15 = r15.zza
            r8 = 8
            r15.zzL(r8)
            int r8 = r15.zzg()
            r27 = r1
            com.google.android.gms.internal.ads.zzajh r1 = r14.zzd
            com.google.android.gms.internal.ads.zzaje r1 = r1.zza
            r28 = r3
            com.google.android.gms.internal.ads.zzajg r3 = r14.zzb
            r29 = r5
            com.google.android.gms.internal.ads.zzaio r5 = r3.zza
            int r30 = com.google.android.gms.internal.ads.zzen.zza
            r30 = r5
            com.google.android.gms.internal.ads.zzaio r30 = (com.google.android.gms.internal.ads.zzaio) r30
            r30 = r7
            int[] r7 = r3.zzg
            int r31 = r15.zzp()
            r7[r28] = r31
            long[] r7 = r3.zzf
            r31 = r9
            r32 = r10
            long r9 = r3.zzb
            r7[r28] = r9
            r33 = r8 & 1
            if (r33 == 0) goto L_0x02fa
            r33 = r7
            int r7 = r15.zzg()
            r34 = r9
            long r9 = (long) r7
            long r9 = r34 + r9
            r33[r28] = r9
        L_0x02fa:
            r7 = r8 & 4
            if (r7 == 0) goto L_0x0300
            r7 = 1
            goto L_0x0301
        L_0x0300:
            r7 = 0
        L_0x0301:
            int r9 = r5.zzd
            if (r7 == 0) goto L_0x0309
            int r9 = r15.zzg()
        L_0x0309:
            r10 = r8 & 256(0x100, float:3.59E-43)
            r33 = r7
            r7 = r8 & 512(0x200, float:7.175E-43)
            r34 = r7
            r7 = r8 & 1024(0x400, float:1.435E-42)
            r8 = r8 & 2048(0x800, float:2.87E-42)
            r35 = r7
            long[] r7 = r1.zzh
            if (r7 == 0) goto L_0x0354
            r36 = r8
            int r8 = r7.length
            r37 = r7
            r7 = 1
            if (r8 != r7) goto L_0x0356
            long[] r7 = r1.zzi
            if (r7 != 0) goto L_0x0328
            goto L_0x0356
        L_0x0328:
            r17 = 0
            r37 = r37[r17]
            int r8 = (r37 > r24 ? 1 : (r37 == r24 ? 0 : -1))
            if (r8 != 0) goto L_0x0331
            goto L_0x034b
        L_0x0331:
            r7 = r7[r17]
            long r39 = r37 + r7
            long r7 = r1.zzd
            java.math.RoundingMode r45 = java.math.RoundingMode.FLOOR
            r41 = 1000000(0xf4240, double:4.940656E-318)
            r43 = r7
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r39, r41, r43, r45)
            r37 = r7
            long r7 = r1.zze
            int r7 = (r37 > r7 ? 1 : (r37 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x034b
            goto L_0x0356
        L_0x034b:
            long[] r7 = r1.zzi
            long[] r7 = (long[]) r7
            r17 = 0
            r24 = r7[r17]
            goto L_0x0356
        L_0x0354:
            r36 = r8
        L_0x0356:
            int[] r7 = r3.zzh
            long[] r8 = r3.zzi
            r37 = r7
            boolean[] r7 = r3.zzj
            r38 = r7
            int r7 = r1.zzb
            r39 = r8
            r8 = 2
            if (r7 != r8) goto L_0x036d
            r7 = r22 & 1
            if (r7 == 0) goto L_0x036d
            r7 = 1
            goto L_0x036e
        L_0x036d:
            r7 = 0
        L_0x036e:
            int[] r8 = r3.zzg
            r8 = r8[r28]
            int r8 = r8 + r12
            r26 = r9
            r47 = r10
            long r9 = r1.zzc
            r44 = r9
            long r9 = r3.zzp
        L_0x037d:
            if (r12 >= r8) goto L_0x0402
            if (r47 == 0) goto L_0x0386
            int r1 = r15.zzg()
            goto L_0x0388
        L_0x0386:
            int r1 = r5.zzb
        L_0x0388:
            zzg(r1)
            if (r34 == 0) goto L_0x0394
            int r28 = r15.zzg()
            r48 = r7
            goto L_0x039a
        L_0x0394:
            r48 = r7
            int r7 = r5.zzc
            r28 = r7
        L_0x039a:
            zzg(r28)
            if (r35 == 0) goto L_0x03a4
            int r7 = r15.zzg()
            goto L_0x03af
        L_0x03a4:
            if (r12 != 0) goto L_0x03ad
            if (r33 == 0) goto L_0x03ac
            r7 = r26
            r12 = 0
            goto L_0x03af
        L_0x03ac:
            r12 = 0
        L_0x03ad:
            int r7 = r5.zzd
        L_0x03af:
            if (r36 == 0) goto L_0x03ba
            int r40 = r15.zzg()
            r49 = r5
            r5 = r40
            goto L_0x03bd
        L_0x03ba:
            r49 = r5
            r5 = 0
        L_0x03bd:
            r51 = r7
            r50 = r8
            long r7 = (long) r5
            long r7 = r7 + r9
            long r40 = r7 - r24
            r42 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r46 = java.math.RoundingMode.FLOOR
            long r7 = com.google.android.gms.internal.ads.zzen.zzu(r40, r42, r44, r46)
            r39[r12] = r7
            boolean r5 = r3.zzq
            if (r5 != 0) goto L_0x03de
            com.google.android.gms.internal.ads.zzajh r5 = r14.zzd
            r40 = r7
            long r7 = r5.zzh
            long r7 = r40 + r7
            r39[r12] = r7
        L_0x03de:
            r37[r12] = r28
            int r5 = r51 >> 16
            r18 = 1
            r5 = r5 & 1
            if (r5 != 0) goto L_0x03f3
            if (r48 == 0) goto L_0x03f0
            if (r12 != 0) goto L_0x03f3
            r5 = r18
            r12 = 0
            goto L_0x03f4
        L_0x03f0:
            r5 = r18
            goto L_0x03f4
        L_0x03f3:
            r5 = 0
        L_0x03f4:
            r38[r12] = r5
            long r7 = (long) r1
            long r9 = r9 + r7
            int r12 = r12 + 1
            r7 = r48
            r5 = r49
            r8 = r50
            goto L_0x037d
        L_0x0402:
            r50 = r8
            r3.zzp = r9
            r3 = r13
            r12 = r50
            goto L_0x0416
        L_0x040a:
            r27 = r1
            r28 = r3
            r29 = r5
            r30 = r7
            r31 = r9
            r32 = r10
        L_0x0416:
            int r1 = r27 + 1
            r5 = r29
            r7 = r30
            r9 = r31
            r10 = r32
            r8 = 1953658222(0x7472756e, float:7.683823E31)
            goto L_0x02a6
        L_0x0425:
            r30 = r7
            r31 = r9
            com.google.android.gms.internal.ads.zzajh r1 = r14.zzd
            com.google.android.gms.internal.ads.zzaje r1 = r1.zza
            com.google.android.gms.internal.ads.zzaio r3 = r4.zza
            r3.getClass()
            r5 = r3
            com.google.android.gms.internal.ads.zzaio r5 = (com.google.android.gms.internal.ads.zzaio) r5
            int r3 = r3.zza
            com.google.android.gms.internal.ads.zzajf r1 = r1.zza(r3)
            r3 = 1935763834(0x7361697a, float:1.785898E31)
            com.google.android.gms.internal.ads.zzet r3 = r11.zzb(r3)
            if (r3 == 0) goto L_0x04b9
            r1.getClass()
            r5 = r1
            com.google.android.gms.internal.ads.zzajf r5 = (com.google.android.gms.internal.ads.zzajf) r5
            int r5 = r1.zzd
            com.google.android.gms.internal.ads.zzed r3 = r3.zza
            r8 = 8
            r3.zzL(r8)
            int r7 = r3.zzg()
            r10 = 1
            r7 = r7 & r10
            if (r7 != r10) goto L_0x045e
            r3.zzM(r8)
        L_0x045e:
            int r7 = r3.zzm()
            int r8 = r3.zzp()
            int r9 = r4.zze
            if (r8 > r9) goto L_0x049d
            if (r7 != 0) goto L_0x0483
            boolean[] r7 = r4.zzl
            r9 = 0
            r10 = 0
        L_0x0470:
            if (r9 >= r8) goto L_0x0481
            int r12 = r3.zzm()
            int r10 = r10 + r12
            if (r12 <= r5) goto L_0x047b
            r12 = 1
            goto L_0x047c
        L_0x047b:
            r12 = 0
        L_0x047c:
            r7[r9] = r12
            int r9 = r9 + 1
            goto L_0x0470
        L_0x0481:
            r7 = 0
            goto L_0x0490
        L_0x0483:
            if (r7 <= r5) goto L_0x0487
            r3 = 1
            goto L_0x0488
        L_0x0487:
            r3 = 0
        L_0x0488:
            int r10 = r7 * r8
            boolean[] r5 = r4.zzl
            r7 = 0
            java.util.Arrays.fill(r5, r7, r8, r3)
        L_0x0490:
            boolean[] r3 = r4.zzl
            int r5 = r4.zze
            java.util.Arrays.fill(r3, r8, r5, r7)
            if (r10 <= 0) goto L_0x04b9
            r4.zza(r10)
            goto L_0x04b9
        L_0x049d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Saiz sample count "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r2 = " is greater than fragment sample count"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x04b9:
            r3 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzet r3 = r11.zzb(r3)
            if (r3 == 0) goto L_0x0504
            com.google.android.gms.internal.ads.zzed r3 = r3.zza
            r8 = 8
            r3.zzL(r8)
            int r5 = r3.zzg()
            r7 = r5 & 1
            r10 = 1
            if (r7 != r10) goto L_0x04d5
            r3.zzM(r8)
        L_0x04d5:
            int r7 = r3.zzp()
            if (r7 != r10) goto L_0x04f0
            int r5 = com.google.android.gms.internal.ads.zzain.zza(r5)
            long r7 = r4.zzc
            if (r5 != 0) goto L_0x04e8
            long r9 = r3.zzu()
            goto L_0x04ec
        L_0x04e8:
            long r9 = r3.zzw()
        L_0x04ec:
            long r7 = r7 + r9
            r4.zzc = r7
            goto L_0x0504
        L_0x04f0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected saio entry count: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r3 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r3)
            throw r1
        L_0x0504:
            r3 = 0
            r5 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzet r5 = r11.zzb(r5)
            if (r5 == 0) goto L_0x0514
            com.google.android.gms.internal.ads.zzed r5 = r5.zza
            r7 = 0
            zzk(r5, r7, r4)
        L_0x0514:
            if (r1 == 0) goto L_0x051b
            java.lang.String r1 = r1.zzb
            r34 = r1
            goto L_0x051d
        L_0x051b:
            r34 = r3
        L_0x051d:
            r1 = r3
            r5 = r1
            r7 = 0
        L_0x0520:
            java.util.List r8 = r11.zzb
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x055d
            java.util.List r8 = r11.zzb
            java.lang.Object r8 = r8.get(r7)
            com.google.android.gms.internal.ads.zzet r8 = (com.google.android.gms.internal.ads.zzet) r8
            com.google.android.gms.internal.ads.zzed r9 = r8.zza
            int r8 = r8.zzd
            r10 = 1935828848(0x73626770, float:1.7937577E31)
            r12 = 1936025959(0x73656967, float:1.817587E31)
            if (r8 != r10) goto L_0x0549
            r10 = 12
            r9.zzL(r10)
            int r8 = r9.zzg()
            if (r8 != r12) goto L_0x055a
            r1 = r9
            goto L_0x055a
        L_0x0549:
            r10 = 12
            r13 = 1936158820(0x73677064, float:1.8336489E31)
            if (r8 != r13) goto L_0x055a
            r9.zzL(r10)
            int r8 = r9.zzg()
            if (r8 != r12) goto L_0x055a
            r5 = r9
        L_0x055a:
            int r7 = r7 + 1
            goto L_0x0520
        L_0x055d:
            r10 = 12
            if (r1 == 0) goto L_0x05fd
            if (r5 != 0) goto L_0x0565
            goto L_0x05fd
        L_0x0565:
            r8 = 8
            r1.zzL(r8)
            int r7 = r1.zzg()
            int r7 = com.google.android.gms.internal.ads.zzain.zza(r7)
            r9 = 4
            r1.zzM(r9)
            r12 = 1
            if (r7 != r12) goto L_0x057c
            r1.zzM(r9)
        L_0x057c:
            int r1 = r1.zzg()
            if (r1 != r12) goto L_0x05f6
            r5.zzL(r8)
            int r1 = r5.zzg()
            int r1 = com.google.android.gms.internal.ads.zzain.zza(r1)
            r5.zzM(r9)
            if (r1 != r12) goto L_0x05a2
            long r7 = r5.zzu()
            int r1 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r1 == 0) goto L_0x059b
            goto L_0x05a8
        L_0x059b:
            java.lang.String r1 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x05a2:
            r8 = 2
            if (r1 < r8) goto L_0x05a8
            r5.zzM(r9)
        L_0x05a8:
            long r7 = r5.zzu()
            r12 = 1
            int r1 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x05ef
            r7 = 1
            r5.zzM(r7)
            int r1 = r5.zzm()
            r8 = r1 & 240(0xf0, float:3.36E-43)
            int r37 = r8 >> 4
            r38 = r1 & 15
            int r1 = r5.zzm()
            if (r1 != r7) goto L_0x05fe
            int r35 = r5.zzm()
            r1 = r16
            byte[] r8 = new byte[r1]
            r9 = 0
            r5.zzH(r8, r9, r1)
            if (r35 != 0) goto L_0x05dd
            int r1 = r5.zzm()
            byte[] r3 = new byte[r1]
            r5.zzH(r3, r9, r1)
        L_0x05dd:
            r39 = r3
            r4.zzk = r7
            com.google.android.gms.internal.ads.zzajf r32 = new com.google.android.gms.internal.ads.zzajf
            r33 = 1
            r36 = r8
            r32.<init>(r33, r34, r35, r36, r37, r38, r39)
            r1 = r32
            r4.zzm = r1
            goto L_0x05fe
        L_0x05ef:
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x05f6:
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x05fd:
            r7 = 1
        L_0x05fe:
            java.util.List r1 = r11.zzb
            int r1 = r1.size()
            r3 = 0
        L_0x0605:
            if (r3 >= r1) goto L_0x0637
            java.util.List r5 = r11.zzb
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.zzet r5 = (com.google.android.gms.internal.ads.zzet) r5
            int r8 = r5.zzd
            r9 = 1970628964(0x75756964, float:3.1109627E32)
            if (r8 != r9) goto L_0x062f
            com.google.android.gms.internal.ads.zzed r5 = r5.zza
            r8 = 8
            r5.zzL(r8)
            r9 = 0
            r12 = 16
            r5.zzH(r6, r9, r12)
            byte[] r13 = zza
            boolean r13 = java.util.Arrays.equals(r6, r13)
            if (r13 == 0) goto L_0x0634
            zzk(r5, r12, r4)
            goto L_0x0634
        L_0x062f:
            r8 = 8
            r9 = 0
            r12 = 16
        L_0x0634:
            int r3 = r3 + 1
            goto L_0x0605
        L_0x0637:
            r8 = 8
            r9 = 0
            r12 = 16
            goto L_0x0650
        L_0x063d:
            r23 = r1
            r22 = r3
            r30 = r7
            r31 = r9
            r12 = r16
            r7 = 1
            r9 = 0
            r10 = 12
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0650:
            int r1 = r31 + 1
            r9 = r1
            r16 = r12
            r3 = r22
            r1 = r23
            r7 = r30
            goto L_0x0160
        L_0x065d:
            r3 = 0
            r9 = 0
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzw r1 = zzh(r1)
            if (r1 == 0) goto L_0x06b3
            android.util.SparseArray r2 = r0.zzf
            int r2 = r2.size()
            r4 = r9
        L_0x0673:
            if (r4 >= r2) goto L_0x06b3
            android.util.SparseArray r5 = r0.zzf
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzais r5 = (com.google.android.gms.internal.ads.zzais) r5
            com.google.android.gms.internal.ads.zzajh r6 = r5.zzd
            com.google.android.gms.internal.ads.zzaje r6 = r6.zza
            com.google.android.gms.internal.ads.zzajg r7 = r5.zzb
            com.google.android.gms.internal.ads.zzaio r7 = r7.zza
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            r8 = r7
            com.google.android.gms.internal.ads.zzaio r8 = (com.google.android.gms.internal.ads.zzaio) r8
            int r7 = r7.zza
            com.google.android.gms.internal.ads.zzajf r6 = r6.zza(r7)
            if (r6 == 0) goto L_0x0695
            java.lang.String r6 = r6.zzb
            goto L_0x0696
        L_0x0695:
            r6 = r3
        L_0x0696:
            com.google.android.gms.internal.ads.zzw r6 = r1.zzb(r6)
            com.google.android.gms.internal.ads.zzajh r7 = r5.zzd
            com.google.android.gms.internal.ads.zzaje r7 = r7.zza
            com.google.android.gms.internal.ads.zzad r7 = r7.zzf
            com.google.android.gms.internal.ads.zzab r7 = r7.zzb()
            r7.zzF(r6)
            com.google.android.gms.internal.ads.zzad r6 = r7.zzaf()
            com.google.android.gms.internal.ads.zzadx r5 = r5.zza
            r5.zzl(r6)
            int r4 = r4 + 1
            goto L_0x0673
        L_0x06b3:
            long r1 = r0.zzy
            int r1 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x0002
            android.util.SparseArray r1 = r0.zzf
            int r1 = r1.size()
            r11 = r9
        L_0x06c0:
            if (r11 >= r1) goto L_0x06ea
            android.util.SparseArray r2 = r0.zzf
            java.lang.Object r2 = r2.valueAt(r11)
            com.google.android.gms.internal.ads.zzais r2 = (com.google.android.gms.internal.ads.zzais) r2
            long r3 = r0.zzy
            int r5 = r2.zzf
        L_0x06ce:
            com.google.android.gms.internal.ads.zzajg r6 = r2.zzb
            int r7 = r6.zze
            if (r5 >= r7) goto L_0x06e7
            long[] r7 = r6.zzi
            r7 = r7[r5]
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x06e7
            boolean[] r6 = r6.zzj
            boolean r6 = r6[r5]
            if (r6 == 0) goto L_0x06e4
            r2.zzi = r5
        L_0x06e4:
            int r5 = r5 + 1
            goto L_0x06ce
        L_0x06e7:
            int r11 = r11 + 1
            goto L_0x06c0
        L_0x06ea:
            r2 = r19
            r0.zzy = r2
            goto L_0x0002
        L_0x06f0:
            java.util.ArrayDeque r1 = r0.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0002
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzes r1 = (com.google.android.gms.internal.ads.zzes) r1
            r1.zzc(r2)
            goto L_0x0002
        L_0x0705:
            r0.zzj()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzait.zzl(long):void");
    }

    private static final zzaio zzm(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaio) sparseArray.valueAt(0);
        }
        zzaio zzaio = (zzaio) sparseArray.get(i);
        zzaio.getClass();
        zzaio zzaio2 = zzaio;
        return zzaio;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(long j, zzed zzed) {
        zzacd.zza(j, zzed, this.zzJ);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: com.google.android.gms.internal.ads.zzais} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r38, com.google.android.gms.internal.ads.zzadn r39) throws java.io.IOException {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
        L_0x0004:
            int r2 = r0.zzr
            r3 = 1701671783(0x656d7367, float:7.0083103E22)
            r4 = 1936286840(0x73696478, float:1.8491255E31)
            r6 = 2
            r7 = 8
            r8 = 0
            r9 = 1
            r10 = 0
            if (r2 == 0) goto L_0x0576
            java.lang.String r11 = "FragmentedMp4Extractor"
            if (r2 == r9) goto L_0x0332
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r13 = 3
            if (r2 == r6) goto L_0x02d4
            com.google.android.gms.internal.ads.zzais r2 = r0.zzB
            if (r2 != 0) goto L_0x009b
            android.util.SparseArray r2 = r0.zzf
            int r14 = r2.size()
            r15 = r3
            r3 = r8
            r4 = r10
        L_0x002d:
            if (r4 >= r14) goto L_0x0066
            java.lang.Object r17 = r2.valueAt(r4)
            r39 = r6
            r6 = r17
            com.google.android.gms.internal.ads.zzais r6 = (com.google.android.gms.internal.ads.zzais) r6
            boolean r17 = r6.zzl
            if (r17 != 0) goto L_0x0047
            int r5 = r6.zzf
            com.google.android.gms.internal.ads.zzajh r12 = r6.zzd
            int r12 = r12.zzb
            if (r5 == r12) goto L_0x0061
        L_0x0047:
            boolean r5 = r6.zzl
            if (r5 == 0) goto L_0x0056
            int r5 = r6.zzh
            com.google.android.gms.internal.ads.zzajg r12 = r6.zzb
            int r12 = r12.zzd
            if (r5 != r12) goto L_0x0056
            goto L_0x0061
        L_0x0056:
            long r19 = r6.zzd()
            int r5 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r5 >= 0) goto L_0x0061
            r3 = r6
            r15 = r19
        L_0x0061:
            int r4 = r4 + 1
            r6 = r39
            goto L_0x002d
        L_0x0066:
            r39 = r6
            if (r3 != 0) goto L_0x0082
            long r2 = r0.zzw
            long r4 = r1.zzf()
            long r2 = r2 - r4
            int r2 = (int) r2
            if (r2 < 0) goto L_0x007b
            r1.zzk(r2)
            r0.zzj()
            goto L_0x0004
        L_0x007b:
            java.lang.String r1 = "Offset to end of mdat was negative."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r8)
            throw r1
        L_0x0082:
            long r4 = r3.zzd()
            long r14 = r1.zzf()
            long r4 = r4 - r14
            int r2 = (int) r4
            if (r2 >= 0) goto L_0x0094
            java.lang.String r2 = "Ignoring negative offset to sample data."
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r2)
            r2 = r10
        L_0x0094:
            r1.zzk(r2)
            r0.zzB = r3
            r2 = r3
            goto L_0x009d
        L_0x009b:
            r39 = r6
        L_0x009d:
            int r3 = r0.zzr
            r4 = 6
            if (r3 != r13) goto L_0x0130
            int r3 = r2.zzb()
            r0.zzC = r3
            r0.zzF = r9
            int r5 = r2.zzf
            int r6 = r2.zzi
            if (r5 >= r6) goto L_0x00e2
            r1.zzk(r3)
            com.google.android.gms.internal.ads.zzajf r1 = r2.zzf()
            if (r1 != 0) goto L_0x00ba
            goto L_0x00d7
        L_0x00ba:
            com.google.android.gms.internal.ads.zzajg r3 = r2.zzb
            com.google.android.gms.internal.ads.zzed r3 = r3.zzn
            int r1 = r1.zzd
            if (r1 == 0) goto L_0x00c5
            r3.zzM(r1)
        L_0x00c5:
            com.google.android.gms.internal.ads.zzajg r1 = r2.zzb
            int r5 = r2.zzf
            boolean r1 = r1.zzb(r5)
            if (r1 == 0) goto L_0x00d7
            int r1 = r3.zzq()
            int r1 = r1 * r4
            r3.zzM(r1)
        L_0x00d7:
            boolean r1 = r2.zzk()
            if (r1 != 0) goto L_0x00df
            r0.zzB = r8
        L_0x00df:
            r1 = r13
            goto L_0x02cf
        L_0x00e2:
            com.google.android.gms.internal.ads.zzajh r5 = r2.zzd
            com.google.android.gms.internal.ads.zzaje r5 = r5.zza
            int r5 = r5.zzg
            if (r5 != r9) goto L_0x00f1
            int r3 = r3 + -8
            r0.zzC = r3
            r1.zzk(r7)
        L_0x00f1:
            com.google.android.gms.internal.ads.zzajh r3 = r2.zzd
            com.google.android.gms.internal.ads.zzaje r3 = r3.zza
            com.google.android.gms.internal.ads.zzad r3 = r3.zzf
            java.lang.String r5 = "audio/ac4"
            java.lang.String r3 = r3.zzo
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x011e
            int r3 = r0.zzC
            r5 = 7
            int r3 = r2.zzc(r3, r5)
            r0.zzD = r3
            int r3 = r0.zzC
            com.google.android.gms.internal.ads.zzed r6 = r0.zzk
            com.google.android.gms.internal.ads.zzabu.zzb(r3, r6)
            com.google.android.gms.internal.ads.zzadx r3 = r2.zza
            com.google.android.gms.internal.ads.zzed r6 = r0.zzk
            r3.zzq(r6, r5)
            int r3 = r0.zzD
            int r3 = r3 + r5
            r0.zzD = r3
            goto L_0x0126
        L_0x011e:
            int r3 = r0.zzC
            int r3 = r2.zzc(r3, r10)
            r0.zzD = r3
        L_0x0126:
            int r5 = r0.zzC
            int r5 = r5 + r3
            r0.zzC = r5
            r3 = 4
            r0.zzr = r3
            r0.zzE = r10
        L_0x0130:
            com.google.android.gms.internal.ads.zzajh r3 = r2.zzd
            com.google.android.gms.internal.ads.zzaje r3 = r3.zza
            com.google.android.gms.internal.ads.zzadx r5 = r2.zza
            long r6 = r2.zze()
            int r11 = r3.zzj
            if (r11 != 0) goto L_0x014f
        L_0x013e:
            int r3 = r0.zzD
            int r4 = r0.zzC
            if (r3 >= r4) goto L_0x0273
            int r4 = r4 - r3
            int r3 = r5.zzf(r1, r4, r10)
            int r4 = r0.zzD
            int r4 = r4 + r3
            r0.zzD = r4
            goto L_0x013e
        L_0x014f:
            com.google.android.gms.internal.ads.zzed r12 = r0.zzh
            byte[] r12 = r12.zzN()
            r12[r10] = r10
            r12[r9] = r10
            r12[r39] = r10
            int r14 = r11 + 1
            r18 = 4
            int r11 = 4 - r11
        L_0x0161:
            int r15 = r0.zzD
            int r13 = r0.zzC
            if (r15 >= r13) goto L_0x0273
            int r13 = r0.zzE
            java.lang.String r15 = "video/hevc"
            if (r13 != 0) goto L_0x01f3
            r1.zzi(r12, r11, r14)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzh
            r13.zzL(r10)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzh
            int r13 = r13.zzg()
            if (r13 <= 0) goto L_0x01eb
            int r13 = r13 + -1
            r0.zzE = r13
            com.google.android.gms.internal.ads.zzed r13 = r0.zzg
            r13.zzL(r10)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzg
            r10 = 4
            r5.zzq(r13, r10)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzh
            r5.zzq(r13, r9)
            com.google.android.gms.internal.ads.zzadx[] r13 = r0.zzJ
            int r13 = r13.length
            r18 = r10
            java.lang.String r10 = "video/avc"
            if (r13 <= 0) goto L_0x01bd
            com.google.android.gms.internal.ads.zzad r13 = r3.zzf
            java.lang.String r13 = r13.zzo
            byte r19 = r12[r18]
            byte[] r20 = com.google.android.gms.internal.ads.zzfp.zza
            boolean r20 = r10.equals(r13)
            if (r20 == 0) goto L_0x01af
            r8 = r19 & 31
            if (r8 == r4) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r8 = r9
            goto L_0x01be
        L_0x01af:
            boolean r8 = r15.equals(r13)
            if (r8 == 0) goto L_0x01bd
            r8 = r19 & 126(0x7e, float:1.77E-43)
            int r8 = r8 >> r9
            r13 = 39
            if (r8 != r13) goto L_0x01bd
            goto L_0x01ad
        L_0x01bd:
            r8 = 0
        L_0x01be:
            r0.zzG = r8
            int r8 = r0.zzD
            int r8 = r8 + 5
            r0.zzD = r8
            int r8 = r0.zzC
            int r8 = r8 + r11
            r0.zzC = r8
            boolean r8 = r0.zzF
            if (r8 != 0) goto L_0x026e
            com.google.android.gms.internal.ads.zzajh r8 = r2.zzd
            com.google.android.gms.internal.ads.zzaje r8 = r8.zza
            com.google.android.gms.internal.ads.zzad r8 = r8.zzf
            java.lang.String r8 = r8.zzo
            boolean r8 = java.util.Objects.equals(r8, r10)
            if (r8 == 0) goto L_0x026e
            r18 = 4
            byte r8 = r12[r18]
            boolean r8 = com.google.android.gms.internal.ads.zzfp.zzi(r8)
            if (r8 == 0) goto L_0x026e
            r0.zzF = r9
            goto L_0x026e
        L_0x01eb:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x01f3:
            boolean r8 = r0.zzG
            if (r8 == 0) goto L_0x025e
            com.google.android.gms.internal.ads.zzed r8 = r0.zzi
            r8.zzI(r13)
            com.google.android.gms.internal.ads.zzed r8 = r0.zzi
            byte[] r8 = r8.zzN()
            int r10 = r0.zzE
            r13 = 0
            r1.zzi(r8, r13, r10)
            com.google.android.gms.internal.ads.zzed r8 = r0.zzi
            int r10 = r0.zzE
            r5.zzq(r8, r10)
            int r8 = r0.zzE
            com.google.android.gms.internal.ads.zzed r10 = r0.zzi
            byte[] r13 = r10.zzN()
            int r10 = r10.zze()
            int r10 = com.google.android.gms.internal.ads.zzfp.zzb(r13, r10)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzi
            com.google.android.gms.internal.ads.zzad r4 = r3.zzf
            java.lang.String r4 = r4.zzo
            boolean r4 = r15.equals(r4)
            r13.zzL(r4)
            com.google.android.gms.internal.ads.zzed r4 = r0.zzi
            r4.zzK(r10)
            com.google.android.gms.internal.ads.zzad r4 = r3.zzf
            int r4 = r4.zzq
            r10 = -1
            if (r4 == r10) goto L_0x0249
            com.google.android.gms.internal.ads.zzft r10 = r0.zzp
            int r10 = r10.zza()
            if (r4 == r10) goto L_0x0249
            com.google.android.gms.internal.ads.zzft r4 = r0.zzp
            com.google.android.gms.internal.ads.zzad r10 = r3.zzf
            int r10 = r10.zzq
            r4.zzd(r10)
        L_0x0249:
            com.google.android.gms.internal.ads.zzft r4 = r0.zzp
            com.google.android.gms.internal.ads.zzed r10 = r0.zzi
            r4.zzb(r6, r10)
            int r4 = r2.zza()
            r4 = r4 & 5
            if (r4 == 0) goto L_0x0263
            com.google.android.gms.internal.ads.zzft r4 = r0.zzp
            r4.zzc()
            goto L_0x0263
        L_0x025e:
            r4 = 0
            int r8 = r5.zzf(r1, r13, r4)
        L_0x0263:
            int r4 = r0.zzD
            int r4 = r4 + r8
            r0.zzD = r4
            int r4 = r0.zzE
            int r4 = r4 - r8
            r0.zzE = r4
            r4 = 6
        L_0x026e:
            r8 = 0
            r10 = 0
            r13 = 3
            goto L_0x0161
        L_0x0273:
            int r22 = r2.zza()
            com.google.android.gms.internal.ads.zzajf r1 = r2.zzf()
            if (r1 == 0) goto L_0x0282
            com.google.android.gms.internal.ads.zzadw r1 = r1.zzc
            r25 = r1
            goto L_0x0284
        L_0x0282:
            r25 = 0
        L_0x0284:
            int r1 = r0.zzC
            r24 = 0
            r23 = r1
            r19 = r5
            r20 = r6
            r19.zzs(r20, r22, r23, r24, r25)
        L_0x0291:
            java.util.ArrayDeque r1 = r0.zzo
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x02c5
            java.util.ArrayDeque r1 = r0.zzo
            java.lang.Object r1 = r1.removeFirst()
            com.google.android.gms.internal.ads.zzair r1 = (com.google.android.gms.internal.ads.zzair) r1
            int r3 = r0.zzx
            int r4 = r1.zzc
            int r3 = r3 - r4
            r0.zzx = r3
            long r3 = r1.zza
            boolean r5 = r1.zzb
            if (r5 == 0) goto L_0x02b0
            long r3 = r3 + r20
        L_0x02b0:
            r6 = r3
            com.google.android.gms.internal.ads.zzadx[] r3 = r0.zzI
            int r4 = r3.length
            r12 = 0
        L_0x02b5:
            if (r12 >= r4) goto L_0x0291
            r5 = r3[r12]
            int r9 = r1.zzc
            int r10 = r0.zzx
            r11 = 0
            r8 = 1
            r5.zzs(r6, r8, r9, r10, r11)
            int r12 = r12 + 1
            goto L_0x02b5
        L_0x02c5:
            boolean r1 = r2.zzk()
            if (r1 != 0) goto L_0x02ce
            r2 = 0
            r0.zzB = r2
        L_0x02ce:
            r1 = 3
        L_0x02cf:
            r0.zzr = r1
            r26 = 0
            return r26
        L_0x02d4:
            android.util.SparseArray r2 = r0.zzf
            int r2 = r2.size()
            r5 = 0
            r6 = 0
        L_0x02dc:
            if (r5 >= r2) goto L_0x02ff
            android.util.SparseArray r7 = r0.zzf
            java.lang.Object r7 = r7.valueAt(r5)
            com.google.android.gms.internal.ads.zzais r7 = (com.google.android.gms.internal.ads.zzais) r7
            com.google.android.gms.internal.ads.zzajg r7 = r7.zzb
            boolean r8 = r7.zzo
            if (r8 == 0) goto L_0x02fc
            long r7 = r7.zzc
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x02fc
            android.util.SparseArray r3 = r0.zzf
            java.lang.Object r3 = r3.valueAt(r5)
            com.google.android.gms.internal.ads.zzais r3 = (com.google.android.gms.internal.ads.zzais) r3
            r6 = r3
            r3 = r7
        L_0x02fc:
            int r5 = r5 + 1
            goto L_0x02dc
        L_0x02ff:
            if (r6 != 0) goto L_0x0306
            r2 = 3
            r0.zzr = r2
            goto L_0x0004
        L_0x0306:
            long r7 = r1.zzf()
            long r3 = r3 - r7
            int r2 = (int) r3
            if (r2 < 0) goto L_0x032a
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzajg r2 = r6.zzb
            com.google.android.gms.internal.ads.zzed r3 = r2.zzn
            byte[] r4 = r3.zzN()
            int r3 = r3.zze()
            r13 = 0
            r1.zzi(r4, r13, r3)
            com.google.android.gms.internal.ads.zzed r3 = r2.zzn
            r3.zzL(r13)
            r2.zzo = r13
            goto L_0x0004
        L_0x032a:
            java.lang.String r1 = "Offset to encryption data was negative."
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0332:
            r39 = r6
            long r5 = r0.zzt
            int r2 = (int) r5
            int r5 = r0.zzu
            int r2 = r2 - r5
            com.google.android.gms.internal.ads.zzed r5 = r0.zzv
            if (r5 == 0) goto L_0x056a
            byte[] r6 = r5.zzN()
            r1.zzi(r6, r7, r2)
            com.google.android.gms.internal.ads.zzet r2 = new com.google.android.gms.internal.ads.zzet
            int r6 = r0.zzs
            r2.<init>(r6, r5)
            long r5 = r1.zzf()
            java.util.ArrayDeque r8 = r0.zzn
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0365
            java.util.ArrayDeque r3 = r0.zzn
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            r3.zzd(r2)
            goto L_0x056d
        L_0x0365:
            int r8 = r2.zzd
            if (r8 != r4) goto L_0x0437
            com.google.android.gms.internal.ads.zzed r2 = r2.zza
            r2.zzL(r7)
            int r3 = r2.zzg()
            int r3 = com.google.android.gms.internal.ads.zzain.zza(r3)
            r10 = 4
            r2.zzM(r10)
            long r15 = r2.zzu()
            if (r3 != 0) goto L_0x0389
            long r3 = r2.zzu()
            long r7 = r2.zzu()
            goto L_0x0391
        L_0x0389:
            long r3 = r2.zzw()
            long r7 = r2.zzw()
        L_0x0391:
            long r5 = r5 + r7
            r11 = r3
            r13 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r17 = java.math.RoundingMode.FLOOR
            long r3 = com.google.android.gms.internal.ads.zzen.zzu(r11, r13, r15, r17)
            r7 = r39
            r2.zzM(r7)
            int r7 = r2.zzq()
            int[] r8 = new int[r7]
            long[] r10 = new long[r7]
            long[] r13 = new long[r7]
            long[] r14 = new long[r7]
            r21 = r3
            r19 = r11
            r11 = 0
        L_0x03b2:
            if (r11 >= r7) goto L_0x040e
            int r12 = r2.zzg()
            r17 = -2147483648(0xffffffff80000000, float:-0.0)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x0406
            long r23 = r2.zzu()
            r17 = 2147483647(0x7fffffff, float:NaN)
            r12 = r12 & r17
            r8[r11] = r12
            r10[r11] = r5
            r14[r11] = r21
            long r19 = r19 + r23
            r12 = r13
            r17 = r14
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r17
            java.math.RoundingMode r17 = java.math.RoundingMode.FLOOR
            r26 = r11
            r9 = r12
            r11 = r19
            r19 = r3
            r3 = r21
            long r13 = com.google.android.gms.internal.ads.zzen.zzu(r11, r13, r15, r17)
            r23 = r3[r26]
            long r23 = r13 - r23
            r9[r26] = r23
            r4 = 4
            r2.zzM(r4)
            r4 = r8[r26]
            r23 = r5
            long r4 = (long) r4
            long r5 = r23 + r4
            int r4 = r26 + 1
            r21 = r13
            r14 = r3
            r13 = r9
            r9 = 1
            r35 = r11
            r11 = r4
            r3 = r19
            r19 = r35
            goto L_0x03b2
        L_0x0406:
            java.lang.String r1 = "Unhandled indirect reference"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x040e:
            r19 = r3
            r9 = r13
            r3 = r14
            java.lang.Long r2 = java.lang.Long.valueOf(r19)
            com.google.android.gms.internal.ads.zzace r4 = new com.google.android.gms.internal.ads.zzace
            r4.<init>(r8, r10, r9, r3)
            android.util.Pair r2 = android.util.Pair.create(r2, r4)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r0.zzA = r3
            com.google.android.gms.internal.ads.zzacu r3 = r0.zzH
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzadq r2 = (com.google.android.gms.internal.ads.zzadq) r2
            r3.zzO(r2)
            r2 = 1
            r0.zzK = r2
            goto L_0x056d
        L_0x0437:
            if (r8 != r3) goto L_0x056d
            com.google.android.gms.internal.ads.zzed r2 = r2.zza
            com.google.android.gms.internal.ads.zzadx[] r3 = r0.zzI
            int r3 = r3.length
            if (r3 == 0) goto L_0x056d
            r2.zzL(r7)
            int r3 = r2.zzg()
            int r3 = com.google.android.gms.internal.ads.zzain.zza(r3)
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L_0x04a9
            r6 = 1
            if (r3 == r6) goto L_0x0468
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Skipping unsupported emsg version: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r11, r2)
            goto L_0x056d
        L_0x0468:
            long r16 = r2.zzu()
            long r12 = r2.zzw()
            r14 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r18 = java.math.RoundingMode.FLOOR
            long r6 = com.google.android.gms.internal.ads.zzen.zzu(r12, r14, r16, r18)
            long r12 = r2.zzu()
            r14 = 1000(0x3e8, double:4.94E-321)
            java.math.RoundingMode r18 = java.math.RoundingMode.FLOOR
            long r8 = com.google.android.gms.internal.ads.zzen.zzu(r12, r14, r16, r18)
            long r10 = r2.zzu()
            r13 = 0
            java.lang.String r3 = r2.zzy(r13)
            r3.getClass()
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r12 = r2.zzy(r13)
            r12.getClass()
            r14 = r12
            java.lang.String r14 = (java.lang.String) r14
            r30 = r8
            r32 = r10
            r9 = r4
            r7 = r6
        L_0x04a4:
            r28 = r3
            r29 = r12
            goto L_0x04f2
        L_0x04a9:
            r13 = 0
            java.lang.String r3 = r2.zzy(r13)
            r3.getClass()
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r12 = r2.zzy(r13)
            r12.getClass()
            r6 = r12
            java.lang.String r6 = (java.lang.String) r6
            long r17 = r2.zzu()
            long r13 = r2.zzu()
            r15 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r19 = java.math.RoundingMode.FLOOR
            long r6 = com.google.android.gms.internal.ads.zzen.zzu(r13, r15, r17, r19)
            long r8 = r0.zzA
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x04d7
            long r8 = r8 + r6
            goto L_0x04d8
        L_0x04d7:
            r8 = r4
        L_0x04d8:
            long r13 = r2.zzu()
            r15 = 1000(0x3e8, double:4.94E-321)
            java.math.RoundingMode r19 = java.math.RoundingMode.FLOOR
            long r10 = com.google.android.gms.internal.ads.zzen.zzu(r13, r15, r17, r19)
            long r13 = r2.zzu()
            r30 = r10
            r32 = r13
            r35 = r8
            r9 = r6
            r7 = r35
            goto L_0x04a4
        L_0x04f2:
            int r3 = r2.zzb()
            byte[] r3 = new byte[r3]
            int r6 = r2.zzb()
            r13 = 0
            r2.zzH(r3, r13, r6)
            com.google.android.gms.internal.ads.zzafo r27 = new com.google.android.gms.internal.ads.zzafo
            r34 = r3
            r27.<init>(r28, r29, r30, r32, r34)
            r2 = r27
            com.google.android.gms.internal.ads.zzafp r3 = r0.zzl
            com.google.android.gms.internal.ads.zzed r6 = new com.google.android.gms.internal.ads.zzed
            byte[] r2 = r3.zza(r2)
            r6.<init>((byte[]) r2)
            int r2 = r6.zzb()
            com.google.android.gms.internal.ads.zzadx[] r3 = r0.zzI
            int r11 = r3.length
            r12 = 0
        L_0x051c:
            if (r12 >= r11) goto L_0x052a
            r13 = r3[r12]
            r14 = 0
            r6.zzL(r14)
            r13.zzq(r6, r2)
            int r12 = r12 + 1
            goto L_0x051c
        L_0x052a:
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x053f
            java.util.ArrayDeque r3 = r0.zzo
            com.google.android.gms.internal.ads.zzair r4 = new com.google.android.gms.internal.ads.zzair
            r6 = 1
            r4.<init>(r9, r6, r2)
            r3.addLast(r4)
            int r3 = r0.zzx
            int r3 = r3 + r2
            r0.zzx = r3
            goto L_0x056d
        L_0x053f:
            java.util.ArrayDeque r3 = r0.zzo
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0558
            java.util.ArrayDeque r3 = r0.zzo
            com.google.android.gms.internal.ads.zzair r4 = new com.google.android.gms.internal.ads.zzair
            r13 = 0
            r4.<init>(r7, r13, r2)
            r3.addLast(r4)
            int r3 = r0.zzx
            int r3 = r3 + r2
            r0.zzx = r3
            goto L_0x056d
        L_0x0558:
            com.google.android.gms.internal.ads.zzadx[] r3 = r0.zzI
            int r4 = r3.length
            r5 = 0
        L_0x055c:
            if (r5 >= r4) goto L_0x056d
            r6 = r3[r5]
            r11 = 0
            r12 = 0
            r9 = 1
            r10 = r2
            r6.zzs(r7, r9, r10, r11, r12)
            int r5 = r5 + 1
            goto L_0x055c
        L_0x056a:
            r1.zzk(r2)
        L_0x056d:
            long r2 = r1.zzf()
            r0.zzl(r2)
            goto L_0x0004
        L_0x0576:
            int r2 = r0.zzu
            if (r2 != 0) goto L_0x05a7
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            byte[] r2 = r2.zzN()
            r6 = 1
            r13 = 0
            boolean r2 = r1.zzn(r2, r13, r7, r6)
            if (r2 != 0) goto L_0x0590
            com.google.android.gms.internal.ads.zzft r1 = r0.zzp
            r1.zzc()
            r17 = -1
            return r17
        L_0x0590:
            r0.zzu = r7
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            r2.zzL(r13)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            long r5 = r2.zzu()
            r0.zzt = r5
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            int r2 = r2.zzg()
            r0.zzs = r2
        L_0x05a7:
            long r5 = r0.zzt
            r8 = 1
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x05c6
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            byte[] r2 = r2.zzN()
            r1.zzi(r2, r7, r7)
            int r2 = r0.zzu
            int r2 = r2 + r7
            r0.zzu = r2
            com.google.android.gms.internal.ads.zzed r2 = r0.zzm
            long r5 = r2.zzw()
            r0.zzt = r5
            goto L_0x05f9
        L_0x05c6:
            r8 = 0
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x05f9
            long r5 = r1.zzd()
            r8 = -1
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x05ea
            java.util.ArrayDeque r2 = r0.zzn
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x05e9
            java.util.ArrayDeque r2 = r0.zzn
            java.lang.Object r2 = r2.peek()
            com.google.android.gms.internal.ads.zzes r2 = (com.google.android.gms.internal.ads.zzes) r2
            long r5 = r2.zza
            goto L_0x05ea
        L_0x05e9:
            r5 = r8
        L_0x05ea:
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x05f9
            long r8 = r1.zzf()
            long r5 = r5 - r8
            int r2 = r0.zzu
            long r8 = (long) r2
            long r5 = r5 + r8
            r0.zzt = r5
        L_0x05f9:
            long r5 = r0.zzt
            int r2 = r0.zzu
            long r8 = (long) r2
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x077c
            long r5 = r1.zzf()
            long r5 = r5 - r8
            int r2 = r0.zzs
            r8 = 1835295092(0x6d646174, float:4.4175247E27)
            r9 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r2 == r9) goto L_0x0613
            if (r2 != r8) goto L_0x0626
        L_0x0613:
            boolean r2 = r0.zzK
            if (r2 != 0) goto L_0x0626
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzH
            com.google.android.gms.internal.ads.zzadp r10 = new com.google.android.gms.internal.ads.zzadp
            long r11 = r0.zzz
            r10.<init>(r11, r5)
            r2.zzO(r10)
            r2 = 1
            r0.zzK = r2
        L_0x0626:
            int r2 = r0.zzs
            if (r2 != r9) goto L_0x0644
            android.util.SparseArray r2 = r0.zzf
            int r2 = r2.size()
            r13 = 0
        L_0x0631:
            if (r13 >= r2) goto L_0x0644
            android.util.SparseArray r10 = r0.zzf
            java.lang.Object r10 = r10.valueAt(r13)
            com.google.android.gms.internal.ads.zzais r10 = (com.google.android.gms.internal.ads.zzais) r10
            com.google.android.gms.internal.ads.zzajg r10 = r10.zzb
            r10.zzc = r5
            r10.zzb = r5
            int r13 = r13 + 1
            goto L_0x0631
        L_0x0644:
            int r2 = r0.zzs
            if (r2 != r8) goto L_0x0655
            r8 = 0
            r0.zzB = r8
            long r2 = r0.zzt
            long r5 = r5 + r2
            r0.zzw = r5
            r7 = 2
            r0.zzr = r7
            goto L_0x0004
        L_0x0655:
            r5 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r2 == r5) goto L_0x0755
            r5 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r5) goto L_0x0755
            r5 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r2 == r5) goto L_0x0755
            r5 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r2 == r5) goto L_0x0755
            r5 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r2 == r5) goto L_0x0755
            if (r2 == r9) goto L_0x0755
            r5 = 1953653094(0x74726166, float:7.6813435E31)
            if (r2 == r5) goto L_0x0755
            r5 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r2 == r5) goto L_0x0755
            r5 = 1701082227(0x65647473, float:6.742798E22)
            if (r2 != r5) goto L_0x0681
            goto L_0x0755
        L_0x0681:
            r5 = 1751411826(0x68646c72, float:4.3148E24)
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == r5) goto L_0x0720
            r5 = 1835296868(0x6d646864, float:4.418049E27)
            if (r2 == r5) goto L_0x0720
            r5 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r2 == r5) goto L_0x0720
            if (r2 == r4) goto L_0x0720
            r4 = 1937011556(0x73747364, float:1.9367383E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1937011827(0x73747473, float:1.9367711E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1668576371(0x63747473, float:4.5093966E21)
            if (r2 == r4) goto L_0x0720
            r4 = 1937011555(0x73747363, float:1.9367382E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1937011578(0x7374737a, float:1.936741E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r2 == r4) goto L_0x0720
            r4 = 1937011571(0x73747373, float:1.9367401E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1952867444(0x74666474, float:7.3014264E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1952868452(0x74666864, float:7.301914E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1953196132(0x746b6864, float:7.46037E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1953654136(0x74726578, float:7.6818474E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1953658222(0x7472756e, float:7.683823E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1886614376(0x70737368, float:3.013775E29)
            if (r2 == r4) goto L_0x0720
            r4 = 1935763834(0x7361697a, float:1.785898E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1935763823(0x7361696f, float:1.7858967E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1936027235(0x73656e63, float:1.8177412E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1970628964(0x75756964, float:3.1109627E32)
            if (r2 == r4) goto L_0x0720
            r4 = 1935828848(0x73626770, float:1.7937577E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1936158820(0x73677064, float:1.8336489E31)
            if (r2 == r4) goto L_0x0720
            r4 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r2 == r4) goto L_0x0720
            r4 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r2 == r4) goto L_0x0720
            if (r2 != r3) goto L_0x070b
            goto L_0x0720
        L_0x070b:
            long r2 = r0.zzt
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0719
            r2 = 0
            r0.zzv = r2
            r6 = 1
            r0.zzr = r6
            goto L_0x0004
        L_0x0719:
            java.lang.String r1 = "Skipping atom with length > 2147483647 (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x0720:
            int r2 = r0.zzu
            if (r2 != r7) goto L_0x074e
            long r2 = r0.zzt
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0747
            com.google.android.gms.internal.ads.zzed r2 = new com.google.android.gms.internal.ads.zzed
            long r3 = r0.zzt
            int r3 = (int) r3
            r2.<init>((int) r3)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzm
            byte[] r3 = r3.zzN()
            byte[] r4 = r2.zzN()
            r13 = 0
            java.lang.System.arraycopy(r3, r13, r4, r13, r7)
            r0.zzv = r2
            r6 = 1
            r0.zzr = r6
            goto L_0x0004
        L_0x0747:
            java.lang.String r1 = "Leaf atom with length > 2147483647 (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x074e:
            java.lang.String r1 = "Leaf atom defines extended atom size (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        L_0x0755:
            long r3 = r1.zzf()
            long r5 = r0.zzt
            long r3 = r3 + r5
            java.util.ArrayDeque r5 = r0.zzn
            com.google.android.gms.internal.ads.zzes r6 = new com.google.android.gms.internal.ads.zzes
            r7 = -8
            long r3 = r3 + r7
            r6.<init>(r2, r3)
            r5.push(r6)
            long r5 = r0.zzt
            int r2 = r0.zzu
            long r7 = (long) r2
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0777
            r0.zzl(r3)
            goto L_0x0004
        L_0x0777:
            r0.zzj()
            goto L_0x0004
        L_0x077c:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzait.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return this.zzq;
    }

    public final void zze(zzacu zzacu) {
        int i;
        if ((this.zzd & 32) == 0) {
            zzacu = new zzakj(zzacu, this.zzc);
        }
        this.zzH = zzacu;
        zzj();
        zzadx[] zzadxArr = new zzadx[2];
        this.zzI = zzadxArr;
        int i2 = 100;
        int i3 = 0;
        if ((this.zzd & 4) != 0) {
            zzadxArr[0] = this.zzH.zzw(100, 5);
            i = 1;
            i2 = 101;
        } else {
            i = 0;
        }
        zzadx[] zzadxArr2 = (zzadx[]) zzen.zzO(this.zzI, i);
        this.zzI = zzadxArr2;
        for (zzadx zzl2 : zzadxArr2) {
            zzl2.zzl(zzb);
        }
        this.zzJ = new zzadx[this.zze.size()];
        while (i3 < this.zzJ.length) {
            zzadx zzw2 = this.zzH.zzw(i2, 3);
            zzw2.zzl((zzad) this.zze.get(i3));
            this.zzJ[i3] = zzw2;
            i3++;
            i2++;
        }
    }

    public final void zzf(long j, long j2) {
        int size = this.zzf.size();
        for (int i = 0; i < size; i++) {
            ((zzais) this.zzf.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzx = 0;
        this.zzp.zzc();
        this.zzy = j2;
        this.zzn.clear();
        zzj();
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzadu zza2 = zzajd.zza(zzacs);
        this.zzq = zza2 != null ? zzfzo.zzo(zza2) : zzfzo.zzn();
        return zza2 == null;
    }

    public zzait(zzakg zzakg, int i, zzek zzek, zzaje zzaje, List list, zzadx zzadx) {
        this.zzc = zzakg;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafp();
        this.zzm = new zzed(16);
        this.zzg = new zzed(zzfp.zza);
        this.zzh = new zzed(5);
        this.zzi = new zzed();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzed(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzq = zzfzo.zzn();
        this.zzz = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzH = zzacu.zza;
        this.zzI = new zzadx[0];
        this.zzJ = new zzadx[0];
        this.zzp = new zzft(new zzaiq(this));
    }
}
