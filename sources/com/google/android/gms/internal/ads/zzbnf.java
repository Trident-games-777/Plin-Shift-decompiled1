package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbnf implements zzbjr {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbnt zzb;
    final /* synthetic */ zzbmp zzc;
    final /* synthetic */ zzbnu zzd;

    zzbnf(zzbnu zzbnu, long j, zzbnt zzbnt, zzbmp zzbmp) {
        this.zza = j;
        this.zzb = zzbnt;
        this.zzc = zzbmp;
        this.zzd = zzbnu;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbnv zzbnv = (zzbnv) obj;
        long currentTimeMillis = zzv.zzC().currentTimeMillis() - this.zza;
        zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + currentTimeMillis + " ms.");
        zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1) {
                if (this.zzb.zze() != 1) {
                    this.zzd.zzi = 0;
                    zzbmp zzbmp = this.zzc;
                    zzbmp zzbmp2 = zzbmp;
                    zzbmp.zzq("/log", zzbjq.zzg);
                    zzbmp.zzq("/result", zzbjq.zzo);
                    this.zzb.zzi(this.zzc);
                    this.zzd.zzh = this.zzb;
                    zze.zza("Successfully loaded JS Engine.");
                    zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
