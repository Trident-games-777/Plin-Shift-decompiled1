package com.google.android.gms.internal.ads;

import coil3.disk.DiskLruCache;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdmu implements zzaym {
    public final /* synthetic */ zzcfk zza;

    public /* synthetic */ zzdmu(zzcfk zzcfk) {
        this.zza = zzcfk;
    }

    public final void zzdp(zzayl zzayl) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != zzayl.zzj) {
            str = "0";
        } else {
            str = DiskLruCache.VERSION;
        }
        hashMap.put("isVisible", str);
        this.zza.zzd("onAdVisibilityChanged", hashMap);
    }
}
