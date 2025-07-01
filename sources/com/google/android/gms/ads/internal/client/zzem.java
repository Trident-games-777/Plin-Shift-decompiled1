package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzem implements InitializationStatus {
    public final /* synthetic */ zzex zza;

    public /* synthetic */ zzem(zzex zzex) {
        this.zza = zzex;
    }

    public final Map getAdapterStatusMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzet(this.zza));
        return hashMap;
    }
}
