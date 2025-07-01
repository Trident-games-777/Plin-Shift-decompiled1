package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbiu implements zzbjr {
    public final void zza(Object obj, Map map) {
        zzcgr zzcgr = (zzcgr) obj;
        zzbjr zzbjr = zzbjq.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzbv(zzcgr.getContext(), ((zzcgy) zzcgr).zzn().afmaVersion, str).zzb();
        }
    }
}
