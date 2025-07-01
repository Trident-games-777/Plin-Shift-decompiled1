package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzced implements zzkl {
    private final zzys zza = new zzys(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    zzced() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    public final long zzb(zzoj zzoj) {
        return 0;
    }

    public final void zzc(zzoj zzoj) {
        zza(false);
    }

    public final void zzd(zzoj zzoj) {
        zza(true);
    }

    public final void zze(zzoj zzoj) {
        zza(true);
    }

    public final void zzf(zzoj zzoj, zzbv zzbv, zzur zzur, zzln[] zzlnArr, zzwr zzwr, zzyd[] zzydArr) {
        int i = 0;
        this.zzf = 0;
        while (true) {
            int length = zzlnArr.length;
            if (i < 2) {
                if (zzydArr[i] != null) {
                    this.zzf += zzlnArr[i].zzb() != 1 ? 131072000 : 13107200;
                }
                i++;
            } else {
                this.zza.zzf(this.zzf);
                return;
            }
        }
    }

    public final boolean zzg(zzoj zzoj) {
        return false;
    }

    public final boolean zzh(zzkk zzkk) {
        long j = zzkk.zzb;
        boolean z = true;
        boolean z2 = j > this.zzc ? false : j < this.zzb ? true : true;
        int zza2 = this.zza.zza();
        int i = this.zzf;
        if (!z2 && (!z2 || !this.zzg || zza2 >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    public final boolean zzi(zzkk zzkk) {
        long j = zzkk.zzd ? this.zze : this.zzd;
        return j <= 0 || zzkk.zzb >= j;
    }

    public final zzys zzj() {
        return this.zza;
    }

    public final synchronized void zzk(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzb = ((long) i) * 1000;
    }
}
