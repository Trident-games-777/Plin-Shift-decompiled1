package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;
import java.util.function.Consumer;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdd implements zzbjr {
    private final Consumer zza;

    public zzcdd(Consumer consumer) {
        this.zza = consumer;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzccf zzccf = (zzccf) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzm.zzj("Action missing from video GMSG.");
        } else if (str.equals("src")) {
            String str2 = (String) map.get("src");
            if (str2 == null) {
                zzm.zzj("src missing from video GMSG.");
            } else {
                this.zza.accept(str2);
            }
        }
    }
}
