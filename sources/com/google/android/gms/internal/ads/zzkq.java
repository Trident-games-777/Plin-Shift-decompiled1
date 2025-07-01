package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzkq {
    public final zzup zza;
    public final Object zzb;
    public final zzwg[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzkr zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlq[] zzi;
    private final zzyj zzj;
    private final zzlf zzk;
    private zzkq zzl;
    private zzwr zzm = zzwr.zza;
    private zzyk zzn;
    private long zzo;

    public zzkq(zzlq[] zzlqArr, long j, zzyj zzyj, zzys zzys, zzlf zzlf, zzkr zzkr, zzyk zzyk) {
        this.zzi = zzlqArr;
        this.zzo = j;
        this.zzj = zzyj;
        this.zzk = zzlf;
        this.zzb = zzkr.zza.zza;
        this.zzf = zzkr;
        this.zzn = zzyk;
        this.zzc = new zzwg[2];
        this.zzh = new boolean[2];
        zzur zzur = zzkr.zza;
        long j2 = zzkr.zzb;
        long j3 = zzkr.zzd;
        zzup zzp = zzlf.zzp(zzur, zzys, j2);
        this.zza = j3 != -9223372036854775807L ? new zztv(zzp, true, 0, j3) : zzp;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzyk zzyk = this.zzn;
                if (i < zzyk.zza) {
                    zzyk.zzb(i);
                    zzyd zzyd = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzyk zzyk = this.zzn;
                if (i < zzyk.zza) {
                    zzyk.zzb(i);
                    zzyd zzyd = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzyk zzyk, long j, boolean z) {
        return zzb(zzyk, j, false, new boolean[2]);
    }

    public final long zzb(zzyk zzyk, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzyk.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzyk.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlq[] zzlqArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzlqArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzyk;
        zzt();
        long zzf2 = this.zza.zzf(zzyk.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzlq[] zzlqArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzlqArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzwg[] zzwgArr = this.zzc;
            if (i4 >= 2) {
                return zzf2;
            }
            if (zzwgArr[i4] != null) {
                zzdb.zzf(zzyk.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzdb.zzf(zzyk.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long zzb2 = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return zzb2 == Long.MIN_VALUE ? this.zzf.zze : zzb2;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzkq zzg() {
        return this.zzl;
    }

    public final zzwr zzh() {
        return this.zzm;
    }

    public final zzyk zzi() {
        return this.zzn;
    }

    public final zzyk zzj(float f, zzbv zzbv) throws zzig {
        zzyk zzo2 = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzbv);
        for (int i = 0; i < zzo2.zza; i++) {
            boolean z = true;
            if (zzo2.zzb(i)) {
                if (zzo2.zzc[i] == null) {
                    this.zzi[i].zzb();
                    z = false;
                }
                zzdb.zzf(z);
            } else {
                if (zzo2.zzc[i] != null) {
                    z = false;
                }
                zzdb.zzf(z);
            }
        }
        for (zzyd zzyd : zzo2.zzc) {
        }
        return zzo2;
    }

    public final void zzk(long j, float f, long j2) {
        zzdb.zzf(zzu());
        long j3 = j - this.zzo;
        zzkm zzkm = new zzkm();
        zzkm.zze(j3);
        zzkm.zzf(f);
        zzkm.zzd(j2);
        this.zza.zzo(new zzko(zzkm, (zzkn) null));
    }

    public final void zzl(float f, zzbv zzbv) throws zzig {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzyk zzj2 = zzj(f, zzbv);
        zzkr zzkr = this.zzf;
        long j = zzkr.zzb;
        long j2 = zzkr.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zza2 = zza(zzj2, j, false);
        long j3 = this.zzo;
        zzkr zzkr2 = this.zzf;
        this.zzo = j3 + (zzkr2.zzb - zza2);
        this.zzf = zzkr2.zzb(zza2);
    }

    public final void zzm(long j) {
        zzdb.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzup zzup = this.zza;
        try {
            boolean z = zzup instanceof zztv;
            zzlf zzlf = this.zzk;
            if (z) {
                zzlf.zzi(((zztv) zzup).zza);
            } else {
                zzlf.zzi(zzup);
            }
        } catch (RuntimeException e) {
            zzdt.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzkq zzkq) {
        if (zzkq != this.zzl) {
            zzs();
            this.zzl = zzkq;
            zzt();
        }
    }

    public final void zzp(long j) {
        this.zzo = j;
    }

    public final void zzq() {
        zzup zzup = this.zza;
        if (zzup instanceof zztv) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zztv) zzup).zzn(0, j);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}
