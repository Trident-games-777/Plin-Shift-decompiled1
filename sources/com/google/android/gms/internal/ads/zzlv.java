package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzlv implements zzkp {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzbj zzd = zzbj.zza;

    public zzlv(zzdc zzdc) {
    }

    public final long zza() {
        long zza2;
        long j = this.zzb;
        if (!this.zza) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzbj zzbj = this.zzd;
        if (zzbj.zzb == 1.0f) {
            zza2 = zzen.zzs(elapsedRealtime);
        } else {
            zza2 = zzbj.zza(elapsedRealtime);
        }
        return j + zza2;
    }

    public final void zzb(long j) {
        this.zzb = j;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final zzbj zzc() {
        return this.zzd;
    }

    public final void zzd() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zze() {
        if (this.zza) {
            zzb(zza());
            this.zza = false;
        }
    }

    public final void zzg(zzbj zzbj) {
        if (this.zza) {
            zzb(zza());
        }
        this.zzd = zzbj;
    }

    public final /* synthetic */ boolean zzj() {
        return false;
    }
}
