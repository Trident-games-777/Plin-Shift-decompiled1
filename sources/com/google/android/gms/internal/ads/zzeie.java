package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzeie implements zzgee {
    final /* synthetic */ zzfet zza;
    final /* synthetic */ zzeif zzb;

    zzeie(zzeif zzeif, zzfet zzfet) {
        this.zza = zzfet;
        this.zzb = zzeif;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            zzfet zza2 = this.zzb.zzh.zza();
            if (this.zza.zzav) {
                while (zza2 != null) {
                    this.zzb.zze(zza2);
                    zza2 = this.zzb.zzh.zza();
                }
            } else if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeiw zzeiw = (zzeiw) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzeiw, this.zza);
            zzfet zza2 = this.zzb.zzh.zza();
            if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }
}
