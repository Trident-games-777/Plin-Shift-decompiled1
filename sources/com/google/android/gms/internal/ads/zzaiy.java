package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaiy implements zzacr, zzadq {
    private int zzA;
    private zzagz zzB;
    private final zzakg zza;
    private final int zzb;
    private final zzed zzc;
    private final zzed zzd;
    private final zzed zze;
    private final zzed zzf;
    private final ArrayDeque zzg;
    private final zzajc zzh;
    private final List zzi;
    private zzfzo zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzed zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private zzacu zzv;
    private zzaix[] zzw;
    private long[][] zzx;
    private int zzy;
    private long zzz;

    @Deprecated
    public zzaiy() {
        this(zzakg.zza, 16);
    }

    private static int zzj(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzk(zzajh zzajh, long j) {
        int zza2 = zzajh.zza(j);
        return zza2 == -1 ? zzajh.zzb(j) : zza2;
    }

    private static long zzl(zzajh zzajh, long j, long j2) {
        int zzk2 = zzk(zzajh, j);
        if (zzk2 == -1) {
            return j2;
        }
        return Math.min(zzajh.zzc[zzk2], j2);
    }

    private final void zzm() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzn(long j) throws zzbh {
        zzbd zzbd;
        boolean z;
        long j2;
        long j3;
        zzbd zzbd2;
        List list;
        int i;
        ArrayList arrayList;
        int i2;
        zzbd zzbd3;
        zzbd zzbd4;
        int i3;
        while (!this.zzg.isEmpty() && ((zzes) this.zzg.peek()).zza == j) {
            zzes zzes = (zzes) this.zzg.pop();
            if (zzes.zzd == 1836019574) {
                zzes zza2 = zzes.zza(1835365473);
                new ArrayList();
                zzbd zzb2 = zza2 != null ? zzain.zzb(zza2) : null;
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                boolean z2 = this.zzA == 1;
                zzadf zzadf = new zzadf();
                zzet zzb3 = zzes.zzb(1969517665);
                if (zzb3 != null) {
                    zzbd zzc2 = zzain.zzc(zzb3);
                    zzadf.zzb(zzc2);
                    zzbd = zzc2;
                } else {
                    zzbd = null;
                }
                zzet zzb4 = zzes.zzb(1836476516);
                zzb4.getClass();
                zzet zzet = zzb4;
                zzbd zzbd5 = new zzbd(-9223372036854775807L, zzain.zzd(zzb4.zza));
                if (1 != (this.zzb & 1)) {
                    j2 = -9223372036854775807L;
                    z = false;
                } else {
                    j2 = -9223372036854775807L;
                    z = true;
                }
                zzbd zzbd6 = zzbd5;
                ArrayList arrayList3 = arrayList2;
                List zzf2 = zzain.zzf(zzes, zzadf, -9223372036854775807L, (zzw) null, z, z2, new zzaiw());
                long j4 = j2;
                long j5 = j4;
                int i5 = 0;
                int i6 = 0;
                int i7 = -1;
                while (true) {
                    j3 = 0;
                    if (i5 >= zzf2.size()) {
                        break;
                    }
                    zzajh zzajh = (zzajh) zzf2.get(i5);
                    if (zzajh.zzb == 0) {
                        zzbd2 = zzb2;
                        list = zzf2;
                        i = i6;
                        arrayList = arrayList3;
                    } else {
                        zzaje zzaje = zzajh.zza;
                        int i8 = i4;
                        long j6 = zzaje.zze;
                        if (j6 == j5) {
                            j6 = zzajh.zzh;
                        }
                        j4 = Math.max(j4, j6);
                        i = i6 + 1;
                        list = zzf2;
                        zzaix zzaix = new zzaix(zzaje, zzajh, this.zzv.zzw(i6, zzaje.zzb));
                        if ("audio/true-hd".equals(zzaje.zzf.zzo)) {
                            i2 = zzajh.zze * 16;
                        } else {
                            i2 = zzajh.zze + 30;
                        }
                        zzab zzb5 = zzaje.zzf.zzb();
                        zzb5.zzQ(i2);
                        if (zzaje.zzb == 2) {
                            zzad zzad = zzaje.zzf;
                            int i9 = this.zzb;
                            int i10 = zzad.zzf;
                            if ((i9 & 8) != 0) {
                                i10 |= i7 == -1 ? 1 : 2;
                            }
                            if (j6 > 0 && (i3 = zzajh.zzb) > 0) {
                                zzb5.zzI(((float) i3) / (((float) j6) / 1000000.0f));
                            }
                            zzb5.zzX(i10);
                        }
                        if (zzaje.zzb == 1 && zzadf.zza()) {
                            zzb5.zzG(zzadf.zza);
                            zzb5.zzH(zzadf.zzb);
                        }
                        int i11 = zzaje.zzb;
                        zzbd[] zzbdArr = new zzbd[3];
                        if (this.zzi.isEmpty()) {
                            zzbd3 = null;
                        } else {
                            zzbd3 = new zzbd(this.zzi);
                        }
                        zzbdArr[i8] = zzbd3;
                        zzbdArr[1] = zzbd;
                        zzbdArr[2] = zzbd6;
                        zzbd[] zzbdArr2 = zzbdArr;
                        zzbd zzbd7 = new zzbd(j5, new zzbc[i8]);
                        if (zzb2 != null) {
                            int i12 = 0;
                            while (i12 < zzb2.zza()) {
                                zzbc zzb6 = zzb2.zzb(i12);
                                if (zzb6 instanceof zzer) {
                                    zzer zzer = (zzer) zzb6;
                                    zzbd4 = zzb2;
                                    if (!zzer.zza.equals("com.android.capture.fps")) {
                                        zzbd7 = zzbd7.zzc(zzer);
                                    } else if (i11 == 2) {
                                        zzbd7 = zzbd7.zzc(zzer);
                                    }
                                } else {
                                    zzbd4 = zzb2;
                                }
                                i12++;
                                zzb2 = zzbd4;
                            }
                        }
                        zzbd2 = zzb2;
                        for (int i13 = 0; i13 < 3; i13++) {
                            zzbd7 = zzbd7.zzd(zzbdArr2[i13]);
                        }
                        if (zzbd7.zza() > 0) {
                            zzb5.zzS(zzbd7);
                        }
                        zzaix.zzc.zzl(zzb5.zzaf());
                        if (zzaje.zzb == 2) {
                            if (i7 == -1) {
                                i7 = arrayList3.size();
                            }
                        }
                        arrayList = arrayList3;
                        arrayList.add(zzaix);
                    }
                    i5++;
                    arrayList3 = arrayList;
                    i6 = i;
                    zzf2 = list;
                    zzb2 = zzbd2;
                    i4 = 0;
                    j5 = -9223372036854775807L;
                }
                this.zzy = i7;
                this.zzz = j4;
                zzaix[] zzaixArr = (zzaix[]) arrayList3.toArray(new zzaix[0]);
                this.zzw = zzaixArr;
                int length = zzaixArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i14 = 0; i14 < zzaixArr.length; i14++) {
                    jArr[i14] = new long[zzaixArr[i14].zzb.zzb];
                    jArr2[i14] = zzaixArr[i14].zzb.zzf[0];
                }
                int i15 = 0;
                while (i15 < zzaixArr.length) {
                    long j7 = Long.MAX_VALUE;
                    int i16 = -1;
                    for (int i17 = 0; i17 < zzaixArr.length; i17++) {
                        if (!zArr[i17]) {
                            long j8 = jArr2[i17];
                            if (j8 <= j7) {
                                i16 = i17;
                                j7 = j8;
                            }
                        }
                    }
                    int i18 = iArr[i16];
                    long[] jArr3 = jArr[i16];
                    jArr3[i18] = j3;
                    zzajh zzajh2 = zzaixArr[i16].zzb;
                    j3 += (long) zzajh2.zzd[i18];
                    int i19 = i18 + 1;
                    iArr[i16] = i19;
                    if (i19 < jArr3.length) {
                        jArr2[i16] = zzajh2.zzf[i19];
                    } else {
                        zArr[i16] = true;
                        i15++;
                    }
                }
                this.zzx = jArr;
                this.zzv.zzD();
                this.zzv.zzO(this);
                this.zzg.clear();
                this.zzk = 2;
            } else if (!this.zzg.isEmpty()) {
                ((zzes) this.zzg.peek()).zzc(zzes);
            }
        }
        if (this.zzk != 2) {
            zzm();
        }
    }

    public final long zza() {
        return this.zzz;
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    public final void zze(zzacu zzacu) {
        if ((this.zzb & 16) == 0) {
            zzacu = new zzakj(zzacu, this.zza);
        }
        this.zzv = zzacu;
    }

    public final void zzf(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = true;
        if (j != 0) {
            for (zzaix zzaix : this.zzw) {
                zzajh zzajh = zzaix.zzb;
                int zza2 = zzajh.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzajh.zzb(j2);
                }
                zzaix.zze = zza2;
                zzady zzady = zzaix.zzd;
                if (zzady != null) {
                    zzady.zzb();
                }
            }
        } else if (this.zzk != 3) {
            zzm();
        } else {
            this.zzh.zzb();
            this.zzi.clear();
        }
    }

    public final zzado zzg(long j) {
        long j2;
        long j3;
        int zzb2;
        zzaix[] zzaixArr = this.zzw;
        if (zzaixArr.length == 0) {
            zzadr zzadr = zzadr.zza;
            return new zzado(zzadr, zzadr);
        }
        int i = this.zzy;
        long j4 = -1;
        if (i != -1) {
            zzajh zzajh = zzaixArr[i].zzb;
            int zzk2 = zzk(zzajh, j);
            if (zzk2 == -1) {
                zzadr zzadr2 = zzadr.zza;
                return new zzado(zzadr2, zzadr2);
            }
            long j5 = zzajh.zzf[zzk2];
            j2 = zzajh.zzc[zzk2];
            if (j5 >= j || zzk2 >= zzajh.zzb - 1 || (zzb2 = zzajh.zzb(j)) == -1 || zzb2 == zzk2) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzajh.zzf[zzb2];
                j4 = zzajh.zzc[zzb2];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzaix[] zzaixArr2 = this.zzw;
            if (i2 >= zzaixArr2.length) {
                break;
            }
            if (i2 != this.zzy) {
                zzajh zzajh2 = zzaixArr2[i2].zzb;
                long zzl2 = zzl(zzajh2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = zzl(zzajh2, j3, j4);
                }
                j2 = zzl2;
            }
            i2++;
        }
        zzadr zzadr3 = new zzadr(j, j2);
        if (j3 == -9223372036854775807L) {
            return new zzado(zzadr3, zzadr3);
        }
        return new zzado(zzadr3, new zzadr(j3, j4));
    }

    public final boolean zzh() {
        return true;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        zzadu zzb2 = zzajd.zzb(zzacs, (this.zzb & 2) != 0);
        this.zzj = zzb2 != null ? zzfzo.zzo(zzb2) : zzfzo.zzn();
        return zzb2 == null;
    }

    public zzaiy(zzakg zzakg, int i) {
        this.zza = zzakg;
        this.zzb = i;
        this.zzj = zzfzo.zzn();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzajc();
        this.zzi = new ArrayList();
        this.zzf = new zzed(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzed(zzfp.zza);
        this.zzd = new zzed(5);
        this.zze = new zzed();
        this.zzp = -1;
        this.zzv = zzacu.zza;
        this.zzw = new zzaix[0];
        this.zzt = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:247:0x009f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacs r34, com.google.android.gms.internal.ads.zzadn r35) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            r2 = r35
        L_0x0006:
            int r3 = r0.zzk
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r7 = 0
            r9 = 2
            r10 = -1
            r11 = 8
            r12 = 1
            r13 = 0
            if (r3 == 0) goto L_0x02b0
            if (r3 == r12) goto L_0x0220
            if (r3 == r9) goto L_0x002a
            com.google.android.gms.internal.ads.zzajc r3 = r0.zzh
            java.util.List r4 = r0.zzi
            r3.zza(r1, r2, r4)
            long r1 = r2.zza
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0029
            r0.zzm()
        L_0x0029:
            return r12
        L_0x002a:
            long r3 = r1.zzf()
            int r11 = r0.zzp
            if (r11 != r10) goto L_0x00c3
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r25 = r10
            r26 = r25
            r20 = r12
            r27 = r20
            r11 = r13
            r18 = r16
            r21 = r18
            r23 = r21
            r28 = 262144(0x40000, double:1.295163E-318)
        L_0x0049:
            com.google.android.gms.internal.ads.zzaix[] r14 = r0.zzw
            int r15 = r14.length
            if (r11 >= r15) goto L_0x00a6
            r14 = r14[r11]
            int r15 = r14.zze
            com.google.android.gms.internal.ads.zzajh r14 = r14.zzb
            r30 = r7
            int r7 = r14.zzb
            if (r15 != r7) goto L_0x005d
            r32 = r9
            goto L_0x009f
        L_0x005d:
            long[] r7 = r14.zzc
            r7 = r7[r15]
            long[][] r14 = r0.zzx
            int r32 = com.google.android.gms.internal.ads.zzen.zza
            long[][] r14 = (long[][]) r14
            r14 = r14[r11]
            r14 = r14[r15]
            long r7 = r7 - r3
            int r32 = (r7 > r30 ? 1 : (r7 == r30 ? 0 : -1))
            if (r32 < 0) goto L_0x0079
            int r32 = (r7 > r28 ? 1 : (r7 == r28 ? 0 : -1))
            if (r32 < 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            r32 = r9
            r9 = r13
            goto L_0x007c
        L_0x0079:
            r32 = r9
            r9 = r12
        L_0x007c:
            if (r9 != 0) goto L_0x0082
            if (r27 != 0) goto L_0x008a
            r5 = r13
            goto L_0x0084
        L_0x0082:
            r5 = r27
        L_0x0084:
            if (r9 != r5) goto L_0x0093
            int r27 = (r7 > r23 ? 1 : (r7 == r23 ? 0 : -1))
            if (r27 >= 0) goto L_0x0093
        L_0x008a:
            r23 = r7
            r27 = r9
            r26 = r11
            r21 = r14
            goto L_0x0095
        L_0x0093:
            r27 = r5
        L_0x0095:
            int r5 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r5 >= 0) goto L_0x009f
            r20 = r9
            r25 = r11
            r18 = r14
        L_0x009f:
            int r11 = r11 + 1
            r7 = r30
            r9 = r32
            goto L_0x0049
        L_0x00a6:
            r30 = r7
            r32 = r9
            int r5 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x00bc
            if (r20 == 0) goto L_0x00bc
            r7 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r7
            int r5 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r5 < 0) goto L_0x00bc
            r11 = r25
            goto L_0x00be
        L_0x00bc:
            r11 = r26
        L_0x00be:
            r0.zzp = r11
            if (r11 != r10) goto L_0x00ca
            return r10
        L_0x00c3:
            r30 = r7
            r32 = r9
            r28 = 262144(0x40000, double:1.295163E-318)
        L_0x00ca:
            com.google.android.gms.internal.ads.zzaix[] r5 = r0.zzw
            r5 = r5[r11]
            com.google.android.gms.internal.ads.zzadx r14 = r5.zzc
            int r7 = r5.zze
            com.google.android.gms.internal.ads.zzajh r8 = r5.zzb
            long[] r9 = r8.zzc
            r10 = r9[r7]
            int[] r8 = r8.zzd
            r8 = r8[r7]
            com.google.android.gms.internal.ads.zzady r9 = r5.zzd
            long r3 = r10 - r3
            int r15 = r0.zzq
            r23 = r7
            r16 = 4
            long r6 = (long) r15
            long r3 = r3 + r6
            int r6 = (r3 > r30 ? 1 : (r3 == r30 ? 0 : -1))
            if (r6 < 0) goto L_0x021d
            int r6 = (r3 > r28 ? 1 : (r3 == r28 ? 0 : -1))
            if (r6 < 0) goto L_0x00f2
            goto L_0x021d
        L_0x00f2:
            com.google.android.gms.internal.ads.zzaje r2 = r5.zza
            int r2 = r2.zzg
            if (r2 != r12) goto L_0x00fd
            r6 = 8
            long r3 = r3 + r6
            int r8 = r8 + -8
        L_0x00fd:
            int r2 = (int) r3
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzaje r2 = r5.zza
            com.google.android.gms.internal.ads.zzad r2 = r2.zzf
            java.lang.String r2 = r2.zzo
            java.lang.String r3 = "video/avc"
            boolean r2 = java.util.Objects.equals(r2, r3)
            if (r2 != 0) goto L_0x0111
            r0.zzt = r12
        L_0x0111:
            com.google.android.gms.internal.ads.zzaje r2 = r5.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x0190
            com.google.android.gms.internal.ads.zzed r2 = r0.zzd
            byte[] r2 = r2.zzN()
            r2[r13] = r13
            r2[r12] = r13
            r2[r32] = r13
            int r4 = r3 + 1
            int r6 = 4 - r3
        L_0x0127:
            int r3 = r0.zzr
            if (r3 >= r8) goto L_0x018d
            int r3 = r0.zzs
            if (r3 != 0) goto L_0x0177
            r1.zzi(r2, r6, r4)
            int r3 = r0.zzq
            int r3 = r3 + r4
            r0.zzq = r3
            com.google.android.gms.internal.ads.zzed r3 = r0.zzd
            r3.zzL(r13)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzd
            int r3 = r3.zzg()
            if (r3 <= 0) goto L_0x016f
            int r3 = r3 + -1
            r0.zzs = r3
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            r3.zzL(r13)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            r7 = r16
            r14.zzq(r3, r7)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzd
            r14.zzq(r3, r12)
            int r3 = r0.zzr
            int r3 = r3 + 5
            r0.zzr = r3
            int r8 = r8 + r6
            boolean r3 = r0.zzt
            if (r3 != 0) goto L_0x018a
            byte r3 = r2[r7]
            boolean r3 = com.google.android.gms.internal.ads.zzfp.zzi(r3)
            if (r3 == 0) goto L_0x018a
            r0.zzt = r12
            goto L_0x018a
        L_0x016f:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r2)
            throw r1
        L_0x0177:
            int r3 = r14.zzf(r1, r3, r13)
            int r7 = r0.zzq
            int r7 = r7 + r3
            r0.zzq = r7
            int r7 = r0.zzr
            int r7 = r7 + r3
            r0.zzr = r7
            int r7 = r0.zzs
            int r7 = r7 - r3
            r0.zzs = r7
        L_0x018a:
            r16 = 4
            goto L_0x0127
        L_0x018d:
            r18 = r8
            goto L_0x01d2
        L_0x0190:
            com.google.android.gms.internal.ads.zzad r2 = r2.zzf
            java.lang.String r3 = "audio/ac4"
            java.lang.String r2 = r2.zzo
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x01b3
            int r2 = r0.zzr
            if (r2 != 0) goto L_0x01b0
            com.google.android.gms.internal.ads.zzed r2 = r0.zze
            com.google.android.gms.internal.ads.zzabu.zzb(r8, r2)
            com.google.android.gms.internal.ads.zzed r2 = r0.zze
            r3 = 7
            r14.zzq(r2, r3)
            int r2 = r0.zzr
            int r2 = r2 + r3
            r0.zzr = r2
        L_0x01b0:
            int r8 = r8 + 7
            goto L_0x01b8
        L_0x01b3:
            if (r9 == 0) goto L_0x01b8
            r9.zzd(r1)
        L_0x01b8:
            int r2 = r0.zzr
            if (r2 >= r8) goto L_0x018d
            int r2 = r8 - r2
            int r2 = r14.zzf(r1, r2, r13)
            int r3 = r0.zzq
            int r3 = r3 + r2
            r0.zzq = r3
            int r3 = r0.zzr
            int r3 = r3 + r2
            r0.zzr = r3
            int r3 = r0.zzs
            int r3 = r3 - r2
            r0.zzs = r3
            goto L_0x01b8
        L_0x01d2:
            com.google.android.gms.internal.ads.zzajh r1 = r5.zzb
            long[] r2 = r1.zzf
            r15 = r2[r23]
            int[] r1 = r1.zzg
            r1 = r1[r23]
            boolean r2 = r0.zzt
            if (r2 != 0) goto L_0x01e3
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 | r2
        L_0x01e3:
            r17 = r1
            if (r9 == 0) goto L_0x0205
            r20 = 0
            r21 = 0
            r19 = r18
            r18 = r17
            r16 = r15
            r15 = r14
            r14 = r9
            r14.zzc(r15, r16, r18, r19, r20, r21)
            r1 = r14
            r14 = r15
            int r7 = r23 + 1
            com.google.android.gms.internal.ads.zzajh r2 = r5.zzb
            int r2 = r2.zzb
            if (r7 != r2) goto L_0x020c
            r2 = 0
            r1.zza(r14, r2)
            goto L_0x020c
        L_0x0205:
            r19 = 0
            r20 = 0
            r14.zzs(r15, r17, r18, r19, r20)
        L_0x020c:
            int r1 = r5.zze
            int r1 = r1 + r12
            r5.zze = r1
            r1 = -1
            r0.zzp = r1
            r0.zzq = r13
            r0.zzr = r13
            r0.zzs = r13
            r0.zzt = r12
            return r13
        L_0x021d:
            r2.zza = r10
            return r12
        L_0x0220:
            r32 = r9
            r28 = 262144(0x40000, double:1.295163E-318)
            long r5 = r0.zzm
            int r3 = r0.zzn
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r1.zzf()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzed r3 = r0.zzo
            if (r3 == 0) goto L_0x0286
            byte[] r9 = r3.zzN()
            int r10 = r0.zzn
            int r5 = (int) r5
            r1.zzi(r9, r10, r5)
            int r5 = r0.zzl
            if (r5 != r4) goto L_0x026b
            r0.zzu = r12
            r3.zzL(r11)
            int r4 = r3.zzg()
            int r4 = zzj(r4)
            if (r4 == 0) goto L_0x0252
            goto L_0x0268
        L_0x0252:
            r4 = 4
            r3.zzM(r4)
        L_0x0256:
            int r4 = r3.zzb()
            if (r4 <= 0) goto L_0x0267
            int r4 = r3.zzg()
            int r4 = zzj(r4)
            if (r4 == 0) goto L_0x0256
            goto L_0x0268
        L_0x0267:
            r4 = r13
        L_0x0268:
            r0.zzA = r4
            goto L_0x02a4
        L_0x026b:
            java.util.ArrayDeque r4 = r0.zzg
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x02a4
            java.util.ArrayDeque r4 = r0.zzg
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzes r4 = (com.google.android.gms.internal.ads.zzes) r4
            com.google.android.gms.internal.ads.zzet r5 = new com.google.android.gms.internal.ads.zzet
            int r6 = r0.zzl
            r5.<init>(r6, r3)
            r4.zzd(r5)
            goto L_0x02a4
        L_0x0286:
            boolean r3 = r0.zzu
            if (r3 != 0) goto L_0x0293
            int r3 = r0.zzl
            r4 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r3 != r4) goto L_0x0293
            r0.zzA = r12
        L_0x0293:
            int r3 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r3 >= 0) goto L_0x029c
            int r3 = (int) r5
            r1.zzk(r3)
            goto L_0x02a4
        L_0x029c:
            long r3 = r1.zzf()
            long r3 = r3 + r5
            r2.zza = r3
            r13 = r12
        L_0x02a4:
            r0.zzn(r7)
            if (r13 == 0) goto L_0x0006
            int r3 = r0.zzk
            r5 = r32
            if (r3 == r5) goto L_0x0006
            return r12
        L_0x02b0:
            r30 = r7
            r5 = r9
            int r3 = r0.zzn
            if (r3 != 0) goto L_0x0321
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            byte[] r3 = r3.zzN()
            boolean r3 = r1.zzn(r3, r13, r11, r12)
            if (r3 != 0) goto L_0x030a
            int r1 = r0.zzA
            if (r1 != r5) goto L_0x0307
            int r1 = r0.zzb
            r1 = r1 & r5
            if (r1 == 0) goto L_0x0307
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzv
            r4 = 4
            com.google.android.gms.internal.ads.zzadx r1 = r1.zzw(r13, r4)
            com.google.android.gms.internal.ads.zzagz r2 = r0.zzB
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 != 0) goto L_0x02de
            r5 = 0
            goto L_0x02e7
        L_0x02de:
            com.google.android.gms.internal.ads.zzbd r5 = new com.google.android.gms.internal.ads.zzbd
            com.google.android.gms.internal.ads.zzbc[] r6 = new com.google.android.gms.internal.ads.zzbc[r12]
            r6[r13] = r2
            r5.<init>(r3, r6)
        L_0x02e7:
            com.google.android.gms.internal.ads.zzab r2 = new com.google.android.gms.internal.ads.zzab
            r2.<init>()
            r2.zzS(r5)
            com.google.android.gms.internal.ads.zzad r2 = r2.zzaf()
            r1.zzl(r2)
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzv
            r1.zzD()
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzv
            com.google.android.gms.internal.ads.zzadp r2 = new com.google.android.gms.internal.ads.zzadp
            r5 = r30
            r2.<init>(r3, r5)
            r1.zzO(r2)
        L_0x0307:
            r22 = -1
            return r22
        L_0x030a:
            r0.zzn = r11
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            r3.zzL(r13)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            long r5 = r3.zzu()
            r0.zzm = r5
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            int r3 = r3.zzg()
            r0.zzl = r3
        L_0x0321:
            long r5 = r0.zzm
            r7 = 1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0340
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            byte[] r3 = r3.zzN()
            r1.zzi(r3, r11, r11)
            int r3 = r0.zzn
            int r3 = r3 + r11
            r0.zzn = r3
            com.google.android.gms.internal.ads.zzed r3 = r0.zzf
            long r5 = r3.zzw()
            r0.zzm = r5
            goto L_0x036d
        L_0x0340:
            r30 = 0
            int r3 = (r5 > r30 ? 1 : (r5 == r30 ? 0 : -1))
            if (r3 != 0) goto L_0x036d
            long r5 = r1.zzd()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x035e
            java.util.ArrayDeque r3 = r0.zzg
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzes r3 = (com.google.android.gms.internal.ads.zzes) r3
            if (r3 == 0) goto L_0x035d
            long r5 = r3.zza
            goto L_0x035e
        L_0x035d:
            r5 = r7
        L_0x035e:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x036d
            long r7 = r1.zzf()
            long r5 = r5 - r7
            int r3 = r0.zzn
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzm = r5
        L_0x036d:
            long r5 = r0.zzm
            int r3 = r0.zzn
            long r7 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x04a8
            int r5 = r0.zzl
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x0457
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x0457
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x0457
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x0457
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x0457
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x0457
            if (r5 == r7) goto L_0x0457
            r6 = 1701082724(0x65647664, float:6.7430217E22)
            if (r5 != r6) goto L_0x03a2
            goto L_0x0457
        L_0x03a2:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x0425
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x0425
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x0425
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x0425
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x0425
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x0425
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x0425
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x0425
            if (r5 == r4) goto L_0x0425
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x0425
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x0425
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x03fa
            goto L_0x0425
        L_0x03fa:
            long r3 = r1.zzf()
            int r5 = r0.zzn
            long r5 = (long) r5
            long r16 = r3 - r5
            int r3 = r0.zzl
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x041e
            long r20 = r16 + r5
            com.google.android.gms.internal.ads.zzagz r13 = new com.google.android.gms.internal.ads.zzagz
            long r3 = r0.zzm
            long r22 = r3 - r5
            r14 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13.<init>(r14, r16, r18, r20, r22)
            r0.zzB = r13
        L_0x041e:
            r3 = 0
            r0.zzo = r3
            r0.zzk = r12
            goto L_0x0006
        L_0x0425:
            if (r3 != r11) goto L_0x0429
            r3 = r12
            goto L_0x042a
        L_0x0429:
            r3 = r13
        L_0x042a:
            com.google.android.gms.internal.ads.zzdb.zzf(r3)
            long r3 = r0.zzm
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0438
            r3 = r12
            goto L_0x0439
        L_0x0438:
            r3 = r13
        L_0x0439:
            com.google.android.gms.internal.ads.zzdb.zzf(r3)
            com.google.android.gms.internal.ads.zzed r3 = new com.google.android.gms.internal.ads.zzed
            long r4 = r0.zzm
            int r4 = (int) r4
            r3.<init>((int) r4)
            com.google.android.gms.internal.ads.zzed r4 = r0.zzf
            byte[] r4 = r4.zzN()
            byte[] r5 = r3.zzN()
            java.lang.System.arraycopy(r4, r13, r5, r13, r11)
            r0.zzo = r3
            r0.zzk = r12
            goto L_0x0006
        L_0x0457:
            long r3 = r1.zzf()
            long r5 = r0.zzm
            long r3 = r3 + r5
            int r8 = r0.zzn
            long r8 = (long) r8
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0488
            int r5 = r0.zzl
            if (r5 != r7) goto L_0x0488
            com.google.android.gms.internal.ads.zzed r5 = r0.zze
            r5.zzI(r11)
            com.google.android.gms.internal.ads.zzed r5 = r0.zze
            byte[] r5 = r5.zzN()
            r1.zzh(r5, r13, r11)
            com.google.android.gms.internal.ads.zzed r5 = r0.zze
            com.google.android.gms.internal.ads.zzain.zzg(r5)
            com.google.android.gms.internal.ads.zzed r5 = r0.zze
            int r5 = r5.zzd()
            r1.zzk(r5)
            r1.zzj()
        L_0x0488:
            long r3 = r3 - r8
            java.util.ArrayDeque r5 = r0.zzg
            com.google.android.gms.internal.ads.zzes r6 = new com.google.android.gms.internal.ads.zzes
            int r7 = r0.zzl
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzm
            int r7 = r0.zzn
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x04a3
            r0.zzn(r3)
            goto L_0x0006
        L_0x04a3:
            r0.zzm()
            goto L_0x0006
        L_0x04a8:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiy.zzb(com.google.android.gms.internal.ads.zzacs, com.google.android.gms.internal.ads.zzadn):int");
    }
}
