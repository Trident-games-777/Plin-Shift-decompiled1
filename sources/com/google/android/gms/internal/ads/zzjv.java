package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzjv extends zzi implements zzir {
    public static final /* synthetic */ int zzd = 0;
    private boolean zzA;
    private zzls zzB;
    private zziq zzC;
    private zzbl zzD;
    private zzba zzE;
    /* access modifiers changed from: private */
    public Object zzF;
    private Surface zzG;
    private int zzH;
    private zzee zzI;
    private int zzJ;
    private zzg zzK;
    private float zzL;
    /* access modifiers changed from: private */
    public boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private int zzP;
    private zzba zzQ;
    private zzlg zzR;
    private int zzS;
    private long zzT;
    private final zzjd zzU;
    private zzwj zzV;
    final zzyk zzb;
    final zzbl zzc;
    private final zzdf zze;
    private final Context zzf;
    private final zzbp zzg;
    private final zzln[] zzh;
    private final zzyj zzi;
    private final zzdm zzj;
    private final zzkh zzk;
    /* access modifiers changed from: private */
    public final zzds zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzbt zzn;
    private final List zzo;
    private final boolean zzp;
    /* access modifiers changed from: private */
    public final zzlw zzq;
    private final Looper zzr;
    private final zzyr zzs;
    private final zzdc zzt;
    private final zzjr zzu;
    private final zzjs zzv;
    private final zzhv zzw;
    private final long zzx;
    private int zzy;
    private int zzz;

    static {
        zzax.zzb("media3.exoplayer");
    }

    public zzjv(zzip zzip, zzbp zzbp) {
        zzoj zza;
        int i;
        zzip zzip2 = zzip;
        zzbp zzbp2 = zzbp;
        zzdf zzdf = new zzdf(zzdc.zza);
        this.zze = zzdf;
        try {
            zzdt.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.0-alpha01] [" + zzen.zze + "]");
            Context applicationContext = zzip2.zza.getApplicationContext();
            this.zzf = applicationContext;
            zzlw zzlw = (zzlw) zzip2.zzh.apply(zzip2.zzb);
            this.zzq = zzlw;
            this.zzP = zzip2.zzj;
            this.zzK = zzip2.zzk;
            this.zzH = zzip2.zzl;
            this.zzM = false;
            this.zzx = zzip2.zzp;
            zzjr zzjr = new zzjr(this, (zzju) null);
            this.zzu = zzjr;
            zzjs zzjs = new zzjs((zzju) null);
            this.zzv = zzjs;
            Handler handler = new Handler(zzip2.zzi);
            zzcep zzcep = ((zzii) zzip2.zzc).zza;
            zzcep zzcep2 = zzcep;
            zzln[] zza2 = zzcep.zza(handler, zzjr, zzjr, zzjr, zzjr);
            this.zzh = zza2;
            int length = zza2.length;
            zzyj zzyj = (zzyj) zzip2.zze.zza();
            this.zzi = zzyj;
            zzuq zza3 = zzip.zza(((zzij) zzip2.zzd).zza);
            zzyr zzh2 = zzyv.zzh(((zzim) zzip2.zzg).zza);
            this.zzs = zzh2;
            this.zzp = zzip2.zzm;
            this.zzB = zzip2.zzn;
            Looper looper = zzip2.zzi;
            this.zzr = looper;
            zzdc zzdc = zzip2.zzb;
            this.zzt = zzdc;
            this.zzg = zzbp2;
            zzyr zzyr = zzh2;
            zzds zzds = new zzds(looper, zzdc, new zzjc(this));
            this.zzl = zzds;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            zzdf zzdf2 = zzdf;
            this.zzV = new zzwj(0);
            this.zzC = zziq.zza;
            int length2 = zza2.length;
            Handler handler2 = handler;
            CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
            zzjs zzjs2 = zzjs;
            zzyk zzyk = new zzyk(new zzlr[2], new zzyd[2], zzcd.zza, (Object) null);
            this.zzb = zzyk;
            this.zzn = new zzbt();
            zzbk zzbk = new zzbk();
            zzbk.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyj.zzn();
            zzbk.zzd(29, true);
            zzbk.zzd(23, false);
            zzbk.zzd(25, false);
            zzbk.zzd(33, false);
            zzbk.zzd(26, false);
            zzbk.zzd(34, false);
            zzbl zze2 = zzbk.zze();
            this.zzc = zze2;
            zzbk zzbk2 = new zzbk();
            zzbk2.zzb(zze2);
            zzbk2.zza(4);
            zzbk2.zza(10);
            this.zzD = zzbk2.zze();
            this.zzj = zzdc.zzd(looper, (Handler.Callback) null);
            zzjd zzjd = new zzjd(this);
            this.zzU = zzjd;
            this.zzR = zzlg.zzg(zzyk);
            zzlw.zzS(zzbp2, looper);
            if (zzen.zza < 31) {
                zza = new zzoj(zzip2.zzs);
            } else {
                zza = zzjn.zza(applicationContext, this, zzip2.zzq, zzip2.zzs);
            }
            zzoj zzoj = zza;
            zzjd zzjd2 = zzjd;
            zzdc zzdc2 = zzdc;
            zzls zzls = this.zzB;
            zzia zzia = zzip2.zzt;
            long j = zzip2.zzo;
            Looper looper2 = looper;
            zzjs zzjs3 = zzjs2;
            zzjr zzjr2 = zzjr;
            zzds zzds2 = zzds;
            Handler handler3 = handler2;
            zzyj zzyj2 = zzyj;
            zzyr zzyr2 = zzyr;
            zzia zzia2 = zzia;
            CopyOnWriteArraySet copyOnWriteArraySet3 = copyOnWriteArraySet2;
            Looper looper3 = looper2;
            this.zzk = new zzkh(zza2, zzyj2, zzyk, (zzkl) zzip2.zzf.zza(), zzyr2, 0, false, zzlw, zzls, zzia2, j, false, false, looper2, zzdc2, zzjd2, zzoj, (Looper) null, this.zzC);
            this.zzL = 1.0f;
            this.zzE = zzba.zza;
            this.zzQ = zzba.zza;
            this.zzS = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            if (audioManager == null) {
                i = -1;
            } else {
                i = audioManager.generateAudioSessionId();
            }
            this.zzJ = i;
            int i2 = zzcu.zza;
            this.zzN = true;
            if (zzlw != null) {
                zzds2.zzb(zzlw);
                zzyr2.zzf(new Handler(looper3), zzlw);
                copyOnWriteArraySet3.add(zzjr2);
                zzip zzip3 = zzip;
                Handler handler4 = handler3;
                new zzhq(zzip3.zza, handler4, zzjr2);
                this.zzw = new zzhv(zzip3.zza, handler4, zzjr2);
                Objects.equals((Object) null, (Object) null);
                zzip3.zza.getApplicationContext();
                zzip3.zza.getApplicationContext();
                new zzq(0).zza();
                zzci zzci = zzci.zza;
                this.zzI = zzee.zza;
                zzyj2.zzk(this.zzK);
                zzab(1, 10, Integer.valueOf(this.zzJ));
                zzab(2, 10, Integer.valueOf(this.zzJ));
                zzab(1, 3, this.zzK);
                zzab(2, 4, Integer.valueOf(this.zzH));
                zzab(2, 5, 0);
                zzab(1, 9, Boolean.valueOf(this.zzM));
                zzjs zzjs4 = zzjs3;
                zzab(2, 7, zzjs4);
                zzab(6, 8, zzjs4);
                zzab(-1, 16, Integer.valueOf(this.zzP));
                zzdf2.zze();
                return;
            }
            throw null;
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzK(zzjv zzjv, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjv.zzad(surface);
        zzjv.zzG = surface;
    }

    private final int zzR(zzlg zzlg) {
        if (zzlg.zza.zzo()) {
            return this.zzS;
        }
        return zzlg.zza.zzn(zzlg.zzb.zza, this.zzn).zzc;
    }

    /* access modifiers changed from: private */
    public static int zzS(int i) {
        return i == -1 ? 2 : 1;
    }

    private final long zzT(zzlg zzlg) {
        if (!zzlg.zzb.zzb()) {
            return zzen.zzv(zzU(zzlg));
        }
        zzlg.zza.zzn(zzlg.zzb.zza, this.zzn);
        if (zzlg.zzc == -9223372036854775807L) {
            long j = zzlg.zza.zze(zzR(zzlg), this.zza, 0).zzl;
            return zzen.zzv(0);
        }
        int i = zzen.zza;
        return zzen.zzv(0) + zzen.zzv(zzlg.zzc);
    }

    private final long zzU(zzlg zzlg) {
        if (zzlg.zza.zzo()) {
            return zzen.zzs(this.zzT);
        }
        boolean z = zzlg.zzp;
        long j = zzlg.zzs;
        if (zzlg.zzb.zzb()) {
            return j;
        }
        zzW(zzlg.zza, zzlg.zzb, j);
        return j;
    }

    private static long zzV(zzlg zzlg) {
        zzbu zzbu = new zzbu();
        zzbt zzbt = new zzbt();
        zzlg.zza.zzn(zzlg.zzb.zza, zzbt);
        long j = zzlg.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzlg.zza.zze(zzbt.zzc, zzbu, 0).zzl;
        return 0;
    }

    private final long zzW(zzbv zzbv, zzur zzur, long j) {
        zzbv.zzn(zzur.zza, this.zzn);
        return j;
    }

    private final Pair zzX(zzbv zzbv, int i, long j) {
        if (zzbv.zzo()) {
            this.zzS = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzT = j;
            return null;
        }
        if (i == -1 || i >= zzbv.zzc()) {
            i = zzbv.zzg(false);
            long j2 = zzbv.zze(i, this.zza, 0).zzl;
            j = zzen.zzv(0);
        }
        return zzbv.zzl(this.zza, this.zzn, i, zzen.zzs(j));
    }

    private final zzlg zzY(zzlg zzlg, zzbv zzbv, Pair pair) {
        zzur zzur;
        zzwr zzwr;
        zzyk zzyk;
        List list;
        int i;
        long j;
        zzbv zzbv2 = zzbv;
        Pair pair2 = pair;
        zzdb.zzd(zzbv2.zzo() || pair2 != null);
        zzbv zzbv3 = zzlg.zza;
        long zzT2 = zzT(zzlg);
        zzlg zzf2 = zzlg.zzf(zzbv);
        if (zzbv2.zzo()) {
            zzur zzh2 = zzlg.zzh();
            long zzs2 = zzen.zzs(this.zzT);
            zzlg zza = zzf2.zzb(zzh2, zzs2, zzs2, zzs2, 0, zzwr.zza, this.zzb, zzfzo.zzn()).zza(zzh2);
            zza.zzq = zza.zzs;
            return zza;
        }
        Object obj = zzf2.zzb.zza;
        int i2 = zzen.zza;
        Pair pair3 = pair2;
        boolean equals = obj.equals(pair2.first);
        if (!equals) {
            zzur = new zzur(pair2.first, -1);
        } else {
            zzur = zzf2.zzb;
        }
        long longValue = ((Long) pair2.second).longValue();
        long zzs3 = zzen.zzs(zzT2);
        if (!zzbv3.zzo()) {
            zzbv3.zzn(obj, this.zzn);
        }
        if (!equals || longValue < zzs3) {
            boolean z = equals;
            zzur zzur2 = zzur;
            long j2 = longValue;
            zzdb.zzf(!zzur2.zzb());
            if (!z) {
                zzwr = zzwr.zza;
            } else {
                zzwr = zzf2.zzh;
            }
            zzwr zzwr2 = zzwr;
            if (!z) {
                zzyk = this.zzb;
            } else {
                zzyk = zzf2.zzi;
            }
            zzyk zzyk2 = zzyk;
            if (!z) {
                list = zzfzo.zzn();
            } else {
                list = zzf2.zzj;
            }
            zzlg zza2 = zzf2.zzb(zzur2, j2, j2, j2, 0, zzwr2, zzyk2, list).zza(zzur2);
            zza2.zzq = j2;
            return zza2;
        } else if (i == 0) {
            int zza3 = zzbv2.zza(zzf2.zzk.zza);
            if (zza3 != -1 && zzbv2.zzd(zza3, this.zzn, false).zzc == zzbv2.zzn(zzur.zza, this.zzn).zzc) {
                return zzf2;
            }
            zzbv2.zzn(zzur.zza, this.zzn);
            if (zzur.zzb()) {
                j = this.zzn.zzf(zzur.zzb, zzur.zzc);
            } else {
                j = this.zzn.zzd;
            }
            zzur zzur3 = zzur;
            zzlg zza4 = zzf2.zzb(zzur3, zzf2.zzs, zzf2.zzs, zzf2.zzd, j - zzf2.zzs, zzf2.zzh, zzf2.zzi, zzf2.zzj).zza(zzur3);
            zza4.zzq = j;
            return zza4;
        } else {
            zzur zzur4 = zzur;
            zzdb.zzf(!zzur4.zzb());
            long max = Math.max(0, zzf2.zzr - (longValue - zzs3));
            long j3 = zzf2.zzq;
            if (zzf2.zzk.equals(zzf2.zzb)) {
                j3 = longValue + max;
            }
            long j4 = longValue;
            zzlg zzb2 = zzf2.zzb(zzur4, j4, j4, j4, max, zzf2.zzh, zzf2.zzi, zzf2.zzj);
            zzb2.zzq = j3;
            return zzb2;
        }
    }

    private final zzlj zzZ(zzli zzli) {
        int zzR2 = zzR(this.zzR);
        zzbv zzbv = this.zzR.zza;
        if (zzR2 == -1) {
            zzR2 = 0;
        }
        zzdc zzdc = this.zzt;
        zzkh zzkh = this.zzk;
        return new zzlj(zzkh, zzli, zzbv, zzR2, zzdc, zzkh.zzc());
    }

    /* access modifiers changed from: private */
    public final void zzaa(int i, int i2) {
        if (i != this.zzI.zzb() || i2 != this.zzI.zza()) {
            this.zzI = new zzee(i, i2);
            zzds zzds = this.zzl;
            zzds.zzd(24, new zziy(i, i2));
            zzds.zzc();
            zzab(2, 14, new zzee(i, i2));
        }
    }

    private final void zzab(int i, int i2, Object obj) {
        zzln[] zzlnArr = this.zzh;
        int length = zzlnArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzln zzln = zzlnArr[i3];
            if (i == -1 || zzln.zzb() == i) {
                zzlj zzZ = zzZ(zzln);
                zzZ.zzf(i2);
                zzZ.zze(obj);
                zzZ.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzac() {
        zzab(1, 2, Float.valueOf(this.zzL * this.zzw.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzad(Object obj) {
        ArrayList<zzlj> arrayList = new ArrayList<>();
        zzln[] zzlnArr = this.zzh;
        int length = zzlnArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzln zzln = zzlnArr[i];
            if (zzln.zzb() == 2) {
                zzlj zzZ = zzZ(zzln);
                zzZ.zzf(1);
                zzZ.zze(obj);
                zzZ.zzd();
                arrayList.add(zzZ);
            }
        }
        Object obj2 = this.zzF;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (zzlj zzi2 : arrayList) {
                    zzi2.zzi(this.zzx);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.zzF;
            Surface surface = this.zzG;
            if (obj3 == surface) {
                surface.release();
                this.zzG = null;
            }
        }
        this.zzF = obj;
        if (z) {
            zzae(zzig.zzd(new zzki(3), PointerIconCompat.TYPE_HELP));
        }
    }

    private final void zzae(zzig zzig) {
        zzlg zzlg = this.zzR;
        zzlg zza = zzlg.zza(zzlg.zzb);
        zza.zzq = zza.zzs;
        zza.zzr = 0;
        zzlg zze2 = zza.zze(1);
        if (zzig != null) {
            zze2 = zze2.zzd(zzig);
        }
        this.zzy++;
        this.zzk.zzo();
        zzag(zze2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* access modifiers changed from: private */
    public final void zzaf(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (i == 0) {
            i3 = 1;
        }
        zzlg zzlg = this.zzR;
        if (zzlg.zzl != z2 || zzlg.zzn != i3 || zzlg.zzm != i2) {
            this.zzy++;
            boolean z3 = zzlg.zzp;
            zzlg zzc2 = zzlg.zzc(z2, i2, i3);
            this.zzk.zzn(z2, i2, i3);
            zzag(zzc2, 0, false, 5, -9223372036854775807L, -1, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0484 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x048f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0499 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04aa A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x04b6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x029c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag(com.google.android.gms.internal.ads.zzlg r34, int r35, boolean r36, int r37, long r38, int r40, boolean r41) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            r2 = r37
            com.google.android.gms.internal.ads.zzlg r3 = r0.zzR
            r0.zzR = r1
            com.google.android.gms.internal.ads.zzbv r4 = r3.zza
            com.google.android.gms.internal.ads.zzbv r5 = r1.zza
            boolean r4 = r4.equals(r5)
            com.google.android.gms.internal.ads.zzbv r5 = r3.zza
            com.google.android.gms.internal.ads.zzbv r6 = r1.zza
            boolean r7 = r6.zzo()
            r10 = -1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r12 = 0
            r14 = 1
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r14)
            r41 = 3
            r9 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r9)
            if (r7 == 0) goto L_0x003b
            boolean r7 = r5.zzo()
            if (r7 == 0) goto L_0x003b
            android.util.Pair r5 = new android.util.Pair
            r5.<init>(r8, r11)
            goto L_0x004e
        L_0x003b:
            boolean r7 = r6.zzo()
            boolean r10 = r5.zzo()
            if (r7 == r10) goto L_0x0055
            android.util.Pair r5 = new android.util.Pair
            java.lang.Integer r6 = java.lang.Integer.valueOf(r41)
            r5.<init>(r15, r6)
        L_0x004e:
            r6 = r5
            r7 = r9
            r5 = r2
            r2 = r36
            goto L_0x00db
        L_0x0055:
            com.google.android.gms.internal.ads.zzur r7 = r3.zzb
            java.lang.Object r7 = r7.zza
            com.google.android.gms.internal.ads.zzbt r10 = r0.zzn
            com.google.android.gms.internal.ads.zzbt r7 = r5.zzn(r7, r10)
            int r7 = r7.zzc
            com.google.android.gms.internal.ads.zzbu r10 = r0.zza
            com.google.android.gms.internal.ads.zzbu r5 = r5.zze(r7, r10, r12)
            java.lang.Object r5 = r5.zzb
            com.google.android.gms.internal.ads.zzur r7 = r1.zzb
            java.lang.Object r7 = r7.zza
            com.google.android.gms.internal.ads.zzbt r10 = r0.zzn
            com.google.android.gms.internal.ads.zzbt r7 = r6.zzn(r7, r10)
            int r7 = r7.zzc
            com.google.android.gms.internal.ads.zzbu r10 = r0.zza
            com.google.android.gms.internal.ads.zzbu r6 = r6.zze(r7, r10, r12)
            java.lang.Object r6 = r6.zzb
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00af
            if (r36 == 0) goto L_0x008d
            if (r2 != 0) goto L_0x008b
            r2 = r9
            r5 = r14
            r6 = r5
            goto L_0x009a
        L_0x008b:
            r5 = r14
            goto L_0x008e
        L_0x008d:
            r5 = r9
        L_0x008e:
            r6 = r5
            if (r5 == 0) goto L_0x0096
            if (r2 != r14) goto L_0x0096
            r5 = r6
            r6 = 2
            goto L_0x009a
        L_0x0096:
            if (r4 != 0) goto L_0x00a9
            r6 = r41
        L_0x009a:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.<init>(r15, r6)
            r6 = r5
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r9
            goto L_0x00db
        L_0x00a9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00af:
            if (r36 == 0) goto L_0x00d3
            if (r2 != 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzur r2 = r3.zzb
            long r5 = r2.zzd
            com.google.android.gms.internal.ads.zzur r2 = r1.zzb
            r7 = r9
            long r9 = r2.zzd
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00cd
            android.util.Pair r5 = new android.util.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            r5.<init>(r15, r2)
            r6 = r5
            r5 = r7
            r2 = r14
            goto L_0x00db
        L_0x00cd:
            r5 = r7
            goto L_0x00d1
        L_0x00cf:
            r7 = r9
            r5 = r2
        L_0x00d1:
            r2 = r14
            goto L_0x00d6
        L_0x00d3:
            r7 = r9
            r5 = r2
            r2 = r7
        L_0x00d6:
            android.util.Pair r6 = new android.util.Pair
            r6.<init>(r8, r11)
        L_0x00db:
            java.lang.Object r8 = r6.first
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r8 == 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzbv r10 = r1.zza
            boolean r10 = r10.zzo()
            if (r10 != 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzbv r10 = r1.zza
            com.google.android.gms.internal.ads.zzur r11 = r1.zzb
            java.lang.Object r11 = r11.zza
            com.google.android.gms.internal.ads.zzbt r15 = r0.zzn
            com.google.android.gms.internal.ads.zzbt r10 = r10.zzn(r11, r15)
            int r10 = r10.zzc
            com.google.android.gms.internal.ads.zzbv r11 = r1.zza
            com.google.android.gms.internal.ads.zzbu r15 = r0.zza
            com.google.android.gms.internal.ads.zzbu r10 = r11.zze(r10, r15, r12)
            com.google.android.gms.internal.ads.zzaw r10 = r10.zzd
            goto L_0x010f
        L_0x010e:
            r10 = 0
        L_0x010f:
            com.google.android.gms.internal.ads.zzba r11 = com.google.android.gms.internal.ads.zzba.zza
            r0.zzQ = r11
            goto L_0x0115
        L_0x0114:
            r10 = 0
        L_0x0115:
            if (r8 != 0) goto L_0x0121
            java.util.List r11 = r3.zzj
            java.util.List r15 = r1.zzj
            boolean r11 = r11.equals(r15)
            if (r11 != 0) goto L_0x0152
        L_0x0121:
            com.google.android.gms.internal.ads.zzba r11 = r0.zzQ
            com.google.android.gms.internal.ads.zzay r11 = r11.zza()
            java.util.List r15 = r1.zzj
        L_0x0129:
            int r9 = r15.size()
            if (r7 >= r9) goto L_0x014c
            java.lang.Object r9 = r15.get(r7)
            com.google.android.gms.internal.ads.zzbd r9 = (com.google.android.gms.internal.ads.zzbd) r9
            r14 = 0
        L_0x0136:
            int r12 = r9.zza()
            if (r14 >= r12) goto L_0x0146
            com.google.android.gms.internal.ads.zzbc r12 = r9.zzb(r14)
            r12.zza(r11)
            int r14 = r14 + 1
            goto L_0x0136
        L_0x0146:
            int r7 = r7 + 1
            r12 = 0
            r14 = 1
            goto L_0x0129
        L_0x014c:
            com.google.android.gms.internal.ads.zzba r7 = r11.zzu()
            r0.zzQ = r7
        L_0x0152:
            com.google.android.gms.internal.ads.zzbv r7 = r0.zzn()
            boolean r9 = r7.zzo()
            if (r9 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzba r7 = r0.zzQ
            goto L_0x017c
        L_0x015f:
            int r9 = r0.zzd()
            com.google.android.gms.internal.ads.zzbu r11 = r0.zza
            r12 = 0
            com.google.android.gms.internal.ads.zzbu r7 = r7.zze(r9, r11, r12)
            com.google.android.gms.internal.ads.zzaw r7 = r7.zzd
            com.google.android.gms.internal.ads.zzba r9 = r0.zzQ
            com.google.android.gms.internal.ads.zzay r9 = r9.zza()
            com.google.android.gms.internal.ads.zzba r7 = r7.zzd
            r9.zzb(r7)
            com.google.android.gms.internal.ads.zzba r7 = r9.zzu()
        L_0x017c:
            com.google.android.gms.internal.ads.zzba r9 = r0.zzE
            boolean r9 = r7.equals(r9)
            r0.zzE = r7
            boolean r7 = r3.zzl
            boolean r11 = r1.zzl
            if (r7 == r11) goto L_0x018c
            r11 = 1
            goto L_0x018d
        L_0x018c:
            r11 = 0
        L_0x018d:
            int r7 = r3.zze
            int r12 = r1.zze
            if (r7 == r12) goto L_0x0195
            r12 = 1
            goto L_0x0196
        L_0x0195:
            r12 = 0
        L_0x0196:
            if (r12 != 0) goto L_0x019a
            if (r11 == 0) goto L_0x019d
        L_0x019a:
            r0.zzah()
        L_0x019d:
            boolean r7 = r3.zzg
            boolean r13 = r1.zzg
            if (r7 == r13) goto L_0x01a5
            r13 = 1
            goto L_0x01a6
        L_0x01a5:
            r13 = 0
        L_0x01a6:
            if (r4 != 0) goto L_0x01b5
            com.google.android.gms.internal.ads.zzds r4 = r0.zzl
            com.google.android.gms.internal.ads.zzis r7 = new com.google.android.gms.internal.ads.zzis
            r14 = r35
            r7.<init>(r1, r14)
            r14 = 0
            r4.zzd(r14, r7)
        L_0x01b5:
            if (r2 == 0) goto L_0x02e6
            com.google.android.gms.internal.ads.zzbt r2 = new com.google.android.gms.internal.ads.zzbt
            r2.<init>()
            com.google.android.gms.internal.ads.zzbv r14 = r3.zza
            boolean r14 = r14.zzo()
            if (r14 != 0) goto L_0x01f6
            com.google.android.gms.internal.ads.zzur r14 = r3.zzb
            java.lang.Object r14 = r14.zza
            com.google.android.gms.internal.ads.zzbv r15 = r3.zza
            r15.zzn(r14, r2)
            int r15 = r2.zzc
            com.google.android.gms.internal.ads.zzbv r7 = r3.zza
            int r7 = r7.zza(r14)
            com.google.android.gms.internal.ads.zzbv r4 = r3.zza
            r40 = r7
            com.google.android.gms.internal.ads.zzbu r7 = r0.zza
            r18 = r8
            r19 = r9
            r8 = 0
            com.google.android.gms.internal.ads.zzbu r4 = r4.zze(r15, r7, r8)
            java.lang.Object r4 = r4.zzb
            com.google.android.gms.internal.ads.zzbu r7 = r0.zza
            com.google.android.gms.internal.ads.zzaw r7 = r7.zzd
            r25 = r40
            r21 = r4
            r23 = r7
            r24 = r14
            r22 = r15
            goto L_0x0204
        L_0x01f6:
            r18 = r8
            r19 = r9
            r22 = r40
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x0204:
            if (r5 != 0) goto L_0x022e
            com.google.android.gms.internal.ads.zzur r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x021d
            com.google.android.gms.internal.ads.zzur r4 = r3.zzb
            int r7 = r4.zzb
            int r4 = r4.zzc
            long r7 = r2.zzf(r7, r4)
            long r14 = zzV(r3)
            goto L_0x0240
        L_0x021d:
            com.google.android.gms.internal.ads.zzur r4 = r3.zzb
            int r4 = r4.zze
            r7 = -1
            if (r4 == r7) goto L_0x022b
            com.google.android.gms.internal.ads.zzlg r2 = r0.zzR
            long r7 = zzV(r2)
            goto L_0x023f
        L_0x022b:
            long r7 = r2.zzd
            goto L_0x023f
        L_0x022e:
            com.google.android.gms.internal.ads.zzur r2 = r3.zzb
            boolean r2 = r2.zzb()
            if (r2 == 0) goto L_0x023d
            long r7 = r3.zzs
            long r14 = zzV(r3)
            goto L_0x0240
        L_0x023d:
            long r7 = r3.zzs
        L_0x023f:
            r14 = r7
        L_0x0240:
            com.google.android.gms.internal.ads.zzbn r20 = new com.google.android.gms.internal.ads.zzbn
            int r2 = com.google.android.gms.internal.ads.zzen.zza
            com.google.android.gms.internal.ads.zzur r2 = r3.zzb
            int r4 = r2.zzb
            int r2 = r2.zzc
            long r26 = com.google.android.gms.internal.ads.zzen.zzv(r7)
            long r28 = com.google.android.gms.internal.ads.zzen.zzv(r14)
            r31 = r2
            r30 = r4
            r20.<init>(r21, r22, r23, r24, r25, r26, r28, r30, r31)
            r2 = r20
            int r4 = r0.zzd()
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            com.google.android.gms.internal.ads.zzbv r7 = r7.zza
            boolean r7 = r7.zzo()
            if (r7 != 0) goto L_0x029c
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            com.google.android.gms.internal.ads.zzur r8 = r7.zzb
            java.lang.Object r9 = r8.zza
            com.google.android.gms.internal.ads.zzbv r7 = r7.zza
            com.google.android.gms.internal.ads.zzbt r8 = r0.zzn
            r7.zzn(r9, r8)
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            com.google.android.gms.internal.ads.zzbv r7 = r7.zza
            int r7 = r7.zza(r9)
            com.google.android.gms.internal.ads.zzlg r8 = r0.zzR
            com.google.android.gms.internal.ads.zzbv r8 = r8.zza
            com.google.android.gms.internal.ads.zzbu r14 = r0.zza
            r15 = r11
            r32 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzbu r8 = r8.zze(r4, r14, r11)
            java.lang.Object r8 = r8.zzb
            com.google.android.gms.internal.ads.zzbu r11 = r0.zza
            com.google.android.gms.internal.ads.zzaw r11 = r11.zzd
            r25 = r7
            r21 = r8
            r24 = r9
            r23 = r11
            goto L_0x02a7
        L_0x029c:
            r15 = r11
            r32 = r12
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x02a7:
            long r26 = com.google.android.gms.internal.ads.zzen.zzv(r38)
            com.google.android.gms.internal.ads.zzbn r20 = new com.google.android.gms.internal.ads.zzbn
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            com.google.android.gms.internal.ads.zzur r7 = r7.zzb
            boolean r7 = r7.zzb()
            if (r7 == 0) goto L_0x02c4
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            long r7 = zzV(r7)
            long r7 = com.google.android.gms.internal.ads.zzen.zzv(r7)
            r28 = r7
            goto L_0x02c6
        L_0x02c4:
            r28 = r26
        L_0x02c6:
            com.google.android.gms.internal.ads.zzlg r7 = r0.zzR
            com.google.android.gms.internal.ads.zzur r7 = r7.zzb
            int r8 = r7.zzb
            int r7 = r7.zzc
            r22 = r4
            r31 = r7
            r30 = r8
            r20.<init>(r21, r22, r23, r24, r25, r26, r28, r30, r31)
            r4 = r20
            com.google.android.gms.internal.ads.zzds r7 = r0.zzl
            com.google.android.gms.internal.ads.zzji r8 = new com.google.android.gms.internal.ads.zzji
            r8.<init>(r5, r2, r4)
            r2 = 11
            r7.zzd(r2, r8)
            goto L_0x02ed
        L_0x02e6:
            r18 = r8
            r19 = r9
            r15 = r11
            r32 = r12
        L_0x02ed:
            if (r18 == 0) goto L_0x02fb
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjj r4 = new com.google.android.gms.internal.ads.zzjj
            r4.<init>(r10, r6)
            r5 = 1
            r2.zzd(r5, r4)
            goto L_0x02fc
        L_0x02fb:
            r5 = 1
        L_0x02fc:
            com.google.android.gms.internal.ads.zzig r2 = r3.zzf
            com.google.android.gms.internal.ads.zzig r4 = r1.zzf
            r6 = 10
            if (r2 == r4) goto L_0x031c
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjk r4 = new com.google.android.gms.internal.ads.zzjk
            r4.<init>(r1)
            r2.zzd(r6, r4)
            com.google.android.gms.internal.ads.zzig r2 = r1.zzf
            if (r2 == 0) goto L_0x031c
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjl r4 = new com.google.android.gms.internal.ads.zzjl
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x031c:
            com.google.android.gms.internal.ads.zzyk r2 = r3.zzi
            com.google.android.gms.internal.ads.zzyk r4 = r1.zzi
            if (r2 == r4) goto L_0x0334
            com.google.android.gms.internal.ads.zzyj r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzp(r4)
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjm r4 = new com.google.android.gms.internal.ads.zzjm
            r4.<init>(r1)
            r7 = 2
            r2.zzd(r7, r4)
        L_0x0334:
            if (r19 != 0) goto L_0x0344
            com.google.android.gms.internal.ads.zzba r2 = r0.zzE
            com.google.android.gms.internal.ads.zzds r4 = r0.zzl
            com.google.android.gms.internal.ads.zzit r7 = new com.google.android.gms.internal.ads.zzit
            r7.<init>(r2)
            r2 = 14
            r4.zzd(r2, r7)
        L_0x0344:
            if (r13 == 0) goto L_0x0352
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zziu r4 = new com.google.android.gms.internal.ads.zziu
            r4.<init>(r1)
            r7 = r41
            r2.zzd(r7, r4)
        L_0x0352:
            if (r32 != 0) goto L_0x0356
            if (r15 == 0) goto L_0x0361
        L_0x0356:
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zziv r4 = new com.google.android.gms.internal.ads.zziv
            r4.<init>(r1)
            r7 = -1
            r2.zzd(r7, r4)
        L_0x0361:
            r2 = 4
            if (r32 == 0) goto L_0x036e
            com.google.android.gms.internal.ads.zzds r4 = r0.zzl
            com.google.android.gms.internal.ads.zziw r7 = new com.google.android.gms.internal.ads.zziw
            r7.<init>(r1)
            r4.zzd(r2, r7)
        L_0x036e:
            r4 = 5
            if (r15 != 0) goto L_0x0377
            int r7 = r3.zzm
            int r8 = r1.zzm
            if (r7 == r8) goto L_0x0381
        L_0x0377:
            com.google.android.gms.internal.ads.zzds r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjb r8 = new com.google.android.gms.internal.ads.zzjb
            r8.<init>(r1)
            r7.zzd(r4, r8)
        L_0x0381:
            int r7 = r3.zzn
            int r8 = r1.zzn
            r9 = 6
            if (r7 == r8) goto L_0x0392
            com.google.android.gms.internal.ads.zzds r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjf r8 = new com.google.android.gms.internal.ads.zzjf
            r8.<init>(r1)
            r7.zzd(r9, r8)
        L_0x0392:
            boolean r7 = r3.zzi()
            boolean r8 = r1.zzi()
            r10 = 7
            if (r7 == r8) goto L_0x03a7
            com.google.android.gms.internal.ads.zzds r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjg r8 = new com.google.android.gms.internal.ads.zzjg
            r8.<init>(r1)
            r7.zzd(r10, r8)
        L_0x03a7:
            com.google.android.gms.internal.ads.zzbj r7 = r3.zzo
            com.google.android.gms.internal.ads.zzbj r8 = r1.zzo
            boolean r7 = r7.equals(r8)
            r8 = 12
            if (r7 != 0) goto L_0x03bd
            com.google.android.gms.internal.ads.zzds r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjh r11 = new com.google.android.gms.internal.ads.zzjh
            r11.<init>(r1)
            r7.zzd(r8, r11)
        L_0x03bd:
            com.google.android.gms.internal.ads.zzbl r7 = r0.zzD
            com.google.android.gms.internal.ads.zzbp r11 = r0.zzg
            com.google.android.gms.internal.ads.zzbl r12 = r0.zzc
            int r13 = com.google.android.gms.internal.ads.zzen.zza
            boolean r13 = r11.zzw()
            r14 = r11
            com.google.android.gms.internal.ads.zzi r14 = (com.google.android.gms.internal.ads.zzi) r14
            com.google.android.gms.internal.ads.zzbv r15 = r14.zzn()
            boolean r16 = r15.zzo()
            if (r16 != 0) goto L_0x03ea
            int r5 = r14.zzd()
            com.google.android.gms.internal.ads.zzbu r8 = r14.zza
            r16 = r7
            r6 = 0
            com.google.android.gms.internal.ads.zzbu r5 = r15.zze(r5, r8, r6)
            boolean r5 = r5.zzh
            if (r5 == 0) goto L_0x03ec
            r5 = 1
            goto L_0x03ed
        L_0x03ea:
            r16 = r7
        L_0x03ec:
            r5 = 0
        L_0x03ed:
            com.google.android.gms.internal.ads.zzbv r6 = r14.zzn()
            boolean r7 = r6.zzo()
            if (r7 == 0) goto L_0x03fb
            r6 = 0
            r7 = -1
            r8 = 0
            goto L_0x0410
        L_0x03fb:
            int r7 = r14.zzd()
            r14.zzh()
            r14.zzv()
            r8 = 0
            int r6 = r6.zzk(r7, r8, r8)
            r7 = -1
            if (r6 == r7) goto L_0x040f
            r6 = 1
            goto L_0x0410
        L_0x040f:
            r6 = r8
        L_0x0410:
            com.google.android.gms.internal.ads.zzbv r15 = r14.zzn()
            boolean r17 = r15.zzo()
            if (r17 == 0) goto L_0x041c
        L_0x041a:
            r7 = r8
            goto L_0x042d
        L_0x041c:
            int r10 = r14.zzd()
            r14.zzh()
            r14.zzv()
            int r10 = r15.zzj(r10, r8, r8)
            if (r10 == r7) goto L_0x041a
            r7 = 1
        L_0x042d:
            com.google.android.gms.internal.ads.zzbv r10 = r14.zzn()
            boolean r15 = r10.zzo()
            if (r15 != 0) goto L_0x044d
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzbu r8 = r14.zza
            r40 = r5
            r4 = 0
            com.google.android.gms.internal.ads.zzbu r8 = r10.zze(r15, r8, r4)
            boolean r8 = r8.zzb()
            if (r8 == 0) goto L_0x0451
            r8 = 1
            goto L_0x0452
        L_0x044d:
            r40 = r5
            r4 = 0
        L_0x0451:
            r8 = 0
        L_0x0452:
            com.google.android.gms.internal.ads.zzbv r10 = r14.zzn()
            boolean r15 = r10.zzo()
            if (r15 != 0) goto L_0x046c
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzbu r14 = r14.zza
            com.google.android.gms.internal.ads.zzbu r4 = r10.zze(r15, r14, r4)
            boolean r4 = r4.zzi
            if (r4 == 0) goto L_0x046c
            r4 = 1
            goto L_0x046d
        L_0x046c:
            r4 = 0
        L_0x046d:
            com.google.android.gms.internal.ads.zzbv r5 = r11.zzn()
            boolean r5 = r5.zzo()
            com.google.android.gms.internal.ads.zzbk r10 = new com.google.android.gms.internal.ads.zzbk
            r10.<init>()
            r10.zzb(r12)
            r11 = r13 ^ 1
            r10.zzd(r2, r11)
            if (r40 == 0) goto L_0x0488
            if (r13 != 0) goto L_0x0488
            r2 = 1
            goto L_0x0489
        L_0x0488:
            r2 = 0
        L_0x0489:
            r12 = 5
            r10.zzd(r12, r2)
            if (r6 == 0) goto L_0x0493
            if (r13 != 0) goto L_0x0493
            r2 = 1
            goto L_0x0494
        L_0x0493:
            r2 = 0
        L_0x0494:
            r10.zzd(r9, r2)
            if (r5 != 0) goto L_0x04a3
            if (r6 != 0) goto L_0x049f
            if (r8 == 0) goto L_0x049f
            if (r40 == 0) goto L_0x04a3
        L_0x049f:
            if (r13 != 0) goto L_0x04a3
            r2 = 1
            goto L_0x04a4
        L_0x04a3:
            r2 = 0
        L_0x04a4:
            r6 = 7
            r10.zzd(r6, r2)
            if (r7 == 0) goto L_0x04ae
            if (r13 != 0) goto L_0x04ae
            r2 = 1
            goto L_0x04af
        L_0x04ae:
            r2 = 0
        L_0x04af:
            r6 = 8
            r10.zzd(r6, r2)
            if (r5 != 0) goto L_0x04c0
            if (r7 != 0) goto L_0x04bc
            if (r8 == 0) goto L_0x04c0
            if (r4 == 0) goto L_0x04c0
        L_0x04bc:
            if (r13 != 0) goto L_0x04c0
            r2 = 1
            goto L_0x04c1
        L_0x04c0:
            r2 = 0
        L_0x04c1:
            r4 = 9
            r10.zzd(r4, r2)
            r2 = 10
            r10.zzd(r2, r11)
            if (r40 == 0) goto L_0x04d1
            if (r13 != 0) goto L_0x04d1
            r2 = 1
            goto L_0x04d2
        L_0x04d1:
            r2 = 0
        L_0x04d2:
            r4 = 11
            r10.zzd(r4, r2)
            if (r40 == 0) goto L_0x04df
            if (r13 != 0) goto L_0x04df
            r2 = 12
            r14 = 1
            goto L_0x04e2
        L_0x04df:
            r2 = 12
            r14 = 0
        L_0x04e2:
            r10.zzd(r2, r14)
            com.google.android.gms.internal.ads.zzbl r2 = r10.zze()
            r0.zzD = r2
            r4 = r16
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x04ff
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            com.google.android.gms.internal.ads.zzje r4 = new com.google.android.gms.internal.ads.zzje
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x04ff:
            com.google.android.gms.internal.ads.zzds r2 = r0.zzl
            r2.zzc()
            boolean r2 = r3.zzp
            boolean r1 = r1.zzp
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjv.zzag(com.google.android.gms.internal.ads.zzlg, int, boolean, int, long, int, boolean):void");
    }

    private final void zzah() {
        int zzf2 = zzf();
        if (zzf2 == 2 || zzf2 == 3) {
            zzai();
            boolean z = this.zzR.zzp;
            zzu();
            zzu();
        }
    }

    private final void zzai() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzr.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", new Object[]{Thread.currentThread().getName(), this.zzr.getThread().getName()});
            if (!this.zzN) {
                if (this.zzO) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzdt.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzO = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    public final void zzA(zzlz zzlz) {
        zzai();
        zzlz zzlz2 = zzlz;
        this.zzq.zzR(zzlz);
    }

    public final void zzB(zzut zzut) {
        zzai();
        List singletonList = Collections.singletonList(zzut);
        zzai();
        zzai();
        zzR(this.zzR);
        zzk();
        boolean z = true;
        this.zzy++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzV = this.zzV.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzld zzld = new zzld((zzut) singletonList.get(i2), this.zzp);
            arrayList.add(zzld);
            this.zzo.add(i2, new zzjt(zzld.zzb, zzld.zza));
        }
        this.zzV = this.zzV.zzg(0, arrayList.size());
        zzll zzll = new zzll(this.zzo, this.zzV);
        if (zzll.zzo() || zzll.zzc() >= 0) {
            int zzg2 = zzll.zzg(false);
            zzlg zzY = zzY(this.zzR, zzll, zzX(zzll, zzg2, -9223372036854775807L));
            int i3 = zzY.zze;
            if (!(zzg2 == -1 || i3 == 1)) {
                i3 = 4;
                if (!zzll.zzo() && zzg2 < zzll.zzc()) {
                    i3 = 2;
                }
            }
            zzlg zze2 = zzY.zze(i3);
            this.zzk.zzq(arrayList, zzg2, zzen.zzs(-9223372036854775807L), this.zzV);
            if (this.zzR.zzb.zza.equals(zze2.zzb.zza) || this.zzR.zza.zzo()) {
                z = false;
            }
            zzag(zze2, 0, z, 4, zzU(zze2), -1, false);
            return;
        }
        throw new zzah(zzll, -1, -9223372036854775807L);
    }

    public final zzig zzE() {
        zzai();
        return this.zzR.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(zzke zzke) {
        boolean z;
        int i = this.zzy - zzke.zzb;
        this.zzy = i;
        boolean z2 = true;
        if (zzke.zzc) {
            this.zzz = zzke.zzd;
            this.zzA = true;
        }
        if (i == 0) {
            zzbv zzbv = zzke.zza.zza;
            if (!this.zzR.zza.zzo() && zzbv.zzo()) {
                this.zzS = -1;
                this.zzT = 0;
            }
            if (!zzbv.zzo()) {
                List zzw2 = ((zzll) zzbv).zzw();
                zzdb.zzf(zzw2.size() == this.zzo.size());
                for (int i2 = 0; i2 < zzw2.size(); i2++) {
                    ((zzjt) this.zzo.get(i2)).zzc((zzbv) zzw2.get(i2));
                }
            }
            long j = -9223372036854775807L;
            if (this.zzA) {
                if (zzke.zza.zzb.equals(this.zzR.zzb) && zzke.zza.zzd == this.zzR.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzbv.zzo() || zzke.zza.zzb.zzb()) {
                        j = zzke.zza.zzd;
                    } else {
                        zzlg zzlg = zzke.zza;
                        zzur zzur = zzlg.zzb;
                        long j2 = zzlg.zzd;
                        zzW(zzbv, zzur, j2);
                        j = j2;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            this.zzA = false;
            zzag(zzke.zza, 1, z, this.zzz, j, -1, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(zzke zzke) {
        this.zzj.zzh(new zzja(this, zzke));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP(zzbm zzbm) {
        zzbm.zza(this.zzD);
    }

    public final void zza(int i, long j, int i2, boolean z) {
        zzai();
        if (i != -1) {
            zzdb.zzd(i >= 0);
            zzbv zzbv = this.zzR.zza;
            if (zzbv.zzo() || i < zzbv.zzc()) {
                this.zzq.zzu();
                this.zzy++;
                if (zzw()) {
                    zzdt.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    zzke zzke = new zzke(this.zzR);
                    zzke.zza(1);
                    this.zzU.zza.zzO(zzke);
                    return;
                }
                zzlg zzlg = this.zzR;
                int i3 = zzlg.zze;
                if (i3 == 3 || (i3 == 4 && !zzbv.zzo())) {
                    zzlg = this.zzR.zze(2);
                }
                int zzd2 = zzd();
                zzlg zzY = zzY(zzlg, zzbv, zzX(zzbv, i, j));
                this.zzk.zzl(zzbv, i, zzen.zzs(j));
                zzag(zzY, 0, true, 1, zzU(zzY), zzd2, false);
            }
        }
    }

    public final int zzb() {
        zzai();
        if (zzw()) {
            return this.zzR.zzb.zzb;
        }
        return -1;
    }

    public final int zzc() {
        zzai();
        if (zzw()) {
            return this.zzR.zzb.zzc;
        }
        return -1;
    }

    public final int zzd() {
        zzai();
        int zzR2 = zzR(this.zzR);
        if (zzR2 == -1) {
            return 0;
        }
        return zzR2;
    }

    public final int zze() {
        zzai();
        if (this.zzR.zza.zzo()) {
            return 0;
        }
        zzlg zzlg = this.zzR;
        return zzlg.zza.zza(zzlg.zzb.zza);
    }

    public final int zzf() {
        zzai();
        return this.zzR.zze;
    }

    public final int zzg() {
        zzai();
        return this.zzR.zzn;
    }

    public final int zzh() {
        zzai();
        return 0;
    }

    public final long zzi() {
        zzai();
        if (zzw()) {
            zzlg zzlg = this.zzR;
            if (zzlg.zzk.equals(zzlg.zzb)) {
                return zzen.zzv(this.zzR.zzq);
            }
            return zzl();
        }
        zzai();
        if (this.zzR.zza.zzo()) {
            return this.zzT;
        }
        zzlg zzlg2 = this.zzR;
        long j = 0;
        if (zzlg2.zzk.zzd != zzlg2.zzb.zzd) {
            return zzen.zzv(zzlg2.zza.zze(zzd(), this.zza, 0).zzm);
        }
        long j2 = zzlg2.zzq;
        if (this.zzR.zzk.zzb()) {
            zzlg zzlg3 = this.zzR;
            zzlg3.zza.zzn(zzlg3.zzk.zza, this.zzn).zzg(this.zzR.zzk.zzb);
        } else {
            j = j2;
        }
        zzlg zzlg4 = this.zzR;
        zzW(zzlg4.zza, zzlg4.zzk, j);
        return zzen.zzv(j);
    }

    public final long zzj() {
        zzai();
        return zzT(this.zzR);
    }

    public final long zzk() {
        zzai();
        return zzen.zzv(zzU(this.zzR));
    }

    public final long zzl() {
        zzai();
        if (!zzw()) {
            zzbv zzn2 = zzn();
            if (zzn2.zzo()) {
                return -9223372036854775807L;
            }
            return zzen.zzv(zzn2.zze(zzd(), this.zza, 0).zzm);
        }
        zzlg zzlg = this.zzR;
        zzur zzur = zzlg.zzb;
        zzlg.zza.zzn(zzur.zza, this.zzn);
        return zzen.zzv(this.zzn.zzf(zzur.zzb, zzur.zzc));
    }

    public final long zzm() {
        zzai();
        return zzen.zzv(this.zzR.zzr);
    }

    public final zzbv zzn() {
        zzai();
        return this.zzR.zza;
    }

    public final zzcd zzo() {
        zzai();
        return this.zzR.zzi.zzd;
    }

    public final void zzp() {
        zzai();
        zzhv zzhv = this.zzw;
        boolean zzu2 = zzu();
        int i = 2;
        zzhv.zzb(zzu2, 2);
        zzaf(zzu2, 1, zzS(1));
        zzlg zzlg = this.zzR;
        if (zzlg.zze == 1) {
            zzlg zzd2 = zzlg.zzd((zzig) null);
            if (true == zzd2.zza.zzo()) {
                i = 4;
            }
            zzlg zze2 = zzd2.zze(i);
            this.zzy++;
            this.zzk.zzk();
            zzag(zze2, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void zzq(boolean z) {
        zzai();
        this.zzw.zzb(z, zzf());
        zzaf(z, 1, zzS(1));
    }

    public final void zzr(Surface surface) {
        zzai();
        zzad(surface);
        int i = surface == null ? 0 : -1;
        zzaa(i, i);
    }

    public final void zzs(float f) {
        zzai();
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzL != max) {
            this.zzL = max;
            zzac();
            zzds zzds = this.zzl;
            zzds.zzd(22, new zzix(max));
            zzds.zzc();
        }
    }

    public final void zzt() {
        zzai();
        this.zzw.zzb(zzu(), 1);
        zzae((zzig) null);
        int i = zzcu.zza;
        zzfzo zzn2 = zzfzo.zzn();
        long j = this.zzR.zzs;
        zzfzo.zzl(zzn2);
    }

    public final boolean zzu() {
        zzai();
        return this.zzR.zzl;
    }

    public final boolean zzv() {
        zzai();
        return false;
    }

    public final boolean zzw() {
        zzai();
        return this.zzR.zzb.zzb();
    }

    public final int zzx() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    public final void zzy(zzlz zzlz) {
        zzlz zzlz2 = zzlz;
        this.zzq.zzt(zzlz);
    }

    public final void zzz() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzen.zze;
        String zza = zzax.zza();
        zzdt.zze("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.5.0-alpha01] [" + str + "] [" + zza + "]");
        zzai();
        this.zzw.zzd();
        if (!this.zzk.zzp()) {
            zzds zzds = this.zzl;
            zzds.zzd(10, new zziz());
            zzds.zzc();
        }
        this.zzl.zze();
        this.zzj.zze((Object) null);
        this.zzs.zzg(this.zzq);
        boolean z = this.zzR.zzp;
        zzlg zze2 = this.zzR.zze(1);
        this.zzR = zze2;
        zzlg zza2 = zze2.zza(zze2.zzb);
        this.zzR = zza2;
        zza2.zzq = zza2.zzs;
        this.zzR.zzr = 0;
        this.zzq.zzQ();
        this.zzi.zzj();
        Surface surface = this.zzG;
        if (surface != null) {
            surface.release();
            this.zzG = null;
        }
        int i = zzcu.zza;
    }
}
