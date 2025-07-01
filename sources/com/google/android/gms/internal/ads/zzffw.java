package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzffw implements zzbjr {
    public final /* synthetic */ zzdel zza;
    public final /* synthetic */ zzcnb zzb;
    public final /* synthetic */ zzflr zzc;
    public final /* synthetic */ zzedp zzd;

    public /* synthetic */ zzffw(zzdel zzdel, zzcnb zzcnb, zzflr zzflr, zzedp zzedp) {
        this.zza = zzdel;
        this.zzb = zzcnb;
        this.zzc = zzflr;
        this.zzd = zzedp;
    }

    public final void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        zzbjq.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzedp zzedp = this.zzd;
        zzflr zzflr = this.zzc;
        zzgei.zzr(zzbjq.zza(zzcfk, str), new zzffy(zzcfk, this.zzb, zzflr, zzedp), zzcaj.zza);
    }
}
