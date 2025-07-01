package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzhw implements zzln, zzlq {
    private final Object zza = new Object();
    private final int zzb;
    private final zzkj zzc;
    private zzlr zzd;
    private int zze;
    private zzoj zzf;
    private zzdc zzg;
    private int zzh;
    private zzwg zzi;
    private zzad[] zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private zzbv zzp;
    private zzlp zzq;

    public zzhw(int i) {
        this.zzb = i;
        this.zzc = new zzkj();
        this.zzm = Long.MIN_VALUE;
        this.zzp = zzbv.zza;
    }

    private final void zzZ(long j, boolean z) throws zzig {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    /* access modifiers changed from: protected */
    public void zzA() {
    }

    /* access modifiers changed from: protected */
    public final void zzB() {
        zzlp zzlp;
        synchronized (this.zza) {
            zzlp = this.zzq;
        }
        if (zzlp != null) {
            zzlp.zza(this);
        }
    }

    /* access modifiers changed from: protected */
    public void zzC() {
    }

    /* access modifiers changed from: protected */
    public void zzD() throws zzig {
    }

    /* access modifiers changed from: protected */
    public void zzE() {
    }

    /* access modifiers changed from: protected */
    public void zzF(zzad[] zzadArr, long j, long j2, zzur zzur) throws zzig {
    }

    public final void zzG() {
        zzdb.zzf(this.zzh == 0);
        zzA();
    }

    public final void zzH(zzad[] zzadArr, zzwg zzwg, long j, long j2, zzur zzur) throws zzig {
        zzdb.zzf(!this.zzn);
        this.zzi = zzwg;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzadArr;
        this.zzk = j2;
        zzF(zzadArr, j, j2, zzur);
    }

    public final void zzI() {
        zzdb.zzf(this.zzh == 0);
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        zzC();
    }

    public final void zzJ(long j) throws zzig {
        zzZ(j, false);
    }

    public final void zzK() {
        this.zzn = true;
    }

    public final void zzL(zzlp zzlp) {
        synchronized (this.zza) {
            this.zzq = zzlp;
        }
    }

    public /* synthetic */ void zzM(float f, float f2) {
    }

    public final void zzN(zzbv zzbv) {
        if (!Objects.equals(this.zzp, zzbv)) {
            this.zzp = zzbv;
        }
    }

    public final void zzO() throws zzig {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzdb.zzf(z);
        this.zzh = 2;
        zzD();
    }

    public final void zzP() {
        zzdb.zzf(this.zzh == 2);
        this.zzh = 1;
        zzE();
    }

    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    public final boolean zzR() {
        return this.zzn;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzcV() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final int zzcW(zzkj zzkj, zzhm zzhm, int i) {
        zzwg zzwg = this.zzi;
        zzwg.getClass();
        zzwg zzwg2 = zzwg;
        int zza2 = zzwg.zza(zzkj, zzhm, i);
        if (zza2 != -4) {
            if (zza2 == -5) {
                zzad zzad = zzkj.zza;
                zzad.getClass();
                zzad zzad2 = zzad;
                long j = zzad.zzt;
                if (j != Long.MAX_VALUE) {
                    zzab zzb2 = zzad.zzb();
                    zzb2.zzad(j + this.zzk);
                    zzkj.zza = zzb2.zzaf();
                    return -5;
                }
            }
            return zza2;
        } else if (zzhm.zzf()) {
            this.zzm = Long.MIN_VALUE;
            return this.zzn ? -4 : -3;
        } else {
            long j2 = zzhm.zze + this.zzk;
            zzhm.zze = j2;
            this.zzm = Math.max(this.zzm, j2);
            return zza2;
        }
    }

    public final long zzcX() {
        return this.zzm;
    }

    /* access modifiers changed from: protected */
    public final zzig zzcY(Throwable th, zzad zzad, boolean z, int i) {
        int i2 = 4;
        if (zzad != null && !this.zzo) {
            this.zzo = true;
            try {
                i2 = zzY(zzad) & 7;
                this.zzo = false;
            } catch (zzig unused) {
                this.zzo = false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                this.zzo = false;
                throw th3;
            }
        }
        return zzig.zzb(th, zzU(), this.zze, zzad, i2, z, i);
    }

    public int zze() throws zzig {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzf() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final zzbv zzh() {
        return this.zzp;
    }

    /* access modifiers changed from: protected */
    public final zzkj zzk() {
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        return zzkj;
    }

    public zzkp zzl() {
        return null;
    }

    public final zzlq zzm() {
        return this;
    }

    public final zzwg zzp() {
        return this.zzi;
    }

    public final void zzq() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    public final void zzr() {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzdb.zzf(z);
        zzkj zzkj = this.zzc;
        zzkj.zzb = null;
        zzkj.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzx();
    }

    public final void zzs(zzlr zzlr, zzad[] zzadArr, zzwg zzwg, long j, boolean z, boolean z2, long j2, long j3, zzur zzur) throws zzig {
        zzdb.zzf(this.zzh == 0);
        this.zzd = zzlr;
        this.zzh = 1;
        zzy(z, z2);
        long j4 = j2;
        zzH(zzadArr, zzwg, j4, j3, zzur);
        zzZ(j4, z);
    }

    public /* synthetic */ void zzt() {
    }

    public void zzu(int i, Object obj) throws zzig {
    }

    public final void zzv(int i, zzoj zzoj, zzdc zzdc) {
        this.zze = i;
        this.zzf = zzoj;
        this.zzg = zzdc;
    }

    /* access modifiers changed from: protected */
    public void zzx() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzy(boolean z, boolean z2) throws zzig {
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zzig {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzwg zzwg = this.zzi;
        zzwg.getClass();
        zzwg zzwg2 = zzwg;
        return zzwg.zze();
    }

    /* access modifiers changed from: protected */
    public final zzad[] zzT() {
        zzad[] zzadArr = this.zzj;
        zzadArr.getClass();
        return zzadArr;
    }

    /* access modifiers changed from: protected */
    public final int zzd(long j) {
        zzwg zzwg = this.zzi;
        zzwg.getClass();
        zzwg zzwg2 = zzwg;
        return zzwg.zzb(j - this.zzk);
    }

    /* access modifiers changed from: protected */
    public final zzdc zzi() {
        zzdc zzdc = this.zzg;
        zzdc.getClass();
        zzdc zzdc2 = zzdc;
        return zzdc;
    }

    /* access modifiers changed from: protected */
    public final zzlr zzn() {
        zzlr zzlr = this.zzd;
        zzlr.getClass();
        zzlr zzlr2 = zzlr;
        return zzlr;
    }

    /* access modifiers changed from: protected */
    public final zzoj zzo() {
        zzoj zzoj = this.zzf;
        zzoj.getClass();
        zzoj zzoj2 = zzoj;
        return zzoj;
    }

    public final void zzw() throws IOException {
        zzwg zzwg = this.zzi;
        zzwg.getClass();
        zzwg zzwg2 = zzwg;
        zzwg.zzd();
    }
}
