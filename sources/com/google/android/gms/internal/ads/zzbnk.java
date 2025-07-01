package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbnk implements zzcaq {
    final /* synthetic */ zzbnt zza;
    final /* synthetic */ zzfka zzb;
    final /* synthetic */ zzbnu zzc;

    zzbnk(zzbnu zzbnu, zzbnt zzbnt, zzfka zzfka) {
        this.zza = zzbnt;
        this.zzb = zzfka;
        this.zzc = zzbnu;
    }

    public final void zza() {
        zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbeg.zzd.zze()).booleanValue()) {
                zzbnu zzbnu = this.zzc;
                if (zzbnu.zze != null) {
                    zzfko zze = zzbnu.zze;
                    zzfka zzfka = this.zzb;
                    zzfka.zzc("Failed loading new engine");
                    zzfka.zzg(false);
                    zze.zzb(zzfka.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
