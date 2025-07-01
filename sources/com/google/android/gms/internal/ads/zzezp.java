package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzci;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzezp implements Callable {
    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzbe.zzc().zza(zzbcn.zzT);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzbe.zzc().zza(zzbcn.zzU)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzci.zza(str2));
                }
            }
        }
        return new zzezr(hashMap);
    }
}
