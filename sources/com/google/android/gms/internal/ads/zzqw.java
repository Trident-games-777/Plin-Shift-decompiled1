package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.compose.animation.core.AnimationKt;
import androidx.work.PeriodicWorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzqw implements zzpu {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private boolean zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private long zzI;
    private float zzJ;
    private ByteBuffer zzK;
    private int zzL;
    private ByteBuffer zzM;
    private boolean zzN;
    private boolean zzO;
    /* access modifiers changed from: private */
    public boolean zzP;
    private boolean zzQ;
    private int zzR;
    private zzh zzS;
    private zzow zzT;
    /* access modifiers changed from: private */
    public long zzU;
    private boolean zzV;
    private boolean zzW;
    private Looper zzX;
    private long zzY;
    private long zzZ;
    private Handler zzaa;
    private final zzqm zzab;
    private final zzqc zzac;
    private final Context zzd;
    private final zzpz zze;
    private final zzrg zzf;
    private final zzfzo zzg;
    private final zzfzo zzh;
    private final zzpy zzi;
    private final ArrayDeque zzj;
    private zzqu zzk;
    private final zzqq zzl;
    private final zzqq zzm;
    private zzoj zzn;
    /* access modifiers changed from: private */
    public zzpr zzo;
    private zzql zzp;
    private zzql zzq;
    private zzcj zzr;
    /* access modifiers changed from: private */
    public AudioTrack zzs;
    private zzop zzt;
    private zzov zzu;
    private zzqp zzv;
    private zzg zzw;
    private zzqn zzx;
    private zzqn zzy;
    private zzbj zzz;

    /* synthetic */ zzqw(zzqk zzqk, zzqv zzqv) {
        zzop zzop;
        Context zza2 = zzqk.zza;
        this.zzd = zza2;
        zzg zzg2 = zzg.zza;
        this.zzw = zzg2;
        if (zza2 != null) {
            zzop zzop2 = zzop.zza;
            int i = zzen.zza;
            zzop = zzop.zzc(zza2, zzg2, (zzow) null);
        } else {
            zzop = zzqk.zzb;
        }
        this.zzt = zzop;
        this.zzab = zzqk.zze;
        int i2 = zzen.zza;
        zzqc zze2 = zzqk.zzf;
        zze2.getClass();
        zzqc zzqc = zze2;
        this.zzac = zze2;
        this.zzi = new zzpy(new zzqr(this, (zzqv) null));
        zzpz zzpz = new zzpz();
        this.zze = zzpz;
        zzrg zzrg = new zzrg();
        this.zzf = zzrg;
        this.zzg = zzfzo.zzq(new zzcq(), zzpz, zzrg);
        this.zzh = zzfzo.zzo(new zzrf());
        this.zzJ = 1.0f;
        this.zzR = 0;
        this.zzS = new zzh(0, 0.0f);
        this.zzy = new zzqn(zzbj.zza, 0, 0, (zzqv) null);
        this.zzz = zzbj.zza;
        this.zzA = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzqq();
        this.zzm = new zzqq();
    }

    public static /* synthetic */ void zzG(zzqw zzqw) {
        if (zzqw.zzZ >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            ((zzra) zzqw.zzo).zza.zzn = true;
            zzqw.zzZ = 0;
        }
    }

    static /* synthetic */ void zzI(AudioTrack audioTrack, zzpr zzpr, Handler handler, zzpo zzpo) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzpr != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzqg(zzpr, zzpo));
            }
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzpr != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzqg(zzpr, zzpo));
            }
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzK() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final long zzL() {
        zzql zzql = this.zzq;
        return zzql.zzc == 0 ? this.zzB / ((long) zzql.zzb) : this.zzC;
    }

    /* access modifiers changed from: private */
    public final long zzM() {
        zzql zzql = this.zzq;
        if (zzql.zzc != 0) {
            return this.zzE;
        }
        long j = this.zzD;
        long j2 = (long) zzql.zzd;
        int i = zzen.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzN(zzql zzql) throws zzpq {
        try {
            return zzql.zza(this.zzw, this.zzR);
        } catch (zzpq e) {
            zzpr zzpr = this.zzo;
            if (zzpr != null) {
                zzpr.zza(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) {
        zzbj zzbj;
        boolean z;
        if (zzab()) {
            zzqm zzqm = this.zzab;
            zzbj = this.zzz;
            zzqm.zzc(zzbj);
        } else {
            zzbj = zzbj.zza;
        }
        zzbj zzbj2 = zzbj;
        this.zzz = zzbj2;
        if (zzab()) {
            zzqm zzqm2 = this.zzab;
            z = this.zzA;
            zzqm2.zzd(z);
        } else {
            z = false;
        }
        this.zzA = z;
        this.zzj.add(new zzqn(zzbj2, Math.max(0, j), zzen.zzt(zzM(), this.zzq.zze), (zzqv) null));
        zzX();
        zzpr zzpr = this.zzo;
        if (zzpr != null) {
            ((zzra) zzpr).zza.zzc.zzw(this.zzA);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzP(long r8) throws com.google.android.gms.internal.ads.zzpt {
        /*
            r7 = this;
            java.nio.ByteBuffer r8 = r7.zzM
            if (r8 != 0) goto L_0x0006
            goto L_0x00b5
        L_0x0006:
            com.google.android.gms.internal.ads.zzqq r8 = r7.zzm
            boolean r8 = r8.zzc()
            if (r8 != 0) goto L_0x00b5
            java.nio.ByteBuffer r8 = r7.zzM
            int r8 = r8.remaining()
            android.media.AudioTrack r9 = r7.zzs
            java.nio.ByteBuffer r0 = r7.zzM
            r1 = 1
            int r9 = r9.write(r0, r8, r1)
            long r2 = android.os.SystemClock.elapsedRealtime()
            r7.zzU = r2
            r2 = 0
            r0 = 0
            if (r9 >= 0) goto L_0x006a
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            r4 = 24
            if (r8 < r4) goto L_0x0031
            r8 = -6
            if (r9 == r8) goto L_0x0035
        L_0x0031:
            r8 = -32
            if (r9 != r8) goto L_0x004a
        L_0x0035:
            long r4 = r7.zzM()
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x003e
            goto L_0x004b
        L_0x003e:
            android.media.AudioTrack r8 = r7.zzs
            boolean r8 = zzaa(r8)
            if (r8 == 0) goto L_0x004a
            r7.zzQ()
            goto L_0x004b
        L_0x004a:
            r1 = r0
        L_0x004b:
            com.google.android.gms.internal.ads.zzpt r8 = new com.google.android.gms.internal.ads.zzpt
            com.google.android.gms.internal.ads.zzql r0 = r7.zzq
            com.google.android.gms.internal.ads.zzad r0 = r0.zza
            r8.<init>(r9, r0, r1)
            com.google.android.gms.internal.ads.zzpr r9 = r7.zzo
            if (r9 == 0) goto L_0x005b
            r9.zza(r8)
        L_0x005b:
            boolean r9 = r8.zzb
            if (r9 != 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzqq r9 = r7.zzm
            r9.zzb(r8)
            return
        L_0x0065:
            com.google.android.gms.internal.ads.zzop r9 = com.google.android.gms.internal.ads.zzop.zza
            r7.zzt = r9
            throw r8
        L_0x006a:
            com.google.android.gms.internal.ads.zzqq r4 = r7.zzm
            r4.zza()
            android.media.AudioTrack r4 = r7.zzs
            boolean r4 = zzaa(r4)
            if (r4 == 0) goto L_0x008b
            long r4 = r7.zzE
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x007f
            r7.zzW = r0
        L_0x007f:
            boolean r2 = r7.zzQ
            if (r2 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzpr r2 = r7.zzo
            if (r2 == 0) goto L_0x008b
            if (r9 >= r8) goto L_0x008b
            com.google.android.gms.internal.ads.zzra r2 = (com.google.android.gms.internal.ads.zzra) r2
        L_0x008b:
            com.google.android.gms.internal.ads.zzql r2 = r7.zzq
            int r2 = r2.zzc
            if (r2 != 0) goto L_0x0097
            long r3 = r7.zzD
            long r5 = (long) r9
            long r3 = r3 + r5
            r7.zzD = r3
        L_0x0097:
            if (r9 != r8) goto L_0x00b5
            if (r2 == 0) goto L_0x00b2
            java.nio.ByteBuffer r8 = r7.zzM
            java.nio.ByteBuffer r9 = r7.zzK
            if (r8 != r9) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r1 = r0
        L_0x00a3:
            com.google.android.gms.internal.ads.zzdb.zzf(r1)
            long r8 = r7.zzE
            int r0 = r7.zzF
            long r0 = (long) r0
            int r2 = r7.zzL
            long r2 = (long) r2
            long r0 = r0 * r2
            long r8 = r8 + r0
            r7.zzE = r8
        L_0x00b2:
            r8 = 0
            r7.zzM = r8
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqw.zzP(long):void");
    }

    private final void zzQ() {
        if (this.zzq.zzc()) {
            this.zzV = true;
        }
    }

    private final void zzR() {
        if (this.zzu == null && this.zzd != null) {
            this.zzX = Looper.myLooper();
            zzov zzov = new zzov(this.zzd, new zzqf(this), this.zzw, this.zzT);
            this.zzu = zzov;
            this.zzt = zzov.zzc();
        }
    }

    private final void zzS() {
        if (!this.zzO) {
            this.zzO = true;
            this.zzi.zzb(zzM());
            if (zzaa(this.zzs)) {
                this.zzP = false;
            }
            this.zzs.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r0 = r2.zzK;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r0.hasRemaining() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        r2.zzr.zze(r2.zzK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzT(long r3) throws com.google.android.gms.internal.ads.zzpt {
        /*
            r2 = this;
            r2.zzP(r3)
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 == 0) goto L_0x0008
            goto L_0x004b
        L_0x0008:
            com.google.android.gms.internal.ads.zzcj r0 = r2.zzr
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x0041
        L_0x0010:
            com.google.android.gms.internal.ads.zzcj r0 = r2.zzr
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x004b
        L_0x0018:
            com.google.android.gms.internal.ads.zzcj r0 = r2.zzr
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x002f
            r2.zzV(r0)
            r2.zzP(r3)
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 == 0) goto L_0x0018
            goto L_0x004b
        L_0x002f:
            java.nio.ByteBuffer r0 = r2.zzK
            if (r0 == 0) goto L_0x004b
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzcj r0 = r2.zzr
            java.nio.ByteBuffer r1 = r2.zzK
            r0.zze(r1)
            goto L_0x0010
        L_0x0041:
            java.nio.ByteBuffer r0 = r2.zzK
            if (r0 == 0) goto L_0x004b
            r2.zzV(r0)
            r2.zzP(r3)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqw.zzT(long):void");
    }

    private final void zzU(zzbj zzbj) {
        zzqn zzqn = new zzqn(zzbj, -9223372036854775807L, -9223372036854775807L, (zzqv) null);
        if (zzZ()) {
            this.zzx = zzqn;
        } else {
            this.zzy = zzqn;
        }
    }

    private final void zzV(ByteBuffer byteBuffer) {
        zzdb.zzf(this.zzM == null);
        if (byteBuffer.hasRemaining()) {
            this.zzM = byteBuffer;
        }
    }

    private final void zzW() {
        if (zzZ()) {
            this.zzs.setVolume(this.zzJ);
        }
    }

    private final void zzX() {
        zzcj zzcj = this.zzq.zzi;
        this.zzr = zzcj;
        zzcj.zzc();
    }

    private final boolean zzY() throws zzpt {
        if (!this.zzr.zzh()) {
            zzP(Long.MIN_VALUE);
            return this.zzM == null;
        }
        this.zzr.zzd();
        zzT(Long.MIN_VALUE);
        if (!this.zzr.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzM;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    private final boolean zzZ() {
        return this.zzs != null;
    }

    private static boolean zzaa(AudioTrack audioTrack) {
        return zzen.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzab() {
        zzql zzql = this.zzq;
        if (zzql.zzc != 0) {
            return false;
        }
        int i = zzql.zza.zzE;
        return true;
    }

    public final boolean zzA(zzad zzad) {
        return zza(zzad) != 0;
    }

    public final void zzJ(zzop zzop) {
        String str;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zzX;
        if (looper != myLooper) {
            String str2 = "null";
            if (looper == null) {
                str = str2;
            } else {
                str = looper.getThread().getName();
            }
            if (myLooper != null) {
                str2 = myLooper.getThread().getName();
            }
            throw new IllegalStateException("Current looper (" + str2 + ") is not the playback looper (" + str + ")");
        } else if (!zzop.equals(this.zzt)) {
            this.zzt = zzop;
            zzpr zzpr = this.zzo;
            if (zzpr != null) {
                ((zzra) zzpr).zza.zzB();
            }
        }
    }

    public final int zza(zzad zzad) {
        zzR();
        if (!"audio/raw".equals(zzad.zzo)) {
            return this.zzt.zzb(zzad, this.zzw) != null ? 2 : 0;
        }
        if (!zzen.zzJ(zzad.zzE)) {
            int i = zzad.zzE;
            zzdt.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i);
            return 0;
        } else if (zzad.zzE != 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public final long zzb(boolean z) {
        long j;
        if (!zzZ() || this.zzH) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzi.zza(z), zzen.zzt(zzM(), this.zzq.zze));
        while (!this.zzj.isEmpty() && min >= ((zzqn) this.zzj.getFirst()).zzc) {
            this.zzy = (zzqn) this.zzj.remove();
        }
        long j2 = min - this.zzy.zzc;
        if (this.zzj.isEmpty()) {
            j = this.zzy.zzb + this.zzab.zza(j2);
        } else {
            zzqn zzqn = (zzqn) this.zzj.getFirst();
            j = zzqn.zzb - zzen.zzq(zzqn.zzc - min, this.zzy.zza.zzb);
        }
        long zzb2 = this.zzab.zzb();
        long zzt2 = j + zzen.zzt(zzb2, this.zzq.zze);
        long j3 = this.zzY;
        if (zzb2 > j3) {
            long zzt3 = zzen.zzt(zzb2 - j3, this.zzq.zze);
            this.zzY = zzb2;
            this.zzZ += zzt3;
            if (this.zzaa == null) {
                this.zzaa = new Handler(Looper.myLooper());
            }
            this.zzaa.removeCallbacksAndMessages((Object) null);
            this.zzaa.postDelayed(new zzqe(this), 100);
        }
        return zzt2;
    }

    public final zzbj zzc() {
        return this.zzz;
    }

    public final zzoz zzd(zzad zzad) {
        if (this.zzV) {
            return zzoz.zza;
        }
        return this.zzac.zza(zzad, this.zzw);
    }

    public final void zze(zzad zzad, int i, int[] iArr) throws zzpp {
        zzcj zzcj;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        zzad zzad2 = zzad;
        zzR();
        if ("audio/raw".equals(zzad2.zzo)) {
            zzdb.zzd(zzen.zzJ(zzad2.zzE));
            i7 = zzen.zzk(zzad2.zzE) * zzad2.zzC;
            zzfzl zzfzl = new zzfzl();
            int i11 = zzad2.zzE;
            zzfzl.zzh(this.zzg);
            zzfzl.zzg(this.zzab.zze());
            zzcj zzcj2 = new zzcj(zzfzl.zzi());
            if (zzcj2.equals(this.zzr)) {
                zzcj2 = this.zzr;
            }
            this.zzf.zzq(zzad2.zzF, zzad2.zzG);
            this.zze.zzo(iArr);
            try {
                zzck zza2 = zzcj2.zza(new zzck(zzad2.zzD, zzad2.zzC, zzad2.zzE));
                i4 = zza2.zzd;
                i3 = zza2.zzb;
                int i12 = zza2.zzc;
                i2 = zzen.zzi(i12);
                zzcj = zzcj2;
                i5 = zzen.zzk(i4) * i12;
                i6 = 0;
            } catch (zzcl e) {
                throw new zzpp((Throwable) e, zzad2);
            }
        } else {
            zzcj zzcj3 = new zzcj(zzfzo.zzn());
            i3 = zzad2.zzD;
            zzoz zzoz = zzoz.zza;
            Pair zzb2 = this.zzt.zzb(zzad2, this.zzw);
            if (zzb2 != null) {
                i4 = ((Integer) zzb2.first).intValue();
                i2 = ((Integer) zzb2.second).intValue();
                i6 = 2;
                i7 = -1;
                zzcj = zzcj3;
                i5 = -1;
            } else {
                throw new zzpp("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzad2))), zzad2);
            }
        }
        if (i4 == 0) {
            throw new zzpp("Invalid output encoding (mode=" + i6 + ") for: " + String.valueOf(zzad2), zzad2);
        } else if (i2 != 0) {
            int i13 = zzad2.zzj;
            if ("audio/vnd.dts.hd;profile=lbr".equals(zzad2.zzo) && i13 == -1) {
                i13 = 768000;
            }
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i2, i4);
            zzdb.zzf(minBufferSize != -2);
            int i14 = i5 != -1 ? i5 : 1;
            int i15 = 250000;
            if (i6 == 0) {
                i8 = i6;
                i9 = Math.max(zzqy.zza(250000, i3, i14), Math.min(minBufferSize * 4, zzqy.zza(750000, i3, i14)));
            } else if (i6 != 1) {
                if (i4 == 5) {
                    i15 = 500000;
                } else if (i4 == 8) {
                    i15 = DurationKt.NANOS_IN_MILLIS;
                    i4 = 8;
                }
                if (i13 != -1) {
                    i10 = zzgck.zzb(i13, 8, RoundingMode.CEILING);
                } else {
                    i10 = zzqy.zzb(i4);
                }
                i8 = i6;
                i9 = zzgcr.zzb((((long) i15) * ((long) i10)) / AnimationKt.MillisToNanos);
            } else {
                i8 = i6;
                i9 = zzgcr.zzb((((long) zzqy.zzb(i4)) * 50000000) / AnimationKt.MillisToNanos);
            }
            this.zzV = false;
            zzql zzql = new zzql(zzad2, i7, i8, i5, i3, i2, i4, (((Math.max(minBufferSize, (int) ((double) i9)) + i14) - 1) / i14) * i14, zzcj, false, false, false);
            if (zzZ()) {
                this.zzp = zzql;
            } else {
                this.zzq = zzql;
            }
        } else {
            throw new zzpp("Invalid output channel config (mode=" + i6 + ") for: " + String.valueOf(zzad2), zzad2);
        }
    }

    public final void zzf() {
        zzqp zzqp;
        if (zzZ()) {
            this.zzB = 0;
            this.zzC = 0;
            this.zzD = 0;
            this.zzE = 0;
            this.zzW = false;
            this.zzF = 0;
            this.zzy = new zzqn(this.zzz, 0, 0, (zzqv) null);
            this.zzI = 0;
            this.zzx = null;
            this.zzj.clear();
            this.zzK = null;
            this.zzL = 0;
            this.zzM = null;
            this.zzO = false;
            this.zzN = false;
            this.zzP = false;
            this.zzf.zzp();
            zzX();
            if (this.zzi.zzh()) {
                this.zzs.pause();
            }
            if (zzaa(this.zzs)) {
                zzqu zzqu = this.zzk;
                zzqu.getClass();
                zzqu zzqu2 = zzqu;
                zzqu.zzb(this.zzs);
            }
            zzpo zzb2 = this.zzq.zzb();
            zzql zzql = this.zzp;
            if (zzql != null) {
                this.zzq = zzql;
                this.zzp = null;
            }
            this.zzi.zzc();
            if (zzen.zza >= 24 && (zzqp = this.zzv) != null) {
                zzqp.zzb();
                this.zzv = null;
            }
            AudioTrack audioTrack = this.zzs;
            zzpr zzpr = this.zzo;
            Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = Executors.newSingleThreadScheduledExecutor(new zzem("ExoPlayer:AudioTrackReleaseThread"));
                }
                zzc++;
                zzb.schedule(new zzqd(audioTrack, zzpr, handler, zzb2), 20, TimeUnit.MILLISECONDS);
            }
            this.zzs = null;
        }
        this.zzm.zza();
        this.zzl.zza();
        this.zzY = 0;
        this.zzZ = 0;
        Handler handler2 = this.zzaa;
        if (handler2 != null) {
            Handler handler3 = handler2;
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void zzg() {
        this.zzG = true;
    }

    public final void zzh() {
        this.zzQ = false;
        if (!zzZ()) {
            return;
        }
        if (this.zzi.zzk() || zzaa(this.zzs)) {
            this.zzs.pause();
        }
    }

    public final void zzi() {
        this.zzQ = true;
        if (zzZ()) {
            this.zzi.zzf();
            this.zzs.play();
        }
    }

    public final void zzj() throws zzpt {
        if (!this.zzN && zzZ() && zzY()) {
            zzS();
            this.zzN = true;
        }
    }

    public final void zzk() {
        zzov zzov = this.zzu;
        if (zzov != null) {
            zzov.zzi();
        }
    }

    public final void zzl() {
        zzf();
        zzfzo zzfzo = this.zzg;
        int size = zzfzo.size();
        for (int i = 0; i < size; i++) {
            ((zzcm) zzfzo.get(i)).zzf();
        }
        zzfzo zzfzo2 = this.zzh;
        int size2 = zzfzo2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzcm) zzfzo2.get(i2)).zzf();
        }
        zzcj zzcj = this.zzr;
        if (zzcj != null) {
            zzcj.zzf();
        }
        this.zzQ = false;
        this.zzV = false;
    }

    public final void zzm(zzg zzg2) {
        if (!this.zzw.equals(zzg2)) {
            this.zzw = zzg2;
            zzov zzov = this.zzu;
            if (zzov != null) {
                zzov.zzg(zzg2);
            }
            zzf();
        }
    }

    public final void zzn(int i) {
        if (this.zzR != i) {
            this.zzR = i;
            zzf();
        }
    }

    public final void zzo(zzh zzh2) {
        if (!this.zzS.equals(zzh2)) {
            if (this.zzs != null) {
                int i = this.zzS.zza;
            }
            this.zzS = zzh2;
        }
    }

    public final void zzp(zzdc zzdc) {
        this.zzi.zze(zzdc);
    }

    public final void zzq(zzpr zzpr) {
        this.zzo = zzpr;
    }

    public final void zzr(int i, int i2) {
        AudioTrack audioTrack = this.zzs;
        if (audioTrack != null) {
            zzaa(audioTrack);
        }
    }

    public final void zzs(zzbj zzbj) {
        this.zzz = new zzbj(Math.max(0.1f, Math.min(zzbj.zzb, 8.0f)), Math.max(0.1f, Math.min(zzbj.zzc, 8.0f)));
        zzU(zzbj);
    }

    public final void zzt(zzoj zzoj) {
        this.zzn = zzoj;
    }

    public final void zzv(boolean z) {
        this.zzA = z;
        zzU(this.zzz);
    }

    public final void zzw(float f) {
        if (this.zzJ != f) {
            this.zzJ = f;
            zzW();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x026e, code lost:
        r0 = com.google.android.gms.internal.ads.zzabr.zza(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzx(java.nio.ByteBuffer r31, long r32, int r34) throws com.google.android.gms.internal.ads.zzpq, com.google.android.gms.internal.ads.zzpt {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            r3 = r32
            r5 = r34
            java.nio.ByteBuffer r0 = r1.zzK
            r7 = 0
            if (r0 == 0) goto L_0x0012
            if (r2 != r0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = r7
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            com.google.android.gms.internal.ads.zzdb.zzd(r0)
            com.google.android.gms.internal.ads.zzql r0 = r1.zzp
            r8 = 0
            if (r0 == 0) goto L_0x006f
            boolean r0 = r1.zzY()
            if (r0 != 0) goto L_0x0022
            return r7
        L_0x0022:
            com.google.android.gms.internal.ads.zzql r0 = r1.zzp
            com.google.android.gms.internal.ads.zzql r9 = r1.zzq
            int r10 = r9.zzc
            int r11 = r0.zzc
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzg
            int r11 = r0.zzg
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zze
            int r11 = r0.zze
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzf
            int r11 = r0.zzf
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzd
            int r11 = r0.zzd
            if (r10 != r11) goto L_0x005f
            boolean r10 = r9.zzj
            boolean r10 = r0.zzj
            boolean r9 = r9.zzk
            boolean r9 = r0.zzk
            r1.zzq = r0
            r1.zzp = r8
            android.media.AudioTrack r0 = r1.zzs
            if (r0 == 0) goto L_0x006c
            boolean r0 = zzaa(r0)
            if (r0 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq
            boolean r0 = r0.zzk
            goto L_0x006c
        L_0x005f:
            r1.zzS()
            boolean r0 = r1.zzy()
            if (r0 == 0) goto L_0x0069
            return r7
        L_0x0069:
            r1.zzf()
        L_0x006c:
            r1.zzO(r3)
        L_0x006f:
            boolean r0 = r1.zzZ()
            if (r0 == 0) goto L_0x0077
            goto L_0x0168
        L_0x0077:
            com.google.android.gms.internal.ads.zzqq r0 = r1.zzl     // Catch:{ zzpq -> 0x03e2 }
            boolean r0 = r0.zzc()     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x0080
            return r7
        L_0x0080:
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq     // Catch:{ zzpq -> 0x008d }
            if (r0 == 0) goto L_0x008c
            r11 = r0
            com.google.android.gms.internal.ads.zzql r11 = (com.google.android.gms.internal.ads.zzql) r11     // Catch:{ zzpq -> 0x008d }
            android.media.AudioTrack r0 = r1.zzN(r0)     // Catch:{ zzpq -> 0x008d }
            goto L_0x00d0
        L_0x008c:
            throw r8     // Catch:{ zzpq -> 0x008d }
        L_0x008d:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq     // Catch:{ zzpq -> 0x03e2 }
            int r12 = r0.zzh     // Catch:{ zzpq -> 0x03e2 }
            r13 = 1000000(0xf4240, float:1.401298E-39)
            if (r12 <= r13) goto L_0x03de
            com.google.android.gms.internal.ads.zzql r14 = new com.google.android.gms.internal.ads.zzql     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzad r15 = r0.zza     // Catch:{ zzpq -> 0x03e2 }
            int r12 = r0.zzb     // Catch:{ zzpq -> 0x03e2 }
            int r13 = r0.zzc     // Catch:{ zzpq -> 0x03e2 }
            int r8 = r0.zzd     // Catch:{ zzpq -> 0x03e2 }
            int r7 = r0.zze     // Catch:{ zzpq -> 0x03e2 }
            int r6 = r0.zzf     // Catch:{ zzpq -> 0x03e2 }
            int r10 = r0.zzg     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzcj r9 = r0.zzi     // Catch:{ zzpq -> 0x03e2 }
            r20 = r6
            boolean r6 = r0.zzj     // Catch:{ zzpq -> 0x03e2 }
            boolean r6 = r0.zzk     // Catch:{ zzpq -> 0x03e2 }
            boolean r0 = r0.zzl     // Catch:{ zzpq -> 0x03e2 }
            r25 = 0
            r26 = 0
            r22 = 1000000(0xf4240, float:1.401298E-39)
            r24 = 0
            r19 = r7
            r18 = r8
            r23 = r9
            r21 = r10
            r16 = r12
            r17 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ zzpq -> 0x03e2 }
            android.media.AudioTrack r0 = r1.zzN(r14)     // Catch:{ zzpq -> 0x03da }
            r1.zzq = r14     // Catch:{ zzpq -> 0x03da }
        L_0x00d0:
            r1.zzs = r0     // Catch:{ zzpq -> 0x03e2 }
            boolean r0 = zzaa(r0)     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x00ee
            android.media.AudioTrack r0 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzqu r6 = r1.zzk     // Catch:{ zzpq -> 0x03e2 }
            if (r6 != 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzqu r6 = new com.google.android.gms.internal.ads.zzqu     // Catch:{ zzpq -> 0x03e2 }
            r6.<init>(r1)     // Catch:{ zzpq -> 0x03e2 }
            r1.zzk = r6     // Catch:{ zzpq -> 0x03e2 }
        L_0x00e5:
            com.google.android.gms.internal.ads.zzqu r6 = r1.zzk     // Catch:{ zzpq -> 0x03e2 }
            r6.zza(r0)     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq     // Catch:{ zzpq -> 0x03e2 }
            boolean r0 = r0.zzk     // Catch:{ zzpq -> 0x03e2 }
        L_0x00ee:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zzpq -> 0x03e2 }
            r6 = 31
            if (r0 < r6) goto L_0x00fd
            com.google.android.gms.internal.ads.zzoj r0 = r1.zzn     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x00fd
            android.media.AudioTrack r6 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzqi.zza(r6, r0)     // Catch:{ zzpq -> 0x03e2 }
        L_0x00fd:
            android.media.AudioTrack r0 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            int r0 = r0.getAudioSessionId()     // Catch:{ zzpq -> 0x03e2 }
            r1.zzR = r0     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzpy r6 = r1.zzi     // Catch:{ zzpq -> 0x03e2 }
            android.media.AudioTrack r7 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq     // Catch:{ zzpq -> 0x03e2 }
            int r8 = r0.zzc     // Catch:{ zzpq -> 0x03e2 }
            r9 = 2
            if (r8 != r9) goto L_0x0112
            r8 = 1
            goto L_0x0113
        L_0x0112:
            r8 = 0
        L_0x0113:
            int r9 = r0.zzg     // Catch:{ zzpq -> 0x03e2 }
            int r10 = r0.zzd     // Catch:{ zzpq -> 0x03e2 }
            int r11 = r0.zzh     // Catch:{ zzpq -> 0x03e2 }
            r6.zzd(r7, r8, r9, r10, r11)     // Catch:{ zzpq -> 0x03e2 }
            r1.zzW()     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzh r0 = r1.zzS     // Catch:{ zzpq -> 0x03e2 }
            int r0 = r0.zza     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzow r0 = r1.zzT     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x013d
            int r6 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zzpq -> 0x03e2 }
            r7 = 23
            if (r6 < r7) goto L_0x013d
            android.media.AudioTrack r6 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzqh.zza(r6, r0)     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzov r0 = r1.zzu     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x013d
            com.google.android.gms.internal.ads.zzow r6 = r1.zzT     // Catch:{ zzpq -> 0x03e2 }
            android.media.AudioDeviceInfo r6 = r6.zza     // Catch:{ zzpq -> 0x03e2 }
            r0.zzh(r6)     // Catch:{ zzpq -> 0x03e2 }
        L_0x013d:
            int r0 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zzpq -> 0x03e2 }
            r6 = 24
            if (r0 < r6) goto L_0x0150
            com.google.android.gms.internal.ads.zzov r0 = r1.zzu     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x0150
            com.google.android.gms.internal.ads.zzqp r6 = new com.google.android.gms.internal.ads.zzqp     // Catch:{ zzpq -> 0x03e2 }
            android.media.AudioTrack r7 = r1.zzs     // Catch:{ zzpq -> 0x03e2 }
            r6.<init>(r7, r0)     // Catch:{ zzpq -> 0x03e2 }
            r1.zzv = r6     // Catch:{ zzpq -> 0x03e2 }
        L_0x0150:
            r6 = 1
            r1.zzH = r6     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzpr r0 = r1.zzo     // Catch:{ zzpq -> 0x03e2 }
            if (r0 == 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzql r6 = r1.zzq     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzpo r6 = r6.zzb()     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzra r0 = (com.google.android.gms.internal.ads.zzra) r0     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzrc r0 = r0.zza     // Catch:{ zzpq -> 0x03e2 }
            com.google.android.gms.internal.ads.zzpm r0 = r0.zzc     // Catch:{ zzpq -> 0x03e2 }
            r0.zzc(r6)     // Catch:{ zzpq -> 0x03e2 }
        L_0x0168:
            com.google.android.gms.internal.ads.zzqq r0 = r1.zzl
            r0.zza()
            boolean r0 = r1.zzH
            r6 = 0
            if (r0 == 0) goto L_0x0188
            long r8 = java.lang.Math.max(r6, r3)
            r1.zzI = r8
            r8 = 0
            r1.zzG = r8
            r1.zzH = r8
            r1.zzO(r3)
            boolean r0 = r1.zzQ
            if (r0 == 0) goto L_0x0188
            r1.zzi()
        L_0x0188:
            com.google.android.gms.internal.ads.zzpy r0 = r1.zzi
            long r8 = r1.zzM()
            boolean r0 = r0.zzj(r8)
            if (r0 != 0) goto L_0x0197
            r27 = 0
            return r27
        L_0x0197:
            java.nio.ByteBuffer r0 = r1.zzK
            if (r0 != 0) goto L_0x03ab
            java.nio.ByteOrder r0 = r2.order()
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r8) goto L_0x01a5
            r0 = 1
            goto L_0x01a6
        L_0x01a5:
            r0 = 0
        L_0x01a6:
            com.google.android.gms.internal.ads.zzdb.zzd(r0)
            boolean r0 = r2.hasRemaining()
            if (r0 != 0) goto L_0x01b2
            r28 = 1
            return r28
        L_0x01b2:
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq
            int r8 = r0.zzc
            if (r8 == 0) goto L_0x031a
            int r8 = r1.zzF
            if (r8 != 0) goto L_0x031a
            int r0 = r0.zzg
            r8 = 20
            if (r0 == r8) goto L_0x030e
            r8 = 30
            r9 = -2
            r10 = 1024(0x400, float:1.435E-42)
            r11 = -1
            if (r0 == r8) goto L_0x0276
            switch(r0) {
                case 5: goto L_0x026e;
                case 6: goto L_0x026e;
                case 7: goto L_0x0276;
                case 8: goto L_0x0276;
                case 9: goto L_0x0259;
                case 10: goto L_0x0257;
                case 11: goto L_0x0254;
                case 12: goto L_0x0254;
                default: goto L_0x01cd;
            }
        L_0x01cd:
            r8 = 16
            switch(r0) {
                case 14: goto L_0x0205;
                case 15: goto L_0x0201;
                case 16: goto L_0x0257;
                case 17: goto L_0x01e6;
                case 18: goto L_0x026e;
                default: goto L_0x01d2;
            }
        L_0x01d2:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected audio encoding: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01e6:
            int r0 = com.google.android.gms.internal.ads.zzabu.zza
            byte[] r0 = new byte[r8]
            int r9 = r2.position()
            r2.get(r0)
            r2.position(r9)
            com.google.android.gms.internal.ads.zzec r9 = new com.google.android.gms.internal.ads.zzec
            r9.<init>(r0, r8)
            com.google.android.gms.internal.ads.zzabs r0 = com.google.android.gms.internal.ads.zzabu.zza(r9)
            int r0 = r0.zzc
            goto L_0x0272
        L_0x0201:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0272
        L_0x0205:
            int r0 = com.google.android.gms.internal.ads.zzabr.zza
            int r0 = r2.position()
            int r10 = r2.limit()
            int r10 = r10 + -10
            r12 = r0
        L_0x0212:
            if (r12 > r10) goto L_0x0225
            int r13 = r12 + 4
            int r13 = com.google.android.gms.internal.ads.zzen.zzj(r2, r13)
            r13 = r13 & r9
            r14 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r13 != r14) goto L_0x0222
            int r12 = r12 - r0
            goto L_0x0226
        L_0x0222:
            int r12 = r12 + 1
            goto L_0x0212
        L_0x0225:
            r12 = r11
        L_0x0226:
            if (r12 != r11) goto L_0x022a
            r0 = 0
            goto L_0x0272
        L_0x022a:
            int r0 = r2.position()
            int r0 = r0 + r12
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r9 = r2.position()
            int r9 = r9 + r12
            r10 = 187(0xbb, float:2.62E-43)
            if (r0 != r10) goto L_0x0243
            r0 = 9
            goto L_0x0245
        L_0x0243:
            r0 = 8
        L_0x0245:
            int r9 = r9 + r0
            byte r0 = r2.get(r9)
            int r0 = r0 >> 4
            r0 = r0 & 7
            r9 = 40
            int r0 = r9 << r0
            int r0 = r0 * r8
            goto L_0x0272
        L_0x0254:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0272
        L_0x0257:
            r0 = r10
            goto L_0x0272
        L_0x0259:
            int r0 = r2.position()
            int r0 = com.google.android.gms.internal.ads.zzen.zzj(r2, r0)
            int r0 = com.google.android.gms.internal.ads.zzadk.zzc(r0)
            if (r0 == r11) goto L_0x0268
            goto L_0x0272
        L_0x0268:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x026e:
            int r0 = com.google.android.gms.internal.ads.zzabr.zza(r2)
        L_0x0272:
            r28 = 1
            goto L_0x0314
        L_0x0276:
            int r0 = com.google.android.gms.internal.ads.zzacq.zza
            r8 = 0
            int r0 = r2.getInt(r8)
            r12 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r0 == r12) goto L_0x030a
            int r0 = r2.getInt(r8)
            r12 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r0 != r12) goto L_0x028c
            goto L_0x0257
        L_0x028c:
            int r0 = r2.getInt(r8)
            r8 = 622876772(0x25205864, float:1.3907736E-16)
            if (r0 != r8) goto L_0x0298
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0272
        L_0x0298:
            int r0 = r2.position()
            byte r8 = r2.get(r0)
            if (r8 == r9) goto L_0x02ec
            if (r8 == r11) goto L_0x02d2
            r9 = 31
            if (r8 == r9) goto L_0x02bf
            int r8 = r0 + 4
            int r0 = r0 + 5
            byte r8 = r2.get(r8)
            r28 = 1
            r8 = r8 & 1
            int r8 = r8 << 6
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            r29 = 2
            goto L_0x02e6
        L_0x02bf:
            r29 = 2
            int r8 = r0 + 5
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 6
            byte r0 = r2.get(r0)
            goto L_0x02e4
        L_0x02d2:
            r29 = 2
            int r8 = r0 + 4
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
        L_0x02e4:
            r0 = r0 & 60
        L_0x02e6:
            int r0 = r0 >> 2
            r0 = r0 | r8
            r28 = 1
            goto L_0x0305
        L_0x02ec:
            r29 = 2
            int r8 = r0 + 4
            int r0 = r0 + 5
            byte r0 = r2.get(r0)
            r28 = 1
            r0 = r0 & 1
            int r0 = r0 << 6
            byte r8 = r2.get(r8)
            r8 = r8 & 252(0xfc, float:3.53E-43)
            int r8 = r8 >> 2
            r0 = r0 | r8
        L_0x0305:
            int r0 = r0 + 1
            int r0 = r0 * 32
            goto L_0x0314
        L_0x030a:
            r28 = 1
            r0 = r10
            goto L_0x0314
        L_0x030e:
            r28 = 1
            int r0 = com.google.android.gms.internal.ads.zzadm.zzb(r2)
        L_0x0314:
            r1.zzF = r0
            if (r0 == 0) goto L_0x0319
            goto L_0x031a
        L_0x0319:
            return r28
        L_0x031a:
            com.google.android.gms.internal.ads.zzqn r0 = r1.zzx
            if (r0 == 0) goto L_0x032d
            boolean r0 = r1.zzY()
            if (r0 != 0) goto L_0x0327
            r27 = 0
            return r27
        L_0x0327:
            r1.zzO(r3)
            r8 = 0
            r1.zzx = r8
        L_0x032d:
            long r8 = r1.zzI
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq
            long r10 = r1.zzL()
            com.google.android.gms.internal.ads.zzrg r12 = r1.zzf
            long r12 = r12.zzo()
            long r10 = r10 - r12
            com.google.android.gms.internal.ads.zzad r0 = r0.zza
            int r0 = r0.zzD
            long r10 = com.google.android.gms.internal.ads.zzen.zzt(r10, r0)
            long r8 = r8 + r10
            boolean r0 = r1.zzG
            if (r0 != 0) goto L_0x0365
            long r10 = r8 - r3
            long r10 = java.lang.Math.abs(r10)
            r12 = 200000(0x30d40, double:9.8813E-319)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0365
            com.google.android.gms.internal.ads.zzpr r0 = r1.zzo
            if (r0 == 0) goto L_0x0362
            com.google.android.gms.internal.ads.zzps r10 = new com.google.android.gms.internal.ads.zzps
            r10.<init>(r3, r8)
            r0.zza(r10)
        L_0x0362:
            r10 = 1
            r1.zzG = r10
        L_0x0365:
            boolean r0 = r1.zzG
            if (r0 == 0) goto L_0x038c
            boolean r0 = r1.zzY()
            r10 = 0
            if (r0 != 0) goto L_0x0371
            return r10
        L_0x0371:
            long r8 = r3 - r8
            long r11 = r1.zzI
            long r11 = r11 + r8
            r1.zzI = r11
            r1.zzG = r10
            r1.zzO(r3)
            com.google.android.gms.internal.ads.zzpr r0 = r1.zzo
            if (r0 == 0) goto L_0x038c
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x038c
            com.google.android.gms.internal.ads.zzra r0 = (com.google.android.gms.internal.ads.zzra) r0
            com.google.android.gms.internal.ads.zzrc r0 = r0.zza
            r0.zzao()
        L_0x038c:
            com.google.android.gms.internal.ads.zzql r0 = r1.zzq
            int r0 = r0.zzc
            if (r0 != 0) goto L_0x039d
            long r6 = r1.zzB
            int r0 = r2.remaining()
            long r8 = (long) r0
            long r6 = r6 + r8
            r1.zzB = r6
            goto L_0x03a7
        L_0x039d:
            long r6 = r1.zzC
            int r0 = r1.zzF
            long r8 = (long) r0
            long r10 = (long) r5
            long r8 = r8 * r10
            long r6 = r6 + r8
            r1.zzC = r6
        L_0x03a7:
            r1.zzK = r2
            r1.zzL = r5
        L_0x03ab:
            r1.zzT(r3)
            java.nio.ByteBuffer r0 = r1.zzK
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x03bf
            r8 = 0
            r1.zzK = r8
            r8 = 0
            r1.zzL = r8
            r28 = 1
            return r28
        L_0x03bf:
            r8 = 0
            r28 = 1
            com.google.android.gms.internal.ads.zzpy r0 = r1.zzi
            long r2 = r1.zzM()
            boolean r0 = r0.zzi(r2)
            if (r0 == 0) goto L_0x03d9
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r2 = "Resetting stalled audio track"
            com.google.android.gms.internal.ads.zzdt.zzf(r0, r2)
            r1.zzf()
            return r28
        L_0x03d9:
            return r8
        L_0x03da:
            r0 = move-exception
            r11.addSuppressed(r0)     // Catch:{ zzpq -> 0x03e2 }
        L_0x03de:
            r1.zzQ()     // Catch:{ zzpq -> 0x03e2 }
            throw r11     // Catch:{ zzpq -> 0x03e2 }
        L_0x03e2:
            r0 = move-exception
            boolean r2 = r0.zzb
            if (r2 != 0) goto L_0x03ef
            com.google.android.gms.internal.ads.zzqq r2 = r1.zzl
            r2.zzb(r0)
            r27 = 0
            return r27
        L_0x03ef:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqw.zzx(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean zzy() {
        if (zzZ()) {
            return (zzen.zza < 29 || !this.zzs.isOffloadedPlayback() || !this.zzP) && this.zzi.zzg(zzM());
        }
        return false;
    }

    public final boolean zzz() {
        if (zzZ()) {
            return this.zzN && !zzy();
        }
        return true;
    }

    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        zzow zzow;
        if (audioDeviceInfo == null) {
            zzow = null;
        } else {
            zzow = new zzow(audioDeviceInfo);
        }
        this.zzT = zzow;
        zzov zzov = this.zzu;
        if (zzov != null) {
            zzov.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzs;
        if (audioTrack != null) {
            zzqh.zza(audioTrack, this.zzT);
        }
    }
}
