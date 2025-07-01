package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbiw implements zzbjr {
    zzbiw() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcfk zzcfk = (zzcfk) obj;
        zzbfm zzK = zzcfk.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcfk.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcfk.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
