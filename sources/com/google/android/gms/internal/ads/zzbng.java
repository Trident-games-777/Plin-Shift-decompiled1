package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbng implements zzbjr {
    final /* synthetic */ zzbmp zza;
    final /* synthetic */ zzbx zzb;
    final /* synthetic */ zzbnu zzc;

    zzbng(zzbnu zzbnu, zzavc zzavc, zzbmp zzbmp, zzbx zzbx) {
        this.zza = zzbmp;
        this.zzb = zzbx;
        this.zzc = zzbnu;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbnv zzbnv = (zzbnv) obj;
        zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            zzm.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zzm.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzavc) null);
            }
            this.zza.zzr("/requestReload", (zzbjr) this.zzb.zza());
        }
        zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
