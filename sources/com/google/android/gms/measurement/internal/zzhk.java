package com.google.android.gms.measurement.internal;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
public final /* synthetic */ class zzhk implements Callable {
    private /* synthetic */ zzhl zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzhk(zzhl zzhl, String str) {
        this.zza = zzhl;
        this.zzb = str;
    }

    public final Object call() {
        zzhl zzhl = this.zza;
        String str = this.zzb;
        zzg zze = zzhl.zzh().zze(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("package_name", str);
        hashMap.put("gmp_version", 106000L);
        if (zze != null) {
            String zzaf = zze.zzaf();
            if (zzaf != null) {
                hashMap.put("app_version", zzaf);
            }
            hashMap.put("app_version_int", Long.valueOf(zze.zze()));
            hashMap.put("dynamite_version", Long.valueOf(zze.zzo()));
        }
        return hashMap;
    }
}
