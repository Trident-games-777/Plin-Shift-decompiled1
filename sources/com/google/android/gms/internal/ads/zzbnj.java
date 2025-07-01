package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbnj implements zzcas {
    final /* synthetic */ zzbnt zza;
    final /* synthetic */ zzfka zzb;
    final /* synthetic */ zzbnu zzc;

    zzbnj(zzbnu zzbnu, zzbnt zzbnt, zzfka zzfka) {
        this.zza = zzbnt;
        this.zzb = zzfka;
        this.zzc = zzbnu;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbmp zzbmp = (zzbmp) obj;
        zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            this.zzc.zzi = 0;
            zzbnu zzbnu = this.zzc;
            if (!(zzbnu.zzh == null || this.zza == zzbnu.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbeg.zzd.zze()).booleanValue()) {
                zzbnu zzbnu2 = this.zzc;
                if (zzbnu2.zze != null) {
                    zzfko zze = zzbnu2.zze;
                    zzfka zzfka = this.zzb;
                    zzfka.zzg(true);
                    zze.zzb(zzfka.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
