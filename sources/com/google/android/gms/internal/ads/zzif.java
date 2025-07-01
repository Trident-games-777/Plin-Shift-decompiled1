package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzif implements zzkp {
    private final zzlv zza;
    private final zzie zzb;
    private zzln zzc;
    private zzkp zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzif(zzie zzie, zzdc zzdc) {
        this.zzb = zzie;
        this.zza = new zzlv(zzdc);
    }

    public final long zza() {
        if (this.zze) {
            return this.zza.zza();
        }
        zzkp zzkp = this.zzd;
        zzkp.getClass();
        zzkp zzkp2 = zzkp;
        return zzkp.zza();
    }

    public final long zzb(boolean z) {
        zzln zzln = this.zzc;
        if (zzln == null || zzln.zzW() || ((z && this.zzc.zzcV() != 2) || (!this.zzc.zzX() && (z || this.zzc.zzQ())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzkp zzkp = this.zzd;
            zzkp.getClass();
            zzkp zzkp2 = zzkp;
            long zza2 = zzkp.zza();
            if (this.zze) {
                if (zza2 < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza2);
            zzbj zzc2 = zzkp.zzc();
            if (!zzc2.equals(this.zza.zzc())) {
                this.zza.zzg(zzc2);
                this.zzb.zza(zzc2);
            }
        }
        return zza();
    }

    public final zzbj zzc() {
        zzkp zzkp = this.zzd;
        return zzkp != null ? zzkp.zzc() : this.zza.zzc();
    }

    public final void zzd(zzln zzln) {
        if (zzln == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzln zzln) throws zzig {
        zzkp zzkp;
        zzkp zzl = zzln.zzl();
        if (zzl != null && zzl != (zzkp = this.zzd)) {
            if (zzkp == null) {
                this.zzd = zzl;
                this.zzc = zzln;
                zzl.zzg(this.zza.zzc());
                return;
            }
            throw zzig.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    public final void zzg(zzbj zzbj) {
        zzkp zzkp = this.zzd;
        if (zzkp != null) {
            zzkp.zzg(zzbj);
            zzbj = this.zzd.zzc();
        }
        this.zza.zzg(zzbj);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzkp zzkp = this.zzd;
        zzkp.getClass();
        zzkp zzkp2 = zzkp;
        return zzkp.zzj();
    }
}
