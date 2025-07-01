package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbip implements zzbjr {
    public final /* synthetic */ zzdel zza;
    public final /* synthetic */ zzcnb zzb;

    public /* synthetic */ zzbip(zzdel zzdel, zzcnb zzcnb) {
        this.zza = zzdel;
        this.zzb = zzcnb;
    }

    public final void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        zzbjq.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzgei.zzr((zzgdz) zzgei.zzn(zzgdz.zzu(zzbjq.zza(zzcfk, str)), new zzbir(this.zzb, str), zzcaj.zza), new zzbjf(zzcfk), zzcaj.zza);
    }
}
