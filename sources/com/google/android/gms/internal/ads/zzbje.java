package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbje implements zzbjr {
    zzbje() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfwa.zzc("true", str)) {
                if (!zzfwa.zzc("false", str)) {
                    return;
                }
            }
            zzfti.zza(zzcfk.getContext()).zzb(Boolean.parseBoolean(str));
        } catch (IOException e) {
            zzv.zzp().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
