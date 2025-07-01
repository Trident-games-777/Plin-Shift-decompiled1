package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzffx implements zzbjr {
    public final /* synthetic */ zzflr zza;
    public final /* synthetic */ zzedp zzb;

    public /* synthetic */ zzffx(zzflr zzflr, zzedp zzedp) {
        this.zza = zzflr;
        this.zzb = zzedp;
    }

    public final void zza(Object obj, Map map) {
        zzcfb zzcfb = (zzcfb) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzcfb.zzD().zzai) {
            this.zza.zzc(str, (zzfkl) null);
        } else {
            this.zzb.zzd(new zzedr(zzv.zzC().currentTimeMillis(), ((zzcgn) zzcfb).zzR().zzb, str, 2));
        }
    }
}
