package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfay implements zzenh {
    final /* synthetic */ zzfaz zza;

    zzfay(zzfaz zzfaz) {
        this.zza = zzfaz;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcox zzcox = (zzcox) obj;
        synchronized (this.zza) {
            zzcox zzcox2 = this.zza.zza;
            if (zzcox2 != null) {
                zzcox2.zzb();
            }
            zzfaz zzfaz = this.zza;
            zzfaz.zza = zzcox;
            zzcox.zzc(zzfaz);
            zzfaz zzfaz2 = this.zza;
            zzfaz2.zzg.zzk(new zzcoy(zzcox, zzfaz2, zzfaz2.zzg, zzfaz2.zzi));
            zzcox.zzk();
        }
    }
}
