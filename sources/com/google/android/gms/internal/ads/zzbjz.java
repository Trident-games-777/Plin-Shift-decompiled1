package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjz implements zzgee {
    final /* synthetic */ Map zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbkd zzd;

    zzbjz(zzbkd zzbkd, Map map, zza zza2, String str) {
        this.zza = map;
        this.zzb = zza2;
        this.zzc = str;
        this.zzd = zzbkd;
    }

    public final void zza(Throwable th) {
        zzv.zzp().zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjJ)).booleanValue()) {
            this.zza.put("u", str);
        }
        this.zzd.zzh(str, this.zzb, this.zza, this.zzc);
    }
}
