package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzahq implements zzacr {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzc = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] zzd = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final UUID zze = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map zzf;
    private long zzA;
    private zzaho zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    private zzdu zzJ;
    private zzdu zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzacu zzai;
    private final zzahl zzaj;
    private final zzahs zzg;
    private final SparseArray zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final zzakg zzk;
    private final zzed zzl;
    private final zzed zzm;
    private final zzed zzn;
    private final zzed zzo;
    private final zzed zzp;
    private final zzed zzq;
    private final zzed zzr;
    private final zzed zzs;
    private final zzed zzt;
    private final zzed zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzen.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public zzahq() {
        this(new zzahl(), 2, zzakg.zza);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzp(zzacs zzacs, zzaho zzaho, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzaho.zzb)) {
            zzx(zzacs, zza, i);
            int i3 = this.zzaa;
            zzw();
            return i3;
        } else if ("S_TEXT/ASS".equals(zzaho.zzb)) {
            zzx(zzacs, zzc, i);
            int i4 = this.zzaa;
            zzw();
            return i4;
        } else if ("S_TEXT/WEBVTT".equals(zzaho.zzb)) {
            zzx(zzacs, zzd, i);
            int i5 = this.zzaa;
            zzw();
            return i5;
        } else {
            zzadx zzadx = zzaho.zzW;
            boolean z2 = true;
            if (!this.zzac) {
                if (zzaho.zzg) {
                    this.zzV &= -1073741825;
                    int i6 = 128;
                    if (!this.zzad) {
                        zzacs.zzi(this.zzn.zzN(), 0, 1);
                        this.zzZ++;
                        if ((this.zzn.zzN()[0] & 128) != 128) {
                            this.zzag = this.zzn.zzN()[0];
                            this.zzad = true;
                        } else {
                            throw zzbh.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b = this.zzag;
                    if ((b & 1) == 1) {
                        byte b2 = b & 2;
                        this.zzV |= 1073741824;
                        if (!this.zzah) {
                            zzacs.zzi(this.zzs.zzN(), 0, 8);
                            this.zzZ += 8;
                            this.zzah = true;
                            zzed zzed = this.zzn;
                            if (b2 != 2) {
                                i6 = 0;
                            }
                            zzed.zzN()[0] = (byte) (i6 | 8);
                            this.zzn.zzL(0);
                            zzadx.zzr(this.zzn, 1, 1);
                            this.zzaa++;
                            this.zzs.zzL(0);
                            zzadx.zzr(this.zzs, 8, 1);
                            this.zzaa += 8;
                        }
                        if (b2 == 2) {
                            if (!this.zzae) {
                                zzacs.zzi(this.zzn.zzN(), 0, 1);
                                this.zzZ++;
                                this.zzn.zzL(0);
                                this.zzaf = this.zzn.zzm();
                                this.zzae = true;
                            }
                            int i7 = this.zzaf * 4;
                            this.zzn.zzI(i7);
                            zzacs.zzi(this.zzn.zzN(), 0, i7);
                            this.zzZ += i7;
                            int i8 = (this.zzaf >> 1) + 1;
                            int i9 = (i8 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzv;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.zzv = ByteBuffer.allocate(i9);
                            }
                            this.zzv.position(0);
                            this.zzv.putShort((short) i8);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i2 = this.zzaf;
                                if (i10 >= i2) {
                                    break;
                                }
                                int zzp2 = this.zzn.zzp();
                                int i12 = zzp2 - i11;
                                if (i10 % 2 == 0) {
                                    this.zzv.putShort((short) i12);
                                } else {
                                    this.zzv.putInt(i12);
                                }
                                i10++;
                                i11 = zzp2;
                            }
                            int i13 = (i - this.zzZ) - i11;
                            if ((i2 & 1) == 1) {
                                this.zzv.putInt(i13);
                            } else {
                                this.zzv.putShort((short) i13);
                                this.zzv.putInt(0);
                            }
                            this.zzt.zzJ(this.zzv.array(), i9);
                            zzadx.zzr(this.zzt, i9, 1);
                            this.zzaa += i9;
                        }
                    }
                } else {
                    byte[] bArr = zzaho.zzh;
                    if (bArr != null) {
                        this.zzq.zzJ(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzaho.zzb) ? zzaho.zzf > 0 : z) {
                    this.zzV |= 268435456;
                    this.zzu.zzI(0);
                    int zze2 = (this.zzq.zze() + i) - this.zzZ;
                    this.zzn.zzI(4);
                    this.zzn.zzN()[0] = (byte) ((zze2 >> 24) & 255);
                    this.zzn.zzN()[1] = (byte) ((zze2 >> 16) & 255);
                    this.zzn.zzN()[2] = (byte) ((zze2 >> 8) & 255);
                    this.zzn.zzN()[3] = (byte) (zze2 & 255);
                    zzadx.zzr(this.zzn, 4, 2);
                    this.zzaa += 4;
                }
                this.zzac = true;
            }
            int zze3 = i + this.zzq.zze();
            if (!"V_MPEG4/ISO/AVC".equals(zzaho.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzaho.zzb)) {
                if (zzaho.zzT != null) {
                    if (this.zzq.zze() != 0) {
                        z2 = false;
                    }
                    zzdb.zzf(z2);
                    zzaho.zzT.zzd(zzacs);
                }
                while (true) {
                    int i14 = this.zzZ;
                    if (i14 >= zze3) {
                        break;
                    }
                    int zzq2 = zzq(zzacs, zzadx, zze3 - i14);
                    this.zzZ += zzq2;
                    this.zzaa += zzq2;
                }
            } else {
                byte[] zzN2 = this.zzm.zzN();
                zzN2[0] = 0;
                zzN2[1] = 0;
                zzN2[2] = 0;
                int i15 = zzaho.zzX;
                int i16 = 4 - i15;
                while (this.zzZ < zze3) {
                    int i17 = this.zzab;
                    if (i17 == 0) {
                        int min = Math.min(i15, this.zzq.zzb());
                        zzacs.zzi(zzN2, i16 + min, i15 - min);
                        if (min > 0) {
                            this.zzq.zzH(zzN2, i16, min);
                        }
                        this.zzZ += i15;
                        this.zzm.zzL(0);
                        this.zzab = this.zzm.zzp();
                        this.zzl.zzL(0);
                        zzadx.zzq(this.zzl, 4);
                        this.zzaa += 4;
                    } else {
                        int zzq3 = zzq(zzacs, zzadx, i17);
                        this.zzZ += zzq3;
                        this.zzaa += zzq3;
                        this.zzab -= zzq3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzaho.zzb)) {
                this.zzo.zzL(0);
                zzadx.zzq(this.zzo, 4);
                this.zzaa += 4;
            }
            int i18 = this.zzaa;
            zzw();
            return i18;
        }
    }

    private final int zzq(zzacs zzacs, zzadx zzadx, int i) throws IOException {
        int zzb2 = this.zzq.zzb();
        if (zzb2 <= 0) {
            return zzadx.zzf(zzacs, i, false);
        }
        int min = Math.min(i, zzb2);
        zzadx.zzq(this.zzq, min);
        return min;
    }

    private final long zzr(long j) throws zzbh {
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return zzen.zzu(j, j2, 1000, RoundingMode.FLOOR);
        }
        throw zzbh.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzs(int i) throws zzbh {
        if (this.zzJ == null || this.zzK == null) {
            throw zzbh.zza("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzt(int i) throws zzbh {
        if (this.zzB == null) {
            throw zzbh.zza("Element " + i + " must be in a TrackEntry", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0 A[EDGE_INSN: B:59:0x00e0->B:48:0x00e0 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzu(com.google.android.gms.internal.ads.zzaho r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zzady r2 = r1.zzT
            r9 = 1
            if (r2 == 0) goto L_0x001c
            r3 = r2
            com.google.android.gms.internal.ads.zzadx r2 = r1.zzW
            com.google.android.gms.internal.ads.zzadw r8 = r1.zzi
            r5 = r21
            r6 = r22
            r7 = r23
            r1 = r3
            r3 = r19
            r1.zzc(r2, r3, r5, r6, r7, r8)
            goto L_0x0121
        L_0x001c:
            java.lang.String r2 = r1.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            java.lang.String r4 = "S_TEXT/WEBVTT"
            java.lang.String r5 = "S_TEXT/ASS"
            r6 = 0
            r7 = 2
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0058
        L_0x003c:
            int r2 = r0.zzR
            java.lang.String r8 = "MatroskaExtractor"
            if (r2 <= r9) goto L_0x0048
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r2)
            goto L_0x0058
        L_0x0048:
            long r10 = r0.zzP
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "Skipping subtitle sample with no duration."
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r2)
        L_0x0058:
            r2 = r22
            goto L_0x00f3
        L_0x005c:
            java.lang.String r2 = r1.zzb
            com.google.android.gms.internal.ads.zzed r8 = r0.zzr
            byte[] r8 = r8.zzN()
            int r12 = r2.hashCode()
            r13 = 738597099(0x2c0618eb, float:1.9056378E-12)
            if (r12 == r13) goto L_0x0088
            r5 = 1045209816(0x3e4ca2d8, float:0.19983995)
            if (r12 == r5) goto L_0x0080
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r12 == r4) goto L_0x0078
            goto L_0x0090
        L_0x0078:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0090
            r2 = r6
            goto L_0x0091
        L_0x0080:
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = r7
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0090
            r2 = r9
            goto L_0x0091
        L_0x0090:
            r2 = -1
        L_0x0091:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00b3
            if (r2 == r9) goto L_0x00a8
            if (r2 != r7) goto L_0x00a2
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = zzy(r10, r2, r3)
            r3 = 25
            goto L_0x00bb
        L_0x00a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x00a8:
            java.lang.String r2 = "%01d:%02d:%02d:%02d"
            r3 = 10000(0x2710, double:4.9407E-320)
            byte[] r2 = zzy(r10, r2, r3)
            r3 = 21
            goto L_0x00bb
        L_0x00b3:
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = zzy(r10, r2, r3)
            r3 = 19
        L_0x00bb:
            int r4 = r2.length
            java.lang.System.arraycopy(r2, r6, r8, r3, r4)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzr
            int r2 = r2.zzd()
        L_0x00c5:
            com.google.android.gms.internal.ads.zzed r3 = r0.zzr
            int r3 = r3.zze()
            if (r2 >= r3) goto L_0x00e0
            com.google.android.gms.internal.ads.zzed r3 = r0.zzr
            byte[] r3 = r3.zzN()
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzed r3 = r0.zzr
            r3.zzK(r2)
            goto L_0x00e0
        L_0x00dd:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00e0:
            com.google.android.gms.internal.ads.zzadx r2 = r1.zzW
            com.google.android.gms.internal.ads.zzed r3 = r0.zzr
            int r4 = r3.zze()
            r2.zzq(r3, r4)
            com.google.android.gms.internal.ads.zzed r2 = r0.zzr
            int r2 = r2.zze()
            int r2 = r22 + r2
        L_0x00f3:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x0111
            int r3 = r0.zzR
            if (r3 <= r9) goto L_0x0103
            com.google.android.gms.internal.ads.zzed r3 = r0.zzu
            r3.zzI(r6)
            goto L_0x0111
        L_0x0103:
            com.google.android.gms.internal.ads.zzed r3 = r0.zzu
            int r3 = r3.zze()
            com.google.android.gms.internal.ads.zzadx r4 = r1.zzW
            com.google.android.gms.internal.ads.zzed r5 = r0.zzu
            r4.zzr(r5, r3, r7)
            int r2 = r2 + r3
        L_0x0111:
            r14 = r2
            com.google.android.gms.internal.ads.zzadx r10 = r1.zzW
            com.google.android.gms.internal.ads.zzadw r1 = r1.zzi
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.zzs(r11, r13, r14, r15, r16)
        L_0x0121:
            r0.zzM = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahq.zzu(com.google.android.gms.internal.ads.zzaho, long, int, int, int):void");
    }

    private final void zzv(zzacs zzacs, int i) throws IOException {
        if (this.zzn.zze() < i) {
            if (this.zzn.zzc() < i) {
                zzed zzed = this.zzn;
                int zzc2 = zzed.zzc();
                zzed.zzF(Math.max(zzc2 + zzc2, i));
            }
            zzed zzed2 = this.zzn;
            zzacs.zzi(zzed2.zzN(), zzed2.zze(), i - zzed2.zze());
            this.zzn.zzK(i);
        }
    }

    private final void zzw() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = 0;
        this.zzah = false;
        this.zzq.zzI(0);
    }

    private final void zzx(zzacs zzacs, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzr.zzc() < i2) {
            zzed zzed = this.zzr;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzed.zzJ(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzN(), 0, length);
        }
        zzacs.zzi(this.zzr.zzN(), length, i);
        this.zzr.zzL(0);
        this.zzr.zzK(i2);
    }

    private static byte[] zzy(long j, String str, long j2) {
        zzdb.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer valueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer valueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / AnimationKt.MillisToNanos);
        String format = String.format(locale, str, new Object[]{valueOf, valueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * AnimationKt.MillisToNanos)) / j2))});
        int i4 = zzen.zza;
        return format.getBytes(StandardCharsets.UTF_8);
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (this.zzaj.zzc(zzacs)) {
                long zzf2 = zzacs.zzf();
                if (this.zzF) {
                    this.zzH = zzf2;
                    zzadn.zza = this.zzG;
                    this.zzF = false;
                    return 1;
                } else if (this.zzC) {
                    long j = this.zzH;
                    if (j != -1) {
                        zzadn.zza = j;
                        this.zzH = -1;
                        return 1;
                    }
                }
            } else {
                for (int i = 0; i < this.zzh.size(); i++) {
                    zzaho zzaho = (zzaho) this.zzh.valueAt(i);
                    zzaho.zzW.getClass();
                    zzady zzady = zzaho.zzT;
                    if (zzady != null) {
                        zzady.zza(zzaho.zzW, zzaho.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzai = zzacu;
        if (this.zzj) {
            zzacu = new zzakj(zzacu, this.zzk);
        }
        this.zzai = zzacu;
    }

    public final void zzf(long j, long j2) {
        this.zzI = -9223372036854775807L;
        this.zzN = 0;
        this.zzaj.zzb();
        this.zzg.zze();
        zzw();
        for (int i = 0; i < this.zzh.size(); i++) {
            zzady zzady = ((zzaho) this.zzh.valueAt(i)).zzT;
            if (zzady != null) {
                zzady.zzb();
            }
        }
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        return new zzahr().zza(zzacs);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f1, code lost:
        if (r6.equals("V_MPEGH/ISO/HEVC") != false) goto L_0x031f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r24) throws com.google.android.gms.internal.ads.zzbh {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzai
            com.google.android.gms.internal.ads.zzdb.zzb(r2)
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 8
            java.lang.String r4 = "A_OPUS"
            r5 = 2
            r6 = 0
            if (r1 == r2) goto L_0x033b
            r2 = 174(0xae, float:2.44E-43)
            r11 = 0
            if (r1 == r2) goto L_0x018e
            r2 = 19899(0x4dbb, float:2.7884E-41)
            r3 = -1
            r5 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r1 == r2) goto L_0x0174
            r2 = 25152(0x6240, float:3.5245E-41)
            if (r1 == r2) goto L_0x0142
            r2 = 28032(0x6d80, float:3.9281E-41)
            if (r1 == r2) goto L_0x012c
            r2 = 357149030(0x1549a966, float:4.072526E-26)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == r2) goto L_0x0114
            r2 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r1 == r2) goto L_0x00ff
            if (r1 == r5) goto L_0x003d
            goto L_0x03bb
        L_0x003d:
            boolean r1 = r0.zzC
            if (r1 != 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzai
            com.google.android.gms.internal.ads.zzdu r2 = r0.zzJ
            com.google.android.gms.internal.ads.zzdu r5 = r0.zzK
            long r14 = r0.zzx
            int r3 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00ed
            long r3 = r0.zzA
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x00ed
            if (r2 == 0) goto L_0x00ed
            int r3 = r2.zza()
            if (r3 == 0) goto L_0x00ed
            if (r5 == 0) goto L_0x00ed
            int r3 = r5.zza()
            int r4 = r2.zza()
            if (r3 == r4) goto L_0x0069
            goto L_0x00ed
        L_0x0069:
            int r3 = r2.zza()
            int[] r4 = new int[r3]
            long[] r12 = new long[r3]
            long[] r13 = new long[r3]
            long[] r14 = new long[r3]
            r15 = 0
        L_0x0076:
            if (r15 >= r3) goto L_0x008f
            long r16 = r2.zzb(r15)
            r14[r15] = r16
            r16 = 0
            r17 = -1
            long r9 = r0.zzx
            long r18 = r5.zzb(r15)
            long r9 = r9 + r18
            r12[r15] = r9
            int r15 = r15 + 1
            goto L_0x0076
        L_0x008f:
            r16 = 0
            r17 = -1
            r9 = r16
        L_0x0095:
            int r10 = r3 + -1
            if (r9 >= r10) goto L_0x00ae
            int r2 = r9 + 1
            r15 = r12[r2]
            r18 = r12[r9]
            r5 = r9
            long r8 = r15 - r18
            int r8 = (int) r8
            r4[r5] = r8
            r8 = r14[r2]
            r15 = r14[r5]
            long r8 = r8 - r15
            r13[r5] = r8
            r9 = r2
            goto L_0x0095
        L_0x00ae:
            long r2 = r0.zzx
            long r8 = r0.zzw
            long r2 = r2 + r8
            r8 = r12[r10]
            long r2 = r2 - r8
            int r2 = (int) r2
            r4[r10] = r2
            long r2 = r0.zzA
            r8 = r14[r10]
            long r2 = r2 - r8
            r13[r10] = r2
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x00e7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Discarding last cue point with unexpected duration: "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r3 = "MatroskaExtractor"
            com.google.android.gms.internal.ads.zzdt.zzf(r3, r2)
            int[] r4 = java.util.Arrays.copyOf(r4, r10)
            long[] r12 = java.util.Arrays.copyOf(r12, r10)
            long[] r13 = java.util.Arrays.copyOf(r13, r10)
            long[] r14 = java.util.Arrays.copyOf(r14, r10)
        L_0x00e7:
            com.google.android.gms.internal.ads.zzace r2 = new com.google.android.gms.internal.ads.zzace
            r2.<init>(r4, r12, r13, r14)
            goto L_0x00f4
        L_0x00ed:
            com.google.android.gms.internal.ads.zzadp r2 = new com.google.android.gms.internal.ads.zzadp
            long r3 = r0.zzA
            r2.<init>(r3, r6)
        L_0x00f4:
            r1.zzO(r2)
            r1 = 1
            r0.zzC = r1
        L_0x00fa:
            r0.zzJ = r11
            r0.zzK = r11
            return
        L_0x00ff:
            android.util.SparseArray r1 = r0.zzh
            int r1 = r1.size()
            if (r1 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzacu r1 = r0.zzai
            r1.zzD()
            return
        L_0x010d:
            java.lang.String r1 = "No valid tracks were found"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r11)
            throw r1
        L_0x0114:
            long r1 = r0.zzy
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x011f
            r1 = 1000000(0xf4240, double:4.940656E-318)
            r0.zzy = r1
        L_0x011f:
            long r1 = r0.zzz
            int r3 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x03bb
            long r1 = r0.zzr(r1)
            r0.zzA = r1
            return
        L_0x012c:
            r23.zzt(r24)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            boolean r2 = r1.zzg
            if (r2 == 0) goto L_0x03bb
            byte[] r1 = r1.zzh
            if (r1 != 0) goto L_0x013b
            goto L_0x03bb
        L_0x013b:
            java.lang.String r1 = "Combining encryption and compression is not supported"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r11)
            throw r1
        L_0x0142:
            r16 = 0
            r23.zzt(r24)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            boolean r2 = r1.zzg
            if (r2 == 0) goto L_0x03bb
            com.google.android.gms.internal.ads.zzadw r2 = r1.zzi
            if (r2 == 0) goto L_0x016d
            com.google.android.gms.internal.ads.zzw r2 = new com.google.android.gms.internal.ads.zzw
            r3 = 1
            com.google.android.gms.internal.ads.zzv[] r3 = new com.google.android.gms.internal.ads.zzv[r3]
            com.google.android.gms.internal.ads.zzv r4 = new com.google.android.gms.internal.ads.zzv
            java.util.UUID r5 = com.google.android.gms.internal.ads.zzj.zza
            com.google.android.gms.internal.ads.zzaho r6 = r0.zzB
            com.google.android.gms.internal.ads.zzadw r6 = r6.zzi
            byte[] r6 = r6.zzb
            java.lang.String r7 = "video/webm"
            r4.<init>(r5, r11, r7, r6)
            r3[r16] = r4
            r2.<init>(r11, r3)
            r1.zzk = r2
            return
        L_0x016d:
            java.lang.String r1 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r11)
            throw r1
        L_0x0174:
            r17 = -1
            int r1 = r0.zzD
            r2 = r17
            if (r1 == r2) goto L_0x0187
            long r6 = r0.zzE
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0187
            if (r1 != r5) goto L_0x03bb
            r0.zzG = r6
            return
        L_0x0187:
            java.lang.String r1 = "Mandatory element SeekID or SeekPosition not found"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r11)
            throw r1
        L_0x018e:
            r2 = -1
            r16 = 0
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            com.google.android.gms.internal.ads.zzdb.zzb(r1)
            r6 = r1
            com.google.android.gms.internal.ads.zzaho r6 = (com.google.android.gms.internal.ads.zzaho) r6
            java.lang.String r6 = r1.zzb
            if (r6 == 0) goto L_0x0334
            int r7 = r6.hashCode()
            switch(r7) {
                case -2095576542: goto L_0x0314;
                case -2095575984: goto L_0x030a;
                case -1985379776: goto L_0x02ff;
                case -1784763192: goto L_0x02f4;
                case -1730367663: goto L_0x02e9;
                case -1482641358: goto L_0x02de;
                case -1482641357: goto L_0x02d3;
                case -1373388978: goto L_0x02c8;
                case -933872740: goto L_0x02bd;
                case -538363189: goto L_0x02b2;
                case -538363109: goto L_0x02a7;
                case -425012669: goto L_0x029b;
                case -356037306: goto L_0x028f;
                case 62923557: goto L_0x0283;
                case 62923603: goto L_0x0277;
                case 62927045: goto L_0x026b;
                case 82318131: goto L_0x0260;
                case 82338133: goto L_0x0254;
                case 82338134: goto L_0x0249;
                case 99146302: goto L_0x023d;
                case 444813526: goto L_0x0231;
                case 542569478: goto L_0x0225;
                case 635596514: goto L_0x0219;
                case 725948237: goto L_0x020d;
                case 725957860: goto L_0x0201;
                case 738597099: goto L_0x01f5;
                case 855502857: goto L_0x01eb;
                case 1045209816: goto L_0x01df;
                case 1422270023: goto L_0x01d3;
                case 1809237540: goto L_0x01c8;
                case 1950749482: goto L_0x01bc;
                case 1950789798: goto L_0x01b0;
                case 1951062397: goto L_0x01a6;
                default: goto L_0x01a4;
            }
        L_0x01a4:
            goto L_0x031e
        L_0x01a6:
            boolean r3 = r6.equals(r4)
            if (r3 == 0) goto L_0x031e
            r3 = 11
            goto L_0x031f
        L_0x01b0:
            java.lang.String r3 = "A_FLAC"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 22
            goto L_0x031f
        L_0x01bc:
            java.lang.String r3 = "A_EAC3"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 17
            goto L_0x031f
        L_0x01c8:
            java.lang.String r3 = "V_MPEG2"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 3
            goto L_0x031f
        L_0x01d3:
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 27
            goto L_0x031f
        L_0x01df:
            java.lang.String r3 = "S_TEXT/WEBVTT"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 29
            goto L_0x031f
        L_0x01eb:
            java.lang.String r4 = "V_MPEGH/ISO/HEVC"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x031e
            goto L_0x031f
        L_0x01f5:
            java.lang.String r3 = "S_TEXT/ASS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 28
            goto L_0x031f
        L_0x0201:
            java.lang.String r3 = "A_PCM/INT/LIT"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 24
            goto L_0x031f
        L_0x020d:
            java.lang.String r3 = "A_PCM/INT/BIG"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 25
            goto L_0x031f
        L_0x0219:
            java.lang.String r3 = "A_PCM/FLOAT/IEEE"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 26
            goto L_0x031f
        L_0x0225:
            java.lang.String r3 = "A_DTS/EXPRESS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 20
            goto L_0x031f
        L_0x0231:
            java.lang.String r3 = "V_THEORA"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 10
            goto L_0x031f
        L_0x023d:
            java.lang.String r3 = "S_HDMV/PGS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 31
            goto L_0x031f
        L_0x0249:
            java.lang.String r3 = "V_VP9"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 1
            goto L_0x031f
        L_0x0254:
            java.lang.String r3 = "V_VP8"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = r16
            goto L_0x031f
        L_0x0260:
            java.lang.String r3 = "V_AV1"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = r5
            goto L_0x031f
        L_0x026b:
            java.lang.String r3 = "A_DTS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 19
            goto L_0x031f
        L_0x0277:
            java.lang.String r3 = "A_AC3"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 16
            goto L_0x031f
        L_0x0283:
            java.lang.String r3 = "A_AAC"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 13
            goto L_0x031f
        L_0x028f:
            java.lang.String r3 = "A_DTS/LOSSLESS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 21
            goto L_0x031f
        L_0x029b:
            java.lang.String r3 = "S_VOBSUB"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 30
            goto L_0x031f
        L_0x02a7:
            java.lang.String r3 = "V_MPEG4/ISO/AVC"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 7
            goto L_0x031f
        L_0x02b2:
            java.lang.String r3 = "V_MPEG4/ISO/ASP"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 5
            goto L_0x031f
        L_0x02bd:
            java.lang.String r3 = "S_DVBSUB"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 32
            goto L_0x031f
        L_0x02c8:
            java.lang.String r3 = "V_MS/VFW/FOURCC"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 9
            goto L_0x031f
        L_0x02d3:
            java.lang.String r3 = "A_MPEG/L3"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 15
            goto L_0x031f
        L_0x02de:
            java.lang.String r3 = "A_MPEG/L2"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 14
            goto L_0x031f
        L_0x02e9:
            java.lang.String r3 = "A_VORBIS"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 12
            goto L_0x031f
        L_0x02f4:
            java.lang.String r3 = "A_TRUEHD"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 18
            goto L_0x031f
        L_0x02ff:
            java.lang.String r3 = "A_MS/ACM"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 23
            goto L_0x031f
        L_0x030a:
            java.lang.String r3 = "V_MPEG4/ISO/SP"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 4
            goto L_0x031f
        L_0x0314:
            java.lang.String r3 = "V_MPEG4/ISO/AP"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x031e
            r3 = 6
            goto L_0x031f
        L_0x031e:
            r3 = r2
        L_0x031f:
            switch(r3) {
                case 0: goto L_0x0323;
                case 1: goto L_0x0323;
                case 2: goto L_0x0323;
                case 3: goto L_0x0323;
                case 4: goto L_0x0323;
                case 5: goto L_0x0323;
                case 6: goto L_0x0323;
                case 7: goto L_0x0323;
                case 8: goto L_0x0323;
                case 9: goto L_0x0323;
                case 10: goto L_0x0323;
                case 11: goto L_0x0323;
                case 12: goto L_0x0323;
                case 13: goto L_0x0323;
                case 14: goto L_0x0323;
                case 15: goto L_0x0323;
                case 16: goto L_0x0323;
                case 17: goto L_0x0323;
                case 18: goto L_0x0323;
                case 19: goto L_0x0323;
                case 20: goto L_0x0323;
                case 21: goto L_0x0323;
                case 22: goto L_0x0323;
                case 23: goto L_0x0323;
                case 24: goto L_0x0323;
                case 25: goto L_0x0323;
                case 26: goto L_0x0323;
                case 27: goto L_0x0323;
                case 28: goto L_0x0323;
                case 29: goto L_0x0323;
                case 30: goto L_0x0323;
                case 31: goto L_0x0323;
                case 32: goto L_0x0323;
                default: goto L_0x0322;
            }
        L_0x0322:
            goto L_0x0331
        L_0x0323:
            com.google.android.gms.internal.ads.zzacu r2 = r0.zzai
            int r3 = r1.zzc
            r1.zze(r2, r3)
            android.util.SparseArray r2 = r0.zzh
            int r3 = r1.zzc
            r2.put(r3, r1)
        L_0x0331:
            r0.zzB = r11
            return
        L_0x0334:
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r11)
            throw r1
        L_0x033b:
            r16 = 0
            int r1 = r0.zzN
            if (r1 != r5) goto L_0x03bb
            android.util.SparseArray r1 = r0.zzh
            int r2 = r0.zzT
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.ads.zzaho r1 = (com.google.android.gms.internal.ads.zzaho) r1
            r1.zzW.getClass()
            long r8 = r0.zzY
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0376
            java.lang.String r2 = r1.zzb
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0376
            com.google.android.gms.internal.ads.zzed r2 = r0.zzu
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r3 = r3.order(r4)
            long r4 = r0.zzY
            java.nio.ByteBuffer r3 = r3.putLong(r4)
            byte[] r3 = r3.array()
            int r4 = r3.length
            r2.zzJ(r3, r4)
        L_0x0376:
            r2 = r16
            r3 = r2
        L_0x0379:
            int r4 = r0.zzR
            if (r2 >= r4) goto L_0x0385
            int[] r4 = r0.zzS
            r4 = r4[r2]
            int r3 = r3 + r4
            int r2 = r2 + 1
            goto L_0x0379
        L_0x0385:
            r2 = r16
        L_0x0387:
            int r4 = r0.zzR
            if (r2 >= r4) goto L_0x03b7
            long r4 = r0.zzO
            int r6 = r1.zze
            int r6 = r6 * r2
            int r6 = r6 / 1000
            long r6 = (long) r6
            long r4 = r4 + r6
            int r6 = r0.zzV
            if (r2 != 0) goto L_0x03a1
            boolean r2 = r0.zzX
            if (r2 != 0) goto L_0x039e
            r6 = r6 | 1
        L_0x039e:
            r7 = r16
            goto L_0x03a2
        L_0x03a1:
            r7 = r2
        L_0x03a2:
            int[] r2 = r0.zzS
            r2 = r2[r7]
            int r3 = r3 - r2
            r21 = r4
            r5 = r2
            r4 = r6
            r6 = r3
            r2 = r21
            r0.zzu(r1, r2, r4, r5, r6)
            r20 = 1
            int r2 = r7 + 1
            r3 = r6
            goto L_0x0387
        L_0x03b7:
            r2 = r16
            r0.zzN = r2
        L_0x03bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahq.zzj(int):void");
    }

    /* access modifiers changed from: protected */
    public final void zzm(int i, long j, long j2) throws zzbh {
        zzdb.zzb(this.zzai);
        if (i == 160) {
            this.zzX = false;
            this.zzY = 0;
        } else if (i == 174) {
            this.zzB = new zzaho();
        } else if (i == 187) {
            this.zzL = false;
        } else if (i == 19899) {
            this.zzD = -1;
            this.zzE = -1;
        } else if (i == 20533) {
            zzt(i);
            this.zzB.zzg = true;
        } else if (i == 21968) {
            zzt(i);
            this.zzB.zzx = true;
        } else if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 == -1 || j3 == j) {
                this.zzx = j;
                this.zzw = j2;
                return;
            }
            throw zzbh.zza("Multiple Segment elements not supported", (Throwable) null);
        } else if (i == 475249515) {
            this.zzJ = new zzdu(32);
            this.zzK = new zzdu(32);
        } else if (i != 524531317 || this.zzC) {
        } else {
            if (!this.zzi || this.zzG == -1) {
                this.zzai.zzO(new zzadp(this.zzA, 0));
                this.zzC = true;
                return;
            }
            this.zzF = true;
        }
    }

    zzahq(zzahl zzahl, int i, zzakg zzakg) {
        this.zzx = -1;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzG = -1;
        this.zzH = -1;
        this.zzI = -9223372036854775807L;
        this.zzaj = zzahl;
        zzahl.zza(new zzahn(this, (zzahp) null));
        this.zzk = zzakg;
        boolean z = false;
        this.zzi = 1 == ((i & 1) ^ 1);
        this.zzj = (i & 2) == 0 ? true : z;
        this.zzg = new zzahs();
        this.zzh = new SparseArray();
        this.zzn = new zzed(4);
        this.zzo = new zzed(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzed(4);
        this.zzl = new zzed(zzfp.zza);
        this.zzm = new zzed(4);
        this.zzq = new zzed();
        this.zzr = new zzed();
        this.zzs = new zzed(8);
        this.zzt = new zzed();
        this.zzu = new zzed();
        this.zzS = new int[1];
    }

    /* access modifiers changed from: protected */
    public final void zzn(int i, String str) throws zzbh {
        if (i == 134) {
            zzt(i);
            this.zzB.zzb = str;
        } else if (i != 17026) {
            if (i == 21358) {
                zzt(i);
                this.zzB.zza = str;
            } else if (i == 2274716) {
                zzt(i);
                this.zzB.zzZ = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw zzbh.zza("DocType " + str + " not supported", (Throwable) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: int} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r25, int r26, com.google.android.gms.internal.ads.zzacs r27) throws java.io.IOException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r7 = r27
            r3 = 161(0xa1, float:2.26E-43)
            r4 = 0
            r5 = 4
            r6 = 163(0xa3, float:2.28E-43)
            r8 = 2
            r9 = 1
            r10 = 0
            if (r1 == r3) goto L_0x00fd
            if (r1 == r6) goto L_0x00fd
            r3 = 165(0xa5, float:2.31E-43)
            if (r1 == r3) goto L_0x00cc
            r3 = 16877(0x41ed, float:2.365E-41)
            if (r1 == r3) goto L_0x00a6
            r3 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r3) goto L_0x0097
            r3 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r3) goto L_0x0085
            r3 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r3) goto L_0x0062
            r3 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r3) goto L_0x0053
            r3 = 30322(0x7672, float:4.249E-41)
            if (r1 != r3) goto L_0x0040
            r24.zzt(r25)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            byte[] r3 = new byte[r2]
            r1.zzv = r3
            byte[] r1 = r1.zzv
            r7.zzi(r1, r10, r2)
            return
        L_0x0040:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected id: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r4)
            throw r1
        L_0x0053:
            r24.zzt(r25)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            byte[] r3 = new byte[r2]
            r1.zzj = r3
            byte[] r1 = r1.zzj
            r7.zzi(r1, r10, r2)
            return
        L_0x0062:
            com.google.android.gms.internal.ads.zzed r1 = r0.zzp
            byte[] r1 = r1.zzN()
            java.util.Arrays.fill(r1, r10)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzp
            int r3 = 4 - r2
            byte[] r1 = r1.zzN()
            r7.zzi(r1, r3, r2)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzp
            r1.zzL(r10)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzp
            long r1 = r1.zzu()
            int r1 = (int) r1
            r0.zzD = r1
            return
        L_0x0085:
            byte[] r3 = new byte[r2]
            r7.zzi(r3, r10, r2)
            r24.zzt(r25)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            com.google.android.gms.internal.ads.zzadw r2 = new com.google.android.gms.internal.ads.zzadw
            r2.<init>(r9, r3, r10, r10)
            r1.zzi = r2
            return
        L_0x0097:
            r24.zzt(r25)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            byte[] r3 = new byte[r2]
            r1.zzh = r3
            byte[] r1 = r1.zzh
            r7.zzi(r1, r10, r2)
            return
        L_0x00a6:
            r24.zzt(r25)
            com.google.android.gms.internal.ads.zzaho r1 = r0.zzB
            int r3 = r1.zzY
            r4 = 1685485123(0x64767643, float:1.8185683E22)
            if (r3 == r4) goto L_0x00c2
            int r3 = r1.zzY
            r4 = 1685480259(0x64766343, float:1.8180206E22)
            if (r3 != r4) goto L_0x00be
            goto L_0x00c2
        L_0x00be:
            r7.zzk(r2)
            return
        L_0x00c2:
            byte[] r3 = new byte[r2]
            r1.zzN = r3
            byte[] r1 = r1.zzN
            r7.zzi(r1, r10, r2)
            return
        L_0x00cc:
            int r1 = r0.zzN
            if (r1 == r8) goto L_0x00d2
            goto L_0x032d
        L_0x00d2:
            android.util.SparseArray r1 = r0.zzh
            int r3 = r0.zzT
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.ads.zzaho r1 = (com.google.android.gms.internal.ads.zzaho) r1
            int r3 = r0.zzW
            if (r3 != r5) goto L_0x00f9
            java.lang.String r1 = r1.zzb
            java.lang.String r3 = "V_VP9"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00f9
            com.google.android.gms.internal.ads.zzed r1 = r0.zzu
            r1.zzI(r2)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzu
            byte[] r1 = r1.zzN()
            r7.zzi(r1, r10, r2)
            return
        L_0x00f9:
            r7.zzk(r2)
            return
        L_0x00fd:
            int r3 = r0.zzN
            r11 = 8
            if (r3 != 0) goto L_0x0122
            com.google.android.gms.internal.ads.zzahs r3 = r0.zzg
            long r12 = r3.zzd(r7, r10, r9, r11)
            int r3 = (int) r12
            r0.zzT = r3
            com.google.android.gms.internal.ads.zzahs r3 = r0.zzg
            int r3 = r3.zza()
            r0.zzU = r3
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzP = r12
            r0.zzN = r9
            com.google.android.gms.internal.ads.zzed r3 = r0.zzn
            r3.zzI(r10)
        L_0x0122:
            android.util.SparseArray r3 = r0.zzh
            int r12 = r0.zzT
            java.lang.Object r3 = r3.get(r12)
            com.google.android.gms.internal.ads.zzaho r3 = (com.google.android.gms.internal.ads.zzaho) r3
            if (r3 != 0) goto L_0x0138
            int r1 = r0.zzU
            int r1 = r2 - r1
            r7.zzk(r1)
            r0.zzN = r10
            return
        L_0x0138:
            r3.zzW.getClass()
            int r12 = r0.zzN
            if (r12 != r9) goto L_0x02de
            r12 = 3
            r0.zzv(r7, r12)
            com.google.android.gms.internal.ads.zzed r13 = r0.zzn
            byte[] r13 = r13.zzN()
            byte r13 = r13[r8]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x016b
            r0.zzR = r9
            int[] r4 = r0.zzS
            int[] r4 = zzz(r4, r9)
            r0.zzS = r4
            int r5 = r0.zzU
            int r2 = r2 - r5
            int r2 = r2 + -3
            r4[r10] = r2
        L_0x0163:
            r16 = r9
            r17 = r10
            r18 = r11
            goto L_0x028c
        L_0x016b:
            r0.zzv(r7, r5)
            com.google.android.gms.internal.ads.zzed r15 = r0.zzn
            byte[] r15 = r15.zzN()
            byte r15 = r15[r12]
            r15 = r15 & r14
            int r15 = r15 + r9
            r0.zzR = r15
            int[] r5 = r0.zzS
            int[] r5 = zzz(r5, r15)
            r0.zzS = r5
            if (r13 != r8) goto L_0x0190
            int r4 = r0.zzU
            int r2 = r2 - r4
            int r2 = r2 + -4
            int r4 = r0.zzR
            int r2 = r2 / r4
            java.util.Arrays.fill(r5, r10, r4, r2)
            goto L_0x0163
        L_0x0190:
            if (r13 != r9) goto L_0x01c9
            r4 = r10
            r12 = r4
            r5 = 4
        L_0x0195:
            int r13 = r0.zzR
            int r13 = r13 + -1
            if (r4 >= r13) goto L_0x01bf
            int[] r13 = r0.zzS
            r13[r4] = r10
        L_0x019f:
            int r13 = r5 + 1
            r0.zzv(r7, r13)
            com.google.android.gms.internal.ads.zzed r15 = r0.zzn
            byte[] r15 = r15.zzN()
            byte r5 = r15[r5]
            r5 = r5 & r14
            int[] r15 = r0.zzS
            r16 = r15[r4]
            int r16 = r16 + r5
            r15[r4] = r16
            if (r5 == r14) goto L_0x01bd
            int r12 = r12 + r16
            int r4 = r4 + 1
            r5 = r13
            goto L_0x0195
        L_0x01bd:
            r5 = r13
            goto L_0x019f
        L_0x01bf:
            int[] r4 = r0.zzS
            int r15 = r0.zzU
            int r2 = r2 - r15
            int r2 = r2 - r5
            int r2 = r2 - r12
            r4[r13] = r2
            goto L_0x0163
        L_0x01c9:
            if (r13 != r12) goto L_0x02d7
            r12 = r10
            r13 = r12
            r5 = 4
        L_0x01ce:
            int r15 = r0.zzR
            int r15 = r15 + -1
            if (r12 >= r15) goto L_0x027d
            int[] r15 = r0.zzS
            r15[r12] = r10
            int r15 = r5 + 1
            r0.zzv(r7, r15)
            r16 = r9
            com.google.android.gms.internal.ads.zzed r9 = r0.zzn
            byte[] r9 = r9.zzN()
            byte r9 = r9[r5]
            if (r9 == 0) goto L_0x0276
            r9 = r10
        L_0x01ea:
            if (r9 >= r11) goto L_0x0241
            int r17 = 7 - r9
            r18 = r11
            int r11 = r16 << r17
            r17 = r10
            com.google.android.gms.internal.ads.zzed r10 = r0.zzn
            byte[] r10 = r10.zzN()
            byte r10 = r10[r5]
            r10 = r10 & r11
            if (r10 == 0) goto L_0x0238
            int r15 = r15 + r9
            r0.zzv(r7, r15)
            com.google.android.gms.internal.ads.zzed r10 = r0.zzn
            int r19 = r5 + 1
            byte[] r10 = r10.zzN()
            byte r5 = r10[r5]
            r5 = r5 & r14
            int r10 = ~r11
            r5 = r5 & r10
            long r10 = (long) r5
            r5 = r19
        L_0x0213:
            if (r5 >= r15) goto L_0x0229
            long r10 = r10 << r18
            com.google.android.gms.internal.ads.zzed r6 = r0.zzn
            int r20 = r5 + 1
            byte[] r6 = r6.zzN()
            byte r5 = r6[r5]
            r5 = r5 & r14
            long r5 = (long) r5
            long r10 = r10 | r5
            r5 = r20
            r6 = 163(0xa3, float:2.28E-43)
            goto L_0x0213
        L_0x0229:
            if (r12 <= 0) goto L_0x0247
            int r9 = r9 * 7
            int r9 = r9 + 6
            r5 = 1
            long r5 = r5 << r9
            r20 = -1
            long r5 = r5 + r20
            long r10 = r10 - r5
            goto L_0x0247
        L_0x0238:
            int r9 = r9 + 1
            r10 = r17
            r11 = r18
            r6 = 163(0xa3, float:2.28E-43)
            goto L_0x01ea
        L_0x0241:
            r17 = r10
            r18 = r11
            r10 = 0
        L_0x0247:
            r5 = r15
            r20 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r6 < 0) goto L_0x026f
            r20 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r6 > 0) goto L_0x026f
            int[] r6 = r0.zzS
            int r9 = (int) r10
            if (r12 == 0) goto L_0x0260
            int r10 = r12 + -1
            r10 = r6[r10]
            int r9 = r9 + r10
        L_0x0260:
            r6[r12] = r9
            int r13 = r13 + r9
            int r12 = r12 + 1
            r9 = r16
            r10 = r17
            r11 = r18
            r6 = 163(0xa3, float:2.28E-43)
            goto L_0x01ce
        L_0x026f:
            java.lang.String r1 = "EBML lacing sample size out of range."
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r4)
            throw r1
        L_0x0276:
            java.lang.String r1 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r4)
            throw r1
        L_0x027d:
            r16 = r9
            r17 = r10
            r18 = r11
            int[] r4 = r0.zzS
            int r6 = r0.zzU
            int r2 = r2 - r6
            int r2 = r2 - r5
            int r2 = r2 - r13
            r4[r15] = r2
        L_0x028c:
            com.google.android.gms.internal.ads.zzed r2 = r0.zzn
            byte[] r2 = r2.zzN()
            byte r2 = r2[r17]
            int r2 = r2 << 8
            com.google.android.gms.internal.ads.zzed r4 = r0.zzn
            byte[] r4 = r4.zzN()
            byte r4 = r4[r16]
            r4 = r4 & r14
            long r5 = r0.zzI
            r2 = r2 | r4
            long r9 = (long) r2
            long r9 = r0.zzr(r9)
            long r5 = r5 + r9
            r0.zzO = r5
            int r2 = r3.zzd
            if (r2 == r8) goto L_0x02ca
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02c7
            com.google.android.gms.internal.ads.zzed r1 = r0.zzn
            byte[] r1 = r1.zzN()
            byte r1 = r1[r8]
            r2 = 128(0x80, float:1.794E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x02c2
            r2 = r16
            goto L_0x02c4
        L_0x02c2:
            r2 = r17
        L_0x02c4:
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x02cc
        L_0x02c7:
            r2 = r17
            goto L_0x02cc
        L_0x02ca:
            r2 = r16
        L_0x02cc:
            r0.zzV = r2
            r0.zzN = r8
            r2 = r17
            r0.zzQ = r2
            r2 = 163(0xa3, float:2.28E-43)
            goto L_0x02e1
        L_0x02d7:
            java.lang.String r1 = "Unexpected lacing value: 2"
            com.google.android.gms.internal.ads.zzbh r1 = com.google.android.gms.internal.ads.zzbh.zza(r1, r4)
            throw r1
        L_0x02de:
            r16 = r9
            r2 = r6
        L_0x02e1:
            if (r1 != r2) goto L_0x0314
        L_0x02e3:
            int r1 = r0.zzQ
            int r2 = r0.zzR
            if (r1 >= r2) goto L_0x0310
            int[] r2 = r0.zzS
            r1 = r2[r1]
            r2 = 0
            int r5 = r0.zzp(r7, r3, r1, r2)
            long r1 = r0.zzO
            int r4 = r0.zzQ
            int r6 = r3.zze
            int r4 = r4 * r6
            int r4 = r4 / 1000
            long r8 = (long) r4
            long r1 = r1 + r8
            int r4 = r0.zzV
            r6 = 0
            r22 = r1
            r1 = r3
            r2 = r22
            r0.zzu(r1, r2, r4, r5, r6)
            int r2 = r0.zzQ
            int r2 = r2 + 1
            r0.zzQ = r2
            r3 = r1
            goto L_0x02e3
        L_0x0310:
            r2 = 0
            r0.zzN = r2
            return
        L_0x0314:
            r1 = r3
        L_0x0315:
            int r2 = r0.zzQ
            int r3 = r0.zzR
            if (r2 >= r3) goto L_0x032d
            int[] r3 = r0.zzS
            r4 = r3[r2]
            r5 = r16
            int r4 = r0.zzp(r7, r1, r4, r5)
            r3[r2] = r4
            int r2 = r0.zzQ
            int r2 = r2 + r5
            r0.zzQ = r2
            goto L_0x0315
        L_0x032d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahq.zzh(int, int, com.google.android.gms.internal.ads.zzacs):void");
    }

    public zzahq(zzakg zzakg, int i) {
        this(new zzahl(), 0, zzakg);
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i, double d) throws zzbh {
        if (i == 181) {
            zzt(i);
            this.zzB.zzQ = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    zzt(i);
                    this.zzB.zzD = (float) d;
                    return;
                case 21970:
                    zzt(i);
                    this.zzB.zzE = (float) d;
                    return;
                case 21971:
                    zzt(i);
                    this.zzB.zzF = (float) d;
                    return;
                case 21972:
                    zzt(i);
                    this.zzB.zzG = (float) d;
                    return;
                case 21973:
                    zzt(i);
                    this.zzB.zzH = (float) d;
                    return;
                case 21974:
                    zzt(i);
                    this.zzB.zzI = (float) d;
                    return;
                case 21975:
                    zzt(i);
                    this.zzB.zzJ = (float) d;
                    return;
                case 21976:
                    zzt(i);
                    this.zzB.zzK = (float) d;
                    return;
                case 21977:
                    zzt(i);
                    this.zzB.zzL = (float) d;
                    return;
                case 21978:
                    zzt(i);
                    this.zzB.zzM = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            zzt(i);
                            this.zzB.zzs = (float) d;
                            return;
                        case 30324:
                            zzt(i);
                            this.zzB.zzt = (float) d;
                            return;
                        case 30325:
                            zzt(i);
                            this.zzB.zzu = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzz = (long) d;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i, long j) throws zzbh {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        zzt(i);
                        this.zzB.zzd = (int) j;
                        return;
                    case 136:
                        if (j == 1) {
                            z = true;
                        }
                        zzt(i);
                        this.zzB.zzV = z;
                        return;
                    case 155:
                        this.zzP = zzr(j);
                        return;
                    case 159:
                        zzt(i);
                        this.zzB.zzO = (int) j;
                        return;
                    case 176:
                        zzt(i);
                        this.zzB.zzl = (int) j;
                        return;
                    case 179:
                        zzs(i);
                        this.zzJ.zzc(zzr(j));
                        return;
                    case 186:
                        zzt(i);
                        this.zzB.zzm = (int) j;
                        return;
                    case 215:
                        zzt(i);
                        this.zzB.zzc = (int) j;
                        return;
                    case 231:
                        this.zzI = zzr(j);
                        return;
                    case 238:
                        this.zzW = (int) j;
                        return;
                    case 241:
                        if (!this.zzL) {
                            zzs(i);
                            this.zzK.zzc(j);
                            this.zzL = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzX = true;
                        return;
                    case 16871:
                        zzt(i);
                        this.zzB.zzY = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw zzbh.zza("ContentCompAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw zzbh.zza("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw zzbh.zza("EBMLReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw zzbh.zza("ContentEncAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw zzbh.zza("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzE = j + this.zzx;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        zzt(i);
                        if (i2 == 0) {
                            this.zzB.zzw = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzB.zzw = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzB.zzw = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzB.zzw = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzt(i);
                        this.zzB.zzo = (int) j;
                        return;
                    case 21682:
                        zzt(i);
                        this.zzB.zzq = (int) j;
                        return;
                    case 21690:
                        zzt(i);
                        this.zzB.zzp = (int) j;
                        return;
                    case 21930:
                        if (j == 1) {
                            z = true;
                        }
                        zzt(i);
                        this.zzB.zzU = z;
                        return;
                    case 21938:
                        zzt(i);
                        zzaho zzaho = this.zzB;
                        zzaho.zzx = true;
                        zzaho.zzn = (int) j;
                        return;
                    case 21998:
                        zzt(i);
                        this.zzB.zzf = (int) j;
                        return;
                    case 22186:
                        zzt(i);
                        this.zzB.zzR = j;
                        return;
                    case 22203:
                        zzt(i);
                        this.zzB.zzS = j;
                        return;
                    case 25188:
                        zzt(i);
                        this.zzB.zzP = (int) j;
                        return;
                    case 30114:
                        this.zzY = j;
                        return;
                    case 30321:
                        int i3 = (int) j;
                        zzt(i);
                        if (i3 == 0) {
                            this.zzB.zzr = 0;
                            return;
                        } else if (i3 == 1) {
                            this.zzB.zzr = 1;
                            return;
                        } else if (i3 == 2) {
                            this.zzB.zzr = 2;
                            return;
                        } else if (i3 == 3) {
                            this.zzB.zzr = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzt(i);
                        this.zzB.zze = (int) j;
                        return;
                    case 2807729:
                        this.zzy = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i4 = (int) j;
                                zzt(i);
                                if (i4 == 1) {
                                    this.zzB.zzA = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.zzB.zzA = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzt(i);
                                int zzb2 = zzm.zzb((int) j);
                                if (zzb2 != -1) {
                                    this.zzB.zzz = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzt(i);
                                this.zzB.zzx = true;
                                int zza2 = zzm.zza((int) j);
                                if (zza2 != -1) {
                                    this.zzB.zzy = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzt(i);
                                this.zzB.zzB = (int) j;
                                return;
                            case 21949:
                                zzt(i);
                                this.zzB.zzC = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                throw zzbh.zza("ContentEncodingScope " + j + " not supported", (Throwable) null);
            }
        } else if (j != 0) {
            throw zzbh.zza("ContentEncodingOrder " + j + " not supported", (Throwable) null);
        }
    }
}
