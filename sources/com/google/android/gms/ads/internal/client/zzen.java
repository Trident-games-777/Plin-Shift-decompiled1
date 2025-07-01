package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdFormat;
import java.util.Set;
import java.util.function.BiFunction;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzen implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        AdFormat adFormat = (AdFormat) obj;
        Integer num = (Integer) obj2;
        Set set = zzex.zza;
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        return Integer.valueOf(i);
    }
}
