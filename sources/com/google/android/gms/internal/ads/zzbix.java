package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbix implements zzbjr {
    zzbix() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcfk zzcfk = (zzcfk) obj;
        zzbfm zzK = zzcfk.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzcfk.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcfk.zze("nativeClickMetaReady", zzb);
        }
    }
}
