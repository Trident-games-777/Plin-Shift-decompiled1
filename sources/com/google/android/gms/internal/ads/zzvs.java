package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.work.WorkRequest;
import coil3.disk.DiskLruCache;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvs implements zzup, zzacu, zzyy, zzzc, zzwd {
    /* access modifiers changed from: private */
    public static final Map zzb;
    /* access modifiers changed from: private */
    public static final zzad zzc;
    private zzadq zzA;
    /* access modifiers changed from: private */
    public long zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private boolean zzH;
    private long zzI;
    private long zzJ;
    private boolean zzK;
    private int zzL;
    private boolean zzM;
    private boolean zzN;
    private final zzys zzO;
    private final Uri zzd;
    private final zzgd zze;
    private final zzrp zzf;
    private final zzva zzg;
    private final zzrk zzh;
    private final zzvo zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final long zzk;
    private final zzzg zzl = new zzzg("ProgressiveMediaPeriod");
    private final zzvh zzm;
    private final zzdf zzn;
    private final Runnable zzo;
    /* access modifiers changed from: private */
    public final Runnable zzp;
    /* access modifiers changed from: private */
    public final Handler zzq;
    private zzuo zzr;
    /* access modifiers changed from: private */
    public zzafv zzs;
    private zzwf[] zzt;
    private zzvq[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzvr zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", DiskLruCache.VERSION);
        zzb = Collections.unmodifiableMap(hashMap);
        zzab zzab = new zzab();
        zzab.zzL("icy");
        zzab.zzZ("application/x-icy");
        zzc = zzab.zzaf();
    }

    public zzvs(Uri uri, zzgd zzgd, zzvh zzvh, zzrp zzrp, zzrk zzrk, zzyw zzyw, zzva zzva, zzvo zzvo, zzys zzys, String str, int i, long j) {
        this.zzd = uri;
        this.zze = zzgd;
        this.zzf = zzrp;
        this.zzh = zzrk;
        this.zzg = zzva;
        this.zzi = zzvo;
        this.zzO = zzys;
        this.zzj = (long) i;
        this.zzm = zzvh;
        this.zzk = j;
        this.zzn = new zzdf(zzdc.zza);
        this.zzo = new zzvj(this);
        this.zzp = new zzvk(this);
        this.zzq = zzen.zzy((Handler.Callback) null);
        this.zzu = new zzvq[0];
        this.zzt = new zzwf[0];
        this.zzJ = -9223372036854775807L;
        this.zzD = 1;
    }

    private final int zzQ() {
        int i = 0;
        for (zzwf zzd2 : this.zzt) {
            i += zzd2.zzd();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public final long zzR(boolean z) {
        int i = 0;
        long j = Long.MIN_VALUE;
        while (true) {
            zzwf[] zzwfArr = this.zzt;
            if (i >= zzwfArr.length) {
                return j;
            }
            if (!z) {
                zzvr zzvr = this.zzz;
                zzvr.getClass();
                zzvr zzvr2 = zzvr;
                if (!zzvr.zzc[i]) {
                    i++;
                }
            }
            j = Math.max(j, zzwfArr[i].zzh());
            i++;
        }
    }

    private final zzadx zzS(zzvq zzvq) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzvq.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        if (this.zzv) {
            int i2 = zzvq.zza;
            zzdt.zzf("ProgressiveMediaPeriod", "Extractor added new track (id=" + i2 + ") after finishing tracks.");
            return new zzacm();
        }
        zzys zzys = this.zzO;
        zzrp zzrp = this.zzf;
        zzrk zzrk = this.zzh;
        zzrp zzrp2 = zzrp;
        zzrk zzrk2 = zzrk;
        zzwf zzwf = new zzwf(zzys, zzrp, zzrk);
        zzwf.zzu(this);
        int i3 = length + 1;
        zzvq[] zzvqArr = (zzvq[]) Arrays.copyOf(this.zzu, i3);
        zzvqArr[length] = zzvq;
        int i4 = zzen.zza;
        this.zzu = zzvqArr;
        zzwf[] zzwfArr = (zzwf[]) Arrays.copyOf(this.zzt, i3);
        zzwfArr[length] = zzwf;
        this.zzt = zzwfArr;
        return zzwf;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzT() {
        zzdb.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* access modifiers changed from: private */
    public final void zzU() {
        int i;
        zzbd zzbd;
        if (!this.zzN && !this.zzw && this.zzv && this.zzA != null) {
            zzwf[] zzwfArr = this.zzt;
            int length = zzwfArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (zzwfArr[i2].zzi() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.zzn.zzc();
            int length2 = this.zzt.length;
            zzbw[] zzbwArr = new zzbw[length2];
            boolean[] zArr = new boolean[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                zzad zzi2 = this.zzt[i3].zzi();
                zzi2.getClass();
                zzad zzad = zzi2;
                String str = zzi2.zzo;
                boolean zzg2 = zzbg.zzg(str);
                boolean z = zzg2 || zzbg.zzi(str);
                zArr[i3] = z;
                this.zzx = z | this.zzx;
                this.zzy = this.zzk != -9223372036854775807L && length2 == 1 && zzbg.zzh(str);
                zzafv zzafv = this.zzs;
                if (zzafv != null) {
                    if (zzg2 || this.zzu[i3].zzb) {
                        zzbd zzbd2 = zzi2.zzl;
                        if (zzbd2 == null) {
                            zzbd = new zzbd(-9223372036854775807L, zzafv);
                        } else {
                            zzbd = zzbd2.zzc(zzafv);
                        }
                        zzab zzb2 = zzi2.zzb();
                        zzb2.zzS(zzbd);
                        zzi2 = zzb2.zzaf();
                    }
                    if (zzg2 && zzi2.zzh == -1 && zzi2.zzi == -1 && (i = zzafv.zza) != -1) {
                        zzab zzb3 = zzi2.zzb();
                        zzb3.zzy(i);
                        zzi2 = zzb3.zzaf();
                    }
                }
                zzbwArr[i3] = new zzbw(Integer.toString(i3), zzi2.zzc(this.zzf.zza(zzi2)));
            }
            this.zzz = new zzvr(new zzwr(zzbwArr), zArr);
            if (this.zzy && this.zzB == -9223372036854775807L) {
                this.zzB = this.zzk;
                this.zzA = new zzvm(this, this.zzA);
            }
            this.zzi.zza(this.zzB, this.zzA.zzh(), this.zzC);
            this.zzw = true;
            zzuo zzuo = this.zzr;
            zzuo.getClass();
            zzuo zzuo2 = zzuo;
            zzuo.zzi(this);
        }
    }

    private final void zzV(int i) {
        zzT();
        zzvr zzvr = this.zzz;
        boolean[] zArr = zzvr.zzd;
        if (!zArr[i]) {
            zzad zzb2 = zzvr.zza.zzb(i).zzb(0);
            this.zzg.zzc(new zzun(1, zzbg.zzb(zzb2.zzo), zzb2, 0, (Object) null, zzen.zzv(this.zzI), -9223372036854775807L));
            zArr[i] = true;
        }
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (this.zzK && zArr[i] && !this.zzt[i].zzx(false)) {
            this.zzJ = 0;
            this.zzK = false;
            this.zzF = true;
            this.zzI = 0;
            this.zzL = 0;
            for (zzwf zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            zzuo zzuo = this.zzr;
            zzuo.getClass();
            zzuo zzuo2 = zzuo;
            zzuo.zzg(this);
        }
    }

    private final void zzX() {
        zzvn zzvn = new zzvn(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdb.zzf(zzY());
            long j = this.zzB;
            if (j == -9223372036854775807L || this.zzJ <= j) {
                zzadq zzadq = this.zzA;
                zzadq.getClass();
                zzadq zzadq2 = zzadq;
                zzvn.zzf(zzvn, zzadq.zzg(this.zzJ).zza.zzc, this.zzJ);
                for (zzwf zzt2 : this.zzt) {
                    zzt2.zzt(this.zzJ);
                }
                this.zzJ = -9223372036854775807L;
            } else {
                this.zzM = true;
                this.zzJ = -9223372036854775807L;
                return;
            }
        }
        this.zzL = zzQ();
        long zza = this.zzl.zza(zzvn, this, zzyw.zza(this.zzD));
        this.zzg.zzg(new zzui(zzvn.zzb, zzvn.zzl, zza), new zzun(1, -1, (zzad) null, 0, (Object) null, zzen.zzv(zzvn.zzk), zzen.zzv(this.zzB)));
    }

    private final boolean zzY() {
        return this.zzJ != -9223372036854775807L;
    }

    private final boolean zzZ() {
        return this.zzF || zzY();
    }

    public final void zzD() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF() {
        this.zzH = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzH() throws IOException {
        this.zzl.zzi(zzyw.zza(this.zzD));
    }

    /* access modifiers changed from: package-private */
    public final void zzI(int i) throws IOException {
        this.zzt[i].zzm();
        zzH();
    }

    public final /* bridge */ /* synthetic */ void zzJ(zzzb zzzb, long j, long j2, boolean z) {
        zzvn zzvn = (zzvn) zzzb;
        zzhc zze2 = zzvn.zzd;
        zzui zzui = new zzui(zzvn.zzb, zzvn.zzl, zze2.zzh(), zze2.zzi(), j, j2, zze2.zzg());
        long unused = zzvn.zzb;
        this.zzg.zzd(zzui, new zzun(1, -1, (zzad) null, 0, (Object) null, zzen.zzv(zzvn.zzk), zzen.zzv(this.zzB)));
        if (!z) {
            for (zzwf zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            if (this.zzG > 0) {
                zzuo zzuo = this.zzr;
                zzuo.getClass();
                zzuo zzuo2 = zzuo;
                zzuo.zzg(this);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzK(zzzb zzzb, long j, long j2) {
        zzadq zzadq;
        zzvn zzvn = (zzvn) zzzb;
        if (this.zzB == -9223372036854775807L && (zzadq = this.zzA) != null) {
            boolean zzh2 = zzadq.zzh();
            long zzR = zzR(true);
            long j3 = zzR == Long.MIN_VALUE ? 0 : zzR + WorkRequest.MIN_BACKOFF_MILLIS;
            this.zzB = j3;
            this.zzi.zza(j3, zzh2, this.zzC);
        }
        zzhc zze2 = zzvn.zzd;
        zzui zzui = new zzui(zzvn.zzb, zzvn.zzl, zze2.zzh(), zze2.zzi(), j, j2, zze2.zzg());
        long unused = zzvn.zzb;
        this.zzg.zze(zzui, new zzun(1, -1, (zzad) null, 0, (Object) null, zzen.zzv(zzvn.zzk), zzen.zzv(this.zzB)));
        this.zzM = true;
        zzuo zzuo = this.zzr;
        zzuo.getClass();
        zzuo zzuo2 = zzuo;
        zzuo.zzg(this);
    }

    public final void zzL() {
        for (zzwf zzo2 : this.zzt) {
            zzo2.zzo();
        }
        this.zzm.zze();
    }

    public final void zzM(zzad zzad) {
        this.zzq.post(this.zzo);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzwf zzn2 : this.zzt) {
                zzn2.zzn();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages((Object) null);
        this.zzr = null;
        this.zzN = true;
    }

    public final void zzO(zzadq zzadq) {
        this.zzq.post(new zzvl(this, zzadq));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(int i) {
        return !zzZ() && this.zzt[i].zzx(this.zzM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(long r23, com.google.android.gms.internal.ads.zzls r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r3 = r25
            r0.zzT()
            com.google.android.gms.internal.ads.zzadq r4 = r0.zzA
            boolean r4 = r4.zzh()
            r5 = 0
            if (r4 != 0) goto L_0x0014
            return r5
        L_0x0014:
            com.google.android.gms.internal.ads.zzadq r4 = r0.zzA
            com.google.android.gms.internal.ads.zzado r4 = r4.zzg(r1)
            com.google.android.gms.internal.ads.zzadr r7 = r4.zza
            com.google.android.gms.internal.ads.zzadr r4 = r4.zzb
            long r8 = r3.zzc
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x002c
            long r8 = r3.zzd
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x002b
            return r1
        L_0x002b:
            r8 = r5
        L_0x002c:
            long r10 = r7.zzb
            int r7 = com.google.android.gms.internal.ads.zzen.zza
            long r12 = r1 - r8
            long r7 = r1 ^ r8
            long r14 = r1 ^ r12
            r16 = r5
            long r5 = r3.zzd
            long r18 = r1 + r5
            long r20 = r1 ^ r18
            long r5 = r5 ^ r18
            long r7 = r7 & r14
            int r3 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0047
            r12 = -9223372036854775808
        L_0x0047:
            long r5 = r20 & r5
            int r3 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0052
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0052:
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r3 > 0) goto L_0x005e
            int r3 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x005e
            r3 = r5
            goto L_0x005f
        L_0x005e:
            r3 = r6
        L_0x005f:
            long r7 = r4.zzb
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x006a
            int r4 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r4 > 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r5 = r6
        L_0x006b:
            if (r3 == 0) goto L_0x0080
            if (r5 == 0) goto L_0x0080
            long r3 = r10 - r1
            long r1 = r7 - r1
            long r3 = java.lang.Math.abs(r3)
            long r1 = java.lang.Math.abs(r1)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0085
            goto L_0x0082
        L_0x0080:
            if (r3 == 0) goto L_0x0083
        L_0x0082:
            return r10
        L_0x0083:
            if (r5 == 0) goto L_0x0086
        L_0x0085:
            return r7
        L_0x0086:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvs.zza(long, com.google.android.gms.internal.ads.zzls):long");
    }

    public final long zzb() {
        long j;
        zzT();
        if (this.zzM || this.zzG == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzJ;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzvr zzvr = this.zzz;
                if (zzvr.zzb[i] && zzvr.zzc[i] && !this.zzt[i].zzw()) {
                    j = Math.min(j, this.zzt[i].zzh());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = zzR(false);
        }
        return j == Long.MIN_VALUE ? this.zzI : j;
    }

    public final long zzc() {
        return zzb();
    }

    public final long zzd() {
        if (!this.zzF) {
            return -9223372036854775807L;
        }
        if (!this.zzM && zzQ() <= this.zzL) {
            return -9223372036854775807L;
        }
        this.zzF = false;
        return this.zzI;
    }

    public final long zze(long j) {
        boolean z;
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (true != this.zzA.zzh()) {
            j = 0;
        }
        this.zzF = false;
        this.zzI = j;
        if (zzY()) {
            this.zzJ = j;
            return j;
        }
        if (this.zzD != 7 && (this.zzM || this.zzl.zzl())) {
            int length = this.zzt.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zzwf zzwf = this.zzt[i];
                if (this.zzy) {
                    z = zzwf.zzy(zzwf.zza());
                } else {
                    z = zzwf.zzz(j, false);
                }
                if (!z && (zArr[i] || !this.zzx)) {
                    break;
                }
                i++;
            }
            return j;
        }
        this.zzK = false;
        this.zzJ = j;
        this.zzM = false;
        zzzg zzzg = this.zzl;
        if (zzzg.zzl()) {
            for (zzwf zzk2 : this.zzt) {
                zzk2.zzk();
            }
            this.zzl.zzg();
            return j;
        }
        zzzg.zzh();
        for (zzwf zzp2 : this.zzt) {
            zzp2.zzp(false);
        }
        return j;
    }

    public final long zzf(zzyd[] zzydArr, boolean[] zArr, zzwg[] zzwgArr, boolean[] zArr2, long j) {
        boolean z;
        zzyd zzyd;
        zzT();
        zzvr zzvr = this.zzz;
        zzwr zzwr = zzvr.zza;
        boolean[] zArr3 = zzvr.zzc;
        int i = this.zzG;
        int i2 = 0;
        for (int i3 = 0; i3 < zzydArr.length; i3++) {
            zzvp zzvp = zzwgArr[i3];
            if (zzvp != null && (zzydArr[i3] == null || !zArr[i3])) {
                int zzc2 = zzvp.zzb;
                zzdb.zzf(zArr3[zzc2]);
                this.zzG--;
                zArr3[zzc2] = false;
                zzwgArr[i3] = null;
            }
        }
        if (!this.zzE ? j == 0 || this.zzy : i != 0) {
            z = false;
        } else {
            z = true;
        }
        for (int i4 = 0; i4 < zzydArr.length; i4++) {
            if (zzwgArr[i4] == null && (zzyd = zzydArr[i4]) != null) {
                zzdb.zzf(zzyd.zzc() == 1);
                zzdb.zzf(zzyd.zza(0) == 0);
                int zza = zzwr.zza(zzyd.zze());
                zzdb.zzf(!zArr3[zza]);
                this.zzG++;
                zArr3[zza] = true;
                zzwgArr[i4] = new zzvp(this, zza);
                zArr2[i4] = true;
                if (!z) {
                    zzwf zzwf = this.zzt[zza];
                    z = zzwf.zzb() != 0 && !zzwf.zzz(j, true);
                }
            }
        }
        if (this.zzG == 0) {
            this.zzK = false;
            this.zzF = false;
            if (this.zzl.zzl()) {
                zzwf[] zzwfArr = this.zzt;
                int length = zzwfArr.length;
                while (i2 < length) {
                    zzwfArr[i2].zzk();
                    i2++;
                }
                this.zzl.zzg();
            } else {
                this.zzM = false;
                for (zzwf zzp2 : this.zzt) {
                    zzp2.zzp(false);
                }
            }
        } else if (z) {
            j = zze(j);
            while (i2 < zzwgArr.length) {
                if (zzwgArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzE = true;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final int zzg(int i, zzkj zzkj, zzhm zzhm, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int zze2 = this.zzt[i].zze(zzkj, zzhm, i2, this.zzM);
        if (zze2 == -3) {
            zzW(i);
        }
        return zze2;
    }

    public final zzwr zzh() {
        zzT();
        return this.zzz.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzwf zzwf = this.zzt[i];
        int zzc2 = zzwf.zzc(j, this.zzM);
        zzwf.zzv(zzc2);
        if (zzc2 != 0) {
            return zzc2;
        }
        zzW(i);
        return 0;
    }

    public final void zzj(long j, boolean z) {
        if (!this.zzy) {
            zzT();
            if (!zzY()) {
                boolean[] zArr = this.zzz.zzc;
                int length = this.zzt.length;
                for (int i = 0; i < length; i++) {
                    this.zzt[i].zzj(j, false, zArr[i]);
                }
            }
        }
    }

    public final void zzk() throws IOException {
        zzH();
        if (this.zzM && !this.zzw) {
            throw zzbh.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzl(zzuo zzuo, long j) {
        this.zzr = zzuo;
        this.zzn.zze();
        zzX();
    }

    public final void zzm(long j) {
    }

    public final boolean zzo(zzko zzko) {
        if (this.zzM) {
            return false;
        }
        zzzg zzzg = this.zzl;
        if (zzzg.zzk() || this.zzK) {
            return false;
        }
        if (this.zzw && this.zzG == 0) {
            return false;
        }
        boolean zze2 = this.zzn.zze();
        if (zzzg.zzl()) {
            return zze2;
        }
        zzX();
        return true;
    }

    public final boolean zzp() {
        return this.zzl.zzl() && this.zzn.zzd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzyz zzu(com.google.android.gms.internal.ads.zzzb r23, long r24, long r26, java.io.IOException r28, int r29) {
        /*
            r22 = this;
            r0 = r22
            r1 = r28
            r2 = r23
            com.google.android.gms.internal.ads.zzvn r2 = (com.google.android.gms.internal.ads.zzvn) r2
            com.google.android.gms.internal.ads.zzhc r3 = r2.zzd
            com.google.android.gms.internal.ads.zzui r4 = new com.google.android.gms.internal.ads.zzui
            long r5 = r2.zzb
            com.google.android.gms.internal.ads.zzgi r7 = r2.zzl
            android.net.Uri r8 = r3.zzh()
            java.util.Map r9 = r3.zzi()
            long r14 = r3.zzg()
            r10 = r24
            r12 = r26
            r4.<init>(r5, r7, r8, r9, r10, r12, r14)
            long unused = r2.zzk
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzbh
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r1 instanceof java.io.FileNotFoundException
            if (r3 != 0) goto L_0x0065
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzgt
            if (r3 != 0) goto L_0x0065
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzze
            if (r3 != 0) goto L_0x0065
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x0059
            boolean r7 = r3 instanceof com.google.android.gms.internal.ads.zzge
            if (r7 == 0) goto L_0x0054
            r7 = r3
            com.google.android.gms.internal.ads.zzge r7 = (com.google.android.gms.internal.ads.zzge) r7
            int r7 = r7.zza
            r8 = 2008(0x7d8, float:2.814E-42)
            if (r7 != r8) goto L_0x0054
            goto L_0x0065
        L_0x0054:
            java.lang.Throwable r3 = r3.getCause()
            goto L_0x0044
        L_0x0059:
            int r3 = r29 + -1
            int r3 = r3 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r3 = java.lang.Math.min(r3, r7)
            long r7 = (long) r3
            goto L_0x0066
        L_0x0065:
            r7 = r5
        L_0x0066:
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzyz r3 = com.google.android.gms.internal.ads.zzzg.zzb
            goto L_0x00ba
        L_0x006d:
            int r3 = r0.zzQ()
            int r9 = r0.zzL
            r10 = 1
            r11 = 0
            if (r3 <= r9) goto L_0x0079
            r9 = r10
            goto L_0x007a
        L_0x0079:
            r9 = r11
        L_0x007a:
            boolean r12 = r0.zzH
            if (r12 != 0) goto L_0x00b4
            com.google.android.gms.internal.ads.zzadq r12 = r0.zzA
            if (r12 == 0) goto L_0x008b
            long r12 = r12.zza()
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x008b
            goto L_0x00b4
        L_0x008b:
            boolean r3 = r0.zzw
            if (r3 == 0) goto L_0x009a
            boolean r5 = r0.zzZ()
            if (r5 != 0) goto L_0x009a
            r0.zzK = r10
            com.google.android.gms.internal.ads.zzyz r3 = com.google.android.gms.internal.ads.zzzg.zza
            goto L_0x00ba
        L_0x009a:
            r0.zzF = r3
            r5 = 0
            r0.zzI = r5
            r0.zzL = r11
            com.google.android.gms.internal.ads.zzwf[] r3 = r0.zzt
            int r10 = r3.length
            r12 = r11
        L_0x00a6:
            if (r12 >= r10) goto L_0x00b0
            r13 = r3[r12]
            r13.zzp(r11)
            int r12 = r12 + 1
            goto L_0x00a6
        L_0x00b0:
            com.google.android.gms.internal.ads.zzvn.zzf(r2, r5, r5)
            goto L_0x00b6
        L_0x00b4:
            r0.zzL = r3
        L_0x00b6:
            com.google.android.gms.internal.ads.zzyz r3 = com.google.android.gms.internal.ads.zzzg.zzb(r9, r7)
        L_0x00ba:
            boolean r5 = r3.zzc()
            r6 = r5 ^ 1
            com.google.android.gms.internal.ads.zzva r7 = r0.zzg
            long r8 = r2.zzk
            long r10 = r0.zzB
            long r18 = com.google.android.gms.internal.ads.zzen.zzv(r8)
            long r20 = com.google.android.gms.internal.ads.zzen.zzv(r10)
            com.google.android.gms.internal.ads.zzun r12 = new com.google.android.gms.internal.ads.zzun
            r16 = 0
            r17 = 0
            r13 = 1
            r14 = -1
            r15 = 0
            r12.<init>(r13, r14, r15, r16, r17, r18, r20)
            r7.zzf(r4, r12, r1, r6)
            if (r5 != 0) goto L_0x00e4
            long unused = r2.zzb
        L_0x00e4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvs.zzu(com.google.android.gms.internal.ads.zzzb, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zzyz");
    }

    /* access modifiers changed from: package-private */
    public final zzadx zzv() {
        return zzS(new zzvq(0, true));
    }

    public final zzadx zzw(int i, int i2) {
        return zzS(new zzvq(i, false));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE() {
        if (!this.zzN) {
            zzuo zzuo = this.zzr;
            zzuo.getClass();
            zzuo zzuo2 = zzuo;
            zzuo.zzg(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(zzadq zzadq) {
        zzadq zzadq2;
        if (this.zzs == null) {
            zzadq2 = zzadq;
        } else {
            zzadq2 = new zzadp(-9223372036854775807L, 0);
        }
        this.zzA = zzadq2;
        this.zzB = zzadq.zza();
        boolean z = false;
        int i = 1;
        if (!this.zzH && zzadq.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzC = z;
        if (true == z) {
            i = 7;
        }
        this.zzD = i;
        if (this.zzw) {
            this.zzi.zza(this.zzB, zzadq.zzh(), this.zzC);
        } else {
            zzU();
        }
    }
}
