package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzsy extends zzhw {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private int zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private int zzI;
    private int zzJ;
    private ByteBuffer zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private long zzX;
    private long zzY;
    private boolean zzZ;
    protected zzhx zza;
    private boolean zzaa;
    private boolean zzab;
    private zzsw zzac;
    private long zzad;
    private boolean zzae;
    private zzrq zzaf;
    private zzrq zzag;
    private final zzsl zzc;
    private final zzta zzd;
    private final float zze;
    private final zzhm zzf = new zzhm(0, 0);
    private final zzhm zzg = new zzhm(0, 0);
    private final zzhm zzh = new zzhm(2, 0);
    private final zzse zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrd zzl;
    private zzad zzm;
    private zzad zzn;
    /* access modifiers changed from: private */
    public zzlm zzo;
    private MediaCrypto zzp;
    private float zzq;
    private float zzr;
    private zzsn zzs;
    private zzad zzt;
    private MediaFormat zzu;
    private boolean zzv;
    private float zzw;
    private ArrayDeque zzx;
    private zzsu zzy;
    private zzsq zzz;

    public zzsy(int i, zzsl zzsl, zzta zzta, boolean z, float f) {
        super(i);
        this.zzc = zzsl;
        zzta zzta2 = zzta;
        this.zzd = zzta;
        this.zze = f;
        zzse zzse = new zzse();
        this.zzi = zzse;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzq = 1.0f;
        this.zzr = 1.0f;
        this.zzk = new ArrayDeque();
        this.zzac = zzsw.zza;
        zzse.zzj(0);
        zzse.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrd();
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzR = 0;
        this.zzI = -1;
        this.zzJ = -1;
        this.zzH = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zza = new zzhx();
    }

    protected static boolean zzaP(zzad zzad2) {
        return zzad2.zzJ == 0;
    }

    private final void zzaQ() {
        this.zzJ = -1;
        this.zzK = null;
    }

    private final void zzaR(zzsw zzsw) {
        this.zzac = zzsw;
        if (zzsw.zzd != -9223372036854775807L) {
            this.zzae = true;
        }
    }

    private final boolean zzaT() throws zzig {
        if (this.zzU) {
            this.zzS = 1;
            if (this.zzC) {
                this.zzT = 3;
                return false;
            }
            this.zzT = 2;
        } else {
            zzaS();
        }
        return true;
    }

    private final boolean zzaU() {
        return this.zzJ >= 0;
    }

    private final boolean zzaV(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzad zzad2 = this.zzn;
        return zzad2 == null || !Objects.equals(zzad2.zzo, "audio/opus") || !zzadm.zzf(j, j2);
    }

    private final boolean zzaW(int i) throws zzig {
        zzhm zzhm = this.zzf;
        zzkj zzk2 = zzk();
        zzhm.zzb();
        int zzcW = zzcW(zzk2, this.zzf, i | 4);
        if (zzcW == -5) {
            zzac(zzk2);
            return true;
        } else if (zzcW != -4 || !this.zzf.zzf()) {
            return false;
        } else {
            this.zzZ = true;
            zzai();
            return false;
        }
    }

    private final boolean zzaX(zzad zzad2) throws zzig {
        if (!(zzen.zza < 23 || this.zzs == null || this.zzT == 3 || zzcV() == 0)) {
            float f = this.zzr;
            zzad2.getClass();
            zzad zzad3 = zzad2;
            float zzZ2 = zzZ(f, zzad2, zzT());
            float f2 = this.zzw;
            if (f2 != zzZ2) {
                if (zzZ2 == -1.0f) {
                    zzae();
                    return false;
                } else if (f2 != -1.0f || zzZ2 > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", zzZ2);
                    zzsn zzsn = this.zzs;
                    zzsn.getClass();
                    zzsn zzsn2 = zzsn;
                    zzsn.zzq(bundle);
                    this.zzw = zzZ2;
                }
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzP = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzO = false;
        this.zzN = false;
        this.zzl.zzb();
    }

    private final void zzae() throws zzig {
        if (this.zzU) {
            this.zzS = 1;
            this.zzT = 3;
            return;
        }
        zzaG();
        zzaC();
    }

    private final void zzah() {
        try {
            zzsn zzsn = this.zzs;
            zzdb.zzb(zzsn);
            zzsn zzsn2 = zzsn;
            zzsn.zzj();
        } finally {
            zzaH();
        }
    }

    private final void zzao() {
        this.zzI = -1;
        this.zzg.zzc = null;
    }

    /* access modifiers changed from: protected */
    public void zzC() {
        try {
            zzad();
            zzaG();
        } finally {
            this.zzag = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r4 >= r0) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzF(com.google.android.gms.internal.ads.zzad[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzur r18) throws com.google.android.gms.internal.ads.zzig {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzsw r13 = r12.zzac
            long r0 = r13.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzsw r4 = new com.google.android.gms.internal.ads.zzsw
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r14
            r9 = r16
            r4.<init>(r5, r7, r9)
            r12.zzaR(r4)
            return
        L_0x001e:
            java.util.ArrayDeque r13 = r12.zzk
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x0052
            long r0 = r12.zzX
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0036
            long r4 = r12.zzad
            int r13 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0052
            int r13 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r13 < 0) goto L_0x0052
        L_0x0036:
            com.google.android.gms.internal.ads.zzsw r5 = new com.google.android.gms.internal.ads.zzsw
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaR(r5)
            com.google.android.gms.internal.ads.zzsw r13 = r12.zzac
            long r13 = r13.zzd
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0051
            r12.zzap()
        L_0x0051:
            return
        L_0x0052:
            java.util.ArrayDeque r13 = r12.zzk
            com.google.android.gms.internal.ads.zzsw r5 = new com.google.android.gms.internal.ads.zzsw
            long r6 = r12.zzX
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r13.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zzF(com.google.android.gms.internal.ads.zzad[], long, long, com.google.android.gms.internal.ads.zzur):void");
    }

    public void zzM(float f, float f2) throws zzig {
        this.zzq = f;
        this.zzr = f2;
        zzaX(this.zzt);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: char} */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r10v24 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r2v23, types: [java.lang.Throwable, android.media.MediaFormat] */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r5v37 */
    /* JADX WARNING: type inference failed for: r5v38 */
    /* JADX WARNING: type inference failed for: r5v39 */
    /* JADX WARNING: type inference failed for: r10v31 */
    /* JADX WARNING: type inference failed for: r5v41 */
    /* JADX WARNING: type inference failed for: r5v42 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r5v44 */
    /* JADX WARNING: type inference failed for: r5v45 */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f3, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01fa, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x022e, code lost:
        r5 = r5;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        zzai();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0233, code lost:
        if (r1.zzaa != false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0235, code lost:
        zzaG();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0274, code lost:
        r17 = r2;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0315, code lost:
        if (r1.zzn != null) goto L_0x0317;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        zzai();
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x035e, code lost:
        if (r1.zzaa != false) goto L_0x0360;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0360, code lost:
        zzaG();
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x03d9, code lost:
        if (r1.zzG != false) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x03db, code lost:
        r1.zzV = true;
        r2.zzk(r1.zzI, 0, 0, 0, 4);
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x03ea, code lost:
        r1.zzS = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0467, code lost:
        if (zzQ() == false) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0469, code lost:
        r1.zzY = r1.zzX;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        r10 = 0;
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x059e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.zzaa = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x05cc, code lost:
        r0 = e;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x05cd, code lost:
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x05cf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x05d0, code lost:
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x05d1, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x05d7, code lost:
        r3 = r0.getStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x05fa, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x05fc, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x05ff, code lost:
        zzaG();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x060e, code lost:
        r3 = 4006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0611, code lost:
        r3 = 4003;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x061a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x061b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x061c, code lost:
        r10 = false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:43:0x0099, B:139:0x022e] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x022e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:220:0x0359 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f9 A[Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }, ExcHandler: CryptoException (e android.media.MediaCodec$CryptoException), Splitter:B:14:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0388 A[Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x05cc A[ExcHandler: CryptoException (e android.media.MediaCodec$CryptoException), PHI: r5 
      PHI: (r5v2 ?) = (r5v0 char), (r5v31 ?), (r5v37 ?), (r5v38 ?), (r5v41 ?), (r5v44 ?) binds: [B:14:0x0021, B:43:0x0099, B:137:0x0227, B:139:0x022e, B:30:0x007e, B:73:0x0116] A[DONT_GENERATE, DONT_INLINE], Splitter:B:43:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x05ff  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x061b A[ExcHandler: CryptoException (e android.media.MediaCodec$CryptoException), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x03a7 A[EDGE_INSN: B:407:0x03a7->B:440:0x03a7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:137:0x0227=Splitter:B:137:0x0227, B:30:0x007e=Splitter:B:30:0x007e} */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzV(long r19, long r21) throws com.google.android.gms.internal.ads.zzig {
        /*
            r18 = this;
            r1 = r18
            r3 = 1
            boolean r0 = r1.zzaa     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            if (r0 == 0) goto L_0x000b
            r1.zzaq()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            return
        L_0x000b:
            com.google.android.gms.internal.ads.zzad r0 = r1.zzm     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            r4 = 2
            if (r0 != 0) goto L_0x0016
            boolean r0 = r1.zzaW(r4)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            if (r0 == 0) goto L_0x05c3
        L_0x0016:
            r1.zzaC()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            boolean r0 = r1.zzN     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
            r5 = -5
            r6 = 0
            if (r0 == 0) goto L_0x01fd
            java.lang.String r0 = "bypassRender"
            android.os.Trace.beginSection(r0)     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
        L_0x0024:
            boolean r0 = r1.zzaa     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            r0 = r0 ^ r3
            com.google.android.gms.internal.ads.zzdb.zzf(r0)     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            boolean r4 = r0.zzq()     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            if (r4 == 0) goto L_0x007d
            java.nio.ByteBuffer r7 = r0.zzc     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r8 = r1.zzJ     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r10 = r0.zzm()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r11 = r0.zze     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r13 = r1.zzf()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r2 = r0.zzn()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            boolean r13 = r1.zzaV(r13, r2)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            boolean r14 = r0.zzf()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r2 = 1
            com.google.android.gms.internal.ads.zzad r15 = r1.zzn     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r15 == 0) goto L_0x0076
            r0 = r15
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r3 = r6
            r6 = 0
            r4 = 0
            r9 = 0
            r2 = r19
            r4 = r21
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r2 = r0.zzn()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r1.zzaD(r2)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r0.zzb()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r2 = 0
            goto L_0x007e
        L_0x0074:
            r3 = 1
            goto L_0x0085
        L_0x0076:
            r2 = r6
            throw r2     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
        L_0x0078:
            r0 = move-exception
            r10 = 0
            r15 = 1
            goto L_0x05d2
        L_0x007d:
            r2 = r6
        L_0x007e:
            boolean r0 = r1.zzZ     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f2 }
            if (r0 == 0) goto L_0x0088
            r3 = 1
            r1.zzaa = r3     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x05cf }
        L_0x0085:
            r5 = 0
            goto L_0x01e7
        L_0x0088:
            r3 = 1
            boolean r0 = r1.zzO     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            if (r0 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            boolean r0 = r0.zzp(r4)     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            com.google.android.gms.internal.ads.zzdb.zzf(r0)     // Catch:{ CryptoException -> 0x01f9, IllegalStateException -> 0x01f5 }
            r5 = 0
            r1.zzO = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x009d
        L_0x009c:
            r5 = 0
        L_0x009d:
            boolean r0 = r1.zzP     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r0 = r0.zzq()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x00b6
            r1.zzad()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzP = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzaC()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r0 = r1.zzN     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x01e7
            goto L_0x00ba
        L_0x00b6:
            r6 = r2
            r5 = -5
            goto L_0x0024
        L_0x00ba:
            boolean r0 = r1.zzZ     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r0 = r0 ^ r3
            com.google.android.gms.internal.ads.zzdb.zzf(r0)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzkj r0 = r1.zzk()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r4.zzb()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x00c9:
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r4.zzb()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r4 = r1.zzcW(r0, r4, r5)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r6 = -5
            if (r4 == r6) goto L_0x01c8
            r7 = -4
            if (r4 == r7) goto L_0x00e6
            boolean r0 = r1.zzQ()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x01cb
            long r7 = r1.zzX     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzY = r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x01cb
        L_0x00e6:
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r7 = r4.zzf()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x00f6
            r1.zzZ = r3     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r7 = r1.zzX     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzY = r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x01cb
        L_0x00f6:
            long r7 = r1.zzX     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r4.zze     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r7 = java.lang.Math.max(r7, r9)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzX = r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r1.zzQ()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 != 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzg     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r4.zzh()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x0110
        L_0x010e:
            r1.zzY = r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x0110:
            boolean r4 = r1.zzab     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.String r7 = "audio/opus"
            if (r4 == 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzad r4 = r1.zzm     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x015d
            r8 = r4
            com.google.android.gms.internal.ads.zzad r8 = (com.google.android.gms.internal.ads.zzad) r8     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzn = r4     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.String r4 = r4.zzo     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = java.util.Objects.equals(r4, r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzad r4 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.util.List r4 = r4.zzr     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r4.isEmpty()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 != 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzad r4 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.util.List r4 = r4.zzr     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            byte[] r4 = (byte[]) r4     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r4 = com.google.android.gms.internal.ads.zzadm.zza(r4)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r8 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r8 == 0) goto L_0x0154
            r9 = r8
            com.google.android.gms.internal.ads.zzad r9 = (com.google.android.gms.internal.ads.zzad) r9     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzab r8 = r8.zzb()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r8.zzG(r4)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r4 = r8.zzaf()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzn = r4     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0155
        L_0x0154:
            throw r2     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x0155:
            com.google.android.gms.internal.ads.zzad r4 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzan(r4, r2)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzab = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x015e
        L_0x015d:
            throw r2     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x015e:
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r4.zzk()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r4 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x019c
            java.lang.String r4 = r4.zzo     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = java.util.Objects.equals(r4, r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r7 = r4.zze()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzad r7 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r4.zza = r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzaj(r4)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x017e:
            long r7 = r1.zzf()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r4.zze     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r7 = com.google.android.gms.internal.ads.zzadm.zzf(r7, r9)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzrd r7 = r1.zzl     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r8 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r8 == 0) goto L_0x019b
            r9 = r8
            com.google.android.gms.internal.ads.zzad r9 = (com.google.android.gms.internal.ads.zzad) r9     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.util.List r8 = r8.zzr     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r7.zza(r4, r8)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x019c
        L_0x019b:
            throw r2     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x019c:
            com.google.android.gms.internal.ads.zzse r4 = r1.zzi     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r7 = r4.zzq()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 != 0) goto L_0x01a5
            goto L_0x01bb
        L_0x01a5:
            long r7 = r1.zzf()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r4.zzn()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r1.zzaV(r7, r9)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzhm r9 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r9.zze     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r7 = r1.zzaV(r7, r9)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 != r7) goto L_0x01c5
        L_0x01bb:
            com.google.android.gms.internal.ads.zzse r4 = r1.zzi     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzhm r7 = r1.zzh     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r4.zzp(r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 != 0) goto L_0x00c9
        L_0x01c5:
            r1.zzO = r3     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x01cb
        L_0x01c8:
            r1.zzac(r0)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x01cb:
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r4 = r0.zzq()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r4 == 0) goto L_0x01d6
            r0.zzk()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x01d6:
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r0 = r0.zzq()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x01ee
            boolean r0 = r1.zzZ     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x01ee
            boolean r0 = r1.zzP     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x01e7
            goto L_0x01ee
        L_0x01e7:
            android.os.Trace.endSection()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r15 = r3
            r10 = r5
            goto L_0x05be
        L_0x01ee:
            r5 = r6
            r6 = r2
            goto L_0x0024
        L_0x01f2:
            r0 = move-exception
            r3 = 1
            goto L_0x01f6
        L_0x01f5:
            r0 = move-exception
        L_0x01f6:
            r5 = 0
            goto L_0x05c9
        L_0x01f9:
            r0 = move-exception
            r5 = 0
            goto L_0x05cd
        L_0x01fd:
            r2 = r6
            r6 = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzsn r0 = r1.zzs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x05ae
            com.google.android.gms.internal.ads.zzdc r0 = r1.zzi()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r0.zzb()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.String r0 = "drainAndFeed"
            android.os.Trace.beginSection(r0)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r16 = r6
        L_0x0212:
            com.google.android.gms.internal.ads.zzsn r6 = r1.zzs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r6 == 0) goto L_0x05a9
            r0 = r6
            com.google.android.gms.internal.ads.zzsn r0 = (com.google.android.gms.internal.ads.zzsn) r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r0 = r1.zzaU()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x0329
            boolean r0 = r1.zzD     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0239
            boolean r0 = r1.zzV     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0239
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x022e, CryptoException -> 0x05cc }
            int r0 = r6.zzb(r0)     // Catch:{ IllegalStateException -> 0x022e, CryptoException -> 0x05cc }
            goto L_0x023f
        L_0x022e:
            r1.zzai()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            boolean r0 = r1.zzaa     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0274
            r1.zzaG()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0274
        L_0x0239:
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r0 = r6.zzb(r0)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x023f:
            if (r0 >= 0) goto L_0x0284
            r6 = -2
            if (r0 != r6) goto L_0x0270
            r1.zzW = r3     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzsn r0 = r1.zzs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x026f
            r6 = r0
            com.google.android.gms.internal.ads.zzsn r6 = (com.google.android.gms.internal.ads.zzsn) r6     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r6 = r1.zzA     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r6 == 0) goto L_0x026a
            java.lang.String r6 = "width"
            int r6 = r0.getInteger(r6)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r7 = 32
            if (r6 != r7) goto L_0x026a
            java.lang.String r6 = "height"
            int r6 = r0.getInteger(r6)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r6 != r7) goto L_0x026a
            r1.zzF = r3     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0212
        L_0x026a:
            r1.zzu = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzv = r3     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0212
        L_0x026f:
            throw r2     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x0270:
            boolean r0 = r1.zzG     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x0278
        L_0x0274:
            r17 = r2
            goto L_0x03a7
        L_0x0278:
            boolean r0 = r1.zzZ     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x0280
            int r0 = r1.zzS     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != r4) goto L_0x0274
        L_0x0280:
            r1.zzai()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0274
        L_0x0284:
            boolean r7 = r1.zzF     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x028e
            r1.zzF = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r6.zzo(r0, r5)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0212
        L_0x028e:
            android.media.MediaCodec$BufferInfo r7 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r7 = r7.size     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 != 0) goto L_0x02a0
            android.media.MediaCodec$BufferInfo r7 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r7 = r7.flags     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r7 = r7 & 4
            if (r7 == 0) goto L_0x02a0
            r1.zzai()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0274
        L_0x02a0:
            r1.zzJ = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.nio.ByteBuffer r0 = r6.zzg(r0)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzK = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x02bf
            android.media.MediaCodec$BufferInfo r7 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r7 = r7.offset     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r0.position(r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.nio.ByteBuffer r0 = r1.zzK     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            android.media.MediaCodec$BufferInfo r7 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r7 = r7.offset     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            android.media.MediaCodec$BufferInfo r8 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r8 = r8.size     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r7 = r7 + r8
            r0.limit(r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x02bf:
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r7 = r0.presentationTimeUs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r1.zzf()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x02cd
            r0 = r3
            goto L_0x02ce
        L_0x02cd:
            r0 = r5
        L_0x02ce:
            r1.zzL = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r7 = r1.zzY     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x02e5
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r9 = r0.presentationTimeUs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x02e5
            r0 = r3
            goto L_0x02e6
        L_0x02e5:
            r0 = r5
        L_0x02e6:
            r1.zzM = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            long r7 = r0.presentationTimeUs     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzsw r0 = r1.zzac     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzej r0 = r0.zze     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.Object r0 = r0.zzc(r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 != 0) goto L_0x030a
            boolean r7 = r1.zzae     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x030a
            android.media.MediaFormat r7 = r1.zzu     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r7 == 0) goto L_0x030a
            com.google.android.gms.internal.ads.zzsw r0 = r1.zzac     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzej r0 = r0.zze     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x030a:
            if (r0 == 0) goto L_0x030f
            r1.zzn = r0     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0317
        L_0x030f:
            boolean r0 = r1.zzv     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0329
            com.google.android.gms.internal.ads.zzad r0 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0329
        L_0x0317:
            com.google.android.gms.internal.ads.zzad r0 = r1.zzn     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0328
            r7 = r0
            com.google.android.gms.internal.ads.zzad r7 = (com.google.android.gms.internal.ads.zzad) r7     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            android.media.MediaFormat r7 = r1.zzu     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzan(r0, r7)     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzv = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            r1.zzae = r5     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            goto L_0x0329
        L_0x0328:
            throw r2     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
        L_0x0329:
            boolean r0 = r1.zzD     // Catch:{ CryptoException -> 0x05cc, IllegalStateException -> 0x05c8 }
            if (r0 == 0) goto L_0x0364
            boolean r0 = r1.zzV     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 == 0) goto L_0x0364
            java.nio.ByteBuffer r7 = r1.zzK     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            int r8 = r1.zzJ     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            long r11 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            boolean r13 = r1.zzL     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            boolean r14 = r1.zzM     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            com.google.android.gms.internal.ads.zzad r15 = r1.zzn     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            if (r15 == 0) goto L_0x0354
            r0 = r15
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ IllegalStateException -> 0x0357, CryptoException -> 0x061b }
            r10 = 1
            r4 = r21
            r17 = r2
            r2 = r19
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0359, CryptoException -> 0x061b }
            goto L_0x0386
        L_0x0354:
            r17 = r2
            throw r17     // Catch:{ IllegalStateException -> 0x0359, CryptoException -> 0x061b }
        L_0x0357:
            r17 = r2
        L_0x0359:
            r1.zzai()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            boolean r0 = r1.zzaa     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 == 0) goto L_0x03a7
            r1.zzaG()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            goto L_0x03a7
        L_0x0364:
            r17 = r2
            java.nio.ByteBuffer r7 = r1.zzK     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r8 = r1.zzJ     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r9 = r0.flags     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r11 = r0.presentationTimeUs     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            boolean r13 = r1.zzL     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            boolean r14 = r1.zzM     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            com.google.android.gms.internal.ads.zzad r15 = r1.zzn     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r15 == 0) goto L_0x05a6
            r0 = r15
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r10 = 1
            r2 = r19
            r4 = r21
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
        L_0x0386:
            if (r0 == 0) goto L_0x03a7
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            long r2 = r0.presentationTimeUs     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r1.zzaD(r2)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r0 = r0.flags     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r0 = r0 & 4
            r1.zzaQ()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 == 0) goto L_0x039e
            r1.zzai()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            goto L_0x03a7
        L_0x039e:
            r2 = r17
            r3 = 1
            r4 = 2
            r5 = 0
            r16 = -5
            goto L_0x0212
        L_0x03a7:
            com.google.android.gms.internal.ads.zzsn r2 = r1.zzs     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r2 == 0) goto L_0x05a0
            int r0 = r1.zzS     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r9 = 2
            if (r0 == r9) goto L_0x05a0
            boolean r0 = r1.zzZ     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 == 0) goto L_0x03b6
            goto L_0x05a0
        L_0x03b6:
            r0 = r2
            com.google.android.gms.internal.ads.zzsn r0 = (com.google.android.gms.internal.ads.zzsn) r0     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            int r0 = r1.zzI     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 >= 0) goto L_0x03d2
            int r0 = r2.zza()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r1.zzI = r0     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            if (r0 < 0) goto L_0x05a0
            com.google.android.gms.internal.ads.zzhm r3 = r1.zzg     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            java.nio.ByteBuffer r0 = r2.zzf(r0)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r3.zzc = r0     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r0.zzb()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
        L_0x03d2:
            int r0 = r1.zzS     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x0078 }
            r15 = 1
            if (r0 != r15) goto L_0x03ef
            boolean r0 = r1.zzG     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            if (r0 != 0) goto L_0x03ea
            r1.zzV = r15     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            int r3 = r1.zzI     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            r6 = 0
            r8 = 4
            r4 = 0
            r5 = 0
            r2.zzk(r3, r4, r5, r6, r8)     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            r1.zzao()     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
        L_0x03ea:
            r1.zzS = r9     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            r10 = 0
            goto L_0x05a2
        L_0x03ef:
            boolean r0 = r1.zzE     // Catch:{ CryptoException -> 0x061b, IllegalStateException -> 0x059e }
            if (r0 == 0) goto L_0x0416
            r10 = 0
            r1.zzE = r10     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.nio.ByteBuffer r0 = r0.zzc     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x0415
            r3 = r0
            java.nio.ByteBuffer r3 = (java.nio.ByteBuffer) r3     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            byte[] r3 = zzb     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.put(r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r1.zzI     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r6 = 0
            r8 = 0
            r4 = 0
            r5 = 38
            r2.zzk(r3, r4, r5, r6, r8)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzao()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzU = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x0415:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0416:
            r10 = 0
            int r0 = r1.zzR     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != r15) goto L_0x0449
            r0 = r10
        L_0x041c:
            com.google.android.gms.internal.ads.zzad r3 = r1.zzt     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r3 == 0) goto L_0x0448
            r4 = r3
            com.google.android.gms.internal.ads.zzad r4 = (com.google.android.gms.internal.ads.zzad) r4     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.util.List r3 = r3.zzr     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r3.size()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 >= r3) goto L_0x0445
            com.google.android.gms.internal.ads.zzad r3 = r1.zzt     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.util.List r3 = r3.zzr     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            byte[] r3 = (byte[]) r3     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.nio.ByteBuffer r4 = r4.zzc     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 == 0) goto L_0x0444
            r5 = r4
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r4.put(r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r0 = r0 + 1
            goto L_0x041c
        L_0x0444:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0445:
            r1.zzR = r9     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x0449
        L_0x0448:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0449:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.nio.ByteBuffer r0 = r0.zzc     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x059d
            r3 = r0
            java.nio.ByteBuffer r3 = (java.nio.ByteBuffer) r3     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r0 = r0.position()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzkj r3 = r1.zzk()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r4 = r1.zzg     // Catch:{ zzhl -> 0x0590 }
            int r4 = r1.zzcW(r3, r4, r10)     // Catch:{ zzhl -> 0x0590 }
            r5 = -3
            if (r4 != r5) goto L_0x046f
            boolean r0 = r1.zzQ()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x05a2
            long r2 = r1.zzX     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzY = r2     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x05a2
        L_0x046f:
            r11 = -5
            if (r4 != r11) goto L_0x0482
            int r0 = r1.zzR     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != r9) goto L_0x047d
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zzb()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzR = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x047d:
            r1.zzac(r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x0482:
            com.google.android.gms.internal.ads.zzhm r3 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r4 = r3.zzf()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 == 0) goto L_0x04b7
            long r4 = r1.zzX     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzY = r4     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r0 = r1.zzR     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != r9) goto L_0x0497
            r3.zzb()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzR = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0497:
            r1.zzZ = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r0 = r1.zzU     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != 0) goto L_0x04a2
            r1.zzai()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x05a2
        L_0x04a2:
            boolean r0 = r1.zzG     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != 0) goto L_0x05a2
            r1.zzV = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r1.zzI     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r6 = 0
            r8 = 4
            r4 = 0
            r5 = 0
            r2.zzk(r3, r4, r5, r6, r8)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzao()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x05a2
        L_0x04b7:
            boolean r4 = r1.zzU     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 != 0) goto L_0x04cc
            boolean r4 = r3.zzg()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 != 0) goto L_0x04cc
            r3.zzb()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r0 = r1.zzR     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != r9) goto L_0x03a7
            r1.zzR = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x04cc:
            boolean r3 = r1.zzaO(r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r3 == 0) goto L_0x04e0
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zzb()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhx r0 = r1.zza     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r0.zzd     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r2 + r15
            r0.zzd = r2     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x04e0:
            com.google.android.gms.internal.ads.zzhm r3 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r4 = r3.zzl()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 == 0) goto L_0x04ed
            com.google.android.gms.internal.ads.zzhj r3 = r3.zzb     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r3.zzb(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x04ed:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            long r6 = r0.zze     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r0 = r1.zzab     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x0525
            java.util.ArrayDeque r0 = r1.zzk     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r0 = r0.isEmpty()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != 0) goto L_0x0513
            java.util.ArrayDeque r0 = r1.zzk     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.lang.Object r0 = r0.peekLast()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzsw r0 = (com.google.android.gms.internal.ads.zzsw) r0     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzej r0 = r0.zze     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzad r3 = r1.zzm     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r3 == 0) goto L_0x0512
            r5 = r3
            com.google.android.gms.internal.ads.zzad r5 = (com.google.android.gms.internal.ads.zzad) r5     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zzd(r6, r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x0521
        L_0x0512:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0513:
            com.google.android.gms.internal.ads.zzsw r0 = r1.zzac     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzej r0 = r0.zze     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzad r3 = r1.zzm     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r3 == 0) goto L_0x0524
            r5 = r3
            com.google.android.gms.internal.ads.zzad r5 = (com.google.android.gms.internal.ads.zzad) r5     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zzd(r6, r3)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0521:
            r1.zzab = r10     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x0525
        L_0x0524:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0525:
            long r12 = r1.zzX     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            long r12 = java.lang.Math.max(r12, r6)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzX = r12     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r0 = r1.zzQ()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 != 0) goto L_0x053b
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r0 = r0.zzh()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x053d
        L_0x053b:
            r1.zzY = r12     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x053d:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zzk()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            boolean r3 = r0.zze()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r3 == 0) goto L_0x054d
            r1.zzaj(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x054d:
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzaE(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzau(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r4 == 0) goto L_0x0568
            r0 = r2
            com.google.android.gms.internal.ads.zzsn r0 = (com.google.android.gms.internal.ads.zzsn) r0     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r1.zzI     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhj r5 = r0.zzb     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r8 = 0
            r4 = 0
            r2.zzl(r3, r4, r5, r6, r8)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x057f
        L_0x0568:
            r0 = r2
            com.google.android.gms.internal.ads.zzsn r0 = (com.google.android.gms.internal.ads.zzsn) r0     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r1.zzI     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhm r0 = r1.zzg     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            java.nio.ByteBuffer r0 = r0.zzc     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            if (r0 == 0) goto L_0x058f
            r4 = r0
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r5 = r0.limit()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r8 = 0
            r4 = 0
            r2.zzk(r3, r4, r5, r6, r8)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x057f:
            r1.zzao()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzU = r15     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzR = r10     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            com.google.android.gms.internal.ads.zzhx r0 = r1.zza     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r0.zzc     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r2 + r15
            r0.zzc = r2     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x058f:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x0590:
            r0 = move-exception
            r11 = -5
            r1.zzak(r0)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzaW(r10)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzah()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x03a7
        L_0x059d:
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x059e:
            r0 = move-exception
            goto L_0x05d1
        L_0x05a0:
            r10 = 0
            r15 = 1
        L_0x05a2:
            android.os.Trace.endSection()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            goto L_0x05be
        L_0x05a6:
            r10 = 0
            r15 = 1
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x05a9:
            r17 = r2
            r15 = r3
            r10 = r5
            throw r17     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x05ae:
            r15 = r3
            r10 = r5
            com.google.android.gms.internal.ads.zzhx r0 = r1.zza     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r0.zzd     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r3 = r18.zzd(r19)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r1.zzaW(r15)     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x05be:
            com.google.android.gms.internal.ads.zzhx r0 = r1.zza     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
            r0.zza()     // Catch:{ CryptoException -> 0x05c6, IllegalStateException -> 0x05c4 }
        L_0x05c3:
            return
        L_0x05c4:
            r0 = move-exception
            goto L_0x05d2
        L_0x05c6:
            r0 = move-exception
            goto L_0x061d
        L_0x05c8:
            r0 = move-exception
        L_0x05c9:
            r15 = r3
            r10 = r5
            goto L_0x05d2
        L_0x05cc:
            r0 = move-exception
        L_0x05cd:
            r10 = r5
            goto L_0x061d
        L_0x05cf:
            r0 = move-exception
            r15 = r3
        L_0x05d1:
            r10 = 0
        L_0x05d2:
            boolean r2 = r0 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x05d7
            goto L_0x05ec
        L_0x05d7:
            java.lang.StackTraceElement[] r3 = r0.getStackTrace()
            int r4 = r3.length
            if (r4 <= 0) goto L_0x061a
            r3 = r3[r10]
            java.lang.String r3 = r3.getClassName()
            java.lang.String r4 = "android.media.MediaCodec"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x061a
        L_0x05ec:
            r1.zzak(r0)
            if (r2 == 0) goto L_0x05fc
            r2 = r0
            android.media.MediaCodec$CodecException r2 = (android.media.MediaCodec.CodecException) r2
            boolean r2 = r2.isRecoverable()
            if (r2 == 0) goto L_0x05fc
            r2 = r15
            goto L_0x05fd
        L_0x05fc:
            r2 = r10
        L_0x05fd:
            if (r2 == 0) goto L_0x0602
            r1.zzaG()
        L_0x0602:
            com.google.android.gms.internal.ads.zzsq r3 = r1.zzz
            com.google.android.gms.internal.ads.zzsp r0 = r1.zzaA(r0, r3)
            int r3 = r0.zzb
            r4 = 1101(0x44d, float:1.543E-42)
            if (r3 != r4) goto L_0x0611
            r3 = 4006(0xfa6, float:5.614E-42)
            goto L_0x0613
        L_0x0611:
            r3 = 4003(0xfa3, float:5.61E-42)
        L_0x0613:
            com.google.android.gms.internal.ads.zzad r4 = r1.zzm
            com.google.android.gms.internal.ads.zzig r0 = r1.zzcY(r0, r4, r2, r3)
            throw r0
        L_0x061a:
            throw r0
        L_0x061b:
            r0 = move-exception
            r10 = 0
        L_0x061d:
            com.google.android.gms.internal.ads.zzad r2 = r1.zzm
            int r3 = r0.getErrorCode()
            int r3 = com.google.android.gms.internal.ads.zzen.zzl(r3)
            com.google.android.gms.internal.ads.zzig r0 = r1.zzcY(r0, r2, r10, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zzV(long, long):void");
    }

    public boolean zzW() {
        return this.zzaa;
    }

    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaU()) {
            return true;
        }
        return this.zzH != -9223372036854775807L && zzi().zzb() < this.zzH;
    }

    public final int zzY(zzad zzad2) throws zzig {
        try {
            return zzaa(this.zzd, zzad2);
        } catch (zztf e) {
            throw zzcY(e, zzad2, false, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public float zzZ(float f, zzad zzad2, zzad[] zzadArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public zzsp zzaA(Throwable th, zzsq zzsq) {
        return new zzsp(th, zzsq);
    }

    /* access modifiers changed from: protected */
    public final zzsq zzaB() {
        return this.zzz;
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [android.media.MediaCrypto, com.google.android.gms.internal.ads.zzsx] */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04dd A[Catch:{ all -> 0x0505, Exception -> 0x0513 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0535 A[Catch:{ zztf -> 0x0092, zzsu -> 0x0564 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0538 A[Catch:{ zztf -> 0x0092, zzsu -> 0x0564 }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0504 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x054b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0544 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaC() throws com.google.android.gms.internal.ads.zzig {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r8 = "MediaCodecRenderer"
            com.google.android.gms.internal.ads.zzsn r0 = r1.zzs
            if (r0 != 0) goto L_0x056d
            boolean r0 = r1.zzN
            if (r0 != 0) goto L_0x056d
            com.google.android.gms.internal.ads.zzad r9 = r1.zzm
            if (r9 != 0) goto L_0x0012
            goto L_0x056d
        L_0x0012:
            boolean r0 = r1.zzaM(r9)
            r10 = 1
            if (r0 == 0) goto L_0x0046
            r1.zzad()
            java.lang.String r0 = r9.zzo
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = "audio/mpeg"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = "audio/opus"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi
            r0.zzo(r10)
            goto L_0x0043
        L_0x003c:
            com.google.android.gms.internal.ads.zzse r0 = r1.zzi
            r2 = 32
            r0.zzo(r2)
        L_0x0043:
            r1.zzN = r10
            return
        L_0x0046:
            com.google.android.gms.internal.ads.zzrq r0 = r1.zzag
            r1.zzaf = r0
            if (r0 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzdb.zzf(r10)
            com.google.android.gms.internal.ads.zzrq r0 = r1.zzaf
            boolean r2 = com.google.android.gms.internal.ads.zzrr.zza
            r0.zza()
        L_0x0056:
            r11 = 0
            com.google.android.gms.internal.ads.zzrq r0 = r1.zzaf     // Catch:{ zzsu -> 0x0564 }
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r9.zzo     // Catch:{ zzsu -> 0x0564 }
            com.google.android.gms.internal.ads.zzdb.zzb(r0)     // Catch:{ zzsu -> 0x0564 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ zzsu -> 0x0564 }
        L_0x0062:
            com.google.android.gms.internal.ads.zzad r12 = r1.zzm     // Catch:{ zzsu -> 0x0564 }
            r13 = 0
            if (r12 == 0) goto L_0x0562
            r0 = r12
            com.google.android.gms.internal.ads.zzad r0 = (com.google.android.gms.internal.ads.zzad) r0     // Catch:{ zzsu -> 0x0564 }
            java.util.ArrayDeque r0 = r1.zzx     // Catch:{ zzsu -> 0x0564 }
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzta r0 = r1.zzd     // Catch:{ zztf -> 0x0092 }
            java.util.List r0 = r1.zzag(r0, r12, r11)     // Catch:{ zztf -> 0x0092 }
            r0.isEmpty()     // Catch:{ zztf -> 0x0092 }
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch:{ zztf -> 0x0092 }
            r2.<init>()     // Catch:{ zztf -> 0x0092 }
            r1.zzx = r2     // Catch:{ zztf -> 0x0092 }
            boolean r2 = r0.isEmpty()     // Catch:{ zztf -> 0x0092 }
            if (r2 != 0) goto L_0x008f
            java.util.ArrayDeque r2 = r1.zzx     // Catch:{ zztf -> 0x0092 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ zztf -> 0x0092 }
            com.google.android.gms.internal.ads.zzsq r0 = (com.google.android.gms.internal.ads.zzsq) r0     // Catch:{ zztf -> 0x0092 }
            r2.add(r0)     // Catch:{ zztf -> 0x0092 }
        L_0x008f:
            r1.zzy = r13     // Catch:{ zztf -> 0x0092 }
            goto L_0x009c
        L_0x0092:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzsu r2 = new com.google.android.gms.internal.ads.zzsu     // Catch:{ zzsu -> 0x0564 }
            r3 = -49998(0xffffffffffff3cb2, float:NaN)
            r2.<init>((com.google.android.gms.internal.ads.zzad) r12, (java.lang.Throwable) r0, (boolean) r11, (int) r3)     // Catch:{ zzsu -> 0x0564 }
            throw r2     // Catch:{ zzsu -> 0x0564 }
        L_0x009c:
            java.util.ArrayDeque r0 = r1.zzx     // Catch:{ zzsu -> 0x0564 }
            boolean r0 = r0.isEmpty()     // Catch:{ zzsu -> 0x0564 }
            if (r0 != 0) goto L_0x0557
            java.util.ArrayDeque r14 = r1.zzx     // Catch:{ zzsu -> 0x0564 }
            if (r14 == 0) goto L_0x0555
            r0 = r14
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch:{ zzsu -> 0x0564 }
        L_0x00ab:
            com.google.android.gms.internal.ads.zzsn r0 = r1.zzs     // Catch:{ zzsu -> 0x0564 }
            if (r0 != 0) goto L_0x0551
            java.lang.Object r0 = r14.peekFirst()     // Catch:{ zzsu -> 0x0564 }
            r15 = r0
            com.google.android.gms.internal.ads.zzsq r15 = (com.google.android.gms.internal.ads.zzsq) r15     // Catch:{ zzsu -> 0x0564 }
            if (r15 == 0) goto L_0x054e
            r0 = r15
            com.google.android.gms.internal.ads.zzsq r0 = (com.google.android.gms.internal.ads.zzsq) r0     // Catch:{ zzsu -> 0x0564 }
            boolean r0 = r1.zzaN(r15)     // Catch:{ zzsu -> 0x0564 }
            if (r0 == 0) goto L_0x056d
            com.google.android.gms.internal.ads.zzad r0 = r1.zzm     // Catch:{ Exception -> 0x0515 }
            if (r0 == 0) goto L_0x050e
            r2 = r0
            com.google.android.gms.internal.ads.zzad r2 = (com.google.android.gms.internal.ads.zzad) r2     // Catch:{ Exception -> 0x0515 }
            java.lang.String r2 = r15.zza     // Catch:{ Exception -> 0x0515 }
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0515 }
            r4 = 23
            if (r3 >= r4) goto L_0x00d3
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00dd
        L_0x00d3:
            float r3 = r1.zzr     // Catch:{ Exception -> 0x0515 }
            com.google.android.gms.internal.ads.zzad[] r6 = r1.zzT()     // Catch:{ Exception -> 0x0515 }
            float r3 = r1.zzZ(r3, r0, r6)     // Catch:{ Exception -> 0x0515 }
        L_0x00dd:
            float r6 = r1.zze     // Catch:{ Exception -> 0x0515 }
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x00e5
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x00e5:
            r1.zzaF(r0)     // Catch:{ Exception -> 0x0515 }
            com.google.android.gms.internal.ads.zzdc r6 = r1.zzi()     // Catch:{ Exception -> 0x0515 }
            long r6 = r6.zzb()     // Catch:{ Exception -> 0x0515 }
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            com.google.android.gms.internal.ads.zzsk r5 = r1.zzaf(r15, r0, r13, r3)     // Catch:{ Exception -> 0x0515 }
            r17 = r10
            int r10 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x050c }
            r11 = 31
            if (r10 < r11) goto L_0x0105
            com.google.android.gms.internal.ads.zzoj r10 = r1.zzo()     // Catch:{ Exception -> 0x050c }
            com.google.android.gms.internal.ads.zzst.zza(r5, r10)     // Catch:{ Exception -> 0x050c }
        L_0x0105:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r10.<init>()     // Catch:{ all -> 0x0505 }
            java.lang.String r11 = "createCodec:"
            r10.append(r11)     // Catch:{ all -> 0x0505 }
            r10.append(r2)     // Catch:{ all -> 0x0505 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0505 }
            android.os.Trace.beginSection(r10)     // Catch:{ all -> 0x0505 }
            com.google.android.gms.internal.ads.zzsl r10 = r1.zzc     // Catch:{ all -> 0x0505 }
            com.google.android.gms.internal.ads.zzsn r10 = r10.zzd(r5)     // Catch:{ all -> 0x0505 }
            r1.zzs = r10     // Catch:{ all -> 0x0505 }
            com.google.android.gms.internal.ads.zzsv r11 = new com.google.android.gms.internal.ads.zzsv     // Catch:{ all -> 0x0505 }
            r11.<init>(r1, r13)     // Catch:{ all -> 0x0505 }
            r10.zzs(r11)     // Catch:{ all -> 0x0505 }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x050c }
            com.google.android.gms.internal.ads.zzdc r10 = r1.zzi()     // Catch:{ Exception -> 0x050c }
            long r10 = r10.zzb()     // Catch:{ Exception -> 0x050c }
            boolean r18 = r15.zze(r0)     // Catch:{ Exception -> 0x050c }
            if (r18 != 0) goto L_0x03b0
            r18 = r13
            java.lang.String r13 = "Format exceeds selected codec's capabilities [%s, %s]"
            java.lang.String r4 = ","
            r19 = r4
            java.lang.String r19 = (java.lang.String) r19     // Catch:{ Exception -> 0x0513 }
            r19 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0513 }
            r5.<init>()     // Catch:{ Exception -> 0x0513 }
            r20 = r6
            java.lang.String r6 = "id="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zza     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = ", mimeType="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zzo     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zzn     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x016f
            java.lang.String r6 = ", container="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zzn     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x016f:
            int r6 = r0.zzj     // Catch:{ Exception -> 0x0513 }
            r7 = -1
            if (r6 == r7) goto L_0x017e
            java.lang.String r6 = ", bitrate="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzj     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x017e:
            java.lang.String r6 = r0.zzk     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x018c
            java.lang.String r6 = ", codecs="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zzk     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x018c:
            com.google.android.gms.internal.ads.zzw r6 = r0.zzs     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x021c
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet     // Catch:{ Exception -> 0x0513 }
            r6.<init>()     // Catch:{ Exception -> 0x0513 }
            r22 = r10
            r7 = 0
        L_0x0198:
            com.google.android.gms.internal.ads.zzw r10 = r0.zzs     // Catch:{ Exception -> 0x0513 }
            int r11 = r10.zzb     // Catch:{ Exception -> 0x0513 }
            if (r7 >= r11) goto L_0x020e
            com.google.android.gms.internal.ads.zzv r10 = r10.zza(r7)     // Catch:{ Exception -> 0x0513 }
            java.util.UUID r10 = r10.zza     // Catch:{ Exception -> 0x0513 }
            java.util.UUID r11 = com.google.android.gms.internal.ads.zzj.zzb     // Catch:{ Exception -> 0x0513 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0513 }
            if (r11 == 0) goto L_0x01b4
            java.lang.String r10 = "cenc"
            r6.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x01b1:
            r24 = r7
            goto L_0x020b
        L_0x01b4:
            java.util.UUID r11 = com.google.android.gms.internal.ads.zzj.zzc     // Catch:{ Exception -> 0x0513 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0513 }
            if (r11 == 0) goto L_0x01c2
            java.lang.String r10 = "clearkey"
            r6.add(r10)     // Catch:{ Exception -> 0x0513 }
            goto L_0x01b1
        L_0x01c2:
            java.util.UUID r11 = com.google.android.gms.internal.ads.zzj.zze     // Catch:{ Exception -> 0x0513 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0513 }
            if (r11 == 0) goto L_0x01d0
            java.lang.String r10 = "playready"
            r6.add(r10)     // Catch:{ Exception -> 0x0513 }
            goto L_0x01b1
        L_0x01d0:
            java.util.UUID r11 = com.google.android.gms.internal.ads.zzj.zzd     // Catch:{ Exception -> 0x0513 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0513 }
            if (r11 == 0) goto L_0x01de
            java.lang.String r10 = "widevine"
            r6.add(r10)     // Catch:{ Exception -> 0x0513 }
            goto L_0x01b1
        L_0x01de:
            java.util.UUID r11 = com.google.android.gms.internal.ads.zzj.zza     // Catch:{ Exception -> 0x0513 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0513 }
            if (r11 == 0) goto L_0x01ec
            java.lang.String r10 = "universal"
            r6.add(r10)     // Catch:{ Exception -> 0x0513 }
            goto L_0x01b1
        L_0x01ec:
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0513 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0513 }
            r11.<init>()     // Catch:{ Exception -> 0x0513 }
            r24 = r7
            java.lang.String r7 = "unknown ("
            r11.append(r7)     // Catch:{ Exception -> 0x0513 }
            r11.append(r10)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r7 = ")"
            r11.append(r7)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r7 = r11.toString()     // Catch:{ Exception -> 0x0513 }
            r6.add(r7)     // Catch:{ Exception -> 0x0513 }
        L_0x020b:
            int r7 = r24 + 1
            goto L_0x0198
        L_0x020e:
            java.lang.String r7 = ", drm=["
            r5.append(r7)     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzfwi.zzb(r5, r6, r4)     // Catch:{ Exception -> 0x0513 }
            r6 = 93
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            goto L_0x021e
        L_0x021c:
            r22 = r10
        L_0x021e:
            int r6 = r0.zzu     // Catch:{ Exception -> 0x0513 }
            r7 = -1
            if (r6 == r7) goto L_0x023b
            int r6 = r0.zzv     // Catch:{ Exception -> 0x0513 }
            if (r6 == r7) goto L_0x023b
            java.lang.String r6 = ", res="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzu     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = "x"
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzv     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x023b:
            com.google.android.gms.internal.ads.zzm r6 = r0.zzB     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x0259
            boolean r7 = r6.zze()     // Catch:{ Exception -> 0x0513 }
            if (r7 != 0) goto L_0x024b
            boolean r6 = r6.zzf()     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x0259
        L_0x024b:
            java.lang.String r6 = ", color="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzm r6 = r0.zzB     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r6.zzd()     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0259:
            float r6 = r0.zzw     // Catch:{ Exception -> 0x0513 }
            int r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r6 == 0) goto L_0x0269
            java.lang.String r6 = ", fps="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            float r6 = r0.zzw     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0269:
            int r6 = r0.zzC     // Catch:{ Exception -> 0x0513 }
            r7 = -1
            if (r6 == r7) goto L_0x0278
            java.lang.String r6 = ", channels="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzC     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0278:
            int r6 = r0.zzD     // Catch:{ Exception -> 0x0513 }
            r7 = -1
            if (r6 == r7) goto L_0x0287
            java.lang.String r6 = ", sample_rate="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzD     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0287:
            java.lang.String r6 = r0.zzd     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x0295
            java.lang.String r6 = ", language="
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r6 = r0.zzd     // Catch:{ Exception -> 0x0513 }
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0295:
            java.util.List r6 = r0.zzc     // Catch:{ Exception -> 0x0513 }
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x0513 }
            java.lang.String r7 = "]"
            if (r6 != 0) goto L_0x02b5
            java.lang.String r6 = ", labels=["
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            java.util.List r6 = r0.zzc     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzaa r10 = new com.google.android.gms.internal.ads.zzaa     // Catch:{ Exception -> 0x0513 }
            r10.<init>()     // Catch:{ Exception -> 0x0513 }
            java.util.List r6 = com.google.android.gms.internal.ads.zzgae.zzb(r6, r10)     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzfwi.zzb(r5, r6, r4)     // Catch:{ Exception -> 0x0513 }
            r5.append(r7)     // Catch:{ Exception -> 0x0513 }
        L_0x02b5:
            int r6 = r0.zze     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x02dd
            java.lang.String r6 = ", selectionFlags=["
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zze     // Catch:{ Exception -> 0x0513 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0513 }
            r10.<init>()     // Catch:{ Exception -> 0x0513 }
            r11 = r6 & 1
            if (r11 == 0) goto L_0x02ce
            java.lang.String r11 = "default"
            r10.add(r11)     // Catch:{ Exception -> 0x0513 }
        L_0x02ce:
            r6 = r6 & 2
            if (r6 == 0) goto L_0x02d7
            java.lang.String r6 = "forced"
            r10.add(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x02d7:
            com.google.android.gms.internal.ads.zzfwi.zzb(r5, r10, r4)     // Catch:{ Exception -> 0x0513 }
            r5.append(r7)     // Catch:{ Exception -> 0x0513 }
        L_0x02dd:
            int r6 = r0.zzf     // Catch:{ Exception -> 0x0513 }
            if (r6 == 0) goto L_0x038b
            java.lang.String r6 = ", roleFlags=["
            r5.append(r6)     // Catch:{ Exception -> 0x0513 }
            int r6 = r0.zzf     // Catch:{ Exception -> 0x0513 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x0513 }
            r11.<init>()     // Catch:{ Exception -> 0x0513 }
            r16 = r6 & 1
            if (r16 == 0) goto L_0x02fa
            r16 = 32768(0x8000, float:4.5918E-41)
            java.lang.String r10 = "main"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
            goto L_0x02fd
        L_0x02fa:
            r16 = 32768(0x8000, float:4.5918E-41)
        L_0x02fd:
            r10 = r6 & 2
            if (r10 == 0) goto L_0x0306
            java.lang.String r10 = "alt"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0306:
            r10 = r6 & 4
            if (r10 == 0) goto L_0x030f
            java.lang.String r10 = "supplementary"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x030f:
            r10 = r6 & 8
            if (r10 == 0) goto L_0x0318
            java.lang.String r10 = "commentary"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0318:
            r10 = r6 & 16
            if (r10 == 0) goto L_0x0321
            java.lang.String r10 = "dub"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0321:
            r10 = r6 & 32
            if (r10 == 0) goto L_0x032a
            java.lang.String r10 = "emergency"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x032a:
            r10 = r6 & 64
            if (r10 == 0) goto L_0x0333
            java.lang.String r10 = "caption"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0333:
            r10 = r6 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x033c
            java.lang.String r10 = "subtitle"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x033c:
            r10 = r6 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0345
            java.lang.String r10 = "sign"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0345:
            r10 = r6 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x034e
            java.lang.String r10 = "describes-video"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x034e:
            r10 = r6 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0357
            java.lang.String r10 = "describes-music"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0357:
            r10 = r6 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0360
            java.lang.String r10 = "enhanced-intelligibility"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0360:
            r10 = r6 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0369
            java.lang.String r10 = "transcribes-dialog"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0369:
            r10 = r6 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0372
            java.lang.String r10 = "easy-read"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x0372:
            r10 = r6 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x037b
            java.lang.String r10 = "trick-play"
            r11.add(r10)     // Catch:{ Exception -> 0x0513 }
        L_0x037b:
            r6 = r6 & r16
            if (r6 == 0) goto L_0x0384
            java.lang.String r6 = "auxiliary"
            r11.add(r6)     // Catch:{ Exception -> 0x0513 }
        L_0x0384:
            com.google.android.gms.internal.ads.zzfwi.zzb(r5, r11, r4)     // Catch:{ Exception -> 0x0513 }
            r5.append(r7)     // Catch:{ Exception -> 0x0513 }
            goto L_0x038e
        L_0x038b:
            r16 = 32768(0x8000, float:4.5918E-41)
        L_0x038e:
            int r4 = r0.zzf     // Catch:{ Exception -> 0x0513 }
            r4 = r4 & r16
            if (r4 == 0) goto L_0x039e
            java.lang.String r4 = ", auxiliaryTrackType="
            r5.append(r4)     // Catch:{ Exception -> 0x0513 }
            java.lang.String r4 = "undefined"
            r5.append(r4)     // Catch:{ Exception -> 0x0513 }
        L_0x039e:
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0513 }
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r2}     // Catch:{ Exception -> 0x0513 }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ Exception -> 0x0513 }
            java.lang.String r4 = java.lang.String.format(r5, r13, r4)     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r4)     // Catch:{ Exception -> 0x0513 }
            goto L_0x03b8
        L_0x03b0:
            r19 = r5
            r20 = r6
            r22 = r10
            r18 = r13
        L_0x03b8:
            r1.zzz = r15     // Catch:{ Exception -> 0x0513 }
            r1.zzw = r3     // Catch:{ Exception -> 0x0513 }
            r1.zzt = r0     // Catch:{ Exception -> 0x0513 }
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            r3 = 25
            r4 = 2
            if (r0 > r3) goto L_0x03f7
            java.lang.String r0 = "OMX.Exynos.avc.dec.secure"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x03f7
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ Exception -> 0x0513 }
            java.lang.String r5 = "SM-T585"
            boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x03f5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ Exception -> 0x0513 }
            java.lang.String r5 = "SM-A510"
            boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x03f5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ Exception -> 0x0513 }
            java.lang.String r5 = "SM-A520"
            boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x03f5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ Exception -> 0x0513 }
            java.lang.String r5 = "SM-J700"
            boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x03f7
        L_0x03f5:
            r0 = r4
            goto L_0x0439
        L_0x03f7:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            r5 = 24
            if (r0 >= r5) goto L_0x0438
            java.lang.String r0 = "OMX.Nvidia.h264.decode"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x040d
            java.lang.String r0 = "OMX.Nvidia.h264.decode.secure"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x0438
        L_0x040d:
            java.lang.String r0 = "flounder"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x0435
            java.lang.String r0 = "flounder_lte"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x0435
            java.lang.String r0 = "grouper"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x0435
            java.lang.String r0 = "tilapia"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x0438
        L_0x0435:
            r0 = r17
            goto L_0x0439
        L_0x0438:
            r0 = 0
        L_0x0439:
            r1.zzA = r0     // Catch:{ Exception -> 0x0513 }
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            r5 = 29
            if (r0 != r5) goto L_0x044c
            java.lang.String r0 = "c2.android.aac.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x044c
            r0 = r17
            goto L_0x044d
        L_0x044c:
            r0 = 0
        L_0x044d:
            r1.zzB = r0     // Catch:{ Exception -> 0x0513 }
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            r6 = 23
            if (r0 > r6) goto L_0x0460
            java.lang.String r0 = "OMX.google.vorbis.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x0460
            r0 = r17
            goto L_0x0461
        L_0x0460:
            r0 = 0
        L_0x0461:
            r1.zzC = r0     // Catch:{ Exception -> 0x0513 }
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            r6 = 21
            if (r0 != r6) goto L_0x0474
            java.lang.String r0 = "OMX.google.aac.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x0474
            r0 = r17
            goto L_0x0475
        L_0x0474:
            r0 = 0
        L_0x0475:
            r1.zzD = r0     // Catch:{ Exception -> 0x0513 }
            java.lang.String r0 = r15.zza     // Catch:{ Exception -> 0x0513 }
            int r6 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            if (r6 > r3) goto L_0x0489
            java.lang.String r3 = "OMX.rk.video_decoder.avc"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            goto L_0x0489
        L_0x0486:
            r0 = r17
            goto L_0x04d7
        L_0x0489:
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x0513 }
            if (r3 > r5) goto L_0x04bd
            java.lang.String r3 = "OMX.broadcom.video_decoder.tunnel"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            java.lang.String r3 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            java.lang.String r3 = "OMX.bcm.vdec.avc.tunnel"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            java.lang.String r3 = "OMX.bcm.vdec.avc.tunnel.secure"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            java.lang.String r3 = "OMX.bcm.vdec.hevc.tunnel"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r3 != 0) goto L_0x0486
            java.lang.String r3 = "OMX.bcm.vdec.hevc.tunnel.secure"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0513 }
            if (r0 != 0) goto L_0x0486
        L_0x04bd:
            java.lang.String r0 = "Amazon"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x04d6
            java.lang.String r0 = "AFTS"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzen.zzd     // Catch:{ Exception -> 0x0513 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x04d6
            boolean r0 = r15.zzf     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x04d6
            goto L_0x0486
        L_0x04d6:
            r0 = 0
        L_0x04d7:
            r1.zzG = r0     // Catch:{ Exception -> 0x0513 }
            com.google.android.gms.internal.ads.zzsn r0 = r1.zzs     // Catch:{ Exception -> 0x0513 }
            if (r0 == 0) goto L_0x0504
            com.google.android.gms.internal.ads.zzsn r0 = (com.google.android.gms.internal.ads.zzsn) r0     // Catch:{ Exception -> 0x0513 }
            int r0 = r1.zzcV()     // Catch:{ Exception -> 0x0513 }
            if (r0 != r4) goto L_0x04f2
            com.google.android.gms.internal.ads.zzdc r0 = r1.zzi()     // Catch:{ Exception -> 0x0513 }
            long r3 = r0.zzb()     // Catch:{ Exception -> 0x0513 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 + r5
            r1.zzH = r3     // Catch:{ Exception -> 0x0513 }
        L_0x04f2:
            com.google.android.gms.internal.ads.zzhx r0 = r1.zza     // Catch:{ Exception -> 0x0513 }
            int r3 = r0.zza     // Catch:{ Exception -> 0x0513 }
            int r3 = r3 + 1
            r0.zza = r3     // Catch:{ Exception -> 0x0513 }
            long r6 = r22 - r20
            r3 = r19
            r4 = r22
            r1.zzal(r2, r3, r4, r6)     // Catch:{ Exception -> 0x0513 }
            goto L_0x0544
        L_0x0504:
            throw r18     // Catch:{ Exception -> 0x0513 }
        L_0x0505:
            r0 = move-exception
            r18 = r13
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0513 }
            throw r0     // Catch:{ Exception -> 0x0513 }
        L_0x050c:
            r0 = move-exception
            goto L_0x0518
        L_0x050e:
            r17 = r10
            r18 = r13
            throw r18     // Catch:{ Exception -> 0x0513 }
        L_0x0513:
            r0 = move-exception
            goto L_0x051a
        L_0x0515:
            r0 = move-exception
            r17 = r10
        L_0x0518:
            r18 = r13
        L_0x051a:
            java.lang.String r2 = r15.zza     // Catch:{ zzsu -> 0x0564 }
            java.lang.String r3 = "Failed to initialize decoder: "
            java.lang.String r2 = r3.concat(r2)     // Catch:{ zzsu -> 0x0564 }
            com.google.android.gms.internal.ads.zzdt.zzg(r8, r2, r0)     // Catch:{ zzsu -> 0x0564 }
            r14.removeFirst()     // Catch:{ zzsu -> 0x0564 }
            com.google.android.gms.internal.ads.zzsu r2 = new com.google.android.gms.internal.ads.zzsu     // Catch:{ zzsu -> 0x0564 }
            r3 = 0
            r2.<init>((com.google.android.gms.internal.ads.zzad) r12, (java.lang.Throwable) r0, (boolean) r3, (com.google.android.gms.internal.ads.zzsq) r15)     // Catch:{ zzsu -> 0x0564 }
            r1.zzak(r2)     // Catch:{ zzsu -> 0x0564 }
            com.google.android.gms.internal.ads.zzsu r0 = r1.zzy     // Catch:{ zzsu -> 0x0564 }
            if (r0 != 0) goto L_0x0538
            r1.zzy = r2     // Catch:{ zzsu -> 0x0564 }
            goto L_0x053e
        L_0x0538:
            com.google.android.gms.internal.ads.zzsu r0 = com.google.android.gms.internal.ads.zzsu.zza(r0, r2)     // Catch:{ zzsu -> 0x0564 }
            r1.zzy = r0     // Catch:{ zzsu -> 0x0564 }
        L_0x053e:
            boolean r0 = r14.isEmpty()     // Catch:{ zzsu -> 0x0564 }
            if (r0 != 0) goto L_0x054b
        L_0x0544:
            r10 = r17
            r13 = r18
            r11 = 0
            goto L_0x00ab
        L_0x054b:
            com.google.android.gms.internal.ads.zzsu r0 = r1.zzy     // Catch:{ zzsu -> 0x0564 }
            throw r0     // Catch:{ zzsu -> 0x0564 }
        L_0x054e:
            r18 = r13
            throw r18     // Catch:{ zzsu -> 0x0564 }
        L_0x0551:
            r2 = r13
            r1.zzx = r2     // Catch:{ zzsu -> 0x0564 }
            goto L_0x056d
        L_0x0555:
            r2 = r13
            throw r2     // Catch:{ zzsu -> 0x0564 }
        L_0x0557:
            r2 = r13
            com.google.android.gms.internal.ads.zzsu r0 = new com.google.android.gms.internal.ads.zzsu     // Catch:{ zzsu -> 0x0564 }
            r3 = -49999(0xffffffffffff3cb1, float:NaN)
            r4 = 0
            r0.<init>((com.google.android.gms.internal.ads.zzad) r12, (java.lang.Throwable) r2, (boolean) r4, (int) r3)     // Catch:{ zzsu -> 0x0564 }
            throw r0     // Catch:{ zzsu -> 0x0564 }
        L_0x0562:
            r2 = r13
            throw r2     // Catch:{ zzsu -> 0x0564 }
        L_0x0564:
            r0 = move-exception
            r2 = 4001(0xfa1, float:5.607E-42)
            r3 = 0
            com.google.android.gms.internal.ads.zzig r0 = r1.zzcY(r0, r9, r3, r2)
            throw r0
        L_0x056d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zzaC():void");
    }

    /* access modifiers changed from: protected */
    public void zzaD(long j) {
        this.zzad = j;
        while (!this.zzk.isEmpty() && j >= ((zzsw) this.zzk.peek()).zzb) {
            zzsw zzsw = (zzsw) this.zzk.poll();
            zzsw.getClass();
            zzsw zzsw2 = zzsw;
            zzaR(zzsw);
            zzap();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaE(zzhm zzhm) throws zzig {
    }

    /* access modifiers changed from: protected */
    public void zzaF(zzad zzad2) throws zzig {
    }

    /* access modifiers changed from: protected */
    public final void zzaG() {
        try {
            zzsn zzsn = this.zzs;
            if (zzsn != null) {
                zzsn.zzm();
                this.zza.zzb++;
                zzsq zzsq = this.zzz;
                if (zzsq != null) {
                    zzsq zzsq2 = zzsq;
                    zzam(zzsq.zza);
                } else {
                    throw null;
                }
            }
        } finally {
            this.zzs = null;
            this.zzp = null;
            this.zzaf = null;
            zzaI();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaH() {
        zzao();
        zzaQ();
        this.zzH = -9223372036854775807L;
        this.zzV = false;
        this.zzU = false;
        this.zzE = false;
        this.zzF = false;
        this.zzL = false;
        this.zzM = false;
        this.zzX = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzS = 0;
        this.zzT = 0;
        this.zzR = this.zzQ ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzaI() {
        zzaH();
        this.zzx = null;
        this.zzz = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = false;
        this.zzW = false;
        this.zzw = -1.0f;
        this.zzA = 0;
        this.zzB = false;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzQ = false;
        this.zzR = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaJ() throws zzig {
        boolean zzaK = zzaK();
        if (zzaK) {
            zzaC();
        }
        return zzaK;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaK() {
        if (this.zzs == null) {
            return false;
        }
        int i = this.zzT;
        if (i == 3 || ((this.zzB && !this.zzW) || (this.zzC && this.zzV))) {
            zzaG();
            return true;
        }
        if (i == 2) {
            zzdb.zzf(zzen.zza >= 23);
            if (zzen.zza >= 23) {
                try {
                    zzaS();
                } catch (zzig e) {
                    zzdt.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaG();
                    return true;
                }
            }
        }
        zzah();
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaL() {
        return this.zzN;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaM(zzad zzad2) {
        return this.zzag == null && zzas(zzad2);
    }

    /* access modifiers changed from: protected */
    public boolean zzaN(zzsq zzsq) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzaO(zzhm zzhm) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int zzaa(zzta zzta, zzad zzad2) throws zztf;

    /* access modifiers changed from: protected */
    public zzhy zzab(zzsq zzsq, zzad zzad2, zzad zzad3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        if (zzaT() == false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
        if (zzaT() == false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cc, code lost:
        if (zzaT() == false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzhy zzac(com.google.android.gms.internal.ads.zzkj r12) throws com.google.android.gms.internal.ads.zzig {
        /*
            r11 = this;
            r0 = 1
            r11.zzab = r0
            com.google.android.gms.internal.ads.zzad r1 = r12.zza
            r1.getClass()
            r2 = r1
            com.google.android.gms.internal.ads.zzad r2 = (com.google.android.gms.internal.ads.zzad) r2
            java.lang.String r2 = r1.zzo
            r3 = 0
            if (r2 == 0) goto L_0x0107
            java.lang.String r4 = "video/av01"
            boolean r2 = java.util.Objects.equals(r2, r4)
            r4 = 0
            if (r2 == 0) goto L_0x002c
            java.util.List r2 = r1.zzr
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzab r1 = r1.zzb()
            r1.zzM(r4)
            com.google.android.gms.internal.ads.zzad r1 = r1.zzaf()
        L_0x002c:
            r8 = r1
            com.google.android.gms.internal.ads.zzrq r12 = r12.zzb
            r11.zzag = r12
            r11.zzm = r8
            boolean r12 = r11.zzN
            if (r12 == 0) goto L_0x003a
            r11.zzP = r0
            return r4
        L_0x003a:
            com.google.android.gms.internal.ads.zzsn r12 = r11.zzs
            if (r12 != 0) goto L_0x0044
            r11.zzx = r4
            r11.zzaC()
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzsq r1 = r11.zzz
            r1.getClass()
            r2 = r1
            com.google.android.gms.internal.ads.zzsq r2 = (com.google.android.gms.internal.ads.zzsq) r2
            com.google.android.gms.internal.ads.zzad r7 = r11.zzt
            r7.getClass()
            r2 = r7
            com.google.android.gms.internal.ads.zzad r2 = (com.google.android.gms.internal.ads.zzad) r2
            com.google.android.gms.internal.ads.zzrq r2 = r11.zzaf
            com.google.android.gms.internal.ads.zzrq r4 = r11.zzag
            if (r2 != r4) goto L_0x00f9
            if (r4 == r2) goto L_0x005e
            r2 = r0
            goto L_0x005f
        L_0x005e:
            r2 = r3
        L_0x005f:
            if (r2 == 0) goto L_0x006a
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            r5 = 23
            if (r4 < r5) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r4 = r3
            goto L_0x006b
        L_0x006a:
            r4 = r0
        L_0x006b:
            com.google.android.gms.internal.ads.zzdb.zzf(r4)
            com.google.android.gms.internal.ads.zzhy r4 = r11.zzab(r1, r7, r8)
            int r5 = r4.zzd
            r6 = 3
            if (r5 == 0) goto L_0x00df
            r9 = 16
            r10 = 2
            if (r5 == r0) goto L_0x00bc
            if (r5 == r10) goto L_0x0090
            boolean r0 = r11.zzaX(r8)
            if (r0 != 0) goto L_0x0085
            goto L_0x00c2
        L_0x0085:
            r11.zzt = r8
            if (r2 == 0) goto L_0x00e2
            boolean r0 = r11.zzaT()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00e3
        L_0x0090:
            boolean r5 = r11.zzaX(r8)
            if (r5 != 0) goto L_0x0097
            goto L_0x00c2
        L_0x0097:
            r11.zzQ = r0
            r11.zzR = r0
            int r5 = r11.zzA
            if (r5 == r10) goto L_0x00af
            if (r5 != r0) goto L_0x00ae
            int r5 = r8.zzu
            int r9 = r7.zzu
            if (r5 != r9) goto L_0x00ae
            int r5 = r8.zzv
            int r9 = r7.zzv
            if (r5 != r9) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r0 = r3
        L_0x00af:
            r11.zzE = r0
            r11.zzt = r8
            if (r2 == 0) goto L_0x00e2
            boolean r0 = r11.zzaT()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00bc:
            boolean r5 = r11.zzaX(r8)
            if (r5 != 0) goto L_0x00c4
        L_0x00c2:
            r10 = r9
            goto L_0x00e3
        L_0x00c4:
            r11.zzt = r8
            if (r2 == 0) goto L_0x00cf
            boolean r0 = r11.zzaT()
            if (r0 != 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00cf:
            boolean r2 = r11.zzU
            if (r2 == 0) goto L_0x00e2
            r11.zzS = r0
            boolean r2 = r11.zzC
            if (r2 == 0) goto L_0x00dc
            r11.zzT = r6
            goto L_0x00e3
        L_0x00dc:
            r11.zzT = r0
            goto L_0x00e2
        L_0x00df:
            r11.zzae()
        L_0x00e2:
            r10 = r3
        L_0x00e3:
            int r0 = r4.zzd
            if (r0 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzsn r0 = r11.zzs
            if (r0 != r12) goto L_0x00ef
            int r12 = r11.zzT
            if (r12 != r6) goto L_0x00f8
        L_0x00ef:
            java.lang.String r6 = r1.zza
            com.google.android.gms.internal.ads.zzhy r5 = new com.google.android.gms.internal.ads.zzhy
            r9 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            return r5
        L_0x00f8:
            return r4
        L_0x00f9:
            r11.zzae()
            java.lang.String r6 = r1.zza
            com.google.android.gms.internal.ads.zzhy r5 = new com.google.android.gms.internal.ads.zzhy
            r9 = 0
            r10 = 128(0x80, float:1.794E-43)
            r5.<init>(r6, r7, r8, r9, r10)
            return r5
        L_0x0107:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzig r12 = r11.zzcY(r12, r1, r3, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsy.zzac(com.google.android.gms.internal.ads.zzkj):com.google.android.gms.internal.ads.zzhy");
    }

    /* access modifiers changed from: protected */
    public abstract zzsk zzaf(zzsq zzsq, zzad zzad2, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List zzag(zzta zzta, zzad zzad2, boolean z) throws zztf;

    /* access modifiers changed from: protected */
    public void zzaj(zzhm zzhm) throws zzig {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzak(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzal(String str, zzsk zzsk, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzam(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzan(zzad zzad2, MediaFormat mediaFormat) throws zzig {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzap() {
    }

    /* access modifiers changed from: protected */
    public void zzaq() throws zzig {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzar(long j, long j2, zzsn zzsn, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzad zzad2) throws zzig;

    /* access modifiers changed from: protected */
    public boolean zzas(zzad zzad2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final float zzat() {
        return this.zzq;
    }

    /* access modifiers changed from: protected */
    public int zzau(zzhm zzhm) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzav() {
        return this.zzac.zzd;
    }

    /* access modifiers changed from: protected */
    public final long zzaw() {
        return this.zzac.zzc;
    }

    /* access modifiers changed from: protected */
    public final zzlm zzay() {
        return this.zzo;
    }

    /* access modifiers changed from: protected */
    public final zzsn zzaz() {
        return this.zzs;
    }

    public final int zze() {
        return 8;
    }

    public void zzu(int i, Object obj) throws zzig {
        if (i == 11) {
            this.zzo = (zzlm) obj;
        }
    }

    /* access modifiers changed from: protected */
    public void zzx() {
        this.zzm = null;
        zzaR(zzsw.zza);
        this.zzk.clear();
        zzaK();
    }

    /* access modifiers changed from: protected */
    public void zzy(boolean z, boolean z2) throws zzig {
        this.zza = new zzhx();
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zzig {
        this.zzZ = false;
        this.zzaa = false;
        if (this.zzN) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzO = false;
            this.zzl.zzb();
        } else {
            zzaJ();
        }
        zzej zzej = this.zzac.zze;
        if (zzej.zza() > 0) {
            this.zzab = true;
        }
        zzej.zze();
        this.zzk.clear();
    }

    private final void zzaS() throws zzig {
        zzrq zzrq = this.zzag;
        zzrq.getClass();
        zzrq zzrq2 = zzrq;
        this.zzaf = zzrq;
        this.zzS = 0;
        this.zzT = 0;
    }

    private final void zzai() throws zzig {
        int i = this.zzT;
        if (i == 1) {
            zzah();
        } else if (i == 2) {
            zzah();
            zzaS();
        } else if (i != 3) {
            this.zzaa = true;
            zzaq();
        } else {
            zzaG();
            zzaC();
        }
    }
}
